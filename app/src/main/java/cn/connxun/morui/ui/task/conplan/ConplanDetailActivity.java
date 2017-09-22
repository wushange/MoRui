package cn.connxun.morui.ui.task.conplan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.connxun.morui.R;
import cn.connxun.morui.api.PlanApi;
import cn.connxun.morui.constants.Constants;
import cn.connxun.morui.entity.PlanDetail;
import cn.connxun.morui.ui.base.BaseActivity;
import cn.connxun.morui.ui.filepreview.FilePreviewActivity;
import io.reactivex.functions.Consumer;

/**
 * 应急预案详情
 * Created by wushange on 2017/8/17.
 */

public class ConplanDetailActivity extends BaseActivity {
    @BindView(R.id.tv_plan_title)
    TextView tvPlanTitle;
    @BindView(R.id.tv_plan_context)
    TextView tvPlanContext;
    @BindView(R.id.tv_plan_file)
    TextView tvPlanFile;

    public static void callMe(Context context, @NonNull String cid) {
        Intent intent = new Intent(context, ConplanDetailActivity.class);
        intent.putExtra(CON_PLAN_ID, cid);
        context.startActivity(intent);
    }

    public static String CON_PLAN_ID = "CON_PLAN_ID";
    @Inject
    PlanApi api;
    String cid;

    @Override
    public int bindLayout() {
        return R.layout.activity_conplan_detail;
    }

    @Override
    public void initParms(Bundle parms) {
        if (parms != null) {
            cid = parms.getString(CON_PLAN_ID);
        }
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void doBusiness(Context mContext) {
        api.getPlanDetailById(cid).subscribe(new Consumer<PlanDetail>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull PlanDetail planDetail) throws Exception {
                LogUtils.e("---" + planDetail.toString());
                tvPlanTitle.setText(planDetail.getName());
                tvPlanContext.setText(Html.fromHtml(planDetail.getContent()));
                if(!StringUtils.isEmpty(planDetail.getFilePath())){
                    SpannableString spannableString = new SpannableString(planDetail.getFileName());
                    //设置下划线
                    spannableString.setSpan(new UnderlineSpan(), 0, planDetail.getFileName().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    tvPlanFile.setText(spannableString);
                    tvPlanFile.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            FilePreviewActivity.callMe(getContext(), Constants.HOST+"/upload/"+planDetail.getFilePath());
                        }
                    });
                }
            }
        });
    }

    @Override
    public void initInjector() {
        getComponent().inject(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
