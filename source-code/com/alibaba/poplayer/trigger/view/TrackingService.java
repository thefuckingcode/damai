package com.alibaba.poplayer.trigger.view;

import android.app.Activity;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.poplayer.factory.view.base.PopLayerBaseView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import tb.cr1;
import tb.eu2;

/* compiled from: Taobao */
public class TrackingService {
    public static final String OPER_INFO = "info";
    public static final String OPER_MIRROR = "mirror";
    public static final String OPER_TRACK = "track";
    public static final String OPER_UNMIRROR = "unmirror";
    public static final String OPER_UNTRACK = "untrack";
    public static final String TAG = "TrackingService";
    public static final String TASK_OPER_REMOVE_ACTIVE_LAUNCHED = "removeActiveLaunched";
    public static final String TASK_OPER_REMOVE_ALL = "removeALL";
    public static final String TASK_OPER_REMOVE_ALL_LAUNCHED = "removeAllLaunchedByView";
    public static final String TASK_OPER_STOP = "stop";
    public static final String TASK_OPER_STOP_WITH_ID = "stopWithId";
    private static c f = new c();
    private static b g = new b();
    private static final ISOTaskMatcher h = new b();
    private static final ISOTaskMatcher i = new c();
    private static final ISOTaskMatcher j = new d();
    private static final ISOTaskMatcher k = new e();
    private static final ISOTaskMatcher l = new f();
    private static final ISOTaskMatcher m = new g();
    private final a<i> a = new a<>();
    private boolean b;
    private boolean c;
    private final WeakReference<Activity> d;
    private final ViewTreeObserver.OnPreDrawListener e = new a();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public interface ISOTaskMatcher {
        boolean match(View view, ViewConfigItem viewConfigItem, i iVar, Object... objArr);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface OnSTaskInvokeListener {
        void OnTargetViewAdded(View view, i iVar);

        void OnTargetViewRemoved(View view, i iVar, boolean z);
    }

    /* compiled from: Taobao */
    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        public boolean onPreDraw() {
            try {
                TrackingService.this.l();
            } catch (Throwable unused) {
            }
            return true;
        }
    }

    /* compiled from: Taobao */
    static class b implements ISOTaskMatcher {
        b() {
        }

        @Override // com.alibaba.poplayer.trigger.view.TrackingService.ISOTaskMatcher
        public boolean match(View view, ViewConfigItem viewConfigItem, i iVar, Object... objArr) {
            View view2 = iVar.l;
            return view2 != null && view2 == view;
        }
    }

    /* compiled from: Taobao */
    static class c implements ISOTaskMatcher {
        c() {
        }

        @Override // com.alibaba.poplayer.trigger.view.TrackingService.ISOTaskMatcher
        public boolean match(View view, ViewConfigItem viewConfigItem, i iVar, Object... objArr) {
            if (objArr == null || objArr.length < 2) {
                return false;
            }
            String str = (String) objArr[0];
            String str2 = (String) objArr[1];
            View view2 = iVar.l;
            if (view2 == null || view2 != view || !iVar.a.equals(str) || !iVar.f.equals(str2)) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: Taobao */
    static class d implements ISOTaskMatcher {
        d() {
        }

        @Override // com.alibaba.poplayer.trigger.view.TrackingService.ISOTaskMatcher
        public boolean match(View view, ViewConfigItem viewConfigItem, i iVar, Object... objArr) {
            if (objArr == null || objArr.length == 0) {
                return false;
            }
            String str = (String) objArr[0];
            View view2 = iVar.l;
            if (view2 == null || view2 != view || !iVar.b.equals(str) || iVar.f()) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: Taobao */
    static class e implements ISOTaskMatcher {
        e() {
        }

        @Override // com.alibaba.poplayer.trigger.view.TrackingService.ISOTaskMatcher
        public boolean match(View view, ViewConfigItem viewConfigItem, i iVar, Object... objArr) {
            return viewConfigItem == iVar.j;
        }
    }

    /* compiled from: Taobao */
    static class f implements ISOTaskMatcher {
        f() {
        }

        @Override // com.alibaba.poplayer.trigger.view.TrackingService.ISOTaskMatcher
        public boolean match(View view, ViewConfigItem viewConfigItem, i iVar, Object... objArr) {
            if (objArr == null || objArr.length == 0) {
                return false;
            }
            String str = (String) objArr[0];
            if (view != iVar.l || !str.equals(iVar.i.uri)) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: Taobao */
    static class g implements ISOTaskMatcher {
        g() {
        }

        @Override // com.alibaba.poplayer.trigger.view.TrackingService.ISOTaskMatcher
        public boolean match(View view, ViewConfigItem viewConfigItem, i iVar, Object... objArr) {
            if (objArr == null || objArr.length == 0) {
                return false;
            }
            return iVar.o.equals((String) objArr[0]);
        }
    }

    /* compiled from: Taobao */
    public class h extends i {
        public h(TrackingService trackingService, String str, View view, String str2, String str3, String str4, boolean z, boolean z2, String str5, ViewEvent viewEvent, ViewConfigItem viewConfigItem, OnSTaskInvokeListener onSTaskInvokeListener) {
            super(str, view, str2, str3, str4, z, z2, str5, viewEvent, viewConfigItem, onSTaskInvokeListener);
            this.h = 1;
            SparseArray<WeakReference<View>> sparseArray = new SparseArray<>();
            this.g = sparseArray;
            sparseArray.put(0, new WeakReference<>(view));
            onSTaskInvokeListener.OnTargetViewAdded(view, this);
        }

        /* access modifiers changed from: package-private */
        @Override // com.alibaba.poplayer.trigger.view.TrackingService.i
        public boolean g(boolean z) {
            return z;
        }

        @Override // com.alibaba.poplayer.trigger.view.TrackingService.i
        public boolean h() {
            return true;
        }
    }

    /* compiled from: Taobao */
    public class i {
        public String a;
        public final String b;
        public final String c;
        public final boolean d;
        public boolean e;
        public final String f;
        protected SparseArray<WeakReference<View>> g;
        public int h = 1;
        public final ViewEvent i;
        public final ViewConfigItem j;
        public boolean k;
        public View l;
        public String m;
        public OnSTaskInvokeListener n;
        public final String o = String.valueOf(System.currentTimeMillis());

        public i(String str, View view, String str2, String str3, String str4, boolean z, boolean z2, String str5, ViewEvent viewEvent, ViewConfigItem viewConfigItem, OnSTaskInvokeListener onSTaskInvokeListener) {
            this.m = str;
            this.l = view;
            this.b = str3;
            this.c = str4;
            this.d = z;
            this.e = z2;
            this.f = str5;
            this.i = viewEvent;
            this.j = viewConfigItem;
            this.n = onSTaskInvokeListener;
            this.g = new SparseArray<>();
            e(str2);
        }

        @Nullable
        private View[] c(String str) throws ClassNotFoundException, JSONException {
            int i2;
            View[] l2 = TrackingService.f.l(this.a, this.d);
            if (l2 != null && (i2 = this.h) <= l2.length) {
                return (l2.length <= i2 || i2 == 0) ? l2 : (View[]) Arrays.copyOfRange(l2, 0, i2);
            }
            if (!this.e) {
                cr1.b("STask$Runner.selectAndOperate.selectedViews.withSelector{%s}.fail.abandonSchedule", this.a);
                j(str, false, "Select.NotFound");
                return null;
            }
            cr1.b("STask$Runner.selectAndOperate.selectedViews.withSelector{%s}.fail.scheduleLater", this.a);
            return null;
        }

        private void e(String str) {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("\\?");
                this.a = split[0];
                if (split.length <= 1) {
                    this.h = 1;
                    return;
                }
                try {
                    String[] split2 = split[1].split("=");
                    String str2 = split2[0];
                    String str3 = split2[1];
                    if ("expectedViewSize".equals(str2)) {
                        this.h = Integer.parseInt(str3);
                    }
                } catch (Throwable unused) {
                    this.h = 1;
                }
            }
        }

        @NonNull
        public void a(List<View> list) {
            this.g.clear();
            if (!(list == null || list.size() == 0)) {
                int size = list.size();
                SparseArray<WeakReference<View>> sparseArray = new SparseArray<>();
                for (int i2 = 0; i2 < size; i2++) {
                    sparseArray.put(i2, new WeakReference<>(list.get(i2)));
                }
                this.g = sparseArray;
            }
        }

        public void b() {
            if (!this.k) {
                this.k = true;
                Iterator<View> it = d().iterator();
                while (it.hasNext()) {
                    this.n.OnTargetViewRemoved(it.next(), this, true);
                }
                this.g.clear();
                this.l = null;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.ArrayList<android.view.View> */
        /* JADX WARN: Multi-variable type inference failed */
        @NonNull
        public ArrayList<View> d() {
            SparseArray<WeakReference<View>> sparseArray = this.g;
            if (sparseArray == null || sparseArray.size() == 0) {
                return new ArrayList<>();
            }
            int size = this.g.size();
            ArrayList<View> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < size; i2++) {
                WeakReference<View> weakReference = this.g.get(i2);
                if (weakReference != null) {
                    arrayList.add(eu2.c(weakReference));
                }
            }
            return arrayList;
        }

        /* access modifiers changed from: protected */
        public boolean f() {
            ArrayList<View> d2 = d();
            if (d2.size() != this.h) {
                return false;
            }
            Iterator<View> it = d2.iterator();
            while (it.hasNext()) {
                if (!eu2.g(it.next())) {
                    return false;
                }
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean g(boolean z) {
            if (TrackingService.OPER_MIRROR.equals(this.f) || TrackingService.OPER_TRACK.equals(this.f)) {
                if (z || this.e) {
                    return true;
                }
                return false;
            } else if (TrackingService.OPER_UNMIRROR.equals(this.f) || TrackingService.OPER_UNTRACK.equals(this.f) || !"info".equals(this.f) || z || !this.e) {
                return false;
            } else {
                return true;
            }
        }

        public boolean h() {
            String str = TrackingService.OPER_MIRROR;
            try {
                if (!TrackingService.OPER_TRACK.equals(this.f)) {
                    if (!str.equals(this.f)) {
                        if (!TrackingService.OPER_UNTRACK.equals(this.f)) {
                            if (!TrackingService.OPER_UNMIRROR.equals(this.f)) {
                                if ("info".equals(this.f)) {
                                    View[] c2 = c("PopLayer.SOTask.Info");
                                    if (c2 == null) {
                                        return false;
                                    }
                                    TrackingService.g.b("PopLayer.SOTask.Info", c2, this);
                                }
                                return true;
                            }
                        }
                        if (TrackingService.OPER_UNTRACK.equals(this.f)) {
                            str = TrackingService.OPER_TRACK;
                        }
                        TrackingService.this.m(TrackingService.i, this.l, this.j, new Object[]{this.a, str});
                        cr1.b("STask$Runner.removeTask success by operation:{%s}.", this.f);
                        return true;
                    }
                }
                if (f()) {
                    return true;
                }
                TrackingService.g.c("PopLayer.SOTask.Track", c("PopLayer.SOTask.Track"), this);
                if (this.g.size() == this.h) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                cr1.c("STask.Runner.error", th);
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public void i(String str, String str2) {
            View view = this.l;
            if (view == null || !(view instanceof PopLayerBaseView)) {
                cr1.b("STask$Runner.sendTaskExecutionEventToMasterView.error:masterView is empty or isn't PopLayerBaseView.", new Object[0]);
            } else {
                ((PopLayerBaseView) view).onReceiveEvent(str, str2);
            }
        }

        /* access modifiers changed from: package-private */
        public void j(String str, boolean z, Object obj) throws JSONException {
            if (obj == null) {
                obj = new JSONObject();
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("taskHandle", this.b).put("info", obj).put("succeed", z);
            i(str, jSONObject.toString());
        }
    }

    public TrackingService(Activity activity) {
        this.d = new WeakReference<>(activity);
        this.c = true;
    }

    private void f() {
        Activity h2 = h();
        if (h2 == null) {
            cr1.b("%s.begin error,touch activity is empty.", TAG);
        } else if (!this.b) {
            this.b = true;
            ViewTreeObserver viewTreeObserver = eu2.e(h2).getViewTreeObserver();
            viewTreeObserver.removeOnPreDrawListener(this.e);
            viewTreeObserver.addOnPreDrawListener(this.e);
            cr1.b("%s.begin.", TAG);
        }
    }

    private boolean g() {
        Activity h2 = h();
        if (h2 == null) {
            cr1.b("%s.end error,touch activity is empty.", TAG);
            return false;
        }
        ViewGroup e2 = eu2.e(h2);
        if (e2 == null) {
            return false;
        }
        this.b = false;
        e2.getViewTreeObserver().removeOnPreDrawListener(this.e);
        cr1.b("%s.end,mPendingTasks keep count:{%s}.", TAG, Integer.valueOf(this.a.e()));
        return true;
    }

    private boolean i(String str, String str2, ViewEvent viewEvent, ViewConfigItem viewConfigItem) {
        try {
            for (i iVar : this.a.f().b()) {
                if (!TextUtils.isEmpty(str) && str.contains(iVar.a) && !TextUtils.isEmpty(str2) && str2.equals(iVar.f) && !TextUtils.isEmpty(iVar.i.uri) && iVar.i.uri.equals(viewEvent.uri) && !TextUtils.isEmpty(iVar.j.uuid) && iVar.j.uuid.equals(viewConfigItem.uuid)) {
                    return true;
                }
            }
            this.a.b();
            return false;
        } finally {
            this.a.b();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l() {
        if (this.a.e() != 0) {
            n();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void m(ISOTaskMatcher iSOTaskMatcher, View view, ViewConfigItem viewConfigItem, Object... objArr) {
        try {
            for (i iVar : this.a.f().b()) {
                if (iSOTaskMatcher.match(view, viewConfigItem, iVar, objArr)) {
                    iVar.b();
                    this.a.d(iVar);
                }
            }
        } finally {
            this.a.b();
        }
    }

    private void n() {
        try {
            for (i iVar : this.a.f().b()) {
                if (!iVar.g(iVar.h())) {
                    this.a.d(iVar);
                }
            }
        } finally {
            this.a.b();
        }
    }

    private void p(i iVar, boolean z) {
        cr1.b("scheduleSOTask.immediate{%s}", Boolean.valueOf(z));
        if (!z) {
            this.a.a(iVar);
        } else if (iVar.g(iVar.h())) {
            this.a.a(iVar);
        }
    }

    public Activity h() {
        return (Activity) eu2.c(this.d);
    }

    /* JADX INFO: finally extract failed */
    public void j() {
        this.c = false;
        g();
        try {
            for (i iVar : this.a.f().b()) {
                if (!iVar.j.embed) {
                    iVar.b();
                    this.a.d(iVar);
                }
            }
            this.a.b();
            this.b = false;
            f.b();
        } catch (Throwable th) {
            this.a.b();
            throw th;
        }
    }

    public void k(View view, String str, String str2, ViewConfigItem viewConfigItem, String str3) {
        if ("stop".equals(str2)) {
            m(j, view, viewConfigItem, str);
        } else if (TASK_OPER_REMOVE_ALL_LAUNCHED.equals(str2)) {
            m(h, view, viewConfigItem, new Object[0]);
        } else if (TASK_OPER_REMOVE_ALL.equals(str2)) {
            m(k, view, viewConfigItem, new Object[0]);
        } else if (TASK_OPER_REMOVE_ACTIVE_LAUNCHED.equals(str2)) {
            m(l, view, viewConfigItem, str);
        } else if (TASK_OPER_STOP_WITH_ID.equals(str2)) {
            m(m, view, viewConfigItem, str3);
        }
    }

    public i o(String str, View view, String str2, String str3, String str4, boolean z, boolean z2, String str5, ViewEvent viewEvent, ViewConfigItem viewConfigItem, OnSTaskInvokeListener onSTaskInvokeListener, boolean z3) throws JSONException {
        i iVar;
        if (i(str2, str5, viewEvent, viewConfigItem)) {
            cr1.b("%s.scheduleSTask.but already contains.", TAG);
            return null;
        }
        if (!TextUtils.isEmpty(str2) || view == null) {
            iVar = new i(str, view, str2, str3, str4, z, z2, str5, viewEvent, viewConfigItem, onSTaskInvokeListener);
        } else {
            iVar = new h(this, str, view, str2, str3, str4, z, z2, str5, viewEvent, viewConfigItem, onSTaskInvokeListener);
        }
        p(iVar, z3);
        if (this.c) {
            f();
        }
        return iVar;
    }

    public void q() {
        this.c = true;
        if (this.a.e() > 0) {
            f();
        }
    }
}
