package cn.connxun.morui.ui.task.conplan;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ConplanActivity_MembersInjector implements MembersInjector<ConplanActivity> {
  private final Provider<ConplanAdapter> adapterProvider;

  private final Provider<ConplanPresenter> presenterProvider;

  public ConplanActivity_MembersInjector(
      Provider<ConplanAdapter> adapterProvider, Provider<ConplanPresenter> presenterProvider) {
    assert adapterProvider != null;
    this.adapterProvider = adapterProvider;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<ConplanActivity> create(
      Provider<ConplanAdapter> adapterProvider, Provider<ConplanPresenter> presenterProvider) {
    return new ConplanActivity_MembersInjector(adapterProvider, presenterProvider);
  }

  @Override
  public void injectMembers(ConplanActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.adapter = adapterProvider.get();
    instance.presenter = presenterProvider.get();
  }

  public static void injectAdapter(
      ConplanActivity instance, Provider<ConplanAdapter> adapterProvider) {
    instance.adapter = adapterProvider.get();
  }

  public static void injectPresenter(
      ConplanActivity instance, Provider<ConplanPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }
}
