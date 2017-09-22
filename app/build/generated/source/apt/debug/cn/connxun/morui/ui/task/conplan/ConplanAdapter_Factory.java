package cn.connxun.morui.ui.task.conplan;

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
public final class ConplanAdapter_Factory implements Factory<ConplanAdapter> {
  private final MembersInjector<ConplanAdapter> conplanAdapterMembersInjector;

  private final Provider<Context> contextProvider;

  public ConplanAdapter_Factory(
      MembersInjector<ConplanAdapter> conplanAdapterMembersInjector,
      Provider<Context> contextProvider) {
    assert conplanAdapterMembersInjector != null;
    this.conplanAdapterMembersInjector = conplanAdapterMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public ConplanAdapter get() {
    return MembersInjectors.injectMembers(
        conplanAdapterMembersInjector, new ConplanAdapter(contextProvider.get()));
  }

  public static Factory<ConplanAdapter> create(
      MembersInjector<ConplanAdapter> conplanAdapterMembersInjector,
      Provider<Context> contextProvider) {
    return new ConplanAdapter_Factory(conplanAdapterMembersInjector, contextProvider);
  }
}
