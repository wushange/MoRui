package cn.connxun.morui.api;

import com.blankj.utilcode.util.SPUtils;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import cn.connxun.morui.components.retrofit.MoRuiGsonConverterFactory;
import cn.connxun.morui.components.retrofit.RequestHelper;
import cn.connxun.morui.constants.Constants;
import cn.connxun.morui.entity.AllotUser;
import cn.connxun.morui.entity.ListBean;
import cn.connxun.morui.entity.Task;
import cn.connxun.morui.entity.Task_Allot;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.http.Body;

/**
 * Created by wushange on 2017/7/11.
 */

public class TaskApi implements TaskApiService {
    public static final String BASE_URL = SPUtils.getInstance().getString(Constants.HOSTKEY,Constants.HOST) + "/api/inspection/task/";
    private TaskApiService service;
    private RequestHelper  helper;

    public TaskApi(RequestHelper helper, OkHttpClient.Builder mOkHttpClient) {
        this.helper = helper;
        mOkHttpClient.addInterceptor(chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .addHeader("accessToken", helper.getToken())
                    .build();
            return chain.proceed(request);
        });
        Retrofit retrofit =
                new Retrofit.Builder()
                        .client(mOkHttpClient.build())
                        .baseUrl(BASE_URL)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(MoRuiGsonConverterFactory.create())
                        .build();
        service = retrofit.create(TaskApiService.class);
    }

    public Observable<ListBean<Task_Allot>> getProjectList() {
        return service.getProjectList()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

    }

    public Observable<List<AllotUser>> getUserListByTasks() {
        return service.getUserListByTasks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    public Observable<Object> allotmentTask(List<Task_Allot> jsonStr) {
        return service.allotmentTask(jsonStr)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    @Override
    public Observable<List<Task>> getNewTaskList() {
        return service.getNewTaskList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Object> confirmTask(@Body Object task) {
        return service.confirmTask(task).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Object> gobackTask(@Body Object task) {
        return service.gobackTask(task).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    public Observable<List<Task>> getHistoryTask() {
        return service.getHistoryTask()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Object> uploadTask(@Body List<Task> json) {
        return service.uploadTask(json)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
