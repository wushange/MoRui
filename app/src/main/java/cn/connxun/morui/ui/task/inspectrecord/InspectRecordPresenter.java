package cn.connxun.morui.ui.task.inspectrecord;

import android.os.Handler;

import java.util.List;

import javax.inject.Inject;

import cn.connxun.morui.components.rxjava.RxUtil;
import cn.connxun.morui.data.local.TaskStroge;
import cn.connxun.morui.di.PerActivity;
import cn.connxun.morui.entity.Task;
import cn.connxun.morui.ui.base.BasePresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;

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
        RxUtil.runOnIoThreadTask().observeOn(AndroidSchedulers.mainThread()).subscribe(o -> {
            List<Task> taskList = taskStroge.getAllTask_NoSyncList();
            new Handler().postDelayed(() -> mView.showList(taskList),500);
        });


    }
}
