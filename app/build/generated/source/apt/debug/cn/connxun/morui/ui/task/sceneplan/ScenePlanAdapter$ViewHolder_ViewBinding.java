// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.task.sceneplan;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ScenePlanAdapter$ViewHolder_ViewBinding implements Unbinder {
  private ScenePlanAdapter.ViewHolder target;

  @UiThread
  public ScenePlanAdapter$ViewHolder_ViewBinding(ScenePlanAdapter.ViewHolder target, View source) {
    this.target = target;

    target.tvItemConplanTitle = Utils.findRequiredViewAsType(source, R.id.tv_item_conplan_title, "field 'tvItemConplanTitle'", TextView.class);
    target.tvItemConplanSubtitle = Utils.findRequiredViewAsType(source, R.id.tv_item_conplan_subtitle, "field 'tvItemConplanSubtitle'", TextView.class);
    target.tvItemConplanContent = Utils.findRequiredViewAsType(source, R.id.tv_item_conplan_content, "field 'tvItemConplanContent'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ScenePlanAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvItemConplanTitle = null;
    target.tvItemConplanSubtitle = null;
    target.tvItemConplanContent = null;
  }
}
