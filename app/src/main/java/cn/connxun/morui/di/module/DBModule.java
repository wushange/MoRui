package cn.connxun.morui.di.module;

import android.content.Context;

import javax.inject.Singleton;

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
import dagger.Module;
import dagger.Provides;

/**
 * Created by sll on 2015/3/4.
 */
@Module
public class DBModule {

    @Provides
    @Singleton
    MyOpenHelper provideMyOpenHelper(Context context) {
        return new MyOpenHelper(context, "app.db", null);
    }

    @Provides
    @Singleton
    DaoMaster provideDaoMaster(MyOpenHelper helper) {
        return new DaoMaster(helper.getWritableDatabase());
    }

    @Provides
    @Singleton
    DaoSession provideDaoSession(DaoMaster master) {
        return master.newSession();
    }


    @Provides
    @Singleton
    UserDao getUserDao(DaoSession session) {
        return session.getUserDao();
    }

    @Provides
    @Singleton
    ContactsDao getContactsDao(DaoSession session) {
        return session.getContactsDao();
    }

    @Provides
    @Singleton
    NoticeDao getNoticeDao(DaoSession session) {
        return session.getNoticeDao();
    }

    @Provides
    @Singleton
    DocumentDao getDocumentDao(DaoSession session) {
        return session.getDocumentDao();
    }

    @Provides
    @Singleton
    PlanDetailDao getPlanDetailDao(DaoSession session) {
        return session.getPlanDetailDao();
    }
    @Provides
    @Singleton
    Task_AllotDao getTask_AllotDao(DaoSession session) {
        return session.getTask_AllotDao();
    }
    @Provides
    @Singleton
    TaskDao getTaskDao(DaoSession session) {
        return session.getTaskDao();
    }
    @Provides
    @Singleton
    TaskSubDao getTaskSubDao(DaoSession session) {
        return session.getTaskSubDao();
    }
    @Provides
    @Singleton
    AllotUserDao getAllotUserDao(DaoSession session) {
        return session.getAllotUserDao();
    }
}
