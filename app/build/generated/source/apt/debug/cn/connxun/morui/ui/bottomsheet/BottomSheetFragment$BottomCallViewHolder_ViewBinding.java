// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.bottomsheet;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BottomSheetFragment$BottomCallViewHolder_ViewBinding implements Unbinder {
  private BottomSheetFragment.BottomCallViewHolder target;

  @UiThread
  public BottomSheetFragment$BottomCallViewHolder_ViewBinding(BottomSheetFragment.BottomCallViewHolder target,
      View source) {
    this.target = target;

    target.tvItemBottomName = Utils.findRequiredViewAsType(source, R.id.tv_item_taskallot_username, "field 'tvItemBottomName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BottomSheetFragment.BottomCallViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvItemBottomName = null;
  }
}
