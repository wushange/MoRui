package cn.connxun.morui.ui.notice;

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
import cn.connxun.morui.ui.base.ViewPagerAdapter;

/**
 * 巡检记录
 * Created by wushange on 2017/7/19.
 */

public class NoticeActivity extends BaseSwipeBackActivity implements HasComponent<FragmentComponent> {

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private ViewPagerAdapter adapter;
    private FragmentComponent  mNoticeComponent;

    @Override
    public int bindLayout() {
        return R.layout.activity_notice;
    }

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public void initView(View view) {
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(NoticeFragment.newInstance(1), "报警");
        adapter.addFragment(NoticeFragment.newInstance(2), "系统");
        adapter.addFragment(NoticeFragment.newInstance(3), "命令");
        viewpager.setOffscreenPageLimit(4);
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
    }

    @Override
    public void doBusiness(Context mContext) {
    }

    @Override
    public void initInjector() {

        mNoticeComponent = DaggerFragmentComponent.builder()
                .applicationComponent(getApplicationComponent())
                .build();

        mNoticeComponent.inject(this);
    }

    @Override
    public FragmentComponent getFragmentComponent() {
        return mNoticeComponent;
    }
}
