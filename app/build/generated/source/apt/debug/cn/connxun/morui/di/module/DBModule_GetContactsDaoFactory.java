package cn.connxun.morui.di.module;

import cn.connxun.morui.db.ContactsDao;
import cn.connxun.morui.db.DaoSession;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DBModule_GetContactsDaoFactory implements Factory<ContactsDao> {
  private final DBModule module;

  private final Provider<DaoSession> sessionProvider;

  public DBModule_GetContactsDaoFactory(DBModule module, Provider<DaoSession> sessionProvider) {
    assert module != null;
    this.module = module;
    assert sessionProvider != null;
    this.sessionProvider = sessionProvider;
  }

  @Override
  public ContactsDao get() {
    return Preconditions.checkNotNull(
        module.getContactsDao(sessionProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ContactsDao> create(DBModule module, Provider<DaoSession> sessionProvider) {
    return new DBModule_GetContactsDaoFactory(module, sessionProvider);
  }

  /** Proxies {@link DBModule#getContactsDao(DaoSession)}. */
  public static ContactsDao proxyGetContactsDao(DBModule instance, DaoSession session) {
    return instance.getContactsDao(session);
  }
}
