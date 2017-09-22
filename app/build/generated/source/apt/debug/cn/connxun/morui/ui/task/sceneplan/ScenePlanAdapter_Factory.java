package cn.connxun.morui.ui.task.sceneplan;

import android.content.Context;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ScenePlanAdapter_Factory implements Factory<ScenePlanAdapter> {
  private final MembersInjector<ScenePlanAdapter> scenePlanAdapterMembersInjector;

  private final Provider<Context> contextProvider;

  public ScenePlanAdapter_Factory(
      MembersInjector<ScenePlanAdapter> scenePlanAdapterMembersInjector,
      Provider<Context> contextProvider) {
    assert scenePlanAdapterMembersInjector != null;
    this.scenePlanAdapterMembersInjector = scenePlanAdapterMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public ScenePlanAdapter get() {
    return MembersInjectors.injectMembers(
        scenePlanAdapterMembersInjector, new ScenePlanAdapter(contextProvider.get()));
  }

  public static Factory<ScenePlanAdapter> create(
      MembersInjector<ScenePlanAdapter> scenePlanAdapterMembersInjector,
      Provider<Context> contextProvider) {
    return new ScenePlanAdapter_Factory(scenePlanAdapterMembersInjector, contextProvider);
  }
}
