package cn.connxun.morui.ui.filedoc;

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
public final class FileDocAdapter_Factory implements Factory<FileDocAdapter> {
  private final MembersInjector<FileDocAdapter> fileDocAdapterMembersInjector;

  private final Provider<Context> contextProvider;

  public FileDocAdapter_Factory(
      MembersInjector<FileDocAdapter> fileDocAdapterMembersInjector,
      Provider<Context> contextProvider) {
    assert fileDocAdapterMembersInjector != null;
    this.fileDocAdapterMembersInjector = fileDocAdapterMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public FileDocAdapter get() {
    return MembersInjectors.injectMembers(
        fileDocAdapterMembersInjector, new FileDocAdapter(contextProvider.get()));
  }

  public static Factory<FileDocAdapter> create(
      MembersInjector<FileDocAdapter> fileDocAdapterMembersInjector,
      Provider<Context> contextProvider) {
    return new FileDocAdapter_Factory(fileDocAdapterMembersInjector, contextProvider);
  }
}
