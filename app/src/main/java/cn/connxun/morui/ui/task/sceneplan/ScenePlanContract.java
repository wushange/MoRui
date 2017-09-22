package cn.connxun.morui.ui.task.sceneplan;


import java.util.List;

import cn.connxun.morui.entity.ConplanBean;
import cn.connxun.morui.ui.base.BasePView;

/**
 * Created by sll on 2016/5/11.
 */
public interface ScenePlanContract {
    interface  ScenePlanView extends BasePView {
        void showList(List<ConplanBean> list);
    }

    interface ScenePlanPresenter {
        void getList();
    }
}
