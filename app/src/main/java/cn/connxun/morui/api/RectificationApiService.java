package cn.connxun.morui.api;

import java.util.List;

import cn.connxun.morui.entity.InspectionRectification;
import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by wushange on 2017/8/14.
 */

public interface RectificationApiService {
    /**
     * 分配任务
     *
     * @return
     */
    @GET("rectification/getListByUser.do")
    Observable<List<InspectionRectification>> getList();

    @GET("rectification/findOneById.do")
    Observable<Response<String>> getDetail(@Query("id") String id);


    @Headers("Content-Type:application/json")
    @POST("rectification/updateRectification.do")
    Observable<Response<String>> changeTask(@Body Object o);
}
