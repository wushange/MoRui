package cn.connxun.morui.ui.filedoc;

import cn.connxun.morui.api.DocumentApi;
import cn.connxun.morui.data.local.DocumentStorge;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FileDocPresenter_Factory implements Factory<FileDocPresenter> {
  private final MembersInjector<FileDocPresenter> fileDocPresenterMembersInjector;

  private final Provider<DocumentApi> documentApiProvider;

  private final Provider<DocumentStorge> storgeProvider;

  public FileDocPresenter_Factory(
      MembersInjector<FileDocPresenter> fileDocPresenterMembersInjector,
      Provider<DocumentApi> documentApiProvider,
      Provider<DocumentStorge> storgeProvider) {
    assert fileDocPresenterMembersInjector != null;
    this.fileDocPresenterMembersInjector = fileDocPresenterMembersInjector;
    assert documentApiProvider != null;
    this.documentApiProvider = documentApiProvider;
    assert storgeProvider != null;
    this.storgeProvider = storgeProvider;
  }

  @Override
  public FileDocPresenter get() {
    return MembersInjectors.injectMembers(
        fileDocPresenterMembersInjector,
        new FileDocPresenter(documentApiProvider.get(), storgeProvider.get()));
  }

  public static Factory<FileDocPresenter> create(
      MembersInjector<FileDocPresenter> fileDocPresenterMembersInjector,
      Provider<DocumentApi> documentApiProvider,
      Provider<DocumentStorge> storgeProvider) {
    return new FileDocPresenter_Factory(
        fileDocPresenterMembersInjector, documentApiProvider, storgeProvider);
  }
}
