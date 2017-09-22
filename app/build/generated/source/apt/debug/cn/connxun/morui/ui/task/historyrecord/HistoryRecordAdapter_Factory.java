package cn.connxun.morui.ui.task.historyrecord;

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
public final class HistoryRecordAdapter_Factory implements Factory<HistoryRecordAdapter> {
  private final MembersInjector<HistoryRecordAdapter> historyRecordAdapterMembersInjector;

  private final Provider<Context> contextProvider;

  public HistoryRecordAdapter_Factory(
      MembersInjector<HistoryRecordAdapter> historyRecordAdapterMembersInjector,
      Provider<Context> contextProvider) {
    assert historyRecordAdapterMembersInjector != null;
    this.historyRecordAdapterMembersInjector = historyRecordAdapterMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public HistoryRecordAdapter get() {
    return MembersInjectors.injectMembers(
        historyRecordAdapterMembersInjector, new HistoryRecordAdapter(contextProvider.get()));
  }

  public static Factory<HistoryRecordAdapter> create(
      MembersInjector<HistoryRecordAdapter> historyRecordAdapterMembersInjector,
      Provider<Context> contextProvider) {
    return new HistoryRecordAdapter_Factory(historyRecordAdapterMembersInjector, contextProvider);
  }
}
