package cn.connxun.morui.ui.task.conplan;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.connxun.morui.R;
import cn.connxun.morui.entity.PlanDetail;

/**
 * Created by wushange on 2017/7/19.
 */

public class ConplanAdapter extends RecyclerArrayAdapter<PlanDetail> {

    @Inject
    public ConplanAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }

    class ViewHolder extends BaseViewHolder<PlanDetail> {


        @BindView(R.id.tv_item_conplan_title)
        TextView tvItemConplanTitle;

        public ViewHolder(ViewGroup group) {
            super(group, R.layout.item_conplan);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(PlanDetail data) {
            super.setData(data);
            tvItemConplanTitle.setText(data.getName());
        }
    }


}
