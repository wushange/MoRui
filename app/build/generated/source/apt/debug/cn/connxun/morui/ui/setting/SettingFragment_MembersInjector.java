package cn.connxun.morui.ui.setting;

import cn.connxun.morui.data.local.UserStorge;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SettingFragment_MembersInjector implements MembersInjector<SettingFragment> {
  private final Provider<UserStorge> userStorgeProvider;

  public SettingFragment_MembersInjector(Provider<UserStorge> userStorgeProvider) {
    assert userStorgeProvider != null;
    this.userStorgeProvider = userStorgeProvider;
  }

  public static MembersInjector<SettingFragment> create(Provider<UserStorge> userStorgeProvider) {
    return new SettingFragment_MembersInjector(userStorgeProvider);
  }

  @Override
  public void injectMembers(SettingFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.userStorge = userStorgeProvider.get();
  }

  public static void injectUserStorge(
      SettingFragment instance, Provider<UserStorge> userStorgeProvider) {
    instance.userStorge = userStorgeProvider.get();
  }
}
