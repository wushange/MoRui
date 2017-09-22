package cn.connxun.morui.di.module;

import android.content.Context;
import cn.connxun.morui.data.local.TaskStroge;
import cn.connxun.morui.data.local.UserStorge;
import cn.connxun.morui.db.TaskDao;
import cn.connxun.morui.db.TaskSubDao;
import cn.connxun.morui.db.Task_AllotDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideTaskStrogeFactory implements Factory<TaskStroge> {
  private final ApplicationModule module;

  private final Provider<Context> mContextProvider;

  private final Provider<TaskDao> allotTaskDaoProvider;

  private final Provider<TaskSubDao> subListBeanDaoProvider;

  private final Provider<Task_AllotDao> allotDaoProvider;

  private final Provider<UserStorge> userStorgeProvider;

  public ApplicationModule_ProvideTaskStrogeFactory(
      ApplicationModule module,
      Provider<Context> mContextProvider,
      Provider<TaskDao> allotTaskDaoProvider,
      Provider<TaskSubDao> subListBeanDaoProvider,
      Provider<Task_AllotDao> allotDaoProvider,
      Provider<UserStorge> userStorgeProvider) {
    assert module != null;
    this.module = module;
    assert mContextProvider != null;
    this.mContextProvider = mContextProvider;
    assert allotTaskDaoProvider != null;
    this.allotTaskDaoProvider = allotTaskDaoProvider;
    assert subListBeanDaoProvider != null;
    this.subListBeanDaoProvider = subListBeanDaoProvider;
    assert allotDaoProvider != null;
    this.allotDaoProvider = allotDaoProvider;
    assert userStorgeProvider != null;
    this.userStorgeProvider = userStorgeProvider;
  }

  @Override
  public TaskStroge get() {
    return Preconditions.checkNotNull(
        module.provideTaskStroge(
            mContextProvider.get(),
            allotTaskDaoProvider.get(),
            subListBeanDaoProvider.get(),
            allotDaoProvider.get(),
            userStorgeProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<TaskStroge> create(
      ApplicationModule module,
      Provider<Context> mContextProvider,
      Provider<TaskDao> allotTaskDaoProvider,
      Provider<TaskSubDao> subListBeanDaoProvider,
      Provider<Task_AllotDao> allotDaoProvider,
      Provider<UserStorge> userStorgeProvider) {
    return new ApplicationModule_ProvideTaskStrogeFactory(
        module,
        mContextProvider,
        allotTaskDaoProvider,
        subListBeanDaoProvider,
        allotDaoProvider,
        userStorgeProvider);
  }

  /**
   * Proxies {@link ApplicationModule#provideTaskStroge(Context, TaskDao, TaskSubDao, Task_AllotDao,
   * UserStorge)}.
   */
  public static TaskStroge proxyProvideTaskStroge(
      ApplicationModule instance,
      Context mContext,
      TaskDao allotTaskDao,
      TaskSubDao subListBeanDao,
      Task_AllotDao allotDao,
      UserStorge userStorge) {
    return instance.provideTaskStroge(mContext, allotTaskDao, subListBeanDao, allotDao, userStorge);
  }
}
