// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.notice;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import com.jude.easyrecyclerview.EasyRecyclerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NoticeFragment_ViewBinding implements Unbinder {
  private NoticeFragment target;

  @UiThread
  public NoticeFragment_ViewBinding(NoticeFragment target, View source) {
    this.target = target;

    target.easyRecyclerView = Utils.findRequiredViewAsType(source, R.id.notice_recyclerview, "field 'easyRecyclerView'", EasyRecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NoticeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.easyRecyclerView = null;
  }
}
