package cn.connxun.morui.ui.task.historyrecord;

import java.util.List;

import javax.inject.Inject;

import cn.connxun.morui.api.TaskApi;
import cn.connxun.morui.di.PerActivity;
import cn.connxun.morui.entity.Task;
import cn.connxun.morui.ui.base.BasePresenter;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by wanglj on 16/7/4.
 */


@PerActivity
public class HistoryRecordPresenter extends BasePresenter<HistoryRecordContract.HistoryRecordView> implements HistoryRecordContract.HistoryRecordPresenter {

    TaskApi taskApi;

    @Inject
    public HistoryRecordPresenter(TaskApi taskApi) {
        this.taskApi = taskApi;
    }

    @Override
    public void getTaskList() {
        mDisposable.add(taskApi.getHistoryTask().subscribe(new Consumer<List<Task>>() {
            @Override
            public void accept(@NonNull List<Task> tasks) throws Exception {
                mView.showList(tasks);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {

            }
        }));

    }
}
