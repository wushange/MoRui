package cn.connxun.morui.ui.task.taskdetails;

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
public final class TaskDetailsAdapter_Factory implements Factory<TaskDetailsAdapter> {
  private final MembersInjector<TaskDetailsAdapter> taskDetailsAdapterMembersInjector;

  private final Provider<Context> contextProvider;

  public TaskDetailsAdapter_Factory(
      MembersInjector<TaskDetailsAdapter> taskDetailsAdapterMembersInjector,
      Provider<Context> contextProvider) {
    assert taskDetailsAdapterMembersInjector != null;
    this.taskDetailsAdapterMembersInjector = taskDetailsAdapterMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public TaskDetailsAdapter get() {
    return MembersInjectors.injectMembers(
        taskDetailsAdapterMembersInjector, new TaskDetailsAdapter(contextProvider.get()));
  }

  public static Factory<TaskDetailsAdapter> create(
      MembersInjector<TaskDetailsAdapter> taskDetailsAdapterMembersInjector,
      Provider<Context> contextProvider) {
    return new TaskDetailsAdapter_Factory(taskDetailsAdapterMembersInjector, contextProvider);
  }
}
