package com.alibaba.poplayer.layermanager;

import android.app.Activity;
import android.app.Application;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.annotation.IdRes;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.R$id;
import com.alibaba.poplayer.exception.PoplayerException;
import com.alibaba.poplayer.layermanager.PopRequest;
import com.alibaba.poplayer.layermanager.config.ConfigItem;
import com.alibaba.poplayer.layermanager.view.PopLayerViewContainer;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import tb.ac;
import tb.cr1;
import tb.eu2;
import tb.lu0;
import tb.xl;

/* compiled from: Taobao */
public class e {
    public static final String TAG = "e";
    public static boolean i;
    private static e j;
    private xl a;
    private ILayerMgrAdapter b;
    private WeakReference<Activity> c;
    private ac d;
    private ICVMHolderAction e;
    private ArrayList<PopRequest> f;
    a g = new a();
    b h = new b();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a {
        a() {
        }

        /* access modifiers changed from: package-private */
        public ICVMHolderAction a(PopRequest popRequest) {
            Activity a2 = popRequest.a();
            if (popRequest.b() == 1) {
                return e.this.e;
            }
            if (popRequest.b() == 2) {
                if (a2 == null) {
                    return null;
                }
                return e.this.g.e(popRequest.a());
            } else if (popRequest.b() != 3) {
                throw new PoplayerException("UNKNOW Domain.");
            } else if (popRequest.d() == null) {
                throw new PoplayerException("This request not has HostView but Domain is VIEW.");
            } else if (a2 == null) {
                return null;
            } else {
                return e.this.g.f(popRequest.a());
            }
        }

        /* access modifiers changed from: package-private */
        public PopLayerViewContainer b(Activity activity) {
            Window window;
            PopLayerViewContainer c = e.this.g.c(activity);
            if (c != null) {
                return c;
            }
            if (e.i && activity.isChild() && (activity.getParent() instanceof Activity)) {
                activity = activity.getParent();
            }
            PopLayerViewContainer popLayerViewContainer = new PopLayerViewContainer(activity);
            popLayerViewContainer.setId(R$id.layermanager_penetrate_webview_container_id);
            popLayerViewContainer.setVisibility(0);
            if (!e.i || !activity.isChild() || !(activity.getParent() instanceof Activity)) {
                window = activity.getWindow();
            } else {
                window = activity.getParent().getWindow();
            }
            window.addContentView(popLayerViewContainer, new LinearLayout.LayoutParams(-1, -1));
            popLayerViewContainer.bringToFront();
            return popLayerViewContainer;
        }

        /* access modifiers changed from: package-private */
        public PopLayerViewContainer c(Activity activity) {
            if (e.i && activity.isChild() && (activity.getParent() instanceof Activity)) {
                activity = activity.getParent();
            }
            return (PopLayerViewContainer) activity.getWindow().findViewById(R$id.layermanager_penetrate_webview_container_id);
        }

        /* access modifiers changed from: package-private */
        public View d(Activity activity) {
            if (e.i && activity.isChild() && (activity.getParent() instanceof Activity)) {
                activity = activity.getParent();
            }
            return activity.getWindow().findViewById(16908290);
        }

        /* access modifiers changed from: package-private */
        public f e(Activity activity) {
            Object tag;
            View d = d(activity);
            if (d == null || (tag = d.getTag(R$id.layermanager_viewmodel_page_id)) == null) {
                return null;
            }
            return (f) tag;
        }

        /* access modifiers changed from: package-private */
        public g f(Activity activity) {
            Object tag;
            View d = d(activity);
            if (d == null || (tag = d.getTag(R$id.layermanager_viewmodel_view_id)) == null) {
                return null;
            }
            return (g) tag;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b {
        b() {
        }

        public void a(Activity activity, ICVMHolderAction iCVMHolderAction, @IdRes int i) {
            e.this.g.d(activity).setTag(i, iCVMHolderAction);
        }
    }

    public e(ILayerMgrAdapter iLayerMgrAdapter) {
        this.b = iLayerMgrAdapter;
        this.a = new xl(this.b);
        this.f = new ArrayList<>();
    }

    private Activity c() {
        return (Activity) eu2.c(this.c);
    }

    public static e f() {
        return j;
    }

    private lu0<ICVMHolderAction, PopRequest> i(ArrayList<? extends PopRequest> arrayList) throws PoplayerException {
        lu0<ICVMHolderAction, PopRequest> lu0 = new lu0<>();
        Iterator<? extends PopRequest> it = arrayList.iterator();
        while (it.hasNext()) {
            PopRequest popRequest = (PopRequest) it.next();
            if (!this.f.isEmpty() && this.f.contains(popRequest)) {
                this.f.remove(popRequest);
            } else if (popRequest.i() == PopRequest.Status.REMOVED) {
                cr1.b("%s.removeAdjustRequests=> but status = remove", toString());
            } else if (popRequest.h() == null || !(popRequest.h() instanceof c)) {
                cr1.b("%s.removeAdjustRequests=> but popParam is empty or but InnerPopParam", toString());
            } else {
                ICVMHolderAction a2 = this.g.a(popRequest);
                if (a2 == null) {
                    cr1.b("%s.removeAdjustRequests=> find canvas view model fail.", toString());
                } else {
                    lu0.c(a2, popRequest);
                }
            }
        }
        return lu0;
    }

    private void j(Activity activity) {
        if (this.e == null) {
            this.e = new a(activity.getApplication());
        }
        this.e.attach(activity);
        f e2 = this.g.e(activity);
        Object[] objArr = new Object[2];
        String str = TAG;
        boolean z = false;
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(e2 != null);
        cr1.b("%s.resetViewModels: find pageVM : %s.", objArr);
        if (e2 == null) {
            e2 = new f(this, activity);
            this.h.a(activity, e2, R$id.layermanager_viewmodel_page_id);
        }
        e2.attach(activity);
        g f2 = this.g.f(activity);
        Object[] objArr2 = new Object[2];
        objArr2[0] = str;
        if (f2 != null) {
            z = true;
        }
        objArr2[1] = Boolean.valueOf(z);
        cr1.b("%s.resetViewModels: find viewsVM : %s.", objArr2);
        if (f2 == null) {
            f2 = new g(this, activity);
            this.h.a(activity, f2, R$id.layermanager_viewmodel_view_id);
        }
        f2.attach(activity);
    }

    private lu0<ICVMHolderAction, PopRequest> l(ArrayList<? extends PopRequest> arrayList) throws PoplayerException {
        ConfigItem configItem;
        lu0<ICVMHolderAction, PopRequest> lu0 = new lu0<>();
        Iterator<? extends PopRequest> it = arrayList.iterator();
        while (it.hasNext()) {
            PopRequest popRequest = (PopRequest) it.next();
            PopRequest.Status i2 = popRequest.i();
            PopRequest.Status status = PopRequest.Status.WAITTING;
            if (i2 == status || popRequest.i() == PopRequest.Status.REMOVED) {
                ac acVar = this.d;
                if (acVar == null || (configItem = acVar.a(popRequest.f())) == null) {
                    cr1.b("%s.tryAdjustRequests.not find ConfigRule,use default.", TAG);
                    configItem = new ConfigItem();
                }
                ICVMHolderAction a2 = this.g.a(popRequest);
                if (a2 == null) {
                    cr1.b("%s.tryAdjustRequests=> find canvas view model fail.", toString());
                } else {
                    if (!(popRequest.h() instanceof c)) {
                        popRequest.p(new c(popRequest.h(), configItem));
                    }
                    popRequest.q(status);
                    lu0.c(a2, popRequest);
                }
            } else {
                cr1.b("%s.tryAdjustRequests=> add but status not in (waitting or removed)", toString());
            }
        }
        return lu0;
    }

    public void b(PopRequest popRequest) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new PoplayerException("Please execute on UI Thread.");
        } else if (popRequest.i() == PopRequest.Status.WAITTING || popRequest.i() == PopRequest.Status.REMOVED) {
            cr1.b("%s.viewReadyNotify=> add but status = waitting or removed.", toString());
        } else if (!(popRequest.h() instanceof c)) {
            cr1.b("%s.viewReadyNotify=> add but popParam not InnerPopParam", toString());
        } else if (popRequest.e() == null) {
            cr1.b("%s.viewReadyNotify=>layer is empty.", toString());
        } else {
            this.g.a(popRequest).viewReadyNotify(popRequest);
        }
    }

    public PopLayerViewContainer d() {
        return this.g.c((Activity) eu2.c(this.c));
    }

    public void e(Application application) {
        if (j == null) {
            j = this;
        }
        this.b.initializeConfigContainer(this);
        this.b.addConfigObserver(this);
        n();
    }

    public void g(PopRequest popRequest) {
        if (popRequest != null) {
            ArrayList<PopRequest> arrayList = new ArrayList<>();
            arrayList.add(popRequest);
            h(arrayList);
        }
    }

    public void h(ArrayList<PopRequest> arrayList) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            lu0<ICVMHolderAction, PopRequest> i2 = i(arrayList);
            for (ICVMHolderAction iCVMHolderAction : i2.b().keySet()) {
                iCVMHolderAction.removeRequests(i2.a(iCVMHolderAction));
            }
            return;
        }
        throw new PoplayerException("Please execute on UI Thread.");
    }

    public void k(Activity activity, String str) {
        if (PopLayer.getReference().isSamePage(activity, c())) {
            cr1.b("%s.touchActivity.is same page.", TAG);
            return;
        }
        j(activity);
        this.c = new WeakReference<>(activity);
        cr1.b("%s.currentActivity is: %s.", TAG, activity.getClass().getName());
        o();
    }

    public void m(ArrayList<? extends PopRequest> arrayList) throws PoplayerException {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new PoplayerException("Please execute on UI Thread.");
        } else if (!this.a.c()) {
            cr1.b("%s.tryOpen,but LayerMgr`configs not ready.Saving", TAG);
            this.f.addAll(arrayList);
        } else {
            lu0<ICVMHolderAction, PopRequest> l = l(arrayList);
            for (ICVMHolderAction iCVMHolderAction : l.b().keySet()) {
                iCVMHolderAction.acceptRequests(l.a(iCVMHolderAction));
            }
        }
    }

    public void n() {
        this.a.e();
    }

    public void o() {
        if (c() != null) {
            ac b2 = this.a.b(c().getClass().getName());
            this.d = b2;
            Object[] objArr = new Object[2];
            objArr[0] = TAG;
            objArr[1] = b2 == null ? DXRecyclerLayout.LOAD_MORE_EMPTY : b2.toString();
            cr1.b("%s.update BizConfig: %s.", objArr);
        } else {
            cr1.b("%s.currentActivity is empty.updateBizConfig fail.", TAG);
        }
        if (!this.f.isEmpty()) {
            cr1.b("%s.config update. deal waitting list ,size:{%s}.", TAG, Integer.valueOf(this.f.size()));
            m(this.f);
            this.f.clear();
        }
    }
}
