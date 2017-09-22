package cn.connxun.morui.di.module;

import cn.connxun.morui.api.DocumentApi;
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
public final class ApiModule_ProvideDocumentApiFactory implements Factory<DocumentApi> {
  private final ApiModule module;

  private final Provider<RequestHelper> helperProvider;

  private final Provider<OkHttpClient.Builder> okHttpClientProvider;

  public ApiModule_ProvideDocumentApiFactory(
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
  public DocumentApi get() {
    return Preconditions.checkNotNull(
        module.provideDocumentApi(helperProvider.get(), okHttpClientProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<DocumentApi> create(
      ApiModule module,
      Provider<RequestHelper> helperProvider,
      Provider<OkHttpClient.Builder> okHttpClientProvider) {
    return new ApiModule_ProvideDocumentApiFactory(module, helperProvider, okHttpClientProvider);
  }
}
