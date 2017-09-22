package cn.connxun.morui.ui.filedoc;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.blankj.utilcode.util.ConvertUtils;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import javax.inject.Inject;

import butterknife.BindView;
import cn.connxun.morui.constants.Constants;
import cn.connxun.morui.R;
import cn.connxun.morui.entity.Document;
import cn.connxun.morui.entity.ListBean;
import cn.connxun.morui.ui.base.BaseSwipeBackActivity;
import cn.connxun.morui.ui.filepreview.FilePreviewActivity;

/**
 * 文件文档
 * Created by wushange on 2017/7/19.
 */

public class FileDocActivity extends BaseSwipeBackActivity implements FileDocContract.FileDocView ,SwipeRefreshLayout.OnRefreshListener   {
    @BindView(R.id.easy_recyclerview)
    EasyRecyclerView recyclerView;
    @Inject
    FileDocAdapter   adapter;
    @Inject
    FileDocPresenter presenter;

    @Override
    public int bindLayout() {
        return R.layout.activity_filedoc;
    }

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public void initView(View view) {
        presenter.attachView(this);
    }

    @Override
    public void doBusiness(Context mContext) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerDecoration(Color.GRAY, ConvertUtils.px2dp(2)));
        recyclerView.setRefreshListener(this);
        adapter.setOnItemClickListener(position -> {
            FilePreviewActivity.callMe(getContext(), Constants.HOST+"/upload/"+adapter.getItem(position).getFilePath());
        });
        recyclerView.setAdapterWithProgress(adapter);
        presenter.getList();
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
    public void showList(ListBean<Document> list) {
        if (list.getTotal() <= 0) {
            recyclerView.showEmpty();
            return;
        }
        adapter.addAll(list.getList());
    }

    @Override
    public void onRefresh() {
        adapter.clear();
        presenter.getList();

    }
}
