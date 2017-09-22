package cn.connxun.morui.di.module;

import cn.connxun.morui.db.DaoSession;
import cn.connxun.morui.db.TaskSubDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DBModule_GetTaskSubDaoFactory implements Factory<TaskSubDao> {
  private final DBModule module;

  private final Provider<DaoSession> sessionProvider;

  public DBModule_GetTaskSubDaoFactory(DBModule module, Provider<DaoSession> sessionProvider) {
    assert module != null;
    this.module = module;
    assert sessionProvider != null;
    this.sessionProvider = sessionProvider;
  }

  @Override
  public TaskSubDao get() {
    return Preconditions.checkNotNull(
        module.getTaskSubDao(sessionProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<TaskSubDao> create(DBModule module, Provider<DaoSession> sessionProvider) {
    return new DBModule_GetTaskSubDaoFactory(module, sessionProvider);
  }

  /** Proxies {@link DBModule#getTaskSubDao(DaoSession)}. */
  public static TaskSubDao proxyGetTaskSubDao(DBModule instance, DaoSession session) {
    return instance.getTaskSubDao(session);
  }
}
