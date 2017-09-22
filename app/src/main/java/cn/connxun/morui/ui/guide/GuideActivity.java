package cn.connxun.morui.ui.guide;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.just.library.AgentWeb;

import butterknife.BindView;
import cn.connxun.morui.R;
import cn.connxun.morui.ui.base.BaseSwipeBackActivity;
import cn.connxun.morui.widget.AppTitle;

/**
 * 巡检记录
 * Created by wushange on 2017/7/19.
 */

public class GuideActivity extends BaseSwipeBackActivity {
    @BindView(R.id.weblayout)
    FrameLayout weblayout;

    @BindView(R.id.app_title_id)
    AppTitle appTitle;
    @Override
    public int bindLayout() {
        return R.layout.activity_guide;
    }

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public void initView(View view) {
        AgentWeb mAgentWeb = AgentWeb.with(this)//传入Activity
                .setAgentWebParent(weblayout, new FrameLayout.LayoutParams(-1, -1))//传入AgentWeb 的父控件 ，如果父控件为 RelativeLayout ， 那么第二参数需要传入 RelativeLayout.LayoutParams
                .useDefaultIndicator()// 使用默认进度条
                .defaultProgressBarColor() // 使用默认进度条颜色
                .setReceivedTitleCallback((view1, title) -> appTitle.setTitle(title)) //设置 Web 页面的 title 回调
                .createAgentWeb()//
                .ready()
                .go("https://www.freelinebuild.com/");

    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void initInjector() {
    }

}
