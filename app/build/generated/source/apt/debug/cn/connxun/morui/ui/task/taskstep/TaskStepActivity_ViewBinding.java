// Generated code from Butter Knife. Do not modify!
package cn.connxun.morui.ui.task.taskstep;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.connxun.morui.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TaskStepActivity_ViewBinding implements Unbinder {
  private TaskStepActivity target;

  @UiThread
  public TaskStepActivity_ViewBinding(TaskStepActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TaskStepActivity_ViewBinding(TaskStepActivity target, View source) {
    this.target = target;

    target.tvTagsPos = Utils.findRequiredViewAsType(source, R.id.tv_tags_pos, "field 'tvTagsPos'", TextView.class);
    target.tvTagsSize = Utils.findRequiredViewAsType(source, R.id.tv_tags_size, "field 'tvTagsSize'", TextView.class);
    target.tvTagsUnit = Utils.findRequiredViewAsType(source, R.id.tv_tag_unit, "field 'tvTagsUnit'", TextView.class);
    target.tvTagName = Utils.findRequiredViewAsType(source, R.id.tv_tag_name, "field 'tvTagName'", TextView.class);
    target.etTagResult = Utils.findRequiredViewAsType(source, R.id.et_tag_result, "field 'etTagResult'", EditText.class);
    target.rbTagNormal = Utils.findRequiredViewAsType(source, R.id.rb_tag_normal, "field 'rbTagNormal'", RadioButton.class);
    target.rbTagAbnormal = Utils.findRequiredViewAsType(source, R.id.rb_tag_abnormal, "field 'rbTagAbnormal'", RadioButton.class);
    target.rgTagResult = Utils.findRequiredViewAsType(source, R.id.rg_tag_result, "field 'rgTagResult'", RadioGroup.class);
    target.llTagNormal = Utils.findRequiredViewAsType(source, R.id.ll_tag_normal, "field 'llTagNormal'", LinearLayout.class);
    target.llTagNeedEdit = Utils.findRequiredViewAsType(source, R.id.ll_tag_need_edit, "field 'llTagNeedEdit'", LinearLayout.class);
    target.rlTagResult = Utils.findRequiredViewAsType(source, R.id.rl_tag_result, "field 'rlTagResult'", RelativeLayout.class);
    target.btnTagPhoto = Utils.findRequiredViewAsType(source, R.id.btn_tag_photo, "field 'btnTagPhoto'", Button.class);
    target.btnTagRemark = Utils.findRequiredViewAsType(source, R.id.btn_tag_remark, "field 'btnTagRemark'", Button.class);
    target.llTagNeedEdit2 = Utils.findRequiredViewAsType(source, R.id.ll_tag_need_edit2, "field 'llTagNeedEdit2'", LinearLayout.class);
    target.btnTagSave = Utils.findRequiredViewAsType(source, R.id.btn_tag_save, "field 'btnTagSave'", Button.class);
    target.btnTagLast = Utils.findRequiredViewAsType(source, R.id.btn_tag_last, "field 'btnTagLast'", Button.class);
    target.btnReTakephotp = Utils.findRequiredViewAsType(source, R.id.btn_re_takephotp, "field 'btnReTakephotp'", Button.class);
    target.ivTaksImg = Utils.findRequiredViewAsType(source, R.id.iv_taks_img, "field 'ivTaksImg'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TaskStepActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvTagsPos = null;
    target.tvTagsSize = null;
    target.tvTagsUnit = null;
    target.tvTagName = null;
    target.etTagResult = null;
    target.rbTagNormal = null;
    target.rbTagAbnormal = null;
    target.rgTagResult = null;
    target.llTagNormal = null;
    target.llTagNeedEdit = null;
    target.rlTagResult = null;
    target.btnTagPhoto = null;
    target.btnTagRemark = null;
    target.llTagNeedEdit2 = null;
    target.btnTagSave = null;
    target.btnTagLast = null;
    target.btnReTakephotp = null;
    target.ivTaksImg = null;
  }
}
