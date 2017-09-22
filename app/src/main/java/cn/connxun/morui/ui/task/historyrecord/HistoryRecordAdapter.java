package cn.connxun.morui.ui.task.historyrecord;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
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
import cn.connxun.morui.entity.Task;

/**
 * Created by wushange on 2017/7/19.
 */

public class HistoryRecordAdapter extends RecyclerArrayAdapter<Task> {
    OnItemButtonClickListener onItemButtonClickListener;

    public OnItemButtonClickListener getOnItemButtonClickListener() {
        return onItemButtonClickListener;
    }

    public void setOnItemButtonClickListener(OnItemButtonClickListener onItemButtonClickListener) {
        this.onItemButtonClickListener = onItemButtonClickListener;
    }

    @Inject
    public HistoryRecordAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }

    class ViewHolder extends BaseViewHolder<Task> {

        @BindView(R.id.tv_item_task_name)
        TextView tvItemTaskName;
        @BindView(R.id.tv_item_task_status)
        TextView tvItemTaskStatus;
        @BindView(R.id.tv_item_task_shenfen)
        TextView tvItemTaskShenfen;
        @BindView(R.id.tv_item_task_startdate)
        TextView tvItemTaskStartdate;
        @BindView(R.id.tv_item_task_endtime)
        TextView tvItemTaskEndtime;
        @BindView(R.id.tv_item_task_update_time)
        TextView tvItemTaskUpdateTime;
        @BindView(R.id.btn_taskoper)
        Button   btnTaskoper;
        @BindView(R.id.listItem)
        CardView listItem;

        public ViewHolder(ViewGroup group) {
            super(group, R.layout.item_task_history);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(Task data) {
            super.setData(data);
            tvItemTaskName.setText(data.getName());
            if (getAdapterPosition() / 2 == 0) {
                tvItemTaskStatus.setText("全部正常");
                tvItemTaskStatus.setTextColor(Color.GREEN);
            } else {
                tvItemTaskStatus.setText("异常点数:" + getAdapterPosition());
                tvItemTaskStatus.setTextColor(Color.RED);
            }
            tvItemTaskStartdate.setText(data.getStartDate());
            tvItemTaskEndtime.setText(data.getEndDate());
            tvItemTaskShenfen.setText(data.getCheckUserName());
            tvItemTaskUpdateTime.setText(data.getUploadDate());
            btnTaskoper.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemButtonClickListener.OnItemButtonClickListener(v, data);
                }
            });
        }
    }


    interface OnItemButtonClickListener {
        void OnItemButtonClickListener(View v, Task da);
    }
}
