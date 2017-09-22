package cn.connxun.morui.ui.bottomsheet;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.connxun.morui.R;
import cn.connxun.morui.entity.AllotUser;

/**
 * Created by wushange on 2016/11/30.
 */

public class BottomSheetFragment extends com.flipboard.bottomsheet.commons.BottomSheetFragment implements RecyclerArrayAdapter.OnItemClickListener {
    private static final String USERS_TAG = "USERS_TAG";
    @BindView(R.id.easy_recyclerview)
    EasyRecyclerView btmCallList;
    ListAdapter adapter;
    List<AllotUser> userList = new ArrayList<>();
    OnBottomListener onBottomListener;

    public void setBottomListener(OnBottomListener bottomListener) {
        this.onBottomListener = bottomListener;
    }

    public static void showUsers(FragmentManager manager, List<AllotUser> users, OnBottomListener onBottomListener) {
        BottomSheetFragment callFragment = new BottomSheetFragment();
        callFragment.setBottomListener(onBottomListener);
        Bundle bundle = new Bundle();
        bundle.putSerializable(USERS_TAG, (Serializable) users);
        callFragment.setArguments(bundle);
        callFragment.show(manager, R.id.bottomsheet);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_btm_users_view, container, false);
        ButterKnife.bind(this, view);
        btmCallList.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ListAdapter(getContext());
        btmCallList.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
        if (getArguments().getSerializable(USERS_TAG) != null) {
            userList = (List<AllotUser>) getArguments().getSerializable(USERS_TAG);
            adapter.addAll(userList);
        }else {
            btmCallList.showEmpty();
        }
        return view;
    }

    @Override
    public void onItemClick(int position) {
        AllotUser user = adapter.getItem(position);
        onBottomListener.onBottomListener(user,this);
    }


    class ListAdapter extends RecyclerArrayAdapter<AllotUser> {

        public ListAdapter(Context context) {
            super(context);
        }

        @Override
        public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
            return new BottomCallViewHolder(parent);
        }
    }

    class BottomCallViewHolder extends BaseViewHolder<AllotUser> {

        @BindView(R.id.tv_item_taskallot_username)
        TextView tvItemBottomName;

        public BottomCallViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_taskallot_user);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(AllotUser data) {
            super.setData(data);
            tvItemBottomName.setText(data.getRealname());
        }


    }


    public interface OnBottomListener{
        void onBottomListener(AllotUser user,BottomSheetFragment fragment);
    }
}
