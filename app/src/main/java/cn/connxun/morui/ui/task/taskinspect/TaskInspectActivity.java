package cn.connxun.morui.ui.task.taskinspect;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;

import com.jude.easyrecyclerview.EasyRecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import cn.connxun.morui.R;
import cn.connxun.morui.constants.enums.TASK_STATUS;
import cn.connxun.morui.db.TaskDao;
import cn.connxun.morui.entity.Task;
import cn.connxun.morui.ui.base.BaseEvents;
import cn.connxun.morui.ui.base.BaseSwipeBackActivity;
import cn.connxun.morui.ui.task.taskdetails.TaskDetailsActivity;
import cn.connxun.morui.ui.task.tasktag.TaskTagactivity;

/**
 * 巡检任务
 * Created by wushange on 2017/7/19.
 */

public class TaskInspectActivity extends BaseSwipeBackActivity implements TaskInspectContract.TaskInsView {
    @BindView(R.id.easy_recyclerview)
    EasyRecyclerView     erlTaskIns;
    @Inject
    TaskInspectPresenter presenter;
    @Inject
    TaskInspectAdapter   adapter;
    @BindView(R.id.btn_sync)
    Button               btnSync;
    @Inject
    TaskDao              taskDao;

    @Override
    public int bindLayout() {
        return R.layout.activity_task_inspect;
    }

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public void initView(View view) {
        presenter.attachView(this);
        presenter.getOfflineTaskList();
        erlTaskIns.setLayoutManager(new LinearLayoutManager(this));
        erlTaskIns.setAdapterWithProgress(adapter);
        adapter.setOnItemButtonClickListener((pos,v, data) -> {
            switch (v.getId()) {
                case R.id.btn_task_goback:
                    presenter.gobackTask(data,pos);
                    break;
                case R.id.btn_task_configm:
                    presenter.confirmTask(data,pos);
                    break;
                case R.id.btn_taskoper:
                    if (data.getCheckStatus() == TASK_STATUS.NOCHECK.value()) {
                        data.setCheckStatus(TASK_STATUS.CHECKING.value());
                        taskDao.update(data);
                        adapter.notifyDataSetChanged();
                        TaskTagactivity.callMe(getContext(), data.getId());
                    } else if (data.getCheckStatus() == TASK_STATUS.CHECKING.value()) {
                        TaskTagactivity.callMe(getContext(), data.getId());
                    } else if (data.getCheckStatus() == TASK_STATUS.CHECKDONE.value()) {
                        TaskDetailsActivity.callMe(getContext(), data.getId());
                    }
                    break;
            }


        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void doBusiness(Context mContext) {
        btnSync.setOnClickListener(v -> {
            btnSync.setText("正在同步");
            btnSync.setEnabled(false);
            presenter.syncTaskList();
        });

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
        dissmissDialog();
    }

    @Override
    public void onError(String error) {
        Toast(error);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void showLoadingView(String string) {
        mOperation.showNotCancelWithContent(string);
    }

    @Override
    public void showList(List<Task> list) {
        mOperation.dissMissDialog();
        erlTaskIns.setVisibility(View.VISIBLE);
        btnSync.setVisibility(View.GONE);
        if (list.size() == 0) {
            erlTaskIns.showEmpty();
            return;
        }
        adapter.addAll(list);
    }

    @Override
    public void showOfflineList(List<Task> list) {
        mOperation.dissMissDialog();
        if (list.size() == 0) {
            erlTaskIns.setVisibility(View.GONE);
            btnSync.setVisibility(View.VISIBLE);
            return;
        }
        adapter.clear();
        adapter.addAll(list);
    }

    @Override
    public void confirmTaskSuccess(Task task, int pos) {
        adapter.update(task, pos);
        Toast("确认成功");
    }

    @Override
    public void gobackTaskSuccess(Task task, int pos) {
        adapter.update(task, pos);
        Toast("撤回成功");
    }


    @Subscribe
    public void update(BaseEvents.CommonEvent ac) {
        if (ac.equals(BaseEvents.CommonEvent.UPDATE_LIST)) {
            presenter.getOfflineTaskList();
        }

    }
}
