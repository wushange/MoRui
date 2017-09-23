package cn.connxun.morui.ui.task.taskstep;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.blankj.utilcode.util.StringUtils;
import com.bumptech.glide.Glide;
import com.orhanobut.logger.Logger;
import com.tbruyelle.rxpermissions2.RxPermissions;

import org.greenrobot.eventbus.EventBus;

import java.io.ByteArrayOutputStream;

import javax.inject.Inject;

import butterknife.BindView;
import cn.connxun.morui.R;
import cn.connxun.morui.components.rxjava.RxUtil;
import cn.connxun.morui.constants.enums.TASKSUB_CHECK_RESULT;
import cn.connxun.morui.constants.enums.TASKSUB_SUBJECTIVEJUDMENT;
import cn.connxun.morui.constants.enums.TASK_ISSUBJUDGE;
import cn.connxun.morui.entity.Task;
import cn.connxun.morui.entity.TaskSub;
import cn.connxun.morui.ui.base.BaseEvents;
import cn.connxun.morui.ui.base.BaseSwipeBackActivity;
import cn.connxun.morui.utils.ImageUtils;
import cn.finalteam.rxgalleryfinal.RxGalleryFinalApi;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * 巡检任务
 * Created by wushange on 2017/7/19.
 */

public class TaskStepActivity extends BaseSwipeBackActivity implements TaskStepContract.TaskStepView {

    private static final String TASK_ID_SETP = "TASK_ID_SETP";
    private static final String TASK_TAGID   = "TASK_TAGID";
    @BindView(R.id.tv_tags_pos)
    TextView       tvTagsPos;
    @BindView(R.id.tv_tags_size)
    TextView       tvTagsSize;
    @BindView(R.id.tv_tag_unit)
    TextView       tvTagsUnit;
    @BindView(R.id.tv_tag_name)
    TextView       tvTagName;
    @BindView(R.id.et_tag_result)
    EditText       etTagResult;
    @BindView(R.id.rb_tag_normal)
    RadioButton    rbTagNormal;
    @BindView(R.id.rb_tag_abnormal)
    RadioButton    rbTagAbnormal;
    @BindView(R.id.rg_tag_result)
    RadioGroup     rgTagResult;
    @BindView(R.id.ll_tag_normal)
    LinearLayout   llTagNormal;
    @BindView(R.id.ll_tag_need_edit)
    LinearLayout   llTagNeedEdit;
    @BindView(R.id.rl_tag_result)
    RelativeLayout rlTagResult;
    @BindView(R.id.btn_tag_photo)
    Button         btnTagPhoto;
    @BindView(R.id.btn_tag_remark)
    Button         btnTagRemark;
    @BindView(R.id.ll_tag_need_edit2)
    LinearLayout   llTagNeedEdit2;
    @BindView(R.id.btn_tag_save)
    Button         btnTagSave;
    @BindView(R.id.btn_tag_last)
    Button         btnTagLast;
    @BindView(R.id.btn_re_takephotp)
    Button         btnReTakephotp;
    @BindView(R.id.iv_taks_img)
    ImageView      ivTaksImg;

    public static void callMe(Context context, String taskId, String tagId) {
        Intent intent = new Intent(context, TaskStepActivity.class);
        intent.putExtra(TASK_ID_SETP, taskId);
        intent.putExtra(TASK_TAGID, tagId);
        context.startActivity(intent);
    }

    String tagId  = "";
    String taskId = "";
    TaskSub mTask;

    @Inject
    TaskStepPresenter presenter;
    int index = 0;

    @Override
    public int bindLayout() {
        return R.layout.activity_task_step;
    }


    @Override
    public void initParms(Bundle parms) {
        taskId = parms.getString(TASK_ID_SETP);
        tagId = parms.getString(TASK_TAGID);
        Logger.e("-taskId==>>" + taskId + "---tagId==>>" + tagId);
    }

    @Override
    public void initView(View view) {
        presenter.attachView(this);
        btnTagSave.setOnClickListener(v -> presenter.checkTask());
        btnTagLast.setOnClickListener(v -> presenter.goLast());
        btnTagPhoto.setOnClickListener(v -> takePhoto());
        btnReTakephotp.setOnClickListener(v -> {
            mTask.setFilePath("");
            takePhoto();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    @Override
    public void doBusiness(Context mContext) {
        presenter.getLocalTask();
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
        if ("未匹配到任务".equals(error)) {
            this.finish();
            return;
        }
        mOperation.showBasicDialog(error, "确定", (dialog, which) -> {
            dialog.dismiss();
        });
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public int getIsSubJudge() {
        return mTask.getIsSubJudge();
    }

    @Override
    public String getEditText() {
        return etTagResult.getText().toString();
    }

    @Override
    public String getTagId() {
        return tagId;
    }

    @Override
    public void setCurrIndex(int index) {
        this.index = index;
    }

    @Override
    public void indexAdd() {
        index++;
    }

    @Override
    public void indexBack() {
        index--;
    }

    @Override
    public String getThisTaskId() {
        return taskId;
    }

    @Override
    public void completeTask(Task bean) {
        mOperation.showBasicDialog("是否继续巡检？", (dialog, which) -> {
            dialog.dismiss();
            EventBus.getDefault().postSticky(BaseEvents.CommonEvent.UPDATE_LIST);
            finish();
        });
    }

    @Override
    public void showConPlan() {
        new MaterialDialog.Builder(getContext())
                .title("现场处置方案")
                .cancelable(false)
                .content(mTask.getContingencyScene())
                .positiveText("立即拍照")
                .onPositive((dialog, which) -> {
                    dialog.dismiss();
                    takePhoto();
                })
                .show();
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
            btnReTakephotp.setVisibility(View.VISIBLE);
            RxUtil.runOnIoThreadTask().observeOn(AndroidSchedulers.mainThread()).subscribe(o -> {
                Bitmap                bitmap = ImageUtils.getSmallBitmap(imgPath);
                ByteArrayOutputStream baos   = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 40, baos);
                byte[] bytes = baos.toByteArray();
                Glide.with(getContext())
                        .load(bytes)
                        .into(ivTaksImg);
                mTask.setFilePath(ImageUtils.bitmapToString(imgPath));
            }, throwable -> Toast(throwable.getMessage()));
            RxGalleryFinalApi.openZKCameraForResult(this, strings -> Logger.e(String.format("拍照成功,图片存储路径:%s", strings[0])));

        } else {
            Logger.e("失敗");
        }
    }

    @Override
    public TaskSub getThisTask() {
        return mTask;
    }

    @Override
    public void renderTaskView(String total, TaskSub allotTaskSubListBean) {
        mTask = null;
        mTask = allotTaskSubListBean;
        tvTagsPos.setText(mTask.getDisplayOrder() + "");
        tvTagsSize.setText(total);
        tvTagName.setText(mTask.getEquipmentName() + "-" + mTask.getPointName());
        if (mTask.getFilePath() != null) {
            btnReTakephotp.setVisibility(View.VISIBLE);
            ivTaksImg.setVisibility(View.VISIBLE);
            ivTaksImg.setImageBitmap(ImageUtils.stringtoBitmap(mTask.getFilePath()));
        } else {
            btnReTakephotp.setVisibility(View.GONE);
            ivTaksImg.setVisibility(View.GONE);
        }
        if (mTask.getIsSubJudge() == TASK_ISSUBJUDGE.ISSUBJUDGE.value()) {
            showNormalLayout();
        } else {
            showEditLayout();

        }

    }

    private void showEditLayout() {
        llTagNeedEdit.setVisibility(View.VISIBLE);
        llTagNeedEdit2.setVisibility(View.VISIBLE);
        llTagNormal.setVisibility(View.GONE);
        tvTagsUnit.setText(mTask.getUnit());
        if (!StringUtils.isEmpty(mTask.getCheckResultValue())) {
            etTagResult.setText(mTask.getCheckResultValue());
            etTagResult.setSelection(mTask.getCheckResultValue().length());
        }
        etTagResult.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Logger.e("--beforeTextChanged-");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Logger.e("--onTextChanged-");
            }

            @Override
            public void afterTextChanged(Editable s) {
                Logger.e("--afterTextChanged-");
                mTask.setCheckResultValue(s.toString());
            }
        });
        btnTagRemark.setOnClickListener(v -> mOperation.showInputDialog("请输入备注", "请输入此次检查点的备注信息", mTask.getRemark(), (dialog, input) -> {
            mTask.setRemark(input.toString());
            Toast("备注成功");
        }));
    }

    private void showNormalLayout() {
        llTagNeedEdit.setVisibility(View.GONE);
        llTagNeedEdit2.setVisibility(View.GONE);
        llTagNormal.setVisibility(View.VISIBLE);
        rgTagResult.setOnCheckedChangeListener(oncheckListener);
        if (String.valueOf(TASKSUB_CHECK_RESULT.ABNORMAL.value()).equals(mTask.getCheckResult())) {
            rbTagAbnormal.setChecked(true);
            mTask.setCheckResultValue(TASKSUB_SUBJECTIVEJUDMENT.ABNORMAL.value() + "");
            Logger.e(" rbTagAbnormal.setChecked(true);");
        } else {
            rbTagNormal.setChecked(true);
            mTask.setCheckResultValue(TASKSUB_SUBJECTIVEJUDMENT.NORMAL.value() + "");
            Logger.e("rbTagNormal.setChecked(true);");
        }
    }


    RadioGroup.OnCheckedChangeListener oncheckListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            switch (checkedId) {
                case R.id.rb_tag_normal:
                    Logger.e("rb_tag_normal");
                    mTask.setCheckResultValue(TASKSUB_SUBJECTIVEJUDMENT.NORMAL.value() + "");
                    break;
                case R.id.rb_tag_abnormal:
                    Logger.e("rb_tag_abnormal");
                    mTask.setCheckResultValue(TASKSUB_SUBJECTIVEJUDMENT.ABNORMAL.value() + "");
                    break;
            }
        }
    };

}
