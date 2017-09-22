package cn.connxun.morui.di.module;

import cn.connxun.morui.db.DaoSession;
import cn.connxun.morui.db.TaskDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DBModule_GetTaskDaoFactory implements Factory<TaskDao> {
  private final DBModule module;

  private final Provider<DaoSession> sessionProvider;

  public DBModule_GetTaskDaoFactory(DBModule module, Provider<DaoSession> sessionProvider) {
    assert module != null;
    this.module = module;
    assert sessionProvider != null;
    this.sessionProvider = sessionProvider;
  }

  @Override
  public TaskDao get() {
    return Preconditions.checkNotNull(
        module.getTaskDao(sessionProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<TaskDao> create(DBModule module, Provider<DaoSession> sessionProvider) {
    return new DBModule_GetTaskDaoFactory(module, sessionProvider);
  }

  /** Proxies {@link DBModule#getTaskDao(DaoSession)}. */
  public static TaskDao proxyGetTaskDao(DBModule instance, DaoSession session) {
    return instance.getTaskDao(session);
  }
}
