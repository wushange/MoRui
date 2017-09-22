package cn.connxun.morui.ui.home;

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
public final class HomeMenuAdapter_Factory implements Factory<HomeMenuAdapter> {
  private final MembersInjector<HomeMenuAdapter> homeMenuAdapterMembersInjector;

  private final Provider<Context> contextProvider;

  public HomeMenuAdapter_Factory(
      MembersInjector<HomeMenuAdapter> homeMenuAdapterMembersInjector,
      Provider<Context> contextProvider) {
    assert homeMenuAdapterMembersInjector != null;
    this.homeMenuAdapterMembersInjector = homeMenuAdapterMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public HomeMenuAdapter get() {
    return MembersInjectors.injectMembers(
        homeMenuAdapterMembersInjector, new HomeMenuAdapter(contextProvider.get()));
  }

  public static Factory<HomeMenuAdapter> create(
      MembersInjector<HomeMenuAdapter> homeMenuAdapterMembersInjector,
      Provider<Context> contextProvider) {
    return new HomeMenuAdapter_Factory(homeMenuAdapterMembersInjector, contextProvider);
  }
}
