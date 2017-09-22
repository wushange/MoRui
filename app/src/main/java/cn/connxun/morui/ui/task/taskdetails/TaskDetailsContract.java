package cn.connxun.morui.ui.task.taskdetails;


import java.util.List;

import cn.connxun.morui.entity.TaskSub;
import cn.connxun.morui.ui.base.BasePView;

/**
 * Created by sll on 2016/5/11.
 */
public interface TaskDetailsContract {
    interface TaskDetailsView extends BasePView {
        String taskId();
        void showList(List<TaskSub> list);
    }

    interface TaskDetailsPresenter {
        void getList();
    }
}
