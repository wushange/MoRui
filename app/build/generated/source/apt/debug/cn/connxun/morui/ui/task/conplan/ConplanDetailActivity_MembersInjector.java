package cn.connxun.morui.ui.task.conplan;

import cn.connxun.morui.api.PlanApi;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ConplanDetailActivity_MembersInjector
    implements MembersInjector<ConplanDetailActivity> {
  private final Provider<PlanApi> apiProvider;

  public ConplanDetailActivity_MembersInjector(Provider<PlanApi> apiProvider) {
    assert apiProvider != null;
    this.apiProvider = apiProvider;
  }

  public static MembersInjector<ConplanDetailActivity> create(Provider<PlanApi> apiProvider) {
    return new ConplanDetailActivity_MembersInjector(apiProvider);
  }

  @Override
  public void injectMembers(ConplanDetailActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.api = apiProvider.get();
  }

  public static void injectApi(ConplanDetailActivity instance, Provider<PlanApi> apiProvider) {
    instance.api = apiProvider.get();
  }
}
