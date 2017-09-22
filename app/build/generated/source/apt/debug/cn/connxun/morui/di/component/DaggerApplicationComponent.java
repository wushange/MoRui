package cn.connxun.morui.di.component;

import android.content.Context;
import android.view.LayoutInflater;
import cn.connxun.morui.MyApplication;
import cn.connxun.morui.api.AccountApi;
import cn.connxun.morui.api.ContactsApi;
import cn.connxun.morui.api.DocumentApi;
import cn.connxun.morui.api.NoticeApi;
import cn.connxun.morui.api.PlanApi;
import cn.connxun.morui.api.RectificationApi;
import cn.connxun.morui.api.TaskApi;
import cn.connxun.morui.api.TokenApi;
import cn.connxun.morui.components.retrofit.RequestHelper;
import cn.connxun.morui.data.local.ContactsStorge;
import cn.connxun.morui.data.local.DocumentStorge;
import cn.connxun.morui.data.local.NoticeStorge;
import cn.connxun.morui.data.local.TaskStroge;
import cn.connxun.morui.data.local.UserStorge;
import cn.connxun.morui.db.AllotUserDao;
import cn.connxun.morui.db.ContactsDao;
import cn.connxun.morui.db.DaoMaster;
import cn.connxun.morui.db.DaoSession;
import cn.connxun.morui.db.DocumentDao;
import cn.connxun.morui.db.MyOpenHelper;
import cn.connxun.morui.db.NoticeDao;
import cn.connxun.morui.db.PlanDetailDao;
import cn.connxun.morui.db.TaskDao;
import cn.connxun.morui.db.TaskSubDao;
import cn.connxun.morui.db.Task_AllotDao;
import cn.connxun.morui.db.UserDao;
import cn.connxun.morui.di.module.ApiModule;
import cn.connxun.morui.di.module.ApiModule_ProvideAccountApiFactory;
import cn.connxun.morui.di.module.ApiModule_ProvideContactsApiFactory;
import cn.connxun.morui.di.module.ApiModule_ProvideDocumentApiFactory;
import cn.connxun.morui.di.module.ApiModule_ProvideNoticeApiFactory;
import cn.connxun.morui.di.module.ApiModule_ProvidePlanApiFactory;
import cn.connxun.morui.di.module.ApiModule_ProvideRectificationApiFactory;
import cn.connxun.morui.di.module.ApiModule_ProvideTaskApiFactory;
import cn.connxun.morui.di.module.ApiModule_ProvideTokenApiFactory;
import cn.connxun.morui.di.module.ApplicationModule;
import cn.connxun.morui.di.module.ApplicationModule_ProvideApplicationContextFactory;
import cn.connxun.morui.di.module.ApplicationModule_ProvideContactsStorgeFactory;
import cn.connxun.morui.di.module.ApplicationModule_ProvideDocumentStorgeFactory;
import cn.connxun.morui.di.module.ApplicationModule_ProvideLayoutInflaterFactory;
import cn.connxun.morui.di.module.ApplicationModule_ProvideNoticeStorgeFactory;
import cn.connxun.morui.di.module.ApplicationModule_ProvideOkHttpClientBuildFactory;
import cn.connxun.morui.di.module.ApplicationModule_ProvideOkHttpClientFactory;
import cn.connxun.morui.di.module.ApplicationModule_ProvideRequestHelperFactory;
import cn.connxun.morui.di.module.ApplicationModule_ProvideTaskStrogeFactory;
import cn.connxun.morui.di.module.ApplicationModule_ProvideUserStorgeFactory;
import cn.connxun.morui.di.module.DBModule;
import cn.connxun.morui.di.module.DBModule_GetAllotUserDaoFactory;
import cn.connxun.morui.di.module.DBModule_GetContactsDaoFactory;
import cn.connxun.morui.di.module.DBModule_GetDocumentDaoFactory;
import cn.connxun.morui.di.module.DBModule_GetNoticeDaoFactory;
import cn.connxun.morui.di.module.DBModule_GetPlanDetailDaoFactory;
import cn.connxun.morui.di.module.DBModule_GetTaskDaoFactory;
import cn.connxun.morui.di.module.DBModule_GetTaskSubDaoFactory;
import cn.connxun.morui.di.module.DBModule_GetTask_AllotDaoFactory;
import cn.connxun.morui.di.module.DBModule_GetUserDaoFactory;
import cn.connxun.morui.di.module.DBModule_ProvideDaoMasterFactory;
import cn.connxun.morui.di.module.DBModule_ProvideDaoSessionFactory;
import cn.connxun.morui.di.module.DBModule_ProvideMyOpenHelperFactory;
import cn.connxun.morui.ui.base.BaseActivity;
import dagger.internal.DoubleCheck;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<Context> provideApplicationContextProvider;

  private Provider<OkHttpClient.Builder> provideOkHttpClientBuildProvider;

  private Provider<LayoutInflater> provideLayoutInflaterProvider;

  private Provider<MyOpenHelper> provideMyOpenHelperProvider;

  private Provider<DaoMaster> provideDaoMasterProvider;

  private Provider<DaoSession> provideDaoSessionProvider;

  private Provider<UserDao> getUserDaoProvider;

  private Provider<AllotUserDao> getAllotUserDaoProvider;

  private Provider<UserStorge> provideUserStorgeProvider;

  private Provider<RequestHelper> provideRequestHelperProvider;

  private Provider<AccountApi> provideAccountApiProvider;

  private Provider<OkHttpClient> provideOkHttpClientProvider;

  private Provider<TokenApi> provideTokenApiProvider;

  private Provider<TaskApi> provideTaskApiProvider;

  private Provider<RectificationApi> provideRectificationApiProvider;

  private Provider<DocumentApi> provideDocumentApiProvider;

  private Provider<NoticeApi> provideNoticeApiProvider;

  private Provider<PlanApi> providePlanApiProvider;

  private Provider<ContactsApi> provideContactsApiProvider;

  private Provider<ContactsDao> getContactsDaoProvider;

  private Provider<ContactsStorge> provideContactsStorgeProvider;

  private Provider<NoticeDao> getNoticeDaoProvider;

  private Provider<NoticeStorge> provideNoticeStorgeProvider;

  private Provider<DocumentDao> getDocumentDaoProvider;

  private Provider<DocumentStorge> provideDocumentStorgeProvider;

  private Provider<TaskDao> getTaskDaoProvider;

  private Provider<TaskSubDao> getTaskSubDaoProvider;

  private Provider<Task_AllotDao> getTask_AllotDaoProvider;

  private Provider<TaskStroge> provideTaskStrogeProvider;

  private Provider<PlanDetailDao> getPlanDetailDaoProvider;

  private DaggerApplicationComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideApplicationContextProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideApplicationContextFactory.create(builder.applicationModule));

    this.provideOkHttpClientBuildProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideOkHttpClientBuildFactory.create(builder.applicationModule));

    this.provideLayoutInflaterProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideLayoutInflaterFactory.create(
                builder.applicationModule, provideApplicationContextProvider));

    this.provideMyOpenHelperProvider =
        DoubleCheck.provider(
            DBModule_ProvideMyOpenHelperFactory.create(
                builder.dBModule, provideApplicationContextProvider));

    this.provideDaoMasterProvider =
        DoubleCheck.provider(
            DBModule_ProvideDaoMasterFactory.create(builder.dBModule, provideMyOpenHelperProvider));

    this.provideDaoSessionProvider =
        DoubleCheck.provider(
            DBModule_ProvideDaoSessionFactory.create(builder.dBModule, provideDaoMasterProvider));

    this.getUserDaoProvider =
        DoubleCheck.provider(
            DBModule_GetUserDaoFactory.create(builder.dBModule, provideDaoSessionProvider));

    this.getAllotUserDaoProvider =
        DoubleCheck.provider(
            DBModule_GetAllotUserDaoFactory.create(builder.dBModule, provideDaoSessionProvider));

    this.provideUserStorgeProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideUserStorgeFactory.create(
                builder.applicationModule,
                provideApplicationContextProvider,
                getUserDaoProvider,
                getAllotUserDaoProvider));

    this.provideRequestHelperProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideRequestHelperFactory.create(
                builder.applicationModule,
                provideApplicationContextProvider,
                provideUserStorgeProvider));

    this.provideAccountApiProvider =
        DoubleCheck.provider(
            ApiModule_ProvideAccountApiFactory.create(
                builder.apiModule, provideRequestHelperProvider, provideOkHttpClientBuildProvider));

    this.provideOkHttpClientProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideOkHttpClientFactory.create(builder.applicationModule));

    this.provideTokenApiProvider =
        DoubleCheck.provider(
            ApiModule_ProvideTokenApiFactory.create(
                builder.apiModule, provideOkHttpClientProvider));

    this.provideTaskApiProvider =
        DoubleCheck.provider(
            ApiModule_ProvideTaskApiFactory.create(
                builder.apiModule, provideRequestHelperProvider, provideOkHttpClientBuildProvider));

    this.provideRectificationApiProvider =
        DoubleCheck.provider(
            ApiModule_ProvideRectificationApiFactory.create(
                builder.apiModule, provideRequestHelperProvider, provideOkHttpClientBuildProvider));

    this.provideDocumentApiProvider =
        DoubleCheck.provider(
            ApiModule_ProvideDocumentApiFactory.create(
                builder.apiModule, provideRequestHelperProvider, provideOkHttpClientBuildProvider));

    this.provideNoticeApiProvider =
        DoubleCheck.provider(
            ApiModule_ProvideNoticeApiFactory.create(
                builder.apiModule, provideRequestHelperProvider, provideOkHttpClientBuildProvider));

    this.providePlanApiProvider =
        DoubleCheck.provider(
            ApiModule_ProvidePlanApiFactory.create(
                builder.apiModule, provideRequestHelperProvider, provideOkHttpClientBuildProvider));

    this.provideContactsApiProvider =
        DoubleCheck.provider(
            ApiModule_ProvideContactsApiFactory.create(
                builder.apiModule, provideRequestHelperProvider, provideOkHttpClientBuildProvider));

    this.getContactsDaoProvider =
        DoubleCheck.provider(
            DBModule_GetContactsDaoFactory.create(builder.dBModule, provideDaoSessionProvider));

    this.provideContactsStorgeProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideContactsStorgeFactory.create(
                builder.applicationModule,
                provideApplicationContextProvider,
                getContactsDaoProvider,
                provideUserStorgeProvider));

    this.getNoticeDaoProvider =
        DoubleCheck.provider(
            DBModule_GetNoticeDaoFactory.create(builder.dBModule, provideDaoSessionProvider));

    this.provideNoticeStorgeProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideNoticeStorgeFactory.create(
                builder.applicationModule,
                provideApplicationContextProvider,
                getNoticeDaoProvider));

    this.getDocumentDaoProvider =
        DoubleCheck.provider(
            DBModule_GetDocumentDaoFactory.create(builder.dBModule, provideDaoSessionProvider));

    this.provideDocumentStorgeProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideDocumentStorgeFactory.create(
                builder.applicationModule,
                provideApplicationContextProvider,
                getDocumentDaoProvider));

    this.getTaskDaoProvider =
        DoubleCheck.provider(
            DBModule_GetTaskDaoFactory.create(builder.dBModule, provideDaoSessionProvider));

    this.getTaskSubDaoProvider =
        DoubleCheck.provider(
            DBModule_GetTaskSubDaoFactory.create(builder.dBModule, provideDaoSessionProvider));

    this.getTask_AllotDaoProvider =
        DoubleCheck.provider(
            DBModule_GetTask_AllotDaoFactory.create(builder.dBModule, provideDaoSessionProvider));

    this.provideTaskStrogeProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideTaskStrogeFactory.create(
                builder.applicationModule,
                provideApplicationContextProvider,
                getTaskDaoProvider,
                getTaskSubDaoProvider,
                getTask_AllotDaoProvider,
                provideUserStorgeProvider));

    this.getPlanDetailDaoProvider =
        DoubleCheck.provider(
            DBModule_GetPlanDetailDaoFactory.create(builder.dBModule, provideDaoSessionProvider));
  }

  @Override
  public Context getContext() {
    return provideApplicationContextProvider.get();
  }

  @Override
  public OkHttpClient.Builder getOkHttpClientBuild() {
    return provideOkHttpClientBuildProvider.get();
  }

  @Override
  public LayoutInflater getLayoutInflater() {
    return provideLayoutInflaterProvider.get();
  }

  @Override
  public AccountApi getAccountApi() {
    return provideAccountApiProvider.get();
  }

  @Override
  public TokenApi getTokenApi() {
    return provideTokenApiProvider.get();
  }

  @Override
  public TaskApi getTaskApi() {
    return provideTaskApiProvider.get();
  }

  @Override
  public RectificationApi getRectificationApi() {
    return provideRectificationApiProvider.get();
  }

  @Override
  public DocumentApi getDocumentApi() {
    return provideDocumentApiProvider.get();
  }

  @Override
  public NoticeApi getNoticeApi() {
    return provideNoticeApiProvider.get();
  }

  @Override
  public PlanApi getPlanApi() {
    return providePlanApiProvider.get();
  }

  @Override
  public ContactsApi getContactsApi() {
    return provideContactsApiProvider.get();
  }

  @Override
  public RequestHelper getRequestHelper() {
    return provideRequestHelperProvider.get();
  }

  @Override
  public UserStorge getUserStorge() {
    return provideUserStorgeProvider.get();
  }

  @Override
  public ContactsStorge getContactsStorge() {
    return provideContactsStorgeProvider.get();
  }

  @Override
  public NoticeStorge getNoticeStorge() {
    return provideNoticeStorgeProvider.get();
  }

  @Override
  public DocumentStorge getDocumentStorge() {
    return provideDocumentStorgeProvider.get();
  }

  @Override
  public TaskStroge getTaskStroge() {
    return provideTaskStrogeProvider.get();
  }

  @Override
  public UserDao getUserDao() {
    return getUserDaoProvider.get();
  }

  @Override
  public ContactsDao getContactsDao() {
    return getContactsDaoProvider.get();
  }

  @Override
  public NoticeDao getNoticeDao() {
    return getNoticeDaoProvider.get();
  }

  @Override
  public DocumentDao getDocumentDao() {
    return getDocumentDaoProvider.get();
  }

  @Override
  public PlanDetailDao getPlanDetailDao() {
    return getPlanDetailDaoProvider.get();
  }

  @Override
  public Task_AllotDao getTask_AllotDao() {
    return getTask_AllotDaoProvider.get();
  }

  @Override
  public TaskDao getTaskDao() {
    return getTaskDaoProvider.get();
  }

  @Override
  public TaskSubDao getTaskSubDao() {
    return getTaskSubDaoProvider.get();
  }

  @Override
  public void inject(MyApplication mApplication) {
    MembersInjectors.<MyApplication>noOp().injectMembers(mApplication);
  }

  @Override
  public void inject(BaseActivity mBaseActivity) {
    MembersInjectors.<BaseActivity>noOp().injectMembers(mBaseActivity);
  }

  public static final class Builder {
    private ApplicationModule applicationModule;

    private DBModule dBModule;

    private ApiModule apiModule;

    private Builder() {}

    public ApplicationComponent build() {
      if (applicationModule == null) {
        throw new IllegalStateException(
            ApplicationModule.class.getCanonicalName() + " must be set");
      }
      if (dBModule == null) {
        this.dBModule = new DBModule();
      }
      if (apiModule == null) {
        this.apiModule = new ApiModule();
      }
      return new DaggerApplicationComponent(this);
    }

    public Builder applicationModule(ApplicationModule applicationModule) {
      this.applicationModule = Preconditions.checkNotNull(applicationModule);
      return this;
    }

    public Builder apiModule(ApiModule apiModule) {
      this.apiModule = Preconditions.checkNotNull(apiModule);
      return this;
    }

    public Builder dBModule(DBModule dBModule) {
      this.dBModule = Preconditions.checkNotNull(dBModule);
      return this;
    }
  }
}
