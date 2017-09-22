// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.task.sceneplan;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import com.jude.easyrecyclerview.EasyRecyclerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ScenePlanActivity_ViewBinding implements Unbinder {
  private ScenePlanActivity target;

  @UiThread
  public ScenePlanActivity_ViewBinding(ScenePlanActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ScenePlanActivity_ViewBinding(ScenePlanActivity target, View source) {
    this.target = target;

    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.erl_sceneplan_record, "field 'recyclerView'", EasyRecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ScenePlanActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerView = null;
  }
}
