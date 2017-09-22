package cn.connxun.morui.ui.notice;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.blankj.utilcode.util.ConvertUtils;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import javax.inject.Inject;

import butterknife.BindView;
import cn.connxun.morui.R;
import cn.connxun.morui.api.NoticeApi;
import cn.connxun.morui.data.local.NoticeStorge;
import cn.connxun.morui.di.component.FragmentComponent;
import cn.connxun.morui.entity.ListBean;
import cn.connxun.morui.entity.Notice;
import cn.connxun.morui.ui.base.BaseFragmentV4;
import cn.connxun.morui.ui.notice.adapter.NoticeAdapter;

/**
 * Created by wushange on 2017/8/16.
 */

public class NoticeFragment extends BaseFragmentV4 implements NoticeContract.NoticeView, SwipeRefreshLayout.OnRefreshListener, RecyclerArrayAdapter.OnLoadMoreListener {
    @Inject
    NoticeAdapter adapter;
    @Inject
    NoticeStorge  noticeStorge;
    @Inject
    NoticeApi     noticeApi;
    NoticePresenter presenter;
    @BindView(R.id.notice_recyclerview)
    EasyRecyclerView easyRecyclerView;

    private              int    NOTICE_TYPE  = 1;
    private static final String CHANNEL_TYPE = "CHANNEL_TYPE";

    int page = 1;

    public static NoticeFragment newInstance(int type) {
        NoticeFragment fragment = new NoticeFragment();
        Bundle args = new Bundle();
        args.putInt(CHANNEL_TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_notice;
    }

    @Override
    public void initParams(Bundle params) {
        if (params != null) {
            NOTICE_TYPE = params.getInt(CHANNEL_TYPE);
        }
    }

    @Override
    public void initView(View view) {
        presenter = new NoticePresenter(noticeApi, noticeStorge);
        presenter.attachView(this);
        easyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        easyRecyclerView.addItemDecoration(new DividerDecoration(Color.GRAY, ConvertUtils.px2dp(2)));
        easyRecyclerView.setAdapterWithProgress(adapter);
        easyRecyclerView.setRefreshListener(this);
        adapter.setMore(R.layout.view_more, this);
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {


                mOperation.showBasicDialog("详情",adapter.getItem(position).getNoticeContent(),null);
            }
        });
    }

    @Override
    public void doBusiness(Context mContext) {
        getList();
    }

    private void getList() {
        presenter.getList();
    }

    @Override
    public void lazyInitBusiness(Context mContext) {

    }

    @Override
    public void initInjector() {
        getComponent(FragmentComponent.class).inject(this);
    }


    @Override
    public void onRefresh() {
        page = 1;
        adapter.clear();
        getList();
    }

    @Override
    public void onLoadMore() {
        page++;
        getList();
    }

    @Override
    public void startLoading() {

    }

    @Override
    public void endLoading() {

    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void showList(ListBean<Notice> list) {
        if (page > 1) {

        } else {
            if (list.getList().size() == 0) {
                easyRecyclerView.showEmpty();
                return;
            }
        }
        adapter.addAll(list.getList());
    }

    @Override
    public String getPage() {
        return "" + page;
    }

    @Override
    public String getNoticeType() {
        return "" + NOTICE_TYPE;
    }
}
