package cn.connxun.morui.ui.task.taskstep;


import cn.connxun.morui.entity.Task;
import cn.connxun.morui.entity.TaskSub;
import cn.connxun.morui.ui.base.BasePView;

/**
 * Created by sll on 2016/5/11.
 */
public interface TaskStepContract {
    interface TaskStepView extends BasePView {
        int getIndex();

        int getIsSubJudge();

        String getEditText();

        String getTagId();

        void setCurrIndex(int index);
        void indexAdd();

        void indexBack();

        String getThisTaskId();

        void completeTask(Task bean);

        void showConPlan();

        TaskSub getThisTask();

        void renderTaskView(String total, TaskSub allotTaskSubListBean);
    }

    interface TaskStepPresenter {

        void checkTask();

        void completeTask();

        void getLocalTask();

        void save();

        void goLast();
    }
}
