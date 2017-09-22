package cn.connxun.morui.di.module;

import android.content.Context;
import cn.connxun.morui.data.local.DocumentStorge;
import cn.connxun.morui.db.DocumentDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideDocumentStorgeFactory
    implements Factory<DocumentStorge> {
  private final ApplicationModule module;

  private final Provider<Context> mContextProvider;

  private final Provider<DocumentDao> daoProvider;

  public ApplicationModule_ProvideDocumentStorgeFactory(
      ApplicationModule module,
      Provider<Context> mContextProvider,
      Provider<DocumentDao> daoProvider) {
    assert module != null;
    this.module = module;
    assert mContextProvider != null;
    this.mContextProvider = mContextProvider;
    assert daoProvider != null;
    this.daoProvider = daoProvider;
  }

  @Override
  public DocumentStorge get() {
    return Preconditions.checkNotNull(
        module.provideDocumentStorge(mContextProvider.get(), daoProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<DocumentStorge> create(
      ApplicationModule module,
      Provider<Context> mContextProvider,
      Provider<DocumentDao> daoProvider) {
    return new ApplicationModule_ProvideDocumentStorgeFactory(
        module, mContextProvider, daoProvider);
  }

  /** Proxies {@link ApplicationModule#provideDocumentStorge(Context, DocumentDao)}. */
  public static DocumentStorge proxyProvideDocumentStorge(
      ApplicationModule instance, Context mContext, DocumentDao dao) {
    return instance.provideDocumentStorge(mContext, dao);
  }
}
