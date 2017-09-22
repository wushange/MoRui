package cn.connxun.morui.di.module;

import cn.connxun.morui.api.PlanApi;
import cn.connxun.morui.components.retrofit.RequestHelper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiModule_ProvidePlanApiFactory implements Factory<PlanApi> {
  private final ApiModule module;

  private final Provider<RequestHelper> helperProvider;

  private final Provider<OkHttpClient.Builder> okHttpClientProvider;

  public ApiModule_ProvidePlanApiFactory(
      ApiModule module,
      Provider<RequestHelper> helperProvider,
      Provider<OkHttpClient.Builder> okHttpClientProvider) {
    assert module != null;
    this.module = module;
    assert helperProvider != null;
    this.helperProvider = helperProvider;
    assert okHttpClientProvider != null;
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public PlanApi get() {
    return Preconditions.checkNotNull(
        module.providePlanApi(helperProvider.get(), okHttpClientProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<PlanApi> create(
      ApiModule module,
      Provider<RequestHelper> helperProvider,
      Provider<OkHttpClient.Builder> okHttpClientProvider) {
    return new ApiModule_ProvidePlanApiFactory(module, helperProvider, okHttpClientProvider);
  }
}
