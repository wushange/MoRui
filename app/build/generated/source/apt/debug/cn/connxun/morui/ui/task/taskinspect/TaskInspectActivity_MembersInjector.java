package cn.connxun.morui.ui.task.taskinspect;

import cn.connxun.morui.db.TaskDao;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TaskInspectActivity_MembersInjector
    implements MembersInjector<TaskInspectActivity> {
  private final Provider<TaskInspectPresenter> presenterProvider;

  private final Provider<TaskInspectAdapter> adapterProvider;

  private final Provider<TaskDao> taskDaoProvider;

  public TaskInspectActivity_MembersInjector(
      Provider<TaskInspectPresenter> presenterProvider,
      Provider<TaskInspectAdapter> adapterProvider,
      Provider<TaskDao> taskDaoProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
    assert adapterProvider != null;
    this.adapterProvider = adapterProvider;
    assert taskDaoProvider != null;
    this.taskDaoProvider = taskDaoProvider;
  }

  public static MembersInjector<TaskInspectActivity> create(
      Provider<TaskInspectPresenter> presenterProvider,
      Provider<TaskInspectAdapter> adapterProvider,
      Provider<TaskDao> taskDaoProvider) {
    return new TaskInspectActivity_MembersInjector(
        presenterProvider, adapterProvider, taskDaoProvider);
  }

  @Override
  public void injectMembers(TaskInspectActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
    instance.adapter = adapterProvider.get();
    instance.taskDao = taskDaoProvider.get();
  }

  public static void injectPresenter(
      TaskInspectActivity instance, Provider<TaskInspectPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }

  public static void injectAdapter(
      TaskInspectActivity instance, Provider<TaskInspectAdapter> adapterProvider) {
    instance.adapter = adapterProvider.get();
  }

  public static void injectTaskDao(
      TaskInspectActivity instance, Provider<TaskDao> taskDaoProvider) {
    instance.taskDao = taskDaoProvider.get();
  }
}
