package cn.connxun.morui.ui.task.taskinspect;

import cn.connxun.morui.api.TaskApi;
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
public final class TaskInspectPresenter_Factory implements Factory<TaskInspectPresenter> {
  private final MembersInjector<TaskInspectPresenter> taskInspectPresenterMembersInjector;

  private final Provider<TaskApi> apiProvider;

  private final Provider<TaskStroge> strogeProvider;

  public TaskInspectPresenter_Factory(
      MembersInjector<TaskInspectPresenter> taskInspectPresenterMembersInjector,
      Provider<TaskApi> apiProvider,
      Provider<TaskStroge> strogeProvider) {
    assert taskInspectPresenterMembersInjector != null;
    this.taskInspectPresenterMembersInjector = taskInspectPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
    assert strogeProvider != null;
    this.strogeProvider = strogeProvider;
  }

  @Override
  public TaskInspectPresenter get() {
    return MembersInjectors.injectMembers(
        taskInspectPresenterMembersInjector,
        new TaskInspectPresenter(apiProvider.get(), strogeProvider.get()));
  }

  public static Factory<TaskInspectPresenter> create(
      MembersInjector<TaskInspectPresenter> taskInspectPresenterMembersInjector,
      Provider<TaskApi> apiProvider,
      Provider<TaskStroge> strogeProvider) {
    return new TaskInspectPresenter_Factory(
        taskInspectPresenterMembersInjector, apiProvider, strogeProvider);
  }
}
