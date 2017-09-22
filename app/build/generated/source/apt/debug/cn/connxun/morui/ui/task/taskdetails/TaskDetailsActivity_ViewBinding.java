// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.task.taskdetails;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import com.jude.easyrecyclerview.EasyRecyclerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TaskDetailsActivity_ViewBinding implements Unbinder {
  private TaskDetailsActivity target;

  @UiThread
  public TaskDetailsActivity_ViewBinding(TaskDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TaskDetailsActivity_ViewBinding(TaskDetailsActivity target, View source) {
    this.target = target;

    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.erl_task_details, "field 'recyclerView'", EasyRecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TaskDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerView = null;
  }
}
