package cn.connxun.morui.ui.task.taskdetails;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TaskDetailsActivity_MembersInjector
    implements MembersInjector<TaskDetailsActivity> {
  private final Provider<TaskDetailsPresenter> presenterProvider;

  private final Provider<TaskDetailsAdapter> adapterProvider;

  public TaskDetailsActivity_MembersInjector(
      Provider<TaskDetailsPresenter> presenterProvider,
      Provider<TaskDetailsAdapter> adapterProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
    assert adapterProvider != null;
    this.adapterProvider = adapterProvider;
  }

  public static MembersInjector<TaskDetailsActivity> create(
      Provider<TaskDetailsPresenter> presenterProvider,
      Provider<TaskDetailsAdapter> adapterProvider) {
    return new TaskDetailsActivity_MembersInjector(presenterProvider, adapterProvider);
  }

  @Override
  public void injectMembers(TaskDetailsActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
    instance.adapter = adapterProvider.get();
  }

  public static void injectPresenter(
      TaskDetailsActivity instance, Provider<TaskDetailsPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }

  public static void injectAdapter(
      TaskDetailsActivity instance, Provider<TaskDetailsAdapter> adapterProvider) {
    instance.adapter = adapterProvider.get();
  }
}
