package cn.connxun.morui.ui.contacts;


import java.util.List;

import cn.connxun.morui.entity.Contacts;
import cn.connxun.morui.ui.base.BasePView;

/**
 * Created by sll on 2016/5/11.
 */
public interface ContactsContract {
    interface  ContactsView extends BasePView {
        void showList(List<Contacts> list);
    }

    interface ContactsPresenter {
        void getContactsList();
    }
}
