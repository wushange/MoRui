// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.contacts;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ContactsActivity_ViewBinding implements Unbinder {
  private ContactsActivity target;

  @UiThread
  public ContactsActivity_ViewBinding(ContactsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ContactsActivity_ViewBinding(ContactsActivity target, View source) {
    this.target = target;

    target.mTree = Utils.findRequiredViewAsType(source, R.id.id_tree, "field 'mTree'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ContactsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTree = null;
  }
}
