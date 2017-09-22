// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.notice.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NoticeAdapter$ViewHolder_ViewBinding implements Unbinder {
  private NoticeAdapter.ViewHolder target;

  @UiThread
  public NoticeAdapter$ViewHolder_ViewBinding(NoticeAdapter.ViewHolder target, View source) {
    this.target = target;

    target.tvItemConplanTitle = Utils.findRequiredViewAsType(source, R.id.tv_item_notice_title, "field 'tvItemConplanTitle'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NoticeAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvItemConplanTitle = null;
  }
}
