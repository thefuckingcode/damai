package com.alibaba.gaiax.template;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/alibaba/gaiax/template/GXStyleConvert;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class GXStyleConvert$Companion$instance$2 extends Lambda implements Function0<GXStyleConvert> {
    public static final GXStyleConvert$Companion$instance$2 INSTANCE = new GXStyleConvert$Companion$instance$2();

    GXStyleConvert$Companion$instance$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final GXStyleConvert invoke() {
        return new GXStyleConvert();
    }
}
