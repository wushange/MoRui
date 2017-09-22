package cn.connxun.morui.data.local;

import android.content.Context;

import java.util.List;

import cn.connxun.morui.db.ContactsDao;
import cn.connxun.morui.entity.Contacts;

/**
 * Created by wushange on 2017/8/18.
 */

public class ContactsStorge {

    private Context     context;
    private ContactsDao contactsDao;
    private UserStorge  userStorge;

    public ContactsStorge(Context context, ContactsDao contactsDao, UserStorge userStorge) {
        this.context = context;
        this.contactsDao = contactsDao;
        this.userStorge = userStorge;
    }

    public void saveList(List<Contacts> contactses) {
        for (Contacts contacts : contactses) {
            contacts.setUserId(userStorge.getUserId());
            contactsDao.insertOrReplaceInTx(contacts);
        }
    }

    public List<Contacts> getList() {
        return contactsDao._queryUser_ContactsList(userStorge.getUserId());
    }


}
