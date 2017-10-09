package cn.connxun.morui.ui.imageview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.OnViewTapListener;
import com.github.chrisbanes.photoview.PhotoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.connxun.morui.R;
import cn.connxun.morui.ui.base.BaseActivity;

/**
 * Created by wushange on 2017/9/26.
 */

public class ImagePreViewActivity extends BaseActivity {
    private static String TAG = "IMGTAG";
    @BindView(R.id.iv_view)
    PhotoView ivView;

    public static void callMe(Context context, String imgPath) {
        Intent intent = new Intent(context, ImagePreViewActivity.class);
        intent.putExtra(TAG, imgPath);
        context.startActivity(intent);

    }

    String imgPath = "";

    @Override
    public int bindLayout() {
        return R.layout.activity_imge_preview;
    }

    @Override
    public void initParms(Bundle parms) {
        imgPath = parms.getString(TAG);

    }

    @Override
    public void initView(View view) {
        if (imgPath != null) {
            Glide.with(getContext()).load(imgPath)
                    .into(ivView);
            ivView.setOnViewTapListener(new OnViewTapListener() {
                @Override
                public void onViewTap(View view, float x, float y) {
                    finish();
                }
            });
        }
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void initInjector() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
