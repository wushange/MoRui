package cn.connxun.morui.ui.notice.adapter;

import android.content.Context;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NoticeAdapter_Factory implements Factory<NoticeAdapter> {
  private final MembersInjector<NoticeAdapter> noticeAdapterMembersInjector;

  private final Provider<Context> contextProvider;

  public NoticeAdapter_Factory(
      MembersInjector<NoticeAdapter> noticeAdapterMembersInjector,
      Provider<Context> contextProvider) {
    assert noticeAdapterMembersInjector != null;
    this.noticeAdapterMembersInjector = noticeAdapterMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public NoticeAdapter get() {
    return MembersInjectors.injectMembers(
        noticeAdapterMembersInjector, new NoticeAdapter(contextProvider.get()));
  }

  public static Factory<NoticeAdapter> create(
      MembersInjector<NoticeAdapter> noticeAdapterMembersInjector,
      Provider<Context> contextProvider) {
    return new NoticeAdapter_Factory(noticeAdapterMembersInjector, contextProvider);
  }
}
