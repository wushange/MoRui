package cn.connxun.morui.ui.contacts;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;

import javax.inject.Inject;

import cn.connxun.morui.api.ContactsApi;
import cn.connxun.morui.data.local.ContactsStorge;
import cn.connxun.morui.di.PerActivity;
import cn.connxun.morui.ui.base.BasePresenter;


@PerActivity
public class ContactsPresenter extends BasePresenter<ContactsContract.ContactsView> implements ContactsContract.ContactsPresenter {

    ContactsApi    api;
    ContactsStorge contactsStorge;

    @Inject
    public ContactsPresenter(ContactsApi api, ContactsStorge storge) {
        this.api = api;
        this.contactsStorge = storge;
    }

    @Override
    public void getContactsList() {
        if (!NetworkUtils.isConnected()) {
            LogUtils.e("离线模式准备中...");
            mView.showList(contactsStorge.getList());
            return;
        }
        if (contactsStorge.getList() != null && contactsStorge.getList().size() > 0) {
            mView.showList(contactsStorge.getList());
            return;
        }
        mDisposable.add(api.getList().subscribe(contactses -> {

            contactsStorge.saveList(contactses);
            mView.showList(contactses);
        }, throwable -> {
        }));
    }


}
