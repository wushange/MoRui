// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.filepreview;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import cn.connxun.morui.widget.AppTitle;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FilePreviewActivity_ViewBinding implements Unbinder {
  private FilePreviewActivity target;

  @UiThread
  public FilePreviewActivity_ViewBinding(FilePreviewActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public FilePreviewActivity_ViewBinding(FilePreviewActivity target, View source) {
    this.target = target;

    target.mViewParent = Utils.findRequiredViewAsType(source, R.id.webView1, "field 'mViewParent'", ViewGroup.class);
    target.appTitle = Utils.findRequiredViewAsType(source, R.id.app_title_id, "field 'appTitle'", AppTitle.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FilePreviewActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mViewParent = null;
    target.appTitle = null;
  }
}
