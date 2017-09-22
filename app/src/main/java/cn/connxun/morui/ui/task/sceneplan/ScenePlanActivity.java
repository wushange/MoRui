package cn.connxun.morui.ui.task.sceneplan;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import cn.connxun.morui.R;
import cn.connxun.morui.entity.ConplanBean;
import cn.connxun.morui.ui.base.BaseSwipeBackActivity;
import cn.connxun.morui.ui.filepreview.FilePreviewActivity;

/**
 * 巡检记录
 * Created by wushange on 2017/7/19.
 */

public class ScenePlanActivity extends BaseSwipeBackActivity implements  ScenePlanContract.ScenePlanView{
    @BindView(R.id.erl_sceneplan_record)
    EasyRecyclerView recyclerView;
    @Inject
    ScenePlanAdapter   adapter;
    @Inject
    ScenePlanPresenter presenter;

    @Override
    public int bindLayout() {
        return R.layout.activity_sceneplay;
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
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void doBusiness(Context mContext) {
        presenter.getList();
        adapter.setOnItemClickListener(position -> {
            FilePreviewActivity.callMe(getContext(),"http://124.163.204.74/file3.data.weipan.cn/38704231/917eed08f259e96f1bf61ee8f3edddb2cd67799b?ip=1500882004,221.216.94.191&ssig=wwbUZsE7ov&Expires=1500882604&KID=sae,l30zoo1wmz&fn=%E6%B5%8B%E8%AF%95%E9%9C%80%E6%B1%82%E5%88%86%E6%9E%90%E6%96%87%E6%A1%A3.pdf&skiprd=2&se_ip_debug=221.216.94.191&corp=2&from=1221134&wsiphost=local");

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
    public void showList(List<ConplanBean> list) {
        adapter.addAll(list);
    }
}
