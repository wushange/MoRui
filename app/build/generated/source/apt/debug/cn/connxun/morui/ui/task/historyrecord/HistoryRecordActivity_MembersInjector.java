package cn.connxun.morui.ui.task.historyrecord;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HistoryRecordActivity_MembersInjector
    implements MembersInjector<HistoryRecordActivity> {
  private final Provider<HistoryRecordPresenter> presenterProvider;

  private final Provider<HistoryRecordAdapter> adapterProvider;

  public HistoryRecordActivity_MembersInjector(
      Provider<HistoryRecordPresenter> presenterProvider,
      Provider<HistoryRecordAdapter> adapterProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
    assert adapterProvider != null;
    this.adapterProvider = adapterProvider;
  }

  public static MembersInjector<HistoryRecordActivity> create(
      Provider<HistoryRecordPresenter> presenterProvider,
      Provider<HistoryRecordAdapter> adapterProvider) {
    return new HistoryRecordActivity_MembersInjector(presenterProvider, adapterProvider);
  }

  @Override
  public void injectMembers(HistoryRecordActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
    instance.adapter = adapterProvider.get();
  }

  public static void injectPresenter(
      HistoryRecordActivity instance, Provider<HistoryRecordPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }

  public static void injectAdapter(
      HistoryRecordActivity instance, Provider<HistoryRecordAdapter> adapterProvider) {
    instance.adapter = adapterProvider.get();
  }
}
