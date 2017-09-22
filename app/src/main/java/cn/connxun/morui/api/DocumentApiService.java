package cn.connxun.morui.api;

import cn.connxun.morui.entity.Document;
import cn.connxun.morui.entity.ListBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wushange on 2017/8/14.
 */

public interface DocumentApiService {
    /**
     * 获取文件文档列表
     *
     * @param token
     * @param page
     * @param length
     * @param category
     * @return
     */
    @GET("getList.do")
    Observable<ListBean<Document>> getList(
            @Query("page") String page,
            @Query("length") String length,
            @Query("category") String category);


}
