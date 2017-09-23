package cn.connxun.morui.data.local;

import android.content.Context;

import com.blankj.utilcode.util.TimeUtils;
import com.orhanobut.logger.Logger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import cn.connxun.morui.constants.enums.TASKSUB_CHECK_STATUS;
import cn.connxun.morui.constants.enums.TASK_STATUS;
import cn.connxun.morui.db.TaskDao;
import cn.connxun.morui.db.TaskSubDao;
import cn.connxun.morui.db.Task_AllotDao;
import cn.connxun.morui.entity.Task;
import cn.connxun.morui.entity.TaskSub;
import cn.connxun.morui.entity.Task_Allot;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

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
    public Observable<Boolean> saveAllTask(List<Task> tasks) {
        return Observable.create((ObservableOnSubscribe<Boolean>) e -> {
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
            e.onNext(true);
        }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());

    }

    /**
     * 获取所有本地任务 并检查每条任务的完成度
     *
     * @return
     */
    public Observable<List<Task>> getAllTask_OffLine() {

        return Observable.create((ObservableOnSubscribe<List<Task>>) e -> {
            List<Task> allotTasks = taskDao._queryUser_TaskList(userStorge.getUserId());
            for (Task data : allotTasks) {
                long endTime = TimeUtils.string2Millis(data.getEndDate(), new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()));
                long nowTime = TimeUtils.getNowMills();
                if (endTime < nowTime) {
                    data.setCheckStatus(TASK_STATUS.CHECKDONE.value());
                    data.setStatus(TASK_STATUS.CHECK_MISS.value());
                }
                List<TaskSub> allList = taskSubDao._queryTask_TaskSubList(data.getId());
                List<TaskSub> doneList = taskSubDao.queryBuilder().where(
                        TaskSubDao.Properties.CheckStatus.eq(TASKSUB_CHECK_STATUS.CHECKDONE.value())
                        , TaskSubDao.Properties.TaskId.eq(data.getId())).list();
                Logger.e("总任务数:" + allList.size() + "--完成任务数量：" + doneList.size());
                if (doneList.size() == allList.size()) {
                    data.setCheckStatus(TASK_STATUS.CHECKDONE.value());
                }
            }
            e.onNext(allotTasks);
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());


    }

    /**
     * 获取所有未同步任务
     * <p>
     * 并且
     *
     * @return
     */
    public Observable<List<Task>> getAllTask_NoSyncList() {
        return Observable.create((ObservableOnSubscribe<List<Task>>) e -> {
            List<Task> tasks      = new ArrayList<>();
            List<Task> allotTasks = taskDao._queryUser_TaskList(userStorge.getUserId());
            for (Task a : allotTasks) {
                List<TaskSub> allList = taskSubDao._queryTask_TaskSubList(a.getId());
                List<TaskSub> doneList = taskSubDao.queryBuilder().where(
                        TaskSubDao.Properties.CheckStatus.eq(TASKSUB_CHECK_STATUS.CHECKDONE.value())
                        , TaskSubDao.Properties.TaskId.eq(a.getId())).list();
                Logger.e("获取所有未同步任务 总任务数:" + allList.size() + "--完成任务数量：" + doneList.size());
                if (TASK_STATUS.CHECKING.value() != a.getCheckStatus() && TASK_STATUS.NOCHECK.value() != a.getCheckStatus()) {
                    if (doneList.size() == allList.size()) {
                        a.setStatus(3);
                    }
                    tasks.add(a);
                }

            }
            e.onNext(tasks);
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Boolean> saveAllAllotTask(List<Task_Allot> tasks) {
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Boolean> e) throws Exception {
                for (Task_Allot task : tasks) {
                    task.setUserId(userStorge.getUserId());
                }
                task_allotDao.insertOrReplaceInTx(tasks);
                e.onNext(true);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());

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
    public Observable<Boolean> deleteTasks(List<Task> allotTasks) {
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Boolean> e) throws Exception {
                for (Task a : allotTasks) {
                    taskSubDao.deleteInTx(a.getTaskSubList());
                    taskDao.deleteInTx(a);
                }
                e.onNext(true);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

    }
}
