package cn.connxun.morui.ui.task.taskchange;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jude.easyrecyclerview.EasyRecyclerView;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import cn.connxun.morui.R;
import cn.connxun.morui.entity.InspectionRectification;
import cn.connxun.morui.ui.base.BaseEvents;
import cn.connxun.morui.ui.base.BaseSwipeBackActivity;

/**
 *
 *
 * 有问题
 * 巡检记录
 * Created by wushange on 2017/7/19.
 */

public class TaskChangeActivity extends BaseSwipeBackActivity implements TaskChangeContract.TaskChangeView {
    @BindView(R.id.ireasy_recyclerview)
    EasyRecyclerView    erlInsRecord;
    @Inject
    TaskChangePresenter presenter;
    @Inject
    TaskChangeAdapter   adapter;
    @Override
    public int bindLayout() {
        return R.layout.activity_task_change;
    }

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public void initView(View view) {
        presenter.attachView(this);

        erlInsRecord.setLayoutManager(new LinearLayoutManager(this));
        erlInsRecord.setAdapterWithProgress(adapter);
        adapter.setOnItemButtonClickListener((v, da) -> {
            TaskChangeDetailActivity.callMe(getContext(),da);
        });
    }

    @Override
    public void doBusiness(Context mContext) {
        presenter.getTaskChangeList();

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
        Toast(error);
    }

    @Override
    public void showList(List<InspectionRectification> list) {
        adapter.clear();
        adapter.addAll(list);
    }


    @Override
    public void changSuccess() {

    }

    @Override
    public String getTaskCId() {
        return null;
    }

    @Override
    public InspectionRectification getInspectionRectification() {
        return null;
    }
    @Subscribe
    public void update(BaseEvents.CommonEvent commonEvent){
        if(commonEvent.equals(BaseEvents.CommonEvent.UPDATE_CHANGELIST)){
            presenter.getTaskChangeList();
        }
    }
}
