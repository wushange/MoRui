package cn.connxun.morui.di.component;

import android.app.Activity;
import android.content.Context;
import cn.connxun.morui.api.ContactsApi;
import cn.connxun.morui.api.DocumentApi;
import cn.connxun.morui.api.PlanApi;
import cn.connxun.morui.api.RectificationApi;
import cn.connxun.morui.api.TaskApi;
import cn.connxun.morui.api.TokenApi;
import cn.connxun.morui.components.retrofit.RequestHelper;
import cn.connxun.morui.data.local.ContactsStorge;
import cn.connxun.morui.data.local.DocumentStorge;
import cn.connxun.morui.data.local.TaskStroge;
import cn.connxun.morui.data.local.UserStorge;
import cn.connxun.morui.db.TaskDao;
import cn.connxun.morui.db.TaskSubDao;
import cn.connxun.morui.di.module.ActivityModule;
import cn.connxun.morui.di.module.ActivityModule_ProvideActivityFactory;
import cn.connxun.morui.ui.contacts.ContactsActivity;
import cn.connxun.morui.ui.contacts.ContactsActivity_MembersInjector;
import cn.connxun.morui.ui.contacts.ContactsPresenter;
import cn.connxun.morui.ui.contacts.ContactsPresenter_Factory;
import cn.connxun.morui.ui.filedoc.FileDocActivity;
import cn.connxun.morui.ui.filedoc.FileDocActivity_MembersInjector;
import cn.connxun.morui.ui.filedoc.FileDocAdapter;
import cn.connxun.morui.ui.filedoc.FileDocAdapter_Factory;
import cn.connxun.morui.ui.filedoc.FileDocPresenter;
import cn.connxun.morui.ui.filedoc.FileDocPresenter_Factory;
import cn.connxun.morui.ui.guide.GuideActivity;
import cn.connxun.morui.ui.login.LoginActivity;
import cn.connxun.morui.ui.login.LoginActivity_MembersInjector;
import cn.connxun.morui.ui.login.LoginPresenter;
import cn.connxun.morui.ui.login.LoginPresenter_Factory;
import cn.connxun.morui.ui.notice.NoticeActivity;
import cn.connxun.morui.ui.splash.SplashActivity;
import cn.connxun.morui.ui.splash.SplashActivity_MembersInjector;
import cn.connxun.morui.ui.task.conplan.ConplanActivity;
import cn.connxun.morui.ui.task.conplan.ConplanActivity_MembersInjector;
import cn.connxun.morui.ui.task.conplan.ConplanAdapter;
import cn.connxun.morui.ui.task.conplan.ConplanAdapter_Factory;
import cn.connxun.morui.ui.task.conplan.ConplanDetailActivity;
import cn.connxun.morui.ui.task.conplan.ConplanDetailActivity_MembersInjector;
import cn.connxun.morui.ui.task.conplan.ConplanPresenter;
import cn.connxun.morui.ui.task.conplan.ConplanPresenter_Factory;
import cn.connxun.morui.ui.task.historyrecord.HistoryRecordActivity;
import cn.connxun.morui.ui.task.historyrecord.HistoryRecordActivity_MembersInjector;
import cn.connxun.morui.ui.task.historyrecord.HistoryRecordAdapter;
import cn.connxun.morui.ui.task.historyrecord.HistoryRecordAdapter_Factory;
import cn.connxun.morui.ui.task.historyrecord.HistoryRecordPresenter;
import cn.connxun.morui.ui.task.historyrecord.HistoryRecordPresenter_Factory;
import cn.connxun.morui.ui.task.inspectrecord.InspectRecordActivity;
import cn.connxun.morui.ui.task.inspectrecord.InspectRecordActivity_MembersInjector;
import cn.connxun.morui.ui.task.inspectrecord.InspectRecordAdapter;
import cn.connxun.morui.ui.task.inspectrecord.InspectRecordAdapter_Factory;
import cn.connxun.morui.ui.task.inspectrecord.InspectRecordPresenter;
import cn.connxun.morui.ui.task.inspectrecord.InspectRecordPresenter_Factory;
import cn.connxun.morui.ui.task.sceneplan.ScenePlanActivity;
import cn.connxun.morui.ui.task.sceneplan.ScenePlanActivity_MembersInjector;
import cn.connxun.morui.ui.task.sceneplan.ScenePlanAdapter;
import cn.connxun.morui.ui.task.sceneplan.ScenePlanAdapter_Factory;
import cn.connxun.morui.ui.task.sceneplan.ScenePlanPresenter;
import cn.connxun.morui.ui.task.sceneplan.ScenePlanPresenter_Factory;
import cn.connxun.morui.ui.task.scenevideo.SceneVideoActivity;
import cn.connxun.morui.ui.task.synctask.SyncActivity;
import cn.connxun.morui.ui.task.taskallot.TaskAllotActivity;
import cn.connxun.morui.ui.task.taskchange.TaskChangeActivity;
import cn.connxun.morui.ui.task.taskchange.TaskChangeActivity_MembersInjector;
import cn.connxun.morui.ui.task.taskchange.TaskChangeAdapter;
import cn.connxun.morui.ui.task.taskchange.TaskChangeAdapter_Factory;
import cn.connxun.morui.ui.task.taskchange.TaskChangeDetailActivity;
import cn.connxun.morui.ui.task.taskchange.TaskChangeDetailActivity_MembersInjector;
import cn.connxun.morui.ui.task.taskchange.TaskChangePresenter;
import cn.connxun.morui.ui.task.taskchange.TaskChangePresenter_Factory;
import cn.connxun.morui.ui.task.taskdetails.TaskDetailsActivity;
import cn.connxun.morui.ui.task.taskdetails.TaskDetailsActivity_MembersInjector;
import cn.connxun.morui.ui.task.taskdetails.TaskDetailsAdapter;
import cn.connxun.morui.ui.task.taskdetails.TaskDetailsAdapter_Factory;
import cn.connxun.morui.ui.task.taskdetails.TaskDetailsPresenter;
import cn.connxun.morui.ui.task.taskdetails.TaskDetailsPresenter_Factory;
import cn.connxun.morui.ui.task.taskinspect.TaskInspectActivity;
import cn.connxun.morui.ui.task.taskinspect.TaskInspectActivity_MembersInjector;
import cn.connxun.morui.ui.task.taskinspect.TaskInspectAdapter;
import cn.connxun.morui.ui.task.taskinspect.TaskInspectAdapter_Factory;
import cn.connxun.morui.ui.task.taskinspect.TaskInspectPresenter;
import cn.connxun.morui.ui.task.taskinspect.TaskInspectPresenter_Factory;
import cn.connxun.morui.ui.task.taskstep.TaskStepActivity;
import cn.connxun.morui.ui.task.taskstep.TaskStepActivity_MembersInjector;
import cn.connxun.morui.ui.task.taskstep.TaskStepPresenter;
import cn.connxun.morui.ui.task.taskstep.TaskStepPresenter_Factory;
import cn.connxun.morui.ui.task.tasktag.TaskTagactivity;
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
public final class DaggerActivityComponent implements ActivityComponent {
  private Provider<Activity> provideActivityProvider;

  private Provider<TokenApi> getTokenApiProvider;

  private Provider<UserStorge> getUserStorgeProvider;

  private Provider<RequestHelper> getRequestHelperProvider;

  private Provider<LoginPresenter> loginPresenterProvider;

  private MembersInjector<SplashActivity> splashActivityMembersInjector;

  private MembersInjector<LoginActivity> loginActivityMembersInjector;

  private Provider<TaskApi> getTaskApiProvider;

  private Provider<TaskStroge> getTaskStrogeProvider;

  private Provider<TaskInspectPresenter> taskInspectPresenterProvider;

  private Provider<Context> getContextProvider;

  private Provider<TaskInspectAdapter> taskInspectAdapterProvider;

  private Provider<TaskDao> getTaskDaoProvider;

  private MembersInjector<TaskInspectActivity> taskInspectActivityMembersInjector;

  private Provider<ContactsApi> getContactsApiProvider;

  private Provider<ContactsStorge> getContactsStorgeProvider;

  private Provider<ContactsPresenter> contactsPresenterProvider;

  private MembersInjector<ContactsActivity> contactsActivityMembersInjector;

  private Provider<InspectRecordPresenter> inspectRecordPresenterProvider;

  private Provider<InspectRecordAdapter> inspectRecordAdapterProvider;

  private MembersInjector<InspectRecordActivity> inspectRecordActivityMembersInjector;

  private Provider<HistoryRecordPresenter> historyRecordPresenterProvider;

  private Provider<HistoryRecordAdapter> historyRecordAdapterProvider;

  private MembersInjector<HistoryRecordActivity> historyRecordActivityMembersInjector;

  private Provider<ConplanAdapter> conplanAdapterProvider;

  private Provider<PlanApi> getPlanApiProvider;

  private Provider<ConplanPresenter> conplanPresenterProvider;

  private MembersInjector<ConplanActivity> conplanActivityMembersInjector;

  private Provider<ScenePlanAdapter> scenePlanAdapterProvider;

  private Provider<ScenePlanPresenter> scenePlanPresenterProvider;

  private MembersInjector<ScenePlanActivity> scenePlanActivityMembersInjector;

  private Provider<FileDocAdapter> fileDocAdapterProvider;

  private Provider<DocumentApi> getDocumentApiProvider;

  private Provider<DocumentStorge> getDocumentStorgeProvider;

  private Provider<FileDocPresenter> fileDocPresenterProvider;

  private MembersInjector<FileDocActivity> fileDocActivityMembersInjector;

  private Provider<TaskSubDao> getTaskSubDaoProvider;

  private Provider<TaskDetailsPresenter> taskDetailsPresenterProvider;

  private Provider<TaskDetailsAdapter> taskDetailsAdapterProvider;

  private MembersInjector<TaskDetailsActivity> taskDetailsActivityMembersInjector;

  private MembersInjector<ConplanDetailActivity> conplanDetailActivityMembersInjector;

  private Provider<TaskStepPresenter> taskStepPresenterProvider;

  private MembersInjector<TaskStepActivity> taskStepActivityMembersInjector;

  private Provider<RectificationApi> getRectificationApiProvider;

  private Provider<TaskChangePresenter> taskChangePresenterProvider;

  private Provider<TaskChangeAdapter> taskChangeAdapterProvider;

  private MembersInjector<TaskChangeActivity> taskChangeActivityMembersInjector;

  private MembersInjector<TaskChangeDetailActivity> taskChangeDetailActivityMembersInjector;

  private DaggerActivityComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideActivityProvider =
        DoubleCheck.provider(ActivityModule_ProvideActivityFactory.create(builder.activityModule));

    this.getTokenApiProvider =
        new cn_connxun_morui_di_component_ApplicationComponent_getTokenApi(
            builder.applicationComponent);

    this.getUserStorgeProvider =
        new cn_connxun_morui_di_component_ApplicationComponent_getUserStorge(
            builder.applicationComponent);

    this.getRequestHelperProvider =
        new cn_connxun_morui_di_component_ApplicationComponent_getRequestHelper(
            builder.applicationComponent);

    this.loginPresenterProvider =
        DoubleCheck.provider(
            LoginPresenter_Factory.create(
                MembersInjectors.<LoginPresenter>noOp(),
                getTokenApiProvider,
                getUserStorgeProvider,
                getRequestHelperProvider));

    this.splashActivityMembersInjector =
        SplashActivity_MembersInjector.create(loginPresenterProvider, getUserStorgeProvider);

    this.loginActivityMembersInjector =
        LoginActivity_MembersInjector.create(loginPresenterProvider);

    this.getTaskApiProvider =
        new cn_connxun_morui_di_component_ApplicationComponent_getTaskApi(
            builder.applicationComponent);

    this.getTaskStrogeProvider =
        new cn_connxun_morui_di_component_ApplicationComponent_getTaskStroge(
            builder.applicationComponent);

    this.taskInspectPresenterProvider =
        DoubleCheck.provider(
            TaskInspectPresenter_Factory.create(
                MembersInjectors.<TaskInspectPresenter>noOp(),
                getTaskApiProvider,
                getTaskStrogeProvider));

    this.getContextProvider =
        new cn_connxun_morui_di_component_ApplicationComponent_getContext(
            builder.applicationComponent);

    this.taskInspectAdapterProvider =
        TaskInspectAdapter_Factory.create(
            MembersInjectors.<TaskInspectAdapter>noOp(), getContextProvider);

    this.getTaskDaoProvider =
        new cn_connxun_morui_di_component_ApplicationComponent_getTaskDao(
            builder.applicationComponent);

    this.taskInspectActivityMembersInjector =
        TaskInspectActivity_MembersInjector.create(
            taskInspectPresenterProvider, taskInspectAdapterProvider, getTaskDaoProvider);

    this.getContactsApiProvider =
        new cn_connxun_morui_di_component_ApplicationComponent_getContactsApi(
            builder.applicationComponent);

    this.getContactsStorgeProvider =
        new cn_connxun_morui_di_component_ApplicationComponent_getContactsStorge(
            builder.applicationComponent);

    this.contactsPresenterProvider =
        DoubleCheck.provider(
            ContactsPresenter_Factory.create(
                MembersInjectors.<ContactsPresenter>noOp(),
                getContactsApiProvider,
                getContactsStorgeProvider));

    this.contactsActivityMembersInjector =
        ContactsActivity_MembersInjector.create(contactsPresenterProvider);

    this.inspectRecordPresenterProvider =
        DoubleCheck.provider(
            InspectRecordPresenter_Factory.create(
                MembersInjectors.<InspectRecordPresenter>noOp(), getTaskStrogeProvider));

    this.inspectRecordAdapterProvider =
        InspectRecordAdapter_Factory.create(
            MembersInjectors.<InspectRecordAdapter>noOp(), getContextProvider);

    this.inspectRecordActivityMembersInjector =
        InspectRecordActivity_MembersInjector.create(
            inspectRecordPresenterProvider, inspectRecordAdapterProvider);

    this.historyRecordPresenterProvider =
        DoubleCheck.provider(
            HistoryRecordPresenter_Factory.create(
                MembersInjectors.<HistoryRecordPresenter>noOp(), getTaskApiProvider));

    this.historyRecordAdapterProvider =
        HistoryRecordAdapter_Factory.create(
            MembersInjectors.<HistoryRecordAdapter>noOp(), getContextProvider);

    this.historyRecordActivityMembersInjector =
        HistoryRecordActivity_MembersInjector.create(
            historyRecordPresenterProvider, historyRecordAdapterProvider);

    this.conplanAdapterProvider =
        ConplanAdapter_Factory.create(MembersInjectors.<ConplanAdapter>noOp(), getContextProvider);

    this.getPlanApiProvider =
        new cn_connxun_morui_di_component_ApplicationComponent_getPlanApi(
            builder.applicationComponent);

    this.conplanPresenterProvider =
        DoubleCheck.provider(
            ConplanPresenter_Factory.create(
                MembersInjectors.<ConplanPresenter>noOp(), getPlanApiProvider));

    this.conplanActivityMembersInjector =
        ConplanActivity_MembersInjector.create(conplanAdapterProvider, conplanPresenterProvider);

    this.scenePlanAdapterProvider =
        ScenePlanAdapter_Factory.create(
            MembersInjectors.<ScenePlanAdapter>noOp(), getContextProvider);

    this.scenePlanPresenterProvider =
        DoubleCheck.provider(
            ScenePlanPresenter_Factory.create(MembersInjectors.<ScenePlanPresenter>noOp()));

    this.scenePlanActivityMembersInjector =
        ScenePlanActivity_MembersInjector.create(
            scenePlanAdapterProvider, scenePlanPresenterProvider);

    this.fileDocAdapterProvider =
        FileDocAdapter_Factory.create(MembersInjectors.<FileDocAdapter>noOp(), getContextProvider);

    this.getDocumentApiProvider =
        new cn_connxun_morui_di_component_ApplicationComponent_getDocumentApi(
            builder.applicationComponent);

    this.getDocumentStorgeProvider =
        new cn_connxun_morui_di_component_ApplicationComponent_getDocumentStorge(
            builder.applicationComponent);

    this.fileDocPresenterProvider =
        DoubleCheck.provider(
            FileDocPresenter_Factory.create(
                MembersInjectors.<FileDocPresenter>noOp(),
                getDocumentApiProvider,
                getDocumentStorgeProvider));

    this.fileDocActivityMembersInjector =
        FileDocActivity_MembersInjector.create(fileDocAdapterProvider, fileDocPresenterProvider);

    this.getTaskSubDaoProvider =
        new cn_connxun_morui_di_component_ApplicationComponent_getTaskSubDao(
            builder.applicationComponent);

    this.taskDetailsPresenterProvider =
        DoubleCheck.provider(
            TaskDetailsPresenter_Factory.create(
                MembersInjectors.<TaskDetailsPresenter>noOp(), getTaskSubDaoProvider));

    this.taskDetailsAdapterProvider =
        TaskDetailsAdapter_Factory.create(
            MembersInjectors.<TaskDetailsAdapter>noOp(), getContextProvider);

    this.taskDetailsActivityMembersInjector =
        TaskDetailsActivity_MembersInjector.create(
            taskDetailsPresenterProvider, taskDetailsAdapterProvider);

    this.conplanDetailActivityMembersInjector =
        ConplanDetailActivity_MembersInjector.create(getPlanApiProvider);

    this.taskStepPresenterProvider =
        DoubleCheck.provider(
            TaskStepPresenter_Factory.create(
                MembersInjectors.<TaskStepPresenter>noOp(),
                getUserStorgeProvider,
                getTaskSubDaoProvider,
                getTaskDaoProvider));

    this.taskStepActivityMembersInjector =
        TaskStepActivity_MembersInjector.create(taskStepPresenterProvider);

    this.getRectificationApiProvider =
        new cn_connxun_morui_di_component_ApplicationComponent_getRectificationApi(
            builder.applicationComponent);

    this.taskChangePresenterProvider =
        DoubleCheck.provider(
            TaskChangePresenter_Factory.create(
                MembersInjectors.<TaskChangePresenter>noOp(), getRectificationApiProvider));

    this.taskChangeAdapterProvider =
        TaskChangeAdapter_Factory.create(
            MembersInjectors.<TaskChangeAdapter>noOp(), getContextProvider);

    this.taskChangeActivityMembersInjector =
        TaskChangeActivity_MembersInjector.create(
            taskChangePresenterProvider, taskChangeAdapterProvider);

    this.taskChangeDetailActivityMembersInjector =
        TaskChangeDetailActivity_MembersInjector.create(taskChangePresenterProvider);
  }

  @Override
  public Activity getActivity() {
    return provideActivityProvider.get();
  }

  @Override
  public void inject(SplashActivity activity) {
    splashActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(LoginActivity baseActivity) {
    loginActivityMembersInjector.injectMembers(baseActivity);
  }

  @Override
  public void inject(TaskAllotActivity baseActivity) {
    MembersInjectors.<TaskAllotActivity>noOp().injectMembers(baseActivity);
  }

  @Override
  public void inject(TaskInspectActivity activity) {
    taskInspectActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(ContactsActivity activity) {
    contactsActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(InspectRecordActivity activity) {
    inspectRecordActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(HistoryRecordActivity activity) {
    historyRecordActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(ConplanActivity activity) {
    conplanActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(ScenePlanActivity activity) {
    scenePlanActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(SceneVideoActivity activity) {
    MembersInjectors.<SceneVideoActivity>noOp().injectMembers(activity);
  }

  @Override
  public void inject(SyncActivity activity) {
    MembersInjectors.<SyncActivity>noOp().injectMembers(activity);
  }

  @Override
  public void inject(GuideActivity activity) {
    MembersInjectors.<GuideActivity>noOp().injectMembers(activity);
  }

  @Override
  public void inject(FileDocActivity activity) {
    fileDocActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(NoticeActivity activity) {
    MembersInjectors.<NoticeActivity>noOp().injectMembers(activity);
  }

  @Override
  public void inject(TaskTagactivity taskTagactivity) {
    MembersInjectors.<TaskTagactivity>noOp().injectMembers(taskTagactivity);
  }

  @Override
  public void inject(TaskDetailsActivity activity) {
    taskDetailsActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(ConplanDetailActivity activity) {
    conplanDetailActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(TaskStepActivity activity) {
    taskStepActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(TaskChangeActivity activity) {
    taskChangeActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(TaskChangeDetailActivity activity) {
    taskChangeDetailActivityMembersInjector.injectMembers(activity);
  }

  public static final class Builder {
    private ActivityModule activityModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public ActivityComponent build() {
      if (activityModule == null) {
        throw new IllegalStateException(ActivityModule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerActivityComponent(this);
    }

    public Builder activityModule(ActivityModule activityModule) {
      this.activityModule = Preconditions.checkNotNull(activityModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }

  private static class cn_connxun_morui_di_component_ApplicationComponent_getTokenApi
      implements Provider<TokenApi> {
    private final ApplicationComponent applicationComponent;

    cn_connxun_morui_di_component_ApplicationComponent_getTokenApi(
        ApplicationComponent applicationComponent) {
      this.applicationComponent = applicationComponent;
    }

    @Override
    public TokenApi get() {
      return Preconditions.checkNotNull(
          applicationComponent.getTokenApi(),
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

  private static class cn_connxun_morui_di_component_ApplicationComponent_getRequestHelper
      implements Provider<RequestHelper> {
    private final ApplicationComponent applicationComponent;

    cn_connxun_morui_di_component_ApplicationComponent_getRequestHelper(
        ApplicationComponent applicationComponent) {
      this.applicationComponent = applicationComponent;
    }

    @Override
    public RequestHelper get() {
      return Preconditions.checkNotNull(
          applicationComponent.getRequestHelper(),
          "Cannot return null from a non-@Nullable component method");
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

  private static class cn_connxun_morui_di_component_ApplicationComponent_getTaskDao
      implements Provider<TaskDao> {
    private final ApplicationComponent applicationComponent;

    cn_connxun_morui_di_component_ApplicationComponent_getTaskDao(
        ApplicationComponent applicationComponent) {
      this.applicationComponent = applicationComponent;
    }

    @Override
    public TaskDao get() {
      return Preconditions.checkNotNull(
          applicationComponent.getTaskDao(),
          "Cannot return null from a non-@Nullable component method");
    }
  }

  private static class cn_connxun_morui_di_component_ApplicationComponent_getContactsApi
      implements Provider<ContactsApi> {
    private final ApplicationComponent applicationComponent;

    cn_connxun_morui_di_component_ApplicationComponent_getContactsApi(
        ApplicationComponent applicationComponent) {
      this.applicationComponent = applicationComponent;
    }

    @Override
    public ContactsApi get() {
      return Preconditions.checkNotNull(
          applicationComponent.getContactsApi(),
          "Cannot return null from a non-@Nullable component method");
    }
  }

  private static class cn_connxun_morui_di_component_ApplicationComponent_getContactsStorge
      implements Provider<ContactsStorge> {
    private final ApplicationComponent applicationComponent;

    cn_connxun_morui_di_component_ApplicationComponent_getContactsStorge(
        ApplicationComponent applicationComponent) {
      this.applicationComponent = applicationComponent;
    }

    @Override
    public ContactsStorge get() {
      return Preconditions.checkNotNull(
          applicationComponent.getContactsStorge(),
          "Cannot return null from a non-@Nullable component method");
    }
  }

  private static class cn_connxun_morui_di_component_ApplicationComponent_getPlanApi
      implements Provider<PlanApi> {
    private final ApplicationComponent applicationComponent;

    cn_connxun_morui_di_component_ApplicationComponent_getPlanApi(
        ApplicationComponent applicationComponent) {
      this.applicationComponent = applicationComponent;
    }

    @Override
    public PlanApi get() {
      return Preconditions.checkNotNull(
          applicationComponent.getPlanApi(),
          "Cannot return null from a non-@Nullable component method");
    }
  }

  private static class cn_connxun_morui_di_component_ApplicationComponent_getDocumentApi
      implements Provider<DocumentApi> {
    private final ApplicationComponent applicationComponent;

    cn_connxun_morui_di_component_ApplicationComponent_getDocumentApi(
        ApplicationComponent applicationComponent) {
      this.applicationComponent = applicationComponent;
    }

    @Override
    public DocumentApi get() {
      return Preconditions.checkNotNull(
          applicationComponent.getDocumentApi(),
          "Cannot return null from a non-@Nullable component method");
    }
  }

  private static class cn_connxun_morui_di_component_ApplicationComponent_getDocumentStorge
      implements Provider<DocumentStorge> {
    private final ApplicationComponent applicationComponent;

    cn_connxun_morui_di_component_ApplicationComponent_getDocumentStorge(
        ApplicationComponent applicationComponent) {
      this.applicationComponent = applicationComponent;
    }

    @Override
    public DocumentStorge get() {
      return Preconditions.checkNotNull(
          applicationComponent.getDocumentStorge(),
          "Cannot return null from a non-@Nullable component method");
    }
  }

  private static class cn_connxun_morui_di_component_ApplicationComponent_getTaskSubDao
      implements Provider<TaskSubDao> {
    private final ApplicationComponent applicationComponent;

    cn_connxun_morui_di_component_ApplicationComponent_getTaskSubDao(
        ApplicationComponent applicationComponent) {
      this.applicationComponent = applicationComponent;
    }

    @Override
    public TaskSubDao get() {
      return Preconditions.checkNotNull(
          applicationComponent.getTaskSubDao(),
          "Cannot return null from a non-@Nullable component method");
    }
  }

  private static class cn_connxun_morui_di_component_ApplicationComponent_getRectificationApi
      implements Provider<RectificationApi> {
    private final ApplicationComponent applicationComponent;

    cn_connxun_morui_di_component_ApplicationComponent_getRectificationApi(
        ApplicationComponent applicationComponent) {
      this.applicationComponent = applicationComponent;
    }

    @Override
    public RectificationApi get() {
      return Preconditions.checkNotNull(
          applicationComponent.getRectificationApi(),
          "Cannot return null from a non-@Nullable component method");
    }
  }
}
