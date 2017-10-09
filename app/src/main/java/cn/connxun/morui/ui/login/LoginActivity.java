package cn.connxun.morui.ui.login;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.blankj.utilcode.util.SPUtils;
import com.facebook.stetho.common.LogUtil;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnLongClick;
import cn.connxun.morui.R;
import cn.connxun.morui.constants.Constants;
import cn.connxun.morui.entity.User;
import cn.connxun.morui.ui.base.BaseSwipeBackActivity;
import cn.connxun.morui.ui.main.MainActivity;
import cn.connxun.morui.utils.ActivityManager;
import cn.connxun.morui.utils.AnimatorUtil;
import cn.connxun.morui.utils.StatusBarUtil;

/**
 * Created by wushange on 2017/7/12.
 */

public class LoginActivity extends BaseSwipeBackActivity implements LoginContract.LoginView {
    @Inject
    LoginPresenter loginPresenter;
    @BindView(R.id.head_logo)
    ImageView      headLogo;
    @BindView(R.id.login_btn)
    Button         loginBtn;
    @BindView(R.id.input_name)
    EditText       inputName;
    @BindView(R.id.input_pwd)
    EditText       inputPwd;

    @Override
    public int bindLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initParms(Bundle parms) {
    }

    @Override
    public void initView(View view) {
        StatusBarUtil.setTransparentPadding(this);
        StatusBarUtil.setStatusBarTextColor(this, true);
        setTouchDissIm(true);
        AnimatorUtil.addGlobaLayoutListener(view, headLogo);
        
        inputName.setText(SPUtils.getInstance().getString(Constants.USER_NAME,""));
        inputPwd.setText(SPUtils.getInstance().getString(Constants.USER_PWD,""));
        
        
    }

    @Override
    public void doBusiness(Context mContext) {
        loginPresenter.attachView(this);
        loginBtn.setOnClickListener(v -> loginPresenter.login());
    }

    @Override
    public void initInjector() {
        getComponent().inject(this);
    }

    @Override
    public void startLoading() {
        mOperation.showProgress("正在登录...", false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.detachView();
    }

    @Override
    public void endLoading() {
        dissmissDialog();
    }

    @Override
    public void onError(String error) {
        Toast(error);
    }

    @Override
    public String getUserName() {
        return inputName.getText().toString();
    }

    @Override
    public String getUserPassWord() {
        return inputPwd.getText().toString();
    }

    @Override
    public void loginSuccess(User token) {
        mOperation.forwardAndFinish(MainActivity.class, LEFT_RIGHT);
    }

    @OnLongClick(R.id.login_btn)
    public boolean setAppHost(View v) {

        LogUtil.e("----get--->>" + SPUtils.getInstance().getString(Constants.HOSTKEY, Constants.HOST));
        new MaterialDialog.Builder(this)
                .title("选择网络环境")
                .items("内网", "外网", "自定义")
                .itemsCallbackSingleChoice(SPUtils.getInstance().getInt(Constants.HOSTKEY_POS, 0), (dialog, view, which, text) -> {
                    SPUtils.getInstance().put(Constants.HOSTKEY_POS, which);
                    switch (which) {
                        case 0: {
                            String host = String.format(getString(R.string.host_string), Constants.SERVER_IP_LOCAL, Constants.SERVER_PORT_LOCAL);
                            SPUtils.getInstance().put(Constants.HOSTKEY, host);
                            LogUtil.e("---" + host + "----get--->>" + SPUtils.getInstance().getString(Constants.HOSTKEY, Constants.HOST));
                            reApp();
                            break;
                        }
                        case 1: {
                            String host = String.format(getString(R.string.host_string), Constants.SERVER_IP, Constants.SERVER_PORT);
                            SPUtils.getInstance().put(Constants.HOSTKEY, host);
                            LogUtil.e("---" + host + "----get--->>" + SPUtils.getInstance().getString(Constants.HOSTKEY, Constants.HOST));
                            reApp();
                            break;
                        }
                        case 2: {
                            mOperation.showInputDialog("输入host地址",
                                    "更改应用host地址点击确定生效",
                                    "输入有效IP地址",
                                    SPUtils.getInstance().getString(Constants.HOSTKEY, Constants.HOST),
                                    "确定",
                                    "取消",
                                    (dialog1, input) -> {
                                        SPUtils.getInstance().put(Constants.HOSTKEY, input.toString());
                                        reApp();

                                    });
                            break;
                        }
                    }
                    return true;
                })
                .positiveText("选择")
                .show();

//        mOperation.showInputDialog("输入host地址",
//                "更改应用host地址点击确定生效",
//                "输入有效IP地址",
//                SPUtils.getInstance().getString(Constants.HOSTKEY, Constants.HOST),
//                "确定",
//                "取消",
//                (dialog, input) -> {
//                    SPUtils.getInstance().put(Constants.HOSTKEY, input.toString());
//                    mOperation.showBasicDialog("重启生效", "现在重启?", (dialog1, which) -> ActivityManager.getActivityManager().appExit(getContext()));
//
//                });
        return true;
    }

    private void reApp() {
        mOperation.showBasicDialog("重启生效", "现在重启?", (dialog1, which1) -> {

            ActivityManager.getActivityManager().appExit(getContext());

        });
    }
}
