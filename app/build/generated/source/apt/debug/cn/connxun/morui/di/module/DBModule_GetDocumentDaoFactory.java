package cn.connxun.morui.di.module;

import cn.connxun.morui.db.DaoSession;
import cn.connxun.morui.db.DocumentDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DBModule_GetDocumentDaoFactory implements Factory<DocumentDao> {
  private final DBModule module;

  private final Provider<DaoSession> sessionProvider;

  public DBModule_GetDocumentDaoFactory(DBModule module, Provider<DaoSession> sessionProvider) {
    assert module != null;
    this.module = module;
    assert sessionProvider != null;
    this.sessionProvider = sessionProvider;
  }

  @Override
  public DocumentDao get() {
    return Preconditions.checkNotNull(
        module.getDocumentDao(sessionProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<DocumentDao> create(DBModule module, Provider<DaoSession> sessionProvider) {
    return new DBModule_GetDocumentDaoFactory(module, sessionProvider);
  }

  /** Proxies {@link DBModule#getDocumentDao(DaoSession)}. */
  public static DocumentDao proxyGetDocumentDao(DBModule instance, DaoSession session) {
    return instance.getDocumentDao(session);
  }
}
