package cn.connxun.morui.api;

import java.util.List;

import cn.connxun.morui.entity.AllotUser;
import cn.connxun.morui.entity.ListBean;
import cn.connxun.morui.entity.Task;
import cn.connxun.morui.entity.Task_Allot;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by wushange on 2017/8/14.
 */

public interface TaskApiService {
    /**
     * 获取分配任务列表
     *
     * @return
     */
    @GET("getProjectList.do")
    Observable<ListBean<Task_Allot>> getProjectList();

    /**
     * 获取任务人员列表
     *
     * @return
     */
    @GET("getUserListByTasks.do")
    Observable<List<AllotUser>> getUserListByTasks();

    /**
     * 分配任务
     *
     * @param json
     * @return
     */
    @Headers("Content-Type:application/json")
    @POST("allotmentTask.do")
    Observable<Object> allotmentTask(@Body List<Task_Allot> json);

    /**
     * 同步任务
     *
     * @return
     */
    @GET("synchronizingTask.do")
    Observable<List<Task>> getNewTaskList();

    /**
     * 同步任务
     *
     * @return
     */
    @POST("confirmTask.do")
    Observable<Object> confirmTask(@Body Object task);

    /**
     * 同步任务
     *
     * @return
     */
    @POST("withdrawTask.do")
    Observable<Object> gobackTask(@Body Object task);

    /**
     * 同步任务
     *
     * @return
     */
    @GET("getHistoryTask.do")
    Observable<List<Task>> getHistoryTask();


    /**
     * 分配任务
     *
     * @param json
     * @return
     */
    @Headers("Content-Type:application/json")
    @POST("uploadTask.do")
    Observable<Object> uploadTask(@Body List<Task> json);

 
}
