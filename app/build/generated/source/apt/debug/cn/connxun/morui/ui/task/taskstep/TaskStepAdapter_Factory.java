package cn.connxun.morui.ui.task.taskstep;

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
public final class TaskStepAdapter_Factory implements Factory<TaskStepAdapter> {
  private final MembersInjector<TaskStepAdapter> taskStepAdapterMembersInjector;

  private final Provider<Context> contextProvider;

  public TaskStepAdapter_Factory(
      MembersInjector<TaskStepAdapter> taskStepAdapterMembersInjector,
      Provider<Context> contextProvider) {
    assert taskStepAdapterMembersInjector != null;
    this.taskStepAdapterMembersInjector = taskStepAdapterMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public TaskStepAdapter get() {
    return MembersInjectors.injectMembers(
        taskStepAdapterMembersInjector, new TaskStepAdapter(contextProvider.get()));
  }

  public static Factory<TaskStepAdapter> create(
      MembersInjector<TaskStepAdapter> taskStepAdapterMembersInjector,
      Provider<Context> contextProvider) {
    return new TaskStepAdapter_Factory(taskStepAdapterMembersInjector, contextProvider);
  }
}
