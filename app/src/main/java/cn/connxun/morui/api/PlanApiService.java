package cn.connxun.morui.api;

import cn.connxun.morui.entity.ListBean;
import cn.connxun.morui.entity.PlanDetail;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wushange on 2017/7/11.
 */

public interface PlanApiService {
    /**
     * 获取应急预案列表
     * @param token
     * @param page
     * @param length
     * @return
     */
    @GET("getList.do")
    Observable<  ListBean<PlanDetail  >> getPlanList(
                                                               @Query("page") String page,
                                                               @Query("length") String length);


    /**
     * 根据预案id查看详情
     * @param token
     * @param id
     * @return
     */
    @GET("getById.do")
    Observable<  PlanDetail > getPlanDetailById(
                                                           @Query("id") String id);
}
