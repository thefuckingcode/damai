package com.youku.gaiax.provider.module.js;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/youku/gaiax/provider/module/js/JSDelegate;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class JSDelegate$Companion$instance$2 extends Lambda implements Function0<JSDelegate> {
    public static final JSDelegate$Companion$instance$2 INSTANCE = new JSDelegate$Companion$instance$2();

    JSDelegate$Companion$instance$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final JSDelegate invoke() {
        return new JSDelegate();
    }
}
