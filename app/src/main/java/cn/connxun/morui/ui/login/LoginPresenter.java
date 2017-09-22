package cn.connxun.morui.ui.login;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.StringUtils;

import javax.inject.Inject;

import cn.connxun.morui.api.TokenApi;
import cn.connxun.morui.components.retrofit.RequestHelper;
import cn.connxun.morui.data.local.UserStorge;
import cn.connxun.morui.di.PerActivity;
import cn.connxun.morui.entity.User;
import cn.connxun.morui.ui.base.BasePresenter;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by wanglj on 16/7/4.
 */


@PerActivity
public class LoginPresenter extends BasePresenter<LoginContract.LoginView> implements LoginContract.LoginPresenter {

    private TokenApi   tokenApi;
    private UserStorge userStorge;

    @Inject
    public LoginPresenter(TokenApi tokenApi, UserStorge userStorge, RequestHelper requestHelper) {
        this.tokenApi = tokenApi;
        this.userStorge = userStorge;
    }

    @Override
    public void login() {
        String userName = mView.getUserName();
        String userPwd  = mView.getUserPassWord();
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(userPwd)) {
            mView.endLoading();
            mView.onError("用户名密码不能为空请检查！");
            return;
        }
        if (!NetworkUtils.isConnected()) {
            LogUtils.e("offline mode");
            mView.startLoading();
            User user = userStorge.getOfflineUser(userName, userPwd);
            if (user != null) {
                mView.endLoading();
                mView.loginSuccess(user);
                userStorge.login(user);
            } else {
                mView.endLoading();
                mView.onError("系统不能核实你的身份！");
            }

            return;
        }
        tokenApi.getToken(userName, userPwd).subscribe(new Observer<User>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mView.startLoading();
                mDisposable.add(d);
            }

            @Override
            public void onNext(@NonNull User user) {
                LogUtils.e("---" + user.toString());
                user.setRealPwd(userPwd);
                userStorge.login(user);
                mView.loginSuccess(user);
                mView.endLoading();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                mView.onError(e.getMessage());
                mView.endLoading();
            }

            @Override
            public void onComplete() {
                mView.endLoading();
            }
        });

    }
}
