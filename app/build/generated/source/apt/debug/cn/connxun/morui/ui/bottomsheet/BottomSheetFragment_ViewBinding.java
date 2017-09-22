// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.bottomsheet;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import com.jude.easyrecyclerview.EasyRecyclerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BottomSheetFragment_ViewBinding implements Unbinder {
  private BottomSheetFragment target;

  @UiThread
  public BottomSheetFragment_ViewBinding(BottomSheetFragment target, View source) {
    this.target = target;

    target.btmCallList = Utils.findRequiredViewAsType(source, R.id.easy_recyclerview, "field 'btmCallList'", EasyRecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BottomSheetFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btmCallList = null;
  }
}
