package cn.connxun.morui.di.module;

import android.content.Context;
import cn.connxun.morui.components.retrofit.RequestHelper;
import cn.connxun.morui.data.local.UserStorge;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideRequestHelperFactory implements Factory<RequestHelper> {
  private final ApplicationModule module;

  private final Provider<Context> mContextProvider;

  private final Provider<UserStorge> userStorgeProvider;

  public ApplicationModule_ProvideRequestHelperFactory(
      ApplicationModule module,
      Provider<Context> mContextProvider,
      Provider<UserStorge> userStorgeProvider) {
    assert module != null;
    this.module = module;
    assert mContextProvider != null;
    this.mContextProvider = mContextProvider;
    assert userStorgeProvider != null;
    this.userStorgeProvider = userStorgeProvider;
  }

  @Override
  public RequestHelper get() {
    return Preconditions.checkNotNull(
        module.provideRequestHelper(mContextProvider.get(), userStorgeProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<RequestHelper> create(
      ApplicationModule module,
      Provider<Context> mContextProvider,
      Provider<UserStorge> userStorgeProvider) {
    return new ApplicationModule_ProvideRequestHelperFactory(
        module, mContextProvider, userStorgeProvider);
  }

  /** Proxies {@link ApplicationModule#provideRequestHelper(Context, UserStorge)}. */
  public static RequestHelper proxyProvideRequestHelper(
      ApplicationModule instance, Context mContext, UserStorge userStorge) {
    return instance.provideRequestHelper(mContext, userStorge);
  }
}
