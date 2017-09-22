package cn.connxun.morui.ui.task.taskstep;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TaskStepActivity_MembersInjector implements MembersInjector<TaskStepActivity> {
  private final Provider<TaskStepPresenter> presenterProvider;

  public TaskStepActivity_MembersInjector(Provider<TaskStepPresenter> presenterProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<TaskStepActivity> create(
      Provider<TaskStepPresenter> presenterProvider) {
    return new TaskStepActivity_MembersInjector(presenterProvider);
  }

  @Override
  public void injectMembers(TaskStepActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
  }

  public static void injectPresenter(
      TaskStepActivity instance, Provider<TaskStepPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }
}
