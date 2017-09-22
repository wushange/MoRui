package cn.connxun.morui.di.module;

import android.content.Context;
import cn.connxun.morui.db.MyOpenHelper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DBModule_ProvideMyOpenHelperFactory implements Factory<MyOpenHelper> {
  private final DBModule module;

  private final Provider<Context> contextProvider;

  public DBModule_ProvideMyOpenHelperFactory(DBModule module, Provider<Context> contextProvider) {
    assert module != null;
    this.module = module;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public MyOpenHelper get() {
    return Preconditions.checkNotNull(
        module.provideMyOpenHelper(contextProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MyOpenHelper> create(DBModule module, Provider<Context> contextProvider) {
    return new DBModule_ProvideMyOpenHelperFactory(module, contextProvider);
  }

  /** Proxies {@link DBModule#provideMyOpenHelper(Context)}. */
  public static MyOpenHelper proxyProvideMyOpenHelper(DBModule instance, Context context) {
    return instance.provideMyOpenHelper(context);
  }
}
