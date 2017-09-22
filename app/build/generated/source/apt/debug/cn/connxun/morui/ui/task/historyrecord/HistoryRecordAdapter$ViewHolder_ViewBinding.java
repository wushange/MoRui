// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.task.historyrecord;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HistoryRecordAdapter$ViewHolder_ViewBinding implements Unbinder {
  private HistoryRecordAdapter.ViewHolder target;

  @UiThread
  public HistoryRecordAdapter$ViewHolder_ViewBinding(HistoryRecordAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.tvItemTaskName = Utils.findRequiredViewAsType(source, R.id.tv_item_task_name, "field 'tvItemTaskName'", TextView.class);
    target.tvItemTaskStatus = Utils.findRequiredViewAsType(source, R.id.tv_item_task_status, "field 'tvItemTaskStatus'", TextView.class);
    target.tvItemTaskShenfen = Utils.findRequiredViewAsType(source, R.id.tv_item_task_shenfen, "field 'tvItemTaskShenfen'", TextView.class);
    target.tvItemTaskStartdate = Utils.findRequiredViewAsType(source, R.id.tv_item_task_startdate, "field 'tvItemTaskStartdate'", TextView.class);
    target.tvItemTaskEndtime = Utils.findRequiredViewAsType(source, R.id.tv_item_task_endtime, "field 'tvItemTaskEndtime'", TextView.class);
    target.tvItemTaskUpdateTime = Utils.findRequiredViewAsType(source, R.id.tv_item_task_update_time, "field 'tvItemTaskUpdateTime'", TextView.class);
    target.btnTaskoper = Utils.findRequiredViewAsType(source, R.id.btn_taskoper, "field 'btnTaskoper'", Button.class);
    target.listItem = Utils.findRequiredViewAsType(source, R.id.listItem, "field 'listItem'", CardView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HistoryRecordAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvItemTaskName = null;
    target.tvItemTaskStatus = null;
    target.tvItemTaskShenfen = null;
    target.tvItemTaskStartdate = null;
    target.tvItemTaskEndtime = null;
    target.tvItemTaskUpdateTime = null;
    target.btnTaskoper = null;
    target.listItem = null;
  }
}
