package cn.connxun.morui.ui.task.inspectrecord;


import java.util.List;

import cn.connxun.morui.entity.Task;
import cn.connxun.morui.ui.base.BasePView;

/**
 * Created by sll on 2016/5/11.
 */
public interface InspectRecordContract {
    interface  InsRecordView extends BasePView {
        void showList(List<Task> list);
    }

    interface InsRecordPresenter {
        void getTaskList();
    }
}
