package cn.connxun.morui.ui.task.conplan;

import cn.connxun.morui.api.PlanApi;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ConplanPresenter_Factory implements Factory<ConplanPresenter> {
  private final MembersInjector<ConplanPresenter> conplanPresenterMembersInjector;

  private final Provider<PlanApi> planApiProvider;

  public ConplanPresenter_Factory(
      MembersInjector<ConplanPresenter> conplanPresenterMembersInjector,
      Provider<PlanApi> planApiProvider) {
    assert conplanPresenterMembersInjector != null;
    this.conplanPresenterMembersInjector = conplanPresenterMembersInjector;
    assert planApiProvider != null;
    this.planApiProvider = planApiProvider;
  }

  @Override
  public ConplanPresenter get() {
    return MembersInjectors.injectMembers(
        conplanPresenterMembersInjector, new ConplanPresenter(planApiProvider.get()));
  }

  public static Factory<ConplanPresenter> create(
      MembersInjector<ConplanPresenter> conplanPresenterMembersInjector,
      Provider<PlanApi> planApiProvider) {
    return new ConplanPresenter_Factory(conplanPresenterMembersInjector, planApiProvider);
  }
}
