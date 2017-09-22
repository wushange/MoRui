// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.guide;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import cn.connxun.morui.widget.AppTitle;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GuideActivity_ViewBinding implements Unbinder {
  private GuideActivity target;

  @UiThread
  public GuideActivity_ViewBinding(GuideActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public GuideActivity_ViewBinding(GuideActivity target, View source) {
    this.target = target;

    target.weblayout = Utils.findRequiredViewAsType(source, R.id.weblayout, "field 'weblayout'", FrameLayout.class);
    target.appTitle = Utils.findRequiredViewAsType(source, R.id.app_title_id, "field 'appTitle'", AppTitle.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GuideActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.weblayout = null;
    target.appTitle = null;
  }
}
