package cn.connxun.morui.ui.task.taskallot;


import java.util.List;

import cn.connxun.morui.entity.AllotUser;
import cn.connxun.morui.entity.Task_Allot;
import cn.connxun.morui.ui.base.BasePView;

/**
 * Created by sll on 2016/5/11.
 */
public interface TaskAllotContract {
    interface TaskAllotView extends BasePView {

        void removeTask(int oldPos);

        void onUserList(int oldTask, List<AllotUser> users);

        void showList(List<Task_Allot> tasks);
    }

    interface TaskAllotPresenter {
        void getAllotList();

        void getAllotedList();

        void getAllotUsers(int oldTask);

        void allotmentTask(int oldPos,List<Task_Allot> jsonStr);

    }
}
