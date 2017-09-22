package cn.connxun.morui.ui.task.sceneplan;

import javax.inject.Inject;

import cn.connxun.morui.di.PerActivity;
import cn.connxun.morui.ui.base.BasePresenter;

/**
 * Created by wanglj on 16/7/4.
 */


@PerActivity
public class ScenePlanPresenter extends BasePresenter<ScenePlanContract.ScenePlanView> implements ScenePlanContract.ScenePlanPresenter {

    @Inject
    public ScenePlanPresenter() {
    }


    @Override
    public void getList() {
    }
}
