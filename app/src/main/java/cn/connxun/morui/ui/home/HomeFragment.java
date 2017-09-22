package cn.connxun.morui.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.blankj.utilcode.util.ConvertUtils;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import cn.connxun.morui.R;
import cn.connxun.morui.constants.Constants;
import cn.connxun.morui.data.local.UserStorge;
import cn.connxun.morui.di.component.FragmentComponent;
import cn.connxun.morui.entity.Menu;
import cn.connxun.morui.entity.Task;
import cn.connxun.morui.ui.base.BaseFragmentV4;
import cn.connxun.morui.ui.contacts.ContactsActivity;
import cn.connxun.morui.ui.filedoc.FileDocActivity;
import cn.connxun.morui.ui.guide.GuideActivity;
import cn.connxun.morui.ui.notice.NoticeActivity;
import cn.connxun.morui.ui.task.conplan.ConplanActivity;
import cn.connxun.morui.ui.task.historyrecord.HistoryRecordActivity;
import cn.connxun.morui.ui.task.inspectrecord.InspectRecordActivity;
import cn.connxun.morui.ui.task.sceneplan.ScenePlanActivity;
import cn.connxun.morui.ui.task.scenevideo.SceneVideoActivity;
import cn.connxun.morui.ui.task.stacalreport.StaticsReportActivity;
import cn.connxun.morui.ui.task.taskallot.TaskAllotActivity;
import cn.connxun.morui.ui.task.taskinspect.TaskInspectActivity;
import cn.connxun.morui.ui.task.taskinspect.TaskInspectContract;
import cn.connxun.morui.ui.task.taskinspect.TaskInspectPresenter;

/**
 * Created by wushange on 2017/7/19.
 */

public class HomeFragment extends BaseFragmentV4 implements TaskInspectContract.TaskInsView {
    @BindView(R.id.erl_home_menulist)
    EasyRecyclerView     erlHomeMenulist;
    @Inject
    HomeMenuAdapter      adapter;
    @Inject
    UserStorge           userStorge;
    @Inject
    TaskInspectPresenter presenter;
    List<Menu> menus;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void initView(View view) {
        presenter.attachView(this);

        erlHomeMenulist.setLayoutManager(new GridLayoutManager(getContext(), 4));
        DividerDecoration dividerDecoration = new DividerDecoration(getResources().getColor(R.color.grid_itemdecoration), ConvertUtils.dp2px(0.5f));
        erlHomeMenulist.addItemDecoration(dividerDecoration);
        erlHomeMenulist.setAdapter(adapter);

        if (menus != null) {
            return;

        }
        if (userStorge.getUser().getRole_id() == Constants.ROLE_MANAGER) {
            menus = Menu.getHomeMenusByAdmin();
        } else {
            menus = Menu.getHomeMenusByWorks();
        }
        adapter.addAll(menus);

    }

    @Override
    public void doBusiness(Context mContext) {
        adapter.setOnItemClickListener(position -> {
            Menu.MENU_ID menu_id = adapter.getItem(position).getId();
            forwardActivity(menu_id);
        });

    }

    @Override
    public void lazyInitBusiness(Context mContext) {
        if (userStorge.getUser().getId() == 2) {
            mOperation.showToastInCenter("无访问权限！");
            return;
        }
    }


    /**
     * 根据不同id跳转不同页面
     *
     * @param menu_id
     */
    private void forwardActivity(Menu.MENU_ID menu_id) {
        switch (menu_id) {
            case TASK_ALLOCT: {
                mOperation.forward(TaskAllotActivity.class);
            }
            break;
            case TASK_INSPECT: {
                mOperation.forward(TaskInspectActivity.class);
            }
            break;
            case INSPECT_RECORD: {
                mOperation.forward(InspectRecordActivity.class);
            }
            break;
            case HISTORY_RECORD: {
                mOperation.forward(HistoryRecordActivity.class);
            }
            break;
            case CONTINGENCY_PLAN: {
                mOperation.forward(ConplanActivity.class);
            }
            break;
            case SCENE_DISPOSAL_PLAN: {
                mOperation.forward(ScenePlanActivity.class);
            }
            break;
            case STATISTICAL_REPORT: {
                mOperation.forward(StaticsReportActivity.class);
            }
            break;
            case SCENE_VIEDO: {
                mOperation.forward(SceneVideoActivity.class);
            }
            break;
            case CONTACTS: {
                mOperation.forward(ContactsActivity.class);
            }
            break;
            case SYNC_TASK: {
                mOperation.showProgressHorizontalIndeterminateDialog("同步中...", false);
                presenter.syncTaskList();
//                Observable.timer(5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Long>() {
//                    @Override
//                    public void accept(@NonNull Long aLong) throws Exception {
//                        mOperation.dissMissDialog();
//                    }
//                });
            }
            break;
            case GUIDE: {
                mOperation.forward(GuideActivity.class);
            }
            break;
            case FILE_DOC: {
                mOperation.forward(FileDocActivity.class);
            }
            break;
            case NOTICE: {
                mOperation.forward(NoticeActivity.class);
            }
            break;
        }
    }

    @Override
    public void startLoading() {

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
    public void showLoadingView(String string) {
        mOperation.showNotCancelWithContent(string);
    }

    @Override
    public void showList(List<Task> list) {
        mOperation.showSingleBtnDialog("同步任务成功!", "知道了", (dialog, which) -> dialog.dismiss());
    }

    @Override
    public void showOfflineList(List<Task> list) {

    }

    @Override
    public void confirmTaskSuccess(Task task, int pos) {

    }

    @Override
    public void gobackTaskSuccess(Task task, int pos) {

    }


    @Override
    public void initInjector() {
        getComponent(FragmentComponent.class).inject(this);
    }
}
