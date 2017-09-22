// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.task.tasktag;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import com.wang.avi.AVLoadingIndicatorView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TaskTagactivity_ViewBinding implements Unbinder {
  private TaskTagactivity target;

  @UiThread
  public TaskTagactivity_ViewBinding(TaskTagactivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TaskTagactivity_ViewBinding(TaskTagactivity target, View source) {
    this.target = target;

    target.avloadingview = Utils.findRequiredViewAsType(source, R.id.avloadingview, "field 'avloadingview'", AVLoadingIndicatorView.class);
    target.btnTasktag = Utils.findRequiredViewAsType(source, R.id.btn_tasktag, "field 'btnTasktag'", Button.class);
    target.tvResult = Utils.findRequiredViewAsType(source, R.id.tv_result, "field 'tvResult'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TaskTagactivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.avloadingview = null;
    target.btnTasktag = null;
    target.tvResult = null;
  }
}
