package cn.connxun.morui.ui.task.taskallot;

import cn.connxun.morui.api.TaskApi;
import cn.connxun.morui.data.local.TaskStroge;
import cn.connxun.morui.data.local.UserStorge;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TaskAllotPresenter_Factory implements Factory<TaskAllotPresenter> {
  private final MembersInjector<TaskAllotPresenter> taskAllotPresenterMembersInjector;

  private final Provider<TaskApi> apiProvider;

  private final Provider<UserStorge> userStorgeProvider;

  private final Provider<TaskStroge> taskStrogeProvider;

  public TaskAllotPresenter_Factory(
      MembersInjector<TaskAllotPresenter> taskAllotPresenterMembersInjector,
      Provider<TaskApi> apiProvider,
      Provider<UserStorge> userStorgeProvider,
      Provider<TaskStroge> taskStrogeProvider) {
    assert taskAllotPresenterMembersInjector != null;
    this.taskAllotPresenterMembersInjector = taskAllotPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
    assert userStorgeProvider != null;
    this.userStorgeProvider = userStorgeProvider;
    assert taskStrogeProvider != null;
    this.taskStrogeProvider = taskStrogeProvider;
  }

  @Override
  public TaskAllotPresenter get() {
    return MembersInjectors.injectMembers(
        taskAllotPresenterMembersInjector,
        new TaskAllotPresenter(
            apiProvider.get(), userStorgeProvider.get(), taskStrogeProvider.get()));
  }

  public static Factory<TaskAllotPresenter> create(
      MembersInjector<TaskAllotPresenter> taskAllotPresenterMembersInjector,
      Provider<TaskApi> apiProvider,
      Provider<UserStorge> userStorgeProvider,
      Provider<TaskStroge> taskStrogeProvider) {
    return new TaskAllotPresenter_Factory(
        taskAllotPresenterMembersInjector, apiProvider, userStorgeProvider, taskStrogeProvider);
  }
}
