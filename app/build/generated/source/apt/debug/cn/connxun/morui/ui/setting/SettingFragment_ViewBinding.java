// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.setting;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SettingFragment_ViewBinding implements Unbinder {
  private SettingFragment target;

  private View view2131689684;

  @UiThread
  public SettingFragment_ViewBinding(final SettingFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_safe_exit, "field 'btnSafeExit' and method 'onViewClicked'");
    target.btnSafeExit = Utils.castView(view, R.id.btn_safe_exit, "field 'btnSafeExit'", Button.class);
    view2131689684 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.btnClearTasks = Utils.findRequiredViewAsType(source, R.id.btn_clear_tasks, "field 'btnClearTasks'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SettingFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnSafeExit = null;
    target.btnClearTasks = null;

    view2131689684.setOnClickListener(null);
    view2131689684 = null;
  }
}
