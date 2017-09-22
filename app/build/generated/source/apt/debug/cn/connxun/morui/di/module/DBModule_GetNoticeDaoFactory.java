package cn.connxun.morui.di.module;

import cn.connxun.morui.db.DaoSession;
import cn.connxun.morui.db.NoticeDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DBModule_GetNoticeDaoFactory implements Factory<NoticeDao> {
  private final DBModule module;

  private final Provider<DaoSession> sessionProvider;

  public DBModule_GetNoticeDaoFactory(DBModule module, Provider<DaoSession> sessionProvider) {
    assert module != null;
    this.module = module;
    assert sessionProvider != null;
    this.sessionProvider = sessionProvider;
  }

  @Override
  public NoticeDao get() {
    return Preconditions.checkNotNull(
        module.getNoticeDao(sessionProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<NoticeDao> create(DBModule module, Provider<DaoSession> sessionProvider) {
    return new DBModule_GetNoticeDaoFactory(module, sessionProvider);
  }

  /** Proxies {@link DBModule#getNoticeDao(DaoSession)}. */
  public static NoticeDao proxyGetNoticeDao(DBModule instance, DaoSession session) {
    return instance.getNoticeDao(session);
  }
}
