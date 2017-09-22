package cn.connxun.morui.ui.task.taskallot;

import java.util.List;

import javax.inject.Inject;

import cn.connxun.morui.api.TaskApi;
import cn.connxun.morui.data.local.TaskStroge;
import cn.connxun.morui.data.local.UserStorge;
import cn.connxun.morui.di.PerActivity;
import cn.connxun.morui.entity.AllotUser;
import cn.connxun.morui.entity.ListBean;
import cn.connxun.morui.entity.Task_Allot;
import cn.connxun.morui.ui.base.BasePresenter;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by wanglj on 16/7/4.
 */


@PerActivity
public class TaskAllotPresenter extends BasePresenter<TaskAllotContract.TaskAllotView> implements TaskAllotContract.TaskAllotPresenter {

    TaskApi    api;
    UserStorge userStorge;
    TaskStroge taskStroge;

    @Inject
    public TaskAllotPresenter(TaskApi api, UserStorge userStorge, TaskStroge taskStroge) {
        this.api = api;
        this.userStorge = userStorge;
        this.taskStroge = taskStroge;
    }

    @Override
    public void getAllotList() {
        api.getProjectList().subscribe(new Observer<ListBean<Task_Allot>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mDisposable.add(d);
                mView.startLoading();
            }

            @Override
            public void onNext(@NonNull ListBean<Task_Allot> taskListBean) {
                mView.showList(taskListBean.getList());
                taskStroge.saveAllAllotTask(taskListBean.getList());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                mView.onError(e.getMessage());
            }

            @Override
            public void onComplete() {
                mView.endLoading();
            }
        });
    }

    @Override
    public void getAllotedList() {
        mView.showList(taskStroge.getAllTask_Alloted());
    }


    @Override
    public void getAllotUsers(int oldPos) {
        List<AllotUser> allotUsers = userStorge.getAllotUsers();
        if (allotUsers != null && allotUsers.size() > 0) {
            mView.onUserList(oldPos, allotUsers);
            return;
        }
        api.getUserListByTasks().subscribe(new Observer<List<AllotUser>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mDisposable.add(d);
                mView.startLoading();
            }

            @Override
            public void onNext(@NonNull List<AllotUser> allotUsers) {
                mView.onUserList(oldPos, allotUsers);
                userStorge.saveTaskAllTaskUsers(allotUsers);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                mView.onError(e.getMessage());
            }

            @Override
            public void onComplete() {
                mView.endLoading();
            }
        });

    }

    @Override
    public void allotmentTask(int pos,List<Task_Allot> jsonStr) {
        api.allotmentTask(jsonStr).subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mDisposable.add(d);
                mView.startLoading();
            }

            @Override
            public void onNext(@NonNull Object o) {
                taskStroge.updateAllTaskAllots(jsonStr);
                mView.endLoading();
                mView.removeTask(pos);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                mView.onError(e.getMessage());
                mView.endLoading();
            }

            @Override
            public void onComplete() {
                mView.endLoading();
            }
        });

    }
}
