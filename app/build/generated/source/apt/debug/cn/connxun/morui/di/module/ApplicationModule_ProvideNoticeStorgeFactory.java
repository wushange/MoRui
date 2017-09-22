package cn.connxun.morui.di.module;

import android.content.Context;
import cn.connxun.morui.data.local.NoticeStorge;
import cn.connxun.morui.db.NoticeDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideNoticeStorgeFactory implements Factory<NoticeStorge> {
  private final ApplicationModule module;

  private final Provider<Context> mContextProvider;

  private final Provider<NoticeDao> daoProvider;

  public ApplicationModule_ProvideNoticeStorgeFactory(
      ApplicationModule module,
      Provider<Context> mContextProvider,
      Provider<NoticeDao> daoProvider) {
    assert module != null;
    this.module = module;
    assert mContextProvider != null;
    this.mContextProvider = mContextProvider;
    assert daoProvider != null;
    this.daoProvider = daoProvider;
  }

  @Override
  public NoticeStorge get() {
    return Preconditions.checkNotNull(
        module.provideNoticeStorge(mContextProvider.get(), daoProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<NoticeStorge> create(
      ApplicationModule module,
      Provider<Context> mContextProvider,
      Provider<NoticeDao> daoProvider) {
    return new ApplicationModule_ProvideNoticeStorgeFactory(module, mContextProvider, daoProvider);
  }

  /** Proxies {@link ApplicationModule#provideNoticeStorge(Context, NoticeDao)}. */
  public static NoticeStorge proxyProvideNoticeStorge(
      ApplicationModule instance, Context mContext, NoticeDao dao) {
    return instance.provideNoticeStorge(mContext, dao);
  }
}
