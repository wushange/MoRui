package cn.connxun.morui.ui.task.historyrecord;


import java.util.List;

import cn.connxun.morui.entity.Task;
import cn.connxun.morui.ui.base.BasePView;

/**
 * Created by sll on 2016/5/11.
 */
public interface HistoryRecordContract {
    interface  HistoryRecordView extends BasePView {
        void showList(List<Task> list);
    }

    interface HistoryRecordPresenter {
        void getTaskList();
    }
}
