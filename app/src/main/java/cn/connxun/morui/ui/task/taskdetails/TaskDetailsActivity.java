package cn.connxun.morui.ui.task.taskdetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import cn.connxun.morui.R;
import cn.connxun.morui.entity.Task;
import cn.connxun.morui.entity.TaskSub;
import cn.connxun.morui.ui.base.BaseSwipeBackActivity;

/**
 * 任务详情
 * Created by wushange on 2017/7/24.
 */

public class TaskDetailsActivity extends BaseSwipeBackActivity implements TaskDetailsContract.TaskDetailsView {
    private static final String TASK_ID_DETAIL_BAEN = "TASK_ID_DETAIL";

    public static void callMe(Context context, Task task) {
        Intent intent = new Intent(context, TaskDetailsActivity.class);
        intent.putExtra(TASK_ID_DETAIL_BAEN, task);
        context.startActivity(intent);
    }

    @BindView(R.id.erl_task_details)
    EasyRecyclerView     recyclerView;
    @Inject
    TaskDetailsPresenter presenter;
    @Inject
    TaskDetailsAdapter   adapter;

    Task mTask;

    @Override
    public int bindLayout() {
        return R.layout.activity_task_details;
    }

    @Override
    public void initParms(Bundle parms) {
        mTask = (Task) parms.get(TASK_ID_DETAIL_BAEN);

    }

    @Override
    public void initView(View view) {
        presenter.attachView(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SpaceDecoration spaceDecoration = new SpaceDecoration(30);
        spaceDecoration.setPaddingEdgeSide(false);
        recyclerView.addItemDecoration(spaceDecoration);
        recyclerView.setAdapter(adapter);

    }


    @Override
    public void doBusiness(Context mContext) {
        presenter.getList();
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
    public String taskId() {
        return mTask.getId();
    }

    @Override
    public void showList(List<TaskSub> list) {
        if (list.size() <= 0) {
            adapter.addAll(mTask.getTaskSubList());
        } else {
            adapter.addAll(list);
        }

    }

    @Override
    public void onError(String error) {
        Toast(error);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
