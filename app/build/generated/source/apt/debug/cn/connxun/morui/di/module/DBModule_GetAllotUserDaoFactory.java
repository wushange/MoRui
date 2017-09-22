package cn.connxun.morui.di.module;

import cn.connxun.morui.db.AllotUserDao;
import cn.connxun.morui.db.DaoSession;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DBModule_GetAllotUserDaoFactory implements Factory<AllotUserDao> {
  private final DBModule module;

  private final Provider<DaoSession> sessionProvider;

  public DBModule_GetAllotUserDaoFactory(DBModule module, Provider<DaoSession> sessionProvider) {
    assert module != null;
    this.module = module;
    assert sessionProvider != null;
    this.sessionProvider = sessionProvider;
  }

  @Override
  public AllotUserDao get() {
    return Preconditions.checkNotNull(
        module.getAllotUserDao(sessionProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AllotUserDao> create(
      DBModule module, Provider<DaoSession> sessionProvider) {
    return new DBModule_GetAllotUserDaoFactory(module, sessionProvider);
  }

  /** Proxies {@link DBModule#getAllotUserDao(DaoSession)}. */
  public static AllotUserDao proxyGetAllotUserDao(DBModule instance, DaoSession session) {
    return instance.getAllotUserDao(session);
  }
}
