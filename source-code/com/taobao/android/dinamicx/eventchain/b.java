package com.taobao.android.dinamicx.eventchain;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.d;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.monitor.RuntimeProfilingInfoCollector;
import com.taobao.weex.ui.component.AbstractEditComponent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import tb.at;
import tb.h;
import tb.jl1;
import tb.js2;
import tb.o70;
import tb.ox;
import tb.q;
import tb.q0;
import tb.qx;
import tb.sx;
import tb.w10;
import tb.wz;
import tb.xe0;
import tb.ye0;

/* compiled from: Taobao */
public class b extends com.taobao.android.dinamicx.b {
    private h d;
    private WeakHashMap<a, Integer> e;
    private List<WeakReference<a>> f;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements DXEventChainCallback {
        final /* synthetic */ a a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;

        a(a aVar, int i, String str) {
            this.a = aVar;
            this.b = i;
            this.c = str;
        }

        @Override // com.taobao.android.dinamicx.eventchain.DXEventChainCallback
        public void callback(c cVar, sx sxVar) {
            if (sxVar.g() == 2) {
                wz.b("event chain interrupt");
            } else if (this.a.l() == null) {
                wz.b("callback dxRuntimeContext recycled");
            } else {
                qx p = this.a.p();
                if (p != null) {
                    p.j(sxVar.f());
                    if (this.a.p() != null) {
                        p.h(this.a.p().c());
                        p.i(this.a.p().d());
                    }
                }
                if (DinamicXEngine.x()) {
                    a aVar = this.a;
                    int i = this.b;
                    aVar.H(new ye0(i, "callback_" + cVar.a(), sxVar));
                }
                b.this.f(cVar.b(), this.c, this.a);
            }
        }
    }

    public b(@NonNull d dVar) {
        super(dVar);
        h a2 = dVar.b().a();
        if (a2 == null) {
            q0 q0Var = new q0(a(), "DX");
            h hVar = new h();
            this.d = hVar;
            hVar.h(q0Var);
        } else {
            this.d = a2;
            this.d.h(new q0(a(), "DX"));
        }
        this.e = new WeakHashMap<>();
        this.f = new ArrayList();
    }

    public static void d(int i, sx sxVar, a aVar) {
        e(i(i, null, aVar), null, sxVar, aVar);
    }

    public static void e(xe0 xe0, DXAtomicEventNode dXAtomicEventNode, sx sxVar, a aVar) {
        if (xe0 != null) {
            xe0.i(sxVar);
            if (dXAtomicEventNode != null) {
                xe0.h(dXAtomicEventNode.p());
                xe0.g(dXAtomicEventNode.o());
                xe0.a(dXAtomicEventNode.m());
            }
        }
        RuntimeProfilingInfoCollector.c().d(aVar != null ? aVar.m() : null, xe0);
    }

    private sx g(String str, String str2, a aVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || aVar == null) {
            if (DinamicXEngine.x()) {
                int i = -1;
                if (aVar != null) {
                    i = aVar.s() + 1;
                }
                d(i, sx.b(ox.EVENT_CHAIN_ERROR_EXECUTE_ATOMIC_EVENT_CONTEXT_IS_NULL), aVar);
            }
            return sx.b(ox.EVENT_CHAIN_ERROR_EXECUTE_ATOMIC_EVENT_CONTEXT_IS_NULL);
        }
        int f2 = aVar.f();
        xe0 xe0 = null;
        DXAtomicEventNode i2 = aVar.i(str, str2);
        if (i2 == null) {
            if (DinamicXEngine.x()) {
                d(f2, sx.b(ox.EVENT_CHAIN_ERROR_EXECUTE_ATOMIC_EVENT_NODE_IS_NULL), aVar);
            }
            return sx.b(ox.EVENT_CHAIN_ERROR_EXECUTE_ATOMIC_EVENT_NODE_IS_NULL);
        }
        if (DinamicXEngine.x()) {
            xe0 = i(f2, i2, aVar);
        }
        sx j = i2.j(aVar, new a(aVar, f2, str));
        if (DinamicXEngine.x()) {
            e(xe0, i2, j, aVar);
        }
        if (j.g() == 2) {
            wz.b("event chain interrupt");
            return j;
        }
        DXRuntimeContext l = aVar.l();
        if (l == null) {
            wz.b("callback dxRuntimeContext recycled");
            return j;
        }
        qx eventChainExpressionSourceContext = l.getEventChainExpressionSourceContext();
        if (eventChainExpressionSourceContext != null) {
            eventChainExpressionSourceContext.j(j.f());
            if (aVar.p() != null) {
                eventChainExpressionSourceContext.h(aVar.p().c());
                eventChainExpressionSourceContext.i(aVar.p().d());
            }
        }
        if (DinamicXEngine.x()) {
            aVar.H(new ye0(f2, AbstractEditComponent.ReturnTypes.NEXT, j));
        }
        return !TextUtils.isEmpty(i2.o()) ? f(i2.o(), str, aVar) : j;
    }

    private sx h(String str, a aVar) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            return sx.b(ox.EVENT_CHAIN_ERROR_EXECUTE_EVENTCHIAN_CONTEXT_IS_NULL);
        }
        aVar.D(str);
        return g(str, js2.MAIN, aVar);
    }

    public static xe0 i(int i, DXAtomicEventNode dXAtomicEventNode, a aVar) {
        xe0 xe0;
        if (dXAtomicEventNode == null) {
            xe0 = new xe0(i, "unknown", -1, null);
        } else {
            xe0 = new xe0(i, dXAtomicEventNode.n(), dXAtomicEventNode.q().longValue(), null);
        }
        if (aVar != null) {
            xe0.f(aVar.r());
            q e2 = aVar.e();
            if (e2 != null) {
                xe0.b(e2.b());
                h a2 = e2.a();
                if (a2 != null) {
                    xe0.c(a2.d());
                }
            }
            qx p = aVar.p();
            if (p != null) {
                xe0.e(p.e());
                xe0.d(p.c());
            }
            DXRuntimeContext l = aVar.l();
            if (l != null) {
                xe0.j(l.getData());
                xe0.k(l.getSubData());
            }
        }
        return xe0;
    }

    public void c() {
        String str;
        try {
            if (at.L0()) {
                if (this.f != null) {
                    str = " List : size" + this.f.size();
                    Iterator<WeakReference<a>> it = this.f.iterator();
                    if (it != null) {
                        while (it.hasNext()) {
                            WeakReference<a> next = it.next();
                            if (next != null) {
                                a aVar = next.get();
                                if (aVar != null) {
                                    aVar.b();
                                }
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else if (this.e != null) {
                str = " map : size" + this.e.size();
                for (Map.Entry<a, Integer> entry : this.e.entrySet()) {
                    if (!(entry == null || entry.getKey() == null)) {
                        entry.getKey().b();
                    }
                }
            } else {
                return;
            }
            DXAppMonitor.q(a(), null, "DX_EventChain", "DX_EventChain_Error", e.EVENTCHAIN_CONTEXT_SIZE, str);
        } catch (Throwable th) {
            wz.d("DXEventChainException", "", "cancel event chain error : " + th.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public sx f(String str, String str2, a aVar) {
        Object b;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || aVar == null) {
            return sx.b(ox.EVENT_CHAIN_ERROR_EXECUTE_CONTEXT_IS_NULL);
        }
        aVar.K();
        if (str.startsWith("$(") && str.endsWith(jl1.BRACKET_END_STR)) {
            return g(str2, str.substring(2, str.length() - 1), aVar);
        }
        if (str.startsWith("$$(") && str.endsWith(jl1.BRACKET_END_STR)) {
            return h(str.substring(3, str.length() - 1), aVar);
        }
        if (!str.startsWith(o70.DINAMIC_PREFIX_AT) || !str.endsWith("}") || (b = aVar.n().b(str).b(null, aVar.l())) == null) {
            return null;
        }
        return f(b.toString(), str2, aVar);
    }

    public h j() {
        return this.d;
    }

    public void k(a aVar) {
        if (at.L0()) {
            this.f.add(new WeakReference<>(aVar));
            w10.a(this.f);
            return;
        }
        this.e.put(aVar, Integer.valueOf(aVar.hashCode()));
    }

    public void l() {
        this.d.g();
    }
}
