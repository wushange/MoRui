package cn.connxun.morui.ui.task.taskallot;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import cn.connxun.morui.R;
import cn.connxun.morui.api.TaskApi;
import cn.connxun.morui.constants.enums.TASK_STATUS;
import cn.connxun.morui.data.local.TaskStroge;
import cn.connxun.morui.data.local.UserStorge;
import cn.connxun.morui.di.component.FragmentComponent;
import cn.connxun.morui.entity.AllotUser;
import cn.connxun.morui.entity.Task_Allot;
import cn.connxun.morui.ui.base.BaseEvents;
import cn.connxun.morui.ui.base.BaseFragmentV4;
import cn.connxun.morui.ui.bottomsheet.BottomSheetFragment;
import jp.wasabeef.recyclerview.animators.ScaleInBottomAnimator;

/**
 * Created by wushange on 2017/9/5.
 */

public class TaskAllotFragment extends BaseFragmentV4 implements TaskAllotContract.TaskAllotView {
    public static TaskAllotFragment newInstance() {
        TaskAllotFragment fragment = new TaskAllotFragment();
        return fragment;
    }

    @BindView(R.id.rl_task_allot)
    RecyclerView recyclerView;
    TaskAllotPresenter presenter;
    @Inject
    TaskAllotAdapter adapter;
    @Inject
    TaskApi          api;
    @Inject
    UserStorge       userStorge;
    @Inject
    TaskStroge       taskStroge;


    @Override
    public int bindLayout() {
        return R.layout.fragment_task_allot;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void initView(View view) {
        presenter = new TaskAllotPresenter(api, userStorge, taskStroge);
        presenter.attachView(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new SpaceDecoration(20));
        recyclerView.setItemAnimator(new ScaleInBottomAnimator());
        adapter.bindToRecyclerView(recyclerView);
        adapter.setEmptyView(R.layout.view_empty);
        adapter.openLoadAnimation();
        adapter.isFirstOnly(false);
        adapter.setUpFetchEnable(true);
        adapter.setOnItemChildClickListener((adapter1, view1, position) -> presenter.getAllotUsers(position));

    }

    @Override
    public void doBusiness(Context mContext) {
        presenter.getAllotList();

    }

    @Override
    public void lazyInitBusiness(Context mContext) {
    }

    @Override
    public void initInjector() {
        getComponent(FragmentComponent.class).inject(this);
    }

    @Override
    public void startLoading() {
        mOperation.showProgress("请稍后...");
    }

    @Override
    public void endLoading() {
        mOperation.dissMissDialog();
    }

    @Override
    public void onError(String error) {
        mOperation.showToast(error);
    }


    @Override
    public void removeTask(int oldPos) {
        mOperation.showToast("分配成功");
        EventBus.getDefault().postSticky(BaseEvents.CommonEvent.UPDATE_ALLOTED_LIST);
        adapter.remove(oldPos);
    }

    @Override
    public void onUserList(int oldPos, List<AllotUser> users) {
        BottomSheetFragment.showUsers(getChildFragmentManager(), users, (user, fragment) -> new MaterialDialog.Builder(getContext())
                .content("执行人:" + user.getRealname())
                .positiveText("确认")
                .negativeText("取消")
                .onPositive((dialog, which) -> {
                    fragment.dismiss();
                    dialog.dismiss();
                    Task_Allot task= adapter.getItem(oldPos);
                    task.setCheckUserId((int) user.getId());
                    task.setCheckUserName(user.getRealname());
                    task.setCheckUserDepartmentId(user.getDepartmentId());
                    task.setCheckUserEnterpriseId(user.getEnterpriseId());
                    task.setCheckUserJobsId(user.getJobsId());
                    task.setStatus(TASK_STATUS.ALLOT_ALREADY.value());
                    presenter.allotmentTask(oldPos, adapter.getData());
                })
                .onNegative((dialog, which) -> {
                    dialog.dismiss();
                })
                .show());
    }

    @Override
    public void showList(List<Task_Allot> tasks) {
        if (tasks != null) {
            adapter.addData(tasks);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }


}
