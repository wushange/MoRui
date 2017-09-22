package cn.connxun.morui.ui.login;


import cn.connxun.morui.entity.User;
import cn.connxun.morui.ui.base.BasePView;

/**
 * Created by sll on 2016/5/11.
 */
public interface LoginContract {
    interface LoginView extends BasePView {
        String getUserName();

        String getUserPassWord();

        void loginSuccess(User token);
    }

    interface LoginPresenter {
        void login();

    }
}
