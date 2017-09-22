// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.filedoc;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import com.jude.easyrecyclerview.EasyRecyclerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FileDocActivity_ViewBinding implements Unbinder {
  private FileDocActivity target;

  @UiThread
  public FileDocActivity_ViewBinding(FileDocActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public FileDocActivity_ViewBinding(FileDocActivity target, View source) {
    this.target = target;

    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.easy_recyclerview, "field 'recyclerView'", EasyRecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FileDocActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerView = null;
  }
}
