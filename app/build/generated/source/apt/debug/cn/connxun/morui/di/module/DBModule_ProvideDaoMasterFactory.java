package cn.connxun.morui.di.module;

import cn.connxun.morui.db.DaoMaster;
import cn.connxun.morui.db.MyOpenHelper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DBModule_ProvideDaoMasterFactory implements Factory<DaoMaster> {
  private final DBModule module;

  private final Provider<MyOpenHelper> helperProvider;

  public DBModule_ProvideDaoMasterFactory(DBModule module, Provider<MyOpenHelper> helperProvider) {
    assert module != null;
    this.module = module;
    assert helperProvider != null;
    this.helperProvider = helperProvider;
  }

  @Override
  public DaoMaster get() {
    return Preconditions.checkNotNull(
        module.provideDaoMaster(helperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<DaoMaster> create(DBModule module, Provider<MyOpenHelper> helperProvider) {
    return new DBModule_ProvideDaoMasterFactory(module, helperProvider);
  }

  /** Proxies {@link DBModule#provideDaoMaster(MyOpenHelper)}. */
  public static DaoMaster proxyProvideDaoMaster(DBModule instance, MyOpenHelper helper) {
    return instance.provideDaoMaster(helper);
  }
}
