// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.task.stacalreport;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class StaticsReportActivity_ViewBinding implements Unbinder {
  private StaticsReportActivity target;

  private View view2131689618;

  private View view2131689619;

  private View view2131689620;

  @UiThread
  public StaticsReportActivity_ViewBinding(StaticsReportActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public StaticsReportActivity_ViewBinding(final StaticsReportActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_sta_rep1, "field 'btnStaRep1' and method 'onViewClicked'");
    target.btnStaRep1 = Utils.castView(view, R.id.btn_sta_rep1, "field 'btnStaRep1'", Button.class);
    view2131689618 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_sta_rep2, "field 'btnStaRep2' and method 'onViewClicked'");
    target.btnStaRep2 = Utils.castView(view, R.id.btn_sta_rep2, "field 'btnStaRep2'", Button.class);
    view2131689619 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_sta_rep3, "field 'btnStaRep3' and method 'onViewClicked'");
    target.btnStaRep3 = Utils.castView(view, R.id.btn_sta_rep3, "field 'btnStaRep3'", Button.class);
    view2131689620 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    StaticsReportActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnStaRep1 = null;
    target.btnStaRep2 = null;
    target.btnStaRep3 = null;

    view2131689618.setOnClickListener(null);
    view2131689618 = null;
    view2131689619.setOnClickListener(null);
    view2131689619 = null;
    view2131689620.setOnClickListener(null);
    view2131689620 = null;
  }
}
