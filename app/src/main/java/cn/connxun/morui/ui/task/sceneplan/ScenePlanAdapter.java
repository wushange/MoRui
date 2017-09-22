package cn.connxun.morui.ui.task.sceneplan;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.connxun.morui.R;
import cn.connxun.morui.entity.ConplanBean;

/**
 * Created by wushange on 2017/7/19.
 */

public class ScenePlanAdapter extends RecyclerArrayAdapter<ConplanBean> {

    @Inject
    public ScenePlanAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }

    class ViewHolder extends BaseViewHolder<ConplanBean> {


        @BindView(R.id.tv_item_conplan_title)
        TextView tvItemConplanTitle;
        @BindView(R.id.tv_item_conplan_subtitle)
        TextView tvItemConplanSubtitle;
        @BindView(R.id.tv_item_conplan_content)
        TextView tvItemConplanContent;

        public ViewHolder(ViewGroup group) {
            super(group, R.layout.item_scener_conplan);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(ConplanBean data) {
            super.setData(data);
            tvItemConplanTitle.setText(data.getCpTitle());
            tvItemConplanSubtitle.setText(data.getCpSubTitle());
            tvItemConplanContent.setText(data.getCpContent());
        }
    }


}
