package tb;

import android.content.Context;
import android.view.View;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.view.GXIContainer;
import com.alibaba.gaiax.render.view.GXIRootView;
import com.alibaba.gaiax.template.GXTemplateInfo;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class wq0 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final Context a;
    @NotNull
    private GXTemplateEngine.e b;
    @NotNull
    private final GXTemplateEngine.h c;
    @NotNull
    private final GXTemplateInfo d;
    @Nullable
    private xq0 e;
    private int f;
    private boolean g;
    @Nullable
    private Map<String, GXTemplateEngine.j> h;
    @Nullable
    private Set<wo0> i;
    private boolean j;
    private boolean k;
    @Nullable
    private View l;
    @Nullable
    private up0 m;
    @Nullable
    private GXTemplateEngine.g n;
    private int o;
    @Nullable
    private CopyOnWriteArraySet<GXIContainer> p;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final wq0 a(@NotNull GXTemplateEngine.h hVar, @NotNull GXTemplateEngine.e eVar, @NotNull GXTemplateInfo gXTemplateInfo, @Nullable xq0 xq0) {
            k21.i(hVar, "gxTemplateItem");
            k21.i(eVar, "gxMeasureSize");
            k21.i(gXTemplateInfo, "gxTemplateInfo");
            return new wq0(hVar.c(), eVar, hVar, gXTemplateInfo, xq0, null);
        }

        @Nullable
        public final wq0 b(@Nullable View view) {
            if (view instanceof GXIRootView) {
                return ((GXIRootView) view).getTemplateContext();
            }
            return null;
        }
    }

    private wq0(Context context, GXTemplateEngine.e eVar, GXTemplateEngine.h hVar, GXTemplateInfo gXTemplateInfo, xq0 xq0) {
        this.a = context;
        this.b = eVar;
        this.c = hVar;
        this.d = gXTemplateInfo;
        this.e = xq0;
        this.o = -1;
    }

    public /* synthetic */ wq0(Context context, GXTemplateEngine.e eVar, GXTemplateEngine.h hVar, GXTemplateInfo gXTemplateInfo, xq0 xq0, m40 m40) {
        this(context, eVar, hVar, gXTemplateInfo, xq0);
    }

    public final void A(@Nullable View view) {
        this.l = view;
    }

    public final void B(@NotNull GXTemplateEngine.e eVar) {
        k21.i(eVar, "<set-?>");
        this.b = eVar;
    }

    public final void C(@Nullable GXTemplateEngine.g gVar) {
        this.n = gVar;
    }

    public final int a() {
        return this.f;
    }

    @Nullable
    public final CopyOnWriteArraySet<GXIContainer> b() {
        return this.p;
    }

    @NotNull
    public final Context c() {
        return this.a;
    }

    @Nullable
    public final Set<wo0> d() {
        return this.i;
    }

    public final int e() {
        return this.o;
    }

    @Nullable
    public final Map<String, GXTemplateEngine.j> f() {
        return this.h;
    }

    @Nullable
    public final up0 g() {
        return this.m;
    }

    @Nullable
    public final View h() {
        return this.l;
    }

    @NotNull
    public final GXTemplateEngine.e i() {
        return this.b;
    }

    @Nullable
    public final GXTemplateEngine.g j() {
        return this.n;
    }

    @NotNull
    public final GXTemplateInfo k() {
        return this.d;
    }

    @NotNull
    public final GXTemplateEngine.h l() {
        return this.c;
    }

    @Nullable
    public final xq0 m() {
        return this.e;
    }

    public final void n() {
        if (this.p == null) {
            this.p = new CopyOnWriteArraySet<>();
        }
    }

    public final boolean o() {
        return this.g;
    }

    public final boolean p() {
        return this.j;
    }

    public final boolean q() {
        return this.k;
    }

    public final void r() {
        GXTemplateEngine.GXITrackListener f2;
        Map<String, GXTemplateEngine.j> map = this.h;
        if (map != null) {
            for (Map.Entry<String, GXTemplateEngine.j> entry : map.entrySet()) {
                GXTemplateEngine.g j2 = j();
                if (!(j2 == null || (f2 = j2.f()) == null)) {
                    f2.onManualExposureTrackEvent(entry.getValue());
                }
            }
        }
    }

    public final void s() {
        CopyOnWriteArraySet<GXIContainer> copyOnWriteArraySet = this.p;
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.clear();
        }
        this.j = false;
        Set<wo0> set = this.i;
        if (set != null) {
            set.clear();
        }
        this.i = null;
        this.n = null;
        this.l = null;
        this.e = null;
        up0 up0 = this.m;
        if (up0 != null) {
            up0.J();
        }
        this.m = null;
    }

    public final void t(boolean z) {
        this.g = z;
    }

    @NotNull
    public String toString() {
        return "GXTemplateContext(context=" + this.a + ", isDirty=" + this.j + ", size=" + this.b + ", templateItem='" + this.c + "' rootView=" + this.l + ')';
    }

    public final void u(int i2) {
        this.f = i2;
    }

    public final void v(boolean z) {
        this.j = z;
    }

    public final void w(@Nullable Set<wo0> set) {
        this.i = set;
    }

    public final void x(boolean z) {
        this.k = z;
    }

    public final void y(@Nullable Map<String, GXTemplateEngine.j> map) {
        this.h = map;
    }

    public final void z(@Nullable up0 up0) {
        this.m = up0;
    }
}
