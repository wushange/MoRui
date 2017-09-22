package cn.connxun.morui.ui.task.taskinspect;

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
public final class TaskInspectAdapter_Factory implements Factory<TaskInspectAdapter> {
  private final MembersInjector<TaskInspectAdapter> taskInspectAdapterMembersInjector;

  private final Provider<Context> contextProvider;

  public TaskInspectAdapter_Factory(
      MembersInjector<TaskInspectAdapter> taskInspectAdapterMembersInjector,
      Provider<Context> contextProvider) {
    assert taskInspectAdapterMembersInjector != null;
    this.taskInspectAdapterMembersInjector = taskInspectAdapterMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public TaskInspectAdapter get() {
    return MembersInjectors.injectMembers(
        taskInspectAdapterMembersInjector, new TaskInspectAdapter(contextProvider.get()));
  }

  public static Factory<TaskInspectAdapter> create(
      MembersInjector<TaskInspectAdapter> taskInspectAdapterMembersInjector,
      Provider<Context> contextProvider) {
    return new TaskInspectAdapter_Factory(taskInspectAdapterMembersInjector, contextProvider);
  }
}
