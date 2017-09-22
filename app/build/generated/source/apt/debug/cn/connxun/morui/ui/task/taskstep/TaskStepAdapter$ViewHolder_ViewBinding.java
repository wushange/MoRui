// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.task.taskstep;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TaskStepAdapter$ViewHolder_ViewBinding implements Unbinder {
  private TaskStepAdapter.ViewHolder target;

  @UiThread
  public TaskStepAdapter$ViewHolder_ViewBinding(TaskStepAdapter.ViewHolder target, View source) {
    this.target = target;

    target.tvItemTaskName = Utils.findRequiredViewAsType(source, R.id.tv_item_task_name, "field 'tvItemTaskName'", TextView.class);
    target.tvItemTaskStatus = Utils.findRequiredViewAsType(source, R.id.tv_item_task_status, "field 'tvItemTaskStatus'", TextView.class);
    target.tvItemTaskShenfen = Utils.findRequiredViewAsType(source, R.id.tv_item_task_shenfen, "field 'tvItemTaskShenfen'", TextView.class);
    target.tvItemTaskInstime = Utils.findRequiredViewAsType(source, R.id.tv_item_task_instime, "field 'tvItemTaskInstime'", TextView.class);
    target.tvItemTaskSynctime = Utils.findRequiredViewAsType(source, R.id.tv_item_task_synctime, "field 'tvItemTaskSynctime'", TextView.class);
    target.btnTaskoper = Utils.findRequiredViewAsType(source, R.id.btn_taskoper, "field 'btnTaskoper'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TaskStepAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvItemTaskName = null;
    target.tvItemTaskStatus = null;
    target.tvItemTaskShenfen = null;
    target.tvItemTaskInstime = null;
    target.tvItemTaskSynctime = null;
    target.btnTaskoper = null;
  }
}
