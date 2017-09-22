package cn.connxun.morui.data.local;

import android.content.Context;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import cn.connxun.morui.components.rxjava.RxUtil;
import cn.connxun.morui.constants.enums.TASKSUB_CHECK_STATUS;
import cn.connxun.morui.constants.enums.TASK_STATUS;
import cn.connxun.morui.db.TaskDao;
import cn.connxun.morui.db.TaskSubDao;
import cn.connxun.morui.db.Task_AllotDao;
import cn.connxun.morui.entity.Task;
import cn.connxun.morui.entity.TaskSub;
import cn.connxun.morui.entity.Task_Allot;

/**
 * Created by wushange on 2017/8/19.
 */

public class TaskStroge {

    private Context       context;
    private TaskDao       taskDao;
    private TaskSubDao    taskSubDao;
    private Task_AllotDao task_allotDao;
    private UserStorge    userStorge;

    public TaskStroge(Context context, TaskDao taskDao, TaskSubDao taskSubDao, Task_AllotDao task_allotDao, UserStorge userStorge) {
        this.context = context;
        this.taskDao = taskDao;
        this.taskSubDao = taskSubDao;
        this.task_allotDao = task_allotDao;
        this.userStorge = userStorge;
    }

    /**
     * 保存所有task到db
     *
     * @param tasks
     */
    public void saveAllTask(List<Task> tasks) {
        RxUtil.runOnIoThreadTask().subscribe(o -> {
            for (Task allotTask : tasks) {
                allotTask.setUserId(userStorge.getUserId());
                if (taskDao.queryBuilder().where(TaskDao.Properties.Id.eq(allotTask.getId())).unique() == null) {
                    taskDao.insertOrReplaceInTx(allotTask);
                }
                for (TaskSub ab : allotTask.getTaskSubList()) {
                    ab.setTagValue(ab.getTagValue().toLowerCase());
                    if (taskSubDao.queryBuilder().where(TaskSubDao.Properties.Id.eq(ab.getId())).unique() == null) {
                        taskSubDao.insertOrReplaceInTx(ab);
                    }

                }

            }
        });

    }

    /**
     * 获取所有本地任务 并检查每条任务的完成度
     *
     * @return
     */
    public List<Task> getAllTask_OffLine() {
        List<Task> allotTasks = taskDao._queryUser_TaskList(userStorge.getUserId());
        RxUtil.runOnIoThreadTask().subscribe(o -> {
            for (Task a : allotTasks) {
                List<TaskSub> allList = taskSubDao._queryTask_TaskSubList(a.getId());
                List<TaskSub> doneList = taskSubDao.queryBuilder().where(
                        TaskSubDao.Properties.CheckStatus.eq(TASKSUB_CHECK_STATUS.CHECKDONE.value())
                        , TaskSubDao.Properties.TaskId.eq(a.getId())).list();
                Logger.e("总任务数:" + allList.size() + "--完成任务数量：" + doneList.size());
                if (doneList.size() == allList.size()) {
                    a.setCheckStatus(TASK_STATUS.CHECKDONE.value());
                }
            }
        });

        return allotTasks;
    }

    /**
     * 获取所有未同步任务
     * <p>
     * 并且
     *
     * @return
     */
    public List<Task> getAllTask_NoSyncList() {
        List<Task> tasks = new ArrayList<>();
        List<Task> allotTasks = taskDao._queryUser_TaskList(userStorge.getUserId());
        RxUtil.runOnIoThreadTask().subscribe(o -> {
            for (Task a : allotTasks) {
                List<TaskSub> allList = taskSubDao._queryTask_TaskSubList(a.getId());
                List<TaskSub> doneList = taskSubDao.queryBuilder().where(
                        TaskSubDao.Properties.CheckStatus.eq(TASKSUB_CHECK_STATUS.CHECKDONE.value())
                        , TaskSubDao.Properties.TaskId.eq(a.getId())).list();
                Logger.e("总任务数:" + allList.size() + "--完成任务数量：" + doneList.size());
                if (doneList.size() == allList.size()) {
                    tasks.add(a);
                }
            }
        });

        return tasks;
    }

    public void saveAllAllotTask(List<Task_Allot> tasks) {
        RxUtil.runOnIoThreadTask().subscribe(o -> {
            for (Task_Allot task : tasks) {
                task.setUserId(userStorge.getUserId());
            }
            task_allotDao.insertOrReplaceInTx(tasks);
        });

    }

    public List<Task_Allot> getAllTask_Alloted() {
        return task_allotDao.queryBuilder().where(Task_AllotDao.Properties.Status.eq(TASK_STATUS.ALLOT_ALREADY.value()),
                Task_AllotDao.Properties.UserId.eq(userStorge.getUserId())).list();
    }

    public List<Task_Allot> getAllTask_NoAllot() {
        return task_allotDao.queryBuilder().where(Task_AllotDao.Properties.Status.eq(TASK_STATUS.ALLOT_NONE.value()),
                Task_AllotDao.Properties.UserId.eq(userStorge.getUserId())).list();

    }

    public void updateAllTaskAllots(List<Task_Allot> tasks) {
        task_allotDao.updateInTx(tasks);
    }

    public void updateAllTasks(List<Task> tasks) {
        taskDao.updateInTx(tasks);
    }

    /**
     * 删除计划任务
     *
     * @param allotTasks
     */
    public void deleteTasks(List<Task> allotTasks) {
        RxUtil.runOnIoThreadTask().subscribe(o -> {
            for (Task a : allotTasks) {
                taskSubDao.deleteInTx(a.getTaskSubList());
            }
            taskDao.deleteInTx();
        });

    }
}
