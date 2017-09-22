package cn.connxun.morui.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.view.View;

import butterknife.BindView;
import cn.connxun.morui.R;
import cn.connxun.morui.di.HasComponent;
import cn.connxun.morui.di.component.DaggerFragmentComponent;
import cn.connxun.morui.di.component.FragmentComponent;
import cn.connxun.morui.ui.base.BaseActivity;
import cn.connxun.morui.ui.base.ViewPagerAdapter;
import cn.connxun.morui.ui.home.HomeFragment;
import cn.connxun.morui.ui.setting.SettingFragment;
import cn.connxun.morui.utils.StatusBarUtil;
import cn.connxun.morui.widget.MyViewPager;


/**
 * 首页
 */
public class MainActivity extends BaseActivity implements HasComponent<FragmentComponent> {

    @BindView(R.id.tablayout)
    TabLayout   tablayout;
    @BindView(R.id.viewpager)
    MyViewPager viewpager;
    private ViewPagerAdapter adapter;
    private FragmentComponent    mMainComponent;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initParms(Bundle parms) {
    }

    @Override
    public void initView(View view) {
        StatusBarUtil.setTransparentPadding(this);
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        tablayout.setSelectedTabIndicatorHeight(0);
        ViewCompat.setElevation(tablayout, 10);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(HomeFragment.newInstance(), "首页");
        adapter.addFragment(SettingFragment.newInstance(), "设置");
        viewpager.setOffscreenPageLimit(3);
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
    public FragmentComponent getFragmentComponent() {
        return mMainComponent;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
