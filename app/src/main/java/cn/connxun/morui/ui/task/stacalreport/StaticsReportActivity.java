package cn.connxun.morui.ui.task.stacalreport;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;
import cn.connxun.morui.R;
import cn.connxun.morui.ui.base.BaseSwipeBackActivity;

/**
 * 统计报表
 * Created by wushange on 2017/7/19.
 */

public class StaticsReportActivity extends BaseSwipeBackActivity {
    @BindView(R.id.btn_sta_rep1)
    Button btnStaRep1;
    @BindView(R.id.btn_sta_rep2)
    Button btnStaRep2;
    @BindView(R.id.btn_sta_rep3)
    Button btnStaRep3;

    @Override
    public int bindLayout() {
        return R.layout.activity_statisreport;
    }

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void initInjector() {
    }


    @OnClick({R.id.btn_sta_rep1, R.id.btn_sta_rep2, R.id.btn_sta_rep3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_sta_rep1:
                mOperation.forward(ReportResultActivity.class);
                break;
            case R.id.btn_sta_rep2:
                mOperation.forward(ReportActionActivity.class);
                break;
            case R.id.btn_sta_rep3:
                mOperation.showBasicDialog("工程师正在拼命开发中...",null);
                break;
        }
    }
}
