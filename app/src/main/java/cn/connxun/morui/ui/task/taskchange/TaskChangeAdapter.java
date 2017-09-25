package cn.connxun.morui.ui.task.taskchange;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.connxun.morui.R;
import cn.connxun.morui.entity.InspectionRectification;

/**
 * Created by wushange on 2017/7/19.
 */

public class TaskChangeAdapter extends RecyclerArrayAdapter<InspectionRectification> {
    OnItemButtonClickListener onItemButtonClickListener;

    public OnItemButtonClickListener getOnItemButtonClickListener() {
        return onItemButtonClickListener;
    }

    public void setOnItemButtonClickListener(OnItemButtonClickListener onItemButtonClickListener) {
        this.onItemButtonClickListener = onItemButtonClickListener;
    }

    @Inject
    public TaskChangeAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }

    class ViewHolder extends BaseViewHolder<InspectionRectification> {


        @BindView(R.id.tv_item_task_name)
        TextView tvItemTaskName;
        @BindView(R.id.tv_item_task_status)
        TextView tvItemTaskStatus;
        @BindView(R.id.tv_item_task_shenfen)
        TextView tvItemTaskShenfen;
        @BindView(R.id.tv_item_task_instime)
        TextView tvItemTaskInstime;
        @BindView(R.id.tv_item_task_synctime)
        TextView tvItemTaskSynctime;
        @BindView(R.id.btn_taskoper)
        Button   btnTaskoper;

        public ViewHolder(ViewGroup group) {
            super(group, R.layout.item_task_inspect);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(InspectionRectification data) {
            super.setData(data);
            tvItemTaskName.setText("任务:" + data.getPointName());
            tvItemTaskInstime.setText("检查点:" + data.getName());
            tvItemTaskSynctime.setText("专项资金:" + data.getSpecialFunds());
            if (0 == data.getStatus()) {
                tvItemTaskStatus.setText("未整改");
                tvItemTaskStatus.setTextColor(getContext().getResources().getColor(R.color.nocheck));
            } else {
                tvItemTaskStatus.setTextColor(Color.GREEN);
                tvItemTaskStatus.setText("整改完成");
            }
            btnTaskoper.setText("查看详情");
            btnTaskoper.setOnClickListener(v -> onItemButtonClickListener.OnItemButtonClickListener(itemView, data));

        }
    }


    interface OnItemButtonClickListener {
        void OnItemButtonClickListener(View v, InspectionRectification da);
    }
}
