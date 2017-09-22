package cn.connxun.morui.ui.task.taskdetails;

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
public final class TaskDetailsPresenter_Factory implements Factory<TaskDetailsPresenter> {
  private final MembersInjector<TaskDetailsPresenter> taskDetailsPresenterMembersInjector;

  private final Provider<TaskSubDao> allotTaskSubListBeanDaoProvider;

  public TaskDetailsPresenter_Factory(
      MembersInjector<TaskDetailsPresenter> taskDetailsPresenterMembersInjector,
      Provider<TaskSubDao> allotTaskSubListBeanDaoProvider) {
    assert taskDetailsPresenterMembersInjector != null;
    this.taskDetailsPresenterMembersInjector = taskDetailsPresenterMembersInjector;
    assert allotTaskSubListBeanDaoProvider != null;
    this.allotTaskSubListBeanDaoProvider = allotTaskSubListBeanDaoProvider;
  }

  @Override
  public TaskDetailsPresenter get() {
    return MembersInjectors.injectMembers(
        taskDetailsPresenterMembersInjector,
        new TaskDetailsPresenter(allotTaskSubListBeanDaoProvider.get()));
  }

  public static Factory<TaskDetailsPresenter> create(
      MembersInjector<TaskDetailsPresenter> taskDetailsPresenterMembersInjector,
      Provider<TaskSubDao> allotTaskSubListBeanDaoProvider) {
    return new TaskDetailsPresenter_Factory(
        taskDetailsPresenterMembersInjector, allotTaskSubListBeanDaoProvider);
  }
}
