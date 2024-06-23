package com.alient.onearch.adapter.loader;

import androidx.recyclerview.widget.RecyclerView;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.page.GenericFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "invoke", "()Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class BasePageLoader$handleFirstLoad$2$1 extends Lambda implements Function0<ur2> {
    final /* synthetic */ IContext $this_with;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasePageLoader$handleFirstLoad$2$1(IContext iContext) {
        super(0);
        this.$this_with = iContext;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final ur2 invoke() {
        RecyclerView recyclerView;
        RecyclerView.Adapter adapter;
        GenericFragment fragment;
        RecyclerView recyclerView2;
        GenericFragment fragment2 = this.$this_with.getFragment();
        if (fragment2 == null || (recyclerView = fragment2.getRecyclerView()) == null || (adapter = recyclerView.getAdapter()) == null) {
            return null;
        }
        k21.h(adapter, AdvanceSetting.NETWORK_TYPE);
        if (!(adapter.getItemCount() <= 0 || (fragment = this.$this_with.getFragment()) == null || (recyclerView2 = fragment.getRecyclerView()) == null)) {
            recyclerView2.scrollToPosition(0);
        }
        return ur2.INSTANCE;
    }
}
