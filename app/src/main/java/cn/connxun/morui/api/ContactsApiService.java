package cn.connxun.morui.api;

import java.util.List;

import cn.connxun.morui.entity.Contacts;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by wushange on 2017/7/11.
 */

public interface ContactsApiService {
    /**
     * 获取通讯录列表
     *
     * @return
     */
    @GET("getList.do")
    Observable<List<Contacts>> getList();

}
