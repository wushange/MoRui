package cn.connxun.morui.di.module;

import cn.connxun.morui.db.DaoSession;
import cn.connxun.morui.db.PlanDetailDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DBModule_GetPlanDetailDaoFactory implements Factory<PlanDetailDao> {
  private final DBModule module;

  private final Provider<DaoSession> sessionProvider;

  public DBModule_GetPlanDetailDaoFactory(DBModule module, Provider<DaoSession> sessionProvider) {
    assert module != null;
    this.module = module;
    assert sessionProvider != null;
    this.sessionProvider = sessionProvider;
  }

  @Override
  public PlanDetailDao get() {
    return Preconditions.checkNotNull(
        module.getPlanDetailDao(sessionProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<PlanDetailDao> create(
      DBModule module, Provider<DaoSession> sessionProvider) {
    return new DBModule_GetPlanDetailDaoFactory(module, sessionProvider);
  }

  /** Proxies {@link DBModule#getPlanDetailDao(DaoSession)}. */
  public static PlanDetailDao proxyGetPlanDetailDao(DBModule instance, DaoSession session) {
    return instance.getPlanDetailDao(session);
  }
}
