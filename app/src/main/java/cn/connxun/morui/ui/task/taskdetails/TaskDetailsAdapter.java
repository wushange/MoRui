package cn.connxun.morui.ui.task.taskdetails;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.connxun.morui.R;
import cn.connxun.morui.constants.enums.TASKSUB_CHECK_RESULT;
import cn.connxun.morui.entity.TaskSub;

/**
 * Created by wushange on 2017/7/19.
 */

public class TaskDetailsAdapter extends RecyclerArrayAdapter<TaskSub> {

    @Inject
    public TaskDetailsAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }

    class ViewHolder extends BaseViewHolder<TaskSub> {


        @BindView(R.id.tv_item_task_dt_tag)
        TextView tvItemTaskDtTag;
        @BindView(R.id.tv_item_task_dt_params)
        TextView tvItemTaskDtParams;
        @BindView(R.id.tv_item_task_dt_result)
        TextView tvItemTaskDtResult;

        public ViewHolder(ViewGroup group) {
            super(group, R.layout.item_task_details);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(TaskSub data) {
            super.setData(data);
            tvItemTaskDtTag.setText(data.getPointName());
            if(data.getIsSubJudge()==0){
                if (data.getCheckResultValue() != null&& data.getUnit() != null) {
                        tvItemTaskDtParams.setText("" + data.getCheckResultValue() + data.getUnit());
                }
            }else{
                if (data.getCheckResult() != null) {
                    tvItemTaskDtParams.setText(data.getCheckResult().equals(TASKSUB_CHECK_RESULT.NORMAL.value()+"") ? "正常" : "异常");
                }
            }
            if (data.getCheckResult() != null) {
            if (data.getCheckResult().equals(TASKSUB_CHECK_RESULT.NORMAL.value()+"")) {
                tvItemTaskDtResult.setText("正常");
                tvItemTaskDtResult.setTextColor(getContext().getResources().getColor(android.R.color.holo_green_light));
            } else {
                tvItemTaskDtResult.setText("异常");
                tvItemTaskDtResult.setTextColor(getContext().getResources().getColor(android.R.color.holo_red_light));
            }}
        }
    }


}
