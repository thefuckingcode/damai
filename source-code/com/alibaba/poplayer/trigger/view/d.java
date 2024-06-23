package com.alibaba.poplayer.trigger.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.R$id;
import com.alibaba.poplayer.factory.view.base.PopLayerBaseView;
import com.alibaba.poplayer.layermanager.PopRequest;
import com.alibaba.poplayer.trigger.InternalTriggerController;
import com.alibaba.poplayer.trigger.view.TrackingService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import tb.cr1;
import tb.dz0;
import tb.eu2;
import tb.tu2;
import tb.tv2;

/* compiled from: Taobao */
public class d extends com.alibaba.poplayer.trigger.b<ViewEvent, ViewConfigItem, tv2> {
    public static final String TAG = "d";
    public static final String VIEW_SCHEME = "poplayerview://";
    private ArrayList<dz0<ViewConfigItem>> i = new ArrayList<>();
    private TrackingService.OnSTaskInvokeListener j = new a();

    /* compiled from: Taobao */
    class a implements TrackingService.OnSTaskInvokeListener {
        a() {
        }

        @Override // com.alibaba.poplayer.trigger.view.TrackingService.OnSTaskInvokeListener
        public void OnTargetViewAdded(View view, TrackingService.i iVar) {
            dz0 dz0;
            d dVar = d.this;
            ArrayList H = dVar.H(dVar.i, view);
            if (H != null && !H.isEmpty()) {
                Iterator it = H.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    dz0 = (dz0) it.next();
                    if (dz0.s() == iVar.i && dz0.r() == iVar.j) {
                        break;
                    }
                }
            }
            dz0 = null;
            if (dz0 != null) {
                cr1.b("OnSTaskInvokeListener.find from cache:{%s}.", dz0.toString());
                d.this.i.remove(dz0);
            } else {
                dz0 = d.this.G(iVar.i, iVar.j, view);
                dz0.l(new b(d.this, iVar.m, iVar.f, iVar.c, iVar));
                dz0.o(iVar.l);
                cr1.b("OnSTaskInvokeListener.create new one:{%s}.", dz0.toString());
            }
            dz0.q(PopRequest.Status.WAITTING);
            ArrayList arrayList = new ArrayList();
            arrayList.add(dz0);
            d dVar2 = d.this;
            dVar2.t(dVar2.f, arrayList);
        }

        @Override // com.alibaba.poplayer.trigger.view.TrackingService.OnSTaskInvokeListener
        public void OnTargetViewRemoved(View view, TrackingService.i iVar, boolean z) {
            d dVar = d.this;
            ArrayList H = dVar.H(dVar.i(dVar.f), view);
            if (H != null && !H.isEmpty()) {
                if (!z) {
                    d.this.i.addAll(H);
                }
                Iterator it = H.iterator();
                while (it.hasNext()) {
                    dz0 dz0 = (dz0) it.next();
                    Object c = dz0.c();
                    if (c != null && (c instanceof b) && eu2.c(((b) c).d) == iVar) {
                        d.this.r(dz0, z, true);
                    }
                }
            }
            cr1.b("OnSTaskInvokeListener.remove:{%s}.", view.toString());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b {
        final String a;
        final String b;
        final String c;
        final WeakReference<TrackingService.i> d;

        public b(d dVar, String str, String str2, String str3, TrackingService.i iVar) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = new WeakReference<>(iVar);
        }

        public String toString() {
            return "ReqTag{groupId='" + this.a + '\'' + ", operationName='" + this.b + '\'' + ", params='" + this.c + '\'' + '}';
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class c {
        private static d a = new d();
    }

    private void F(Activity activity, ViewEvent viewEvent, @NonNull ArrayList<ViewConfigItem> arrayList) {
        if (arrayList.size() != 0) {
            Iterator<ViewConfigItem> it = arrayList.iterator();
            while (it.hasNext()) {
                ViewConfigItem next = it.next();
                E(activity, viewEvent, next, (View) eu2.c(viewEvent.getHostView()), next.viewuri, "pageLauncher");
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private dz0 G(ViewEvent viewEvent, ViewConfigItem viewConfigItem, View view) {
        dz0 dz0 = new dz0(3, viewEvent, viewConfigItem, (Activity) view.getContext(), this);
        dz0.k((Activity) view.getContext());
        dz0.m(view);
        return dz0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ArrayList<dz0<ViewConfigItem>> H(ArrayList<dz0<ViewConfigItem>> arrayList, View view) {
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        ArrayList<dz0<ViewConfigItem>> arrayList2 = new ArrayList<>();
        Iterator<dz0<ViewConfigItem>> it = arrayList.iterator();
        while (it.hasNext()) {
            dz0<ViewConfigItem> next = it.next();
            if (next.d() == view) {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    public static d M() {
        return c.a;
    }

    public void C(String str, String str2) {
        TrackingService L;
        ViewEvent createViewEvent = ViewEvent.createViewEvent(str, str2, this.f);
        if (2 == createViewEvent.source) {
            this.c.clear();
            if (!(h() == null || (L = L(h())) == null)) {
                L.q();
            }
        }
        a(createViewEvent);
    }

    /* access modifiers changed from: package-private */
    public void D(Activity activity, TrackingService trackingService) {
        InternalTriggerController.a(activity).setTag(R$id.poplayer_trigger_tracking_service_id, trackingService);
    }

    public TrackingService.i E(Activity activity, ViewEvent viewEvent, ViewConfigItem viewConfigItem, View view, String str, String str2) {
        Throwable th;
        try {
            try {
                return J(activity).o(str2, view, viewConfigItem.viewuri, str, viewConfigItem.params, viewConfigItem.selectFromCache, viewConfigItem.continuousSelect, viewConfigItem.operationName, viewEvent, viewConfigItem, this.j, true);
            } catch (Throwable th2) {
                th = th2;
                cr1.c("createSelectTask.error", th);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            cr1.c("createSelectTask.error", th);
            return null;
        }
    }

    public String I(PopRequest popRequest, String str) {
        Object c2;
        if (!(popRequest == null || (c2 = popRequest.c()) == null || !(c2 instanceof b))) {
            b bVar = (b) c2;
            if ("groupId".equals(str)) {
                return bVar.a;
            }
            if (PopLayer.ACTION_TRACK_INFO_KEY_OPERATION_NAME.equals(str)) {
                return bVar.b;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public TrackingService J(Activity activity) {
        TrackingService L = L(activity);
        if (L != null) {
            return L;
        }
        TrackingService trackingService = new TrackingService(activity);
        D(activity, trackingService);
        return trackingService;
    }

    public ArrayList<PopRequest> K(PopLayerBaseView popLayerBaseView, String str, String str2) {
        Object c2;
        ArrayList i2 = i(str2);
        ArrayList<PopRequest> arrayList = new ArrayList<>();
        if (!(i2 == null || i2.size() == 0)) {
            Iterator it = i2.iterator();
            while (it.hasNext()) {
                dz0 dz0 = (dz0) it.next();
                if (dz0.g() != null && dz0.g() == popLayerBaseView && (c2 = dz0.c()) != null && (c2 instanceof b)) {
                    b bVar = (b) c2;
                    if (!TextUtils.isEmpty(bVar.a) && bVar.a.equals(str)) {
                        arrayList.add(dz0);
                    }
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public TrackingService L(Activity activity) {
        Object tag = InternalTriggerController.a(activity).getTag(R$id.poplayer_trigger_tracking_service_id);
        if (tag == null) {
            return null;
        }
        return (TrackingService) tag;
    }

    public void N(Activity activity, View view, String str, String str2, ViewConfigItem viewConfigItem, String str3) {
        if (activity == null) {
            cr1.b("managerTask.fail:opreateActivity == null", new Object[0]);
        } else {
            J(activity).k(view, str, str2, viewConfigItem, str3);
        }
    }

    public void O() {
        C(this.g, this.h);
    }

    public void P(String str, View view) {
        if (view == null) {
            cr1.b("removeMsg.fail:hostView == null", new Object[0]);
        } else {
            N((Activity) view.getContext(), view, str, TrackingService.TASK_OPER_REMOVE_ACTIVE_LAUNCHED, null, null);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.poplayer.trigger.b
    public void j() {
        this.a = new tv2(PopLayer.getReference(), PopLayer.getReference().getConfigAdapter(3));
        this.b = new com.alibaba.poplayer.trigger.d(this);
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.poplayer.trigger.b
    public boolean k(ArrayList<dz0<ViewConfigItem>> arrayList, dz0<ViewConfigItem> dz0) {
        if (!(arrayList == null || arrayList.isEmpty() || dz0 == null)) {
            Iterator<dz0<ViewConfigItem>> it = arrayList.iterator();
            while (it.hasNext()) {
                dz0<ViewConfigItem> next = it.next();
                if (next.r().viewuri.equals(dz0.r().viewuri) && next.d() == dz0.d()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.alibaba.poplayer.trigger.b
    public void n(Activity activity, String str) {
        TrackingService L = L(activity);
        if (L != null) {
            L.j();
        }
        this.i.clear();
        this.b.b(-1);
        c(false, str, false);
    }

    @Override // com.alibaba.poplayer.trigger.b
    public void q(PopRequest popRequest) {
        if (popRequest instanceof dz0) {
            dz0 dz0 = (dz0) popRequest;
            L(dz0.a()).k(null, null, TrackingService.TASK_OPER_REMOVE_ALL, (ViewConfigItem) dz0.r(), null);
            return;
        }
        r(popRequest, true, true);
    }

    @Override // com.alibaba.poplayer.trigger.b
    public void v(boolean z, Context context) {
        ((tv2) this.a).w(z, context);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.alibaba.poplayer.trigger.view.d */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    /* renamed from: x */
    public void a(ViewEvent viewEvent) {
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        sb.append(str);
        sb.append(" create Event:{%s}.");
        cr1.b(sb.toString(), viewEvent.toString());
        if (TextUtils.isEmpty(viewEvent.attachActivityKeyCode) || !viewEvent.attachActivityKeyCode.equals(this.f)) {
            cr1.b("%s activeAccept Useless event,eventKeyCode:%s,curKeyCode:%s.", str, viewEvent.attachActivityKeyCode, this.f);
            return;
        }
        if (!b(viewEvent)) {
            this.c.add(viewEvent);
        }
        new ArrayList().add(viewEvent);
        tu2 g = ((tv2) this.a).g(viewEvent);
        new ArrayList().add(g);
        F(h(), viewEvent, g.a);
        if (2 == viewEvent.source && !g.b.isEmpty()) {
            this.b.c(viewEvent, g.b);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.alibaba.poplayer.trigger.view.d */
    /* JADX WARN: Multi-variable type inference failed */
    public void y(View view, String str, Map<String, String> map) {
        String str2;
        if (!str.startsWith(VIEW_SCHEME)) {
            cr1.b("%s.activeAccept fail,uri{%s} must startsWith{%s} error", TAG, str, VIEW_SCHEME);
        } else if (view.getContext() == null) {
            cr1.b("%s.activeAccept fail,uri{%s},attachActivity is empty.", TAG, str);
        } else {
            Activity activity = (Activity) view.getContext();
            if (map == null) {
                str2 = null;
            } else {
                str2 = map.toString();
            }
            ViewEvent createViewEvent = ViewEvent.createViewEvent(str, str2, InternalTriggerController.b(activity));
            createViewEvent.setHostView(new WeakReference<>(view));
            F(activity, createViewEvent, ((tv2) this.a).y(createViewEvent, map).a);
        }
    }
}
