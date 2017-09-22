package cn.connxun.morui.di.component;

import android.content.Context;
import cn.connxun.morui.api.NoticeApi;
import cn.connxun.morui.api.TaskApi;
import cn.connxun.morui.data.local.NoticeStorge;
import cn.connxun.morui.data.local.TaskStroge;
import cn.connxun.morui.data.local.UserStorge;
import cn.connxun.morui.di.module.ActivityModule;
import cn.connxun.morui.ui.home.HomeFragment;
import cn.connxun.morui.ui.home.HomeFragment_MembersInjector;
import cn.connxun.morui.ui.home.HomeMenuAdapter;
import cn.connxun.morui.ui.home.HomeMenuAdapter_Factory;
import cn.connxun.morui.ui.main.MainActivity;
import cn.connxun.morui.ui.notice.NoticeActivity;
import cn.connxun.morui.ui.notice.NoticeFragment;
import cn.connxun.morui.ui.notice.NoticeFragment_MembersInjector;
import cn.connxun.morui.ui.notice.adapter.NoticeAdapter;
import cn.connxun.morui.ui.notice.adapter.NoticeAdapter_Factory;
import cn.connxun.morui.ui.setting.SettingFragment;
import cn.connxun.morui.ui.setting.SettingFragment_MembersInjector;
import cn.connxun.morui.ui.task.taskallot.TaskAllotActivity;
import cn.connxun.morui.ui.task.taskallot.TaskAllotAdapter;
import cn.connxun.morui.ui.task.taskallot.TaskAllotAdapter_Factory;
import cn.connxun.morui.ui.task.taskallot.TaskAllotFragment;
import cn.connxun.morui.ui.task.taskallot.TaskAllotFragment_MembersInjector;
import cn.connxun.morui.ui.task.taskallot.TaskAllotedFragment;
import cn.connxun.morui.ui.task.taskallot.TaskAllotedFragment_MembersInjector;
import cn.connxun.morui.ui.task.taskinspect.TaskInspectPresenter;
import cn.connxun.morui.ui.task.taskinspect.TaskInspectPresenter_Factory;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerFragmentComponent implements FragmentComponent {
  private Provider<TaskAllotAdapter> taskAllotAdapterProvider;

  private Provider<TaskApi> getTaskApiProvider;

  private Provider<UserStorge> getUserStorgeProvider;

  private Provider<TaskStroge> getTaskStrogeProvider;

  private MembersInjector<TaskAllotedFragment> taskAllotedFragmentMembersInjector;

  private Provider<Context> getContextProvider;

  private Provider<NoticeAdapter> noticeAdapterProvider;

  private Provider<NoticeStorge> getNoticeStorgeProvider;

  private Provider<NoticeApi> getNoticeApiProvider;

  private MembersInjector<NoticeFragment> noticeFragmentMembersInjector;

  private Provider<HomeMenuAdapter> homeMenuAdapterProvider;

  private Provider<TaskInspectPresenter> taskInspectPresenterProvider;

  private MembersInjector<HomeFragment> homeFragmentMembersInjector;

  private MembersInjector<SettingFragment> settingFragmentMembersInjector;

  private MembersInjector<TaskAllotFragment> taskAllotFragmentMembersInjector;

  private DaggerFragmentComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.taskAllotAdapterProvider =
        TaskAllotAdapter_Factory.create(MembersInjectors.<TaskAllotAdapter>noOp());

    this.getTaskApiProvider =
        new cn_connxun_morui_di_component_ApplicationComponent_getTaskApi(
            builder.applicationComponent);

    this.getUserStorgeProvider =
        new cn_connxun_morui_di_component_ApplicationComponent_getUserStorge(
            builder.applicationComponent);

    this.getTaskStrogeProvider =
        new cn_connxun_morui_di_component_ApplicationComponent_getTaskStroge(
            builder.applicationComponent);

    this.taskAllotedFragmentMembersInjector =
        TaskAllotedFragment_MembersInjector.create(
            taskAllotAdapterProvider,
            getTaskApiProvider,
            getUserStorgeProvider,
            getTaskStrogeProvider);

    this.getContextProvider =
        new cn_connxun_morui_di_component_ApplicationComponent_getContext(
            builder.applicationComponent);

    this.noticeAdapterProvider =
        NoticeAdapter_Factory.create(MembersInjectors.<NoticeAdapter>noOp(), getContextProvider);

    this.getNoticeStorgeProvider =
        new cn_connxun_morui_di_component_ApplicationComponent_getNoticeStorge(
            builder.applicationComponent);

    this.getNoticeApiProvider =
        new cn_connxun_morui_di_component_ApplicationComponent_getNoticeApi(
            builder.applicationComponent);

    this.noticeFragmentMembersInjector =
        NoticeFragment_MembersInjector.create(
            noticeAdapterProvider, getNoticeStorgeProvider, getNoticeApiProvider);

    this.homeMenuAdapterProvider =
        HomeMenuAdapter_Factory.create(
            MembersInjectors.<HomeMenuAdapter>noOp(), getContextProvider);

    this.taskInspectPresenterProvider =
        DoubleCheck.provider(
            TaskInspectPresenter_Factory.create(
                MembersInjectors.<TaskInspectPresenter>noOp(),
                getTaskApiProvider,
                getTaskStrogeProvider));

    this.homeFragmentMembersInjector =
        HomeFragment_MembersInjector.create(
            homeMenuAdapterProvider, getUserStorgeProvider, taskInspectPresenterProvider);

    this.settingFragmentMembersInjector =
        SettingFragment_MembersInjector.create(getUserStorgeProvider);

    this.taskAllotFragmentMembersInjector =
        TaskAllotFragment_MembersInjector.create(
            taskAllotAdapterProvider,
            getTaskApiProvider,
            getUserStorgeProvider,
            getTaskStrogeProvider);
  }

  @Override
  public void inject(MainActivity activity) {
    MembersInjectors.<MainActivity>noOp().injectMembers(activity);
  }

  @Override
  public void inject(TaskAllotActivity aboutActivity) {
    MembersInjectors.<TaskAllotActivity>noOp().injectMembers(aboutActivity);
  }

  @Override
  public void inject(TaskAllotedFragment fragment) {
    taskAllotedFragmentMembersInjector.injectMembers(fragment);
  }

  @Override
  public void inject(NoticeActivity activity) {
    MembersInjectors.<NoticeActivity>noOp().injectMembers(activity);
  }

  @Override
  public void inject(NoticeFragment fragment) {
    noticeFragmentMembersInjector.injectMembers(fragment);
  }

  @Override
  public void inject(HomeFragment fragment) {
    homeFragmentMembersInjector.injectMembers(fragment);
  }

  @Override
  public void inject(SettingFragment fragment) {
    settingFragmentMembersInjector.injectMembers(fragment);
  }

  @Override
  public void inject(TaskAllotFragment allotFragment) {
    taskAllotFragmentMembersInjector.injectMembers(allotFragment);
  }

  public static final class Builder {
    private ApplicationComponent applicationComponent;

    private Builder() {}

    public FragmentComponent build() {
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerFragmentComponent(this);
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This
     *     method is a no-op. For more, see https://google.github.io/dagger/unused-modules.
     */
    @Deprecated
    public Builder activityModule(ActivityModule activityModule) {
      Preconditions.checkNotNull(activityModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }

  private static class cn_connxun_morui_di_component_ApplicationComponent_getTaskApi
      implements Provider<TaskApi> {
    private final ApplicationComponent applicationComponent;

    cn_connxun_morui_di_component_ApplicationComponent_getTaskApi(
        ApplicationComponent applicationComponent) {
      this.applicationComponent = applicationComponent;
    }

    @Override
    public TaskApi get() {
      return Preconditions.checkNotNull(
          applicationComponent.getTaskApi(),
          "Cannot return null from a non-@Nullable component method");
    }
  }

  private static class cn_connxun_morui_di_component_ApplicationComponent_getUserStorge
      implements Provider<UserStorge> {
    private final ApplicationComponent applicationComponent;

    cn_connxun_morui_di_component_ApplicationComponent_getUserStorge(
        ApplicationComponent applicationComponent) {
      this.applicationComponent = applicationComponent;
    }

    @Override
    public UserStorge get() {
      return Preconditions.checkNotNull(
          applicationComponent.getUserStorge(),
          "Cannot return null from a non-@Nullable component method");
    }
  }

  private static class cn_connxun_morui_di_component_ApplicationComponent_getTaskStroge
      implements Provider<TaskStroge> {
    private final ApplicationComponent applicationComponent;

    cn_connxun_morui_di_component_ApplicationComponent_getTaskStroge(
        ApplicationComponent applicationComponent) {
      this.applicationComponent = applicationComponent;
    }

    @Override
    public TaskStroge get() {
      return Preconditions.checkNotNull(
          applicationComponent.getTaskStroge(),
          "Cannot return null from a non-@Nullable component method");
    }
  }

  private static class cn_connxun_morui_di_component_ApplicationComponent_getContext
      implements Provider<Context> {
    private final ApplicationComponent applicationComponent;

    cn_connxun_morui_di_component_ApplicationComponent_getContext(
        ApplicationComponent applicationComponent) {
      this.applicationComponent = applicationComponent;
    }

    @Override
    public Context get() {
      return Preconditions.checkNotNull(
          applicationComponent.getContext(),
          "Cannot return null from a non-@Nullable component method");
    }
  }

  private static class cn_connxun_morui_di_component_ApplicationComponent_getNoticeStorge
      implements Provider<NoticeStorge> {
    private final ApplicationComponent applicationComponent;

    cn_connxun_morui_di_component_ApplicationComponent_getNoticeStorge(
        ApplicationComponent applicationComponent) {
      this.applicationComponent = applicationComponent;
    }

    @Override
    public NoticeStorge get() {
      return Preconditions.checkNotNull(
          applicationComponent.getNoticeStorge(),
          "Cannot return null from a non-@Nullable component method");
    }
  }

  private static class cn_connxun_morui_di_component_ApplicationComponent_getNoticeApi
      implements Provider<NoticeApi> {
    private final ApplicationComponent applicationComponent;

    cn_connxun_morui_di_component_ApplicationComponent_getNoticeApi(
        ApplicationComponent applicationComponent) {
      this.applicationComponent = applicationComponent;
    }

    @Override
    public NoticeApi get() {
      return Preconditions.checkNotNull(
          applicationComponent.getNoticeApi(),
          "Cannot return null from a non-@Nullable component method");
    }
  }
}
