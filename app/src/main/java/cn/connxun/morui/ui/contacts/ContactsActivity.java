package cn.connxun.morui.ui.contacts;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import cn.connxun.morui.R;
import cn.connxun.morui.entity.Contacts;
import cn.connxun.morui.ui.base.BaseSwipeBackActivity;
import cn.connxun.morui.widget.treeview.TreeListViewAdapter;

/**
 * 巡检记录
 * Created by wushange on 2017/7/19.
 */

public class ContactsActivity extends BaseSwipeBackActivity implements ContactsContract.ContactsView {

//    @BindView(R.id.lv_recyclerView)
//    IndexableLayout lvRecyclerView;
//    @Inject
//    ContactsAdapter adapter;
    @Inject
    ContactsPresenter presenter;
    @BindView(R.id.id_tree)
    ListView          mTree;
    private TreeListViewAdapter mAdapter;

    @Override
    public int bindLayout() {
        return R.layout.activity_contacts;
    }

    @Override
    public void initParms(Bundle parms) {
    }

    @Override
    public void initView(View view) {
        presenter.attachView(this);
//        lvRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        lvRecyclerView.getRecyclerView().addItemDecoration(new DividerDecoration(Color.DKGRAY, ConvertUtils.px2dp(1),ConvertUtils.px2dp(15),ConvertUtils.px2dp(15)));
//        lvRecyclerView.setOverlayStyle_Center();
//        lvRecyclerView.setCompareMode(IndexableLayout.MODE_FAST);
//        lvRecyclerView.setAdapter(adapter);
    }

    @Override
    public void doBusiness(Context mContext) {
        presenter.getContactsList();
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
    public void showList(List<Contacts> list) {
//        adapter.setDatas(list);
        try {
            mAdapter = new SimpleTreeAdapter<>(mTree, getContext(), list, 0);
            mAdapter.setOnTreeNodeClickListener((node, position) -> {
                if (node.isLeaf()) {
                    Toast(node.getName());
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        mTree.setEmptyView(LayoutInflater.from(getContext()).inflate(R.layout.view_empty,null));
        mTree.setAdapter(mAdapter);
    }

}
