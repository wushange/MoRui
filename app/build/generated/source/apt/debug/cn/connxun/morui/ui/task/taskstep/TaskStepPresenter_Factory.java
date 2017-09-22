package cn.connxun.morui.ui.task.taskstep;

import cn.connxun.morui.db.TaskDao;
import cn.connxun.morui.db.TaskSubDao;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TaskStepPresenter_Factory implements Factory<TaskStepPresenter> {
  private final MembersInjector<TaskStepPresenter> taskStepPresenterMembersInjector;

  private final Provider<TaskSubDao> subListBeanDaoProvider;

  private final Provider<TaskDao> allotTaskDaoProvider;

  public TaskStepPresenter_Factory(
      MembersInjector<TaskStepPresenter> taskStepPresenterMembersInjector,
      Provider<TaskSubDao> subListBeanDaoProvider,
      Provider<TaskDao> allotTaskDaoProvider) {
    assert taskStepPresenterMembersInjector != null;
    this.taskStepPresenterMembersInjector = taskStepPresenterMembersInjector;
    assert subListBeanDaoProvider != null;
    this.subListBeanDaoProvider = subListBeanDaoProvider;
    assert allotTaskDaoProvider != null;
    this.allotTaskDaoProvider = allotTaskDaoProvider;
  }

  @Override
  public TaskStepPresenter get() {
    return MembersInjectors.injectMembers(
        taskStepPresenterMembersInjector,
        new TaskStepPresenter(subListBeanDaoProvider.get(), allotTaskDaoProvider.get()));
  }

  public static Factory<TaskStepPresenter> create(
      MembersInjector<TaskStepPresenter> taskStepPresenterMembersInjector,
      Provider<TaskSubDao> subListBeanDaoProvider,
      Provider<TaskDao> allotTaskDaoProvider) {
    return new TaskStepPresenter_Factory(
        taskStepPresenterMembersInjector, subListBeanDaoProvider, allotTaskDaoProvider);
  }
}
