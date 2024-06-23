package com.alient.onearch.adapter.loader.v2;

import com.alient.onearch.adapter.decorate.ComponentDecorator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/alient/onearch/adapter/decorate/ComponentDecorator;", "invoke", "()Lcom/alient/onearch/adapter/decorate/ComponentDecorator;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class GenericPagerLoader$componentDecorator$2 extends Lambda implements Function0<ComponentDecorator> {
    public static final GenericPagerLoader$componentDecorator$2 INSTANCE = new GenericPagerLoader$componentDecorator$2();

    GenericPagerLoader$componentDecorator$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ComponentDecorator invoke() {
        return new ComponentDecorator();
    }
}
