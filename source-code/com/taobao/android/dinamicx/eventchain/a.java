package com.taobao.android.dinamicx.eventchain;

import android.text.TextUtils;
import android.view.View;
import com.taobao.analysis.v3.FalcoBusinessSpan;
import com.taobao.analysis.v3.FalcoContainerSpan;
import com.taobao.analysis.v3.FalcoStage;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;
import tb.at;
import tb.h;
import tb.mx;
import tb.q;
import tb.qx;
import tb.ry;
import tb.tx;
import tb.we0;
import tb.ye0;

/* compiled from: Taobao */
public class a {
    private WeakReference<View> a;
    private WeakReference<DXRuntimeContext> b;
    private WeakReference<q> c;
    private WeakReference<b> d;
    private qx e;
    private boolean f = false;
    private int g = 0;
    private FalcoBusinessSpan h;
    private FalcoContainerSpan i;
    private FalcoStage j;
    private String k = "";
    private final AtomicInteger l = new AtomicInteger(0);
    private ye0 m;
    private we0 n;
    private tx o;
    private boolean p;

    private DXRuntimeContext k() {
        DXWidgetNode dXWidgetNode;
        WeakReference<View> weakReference = this.a;
        if (weakReference == null || weakReference.get() == null || (dXWidgetNode = (DXWidgetNode) this.a.get().getTag(DXWidgetNode.TAG_WIDGET_NODE)) == null || dXWidgetNode.getReferenceNode() == null) {
            return null;
        }
        return dXWidgetNode.getReferenceNode().getDXRuntimeContext();
    }

    /* access modifiers changed from: protected */
    public void A(DXRuntimeContext dXRuntimeContext) {
        this.b = new WeakReference<>(dXRuntimeContext);
    }

    public void B(we0 we0) {
        this.n = we0;
    }

    public void C(tx txVar) {
        this.o = txVar;
    }

    public void D(String str) {
        this.k = str;
    }

    public void E(qx qxVar) {
        this.e = qxVar;
    }

    public void F(FalcoStage falcoStage) {
        this.j = falcoStage;
    }

    public void G(boolean z) {
        this.p = z;
    }

    public void H(ye0 ye0) {
        this.m = ye0;
    }

    /* access modifiers changed from: protected */
    public void I(View view) {
        this.a = new WeakReference<>(view);
    }

    public void J() {
        int i2 = this.g;
        if (i2 > 0) {
            this.g = i2 - 1;
        }
        ry.f("DXFullTrace", "subReferenceCount ", Integer.valueOf(this.g));
    }

    public void K() {
        WeakReference<DXRuntimeContext> weakReference = this.b;
        DXRuntimeContext dXRuntimeContext = weakReference == null ? null : weakReference.get();
        if (dXRuntimeContext == null) {
            dXRuntimeContext = k();
        }
        if (dXRuntimeContext != null) {
            dXRuntimeContext.setEventChainExpressionSourceContext(this.e);
        }
    }

    public void a() {
        int i2 = this.g + 1;
        this.g = i2;
        ry.f("DXFullTrace", "addReferenceCount ", Integer.valueOf(i2));
    }

    public void b() {
        this.f = true;
    }

    public void c() {
        this.g = 0;
        ry.f("DXFullTrace", "clearReferenceCount ", 0);
    }

    /* access modifiers changed from: protected */
    public h d() {
        WeakReference<b> weakReference = this.d;
        if (weakReference != null && weakReference.get() != null) {
            return this.d.get().j();
        }
        ry.g("DXEventChainContext", "getAbilityEngine : dxEventChainManager is null");
        return null;
    }

    public q e() {
        WeakReference<q> weakReference = this.c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public int f() {
        return this.l.getAndIncrement();
    }

    public FalcoBusinessSpan g() {
        return this.h;
    }

    public FalcoContainerSpan h() {
        return this.i;
    }

    /* access modifiers changed from: protected */
    public DXAtomicEventNode i(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            ry.g("DXEventChainContext", "getAtomicNode : eventchain name  or atomic name is null");
        }
        mx j2 = j(str);
        if (j2 == null) {
            return null;
        }
        return j2.c(str2);
    }

    /* access modifiers changed from: protected */
    public mx j(String str) {
        if (TextUtils.isEmpty(str)) {
            ry.g("DXEventChainContext", "getEventChain : eventchain name is null");
            return null;
        }
        tx n2 = n();
        if (n2 == null) {
            return null;
        }
        return n2.c(str);
    }

    public DXRuntimeContext l() {
        WeakReference<DXRuntimeContext> weakReference = this.b;
        DXRuntimeContext dXRuntimeContext = weakReference == null ? null : weakReference.get();
        if (dXRuntimeContext == null) {
            dXRuntimeContext = k();
        }
        if (dXRuntimeContext != null && dXRuntimeContext.getEventChainExpressionSourceContext() == null) {
            dXRuntimeContext.setEventChainExpressionSourceContext(this.e);
        }
        return dXRuntimeContext;
    }

    public we0 m() {
        return this.n;
    }

    /* access modifiers changed from: protected */
    public tx n() {
        if (this.o != null && at.M0() && this.p) {
            return this.o;
        }
        DXRuntimeContext l2 = l();
        if (l2 == null || l2.getWidgetNode() == null || l2.getWidgetNode().queryRootWidgetNode() == null) {
            return null;
        }
        return l2.getWidgetNode().queryRootWidgetNode().getDxEventChains();
    }

    public String o() {
        return TextUtils.isEmpty(this.k) ? "" : this.k;
    }

    public qx p() {
        return this.e;
    }

    public FalcoStage q() {
        return this.j;
    }

    public ye0 r() {
        return this.m;
    }

    public int s() {
        return this.l.get();
    }

    public int t() {
        ry.f("DXFullTrace", "getReferenceCount ", Integer.valueOf(this.g));
        return this.g;
    }

    public boolean u() {
        return this.f;
    }

    public void v() {
        this.l.set(0);
    }

    /* access modifiers changed from: protected */
    public void w(q qVar) {
        this.c = new WeakReference<>(qVar);
    }

    public void x(FalcoBusinessSpan falcoBusinessSpan) {
        this.h = falcoBusinessSpan;
    }

    public void y(FalcoContainerSpan falcoContainerSpan) {
        this.i = falcoContainerSpan;
    }

    /* access modifiers changed from: protected */
    public void z(b bVar) {
        this.d = new WeakReference<>(bVar);
    }
}
