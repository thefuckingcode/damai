package com.youku.gaiax.impl;

import com.alibaba.gaiax.render.view.container.GXViewHolder;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/alibaba/gaiax/render/view/container/GXViewHolder;", AdvanceSetting.NETWORK_TYPE, "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXContainerHelper$notifyOnPageInvisible$1$1 extends Lambda implements Function1<GXViewHolder, ur2> {
    public static final GaiaXContainerHelper$notifyOnPageInvisible$1$1 INSTANCE = new GaiaXContainerHelper$notifyOnPageInvisible$1$1();

    GaiaXContainerHelper$notifyOnPageInvisible$1$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(GXViewHolder gXViewHolder) {
        invoke(gXViewHolder);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull GXViewHolder gXViewHolder) {
        k21.i(gXViewHolder, AdvanceSetting.NETWORK_TYPE);
        GaiaXContainerHelper.access$onPageInvisible(GaiaXContainerHelper.INSTANCE, gXViewHolder);
    }
}
