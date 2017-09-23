package cn.connxun.morui.ui.task.taskstep;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.ToastUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import cn.connxun.morui.constants.enums.TASKSUB_CHECK_RESULT;
import cn.connxun.morui.constants.enums.TASKSUB_CHECK_STATUS;
import cn.connxun.morui.constants.enums.TASK_ISSUBJUDGE;
import cn.connxun.morui.data.local.UserStorge;
import cn.connxun.morui.db.TaskDao;
import cn.connxun.morui.db.TaskSubDao;
import cn.connxun.morui.di.PerActivity;
import cn.connxun.morui.entity.Task;
import cn.connxun.morui.entity.TaskSub;
import cn.connxun.morui.ui.base.BasePresenter;

/**
 * Created by wanglj on 16/7/4.
 */


@PerActivity
public class TaskStepPresenter extends BasePresenter<TaskStepContract.TaskStepView> implements TaskStepContract.TaskStepPresenter {

    UserStorge userStorge;
    TaskSubDao subListBeanDao;
    TaskDao    allotTaskDao;
    List<TaskSub> allotTaskSubListBeen = new ArrayList<>();

    @Inject
    public TaskStepPresenter(UserStorge userStorge, TaskSubDao subListBeanDao, TaskDao allotTaskDao) {
        this.userStorge = userStorge;
        this.subListBeanDao = subListBeanDao;
        this.allotTaskDao = allotTaskDao;
    }

    @Override
    public void checkTask() {
        if (mView.getIsSubJudge() == TASK_ISSUBJUDGE.NOTISSUBJUDGE.value() && StringUtils.isEmpty(mView.getEditText())) {
            mView.onError("请输入检查结果");
            return;
        }
        TaskSub mTask = mView.getThisTask();
        //如果是主观任务则 使用checkresultvalue 比对 getSubJectJudgment 如果不相等则 判断为异常结果
        if (mView.getIsSubJudge() == TASK_ISSUBJUDGE.ISSUBJUDGE.value()) {
            if (mTask.getCheckResultValue().equals(mTask.getSubjectiveJudgment())) {
                mTask.setCheckResult(TASKSUB_CHECK_RESULT.NORMAL.value() + "");
            } else {
                mTask.setCheckResult(TASKSUB_CHECK_RESULT.ABNORMAL.value() + "");
            }
        } else {
            //如果非主观判断则 判断resultValue的范围精度
            double input;
            if (StringUtils.isEmpty(mTask.getCheckResultValue())) {
                mView.onError("检测值不允许为空");
                return;
            }
            try {
                input = Double.valueOf(mTask.getCheckResultValue());
            } catch (NumberFormatException e) {
                input = 0; // your default value
            }
            checkResultValue(mTask, input);
        }
        if ((String.valueOf(TASKSUB_CHECK_RESULT.ABNORMAL.value()).equals(mTask.getCheckResult()))) {
            if (!StringUtils.isEmpty(mTask.getFilePath())) {
                save();
            } else {
                mView.showConPlan();
            }
        } else {
            save();
        }
    }


    @Override
    public void completeTask() {
        Task allotTask = allotTaskDao.queryBuilder().where(TaskDao.Properties.Id.eq(mView.getThisTaskId())).unique();
        allotTaskDao.update(allotTask);
        mView.completeTask(allotTask);
    }

    @Override
    public void getLocalTask() {
        allotTaskSubListBeen = subListBeanDao
                .queryBuilder()
                .where(TaskSubDao.Properties.TaskId.eq(mView.getThisTaskId()),
                        TaskSubDao.Properties.TagValue.eq(mView.getTagId()))
                .orderAsc(TaskSubDao.Properties.DisplayOrder).build().list();
        int lastDoneIndex = subListBeanDao.queryBuilder().where(
                TaskSubDao.Properties.TaskId.eq(mView.getThisTaskId()),
                TaskSubDao.Properties.TagValue.eq(mView.getTagId()),
                TaskSubDao.Properties.CheckStatus.eq(TASKSUB_CHECK_STATUS.CHECKDONE.value())).build().list().size();
        if (lastDoneIndex > 0) {
            mView.setCurrIndex(lastDoneIndex - 1);
            ToastUtils.showShort("上次检查到这里");
        }
        if (allotTaskSubListBeen != null && allotTaskSubListBeen.size() > 0) {
            TaskSub mTask = allotTaskSubListBeen.get(mView.getIndex());
            mTask.setCheckUserName(userStorge.getUser().getRealname());
            mTask.setCheckDate(TimeUtils.date2String(new Date(), new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())));
            mView.renderTaskView(allotTaskSubListBeen.size() + "", mTask);
        } else {
            mView.onError("未匹配到任务");
        }

    }

    @Override
    public void save() {
        TaskSub currTask = mView.getThisTask();
        mView.indexAdd();
        if (mView.getIsSubJudge() != TASK_ISSUBJUDGE.ISSUBJUDGE.value()) {
            currTask.setCheckResultValue("" + mView.getEditText());
        }
        currTask.setCheckStatus(TASKSUB_CHECK_STATUS.CHECKDONE.value());
        subListBeanDao.update(currTask);
        int successCount = 0;
        for (TaskSub bean : allotTaskSubListBeen) {
            if (bean.getCheckStatus() == 2) {
                successCount++;
            }
        }
        if (mView.getIndex() == allotTaskSubListBeen.size() && successCount == allotTaskSubListBeen.size()) {
            completeTask();
            return;
        }
        if (mView.getIndex() >= allotTaskSubListBeen.size()) {
            mView.onError("没有啦");
            mView.indexBack();
            return;
        }
        TaskSub allotTaskSubListBean = allotTaskSubListBeen.get(mView.getIndex());
        if (allotTaskSubListBean != null) {
            mView.renderTaskView(allotTaskSubListBeen.size() + "", allotTaskSubListBean);
        } else {
            mView.onError("没有啦");
            mView.indexBack();
        }
    }

    @Override
    public void goLast() {
        mView.indexBack();
        if (mView.getIndex() < 0) {
            mView.onError("没有啦");
            mView.indexAdd();
            return;
        }
        TaskSub allotTaskSubListBean = allotTaskSubListBeen.get(mView.getIndex());
        if (allotTaskSubListBean != null) {
            mView.renderTaskView(allotTaskSubListBeen.size() + "", allotTaskSubListBean);
        } else {
            mView.onError("前面没有任务了");
            mView.indexAdd();
        }
    }

    private void checkResultValue(TaskSub mTask, double input) {
        LogUtils.e(
                "--input--" + input
                        + "\n--Stand--" + mTask.getStandardValue()
                        + "\n--Red--" + mTask.getRedWarning()
                        + "\n--Yello--" + mTask.getYellowWarning()
                        + "\n--Origen--" + mTask.getOrangeWarning()
                        + "\n--MinValue--" + mTask.getMinValue()
                        + "\n--MaxValue--" + mTask.getBigValue());
        if (!StringUtils.isEmpty(mTask.getRedWarning()) && !StringUtils.isEmpty(mTask.getOrangeWarning())) {
            if (rangeInDefined(input, Double.parseDouble(mTask.getRedWarning()), Double.parseDouble(mTask.getOrangeWarning()))) {
                mTask.setCheckResult(TASKSUB_CHECK_RESULT.ABNORMAL.value() + "");
                LogUtils.e("橙"); //橙 red-org
                return;
            }
        }
        if (!StringUtils.isEmpty(mTask.getOrangeWarning()) && !StringUtils.isEmpty(mTask.getYellowWarning())) {
            if (rangeInDefined(input, Double.parseDouble(mTask.getOrangeWarning()), Double.parseDouble(mTask.getYellowWarning()))) {
                mTask.setCheckResult(TASKSUB_CHECK_RESULT.ABNORMAL.value() + "");
                LogUtils.e("黄"); //黄 org-yello
                return;
            }

        }
        if (input < Double.parseDouble(mTask.getMinValue())) {
            LogUtils.e("小于最小值"); //   yello-min
            mTask.setCheckResult(TASKSUB_CHECK_RESULT.ABNORMAL.value() + "");
            return;
        }
        if (input > Double.parseDouble(mTask.getBigValue())) {
            LogUtils.e("大于最大值"); //   yello-min
            mTask.setCheckResult(TASKSUB_CHECK_RESULT.ABNORMAL.value() + "");
            return;
        }
        mTask.setCheckResult(TASKSUB_CHECK_RESULT.NORMAL.value() + "");
    }

    private boolean rangeInDefined(double current, double max, double min) {
        if (max - min > 0) {
            return current >= min && current <= max;
        } else {
            return current <= min && current >= max;
        }
    }

}
