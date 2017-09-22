// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.task.taskinspect;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import com.jude.easyrecyclerview.EasyRecyclerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TaskInspectActivity_ViewBinding implements Unbinder {
  private TaskInspectActivity target;

  @UiThread
  public TaskInspectActivity_ViewBinding(TaskInspectActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TaskInspectActivity_ViewBinding(TaskInspectActivity target, View source) {
    this.target = target;

    target.erlTaskIns = Utils.findRequiredViewAsType(source, R.id.easy_recyclerview, "field 'erlTaskIns'", EasyRecyclerView.class);
    target.btnSync = Utils.findRequiredViewAsType(source, R.id.btn_sync, "field 'btnSync'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TaskInspectActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.erlTaskIns = null;
    target.btnSync = null;
  }
}
