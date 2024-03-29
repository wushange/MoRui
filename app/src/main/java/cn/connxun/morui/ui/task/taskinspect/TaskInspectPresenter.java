package cn.connxun.morui.ui.task.taskinspect;

import com.blankj.utilcode.util.ToastUtils;
import com.facebook.stetho.common.LogUtil;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import cn.connxun.morui.api.TaskApi;
import cn.connxun.morui.constants.enums.TASK_STATUS;
import cn.connxun.morui.data.local.TaskStroge;
import cn.connxun.morui.di.PerActivity;
import cn.connxun.morui.entity.Task;
import cn.connxun.morui.ui.base.BasePresenter;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by wanglj on 16/7/4.
 */


@PerActivity
public class TaskInspectPresenter extends BasePresenter<TaskInspectContract.TaskInsView> implements TaskInspectContract.TaskInsPresenter {


    private TaskApi    api;
    private TaskStroge stroge;

    @Inject
    public TaskInspectPresenter(TaskApi api, TaskStroge stroge) {
        this.api = api;
        this.stroge = stroge;
    }

    @Override
    public void confirmTask(Task task, int pos) {
        Map<String, String> jsonObject = new HashMap<>();
        jsonObject.put("id", task.getId());
        api.confirmTask(jsonObject).subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mDisposable.add(d);
            }

            @Override
            public void onNext(@NonNull Object o) {
                LogUtil.e("-next-->>" + o.toString());
                task.setStatus(TASK_STATUS.ALLOT_CONFIRMED.value());
                mView.confirmTaskSuccess(task, pos);
                mView.endLoading();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                LogUtil.e("-onerror-->>" + e.getMessage());
                mView.endLoading();
            }

            @Override
            public void onComplete() {
                mView.endLoading();
            }
        });
    }

    @Override
    public void gobackTask(Task task, int pos) {
        Map<String, String> jsonObject = new HashMap<>();
        jsonObject.put("id", task.getId());
        api.gobackTask(jsonObject).subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mDisposable.add(d);
            }

            @Override
            public void onNext(@NonNull Object o) {
                LogUtil.e("-next-->>" + o.toString());
                task.setStatus(TASK_STATUS.ALLOT_GOBACK.value());
                mView.gobackTaskSuccess(task, pos);
                mView.endLoading();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                LogUtil.e("-onerror-->>" + e.getMessage());
                mView.endLoading();
            }

            @Override
            public void onComplete() {
                mView.endLoading();
            }
        });
    }

    @Override
    public void syncTaskList() {
        stroge.getAllTask_NoSyncList().subscribe(tasks -> {
            Logger.e("--" + tasks.toString());
            mView.showLoadingView("上传任务中...");
            api.uploadTask(tasks).subscribe(new Observer<Object>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {
                    mDisposable.add(d);
                }

                @Override
                public void onNext(@NonNull Object o) {
                    stroge.deleteTasks(tasks).subscribe(new Consumer<Boolean>() {
                        @Override
                        public void accept(@NonNull Boolean aBoolean) throws Exception {
                            ToastUtils.showShort("上传成功");
                        }
                    });
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    mView.onError(e.getMessage());
                    mView.endLoading();
                }

                @Override
                public void onComplete() {
                    mView.endLoading();
                    downloadTasks();
                }
            });
        }, throwable -> {

        });


    }

    @Override
    public void syncTaskOnlyDownload() {
        downloadTasks();
    }

    private void downloadTasks() {
        mView.showLoadingView("下载任务中...");
        api.getNewTaskList().subscribe(new Observer<List<Task>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mDisposable.add(d);
            }

            @Override
            public void onNext(@NonNull List<Task> tasks) {
                ToastUtils.showShort("下载成功");
                mView.endLoading();
                stroge.saveAllTask(tasks).subscribe(aBoolean -> 
                        stroge.getAllTask_OffLine().subscribe(tasks1 ->
                                mView.showList(tasks1), throwable -> mView.onError(throwable.getMessage())));
            }

            @Override
            public void onError(@NonNull Throwable e) {
                mView.onError(e.getMessage());
                mView.endLoading();
            }

            @Override
            public void onComplete() {
            }
        });
    }

    @Override
    public void getOfflineTaskList() {
        stroge.getAllTask_OffLine().subscribe(tasks -> mView.showOfflineList(tasks), throwable -> mView.onError(throwable.getMessage()));

    } 

}
