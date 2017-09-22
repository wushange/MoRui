package cn.connxun.morui.ui.task.taskallot;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import butterknife.BindView;
import cn.connxun.morui.R;
import cn.connxun.morui.di.HasComponent;
import cn.connxun.morui.di.component.DaggerFragmentComponent;
import cn.connxun.morui.di.component.FragmentComponent;
import cn.connxun.morui.ui.base.BaseSwipeBackActivity;


/**
 * 任务分配
 * Created by wushange on 2017/7/19.
 */

public class TaskAllotActivity extends BaseSwipeBackActivity implements HasComponent<FragmentComponent> {
    @BindView(R.id.task_allot_tab)
    TabLayout tablayout;
    @BindView(R.id.vp_task_allot)
    ViewPager viewpager;
    ViewPagerAdapter adapter;
    private FragmentComponent mMainComponent;


    @Override
    public int bindLayout() {
        return R.layout.activity_task_allot;
    }

    @Override
    public void initParms(Bundle parms) {
    }

    @Override
    public void initView(View view) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(TaskAllotFragment.newInstance(), "未分配");
        adapter.addFragment(TaskAllotedFragment.newInstance(), "已分配");
        viewpager.setOffscreenPageLimit(2);
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void initInjector() {
        mMainComponent = DaggerFragmentComponent.builder()
                .applicationComponent(getApplicationComponent())
                .build();
        mMainComponent.inject(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public FragmentComponent getFragmentComponent() {
        return mMainComponent;
    }

}
