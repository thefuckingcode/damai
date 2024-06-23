package com.alibaba.gaiax;

import android.content.Context;
import android.content.res.AssetManager;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.data.GXDataImpl;
import com.alibaba.gaiax.data.cache.GXTemplateInfoSource;
import com.alibaba.gaiax.render.utils.GXContainerUtils;
import com.alibaba.gaiax.render.utils.GXIManualExposureEventListener;
import com.alibaba.gaiax.render.view.GXIContainer;
import com.alibaba.gaiax.render.view.GXIViewBindData;
import com.alibaba.gaiax.render.view.GXIViewVisibleChange;
import com.alibaba.gaiax.template.GXStyleConvert;
import com.uc.webview.export.extension.UCCore;
import com.youku.gaiax.api.data.EventParams;
import io.flutter.wpkbridge.WPKFactory;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ap0;
import tb.aq0;
import tb.gq0;
import tb.if1;
import tb.k21;
import tb.m40;
import tb.no0;
import tb.ob2;
import tb.up0;
import tb.wq0;
import tb.xq0;
import tb.yn0;
import tb.yp0;
import tb.zn0;

/* compiled from: Taobao */
public final class GXTemplateEngine {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final Lazy<GXTemplateEngine> d = kotlin.b.b(GXTemplateEngine$Companion$instance$2.INSTANCE);
    public Context a;
    @NotNull
    private final Lazy b = kotlin.b.b(new GXTemplateEngine$data$2(this));
    @NotNull
    private final Lazy c = kotlin.b.b(GXTemplateEngine$render$2.INSTANCE);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/GXTemplateEngine$GXIAdapter;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Ltb/ur2;", UCCore.LEGACY_EVENT_INIT, "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXIAdapter {
        void init(@NotNull Context context);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/alibaba/gaiax/GXTemplateEngine$GXICustomViewBindData;", "Lcom/alibaba/gaiax/render/view/GXIViewBindData;", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXICustomViewBindData extends GXIViewBindData {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/GXTemplateEngine$GXIDataListener;", "", "Lcom/alibaba/gaiax/GXTemplateEngine$i;", "gxTextData", "", "onTextProcess", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXIDataListener {
        @Nullable
        CharSequence onTextProcess(@NotNull i iVar);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\f"}, d2 = {"Lcom/alibaba/gaiax/GXTemplateEngine$GXIEventListener;", "", "Lcom/alibaba/gaiax/GXTemplateEngine$d;", "gxGesture", "Ltb/ur2;", "onGestureEvent", "Lcom/alibaba/gaiax/GXTemplateEngine$f;", "gxScroll", "onScrollEvent", "Lcom/alibaba/gaiax/GXTemplateEngine$b;", "gxAnimation", "onAnimationEvent", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXIEventListener {

        /* compiled from: Taobao */
        public static final class a {
            public static void a(@NotNull GXIEventListener gXIEventListener, @NotNull b bVar) {
                k21.i(gXIEventListener, "this");
                k21.i(bVar, "gxAnimation");
            }

            public static void b(@NotNull GXIEventListener gXIEventListener, @NotNull d dVar) {
                k21.i(gXIEventListener, "this");
                k21.i(dVar, "gxGesture");
            }

            public static void c(@NotNull GXIEventListener gXIEventListener, @NotNull f fVar) {
                k21.i(gXIEventListener, "this");
                k21.i(fVar, "gxScroll");
            }
        }

        void onAnimationEvent(@NotNull b bVar);

        void onGestureEvent(@NotNull d dVar);

        void onScrollEvent(@NotNull f fVar);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/alibaba/gaiax/GXTemplateEngine$GXITrackListener;", "", "Lcom/alibaba/gaiax/GXTemplateEngine$j;", "gxTrack", "Ltb/ur2;", "onTrackEvent", "onManualClickTrackEvent", "onManualExposureTrackEvent", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXITrackListener {

        /* compiled from: Taobao */
        public static final class a {
            public static void a(@NotNull GXITrackListener gXITrackListener, @NotNull j jVar) {
                k21.i(gXITrackListener, "this");
                k21.i(jVar, "gxTrack");
            }

            public static void b(@NotNull GXITrackListener gXITrackListener, @NotNull j jVar) {
                k21.i(gXITrackListener, "this");
                k21.i(jVar, "gxTrack");
            }

            public static void c(@NotNull GXITrackListener gXITrackListener, @NotNull j jVar) {
                k21.i(gXITrackListener, "this");
                k21.i(jVar, "gxTrack");
            }
        }

        void onManualClickTrackEvent(@NotNull j jVar);

        void onManualExposureTrackEvent(@NotNull j jVar);

        void onTrackEvent(@NotNull j jVar);
    }

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final GXTemplateEngine a() {
            return (GXTemplateEngine) GXTemplateEngine.d.getValue();
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        @NotNull
        public static final a Companion = new a(null);
        @NotNull
        public static final String STATE_END = "END";
        @NotNull
        public static final String STATE_START = "START";
        @Nullable
        private String a;
        @Nullable
        private String b;
        @Nullable
        private View c;
        @Nullable
        private JSONObject d;

        /* compiled from: Taobao */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(m40 m40) {
                this();
            }
        }

        @Nullable
        public final JSONObject a() {
            return this.d;
        }

        @Nullable
        public final String b() {
            return this.b;
        }

        @Nullable
        public final String c() {
            return this.a;
        }

        @Nullable
        public final View d() {
            return this.c;
        }

        public final void e(@Nullable JSONObject jSONObject) {
            this.d = jSONObject;
        }

        public final void f(@Nullable String str) {
            this.b = str;
        }

        public final void g(@Nullable String str) {
            this.a = str;
        }

        public final void h(@Nullable View view) {
            this.c = view;
        }

        @NotNull
        public String toString() {
            return "GXAnimation(type=" + ((Object) this.a) + ", nodeId=" + ((Object) this.b) + ", targetView=" + this.c + ')';
        }
    }

    /* compiled from: Taobao */
    public static abstract class c {
        @Nullable
        private Integer a;
        @Nullable
        private View b;
        @Nullable
        private String c;

        @Nullable
        public final Integer a() {
            return this.a;
        }

        @Nullable
        public final String b() {
            return this.c;
        }

        @Nullable
        public final View c() {
            return this.b;
        }

        public final void d(@Nullable Integer num) {
            this.a = num;
        }

        public final void e(@Nullable String str) {
            this.c = str;
        }

        public final void f(@Nullable h hVar) {
        }

        public final void g(@Nullable View view) {
            this.b = view;
        }
    }

    /* compiled from: Taobao */
    public static class d {
        @Nullable
        private JSONObject eventParams;
        @NotNull
        private String gestureType = EventParams.CLICK_TYPE_TAP;
        @Nullable
        private Integer index;
        @Nullable
        private String nodeId;
        @Nullable
        private h templateItem;
        @Nullable
        private View view;

        @Nullable
        public final JSONObject getEventParams() {
            return this.eventParams;
        }

        @NotNull
        public final String getGestureType() {
            return this.gestureType;
        }

        @Nullable
        public final Integer getIndex() {
            return this.index;
        }

        @Nullable
        public final String getNodeId() {
            return this.nodeId;
        }

        @Nullable
        public final h getTemplateItem() {
            return this.templateItem;
        }

        @Nullable
        public final View getView() {
            return this.view;
        }

        public final void setEventParams(@Nullable JSONObject jSONObject) {
            this.eventParams = jSONObject;
        }

        public final void setGestureType(@NotNull String str) {
            k21.i(str, "<set-?>");
            this.gestureType = str;
        }

        public final void setIndex(@Nullable Integer num) {
            this.index = num;
        }

        public final void setNodeId(@Nullable String str) {
            this.nodeId = str;
        }

        public final void setTemplateItem(@Nullable h hVar) {
            this.templateItem = hVar;
        }

        public final void setView(@Nullable View view2) {
            this.view = view2;
        }

        @NotNull
        public String toString() {
            return "GXGesture(gestureType='" + this.gestureType + "', view=" + this.view + ", nodeId=" + ((Object) this.nodeId) + ", index=" + this.index + ", eventParams=" + this.eventParams + ')';
        }
    }

    /* compiled from: Taobao */
    public static final class e {
        @Nullable
        private Float a;
        @Nullable
        private Float b;

        public e(@Nullable Float f, @Nullable Float f2) {
            this.a = f;
            this.b = f2;
        }

        @Nullable
        public final Float a() {
            return this.b;
        }

        @Nullable
        public final Float b() {
            return this.a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return k21.d(this.a, eVar.a) && k21.d(this.b, eVar.b);
        }

        public int hashCode() {
            Float f = this.a;
            int i = 0;
            int hashCode = (f == null ? 0 : f.hashCode()) * 31;
            Float f2 = this.b;
            if (f2 != null) {
                i = f2.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            return "GXMeasureSize(width=" + this.a + ", height=" + this.b + ')';
        }
    }

    /* compiled from: Taobao */
    public static final class f {
        @NotNull
        public static final a Companion = new a(null);
        @NotNull
        public static final String TYPE_ON_SCROLLED = "onScrolled";
        @NotNull
        public static final String TYPE_ON_SCROLL_STATE_CHANGED = "onScrollStateChanged";
        @NotNull
        private String a = "";
        @Nullable
        private View b;
        private int c;
        private int d;
        private int e;

        /* compiled from: Taobao */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(m40 m40) {
                this();
            }
        }

        public final int a() {
            return this.c;
        }

        public final int b() {
            return this.d;
        }

        public final int c() {
            return this.e;
        }

        @NotNull
        public final String d() {
            return this.a;
        }

        @Nullable
        public final View e() {
            return this.b;
        }

        public final void f(int i) {
            this.c = i;
        }

        public final void g(int i) {
            this.d = i;
        }

        public final void h(int i) {
            this.e = i;
        }

        public final void i(@NotNull String str) {
            k21.i(str, "<set-?>");
            this.a = str;
        }

        public final void j(@Nullable View view) {
            this.b = view;
        }

        @NotNull
        public String toString() {
            return "GXScroll(view=" + this.b + ", dx=" + this.c + ", dy=" + this.d + ", state=" + this.e + ')';
        }
    }

    /* compiled from: Taobao */
    public static final class g {
        @NotNull
        private final JSONObject a;
        @Nullable
        private Object b;
        private int c = -1;
        @Nullable
        private GXIDataListener d;
        @Nullable
        private GXIEventListener e;
        @Nullable
        private GXITrackListener f;

        public g(@NotNull JSONObject jSONObject) {
            k21.i(jSONObject, "data");
            this.a = jSONObject;
        }

        @NotNull
        public final JSONObject a() {
            return this.a;
        }

        @Nullable
        public final GXIDataListener b() {
            return this.d;
        }

        @Nullable
        public final GXIEventListener c() {
            return this.e;
        }

        public final int d() {
            return this.c;
        }

        @Nullable
        public final Object e() {
            return this.b;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof g) && k21.d(this.a, ((g) obj).a);
        }

        @Nullable
        public final GXITrackListener f() {
            return this.f;
        }

        public final void g(@Nullable GXIDataListener gXIDataListener) {
            this.d = gXIDataListener;
        }

        public final void h(@Nullable GXIEventListener gXIEventListener) {
            this.e = gXIEventListener;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public final void i(int i) {
            this.c = i;
        }

        public final void j(@Nullable Object obj) {
            this.b = obj;
        }

        public final void k(@Nullable GXITrackListener gXITrackListener) {
            this.f = gXITrackListener;
        }

        @NotNull
        public String toString() {
            return "GXTemplateData(data=" + this.a + ')';
        }
    }

    /* compiled from: Taobao */
    public static final class h {
        @NotNull
        private final Context a;
        @NotNull
        private String b;
        @NotNull
        private final String c;
        @NotNull
        private String d = "";
        @NotNull
        private String e = "";
        private boolean f;

        public h(@NotNull Context context, @NotNull String str, @NotNull String str2) {
            k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
            k21.i(str, if1.DIMEN_BIZ);
            k21.i(str2, "templateId");
            this.a = context;
            this.b = str;
            this.c = str2;
        }

        @NotNull
        public final String a() {
            return this.b;
        }

        @NotNull
        public final String b() {
            return this.d;
        }

        @NotNull
        public final Context c() {
            return this.a;
        }

        @NotNull
        public final String d() {
            return this.c;
        }

        @NotNull
        public final String e() {
            return this.e;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return k21.d(this.a, hVar.a) && k21.d(this.b, hVar.b) && k21.d(this.c, hVar.c);
        }

        public final boolean f() {
            return this.f;
        }

        public final void g(boolean z) {
            this.f = z;
        }

        public final void h(@NotNull String str) {
            k21.i(str, "<set-?>");
            this.e = str;
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        @NotNull
        public String toString() {
            return "GXTemplateItem(context=" + this.a + ", bizId='" + this.b + "', templateId='" + this.c + "', templateVersion='" + this.e + '\'';
        }
    }

    /* compiled from: Taobao */
    public static final class i extends c {
        @Nullable
        private CharSequence d;
        @Nullable
        private JSONObject e;

        @Nullable
        public final JSONObject h() {
            return this.e;
        }

        @Nullable
        public final CharSequence i() {
            return this.d;
        }

        public final void j(@Nullable JSONObject jSONObject) {
            this.e = jSONObject;
        }

        public final void k(@Nullable no0 no0) {
        }

        public final void l(@Nullable JSONObject jSONObject) {
        }

        public final void m(@Nullable CharSequence charSequence) {
            this.d = charSequence;
        }
    }

    /* compiled from: Taobao */
    public static final class j {
        @Nullable
        private View a;
        @Nullable
        private String b;
        @Nullable
        private Integer c;
        @Nullable
        private JSONObject d;

        @Nullable
        public final Integer a() {
            return this.c;
        }

        @Nullable
        public final String b() {
            return this.b;
        }

        @Nullable
        public final JSONObject c() {
            return this.d;
        }

        @Nullable
        public final View d() {
            return this.a;
        }

        public final void e(@Nullable Integer num) {
            this.c = num;
        }

        public final void f(@Nullable String str) {
            this.b = str;
        }

        public final void g(@Nullable h hVar) {
        }

        public final void h(@Nullable JSONObject jSONObject) {
            this.d = jSONObject;
        }

        public final void i(@Nullable View view) {
            this.a = view;
        }

        @NotNull
        public String toString() {
            return "GXTrack(view=" + this.a + ", nodeId=" + ((Object) this.b) + ", index=" + this.c + ", trackParams=" + this.d + ')';
        }
    }

    /* compiled from: Taobao */
    public static final class k implements GXIManualExposureEventListener {
        final /* synthetic */ GXIEventListener a;
        final /* synthetic */ wq0 b;

        k(GXIEventListener gXIEventListener, wq0 wq0) {
            this.a = gXIEventListener;
            this.b = wq0;
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXIEventListener
        public void onAnimationEvent(@NotNull b bVar) {
            k21.i(bVar, "gxAnimation");
            GXIEventListener gXIEventListener = this.a;
            if (gXIEventListener != null) {
                gXIEventListener.onAnimationEvent(bVar);
            }
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXIEventListener
        public void onGestureEvent(@NotNull d dVar) {
            k21.i(dVar, "gxGesture");
            GXIEventListener gXIEventListener = this.a;
            if (gXIEventListener != null) {
                gXIEventListener.onGestureEvent(dVar);
            }
        }

        @Override // com.alibaba.gaiax.GXTemplateEngine.GXIEventListener
        public void onScrollEvent(@NotNull f fVar) {
            k21.i(fVar, "gxScroll");
            GXIEventListener gXIEventListener = this.a;
            if (gXIEventListener != null) {
                gXIEventListener.onScrollEvent(fVar);
            }
            if (this.b.o() && k21.d(f.TYPE_ON_SCROLL_STATE_CHANGED, fVar.d()) && fVar.c() == 0) {
                GXContainerUtils.INSTANCE.d(this.b);
            }
        }
    }

    public static /* synthetic */ void c(GXTemplateEngine gXTemplateEngine, View view, g gVar, e eVar, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            eVar = null;
        }
        gXTemplateEngine.b(view, gVar, eVar);
    }

    public static /* synthetic */ View h(GXTemplateEngine gXTemplateEngine, h hVar, e eVar, xq0 xq0, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            xq0 = null;
        }
        return gXTemplateEngine.g(hVar, eVar, xq0);
    }

    private final GXIAdapter r() {
        try {
            Object newInstance = Class.forName("com.alibaba.gaiax.adapter.GXAdapter").newInstance();
            if (newInstance != null) {
                return (GXIAdapter) newInstance;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.alibaba.gaiax.GXTemplateEngine.GXIAdapter");
        } catch (Exception unused) {
            return null;
        }
    }

    private final void s(View view, g gVar, e eVar) {
        wq0 b2 = wq0.Companion.b(view);
        if (b2 != null) {
            boolean z = false;
            if (eVar != null) {
                e i2 = b2.i();
                b2.B(eVar);
                if (!k21.c(i2.b(), eVar.b()) || !k21.c(i2.a(), eVar.a())) {
                    z = true;
                }
            }
            b2.C(gVar);
            y(b2);
            z(b2, z);
            p().b(b2);
            return;
        }
        throw new IllegalArgumentException("Not found templateContext from targetView");
    }

    private final void t(View view, g gVar, e eVar) {
        wq0 b2 = wq0.Companion.b(view);
        if (b2 != null) {
            if (eVar != null) {
                b2.B(eVar);
            }
            b2.C(gVar);
            p().c(b2);
            return;
        }
        throw new IllegalArgumentException("Not found templateContext from targetView");
    }

    private final wq0 u(h hVar, e eVar, xq0 xq0) {
        wq0 a2 = wq0.Companion.a(hVar, eVar, l().b(hVar), xq0);
        p().e(a2);
        return a2;
    }

    private final View v(wq0 wq0) {
        return p().f(wq0);
    }

    private final void y(wq0 wq0) {
        g j2;
        g j3 = wq0.j();
        GXIEventListener c2 = j3 == null ? null : j3.c();
        CopyOnWriteArraySet<GXIContainer> b2 = wq0.b();
        boolean z = false;
        if (b2 != null && (!b2.isEmpty())) {
            z = true;
        }
        if (z && !(c2 instanceof GXIManualExposureEventListener) && (j2 = wq0.j()) != null) {
            j2.h(new k(c2, wq0));
        }
    }

    private final void z(wq0 wq0, boolean z) {
        up0 g2 = wq0.g();
        if (g2 != null && z) {
            g2.K(wq0);
            aq0.INSTANCE.k(g2, new ob2<>(wq0.i().b(), wq0.i().a()));
        }
    }

    public final void A(@NotNull Context context) {
        k21.i(context, "<set-?>");
        this.a = context;
    }

    public final void b(@Nullable View view, @NotNull g gVar, @Nullable e eVar) {
        k21.i(gVar, "gxTemplateData");
        if (view != null) {
            try {
                d(view, gVar, eVar);
                e(view, gVar, eVar);
            } catch (Exception e2) {
                GXRegisterCenter.GXIExtensionException i2 = GXRegisterCenter.Companion.a().i();
                if (i2 != null) {
                    i2.exception(e2);
                    return;
                }
                throw e2;
            }
        } else {
            throw new IllegalArgumentException("view is null");
        }
    }

    public final void d(@NotNull View view, @NotNull g gVar, @Nullable e eVar) {
        k21.i(view, "view");
        k21.i(gVar, "gxTemplateData");
        try {
            s(view, gVar, eVar);
        } catch (Exception e2) {
            GXRegisterCenter.GXIExtensionException i2 = GXRegisterCenter.Companion.a().i();
            if (i2 != null) {
                i2.exception(e2);
                return;
            }
            throw e2;
        }
    }

    public final void e(@NotNull View view, @NotNull g gVar, @Nullable e eVar) {
        k21.i(view, "view");
        k21.i(gVar, "gxTemplateData");
        try {
            t(view, gVar, eVar);
        } catch (Exception e2) {
            GXRegisterCenter.GXIExtensionException i2 = GXRegisterCenter.Companion.a().i();
            if (i2 != null) {
                i2.exception(e2);
                return;
            }
            throw e2;
        }
    }

    @NotNull
    public final wq0 f(@NotNull h hVar, @NotNull e eVar, @Nullable xq0 xq0) {
        k21.i(hVar, "gxTemplateItem");
        k21.i(eVar, "gxMeasureSize");
        return wq0.Companion.a(hVar, eVar, l().b(hVar), xq0);
    }

    @Nullable
    public final View g(@NotNull h hVar, @NotNull e eVar, @Nullable xq0 xq0) {
        k21.i(hVar, "gxTemplateItem");
        k21.i(eVar, "gxMeasureSize");
        try {
            wq0 i2 = i(hVar, eVar, xq0);
            if (i2 != null) {
                return j(i2);
            }
            return null;
        } catch (Exception e2) {
            GXRegisterCenter.GXIExtensionException i3 = GXRegisterCenter.Companion.a().i();
            if (i3 != null) {
                i3.exception(e2);
                return null;
            }
            throw e2;
        }
    }

    @Nullable
    public final wq0 i(@NotNull h hVar, @NotNull e eVar, @Nullable xq0 xq0) {
        k21.i(hVar, "gxTemplateItem");
        k21.i(eVar, "gxMeasureSize");
        try {
            return u(hVar, eVar, xq0);
        } catch (Exception e2) {
            GXRegisterCenter.GXIExtensionException i2 = GXRegisterCenter.Companion.a().i();
            if (i2 != null) {
                i2.exception(e2);
                return null;
            }
            throw e2;
        }
    }

    @Nullable
    public final View j(@NotNull wq0 wq0) {
        k21.i(wq0, "gxTemplateContext");
        try {
            return v(wq0);
        } catch (Exception e2) {
            GXRegisterCenter.GXIExtensionException i2 = GXRegisterCenter.Companion.a().i();
            if (i2 != null) {
                i2.exception(e2);
                return null;
            }
            throw e2;
        }
    }

    @NotNull
    public final Context k() {
        Context context = this.a;
        if (context != null) {
            return context;
        }
        k21.A(WPKFactory.INIT_KEY_CONTEXT);
        return null;
    }

    @NotNull
    public final GXDataImpl l() {
        return (GXDataImpl) this.b.getValue();
    }

    @Nullable
    public final up0 m(@Nullable View view, @NotNull String str) {
        up0 g2;
        k21.i(str, "id");
        wq0 b2 = wq0.Companion.b(view);
        if (b2 == null || (g2 = b2.g()) == null) {
            return null;
        }
        return yp0.c(g2, str);
    }

    @Nullable
    public final wq0 n(@Nullable View view) {
        if (view == null) {
            return null;
        }
        return wq0.Companion.b(view);
    }

    @Nullable
    public final View o(@Nullable View view, @NotNull String str) {
        up0 g2;
        k21.i(str, "id");
        wq0 b2 = wq0.Companion.b(view);
        if (b2 == null || (g2 = b2.g()) == null) {
            return null;
        }
        return yp0.d(g2, str);
    }

    @NotNull
    public final gq0 p() {
        return (gq0) this.c.getValue();
    }

    @NotNull
    public final GXTemplateEngine q(@NotNull Context context) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        Context applicationContext = context.getApplicationContext();
        k21.h(applicationContext, "context.applicationContext");
        A(applicationContext);
        GXStyleConvert a2 = GXStyleConvert.Companion.a();
        AssetManager assets = context.getAssets();
        k21.h(assets, "context.assets");
        a2.z(assets);
        GXRegisterCenter.Companion.a().x(new ap0()).E(GXTemplateInfoSource.Companion.a(), 0).F(new yn0(k()), 0).F(new zn0(k()), 1);
        GXIAdapter r = r();
        if (r != null) {
            r.init(context);
        }
        return this;
    }

    public final void w(@NotNull View view) {
        k21.i(view, "targetView");
        if (view instanceof GXIViewVisibleChange) {
            ((GXIViewVisibleChange) view).onVisibleChanged(true);
        }
        wq0 b2 = wq0.Companion.b(view);
        if (b2 != null) {
            b2.t(true);
            b2.r();
            GXContainerUtils.INSTANCE.d(b2);
        }
    }

    public final void x(@NotNull View view) {
        k21.i(view, "targetView");
        if (view instanceof GXIViewVisibleChange) {
            ((GXIViewVisibleChange) view).onVisibleChanged(false);
        }
        wq0 b2 = wq0.Companion.b(view);
        if (b2 != null) {
            b2.t(false);
            GXContainerUtils.INSTANCE.e(b2);
        }
    }
}
