package cn.connxun.morui.ui.login;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoginActivity_MembersInjector implements MembersInjector<LoginActivity> {
  private final Provider<LoginPresenter> loginPresenterProvider;

  public LoginActivity_MembersInjector(Provider<LoginPresenter> loginPresenterProvider) {
    assert loginPresenterProvider != null;
    this.loginPresenterProvider = loginPresenterProvider;
  }

  public static MembersInjector<LoginActivity> create(
      Provider<LoginPresenter> loginPresenterProvider) {
    return new LoginActivity_MembersInjector(loginPresenterProvider);
  }

  @Override
  public void injectMembers(LoginActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.loginPresenter = loginPresenterProvider.get();
  }

  public static void injectLoginPresenter(
      LoginActivity instance, Provider<LoginPresenter> loginPresenterProvider) {
    instance.loginPresenter = loginPresenterProvider.get();
  }
}
