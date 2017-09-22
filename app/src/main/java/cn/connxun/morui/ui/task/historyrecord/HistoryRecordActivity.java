package cn.connxun.morui.ui.task.historyrecord;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jude.easyrecyclerview.EasyRecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import cn.connxun.morui.R;
import cn.connxun.morui.entity.Task;
import cn.connxun.morui.ui.base.BaseSwipeBackActivity;

/**
 * 、、历史记录
 * Created by wushange on 2017/7/19.
 */

public class HistoryRecordActivity extends BaseSwipeBackActivity implements HistoryRecordContract.HistoryRecordView {
    @BindView(R.id.easy_hrecyclerview)
    EasyRecyclerView       erlHisRecord;
    @Inject
    HistoryRecordPresenter presenter;
    @Inject
    HistoryRecordAdapter   adapter;

    @Override
    public int bindLayout() {
        return R.layout.activity_history_record;
    }

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public void initView(View view) {
        presenter.attachView(this);
        presenter.getTaskList();
        erlHisRecord.setLayoutManager(new LinearLayoutManager(this ));
        erlHisRecord.setAdapterWithProgress(adapter);
        adapter.setOnItemButtonClickListener((v, da) -> {
            Toast("敬请期待");
//            TaskDetailsActivity.callMe(getContext(),da.getId());
        });
    }

    @Override
    public void doBusiness(Context mContext) {

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
    public void showList(List<Task> list) {
        adapter.clear();
        adapter.addAll(list);
    }
}
