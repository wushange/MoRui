package cn.connxun.morui.di.module;

import cn.connxun.morui.db.DaoSession;
import cn.connxun.morui.db.Task_AllotDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DBModule_GetTask_AllotDaoFactory implements Factory<Task_AllotDao> {
  private final DBModule module;

  private final Provider<DaoSession> sessionProvider;

  public DBModule_GetTask_AllotDaoFactory(DBModule module, Provider<DaoSession> sessionProvider) {
    assert module != null;
    this.module = module;
    assert sessionProvider != null;
    this.sessionProvider = sessionProvider;
  }

  @Override
  public Task_AllotDao get() {
    return Preconditions.checkNotNull(
        module.getTask_AllotDao(sessionProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Task_AllotDao> create(
      DBModule module, Provider<DaoSession> sessionProvider) {
    return new DBModule_GetTask_AllotDaoFactory(module, sessionProvider);
  }

  /** Proxies {@link DBModule#getTask_AllotDao(DaoSession)}. */
  public static Task_AllotDao proxyGetTask_AllotDao(DBModule instance, DaoSession session) {
    return instance.getTask_AllotDao(session);
  }
}
