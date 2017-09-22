// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.notice;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NoticeActivity_ViewBinding implements Unbinder {
  private NoticeActivity target;

  @UiThread
  public NoticeActivity_ViewBinding(NoticeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NoticeActivity_ViewBinding(NoticeActivity target, View source) {
    this.target = target;

    target.tablayout = Utils.findRequiredViewAsType(source, R.id.tablayout, "field 'tablayout'", TabLayout.class);
    target.viewpager = Utils.findRequiredViewAsType(source, R.id.viewpager, "field 'viewpager'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NoticeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tablayout = null;
    target.viewpager = null;
  }
}
