package cn.connxun.morui.ui.task.historyrecord;

import cn.connxun.morui.api.TaskApi;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HistoryRecordPresenter_Factory implements Factory<HistoryRecordPresenter> {
  private final MembersInjector<HistoryRecordPresenter> historyRecordPresenterMembersInjector;

  private final Provider<TaskApi> taskApiProvider;

  public HistoryRecordPresenter_Factory(
      MembersInjector<HistoryRecordPresenter> historyRecordPresenterMembersInjector,
      Provider<TaskApi> taskApiProvider) {
    assert historyRecordPresenterMembersInjector != null;
    this.historyRecordPresenterMembersInjector = historyRecordPresenterMembersInjector;
    assert taskApiProvider != null;
    this.taskApiProvider = taskApiProvider;
  }

  @Override
  public HistoryRecordPresenter get() {
    return MembersInjectors.injectMembers(
        historyRecordPresenterMembersInjector, new HistoryRecordPresenter(taskApiProvider.get()));
  }

  public static Factory<HistoryRecordPresenter> create(
      MembersInjector<HistoryRecordPresenter> historyRecordPresenterMembersInjector,
      Provider<TaskApi> taskApiProvider) {
    return new HistoryRecordPresenter_Factory(
        historyRecordPresenterMembersInjector, taskApiProvider);
  }
}
