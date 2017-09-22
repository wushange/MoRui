package cn.connxun.morui.ui.task.taskallot;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TaskAllotAdapter_Factory implements Factory<TaskAllotAdapter> {
  private final MembersInjector<TaskAllotAdapter> taskAllotAdapterMembersInjector;

  public TaskAllotAdapter_Factory(
      MembersInjector<TaskAllotAdapter> taskAllotAdapterMembersInjector) {
    assert taskAllotAdapterMembersInjector != null;
    this.taskAllotAdapterMembersInjector = taskAllotAdapterMembersInjector;
  }

  @Override
  public TaskAllotAdapter get() {
    return MembersInjectors.injectMembers(taskAllotAdapterMembersInjector, new TaskAllotAdapter());
  }

  public static Factory<TaskAllotAdapter> create(
      MembersInjector<TaskAllotAdapter> taskAllotAdapterMembersInjector) {
    return new TaskAllotAdapter_Factory(taskAllotAdapterMembersInjector);
  }
}
