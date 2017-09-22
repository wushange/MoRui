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

public class ConplanAdapter$ViewHolder_ViewBinding implements Unbinder {
  private ConplanAdapter.ViewHolder target;

  @UiThread
  public ConplanAdapter$ViewHolder_ViewBinding(ConplanAdapter.ViewHolder target, View source) {
    this.target = target;

    target.tvItemConplanTitle = Utils.findRequiredViewAsType(source, R.id.tv_item_conplan_title, "field 'tvItemConplanTitle'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ConplanAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvItemConplanTitle = null;
  }
}
