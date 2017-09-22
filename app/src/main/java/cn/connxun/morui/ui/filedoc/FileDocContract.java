package cn.connxun.morui.ui.filedoc;


import cn.connxun.morui.entity.Document;
import cn.connxun.morui.entity.ListBean;
import cn.connxun.morui.ui.base.BasePView;

/**
 * Created by sll on 2016/5/11.
 */
public interface FileDocContract {
    interface  FileDocView extends BasePView {
        void showList(ListBean<Document> list);
    }

    interface FileDocPresenter {
        void getList();
    }
}
