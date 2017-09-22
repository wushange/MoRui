package cn.connxun.morui.ui.task.taskstep;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
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
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.orhanobut.logger.Logger;
import com.tbruyelle.rxpermissions2.RxPermissions;

import org.greenrobot.eventbus.EventBus;

import java.io.File;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
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
            RxUtil.runOnIoThreadTask().observeOn(AndroidSchedulers.mainThread()).subscribe(o -> {
                ivTaksImg.setImageURI(Uri.fromFile(new File(imgPath)));
                mTask.setFilePath(ImageUtils.bitmapToString(imgPath));
//                presenter.checkTask();
            });
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
        mTask.setCheckResultValue(TASKSUB_SUBJECTIVEJUDMENT.NORMAL.value() + "");
        mTask.setCheckResult(TASKSUB_CHECK_RESULT.NORMAL.value() + "");
        tvTagsPos.setText(mTask.getDisplayOrder() + "");
        tvTagsSize.setText(total);
        tvTagName.setText(mTask.getEquipmentName() + "-" + mTask.getPointName());
        etTagResult.setText(mTask.getCheckResultValue());
        etTagResult.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                mTask.setCheckResultValue(s.toString());
            }
        });
        rgTagResult.setOnCheckedChangeListener(oncheckListener);
        if (mTask.getIsSubJudge() == TASK_ISSUBJUDGE.ISSUBJUDGE.value()) {
            showNormalLayout();
        } else {
            showEditLayout();

        }
        btnTagRemark.setOnClickListener(v -> mOperation.showInputDialog("请输入备注", "请输入此次检查点的备注信息", mTask.getRemark(), (dialog, input) -> {
            mTask.setRemark(input.toString());
            Toast("备注成功");
        }));
    }

    private void showEditLayout() {
        llTagNeedEdit.setVisibility(View.VISIBLE);
        llTagNeedEdit2.setVisibility(View.VISIBLE);
        llTagNormal.setVisibility(View.GONE);
        tvTagsUnit.setText(mTask.getUnit());
    }

    private void showNormalLayout() {
        llTagNeedEdit.setVisibility(View.GONE);
        llTagNeedEdit2.setVisibility(View.GONE);
        llTagNormal.setVisibility(View.VISIBLE);
        if (String.valueOf(TASKSUB_CHECK_RESULT.ABNORMAL.value()).equals(mTask.getCheckResult())) {
            rbTagAbnormal.setChecked(true);
        } else {
            rbTagNormal.setChecked(true);

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
    TextWatcher                        textWather      = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            if (StringUtils.isEmpty(s.toString())) {
                return;
            }
            double input;
            try {
                input = Double.valueOf(s.toString());
            } catch (NumberFormatException e) {
                input = 0; // your default value
            }
            LogUtils.e(
                    "--input--" + input
                            + "\n--Stand--" + mTask.getStandardValue()
                            + "\n--Red--" + mTask.getRedWarning()
                            + "\n--Yello--" + mTask.getYellowWarning()
                            + "\n--Origen--" + mTask.getOrangeWarning()
                            + "\n--MinValue--" + mTask.getMinValue()
                            + "\n--MaxValue--" + mTask.getBigValue());
            if (rangeInDefined(input, Integer.parseInt(mTask.getBigValue()), Integer.parseInt(mTask.getRedWarning()))) {
                etTagResult.setTextColor(Color.RED);
                mTask.setCheckResult(TASKSUB_CHECK_RESULT.ABNORMAL.value() + "");
                LogUtils.e("红"); //红 max-red
            }
            if (rangeInDefined(input, Integer.parseInt(mTask.getRedWarning()), Integer.parseInt(mTask.getOrangeWarning()))) {
                etTagResult.setTextColor(getResources().getColor(R.color.nocheck));
                mTask.setCheckResult(TASKSUB_CHECK_RESULT.ABNORMAL.value() + "");
                LogUtils.e("橙"); //橙 red-org
            }
            if (rangeInDefined(input, Integer.parseInt(mTask.getOrangeWarning()), Integer.parseInt(mTask.getYellowWarning()))) {
                etTagResult.setTextColor(Color.YELLOW);
                mTask.setCheckResult(TASKSUB_CHECK_RESULT.ABNORMAL.value() + "");
                LogUtils.e("黄"); //黄 org-yello
            }
            if (rangeInDefined(input, Integer.parseInt(mTask.getStandardValue()), Integer.parseInt(mTask.getMinValue()))) {
                LogUtils.e("标准绿色"); //   yello-min
                etTagResult.setTextColor(Color.GREEN);
                mTask.setCheckResult(TASKSUB_CHECK_RESULT.NORMAL.value() + "");
            }
            if (input < Integer.parseInt(mTask.getMinValue())) {
                LogUtils.e("小于最小值"); //   yello-min
                etTagResult.setTextColor(Color.RED);
                mTask.setCheckResult(TASKSUB_CHECK_RESULT.ABNORMAL.value() + "");
            }
            if (input > Integer.parseInt(mTask.getBigValue())) {
                LogUtils.e("大于最大值"); //   yello-min
                etTagResult.setTextColor(Color.RED);
                mTask.setCheckResult(TASKSUB_CHECK_RESULT.ABNORMAL.value() + "");
            }

            mTask.setCheckResultValue("" + input);
        }
    };

    private boolean rangeInDefined(double current, int max, int min) {
        if (max - min > 0) {
            return current >= min && current <= max;
        } else {
            return current <= min && current >= max;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
