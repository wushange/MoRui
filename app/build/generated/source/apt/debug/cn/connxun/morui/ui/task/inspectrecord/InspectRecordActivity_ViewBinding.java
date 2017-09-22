// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.task.inspectrecord;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import com.jude.easyrecyclerview.EasyRecyclerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class InspectRecordActivity_ViewBinding implements Unbinder {
  private InspectRecordActivity target;

  @UiThread
  public InspectRecordActivity_ViewBinding(InspectRecordActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public InspectRecordActivity_ViewBinding(InspectRecordActivity target, View source) {
    this.target = target;

    target.erlInsRecord = Utils.findRequiredViewAsType(source, R.id.ireasy_recyclerview, "field 'erlInsRecord'", EasyRecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    InspectRecordActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.erlInsRecord = null;
  }
}
