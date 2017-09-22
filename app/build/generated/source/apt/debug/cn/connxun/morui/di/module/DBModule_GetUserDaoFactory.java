package cn.connxun.morui.di.module;

import cn.connxun.morui.db.DaoSession;
import cn.connxun.morui.db.UserDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DBModule_GetUserDaoFactory implements Factory<UserDao> {
  private final DBModule module;

  private final Provider<DaoSession> sessionProvider;

  public DBModule_GetUserDaoFactory(DBModule module, Provider<DaoSession> sessionProvider) {
    assert module != null;
    this.module = module;
    assert sessionProvider != null;
    this.sessionProvider = sessionProvider;
  }

  @Override
  public UserDao get() {
    return Preconditions.checkNotNull(
        module.getUserDao(sessionProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<UserDao> create(DBModule module, Provider<DaoSession> sessionProvider) {
    return new DBModule_GetUserDaoFactory(module, sessionProvider);
  }

  /** Proxies {@link DBModule#getUserDao(DaoSession)}. */
  public static UserDao proxyGetUserDao(DBModule instance, DaoSession session) {
    return instance.getUserDao(session);
  }
}
