package cn.connxun.morui.ui.task.conplan;


import cn.connxun.morui.entity.ListBean;
import cn.connxun.morui.entity.PlanDetail;
import cn.connxun.morui.ui.base.BasePView;

/**
 * Created by sll on 2016/5/11.
 */
public interface ConplanContract {
    interface  ConplanView extends BasePView {
        void showList(ListBean<PlanDetail> list);
    }

    interface ConplanPresenter {
        void getList();
    }
}
