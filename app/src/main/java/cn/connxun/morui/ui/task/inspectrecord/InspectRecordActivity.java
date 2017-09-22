package cn.connxun.morui.ui.task.inspectrecord;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jude.easyrecyclerview.EasyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import cn.connxun.morui.R;
import cn.connxun.morui.entity.Task;
import cn.connxun.morui.ui.base.BaseSwipeBackActivity;
import cn.connxun.morui.ui.task.taskdetails.TaskDetailsActivity;

/**
 *
 *
 * 有问题
 * 巡检记录
 * Created by wushange on 2017/7/19.
 */

public class InspectRecordActivity extends BaseSwipeBackActivity implements InspectRecordContract.InsRecordView {
    @BindView(R.id.ireasy_recyclerview)
    EasyRecyclerView       erlInsRecord;
    @Inject
    InspectRecordPresenter presenter;
    @Inject
    InspectRecordAdapter   adapter;
    List<Task> taskList = new ArrayList<>();
    @Override
    public int bindLayout() {
        return R.layout.activity_inspect_record;
    }

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public void initView(View view) {
        presenter.attachView(this);
        presenter.getTaskList();
        erlInsRecord.setLayoutManager(new LinearLayoutManager(this));
        erlInsRecord.setAdapter(adapter);
        adapter.setOnItemButtonClickListener((v, da) -> {
            TaskDetailsActivity.callMe(getContext(),da.getId());
        });
    }

    @Override
    public void doBusiness(Context mContext) {


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
    public void showList(List<Task> list) {
        taskList = list;
        adapter.addAll(taskList);
    }
}
