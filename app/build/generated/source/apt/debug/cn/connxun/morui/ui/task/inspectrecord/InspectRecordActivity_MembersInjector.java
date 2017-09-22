package cn.connxun.morui.ui.task.inspectrecord;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class InspectRecordActivity_MembersInjector
    implements MembersInjector<InspectRecordActivity> {
  private final Provider<InspectRecordPresenter> presenterProvider;

  private final Provider<InspectRecordAdapter> adapterProvider;

  public InspectRecordActivity_MembersInjector(
      Provider<InspectRecordPresenter> presenterProvider,
      Provider<InspectRecordAdapter> adapterProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
    assert adapterProvider != null;
    this.adapterProvider = adapterProvider;
  }

  public static MembersInjector<InspectRecordActivity> create(
      Provider<InspectRecordPresenter> presenterProvider,
      Provider<InspectRecordAdapter> adapterProvider) {
    return new InspectRecordActivity_MembersInjector(presenterProvider, adapterProvider);
  }

  @Override
  public void injectMembers(InspectRecordActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
    instance.adapter = adapterProvider.get();
  }

  public static void injectPresenter(
      InspectRecordActivity instance, Provider<InspectRecordPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }

  public static void injectAdapter(
      InspectRecordActivity instance, Provider<InspectRecordAdapter> adapterProvider) {
    instance.adapter = adapterProvider.get();
  }
}
