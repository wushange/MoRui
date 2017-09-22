// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.task.conplan;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ConplanDetailActivity_ViewBinding implements Unbinder {
  private ConplanDetailActivity target;

  @UiThread
  public ConplanDetailActivity_ViewBinding(ConplanDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ConplanDetailActivity_ViewBinding(ConplanDetailActivity target, View source) {
    this.target = target;

    target.tvPlanTitle = Utils.findRequiredViewAsType(source, R.id.tv_plan_title, "field 'tvPlanTitle'", TextView.class);
    target.tvPlanContext = Utils.findRequiredViewAsType(source, R.id.tv_plan_context, "field 'tvPlanContext'", TextView.class);
    target.tvPlanFile = Utils.findRequiredViewAsType(source, R.id.tv_plan_file, "field 'tvPlanFile'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ConplanDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvPlanTitle = null;
    target.tvPlanContext = null;
    target.tvPlanFile = null;
  }
}
