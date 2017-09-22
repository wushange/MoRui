package cn.connxun.morui.ui.task.conplan;

import javax.inject.Inject;

import cn.connxun.morui.api.PlanApi;
import cn.connxun.morui.di.PerActivity;
import cn.connxun.morui.entity.ListBean;
import cn.connxun.morui.entity.PlanDetail;
import cn.connxun.morui.ui.base.BasePresenter;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by wanglj on 16/7/4.
 */


@PerActivity
public class ConplanPresenter extends BasePresenter<ConplanContract.ConplanView> implements ConplanContract.ConplanPresenter {


    PlanApi planApi;

    @Inject
    public ConplanPresenter(PlanApi planApi) {
        this.planApi = planApi;
    }


    @Override
    public void getList() {
        mDisposable.add(planApi.getPlanList("1","20").subscribe(new Consumer<ListBean<PlanDetail>>() {
            @Override
            public void accept(@NonNull ListBean<PlanDetail> planDetailListBean) throws Exception {
                mView.showList(planDetailListBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {

            }
        }));
    }
}
