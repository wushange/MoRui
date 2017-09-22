package cn.connxun.morui.di.module;

import android.app.NotificationManager;
import android.content.Context;
import android.view.LayoutInflater;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import cn.connxun.morui.components.okhttp.HttpLoggingInterceptor;
import cn.connxun.morui.components.retrofit.RequestHelper;
import cn.connxun.morui.data.local.ContactsStorge;
import cn.connxun.morui.data.local.DocumentStorge;
import cn.connxun.morui.data.local.NoticeStorge;
import cn.connxun.morui.data.local.TaskStroge;
import cn.connxun.morui.data.local.UserStorge;
import cn.connxun.morui.db.AllotUserDao;
import cn.connxun.morui.db.ContactsDao;
import cn.connxun.morui.db.DocumentDao;
import cn.connxun.morui.db.NoticeDao;
import cn.connxun.morui.db.TaskDao;
import cn.connxun.morui.db.TaskSubDao;
import cn.connxun.morui.db.Task_AllotDao;
import cn.connxun.morui.db.UserDao;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class ApplicationModule {

    private final Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return context.getApplicationContext();
    }

    @Provides
    @Singleton
    OkHttpClient.Builder provideOkHttpClientBuild() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addNetworkInterceptor(new StethoInterceptor());
        builder.addInterceptor(logging);
        return builder;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addNetworkInterceptor(new StethoInterceptor());
        builder.addInterceptor(logging);
        return builder.build();
    }

    @Provides
    @Singleton
    RequestHelper provideRequestHelper(Context mContext, UserStorge userStorge) {
        return new RequestHelper(mContext, userStorge);
    }

    @Provides
    @Singleton
    LayoutInflater provideLayoutInflater(Context context) {
        return (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Provides
    @Singleton
    NotificationManager provideNotificationManager(Context mContext) {
        return (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @Provides
    @Singleton
    UserStorge provideUserStorge(Context mContext, UserDao userDao, AllotUserDao allotUserDao) {
        return new UserStorge(mContext, userDao, allotUserDao);
    }

    @Provides
    @Singleton
    ContactsStorge provideContactsStorge(Context mContext, ContactsDao dao, UserStorge userStorge) {
        return new ContactsStorge(mContext, dao, userStorge);
    }

    @Provides
    @Singleton
    DocumentStorge provideDocumentStorge(Context mContext, DocumentDao dao) {
        return new DocumentStorge(mContext, dao);
    }

    @Provides
    @Singleton
    NoticeStorge provideNoticeStorge(Context mContext, NoticeDao dao) {
        return new NoticeStorge(mContext, dao);
    }

    @Provides
    @Singleton
    TaskStroge provideTaskStroge(Context mContext, TaskDao allotTaskDao, TaskSubDao subListBeanDao, Task_AllotDao allotDao, UserStorge userStorge) {
        return new TaskStroge(mContext, allotTaskDao, subListBeanDao,allotDao, userStorge);
    }

}
