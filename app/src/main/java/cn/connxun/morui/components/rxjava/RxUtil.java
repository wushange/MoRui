package cn.connxun.morui.components.rxjava;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wushange on 2017/9/14.
 */

public class RxUtil {

    public static Observable<Object> runOnIoThreadTask() {
        return Observable.create(e -> e.onNext("")).subscribeOn(Schedulers.io()).onExceptionResumeNext(Observable.just("this is rx exception"));
    }
}
