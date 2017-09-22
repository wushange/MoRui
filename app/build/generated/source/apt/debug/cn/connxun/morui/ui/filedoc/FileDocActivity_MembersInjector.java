package cn.connxun.morui.ui.filedoc;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FileDocActivity_MembersInjector implements MembersInjector<FileDocActivity> {
  private final Provider<FileDocAdapter> adapterProvider;

  private final Provider<FileDocPresenter> presenterProvider;

  public FileDocActivity_MembersInjector(
      Provider<FileDocAdapter> adapterProvider, Provider<FileDocPresenter> presenterProvider) {
    assert adapterProvider != null;
    this.adapterProvider = adapterProvider;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<FileDocActivity> create(
      Provider<FileDocAdapter> adapterProvider, Provider<FileDocPresenter> presenterProvider) {
    return new FileDocActivity_MembersInjector(adapterProvider, presenterProvider);
  }

  @Override
  public void injectMembers(FileDocActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.adapter = adapterProvider.get();
    instance.presenter = presenterProvider.get();
  }

  public static void injectAdapter(
      FileDocActivity instance, Provider<FileDocAdapter> adapterProvider) {
    instance.adapter = adapterProvider.get();
  }

  public static void injectPresenter(
      FileDocActivity instance, Provider<FileDocPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }
}
