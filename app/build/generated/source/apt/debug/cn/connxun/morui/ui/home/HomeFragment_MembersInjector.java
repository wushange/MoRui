package cn.connxun.morui.ui.home;

import cn.connxun.morui.data.local.UserStorge;
import cn.connxun.morui.ui.task.taskinspect.TaskInspectPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HomeFragment_MembersInjector implements MembersInjector<HomeFragment> {
  private final Provider<HomeMenuAdapter> adapterProvider;

  private final Provider<UserStorge> userStorgeProvider;

  private final Provider<TaskInspectPresenter> presenterProvider;

  public HomeFragment_MembersInjector(
      Provider<HomeMenuAdapter> adapterProvider,
      Provider<UserStorge> userStorgeProvider,
      Provider<TaskInspectPresenter> presenterProvider) {
    assert adapterProvider != null;
    this.adapterProvider = adapterProvider;
    assert userStorgeProvider != null;
    this.userStorgeProvider = userStorgeProvider;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<HomeFragment> create(
      Provider<HomeMenuAdapter> adapterProvider,
      Provider<UserStorge> userStorgeProvider,
      Provider<TaskInspectPresenter> presenterProvider) {
    return new HomeFragment_MembersInjector(adapterProvider, userStorgeProvider, presenterProvider);
  }

  @Override
  public void injectMembers(HomeFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.adapter = adapterProvider.get();
    instance.userStorge = userStorgeProvider.get();
    instance.presenter = presenterProvider.get();
  }

  public static void injectAdapter(
      HomeFragment instance, Provider<HomeMenuAdapter> adapterProvider) {
    instance.adapter = adapterProvider.get();
  }

  public static void injectUserStorge(
      HomeFragment instance, Provider<UserStorge> userStorgeProvider) {
    instance.userStorge = userStorgeProvider.get();
  }

  public static void injectPresenter(
      HomeFragment instance, Provider<TaskInspectPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }
}
