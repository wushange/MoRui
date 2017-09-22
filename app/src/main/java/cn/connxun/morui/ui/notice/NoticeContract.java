package cn.connxun.morui.ui.notice;


import cn.connxun.morui.entity.ListBean;
import cn.connxun.morui.entity.Notice;
import cn.connxun.morui.ui.base.BasePView;

/**
 * Created by sll on 2016/5/11.
 */
public interface NoticeContract {
    interface   NoticeView extends BasePView {
        void showList(ListBean<Notice> list);
        String getPage();
        String getNoticeType();
    }

    interface  NoticePresenter {
        void getList();
    }
}
