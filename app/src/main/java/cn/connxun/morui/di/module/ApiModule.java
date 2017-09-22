package cn.connxun.morui.di.module;

import javax.inject.Singleton;

import cn.connxun.morui.api.AccountApi;
import cn.connxun.morui.api.ContactsApi;
import cn.connxun.morui.api.DocumentApi;
import cn.connxun.morui.api.NoticeApi;
import cn.connxun.morui.api.PlanApi;
import cn.connxun.morui.api.RectificationApi;
import cn.connxun.morui.api.TaskApi;
import cn.connxun.morui.api.TokenApi;
import cn.connxun.morui.components.retrofit.RequestHelper;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class ApiModule {
    @Provides
    @Singleton
    public TokenApi provideTokenApi(OkHttpClient okHttpClient) {
        return new TokenApi(okHttpClient);
    }

    @Provides
    @Singleton
    public AccountApi provideAccountApi(RequestHelper helper, OkHttpClient.Builder okHttpClient) {
        return new AccountApi(helper, okHttpClient);
    }

    @Provides
    @Singleton
    public DocumentApi provideDocumentApi(RequestHelper helper, OkHttpClient.Builder okHttpClient) {
        return new DocumentApi(helper, okHttpClient);
    }

    @Provides
    @Singleton
    public NoticeApi provideNoticeApi(RequestHelper helper, OkHttpClient.Builder okHttpClient) {
        return new NoticeApi(helper, okHttpClient);
    }

    @Provides
    @Singleton
    public PlanApi providePlanApi(RequestHelper helper, OkHttpClient.Builder okHttpClient) {
        return new PlanApi(helper, okHttpClient);
    }

    @Provides
    @Singleton
    public ContactsApi provideContactsApi(RequestHelper helper, OkHttpClient.Builder okHttpClient) {
        return new ContactsApi(helper, okHttpClient);
    }
    @Provides
    @Singleton
    public TaskApi provideTaskApi(RequestHelper helper, OkHttpClient.Builder okHttpClient) {
        return new TaskApi(helper, okHttpClient);
    }
    @Provides
    @Singleton
    public RectificationApi provideRectificationApi(RequestHelper helper, OkHttpClient.Builder okHttpClient) {
        return new RectificationApi(helper, okHttpClient);
    }
}
