package cn.connxun.morui.di.module;

import cn.connxun.morui.db.DaoMaster;
import cn.connxun.morui.db.DaoSession;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DBModule_ProvideDaoSessionFactory implements Factory<DaoSession> {
  private final DBModule module;

  private final Provider<DaoMaster> masterProvider;

  public DBModule_ProvideDaoSessionFactory(DBModule module, Provider<DaoMaster> masterProvider) {
    assert module != null;
    this.module = module;
    assert masterProvider != null;
    this.masterProvider = masterProvider;
  }

  @Override
  public DaoSession get() {
    return Preconditions.checkNotNull(
        module.provideDaoSession(masterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<DaoSession> create(DBModule module, Provider<DaoMaster> masterProvider) {
    return new DBModule_ProvideDaoSessionFactory(module, masterProvider);
  }

  /** Proxies {@link DBModule#provideDaoSession(DaoMaster)}. */
  public static DaoSession proxyProvideDaoSession(DBModule instance, DaoMaster master) {
    return instance.provideDaoSession(master);
  }
}
