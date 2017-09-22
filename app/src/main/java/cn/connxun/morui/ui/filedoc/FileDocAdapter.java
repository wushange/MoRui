package cn.connxun.morui.ui.filedoc;

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
import cn.connxun.morui.entity.Document;

/**
 * Created by wushange on 2017/7/19.
 */

public class FileDocAdapter extends RecyclerArrayAdapter<Document> {

    @Inject
    public FileDocAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }

    class ViewHolder extends BaseViewHolder<Document> {


        @BindView(R.id.iv_item_file_ic)
        ImageView ivItemFileIc;
        @BindView(R.id.tv_item_file_name)
        TextView  tvItemFileName;

        public ViewHolder(ViewGroup group) {
            super(group, R.layout.item_file_doc);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(Document data) {
            super.setData(data);
            tvItemFileName.setText(data.getFileName());
            ivItemFileIc.setImageResource(R.mipmap.ic_item_file_doc);
        }
    }


}
