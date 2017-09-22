package cn.connxun.morui.ui.login;

import cn.connxun.morui.api.TokenApi;
import cn.connxun.morui.components.retrofit.RequestHelper;
import cn.connxun.morui.data.local.UserStorge;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoginPresenter_Factory implements Factory<LoginPresenter> {
  private final MembersInjector<LoginPresenter> loginPresenterMembersInjector;

  private final Provider<TokenApi> tokenApiProvider;

  private final Provider<UserStorge> userStorgeProvider;

  private final Provider<RequestHelper> requestHelperProvider;

  public LoginPresenter_Factory(
      MembersInjector<LoginPresenter> loginPresenterMembersInjector,
      Provider<TokenApi> tokenApiProvider,
      Provider<UserStorge> userStorgeProvider,
      Provider<RequestHelper> requestHelperProvider) {
    assert loginPresenterMembersInjector != null;
    this.loginPresenterMembersInjector = loginPresenterMembersInjector;
    assert tokenApiProvider != null;
    this.tokenApiProvider = tokenApiProvider;
    assert userStorgeProvider != null;
    this.userStorgeProvider = userStorgeProvider;
    assert requestHelperProvider != null;
    this.requestHelperProvider = requestHelperProvider;
  }

  @Override
  public LoginPresenter get() {
    return MembersInjectors.injectMembers(
        loginPresenterMembersInjector,
        new LoginPresenter(
            tokenApiProvider.get(), userStorgeProvider.get(), requestHelperProvider.get()));
  }

  public static Factory<LoginPresenter> create(
      MembersInjector<LoginPresenter> loginPresenterMembersInjector,
      Provider<TokenApi> tokenApiProvider,
      Provider<UserStorge> userStorgeProvider,
      Provider<RequestHelper> requestHelperProvider) {
    return new LoginPresenter_Factory(
        loginPresenterMembersInjector, tokenApiProvider, userStorgeProvider, requestHelperProvider);
  }
}
