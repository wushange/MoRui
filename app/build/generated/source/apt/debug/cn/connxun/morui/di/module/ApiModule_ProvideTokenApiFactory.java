package cn.connxun.morui.di.module;

import cn.connxun.morui.api.TokenApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvideTokenApiFactory implements Factory<TokenApi> {
  private final ApiModule module;

  private final Provider<OkHttpClient> okHttpClientProvider;

  public ApiModule_ProvideTokenApiFactory(
      ApiModule module, Provider<OkHttpClient> okHttpClientProvider) {
    assert module != null;
    this.module = module;
    assert okHttpClientProvider != null;
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public TokenApi get() {
    return Preconditions.checkNotNull(
        module.provideTokenApi(okHttpClientProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<TokenApi> create(
      ApiModule module, Provider<OkHttpClient> okHttpClientProvider) {
    return new ApiModule_ProvideTokenApiFactory(module, okHttpClientProvider);
  }
}
