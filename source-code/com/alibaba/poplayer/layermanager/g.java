package com.alibaba.poplayer.layermanager;

import android.app.Activity;
import android.view.View;
import com.alibaba.poplayer.R$id;
import com.alibaba.poplayer.layermanager.PopRequest;
import com.alibaba.poplayer.layermanager.view.Canvas;
import com.alibaba.poplayer.layermanager.view.PopLayerViewContainer;
import com.alibaba.poplayer.layermanager.view.SandoContainer;
import com.alibaba.poplayer.trigger.view.TrackingService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tb.cr1;
import tb.eu2;

/* compiled from: Taobao */
public class g implements ICVMHolderAction {
    private WeakReference<Activity> a;
    private HashMap<View, b> b;
    private e c;
    private WeakReference<SandoContainer> d;
    private boolean e = false;

    public g(e eVar, Activity activity) {
        this.c = eVar;
        this.a = new WeakReference<>(activity);
        this.b = new HashMap<>();
    }

    private void a() {
        Activity activity;
        if (!this.e && (activity = (Activity) eu2.c(this.a)) != null) {
            PopLayerViewContainer b2 = this.c.g.b(activity);
            b2.setTag(R$id.layermanager_viewmodel_view_id, this);
            this.d = new WeakReference<>(b2.getSandoContainer());
            this.e = true;
        }
    }

    private boolean b(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.toString().contains(TrackingService.OPER_MIRROR);
    }

    @Override // com.alibaba.poplayer.layermanager.ICVMHolderAction
    public void acceptRequests(ArrayList<PopRequest> arrayList) {
        a();
        Activity activity = (Activity) eu2.c(this.a);
        if (activity == null) {
            cr1.b("context is empty!", new Object[0]);
            return;
        }
        SandoContainer sandoContainer = (SandoContainer) eu2.c(this.d);
        if (sandoContainer == null) {
            cr1.b("container is empty!", new Object[0]);
            return;
        }
        Iterator<PopRequest> it = arrayList.iterator();
        while (it.hasNext()) {
            PopRequest next = it.next();
            View d2 = next.d();
            if (d2 != null) {
                Object c2 = next.c();
                if (b(c2)) {
                    sandoContainer.getMirrorLayer().addMirrorView(c2.toString().contains("realTime"), d2);
                    cr1.b("ViewCVMHolder.add new Canvas", new Object[0]);
                    next.q(PopRequest.Status.SHOWING);
                } else {
                    b bVar = this.b.get(d2);
                    if (bVar != null && bVar.d() == null) {
                        this.b.remove(d2);
                        bVar = null;
                    }
                    if (bVar == null) {
                        bVar = new b(3);
                        bVar.f(new Canvas(activity));
                        this.b.put(d2, bVar);
                    }
                    ArrayList<PopRequest> arrayList2 = new ArrayList<>();
                    arrayList2.add(next);
                    bVar.a(arrayList2);
                    sandoContainer.getAugmentedLayer().augmentTargetView(next.d(), bVar.d());
                    cr1.b("ViewCVMHolder.add new Canvas", new Object[0]);
                }
            }
        }
    }

    @Override // com.alibaba.poplayer.layermanager.ICVMHolderAction
    public void attach(Activity activity) {
        if (e.i && activity.isChild() && (activity.getParent() instanceof Activity)) {
            this.a = new WeakReference<>(activity);
        }
        this.e = false;
    }

    @Override // com.alibaba.poplayer.layermanager.ICVMHolderAction
    public void removeRequests(ArrayList<PopRequest> arrayList) {
        if (((Activity) eu2.c(this.a)) == null) {
            cr1.b("context is empty!", new Object[0]);
            return;
        }
        SandoContainer sandoContainer = (SandoContainer) eu2.c(this.d);
        if (sandoContainer == null) {
            cr1.b("container is empty!", new Object[0]);
            return;
        }
        Iterator<PopRequest> it = arrayList.iterator();
        while (it.hasNext()) {
            PopRequest next = it.next();
            View d2 = next.d();
            if (d2 != null) {
                if (b(next.c())) {
                    sandoContainer.getMirrorLayer().removeMirrorView(d2);
                    cr1.b("RemoveMirrorView{hostView:%s}.", d2.toString());
                } else {
                    b bVar = this.b.get(d2);
                    if (bVar == null || bVar.d() == null) {
                        cr1.b("removeRequest fail:Cvm is null.", new Object[0]);
                    } else {
                        ArrayList<PopRequest> arrayList2 = new ArrayList<>();
                        arrayList2.add(next);
                        bVar.e(arrayList2);
                        if (bVar.c() == 0) {
                            sandoContainer.getAugmentedLayer().unaugmentTarget(bVar.d());
                            bVar.f(null);
                            this.b.remove(d2);
                            cr1.b("Free Augmentd CVM :{hostView:%s}.", d2.toString());
                        }
                    }
                }
            }
        }
    }

    @Override // com.alibaba.poplayer.layermanager.ICVMHolderAction
    public void viewReadyNotify(PopRequest popRequest) {
    }
}
