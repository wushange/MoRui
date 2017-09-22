package cn.connxun.morui.di.component;

import android.content.Context;
import android.view.LayoutInflater;

import javax.inject.Singleton;

import cn.connxun.morui.MyApplication;
import cn.connxun.morui.api.AccountApi;
import cn.connxun.morui.api.ContactsApi;
import cn.connxun.morui.api.DocumentApi;
import cn.connxun.morui.api.NoticeApi;
import cn.connxun.morui.api.PlanApi;
import cn.connxun.morui.api.TaskApi;
import cn.connxun.morui.api.TokenApi;
import cn.connxun.morui.components.retrofit.RequestHelper;
import cn.connxun.morui.data.local.ContactsStorge;
import cn.connxun.morui.data.local.DocumentStorge;
import cn.connxun.morui.data.local.NoticeStorge;
import cn.connxun.morui.data.local.TaskStroge;
import cn.connxun.morui.data.local.UserStorge;
import cn.connxun.morui.db.ContactsDao;
import cn.connxun.morui.db.DocumentDao;
import cn.connxun.morui.db.NoticeDao;
import cn.connxun.morui.db.PlanDetailDao;
import cn.connxun.morui.db.TaskDao;
import cn.connxun.morui.db.TaskSubDao;
import cn.connxun.morui.db.Task_AllotDao;
import cn.connxun.morui.db.UserDao;
import cn.connxun.morui.di.module.ApiModule;
import cn.connxun.morui.di.module.ApplicationModule;
import cn.connxun.morui.di.module.DBModule;
import cn.connxun.morui.ui.base.BaseActivity;
import dagger.Component;
import okhttp3.OkHttpClient;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class, DBModule.class})
public interface ApplicationComponent {
    Context getContext();

    OkHttpClient.Builder getOkHttpClientBuild();

    LayoutInflater getLayoutInflater();

    AccountApi getAccountApi();

    TokenApi getTokenApi();

    TaskApi getTaskApi();

    DocumentApi getDocumentApi();

    NoticeApi getNoticeApi();

    PlanApi getPlanApi();

    ContactsApi getContactsApi();

    RequestHelper getRequestHelper();


    UserStorge getUserStorge();

    ContactsStorge getContactsStorge();

    NoticeStorge getNoticeStorge();

    DocumentStorge getDocumentStorge();

    TaskStroge getTaskStroge();

    UserDao getUserDao();

    ContactsDao getContactsDao();

    NoticeDao getNoticeDao();

    DocumentDao getDocumentDao();

    PlanDetailDao getPlanDetailDao();

    Task_AllotDao getTask_AllotDao();
    TaskDao getTaskDao();

    TaskSubDao getTaskSubDao();

    void inject(MyApplication mApplication);

    void inject(BaseActivity mBaseActivity);
}
