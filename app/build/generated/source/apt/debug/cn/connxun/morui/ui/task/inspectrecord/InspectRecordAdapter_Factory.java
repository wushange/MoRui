package cn.connxun.morui.ui.task.inspectrecord;

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
public final class InspectRecordAdapter_Factory implements Factory<InspectRecordAdapter> {
  private final MembersInjector<InspectRecordAdapter> inspectRecordAdapterMembersInjector;

  private final Provider<Context> contextProvider;

  public InspectRecordAdapter_Factory(
      MembersInjector<InspectRecordAdapter> inspectRecordAdapterMembersInjector,
      Provider<Context> contextProvider) {
    assert inspectRecordAdapterMembersInjector != null;
    this.inspectRecordAdapterMembersInjector = inspectRecordAdapterMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public InspectRecordAdapter get() {
    return MembersInjectors.injectMembers(
        inspectRecordAdapterMembersInjector, new InspectRecordAdapter(contextProvider.get()));
  }

  public static Factory<InspectRecordAdapter> create(
      MembersInjector<InspectRecordAdapter> inspectRecordAdapterMembersInjector,
      Provider<Context> contextProvider) {
    return new InspectRecordAdapter_Factory(inspectRecordAdapterMembersInjector, contextProvider);
  }
}
