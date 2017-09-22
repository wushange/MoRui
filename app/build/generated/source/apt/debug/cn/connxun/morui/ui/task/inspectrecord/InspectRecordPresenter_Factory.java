package cn.connxun.morui.ui.task.inspectrecord;

import cn.connxun.morui.data.local.TaskStroge;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class InspectRecordPresenter_Factory implements Factory<InspectRecordPresenter> {
  private final MembersInjector<InspectRecordPresenter> inspectRecordPresenterMembersInjector;

  private final Provider<TaskStroge> taskStrogeProvider;

  public InspectRecordPresenter_Factory(
      MembersInjector<InspectRecordPresenter> inspectRecordPresenterMembersInjector,
      Provider<TaskStroge> taskStrogeProvider) {
    assert inspectRecordPresenterMembersInjector != null;
    this.inspectRecordPresenterMembersInjector = inspectRecordPresenterMembersInjector;
    assert taskStrogeProvider != null;
    this.taskStrogeProvider = taskStrogeProvider;
  }

  @Override
  public InspectRecordPresenter get() {
    return MembersInjectors.injectMembers(
        inspectRecordPresenterMembersInjector,
        new InspectRecordPresenter(taskStrogeProvider.get()));
  }

  public static Factory<InspectRecordPresenter> create(
      MembersInjector<InspectRecordPresenter> inspectRecordPresenterMembersInjector,
      Provider<TaskStroge> taskStrogeProvider) {
    return new InspectRecordPresenter_Factory(
        inspectRecordPresenterMembersInjector, taskStrogeProvider);
  }
}
