// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.task.taskallot;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TaskAllotedFragment_ViewBinding implements Unbinder {
  private TaskAllotedFragment target;

  @UiThread
  public TaskAllotedFragment_ViewBinding(TaskAllotedFragment target, View source) {
    this.target = target;

    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.rl_task_allot, "field 'recyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TaskAllotedFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerView = null;
  }
}