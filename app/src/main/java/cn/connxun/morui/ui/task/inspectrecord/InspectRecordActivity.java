package cn.connxun.morui.ui.task.inspectrecord;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jude.easyrecyclerview.EasyRecyclerView;

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

        erlInsRecord.setLayoutManager(new LinearLayoutManager(this));
        erlInsRecord.setAdapterWithProgress(adapter);
        adapter.setOnItemButtonClickListener((v, da) -> {
            TaskDetailsActivity.callMe(getContext(),da);
        });
    }

    @Override
    public void doBusiness(Context mContext) {
        presenter.getTaskList();

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
        adapter.clear();
        adapter.addAll(list);
    }
}
