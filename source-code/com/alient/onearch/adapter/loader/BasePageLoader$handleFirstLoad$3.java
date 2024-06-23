package com.alient.onearch.adapter.loader;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class BasePageLoader$handleFirstLoad$3 extends Lambda implements Function0<ur2> {
    final /* synthetic */ BasePageLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasePageLoader$handleFirstLoad$3(BasePageLoader basePageLoader) {
        super(0);
        this.this$0 = basePageLoader;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        BasePageLoader.access$getHost$p(this.this$0).updateContentAdapter();
    }
}
