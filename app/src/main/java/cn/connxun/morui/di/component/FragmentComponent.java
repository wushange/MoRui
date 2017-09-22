package cn.connxun.morui.di.component;


import cn.connxun.morui.di.PerActivity;
import cn.connxun.morui.di.module.ActivityModule;
import cn.connxun.morui.ui.home.HomeFragment;
import cn.connxun.morui.ui.main.MainActivity;
import cn.connxun.morui.ui.notice.NoticeActivity;
import cn.connxun.morui.ui.notice.NoticeFragment;
import cn.connxun.morui.ui.setting.SettingFragment;
import cn.connxun.morui.ui.task.taskallot.TaskAllotActivity;
import cn.connxun.morui.ui.task.taskallot.TaskAllotFragment;
import cn.connxun.morui.ui.task.taskallot.TaskAllotedFragment;
import dagger.Component;

/**
 * Created by sll on 2016/5/13.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class})
public interface FragmentComponent {
    void inject(MainActivity activity);

    void inject(TaskAllotActivity aboutActivity);

    void inject(TaskAllotedFragment fragment);

    void inject(NoticeActivity activity);

    void inject(NoticeFragment fragment);

    void inject(HomeFragment fragment);

    void inject(SettingFragment fragment);

    void inject(TaskAllotFragment allotFragment);

}
