package cn.connxun.morui.ui.task.taskallot;

import cn.connxun.morui.api.TaskApi;
import cn.connxun.morui.data.local.TaskStroge;
import cn.connxun.morui.data.local.UserStorge;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TaskAllotedFragment_MembersInjector
    implements MembersInjector<TaskAllotedFragment> {
  private final Provider<TaskAllotAdapter> adapterProvider;

  private final Provider<TaskApi> apiProvider;

  private final Provider<UserStorge> userStorgeProvider;

  private final Provider<TaskStroge> taskStrogeProvider;

  public TaskAllotedFragment_MembersInjector(
      Provider<TaskAllotAdapter> adapterProvider,
      Provider<TaskApi> apiProvider,
      Provider<UserStorge> userStorgeProvider,
      Provider<TaskStroge> taskStrogeProvider) {
    assert adapterProvider != null;
    this.adapterProvider = adapterProvider;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
    assert userStorgeProvider != null;
    this.userStorgeProvider = userStorgeProvider;
    assert taskStrogeProvider != null;
    this.taskStrogeProvider = taskStrogeProvider;
  }

  public static MembersInjector<TaskAllotedFragment> create(
      Provider<TaskAllotAdapter> adapterProvider,
      Provider<TaskApi> apiProvider,
      Provider<UserStorge> userStorgeProvider,
      Provider<TaskStroge> taskStrogeProvider) {
    return new TaskAllotedFragment_MembersInjector(
        adapterProvider, apiProvider, userStorgeProvider, taskStrogeProvider);
  }

  @Override
  public void injectMembers(TaskAllotedFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.adapter = adapterProvider.get();
    instance.api = apiProvider.get();
    instance.userStorge = userStorgeProvider.get();
    instance.taskStroge = taskStrogeProvider.get();
  }

  public static void injectAdapter(
      TaskAllotedFragment instance, Provider<TaskAllotAdapter> adapterProvider) {
    instance.adapter = adapterProvider.get();
  }

  public static void injectApi(TaskAllotedFragment instance, Provider<TaskApi> apiProvider) {
    instance.api = apiProvider.get();
  }

  public static void injectUserStorge(
      TaskAllotedFragment instance, Provider<UserStorge> userStorgeProvider) {
    instance.userStorge = userStorgeProvider.get();
  }

  public static void injectTaskStroge(
      TaskAllotedFragment instance, Provider<TaskStroge> taskStrogeProvider) {
    instance.taskStroge = taskStrogeProvider.get();
  }
}
