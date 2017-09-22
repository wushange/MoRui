package cn.connxun.morui.ui.task.sceneplan;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ScenePlanPresenter_Factory implements Factory<ScenePlanPresenter> {
  private final MembersInjector<ScenePlanPresenter> scenePlanPresenterMembersInjector;

  public ScenePlanPresenter_Factory(
      MembersInjector<ScenePlanPresenter> scenePlanPresenterMembersInjector) {
    assert scenePlanPresenterMembersInjector != null;
    this.scenePlanPresenterMembersInjector = scenePlanPresenterMembersInjector;
  }

  @Override
  public ScenePlanPresenter get() {
    return MembersInjectors.injectMembers(
        scenePlanPresenterMembersInjector, new ScenePlanPresenter());
  }

  public static Factory<ScenePlanPresenter> create(
      MembersInjector<ScenePlanPresenter> scenePlanPresenterMembersInjector) {
    return new ScenePlanPresenter_Factory(scenePlanPresenterMembersInjector);
  }
}
