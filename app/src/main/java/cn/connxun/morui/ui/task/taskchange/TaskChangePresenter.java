package cn.connxun.morui.ui.task.taskchange;

import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import cn.connxun.morui.api.RectificationApi;
import cn.connxun.morui.di.PerActivity;
import cn.connxun.morui.ui.base.BasePresenter;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import retrofit2.Response;

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
            Logger.e("---"+ stringResponse);
        }, throwable -> {

            mView.onError(throwable.getMessage());
        }));
        
    }

    @Override
    public void changeTask() {
        Map<String, String> jsonObject = new HashMap<>();
        jsonObject.put("id", mView.getInspectionRectification().getId());
        jsonObject.put("rectificationImg",mView.getInspectionRectification().getRectificationImg());
        mDisposable.add(api.changeTask(jsonObject).subscribe(new Consumer<Response<String>>() {
            @Override
            public void accept(@NonNull Response<String> stringResponse) throws Exception {

                mView.changSuccess();
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                mView.onError(throwable.getMessage());
            }
        }));

    }
}
