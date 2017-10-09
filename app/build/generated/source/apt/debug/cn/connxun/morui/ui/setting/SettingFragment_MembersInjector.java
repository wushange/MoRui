package cn.connxun.morui.ui.setting;

import cn.connxun.morui.data.local.TaskStroge;
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

  private final Provider<TaskStroge> taskStrogeProvider;

  public SettingFragment_MembersInjector(
      Provider<UserStorge> userStorgeProvider, Provider<TaskStroge> taskStrogeProvider) {
    assert userStorgeProvider != null;
    this.userStorgeProvider = userStorgeProvider;
    assert taskStrogeProvider != null;
    this.taskStrogeProvider = taskStrogeProvider;
  }

  public static MembersInjector<SettingFragment> create(
      Provider<UserStorge> userStorgeProvider, Provider<TaskStroge> taskStrogeProvider) {
    return new SettingFragment_MembersInjector(userStorgeProvider, taskStrogeProvider);
  }

  @Override
  public void injectMembers(SettingFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.userStorge = userStorgeProvider.get();
    instance.taskStroge = taskStrogeProvider.get();
  }

  public static void injectUserStorge(
      SettingFragment instance, Provider<UserStorge> userStorgeProvider) {
    instance.userStorge = userStorgeProvider.get();
  }

  public static void injectTaskStroge(
      SettingFragment instance, Provider<TaskStroge> taskStrogeProvider) {
    instance.taskStroge = taskStrogeProvider.get();
  }
}
