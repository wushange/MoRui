package cn.connxun.morui.ui.task.taskchange;


import java.util.List;

import cn.connxun.morui.entity.InspectionRectification;
import cn.connxun.morui.ui.base.BasePView;

/**
 * Created by sll on 2016/5/11.
 */
public interface TaskChangeContract {
    interface  TaskChangeView extends BasePView {
        void showList(List<InspectionRectification> list);
        void changSuccess();
        String getTaskCId();
        InspectionRectification getInspectionRectification();
    }

    interface TaskChangePresenter {
        void getTaskChangeList();
        void getTaskChangeDetail();
        void changeTask();
    }
}
