package cn.connxun.morui.ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.connxun.morui.R;
import cn.connxun.morui.data.local.UserStorge;
import cn.connxun.morui.di.component.FragmentComponent;
import cn.connxun.morui.ui.base.BaseFragmentV4;
import cn.connxun.morui.ui.login.LoginActivity;
import cn.connxun.morui.utils.ActivityManager;

/**
 * Created by wushange on 2017/7/19.
 */

public class SettingFragment extends BaseFragmentV4 {
    @BindView(R.id.btn_safe_exit)
    Button btnSafeExit;
    Unbinder unbinder;

    @Inject
    UserStorge userStorge;

    @OnClick(R.id.btn_safe_exit)
    public void onViewClicked() {
        mOperation.showBasicDialog("安全退出应用？", (dialog, which) -> {
            userStorge.logout();
            ActivityManager.getActivityManager().finishAllActivity();
            mOperation.forward(LoginActivity.class);

        });


    }

    public static SettingFragment newInstance() {
        SettingFragment fragment = new SettingFragment();
        return fragment;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void initView(View view) {
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void lazyInitBusiness(Context mContext) {

    }

    @Override
    public void initInjector() {
        getComponent(FragmentComponent.class).inject(this);
    }


}
