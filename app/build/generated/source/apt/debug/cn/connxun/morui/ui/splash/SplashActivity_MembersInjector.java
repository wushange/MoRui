package cn.connxun.morui.ui.splash;

import cn.connxun.morui.data.local.UserStorge;
import cn.connxun.morui.ui.login.LoginPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SplashActivity_MembersInjector implements MembersInjector<SplashActivity> {
  private final Provider<LoginPresenter> presenterProvider;

  private final Provider<UserStorge> userStorgeProvider;

  public SplashActivity_MembersInjector(
      Provider<LoginPresenter> presenterProvider, Provider<UserStorge> userStorgeProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
    assert userStorgeProvider != null;
    this.userStorgeProvider = userStorgeProvider;
  }

  public static MembersInjector<SplashActivity> create(
      Provider<LoginPresenter> presenterProvider, Provider<UserStorge> userStorgeProvider) {
    return new SplashActivity_MembersInjector(presenterProvider, userStorgeProvider);
  }

  @Override
  public void injectMembers(SplashActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
    instance.userStorge = userStorgeProvider.get();
  }

  public static void injectPresenter(
      SplashActivity instance, Provider<LoginPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }

  public static void injectUserStorge(
      SplashActivity instance, Provider<UserStorge> userStorgeProvider) {
    instance.userStorge = userStorgeProvider.get();
  }
}
