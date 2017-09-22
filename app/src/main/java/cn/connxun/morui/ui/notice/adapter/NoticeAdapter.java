package cn.connxun.morui.ui.notice.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.connxun.morui.R;
import cn.connxun.morui.entity.Notice;

/**
 * Created by wushange on 2017/7/19.
 */

public class NoticeAdapter extends RecyclerArrayAdapter<Notice> {

    @Inject
    public NoticeAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }

    class ViewHolder extends BaseViewHolder<Notice> {


        @BindView(R.id.tv_item_notice_title)
        TextView tvItemConplanTitle;

        public ViewHolder(ViewGroup group) {
            super(group, R.layout.item_notice);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(Notice data) {
            super.setData(data);
            tvItemConplanTitle.setText(data.getNoticeName());
        }
    }


}
