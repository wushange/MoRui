package cn.connxun.morui.ui.task.taskdetails;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import cn.connxun.morui.db.TaskSubDao;
import cn.connxun.morui.di.PerActivity;
import cn.connxun.morui.entity.TaskSub;
import cn.connxun.morui.ui.base.BasePresenter;

/**
 * Created by wanglj on 16/7/4.
 */


@PerActivity
public class TaskDetailsPresenter extends BasePresenter<TaskDetailsContract.TaskDetailsView> implements TaskDetailsContract.TaskDetailsPresenter {


    TaskSubDao allotTaskSubListBeanDao;

    @Inject
    public TaskDetailsPresenter(TaskSubDao allotTaskSubListBeanDao) {
        this.allotTaskSubListBeanDao = allotTaskSubListBeanDao;
    }

    @Override
    public void getList() {
        List<TaskSub> listBeen = new ArrayList<>();
        listBeen = allotTaskSubListBeanDao._queryTask_TaskSubList(mView.taskId());
        mView.showList(listBeen);
    }
}
