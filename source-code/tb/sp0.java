package tb;

import com.alibaba.gaiax.GXTemplateEngine;
import com.youku.gaiax.impl.register.GXMixNodeEvent;

/* compiled from: Taobao */
public final /* synthetic */ class sp0 implements Runnable {
    public final /* synthetic */ GXTemplateEngine.d a;
    public final /* synthetic */ GXMixNodeEvent b;

    public /* synthetic */ sp0(GXTemplateEngine.d dVar, GXMixNodeEvent gXMixNodeEvent) {
        this.a = dVar;
        this.b = gXMixNodeEvent;
    }

    public final void run() {
        GXMixNodeEvent.m896initViewLongClickEventDispatcher$lambda5(this.a, this.b);
    }
}
