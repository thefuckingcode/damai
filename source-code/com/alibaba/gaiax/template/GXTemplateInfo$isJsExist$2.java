package com.alibaba.gaiax.template;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0010\u000b\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXTemplateInfo$isJsExist$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ GXTemplateInfo this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GXTemplateInfo$isJsExist$2(GXTemplateInfo gXTemplateInfo) {
        super(0);
        this.this$0 = gXTemplateInfo;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Boolean invoke() {
        return Boolean.valueOf(this.this$0.b());
    }
}
