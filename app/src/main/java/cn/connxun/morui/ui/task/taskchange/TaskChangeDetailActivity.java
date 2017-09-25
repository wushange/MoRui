package cn.connxun.morui.ui.task.taskchange;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.StringUtils;
import com.bumptech.glide.Glide;
import com.orhanobut.logger.Logger;
import com.tbruyelle.rxpermissions2.RxPermissions;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.connxun.morui.R;
import cn.connxun.morui.components.rxjava.RxUtil;
import cn.connxun.morui.constants.Constants;
import cn.connxun.morui.entity.InspectionRectification;
import cn.connxun.morui.ui.base.BaseActivity;
import cn.connxun.morui.ui.base.BaseEvents;
import cn.connxun.morui.utils.ImageUtils;
import cn.finalteam.rxgalleryfinal.RxGalleryFinalApi;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by wushange on 2017/9/22.
 */

public class TaskChangeDetailActivity extends BaseActivity implements TaskChangeContract.TaskChangeView {
    private static final String TASK_ID = "TASK_ID";
    @BindView(R.id.tv_taskc_name)
    TextView  tvTaskcName;
    @BindView(R.id.tv_taskc_pname)
    TextView  tvTaskcPname;
    @BindView(R.id.tv_taskc_dname)
    TextView  tvTaskcDname;
    @BindView(R.id.tv_taskc_money)
    TextView  tvTaskcMoney;
    @BindView(R.id.tv_taskc_postname)
    TextView  tvTaskcPostname;
    @BindView(R.id.btn_taskc_takephoto)
    Button    btnTaskcTakephoto;
    @BindView(R.id.iv_taskc_img)
    ImageView ivTaskcImg;
    @BindView(R.id.iv_taskc_abimg)
    ImageView ivTaskcAbimg;

    public static void callMe(Context context, InspectionRectification taskId) {
        Intent intent = new Intent(context, TaskChangeDetailActivity.class);
        intent.putExtra(TASK_ID, taskId);
        context.startActivity(intent);
    }

    InspectionRectification mTask;

    @Inject
    TaskChangePresenter presenter;

    @Override
    public int bindLayout() {
        return R.layout.activity_task_change_details;
    }

    @Override
    public void initParms(Bundle parms) {
        mTask = (InspectionRectification) parms.get(TASK_ID);
    }

    @Override
    public void initView(View view) {
        presenter.attachView(this);
        tvTaskcName.setText(mTask.getName());
        tvTaskcDname.setText(mTask.getEquipmentName());
        tvTaskcPname.setText(mTask.getPointName());
        tvTaskcMoney.setText(mTask.getSpecialFunds());
        tvTaskcPostname.setText(mTask.getDepartmentName());
        if (0 == mTask.getStatus()) {
            btnTaskcTakephoto.setVisibility(View.VISIBLE);
        } else {
            btnTaskcTakephoto.setVisibility(View.GONE);
        }
        if (!StringUtils.isEmpty(mTask.getAbnormalityImg())) {
            Glide.with(getContext()).load(Constants.HOST+"/upload/"+mTask.getAbnormalityImg()).into(ivTaskcAbimg);
        }
        if (!StringUtils.isEmpty(mTask.getRectificationImg())) {
            Glide.with(getContext()).load(Constants.HOST+"/upload/"+mTask.getRectificationImg()).into(ivTaskcImg);
        }
        btnTaskcTakephoto.setOnClickListener(v -> takePhoto());
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    private void takePhoto() {
        new RxPermissions(getContext()).request(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(granded -> {
                    if (granded) {
                        RxGalleryFinalApi.openZKCamera(this);
                    } else {
                        Toast("请先授予相机权限");
                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RxGalleryFinalApi.TAKE_IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            String imgPath = RxGalleryFinalApi.fileImagePath.getPath();
            Logger.e("拍照OK，图片路径:" + imgPath);
            Toast("采集照片成功！");
            RxUtil.runOnIoThreadTask().observeOn(AndroidSchedulers.mainThread()).subscribe(o -> {
                ivTaskcImg.setImageURI(Uri.fromFile(new File(imgPath)));
                mTask.setRectificationImg(ImageUtils.bitmapToString(imgPath));
                showProgressDialog("整改中...");
                presenter.changeTask();
            });
            RxGalleryFinalApi.openZKCameraForResult(this, strings -> Logger.e(String.format("拍照成功,图片存储路径:%s", strings[0])));

        } else {
            Logger.e("失敗");
        }
    }

    @Override
    public void initInjector() {
        getComponent().inject(this);
    }

    @Override
    public void startLoading() {

    }

    @Override
    public void endLoading() {

    }

    @Override
    public void onError(String error) {

        Toast(error);
    }

    @Override
    public void showList(List<InspectionRectification> list) {

    }


    @Override
    public void changSuccess() {
        Toast("整改成功！");
        dissmissDialog();
        EventBus.getDefault().postSticky(BaseEvents.CommonEvent.UPDATE_CHANGELIST);

    }

    @Override
    public String getTaskCId() {
        return mTask.getId();
    }

    @Override
    public InspectionRectification getInspectionRectification() {
        return mTask;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
