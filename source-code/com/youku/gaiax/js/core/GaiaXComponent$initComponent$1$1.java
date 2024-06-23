package com.youku.gaiax.js.core;

import com.youku.gaiax.js.utils.Aop;
import com.youku.gaiax.js.utils.MonitorUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXComponent$initComponent$1$1 extends Lambda implements Function0<ur2> {
    final /* synthetic */ String $this_apply;
    final /* synthetic */ GaiaXComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GaiaXComponent$initComponent$1$1(GaiaXComponent gaiaXComponent, String str) {
        super(0);
        this.this$0 = gaiaXComponent;
        this.$this_apply = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        Aop aop = Aop.INSTANCE;
        final GaiaXComponent gaiaXComponent = this.this$0;
        final String str = this.$this_apply;
        AnonymousClass1 r1 = new Function0<ur2>() {
            /* class com.youku.gaiax.js.core.GaiaXComponent$initComponent$1$1.AnonymousClass1 */

            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                gaiaXComponent.getJsContext().evaluateJSWithoutTask(str);
            }
        };
        final GaiaXComponent gaiaXComponent2 = this.this$0;
        aop.aopTaskTime(r1, new Function1<Long, ur2>() {
            /* class com.youku.gaiax.js.core.GaiaXComponent$initComponent$1$1.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ ur2 invoke(Long l) {
                invoke(l.longValue());
                return ur2.INSTANCE;
            }

            public final void invoke(long j) {
                MonitorUtils.INSTANCE.jsTemplate(MonitorUtils.TYPE_LOAD_INDEX_JS, j, gaiaXComponent2.getTemplateId(), gaiaXComponent2.getBizId());
            }
        });
    }
}
