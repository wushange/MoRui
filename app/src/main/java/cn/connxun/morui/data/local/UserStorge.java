package cn.connxun.morui.data.local;

import android.content.Context;

import java.util.List;

import cn.connxun.morui.data.ACache;
import cn.connxun.morui.db.AllotUserDao;
import cn.connxun.morui.db.UserDao;
import cn.connxun.morui.entity.AllotUser;
import cn.connxun.morui.entity.User;

/**
 * Created by wushange on 2017/8/17.
 */

public class UserStorge {
    private static final String LOCAL_USER_TAG = "local_user";
    private Context mContext;
    private User user;
    private UserDao userDao;
    private AllotUserDao allotUserDao;

    public UserStorge(Context mContext, UserDao userDao, AllotUserDao allotUserDao) {
        this.mContext = mContext;
        this.userDao = userDao;
        this.allotUserDao = allotUserDao;
    }

    public void login(User user) {
        this.user = user;
        userDao.insertOrReplace(user);
        saveSingleLoginUserByAcahe(user);
    }

    public void logout() {
        clearUser();
    }

    public User getUser() {
        if (user != null)
            return user;
        else
            return getSingleLoginUserByAcahe();
    }

    public long getUserId() {
        if (user != null)
            return user.getId();
        else
            return getSingleLoginUserByAcahe().getId();
    }

    public User getUserById(long id) {
        return userDao.queryBuilder().where(UserDao.Properties.Id.eq(id)).build().unique();
    }

    public boolean isOfflineUser(String userName, String userPwd) {
        User user = userDao.queryBuilder().where(UserDao.Properties.Username.eq(userName), (UserDao.Properties.Password.eq(userPwd))).build().unique();
        return user != null;
    }

    public User getOfflineUser(String userName, String userPwd) {
        return userDao.queryBuilder().where(UserDao.Properties.Username.eq(userName), (UserDao.Properties.RealPwd.eq(userPwd))).build().unique();
    }

    private void clearUser() {
        user = null;
        clearSingleLoginUserByAcahe();
    }


    private void saveSingleLoginUserByAcahe(User user) {
        ACache.get(mContext).put(LOCAL_USER_TAG, user);
    }

    private void clearSingleLoginUserByAcahe() {
        ACache.get(mContext).put(LOCAL_USER_TAG, "'");
    }

    private User getSingleLoginUserByAcahe() {
        return (User) ACache.get(mContext).getAsObject(LOCAL_USER_TAG);
    }


    public void saveTaskAllTaskUsers(List<AllotUser> users) {
        for (AllotUser allotTask : users) {
            allotTask.setUserId(getUserId());
            if (allotUserDao.queryBuilder().where(AllotUserDao.Properties.Id.eq(allotTask.getId())).unique() == null) {
                allotUserDao.insertOrReplaceInTx(allotTask);
            }

        }
    }

    public List<AllotUser> getAllotUsers() {
        return allotUserDao._queryUser_AllotUserList(getUserId());
    }
}
