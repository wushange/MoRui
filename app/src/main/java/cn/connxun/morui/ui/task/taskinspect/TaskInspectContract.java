package cn.connxun.morui.ui.task.taskinspect;


import java.util.List;

import cn.connxun.morui.entity.Task;
import cn.connxun.morui.ui.base.BasePView;

/**
 * Created by sll on 2016/5/11.
 */
public interface TaskInspectContract {
    interface TaskInsView extends BasePView {
        void showLoadingView(String string);
        void showList(List<Task> list);
        void showOfflineList(List<Task> list);
        void confirmTaskSuccess(Task task,int pos);
        void gobackTaskSuccess(Task task,int pos);
    }

    interface TaskInsPresenter {
        void confirmTask(Task task,int pos);
        void gobackTask(Task task,int pos);
        void syncTaskList();
        void getOfflineTaskList();
    }
}
