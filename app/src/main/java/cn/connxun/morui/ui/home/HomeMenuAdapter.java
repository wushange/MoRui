package cn.connxun.morui.ui.home;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.connxun.morui.R;
import cn.connxun.morui.entity.Menu;

/**
 * Created by wushange on 2017/7/19.
 */

public class HomeMenuAdapter extends RecyclerArrayAdapter<Menu> {

    @Inject
    public HomeMenuAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }

    class ViewHolder extends BaseViewHolder<Menu> {

        @BindView(R.id.iv_item_menu_icon)
        ImageView ivItemMenuIcon;
        @BindView(R.id.tv_item_menu_name)
        TextView tvItemMenuName;

        public ViewHolder(ViewGroup group) {
            super(group, R.layout.item_home_menu);
            ButterKnife.bind(this,itemView);
        }

        @Override
        public void setData(Menu data) {
            super.setData(data);
            ivItemMenuIcon.setImageResource(data.getMenuIcon());
            tvItemMenuName.setText(data.getMenuName());
        }
    }
}
