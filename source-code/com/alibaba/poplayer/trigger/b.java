package com.alibaba.poplayer.trigger;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.factory.view.base.PopLayerBaseView;
import com.alibaba.poplayer.layermanager.PopRequest;
import com.alibaba.poplayer.layermanager.e;
import com.alibaba.poplayer.trigger.BaseConfigItem;
import com.alibaba.poplayer.trigger.Event;
import com.alibaba.poplayer.trigger.a;
import com.alibaba.poplayer.utils.Monitor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tb.cr1;
import tb.dz0;
import tb.eu2;
import tb.hn1;
import tb.q61;

@Monitor.TargetClass
/* compiled from: Taobao */
public abstract class b<T extends Event, K extends BaseConfigItem, C extends a> implements PopRequest.PopRequestStatusCallBack {
    @Monitor.TargetField
    public C a;
    public d b;
    public List<T> c = new ArrayList();
    protected ConcurrentHashMap<String, ArrayList<dz0<K>>> d = new ConcurrentHashMap<>();
    public WeakReference<Activity> e;
    public String f;
    public String g;
    public String h;

    public b() {
        j();
    }

    private void e(ArrayList<PopRequest> arrayList) {
        Iterator<PopRequest> it = arrayList.iterator();
        while (it.hasNext()) {
            dz0 dz0 = (dz0) it.next();
            if (dz0.e() != null && (dz0.e() instanceof PopLayerBaseView)) {
                ((PopLayerBaseView) dz0.e()).destroyView();
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a(T t);

    public boolean b(T t) {
        for (T t2 : this.c) {
            if (t.equals(t2)) {
                return true;
            }
        }
        return false;
    }

    public void c(boolean z, String str, boolean z2) {
        ArrayList<dz0<K>> arrayList;
        if (!TextUtils.isEmpty(str) && (arrayList = this.d.get(str)) != null && !arrayList.isEmpty()) {
            Iterator<dz0<K>> it = arrayList.iterator();
            ArrayList<PopRequest> arrayList2 = new ArrayList<>();
            while (it.hasNext()) {
                dz0<K> next = it.next();
                if (PopRequest.Status.WAITTING == next.i() || PopRequest.Status.READY == next.i() || PopRequest.Status.REMOVED == next.i()) {
                    it.remove();
                    arrayList2.add(next);
                    cr1.b("[%s][.remove {%s}. - remove waitting and ready . ", str, next.toString());
                } else if (!z2 && PopRequest.Status.SHOWING == next.i()) {
                    if (z || !next.r().embed) {
                        arrayList2.add(next);
                        it.remove();
                        cr1.b("[%s].remove {%s}. - remove showing but unEmbed . ", str, next.toString());
                    }
                }
            }
            if (arrayList2.size() > 0) {
                e(arrayList2);
                e.f().h(arrayList2);
            }
        }
    }

    public void d() {
        this.d.clear();
    }

    public void f(PopRequest popRequest) {
        PopLayerBaseView popLayerBaseView;
        if (popRequest instanceof dz0) {
            dz0 dz0 = (dz0) popRequest;
            Activity a2 = popRequest.a();
            if (dz0.e() == null) {
                popLayerBaseView = q61.b().a(a2, dz0.r().type);
                if (popLayerBaseView == null) {
                    cr1.b("createLayerAndAddRequest fail.Create layer Fail.", new Object[0]);
                    p(popRequest);
                    cr1.b("createLayerAndAddRequest fail.Removed.", new Object[0]);
                    return;
                }
                dz0.n(popLayerBaseView);
                popLayerBaseView.setPopRequest(dz0);
            } else {
                popLayerBaseView = (PopLayerBaseView) dz0.e();
            }
            try {
                popLayerBaseView.init(a2, dz0);
            } catch (Throwable th) {
                cr1.c("PopLayerView init fail.", th);
            }
            e.f().b(popRequest);
            try {
                popLayerBaseView.onViewAdded(a2);
            } catch (Throwable th2) {
                cr1.c("PopLayerView onViewAdded fail.", th2);
            }
            try {
                PopLayer.getReference().onPopped(popRequest.b(), a2, popRequest.e());
            } catch (Throwable th3) {
                cr1.c("PopLayerView onLayerPopped notify fail.", th3);
            }
            if (hn1.a(dz0.r())) {
                ((PopLayerBaseView) dz0.e()).displayMe();
            }
        }
    }

    public C g() {
        return this.a;
    }

    public Activity h() {
        return (Activity) eu2.c(this.e);
    }

    public ArrayList<dz0<K>> i(String str) {
        return this.d.get(str);
    }

    /* access modifiers changed from: protected */
    public abstract void j();

    /* access modifiers changed from: protected */
    public boolean k(ArrayList<dz0<K>> arrayList, dz0<K> dz0) {
        if (!(arrayList == null || arrayList.isEmpty() || dz0 == null)) {
            Iterator<dz0<K>> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().r().uuid.equals(dz0.r().uuid)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void l(Activity activity) {
        ArrayList<dz0<K>> i = i(InternalTriggerController.b(activity));
        if (!(i == null || i.isEmpty())) {
            for (dz0<K> dz0 : i) {
                if (dz0 != null) {
                    try {
                        if (dz0.i() == PopRequest.Status.SHOWING && dz0.e() != null && (dz0.e() instanceof PopLayerBaseView)) {
                            ((PopLayerBaseView) dz0.e()).onActivityPaused();
                        }
                    } catch (Throwable th) {
                        cr1.c("notifyShowingViewsOnActivityPaused error", th);
                    }
                }
            }
        }
    }

    public void m(Activity activity) {
        ArrayList<dz0<K>> i = i(InternalTriggerController.b(activity));
        if (!(i == null || i.isEmpty())) {
            for (dz0<K> dz0 : i) {
                if (dz0 != null) {
                    try {
                        if (dz0.i() == PopRequest.Status.SHOWING && dz0.e() != null && (dz0.e() instanceof PopLayerBaseView)) {
                            ((PopLayerBaseView) dz0.e()).onActivityResumed();
                        }
                    } catch (Throwable th) {
                        cr1.c("notifyShowingViewsOnActivityResumed error", th);
                    }
                }
            }
        }
    }

    public void n(Activity activity, String str) {
    }

    public void o() {
        cr1.b("%s: activity resue,resume all event.", getClass().getSimpleName());
        for (T t : this.c) {
            a(t);
        }
    }

    @Override // com.alibaba.poplayer.layermanager.PopRequest.PopRequestStatusCallBack
    public void onForceRemoved(PopRequest popRequest) {
        p(popRequest);
    }

    @Override // com.alibaba.poplayer.layermanager.PopRequest.PopRequestStatusCallBack
    public void onReady(PopRequest popRequest) {
        if (popRequest instanceof dz0) {
            f(popRequest);
        }
    }

    @Override // com.alibaba.poplayer.layermanager.PopRequest.PopRequestStatusCallBack
    public void onRecovered(PopRequest popRequest) {
    }

    @Override // com.alibaba.poplayer.layermanager.PopRequest.PopRequestStatusCallBack
    public void onSuspended(PopRequest popRequest) {
    }

    /* access modifiers changed from: protected */
    public void p(PopRequest popRequest) {
        for (String str : this.d.keySet()) {
            ArrayList<dz0<K>> arrayList = this.d.get(str);
            if (!(arrayList == null || arrayList.isEmpty() || !arrayList.contains(popRequest))) {
                arrayList.remove(popRequest);
                cr1.b("[%s].remove {%s}. - active close. ", this.f, popRequest.toString());
                return;
            }
        }
    }

    public void q(PopRequest popRequest) {
        r(popRequest, true, false);
    }

    public void r(PopRequest popRequest, boolean z, boolean z2) {
        if (z && popRequest.e() != null && (popRequest.e() instanceof PopLayerBaseView)) {
            ((PopLayerBaseView) popRequest.e()).destroyView();
        }
        e.f().g(popRequest);
        if (popRequest.e() instanceof PopLayerBaseView) {
            PopLayerBaseView popLayerBaseView = (PopLayerBaseView) popRequest.e();
            popLayerBaseView.onViewRemoved(popLayerBaseView.getContext());
        }
        if (z2) {
            p(popRequest);
        }
    }

    public void s() {
        this.b.b(-1);
        cr1.b("%s: activity pause,stop all timer.", getClass().getSimpleName());
    }

    public void t(String str, ArrayList<dz0<K>> arrayList) {
        ArrayList<dz0<K>> tryOpenRequestControl = PopLayer.getReference().tryOpenRequestControl(arrayList);
        if (!(tryOpenRequestControl == null || tryOpenRequestControl.isEmpty())) {
            ArrayList<dz0<K>> arrayList2 = this.d.get(str);
            if (arrayList2 == null || arrayList2.isEmpty()) {
                this.d.put(str, tryOpenRequestControl);
                e.f().m(tryOpenRequestControl);
                return;
            }
            ArrayList<? extends PopRequest> arrayList3 = new ArrayList<>();
            for (int i = 0; i < tryOpenRequestControl.size(); i++) {
                dz0<K> dz0 = tryOpenRequestControl.get(i);
                Event s = dz0.s();
                boolean z = s != null && s.source == 2;
                cr1.b("tryOpenRequest.pageSwitchType:{%s}.", Boolean.valueOf(z));
                boolean k = k(arrayList2, dz0);
                cr1.b("tryOpenRequest.isPopRequestContains:{%s}.", Boolean.valueOf(k));
                if (!z || !k) {
                    if (dz0.i() != PopRequest.Status.SHOWING) {
                        arrayList3.add(dz0);
                    }
                    arrayList2.add(dz0);
                }
            }
            if (!arrayList3.isEmpty()) {
                e.f().m(arrayList3);
            }
        }
    }

    public void u(Activity activity, String str, String str2, String str3) {
        this.e = new WeakReference<>(activity);
        this.g = str;
        this.h = str2;
        this.f = str3;
    }

    public void v(boolean z, Context context) {
        this.a.w(z, context);
    }

    public void w() {
        c(false, this.f, true);
        if (!this.c.isEmpty()) {
            for (T t : this.c) {
                a(t);
            }
        }
    }
}
