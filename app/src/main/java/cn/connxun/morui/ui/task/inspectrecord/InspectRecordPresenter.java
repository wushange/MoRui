package cn.connxun.morui.ui.task.inspectrecord;

import java.util.List;

import javax.inject.Inject;

import cn.connxun.morui.data.local.TaskStroge;
import cn.connxun.morui.di.PerActivity;
import cn.connxun.morui.entity.Task;
import cn.connxun.morui.ui.base.BasePresenter;

/**
 * Created by wanglj on 16/7/4.
 */


@PerActivity
public class InspectRecordPresenter extends BasePresenter<InspectRecordContract.InsRecordView> implements InspectRecordContract.InsRecordPresenter {


    TaskStroge taskStroge;

    @Inject
    public InspectRecordPresenter(TaskStroge taskStroge) {
        this.taskStroge = taskStroge;
    }

    @Override
    public void getTaskList() {
        List<Task> taskList = taskStroge.getAllTask_NoSyncList();

        mView.showList(taskList);

    }
}
