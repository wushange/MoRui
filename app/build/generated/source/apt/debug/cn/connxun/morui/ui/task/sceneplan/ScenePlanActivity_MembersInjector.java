package cn.connxun.morui.ui.task.sceneplan;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ScenePlanActivity_MembersInjector implements MembersInjector<ScenePlanActivity> {
  private final Provider<ScenePlanAdapter> adapterProvider;

  private final Provider<ScenePlanPresenter> presenterProvider;

  public ScenePlanActivity_MembersInjector(
      Provider<ScenePlanAdapter> adapterProvider, Provider<ScenePlanPresenter> presenterProvider) {
    assert adapterProvider != null;
    this.adapterProvider = adapterProvider;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<ScenePlanActivity> create(
      Provider<ScenePlanAdapter> adapterProvider, Provider<ScenePlanPresenter> presenterProvider) {
    return new ScenePlanActivity_MembersInjector(adapterProvider, presenterProvider);
  }

  @Override
  public void injectMembers(ScenePlanActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.adapter = adapterProvider.get();
    instance.presenter = presenterProvider.get();
  }

  public static void injectAdapter(
      ScenePlanActivity instance, Provider<ScenePlanAdapter> adapterProvider) {
    instance.adapter = adapterProvider.get();
  }

  public static void injectPresenter(
      ScenePlanActivity instance, Provider<ScenePlanPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }
}
