package cn.connxun.morui.ui.contacts;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ContactsActivity_MembersInjector implements MembersInjector<ContactsActivity> {
  private final Provider<ContactsPresenter> presenterProvider;

  public ContactsActivity_MembersInjector(Provider<ContactsPresenter> presenterProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<ContactsActivity> create(
      Provider<ContactsPresenter> presenterProvider) {
    return new ContactsActivity_MembersInjector(presenterProvider);
  }

  @Override
  public void injectMembers(ContactsActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
  }

  public static void injectPresenter(
      ContactsActivity instance, Provider<ContactsPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }
}
