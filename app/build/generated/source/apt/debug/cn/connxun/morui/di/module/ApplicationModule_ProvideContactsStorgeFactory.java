package cn.connxun.morui.di.module;

import android.content.Context;
import cn.connxun.morui.data.local.ContactsStorge;
import cn.connxun.morui.data.local.UserStorge;
import cn.connxun.morui.db.ContactsDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideContactsStorgeFactory
    implements Factory<ContactsStorge> {
  private final ApplicationModule module;

  private final Provider<Context> mContextProvider;

  private final Provider<ContactsDao> daoProvider;

  private final Provider<UserStorge> userStorgeProvider;

  public ApplicationModule_ProvideContactsStorgeFactory(
      ApplicationModule module,
      Provider<Context> mContextProvider,
      Provider<ContactsDao> daoProvider,
      Provider<UserStorge> userStorgeProvider) {
    assert module != null;
    this.module = module;
    assert mContextProvider != null;
    this.mContextProvider = mContextProvider;
    assert daoProvider != null;
    this.daoProvider = daoProvider;
    assert userStorgeProvider != null;
    this.userStorgeProvider = userStorgeProvider;
  }

  @Override
  public ContactsStorge get() {
    return Preconditions.checkNotNull(
        module.provideContactsStorge(
            mContextProvider.get(), daoProvider.get(), userStorgeProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ContactsStorge> create(
      ApplicationModule module,
      Provider<Context> mContextProvider,
      Provider<ContactsDao> daoProvider,
      Provider<UserStorge> userStorgeProvider) {
    return new ApplicationModule_ProvideContactsStorgeFactory(
        module, mContextProvider, daoProvider, userStorgeProvider);
  }

  /** Proxies {@link ApplicationModule#provideContactsStorge(Context, ContactsDao, UserStorge)}. */
  public static ContactsStorge proxyProvideContactsStorge(
      ApplicationModule instance, Context mContext, ContactsDao dao, UserStorge userStorge) {
    return instance.provideContactsStorge(mContext, dao, userStorge);
  }
}
