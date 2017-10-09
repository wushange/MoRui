package cn.connxun.morui.ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.connxun.morui.R;
import cn.connxun.morui.data.local.TaskStroge;
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
    @Inject
    TaskStroge taskStroge;
    @BindView(R.id.btn_clear_tasks)
    Button     btnClearTasks;
    Unbinder unbinder1;

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
        btnClearTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOperation.showBasicDialog("清空缓存将删除所有任务（包含已经检查的任务结果）？", (dialog, which) -> {
                    mOperation.showProgress("删除中...");
                    taskStroge.deleteAllTasks();
                    mOperation.dissMissDialog();
                    mOperation.showToast("删除成功！");
                    
                });


            }
        });
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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder1.unbind();
    }
}
