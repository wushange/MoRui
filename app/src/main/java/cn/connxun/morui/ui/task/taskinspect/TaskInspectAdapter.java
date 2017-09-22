package cn.connxun.morui.ui.task.taskinspect;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.stetho.common.LogUtil;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.connxun.morui.R;
import cn.connxun.morui.constants.enums.TASK_STATUS;
import cn.connxun.morui.entity.Task;

/**
 * Created by wushange on 2017/7/19.
 */

public class TaskInspectAdapter extends RecyclerArrayAdapter<Task> {
    OnItemButtonClickListener onItemButtonClickListener;

    public OnItemButtonClickListener getOnItemButtonClickListener() {
        return onItemButtonClickListener;
    }

    public void setOnItemButtonClickListener(OnItemButtonClickListener onItemButtonClickListener) {
        this.onItemButtonClickListener = onItemButtonClickListener;
    }

    @Inject
    public TaskInspectAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }

    class ViewHolder extends BaseViewHolder<Task> {


        @BindView(R.id.tv_item_task_name)
        TextView     tvItemTaskName;
        @BindView(R.id.tv_item_task_status)
        TextView     tvItemTaskStatus;
        @BindView(R.id.tv_item_task_shenfen)
        TextView     tvItemTaskShenfen;
        @BindView(R.id.tv_item_task_instime)
        TextView     tvItemTaskInstime;
        @BindView(R.id.tv_item_task_synctime)
        TextView     tvItemTaskSynctime;
        @BindView(R.id.btn_taskoper)
        Button       btnTaskoper;
        @BindView(R.id.btn_task_goback)
        Button       btnTaskGoback;
        @BindView(R.id.btn_task_configm)
        Button       btnTaskConfigm;
        @BindView(R.id.ll_task_back)
        LinearLayout llTaskBack;

        public ViewHolder(ViewGroup group) {
            super(group, R.layout.item_task_inspect1);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(Task data) {
            super.setData(data);
            LogUtil.e("--item pos -->>>" + getAdapterPosition() + data.toString());
            String status     = "未检查";
            String actionText = "开始检查";
            if (data.getCheckStatus() == TASK_STATUS.NOCHECK.value()) {
                tvItemTaskStatus.setTextColor(getContext().getResources().getColor(R.color.nocheck));
                status = "未检查";
                actionText = "开始巡查";
            } else if (data.getCheckStatus() == TASK_STATUS.CHECKING.value()) {
                tvItemTaskStatus.setTextColor(getContext().getResources().getColor(R.color.checking));
                status = "检查中";
                actionText = "继续巡查";
            } else if (data.getCheckStatus() == TASK_STATUS.CHECKDONE.value()) {
                tvItemTaskStatus.setTextColor(getContext().getResources().getColor(R.color.checking));
                status = "检查完成";
                actionText = "查看巡查结果详情";
            }
            if (TASK_STATUS.ALLOT_ALREADY.value() == data.getStatus()) {
                status = "待确认";
                llTaskBack.setVisibility(View.VISIBLE);
                btnTaskoper.setVisibility(View.GONE);
            } else if (TASK_STATUS.ALLOT_GOBACK.value() == data.getStatus()) {
                status = "已撤回";
                actionText = "已撤回";
                llTaskBack.setVisibility(View.GONE);
                btnTaskoper.setVisibility(View.VISIBLE);
            } else {
                llTaskBack.setVisibility(View.GONE);
                btnTaskoper.setVisibility(View.VISIBLE);
            }
            tvItemTaskName.setText(data.getName());
            tvItemTaskStatus.setText(status);
            tvItemTaskInstime.setText(data.getStartDate());
            tvItemTaskSynctime.setText(data.getEndDate());
            tvItemTaskShenfen.setText(data.getCheckUserName());
            btnTaskoper.setText(actionText);
            btnTaskoper.setOnClickListener(v -> {
                if (TASK_STATUS.ALLOT_GOBACK.value() != data.getStatus())
                    onItemButtonClickListener.OnItemButtonClickListener(getAdapterPosition(), v, data);
            });
            btnTaskGoback.setOnClickListener(v -> onItemButtonClickListener.OnItemButtonClickListener(getAdapterPosition(), v, data));
            btnTaskConfigm.setOnClickListener(v -> onItemButtonClickListener.OnItemButtonClickListener(getAdapterPosition(), v, data));
        }
    }


    interface OnItemButtonClickListener {
        void OnItemButtonClickListener(int pos, View v, Task da);
    }
}
