package cn.connxun.morui.ui.task.taskallot;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import javax.inject.Inject;

import cn.connxun.morui.R;
import cn.connxun.morui.entity.Task_Allot;

public class TaskAllotAdapter extends BaseQuickAdapter<Task_Allot, BaseViewHolder> {


    @Inject
    TaskAllotAdapter() {
        super(R.layout.item_taskallot);
    }

    @Override
    protected void convert(BaseViewHolder helper, Task_Allot item) {
        helper.setText(R.id.tv_taskallot_name, item.getName());
        helper.setText(R.id.tv_task_time, item.getStartDate() + "\n" + item.getEndDate());
        helper.setText(R.id.tv_taskallot_aname, item.getCheckUserName());
        helper.addOnClickListener(R.id.rl_task_person);
    }
}