// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeMenuAdapter$ViewHolder_ViewBinding implements Unbinder {
  private HomeMenuAdapter.ViewHolder target;

  @UiThread
  public HomeMenuAdapter$ViewHolder_ViewBinding(HomeMenuAdapter.ViewHolder target, View source) {
    this.target = target;

    target.ivItemMenuIcon = Utils.findRequiredViewAsType(source, R.id.iv_item_menu_icon, "field 'ivItemMenuIcon'", ImageView.class);
    target.tvItemMenuName = Utils.findRequiredViewAsType(source, R.id.tv_item_menu_name, "field 'tvItemMenuName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeMenuAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivItemMenuIcon = null;
    target.tvItemMenuName = null;
  }
}
