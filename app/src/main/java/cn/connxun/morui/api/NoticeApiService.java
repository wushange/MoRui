package cn.connxun.morui.api;

import cn.connxun.morui.entity.ListBean;
import cn.connxun.morui.entity.Notice;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wushange on 2017/8/14.
 */

public interface NoticeApiService {
    /**
     * 	获取当前用户消息
     * @param page
     * @param length
     * @param type type =1 报警预警,type =2 系统通知,type =3命令通知
     * @return
     */
    @GET("getListByUser.do")
    Observable<  ListBean<Notice >> getListByUser(
                                                             @Query("page") String page,
                                                             @Query("length") String length,
                                                             @Query("type") String type);

}
