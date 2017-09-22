package cn.connxun.morui.ui.task.conplan;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;

import javax.inject.Inject;

import butterknife.BindView;
import cn.connxun.morui.R;
import cn.connxun.morui.entity.ListBean;
import cn.connxun.morui.entity.PlanDetail;
import cn.connxun.morui.ui.base.BaseSwipeBackActivity;

/**
 * 应急预案
 * Created by wushange on 2017/7/19.
 */

public class ConplanActivity extends BaseSwipeBackActivity implements ConplanContract.ConplanView {
    @BindView(R.id.easy_recyclerview)
    EasyRecyclerView recyclerView;
    @Inject
    ConplanAdapter   adapter;
    @Inject
    ConplanPresenter presenter;

    @Override
    public int bindLayout() {
        return R.layout.activity_contplay;
    }

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public void initView(View view) {
        presenter.attachView(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SpaceDecoration spaceDecoration = new SpaceDecoration(20);
        spaceDecoration.setPaddingEdgeSide(false);
        recyclerView.addItemDecoration(spaceDecoration);
        recyclerView.setAdapterWithProgress(adapter);


    }

    @Override
    public void doBusiness(Context mContext) {
        presenter.getList();
        adapter.setOnItemClickListener(position -> {
            ConplanDetailActivity.callMe(getContext(),adapter.getItem(position).getId()+"");
        });
    }

    @Override
    public void initInjector() {
        getComponent().inject(this);
    }

    @Override
    public void startLoading() {

    }

    @Override
    public void endLoading() {

    }
    @Override
    public void onError(String error) {
        Toast(error);
    }

    @Override
    public void showList(ListBean<PlanDetail> list) {
        if (list.getTotal() <= 0) {
            recyclerView.showEmpty();
            return;
        }
        adapter.addAll(list.getList());
    }
}
