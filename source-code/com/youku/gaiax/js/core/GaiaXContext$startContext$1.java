package com.youku.gaiax.js.core;

import com.youku.gaiax.js.core.api.IContext;
import com.youku.gaiax.js.utils.Aop;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXContext$startContext$1 extends Lambda implements Function0<ur2> {
    final /* synthetic */ Function0<ur2> $complete;
    final /* synthetic */ GaiaXContext this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GaiaXContext$startContext$1(GaiaXContext gaiaXContext, Function0<ur2> function0) {
        super(0);
        this.this$0 = gaiaXContext;
        this.$complete = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        Aop aop = Aop.INSTANCE;
        final GaiaXContext gaiaXContext = this.this$0;
        final Function0<ur2> function0 = this.$complete;
        aop.aopTaskTime(new Function0<ur2>() {
            /* class com.youku.gaiax.js.core.GaiaXContext$startContext$1.AnonymousClass1 */

            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                IContext iContext = gaiaXContext.context;
                if (iContext != null) {
                    iContext.initBootstrap();
                }
                IContext iContext2 = gaiaXContext.context;
                if (iContext2 != null) {
                    iContext2.startBootstrap();
                }
                function0.invoke();
            }
        }, AnonymousClass2.INSTANCE);
    }
}
