package cn.connxun.morui.ui.notice;

import cn.connxun.morui.api.NoticeApi;
import cn.connxun.morui.data.local.NoticeStorge;
import cn.connxun.morui.ui.notice.adapter.NoticeAdapter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NoticeFragment_MembersInjector implements MembersInjector<NoticeFragment> {
  private final Provider<NoticeAdapter> adapterProvider;

  private final Provider<NoticeStorge> noticeStorgeProvider;

  private final Provider<NoticeApi> noticeApiProvider;

  public NoticeFragment_MembersInjector(
      Provider<NoticeAdapter> adapterProvider,
      Provider<NoticeStorge> noticeStorgeProvider,
      Provider<NoticeApi> noticeApiProvider) {
    assert adapterProvider != null;
    this.adapterProvider = adapterProvider;
    assert noticeStorgeProvider != null;
    this.noticeStorgeProvider = noticeStorgeProvider;
    assert noticeApiProvider != null;
    this.noticeApiProvider = noticeApiProvider;
  }

  public static MembersInjector<NoticeFragment> create(
      Provider<NoticeAdapter> adapterProvider,
      Provider<NoticeStorge> noticeStorgeProvider,
      Provider<NoticeApi> noticeApiProvider) {
    return new NoticeFragment_MembersInjector(
        adapterProvider, noticeStorgeProvider, noticeApiProvider);
  }

  @Override
  public void injectMembers(NoticeFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.adapter = adapterProvider.get();
    instance.noticeStorge = noticeStorgeProvider.get();
    instance.noticeApi = noticeApiProvider.get();
  }

  public static void injectAdapter(
      NoticeFragment instance, Provider<NoticeAdapter> adapterProvider) {
    instance.adapter = adapterProvider.get();
  }

  public static void injectNoticeStorge(
      NoticeFragment instance, Provider<NoticeStorge> noticeStorgeProvider) {
    instance.noticeStorge = noticeStorgeProvider.get();
  }

  public static void injectNoticeApi(
      NoticeFragment instance, Provider<NoticeApi> noticeApiProvider) {
    instance.noticeApi = noticeApiProvider.get();
  }
}
