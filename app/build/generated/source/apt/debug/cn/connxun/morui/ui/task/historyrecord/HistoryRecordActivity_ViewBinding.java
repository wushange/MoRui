// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.task.historyrecord;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import com.jude.easyrecyclerview.EasyRecyclerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HistoryRecordActivity_ViewBinding implements Unbinder {
  private HistoryRecordActivity target;

  @UiThread
  public HistoryRecordActivity_ViewBinding(HistoryRecordActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HistoryRecordActivity_ViewBinding(HistoryRecordActivity target, View source) {
    this.target = target;

    target.erlHisRecord = Utils.findRequiredViewAsType(source, R.id.easy_hrecyclerview, "field 'erlHisRecord'", EasyRecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HistoryRecordActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.erlHisRecord = null;
  }
}
