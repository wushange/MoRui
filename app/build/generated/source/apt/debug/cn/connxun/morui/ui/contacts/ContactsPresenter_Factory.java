package cn.connxun.morui.ui.contacts;

import cn.connxun.morui.api.ContactsApi;
import cn.connxun.morui.data.local.ContactsStorge;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ContactsPresenter_Factory implements Factory<ContactsPresenter> {
  private final MembersInjector<ContactsPresenter> contactsPresenterMembersInjector;

  private final Provider<ContactsApi> apiProvider;

  private final Provider<ContactsStorge> storgeProvider;

  public ContactsPresenter_Factory(
      MembersInjector<ContactsPresenter> contactsPresenterMembersInjector,
      Provider<ContactsApi> apiProvider,
      Provider<ContactsStorge> storgeProvider) {
    assert contactsPresenterMembersInjector != null;
    this.contactsPresenterMembersInjector = contactsPresenterMembersInjector;
    assert apiProvider != null;
    this.apiProvider = apiProvider;
    assert storgeProvider != null;
    this.storgeProvider = storgeProvider;
  }

  @Override
  public ContactsPresenter get() {
    return MembersInjectors.injectMembers(
        contactsPresenterMembersInjector,
        new ContactsPresenter(apiProvider.get(), storgeProvider.get()));
  }

  public static Factory<ContactsPresenter> create(
      MembersInjector<ContactsPresenter> contactsPresenterMembersInjector,
      Provider<ContactsApi> apiProvider,
      Provider<ContactsStorge> storgeProvider) {
    return new ContactsPresenter_Factory(
        contactsPresenterMembersInjector, apiProvider, storgeProvider);
  }
}
