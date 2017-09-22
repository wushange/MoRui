// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.task.taskdetails;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TaskDetailsAdapter$ViewHolder_ViewBinding implements Unbinder {
  private TaskDetailsAdapter.ViewHolder target;

  @UiThread
  public TaskDetailsAdapter$ViewHolder_ViewBinding(TaskDetailsAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.tvItemTaskDtTag = Utils.findRequiredViewAsType(source, R.id.tv_item_task_dt_tag, "field 'tvItemTaskDtTag'", TextView.class);
    target.tvItemTaskDtParams = Utils.findRequiredViewAsType(source, R.id.tv_item_task_dt_params, "field 'tvItemTaskDtParams'", TextView.class);
    target.tvItemTaskDtResult = Utils.findRequiredViewAsType(source, R.id.tv_item_task_dt_result, "field 'tvItemTaskDtResult'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TaskDetailsAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvItemTaskDtTag = null;
    target.tvItemTaskDtParams = null;
    target.tvItemTaskDtResult = null;
  }
}
