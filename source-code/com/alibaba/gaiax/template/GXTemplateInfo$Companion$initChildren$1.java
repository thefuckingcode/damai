package com.alibaba.gaiax.template;

import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.template.GXTemplateInfo;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.hp0;
import tb.k21;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/hp0;", AdvanceSetting.NETWORK_TYPE, "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXTemplateInfo$Companion$initChildren$1 extends Lambda implements Function1<hp0, ur2> {
    final /* synthetic */ GXTemplateInfo $templateInfo;
    final /* synthetic */ GXTemplateEngine.h $templateItem;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GXTemplateInfo$Companion$initChildren$1(GXTemplateEngine.h hVar, GXTemplateInfo gXTemplateInfo) {
        super(1);
        this.$templateItem = hVar;
        this.$templateInfo = gXTemplateInfo;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(hp0 hp0) {
        invoke(hp0);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull hp0 hp0) {
        k21.i(hp0, AdvanceSetting.NETWORK_TYPE);
        GXTemplateInfo.Companion companion = GXTemplateInfo.Companion;
        GXTemplateEngine.h hVar = new GXTemplateEngine.h(this.$templateItem.c(), this.$templateItem.a(), hp0.d());
        GXTemplateEngine.h hVar2 = this.$templateItem;
        hVar.g(hVar2.f());
        hVar.h(hVar2.e());
        ur2 ur2 = ur2.INSTANCE;
        GXTemplateInfo g = companion.g(hVar);
        if (this.$templateInfo.k() == null) {
            this.$templateInfo.u(new ArrayList());
        }
        List<GXTemplateInfo> k = this.$templateInfo.k();
        if (k != null) {
            k.add(g);
        }
    }
}
