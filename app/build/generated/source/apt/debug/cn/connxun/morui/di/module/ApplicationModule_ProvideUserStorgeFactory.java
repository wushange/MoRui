package cn.connxun.morui.di.module;

import android.content.Context;
import cn.connxun.morui.data.local.UserStorge;
import cn.connxun.morui.db.AllotUserDao;
import cn.connxun.morui.db.UserDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideUserStorgeFactory implements Factory<UserStorge> {
  private final ApplicationModule module;

  private final Provider<Context> mContextProvider;

  private final Provider<UserDao> userDaoProvider;

  private final Provider<AllotUserDao> allotUserDaoProvider;

  public ApplicationModule_ProvideUserStorgeFactory(
      ApplicationModule module,
      Provider<Context> mContextProvider,
      Provider<UserDao> userDaoProvider,
      Provider<AllotUserDao> allotUserDaoProvider) {
    assert module != null;
    this.module = module;
    assert mContextProvider != null;
    this.mContextProvider = mContextProvider;
    assert userDaoProvider != null;
    this.userDaoProvider = userDaoProvider;
    assert allotUserDaoProvider != null;
    this.allotUserDaoProvider = allotUserDaoProvider;
  }

  @Override
  public UserStorge get() {
    return Preconditions.checkNotNull(
        module.provideUserStorge(
            mContextProvider.get(), userDaoProvider.get(), allotUserDaoProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<UserStorge> create(
      ApplicationModule module,
      Provider<Context> mContextProvider,
      Provider<UserDao> userDaoProvider,
      Provider<AllotUserDao> allotUserDaoProvider) {
    return new ApplicationModule_ProvideUserStorgeFactory(
        module, mContextProvider, userDaoProvider, allotUserDaoProvider);
  }

  /** Proxies {@link ApplicationModule#provideUserStorge(Context, UserDao, AllotUserDao)}. */
  public static UserStorge proxyProvideUserStorge(
      ApplicationModule instance, Context mContext, UserDao userDao, AllotUserDao allotUserDao) {
    return instance.provideUserStorge(mContext, userDao, allotUserDao);
  }
}
