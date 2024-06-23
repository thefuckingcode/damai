package com.youku.gaiax.js;

import com.youku.gaiax.js.utils.MonitorUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "time", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXJS$init$2 extends Lambda implements Function1<Long, ur2> {
    public static final GaiaXJS$init$2 INSTANCE = new GaiaXJS$init$2();

    GaiaXJS$init$2() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(Long l) {
        invoke(l.longValue());
        return ur2.INSTANCE;
    }

    public final void invoke(long j) {
        MonitorUtils.INSTANCE.jsInitScene(MonitorUtils.TYPE_LOAD_MODULE, j);
    }
}
