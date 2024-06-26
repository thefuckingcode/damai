package tb;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.taobao.monitor.annotation.UnsafeMethod;
import com.taobao.monitor.network.a;
import com.taobao.monitor.procedure.IPage;
import com.taobao.monitor.procedure.IPageManager;
import com.taobao.monitor.procedure.IProcedure;
import com.taobao.monitor.procedure.IProcedureManager;
import com.taobao.monitor.procedure.ProcedureImpl;
import com.taobao.monitor.procedure.ProcedureProxy;
import com.taobao.monitor.procedure.c;
import com.taobao.monitor.procedure.f;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class co1 implements IPageManager, IProcedureManager {
    private final IProcedure a;
    @Deprecated
    private volatile IProcedure b;
    @Deprecated
    private volatile IProcedure c;
    private volatile IProcedure d;
    private final Map<Activity, IPage> e = new ConcurrentHashMap();
    private final Map<Fragment, IPage> f = new ConcurrentHashMap();
    private final Map<IPage, IProcedure> g = new ConcurrentHashMap();
    private final Map<IPage, WeakReference<View>> h = new ConcurrentHashMap();

    public co1() {
        IProcedure iProcedure = IProcedure.DEFAULT;
        this.a = iProcedure;
        this.d = iProcedure;
    }

    private f a(IProcedure iProcedure, String str) {
        f g2 = g(iProcedure);
        if (g2 != null && g2.m().get("H5_URL") != null && !TextUtils.isEmpty(g2.m().get("H5_URL").toString()) && c(str, g2.m().get("H5_URL").toString())) {
            return g2;
        }
        if (g2 == null || g2.m().get("schemaUrl") == null || TextUtils.isEmpty(g2.m().get("schemaUrl").toString()) || !c(str, g2.m().get("schemaUrl").toString())) {
            return null;
        }
        return g2;
    }

    private boolean c(String str, String str2) {
        try {
            URI uri = new URI(str);
            URI uri2 = new URI(str2);
            if (!uri2.equals(uri) && !str.substring(uri.getScheme().length()).equals(str2.substring(uri2.getScheme().length()))) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private IProcedure d(Fragment fragment) {
        IPage iPage;
        FragmentActivity activity = fragment.getActivity();
        if (activity == null || (iPage = this.e.get(activity)) == null) {
            return null;
        }
        return this.g.get(iPage);
    }

    private IPage h(IPage iPage) {
        return iPage == null ? IPage.DEFAULT_PAGE : iPage;
    }

    private IProcedure i(IProcedure iProcedure) {
        return iProcedure == null ? IProcedure.DEFAULT : iProcedure;
    }

    private Map<View, IPage> j() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Activity, IPage> entry : this.e.entrySet()) {
            if (!(entry.getKey() == null || entry.getKey().getWindow() == null || entry.getKey().getWindow().getDecorView() == null || entry.getValue() == null || this.g.get(entry.getValue()) == null)) {
                hashMap.put(entry.getKey().getWindow().getDecorView(), entry.getValue());
            }
        }
        for (Map.Entry<Fragment, IPage> entry2 : this.f.entrySet()) {
            if (!(entry2.getKey() == null || entry2.getKey().getView() == null || entry2.getValue() == null || this.g.get(entry2.getValue()) == null)) {
                hashMap.put(entry2.getKey().getView(), entry2.getValue());
            }
        }
        return hashMap;
    }

    private Map<View, IProcedure> k() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Activity, IPage> entry : this.e.entrySet()) {
            if (!(entry.getKey() == null || entry.getKey().getWindow() == null || entry.getKey().getWindow().getDecorView() == null || entry.getValue() == null || this.g.get(entry.getValue()) == null)) {
                hashMap.put(entry.getKey().getWindow().getDecorView(), this.g.get(entry.getValue()));
            }
        }
        for (Map.Entry<Fragment, IPage> entry2 : this.f.entrySet()) {
            if (!(entry2.getKey() == null || entry2.getKey().getView() == null || entry2.getValue() == null || this.g.get(entry2.getValue()) == null)) {
                hashMap.put(entry2.getKey().getView(), this.g.get(entry2.getValue()));
            }
        }
        return hashMap;
    }

    private void m(IProcedure iProcedure, f fVar) {
        if (!(iProcedure == null || fVar == null || g(iProcedure) == null)) {
            for (td2 td2 : g(iProcedure).q()) {
                if ("phaPageNavigationStart".equals(td2.a())) {
                    fVar.q().add(new td2(td2.a(), td2.b()));
                }
                if ("phaStartTime".equals(td2.a())) {
                    fVar.q().add(new td2(td2.a(), td2.b()));
                }
                if ("phaManifestFinishLoad".equals(td2.a())) {
                    fVar.q().add(new td2(td2.a(), td2.b()));
                }
                if ("phaPageCreateStart".equals(td2.a())) {
                    fVar.q().add(new td2(td2.a(), td2.b()));
                }
                if ("phaStartTime".equals(td2.a())) {
                    fVar.q().add(new td2(td2.a(), td2.b()));
                }
                if ("navStartTime".equals(td2.a())) {
                    fVar.q().add(new td2(td2.a(), td2.b()));
                }
            }
        }
    }

    public void b() {
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.h.clear();
    }

    @NonNull
    public IProcedure e(IPage iPage) {
        if (iPage == null) {
            return IProcedure.DEFAULT;
        }
        return i(this.g.get(iPage));
    }

    public String f(String str) {
        f a2;
        f a3;
        for (Map.Entry<Fragment, IPage> entry : this.f.entrySet()) {
            IPage value = entry.getValue();
            if (!(value == null || (a3 = a(this.g.get(value), str)) == null)) {
                m(d(entry.getKey()), a3);
                return a.a(a3);
            }
        }
        f a4 = a(this.b, str);
        if (a4 != null) {
            return a.a(a4);
        }
        for (IPage iPage : this.f.values()) {
            if (!(iPage == null || (a2 = a(this.g.get(iPage), str)) == null)) {
                return a.a(a2);
            }
        }
        return "";
    }

    public f g(IProcedure iProcedure) {
        if (iProcedure instanceof ProcedureProxy) {
            return ((ProcedureImpl) ((ProcedureProxy) iProcedure).c()).e();
        }
        if (iProcedure instanceof ProcedureImpl) {
            return ((ProcedureImpl) iProcedure).e();
        }
        return null;
    }

    @Override // com.taobao.monitor.procedure.IPageManager
    @NonNull
    public IPage getActivityPage(Activity activity) {
        if (activity == null) {
            return IPage.DEFAULT_PAGE;
        }
        return h(this.e.get(activity));
    }

    @Override // com.taobao.monitor.procedure.IProcedureManager
    @NonNull
    public IProcedure getActivityProcedure(Activity activity) {
        if (activity == null) {
            return IProcedure.DEFAULT;
        }
        return i(e(this.e.get(activity)));
    }

    @Override // com.taobao.monitor.procedure.IProcedureManager
    @NonNull
    @Deprecated
    public IProcedure getCurrentActivityProcedure() {
        return i(this.b);
    }

    @Override // com.taobao.monitor.procedure.IProcedureManager
    @NonNull
    @Deprecated
    public IProcedure getCurrentFragmentProcedure() {
        return i(this.c);
    }

    @Override // com.taobao.monitor.procedure.IProcedureManager
    @NonNull
    public IProcedure getCurrentProcedure() {
        if (this.d != null && this.d.isAlive()) {
            return this.d;
        }
        if (this.b != null) {
            return this.b;
        }
        if (this.c != null) {
            return this.c;
        }
        return i(this.a);
    }

    @Override // com.taobao.monitor.procedure.IPageManager
    @NonNull
    public IPage getFragmentPage(Fragment fragment) {
        if (fragment == null) {
            return IPage.DEFAULT_PAGE;
        }
        return h(this.f.get(fragment));
    }

    @Override // com.taobao.monitor.procedure.IProcedureManager
    @NonNull
    public IProcedure getFragmentProcedure(Fragment fragment) {
        if (fragment == null) {
            return IProcedure.DEFAULT;
        }
        return i(e(this.f.get(fragment)));
    }

    @Override // com.taobao.monitor.procedure.IProcedureManager
    @UnsafeMethod
    public IProcedure getLauncherProcedure() {
        return i(this.d);
    }

    @Override // com.taobao.monitor.procedure.IPageManager
    @NonNull
    public synchronized IPage getPage(View view) {
        if (view == null) {
            return IPage.DEFAULT_PAGE;
        }
        Map<View, IPage> j = j();
        while (!j.containsKey(view)) {
            if (view.getParent() == null || !(view.getParent() instanceof View)) {
                view = null;
                continue;
            } else {
                view = (View) view.getParent();
                continue;
            }
            if (view == null) {
                return IPage.DEFAULT_PAGE;
            }
        }
        return h(j.get(view));
    }

    @Override // com.taobao.monitor.procedure.IPageManager
    @NonNull
    public synchronized IPage getPageGroup(View view) {
        IPage iPage;
        if (view == null) {
            return IPage.DEFAULT_PAGE;
        }
        Map<View, IPage> j = j();
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        do {
            if (!z) {
                for (WeakReference<View> weakReference : this.h.values()) {
                    View view2 = weakReference.get();
                    if (view2 != null && view2 == view) {
                        z = true;
                    }
                }
            }
            if (j.containsKey(view) && (iPage = j.get(view)) != null && z) {
                arrayList.add(iPage);
            }
            if (view.getParent() == null || !(view.getParent() instanceof View)) {
                view = null;
                continue;
            } else {
                view = (View) view.getParent();
                continue;
            }
        } while (view != null);
        return new c(arrayList);
    }

    @Override // com.taobao.monitor.procedure.IProcedureManager
    @NonNull
    public synchronized IProcedure getProcedure(View view) {
        if (view == null) {
            return IProcedure.DEFAULT;
        }
        Map<View, IProcedure> k = k();
        while (!k.containsKey(view)) {
            if (view.getParent() == null || !(view.getParent() instanceof View)) {
                view = null;
                continue;
            } else {
                view = (View) view.getParent();
                continue;
            }
            if (view == null) {
                return IProcedure.DEFAULT;
            }
        }
        return i(k.get(view));
    }

    @Override // com.taobao.monitor.procedure.IProcedureManager
    public IProcedure getRootProcedure() {
        return i(this.a);
    }

    @UnsafeMethod
    public IProcedure l(Activity activity, IPage iPage, IProcedure iProcedure) {
        if (!(activity == null || iPage == null)) {
            this.e.put(activity, iPage);
            o(iPage, iProcedure);
            q(iProcedure);
        }
        return iProcedure;
    }

    @UnsafeMethod
    public IProcedure n(Fragment fragment, IPage iPage, IProcedure iProcedure) {
        if (!(fragment == null || iPage == null)) {
            this.f.put(fragment, iPage);
            o(iPage, iProcedure);
            r(iProcedure);
        }
        return iProcedure;
    }

    public IProcedure o(IPage iPage, IProcedure iProcedure) {
        return iPage == null ? iProcedure : this.g.put(iPage, iProcedure);
    }

    public IProcedure p(IPage iPage) {
        if (iPage == null) {
            return null;
        }
        this.e.values().remove(iPage);
        this.f.values().remove(iPage);
        this.h.remove(iPage);
        return this.g.remove(iPage);
    }

    @UnsafeMethod
    @Deprecated
    public IProcedure q(IProcedure iProcedure) {
        this.b = iProcedure;
        return iProcedure;
    }

    @UnsafeMethod
    @Deprecated
    public IProcedure r(IProcedure iProcedure) {
        this.c = iProcedure;
        return iProcedure;
    }

    public IProcedure s(IProcedure iProcedure) {
        if (iProcedure == null) {
            this.d = IProcedure.DEFAULT;
        } else {
            this.d = iProcedure;
        }
        return this.d;
    }

    public void t(IPage iPage, WeakReference<View> weakReference) {
        if (weakReference != null) {
            this.h.put(iPage, weakReference);
        }
    }
}
