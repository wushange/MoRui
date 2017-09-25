package cn.connxun.morui.ui.task.taskchange;

import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import cn.connxun.morui.api.RectificationApi;
import cn.connxun.morui.di.PerActivity;
import cn.connxun.morui.ui.base.BaseEvents;
import cn.connxun.morui.ui.base.BasePresenter;

/**
 * Created by wanglj on 16/7/4.
 */


@PerActivity
public class TaskChangePresenter extends BasePresenter<TaskChangeContract.TaskChangeView> implements TaskChangeContract.TaskChangePresenter {


    RectificationApi api;

    @Inject
    public TaskChangePresenter(RectificationApi api) {
        this.api = api;
    }

    @Override
    public void getTaskChangeList() {
        mDisposable.add(api.getList().subscribe(inspectionRectifications -> mView.showList(inspectionRectifications),
                throwable -> mView.onError(throwable.getMessage())));

    }

    @Override
    public void getTaskChangeDetail() {
        mDisposable.add(api.getDetail(mView.getTaskCId()).subscribe(stringResponse -> {
            Logger.e("---" + stringResponse);
        }, throwable -> {

            mView.onError(throwable.getMessage());
        }));

    }

    @Override
    public void changeTask() {
        mDisposable.add(api.changeTask(mView.getInspectionRectification().getId()
                , mView.getInspectionRectification().getRectificationImg())
                .subscribe(stringResponse -> {
                            EventBus.getDefault().postSticky(BaseEvents.CommonEvent.UPDATE_CHANGELIST);
                            mView.changSuccess();
                        },
                        throwable -> mView.onError(throwable.getMessage())));

    }
}
