// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.filedoc;

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

public class FileDocAdapter$ViewHolder_ViewBinding implements Unbinder {
  private FileDocAdapter.ViewHolder target;

  @UiThread
  public FileDocAdapter$ViewHolder_ViewBinding(FileDocAdapter.ViewHolder target, View source) {
    this.target = target;

    target.ivItemFileIc = Utils.findRequiredViewAsType(source, R.id.iv_item_file_ic, "field 'ivItemFileIc'", ImageView.class);
    target.tvItemFileName = Utils.findRequiredViewAsType(source, R.id.tv_item_file_name, "field 'tvItemFileName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FileDocAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivItemFileIc = null;
    target.tvItemFileName = null;
  }
}
