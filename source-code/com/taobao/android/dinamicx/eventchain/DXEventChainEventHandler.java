package com.taobao.android.dinamicx.eventchain;

import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.a;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import com.taobao.android.dinamicx.monitor.RuntimeProfilingInfoCollector;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import tb.at;
import tb.c00;
import tb.d10;
import tb.ey;
import tb.lx;
import tb.qx;
import tb.ry;
import tb.sx;
import tb.vx;
import tb.we0;

/* compiled from: Taobao */
public class DXEventChainEventHandler extends a {
    public static final long DX_EVENT_EVENTCHAIN = -812009131795779670L;
    private static final AtomicInteger b = new AtomicInteger(0);
    DXEventChainCallback a;

    /* compiled from: Taobao */
    public interface DXEventChainCallback {
        void eventChainCallBack(sx sxVar);
    }

    private static void e(String str, a aVar, String str2, lx lxVar) {
        if (DinamicXEngine.x()) {
            int incrementAndGet = b.incrementAndGet();
            DXTemplateItem dXTemplateItem = null;
            if (aVar != null) {
                aVar.v();
                DXRuntimeContext l = aVar.l();
                if (l != null) {
                    dXTemplateItem = l.getDxTemplateItem();
                }
            }
            we0 we0 = new we0(incrementAndGet, str, dXTemplateItem, str2, lxVar);
            if (aVar != null) {
                aVar.B(we0);
            }
            RuntimeProfilingInfoCollector.c().e(we0);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0182  */
    private void f(lx lxVar, Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        Throwable th;
        Map<String, ey> a2;
        DXWidgetNode queryRootWidgetNode;
        if (objArr == null || objArr.length == 0 || TextUtils.isEmpty(objArr[0].toString())) {
            ry.g("DXEventChainEventHandler", "dx evnetchain handle error : Missing the necessary parameters（args）");
        } else if (dXRuntimeContext == null || dXRuntimeContext.getEngineContext() == null || dXRuntimeContext.getEngineContext().e() == null || dXRuntimeContext.getEngineContext().e().o() == null) {
            ry.g("DXEventChainEventHandler", "dx evnetchain handle error : Missing the necessary parameters(eventChainManage)");
        } else {
            a aVar = null;
            String str = null;
            try {
                d10 d = d(lxVar, objArr, dXRuntimeContext);
                d.e(dXRuntimeContext.getContext());
                d.g(dXRuntimeContext.getNativeView());
                String obj = objArr[0].toString();
                Object obj2 = objArr.length > 1 ? objArr[1] : null;
                DXTraceUtil.a(2, "DX-EventChain-Start", " : ", obj);
                b o = dXRuntimeContext.getEngineContext().e().o();
                a aVar2 = new a();
                try {
                    aVar2.I(dXRuntimeContext.getNativeView());
                    aVar2.A(dXRuntimeContext);
                    aVar2.w(d);
                    aVar2.z(o);
                    if (at.M0() && objArr.length == 3) {
                        Object obj3 = objArr[2];
                        if (obj3 instanceof DXWidgetNode) {
                            aVar2.C(((DXWidgetNode) obj3).getDxEventChains());
                            aVar2.G(true);
                        }
                    } else if (at.M0() && dXRuntimeContext.getWidgetNode() == null && (queryRootWidgetNode = dXRuntimeContext.getWidgetNode().queryRootWidgetNode()) != null) {
                        aVar2.C(queryRootWidgetNode.getDxEventChains());
                    }
                    d.d(o.j());
                    d.i(dXRuntimeContext.getRootView());
                    d.j(dXRuntimeContext.getWidgetNode());
                    o.k(aVar2);
                    JSONObject jSONObject = new JSONObject();
                    if (!(lxVar == null || (a2 = lxVar.a()) == null)) {
                        for (Map.Entry<String, ey> entry : a2.entrySet()) {
                            jSONObject.put(entry.getKey(), entry.getValue().s());
                        }
                    }
                    qx qxVar = new qx();
                    qxVar.f(d);
                    qxVar.h(obj2);
                    qxVar.i(jSONObject);
                    qxVar.g(lxVar);
                    dXRuntimeContext.setEventChainExpressionSourceContext(qxVar);
                    aVar2.E(qxVar);
                    if (DinamicXEngine.x()) {
                        if (dXRuntimeContext.getWidgetNode() != null) {
                            str = dXRuntimeContext.getWidgetNode().getClass().getName();
                        }
                        e(obj, aVar2, str, lxVar);
                    }
                    aVar2.D(obj);
                    c(obj, aVar2);
                    sx f = o.f("$(main)", obj, aVar2);
                    DXEventChainCallback dXEventChainCallback = this.a;
                    if (dXEventChainCallback != null) {
                        dXEventChainCallback.eventChainCallBack(f);
                    }
                    b(obj, f, aVar2);
                    DXTraceUtil.d(2);
                } catch (Throwable th2) {
                    th = th2;
                    aVar = aVar2;
                    e.a aVar3 = new e.a("DX_EventChain", "DX_EventChain_Crash", e.EVENTCHAIN_EXECUTE_CRASH);
                    aVar3.e = vx.a(th);
                    dXRuntimeContext.getDxError().c.add(aVar3);
                    if (DinamicXEngine.x()) {
                    }
                    vx.b(th);
                }
            } catch (Throwable th3) {
                th = th3;
                e.a aVar32 = new e.a("DX_EventChain", "DX_EventChain_Crash", e.EVENTCHAIN_EXECUTE_CRASH);
                aVar32.e = vx.a(th);
                dXRuntimeContext.getDxError().c.add(aVar32);
                if (DinamicXEngine.x()) {
                    b.d(aVar != null ? aVar.s() : -1, sx.a(-1, th.getMessage()), aVar);
                }
                vx.b(th);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b(String str, sx sxVar, a aVar) {
    }

    /* access modifiers changed from: protected */
    public void c(String str, a aVar) {
    }

    /* access modifiers changed from: protected */
    public d10 d(lx lxVar, Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        return new d10();
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction, com.taobao.android.dinamicx.a
    public String getDxFunctionName() {
        return "dxEventHandler";
    }

    @Override // com.taobao.android.dinamicx.IDXEventHandler
    public void handleEvent(final lx lxVar, final Object[] objArr, final DXRuntimeContext dXRuntimeContext) {
        if (!at.U()) {
            f(lxVar, objArr, dXRuntimeContext);
        } else if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            f(lxVar, objArr, dXRuntimeContext);
        } else {
            c00.m(new Runnable() {
                /* class com.taobao.android.dinamicx.eventchain.DXEventChainEventHandler.AnonymousClass1 */

                public void run() {
                    DXEventChainEventHandler.this.f(lxVar, objArr, dXRuntimeContext);
                }
            });
        }
    }
}
