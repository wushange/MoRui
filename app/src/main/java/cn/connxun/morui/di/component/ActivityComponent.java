package cn.connxun.morui.di.component;

import android.app.Activity;

import cn.connxun.morui.di.PerActivity;
import cn.connxun.morui.di.module.ActivityModule;
import cn.connxun.morui.ui.contacts.ContactsActivity;
import cn.connxun.morui.ui.filedoc.FileDocActivity;
import cn.connxun.morui.ui.guide.GuideActivity;
import cn.connxun.morui.ui.login.LoginActivity;
import cn.connxun.morui.ui.notice.NoticeActivity;
import cn.connxun.morui.ui.splash.SplashActivity;
import cn.connxun.morui.ui.task.conplan.ConplanActivity;
import cn.connxun.morui.ui.task.conplan.ConplanDetailActivity;
import cn.connxun.morui.ui.task.historyrecord.HistoryRecordActivity;
import cn.connxun.morui.ui.task.inspectrecord.InspectRecordActivity;
import cn.connxun.morui.ui.task.sceneplan.ScenePlanActivity;
import cn.connxun.morui.ui.task.scenevideo.SceneVideoActivity;
import cn.connxun.morui.ui.task.synctask.SyncActivity;
import cn.connxun.morui.ui.task.taskallot.TaskAllotActivity;
import cn.connxun.morui.ui.task.taskdetails.TaskDetailsActivity;
import cn.connxun.morui.ui.task.taskinspect.TaskInspectActivity;
import cn.connxun.morui.ui.task.taskstep.TaskStepActivity;
import cn.connxun.morui.ui.task.tasktag.TaskTagactivity;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(SplashActivity activity);

    void inject(LoginActivity baseActivity);

    void inject(TaskAllotActivity baseActivity);

    void inject(TaskInspectActivity activity);

    void inject(ContactsActivity activity);

    void inject(InspectRecordActivity activity);

    void inject(HistoryRecordActivity activity);

    void inject(ConplanActivity activity);

    void inject(ScenePlanActivity activity);

    void inject(SceneVideoActivity activity);

    void inject(SyncActivity activity);

    void inject(GuideActivity activity);

    void inject(FileDocActivity activity);

    void inject(NoticeActivity activity);

    void inject(TaskTagactivity taskTagactivity);

    void inject(TaskDetailsActivity activity);

    void inject(ConplanDetailActivity activity);

    void inject(TaskStepActivity activity);
}
