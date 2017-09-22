package cn.connxun.morui.ui.splash;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import cn.connxun.morui.R;
import cn.connxun.morui.data.local.UserStorge;
import cn.connxun.morui.entity.User;
import cn.connxun.morui.ui.base.BaseActivity;
import cn.connxun.morui.ui.login.LoginActivity;
import cn.connxun.morui.ui.login.LoginContract;
import cn.connxun.morui.ui.login.LoginPresenter;
import cn.connxun.morui.ui.main.MainActivity;
import cn.connxun.morui.utils.StatusBarUtil;
import cn.connxun.morui.widget.GradientView;
import io.reactivex.Observable;

/**
 * Created by wushange on 2017/7/12.
 */

public class SplashActivity extends BaseActivity implements LoginContract.LoginView {

    @BindView(R.id.gv_view)
    GradientView gvView;

    @Inject
    LoginPresenter presenter;
    @Inject
    UserStorge     userStorge;
    User user;

    @Override
    public int bindLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void initParms(Bundle parms) {
    }

    @Override
    public void initView(View view) {
        presenter.attachView(this);
        StatusBarUtil.setTransparentPadding(this);
        StatusBarUtil.setStatusBarTextColor(this, true);
        gvView.start();
    }

    @Override
    public void doBusiness(Context mContext) {

        Observable.timer(2, TimeUnit.SECONDS).subscribe(aLong -> {
            user = userStorge.getUser();
//            if (user != null) {
//                presenter.login();
//            } else {
                mOperation.forwardAndFinish(LoginActivity.class, LEFT_RIGHT);
//            }
        });
    }

    @Override
    public void initInjector() {
        getComponent().inject(this);
    }

    @Override
    public void startLoading() {

    }

    @Override
    public void endLoading() {

    }

    @Override
    public void onError(String error) {

    }

    @Override
    public String getUserName() {
        return user.getUsername();
    }

    @Override
    public String getUserPassWord() {
        return user.getRealPwd();
    }

    @Override
    public void loginSuccess(User token) {
        mOperation.forwardAndFinish(MainActivity.class, LEFT_RIGHT);
    }
}
