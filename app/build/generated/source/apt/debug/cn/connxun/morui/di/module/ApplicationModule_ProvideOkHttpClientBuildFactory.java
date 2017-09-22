package cn.connxun.morui.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideOkHttpClientBuildFactory
    implements Factory<OkHttpClient.Builder> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideOkHttpClientBuildFactory(ApplicationModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public OkHttpClient.Builder get() {
    return Preconditions.checkNotNull(
        module.provideOkHttpClientBuild(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<OkHttpClient.Builder> create(ApplicationModule module) {
    return new ApplicationModule_ProvideOkHttpClientBuildFactory(module);
  }

  /** Proxies {@link ApplicationModule#provideOkHttpClientBuild()}. */
  public static OkHttpClient.Builder proxyProvideOkHttpClientBuild(ApplicationModule instance) {
    return instance.provideOkHttpClientBuild();
  }
}
