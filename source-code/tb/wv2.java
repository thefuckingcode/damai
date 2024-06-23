package tb;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.ultron.vfw.adapter.RecyclerViewAdapter;
import com.alibaba.android.ultron.vfw.core.IServiceManager;
import com.alibaba.android.ultron.vfw.event.ComponentLifecycleCallback;
import com.alibaba.android.ultron.vfw.event.OnDynamicEventListener;
import com.alibaba.android.ultron.vfw.template.TemplateDownloadListener;
import com.alibaba.android.ultron.vfw.viewholder.IViewHolderCreator;
import com.alibaba.android.ultron.vfw.viewholder.RecyclerViewHolder;
import com.alibaba.android.ultron.vfw.web.IWebEventBridge;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: Taobao */
public class wv2 implements IServiceManager {
    public static final int ALL = 7;
    public static final int BODY = 2;
    public static final int FOOTER = 4;
    public static final int HEADER = 1;
    public static final String KEY_VIEW_ENGINE = "ViewEngine";
    private Context a;
    private RecyclerViewAdapter b;
    private RecyclerView c;
    private ViewGroup d;
    private ViewGroup e;
    private l20 f;
    private yv2 g;
    private uj2 h;
    private Map<Class<?>, Object> i;
    private List<RecyclerViewHolder> j;
    private List<RecyclerViewHolder> k;
    private IDMComponent l;
    private IDMComponent m;
    private int n;
    private int o;
    private RecyclerViewHolder p;
    private RecyclerViewHolder q;
    private String r;
    private Map<String, Object> s;
    private TemplateDownloadListener t;
    private k80 u;
    private Map<String, IWebEventBridge> v;
    private String w;
    private int x;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                if (findFirstVisibleItemPosition > wv2.this.n) {
                    wv2 wv2 = wv2.this;
                    wv2.K(wv2.p);
                } else {
                    wv2 wv22 = wv2.this;
                    wv22.q(wv22.p);
                }
                if (findFirstVisibleItemPosition > wv2.this.o) {
                    wv2 wv23 = wv2.this;
                    wv23.K(wv23.q);
                    return;
                }
                wv2 wv24 = wv2.this;
                wv24.q(wv24.q);
            }
        }
    }

    public wv2(Context context) {
        this(context, "ultron");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void K(RecyclerViewHolder recyclerViewHolder) {
        View view;
        if (recyclerViewHolder != null && (view = recyclerViewHolder.itemView) != null) {
            view.setVisibility(0);
        }
    }

    private void j() {
        HashMap hashMap = new HashMap();
        for (mc0 mc0 : this.f.b()) {
            String str = mc0.b;
            if (!TextUtils.equals("native", str)) {
                if (hashMap.containsKey(str)) {
                    ((List) hashMap.get(str)).add(mc0);
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(mc0);
                    hashMap.put(str, arrayList);
                }
            }
        }
        if (!hashMap.isEmpty()) {
            for (Map.Entry entry : hashMap.entrySet()) {
                this.h.a((String) entry.getKey(), (List) entry.getValue(), this.t);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void q(RecyclerViewHolder recyclerViewHolder) {
        View view;
        if (recyclerViewHolder != null && (view = recyclerViewHolder.itemView) != null) {
            view.setVisibility(8);
        }
    }

    private void s() {
        this.b.setData(this.f.a());
        this.b.notifyDataSetChanged();
    }

    private void t() {
        ViewGroup viewGroup = this.e;
        if (viewGroup != null) {
            if (viewGroup.getChildCount() > 0) {
                this.e.removeAllViews();
            }
            if (this.k.size() > 0) {
                this.k.clear();
            }
            List<IDMComponent> c2 = this.f.c();
            if (c2 != null && c2.size() > 0) {
                for (IDMComponent iDMComponent : c2) {
                    RecyclerViewHolder c3 = this.g.c(this.e, this.g.f(iDMComponent));
                    View view = c3.itemView;
                    if (view != null) {
                        this.e.addView(view);
                        this.k.add(c3);
                    }
                    this.g.b(c3, iDMComponent);
                    if (iDMComponent == this.m) {
                        this.q = c3;
                        q(c3);
                    }
                }
            }
        }
    }

    private void u() {
        ViewGroup viewGroup = this.d;
        if (viewGroup != null) {
            if (viewGroup.getChildCount() > 0) {
                this.d.removeAllViews();
            }
            if (this.j.size() > 0) {
                this.j.clear();
            }
            List<IDMComponent> d2 = this.f.d();
            if (!(d2 == null || d2.isEmpty())) {
                for (IDMComponent iDMComponent : d2) {
                    RecyclerViewHolder c2 = this.g.c(this.d, this.g.f(iDMComponent));
                    View view = c2.itemView;
                    if (view != null) {
                        this.d.addView(view);
                        this.j.add(c2);
                    }
                    this.g.b(c2, iDMComponent);
                    if (iDMComponent == this.l) {
                        this.p = c2;
                        q(c2);
                    }
                }
            }
        }
    }

    private void w() {
        this.b.notifyDataSetChanged();
    }

    private void x() {
        List<IDMComponent> c2 = this.f.c();
        for (int i2 = 0; i2 < c2.size(); i2++) {
            this.g.b(this.k.get(i2), c2.get(i2));
        }
    }

    private void y() {
        List<IDMComponent> d2 = this.f.d();
        for (int i2 = 0; i2 < d2.size(); i2++) {
            this.g.b(this.j.get(i2), d2.get(i2));
        }
    }

    public void A(String str, IViewHolderCreator iViewHolderCreator) {
        this.g.i(str, iViewHolderCreator);
    }

    public void B(String str, IWebEventBridge iWebEventBridge) {
        if (this.v == null) {
            this.v = new HashMap();
        }
        this.v.put(str, iWebEventBridge);
    }

    public void C(int i2) {
        this.c.getLayoutManager().scrollToPosition(i2);
    }

    public void D(RecyclerViewAdapter recyclerViewAdapter) {
        RecyclerView recyclerView = this.c;
        Objects.requireNonNull(recyclerView, "The bindViewTree method must be called before setAdapter method.");
        this.b = recyclerViewAdapter;
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    public void E(String str) {
        this.w = str;
    }

    public void F(ComponentLifecycleCallback componentLifecycleCallback) {
        this.g.k(componentLifecycleCallback);
    }

    public void G(l20 l20) {
        this.f = l20;
    }

    public void H(int i2, IDMComponent iDMComponent) {
        this.o = i2;
        this.m = iDMComponent;
    }

    public void I(int i2, IDMComponent iDMComponent) {
        this.n = i2;
        this.l = iDMComponent;
    }

    public void J(int i2) {
        this.x = i2;
    }

    public void g(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            this.s.put(str, obj);
        }
    }

    @Override // com.alibaba.android.ultron.vfw.core.IServiceManager
    public <T> T getService(@NonNull Class<T> cls) {
        Object obj = this.i.get(cls);
        if (obj != null) {
            return cls.cast(obj);
        }
        return null;
    }

    public void h(LinearLayout linearLayout, @NonNull RecyclerView recyclerView, LinearLayout linearLayout2) {
        this.d = linearLayout;
        this.c = recyclerView;
        recyclerView.addOnScrollListener(new a());
        this.e = linearLayout2;
    }

    public void i() {
        yv2 yv2 = this.g;
        if (yv2 != null) {
            yv2.d();
        }
    }

    public String k() {
        return this.w;
    }

    public Context l() {
        return this.a;
    }

    public Map<String, Object> m() {
        return this.s;
    }

    public k80 n() {
        return this.u;
    }

    public int o() {
        return this.x;
    }

    public String p() {
        return this.r;
    }

    public void r(int i2) {
        am2.c(am2.KEY_ULTRON_PROFILE, "viewengine rebuild start");
        am2.e("ViewEngine.rebuild", "viewengine rebuild start");
        j();
        am2.c("ViewEngine.rebuild", "download template");
        if ((i2 & 1) != 0) {
            u();
        }
        am2.c("ViewEngine.rebuild", "rebuildHeader");
        if ((i2 & 2) != 0) {
            s();
        }
        am2.c("ViewEngine.rebuild", "rebuildBody");
        if ((i2 & 4) != 0) {
            t();
        }
        am2.a("ViewEngine.rebuild", "rebuildFooter");
        am2.c(am2.KEY_ULTRON_PROFILE, "viewengine rebuild end");
    }

    @Override // com.alibaba.android.ultron.vfw.core.IServiceManager
    public <T> void registerService(@NonNull Class<T> cls, @NonNull T t2) {
        this.i.put(cls, t2);
    }

    public void v(int i2) {
        if ((i2 & 1) != 0) {
            y();
        }
        if ((i2 & 2) != 0) {
            w();
        }
        if ((i2 & 4) != 0) {
            x();
        }
    }

    public void z(OnDynamicEventListener onDynamicEventListener) {
        registerService(OnDynamicEventListener.class, onDynamicEventListener);
    }

    public wv2(Context context, String str) {
        this.i = new HashMap();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.n = -1;
        this.o = -1;
        this.r = "ultron";
        this.w = "default";
        this.a = context;
        this.r = str;
        this.u = k80.c(this);
        yv2 yv2 = new yv2(this);
        this.g = yv2;
        registerService(yv2.class, yv2);
        uj2 uj2 = new uj2(this);
        this.h = uj2;
        registerService(uj2.class, uj2);
        HashMap hashMap = new HashMap();
        this.s = hashMap;
        hashMap.put(KEY_VIEW_ENGINE, this);
        this.f = new l20();
    }
}
