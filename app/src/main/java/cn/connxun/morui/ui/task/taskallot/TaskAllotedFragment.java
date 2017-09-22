package cn.connxun.morui.ui.task.taskallot;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.facebook.stetho.common.LogUtil;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import butterknife.BindView;
import cn.connxun.morui.R;
import cn.connxun.morui.api.TaskApi;
import cn.connxun.morui.data.local.TaskStroge;
import cn.connxun.morui.data.local.UserStorge;
import cn.connxun.morui.di.component.FragmentComponent;
import cn.connxun.morui.ui.base.BaseEvents;
import cn.connxun.morui.ui.base.BaseFragmentV4;
import jp.wasabeef.recyclerview.animators.ScaleInBottomAnimator;

/**
 * Created by wushange on 2017/9/5.
 */

public class TaskAllotedFragment extends BaseFragmentV4  {
    public static TaskAllotedFragment newInstance() {
        TaskAllotedFragment fragment = new TaskAllotedFragment();
        return fragment;
    }

    @BindView(R.id.rl_task_allot)
    RecyclerView recyclerView;
    @Inject
    TaskAllotAdapter adapter;
    @Inject
    TaskApi          api;
    @Inject
    UserStorge       userStorge;
    @Inject
    TaskStroge       taskStroge;

    @Override
    public int bindLayout() {
        return R.layout.fragment_task_alloted;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void initView(View view) {
        EventBus.getDefault().register(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new SpaceDecoration(20));
        recyclerView.setItemAnimator(new ScaleInBottomAnimator());
        adapter.bindToRecyclerView(recyclerView);
        adapter.setEmptyView(R.layout.view_empty);
        adapter.openLoadAnimation();
        adapter.isFirstOnly(false);
        adapter.setUpFetchEnable(true);

    }

    @Override
    public void doBusiness(Context mContext) {

        LogUtil.e("已分配咧白哦" + taskStroge.getAllTask_Alloted());
        adapter.addData(taskStroge.getAllTask_Alloted());
    }

    @Override
    public void lazyInitBusiness(Context mContext) {
    }

    @Override
    public void initInjector() {
        getComponent(FragmentComponent.class).inject(this);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Subscribe
    public void update(BaseEvents.CommonEvent commonEvent){
        if(commonEvent.equals(BaseEvents.CommonEvent.UPDATE_ALLOTED_LIST)){
            adapter.replaceData(taskStroge.getAllTask_Alloted());
        }
    }
}
