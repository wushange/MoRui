// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view2131689612;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    this.target = target;

    View view;
    target.headLogo = Utils.findRequiredViewAsType(source, R.id.head_logo, "field 'headLogo'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.login_btn, "field 'loginBtn' and method 'setAppHost'");
    target.loginBtn = Utils.castView(view, R.id.login_btn, "field 'loginBtn'", Button.class);
    view2131689612 = view;
    view.setOnLongClickListener(new View.OnLongClickListener() {
      @Override
      public boolean onLongClick(View p0) {
        return target.setAppHost(p0);
      }
    });
    target.inputName = Utils.findRequiredViewAsType(source, R.id.input_name, "field 'inputName'", EditText.class);
    target.inputPwd = Utils.findRequiredViewAsType(source, R.id.input_pwd, "field 'inputPwd'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.headLogo = null;
    target.loginBtn = null;
    target.inputName = null;
    target.inputPwd = null;

    view2131689612.setOnLongClickListener(null);
    view2131689612 = null;
  }
}
