package com.alibaba.pictures.ut;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.id2;
import tb.k21;
import tb.ot2;
import tb.uq2;

/* compiled from: Taobao */
public final class ClickCat {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    private String b;
    private String c;
    private boolean d;
    private boolean e;
    private View.AccessibilityDelegate f;
    private final Lazy g = b.b(ClickCat$params$2.INSTANCE);
    private final View h;

    /* compiled from: Taobao */
    public static final class a extends View.AccessibilityDelegate {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private ClickCat a;

        public a(@NotNull ClickCat clickCat) {
            k21.i(clickCat, "clickCat");
            this.a = clickCat;
        }

        public final void a() {
            UTHitBuilders.UTControlHitBuilder uTControlHitBuilder;
            Map<String, String> n;
            DogCat dogCat;
            id2 r;
            IpChange ipChange = $ipChange;
            boolean z = false;
            if (AndroidInstantRuntime.support(ipChange, "326109968")) {
                ipChange.ipc$dispatch("326109968", new Object[]{this});
                return;
            }
            String str = this.a.a;
            if (str == null || str.length() == 0) {
                ClickCat clickCat = this.a;
                clickCat.a = DogCat.INSTANCE.j(clickCat.c);
            }
            String str2 = this.a.b;
            if (str2 == null || str2.length() == 0) {
                uTControlHitBuilder = new UTHitBuilders.UTControlHitBuilder(this.a.a);
            } else {
                uTControlHitBuilder = new UTHitBuilders.UTControlHitBuilder(DogCat.INSTANCE.i(str2), this.a.a);
            }
            IClkParamsHandler g = uq2.INSTANCE.g();
            if (g != null) {
                g.onHandle(this.a.l(), this.a.d);
            }
            uTControlHitBuilder.setProperties(this.a.l());
            String str3 = this.a.c;
            String q = !(str3 == null || str3.length() == 0) ? this.a.c : DogCat.INSTANCE.q(this.a.h);
            String str4 = null;
            if (q == null || q.length() == 0) {
                q = DogCat.b(DogCat.INSTANCE, this.a.a, null, 2, null);
            }
            if ((q == null || q.length() == 0) && (r = (dogCat = DogCat.INSTANCE).r()) != null && !r.c()) {
                id2 r2 = dogCat.r();
                if (r2 != null) {
                    str4 = r2.a();
                }
                id2 r3 = dogCat.r();
                if (r3 != null) {
                    r3.d(true);
                }
                q = str4;
            }
            if (q == null || q.length() == 0) {
                z = true;
            }
            if (z) {
                ot2.c("click-emit-cancel: spm is null");
                return;
            }
            DogCat dogCat2 = DogCat.INSTANCE;
            if (!dogCat2.c(q)) {
                ot2.d("click-emit: spm is unLegal : ctrlName=" + this.a.a + ", spm=" + q);
            }
            uTControlHitBuilder.setProperty("spm", q);
            if (this.a.d) {
                HashMap hashMap = new HashMap();
                hashMap.put("spm-url", q);
                hashMap.put("spm", q);
                hashMap.putAll(this.a.l());
                UTAnalytics instance = UTAnalytics.getInstance();
                k21.h(instance, "UTAnalytics.getInstance()");
                instance.getDefaultTracker().updateNextPageProperties(hashMap);
            }
            if (this.a.e && (n = dogCat2.n()) != null) {
                uTControlHitBuilder.setProperties(n);
            }
            ot2.a("click-emit: " + this.a.a);
            UTAnalytics instance2 = UTAnalytics.getInstance();
            k21.h(instance2, "UTAnalytics.getInstance()");
            instance2.getDefaultTracker().send(uTControlHitBuilder.build());
        }

        public void sendAccessibilityEvent(@NotNull View view, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-481948896")) {
                ipChange.ipc$dispatch("-481948896", new Object[]{this, view, Integer.valueOf(i)});
                return;
            }
            k21.i(view, "host");
            super.sendAccessibilityEvent(view, i);
            View.AccessibilityDelegate accessibilityDelegate = this.a.f;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.sendAccessibilityEvent(view, i);
            }
            if (i == 1 || i == 2) {
                a();
            }
        }
    }

    public ClickCat(@Nullable View view) {
        this.h = view;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final Map<String, String> l() {
        Object value;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1311907817")) {
            value = ipChange.ipc$dispatch("1311907817", new Object[]{this});
        } else {
            value = this.g.getValue();
        }
        return (Map) value;
    }

    public final void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1247353219")) {
            ipChange.ipc$dispatch("1247353219", new Object[]{this});
            return;
        }
        a aVar = new a(this);
        View view = this.h;
        if (view == null) {
            aVar.a();
            return;
        }
        if (!view.isClickable()) {
            this.h.setClickable(true);
        }
        this.h.setAccessibilityDelegate(aVar);
    }

    @NotNull
    public final ClickCat k(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1876761198")) {
            return (ClickCat) ipChange.ipc$dispatch("-1876761198", new Object[]{this, str});
        }
        this.a = str;
        return this;
    }

    @NotNull
    public final ClickCat m(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1154692147")) {
            return (ClickCat) ipChange.ipc$dispatch("-1154692147", new Object[]{this, Boolean.valueOf(z)});
        }
        this.d = z;
        return this;
    }

    @NotNull
    public final ClickCat n(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1989062474")) {
            return (ClickCat) ipChange.ipc$dispatch("-1989062474", new Object[]{this, str});
        }
        this.b = str;
        return this;
    }

    @NotNull
    public final ClickCat o(@Nullable Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1806168591")) {
            return (ClickCat) ipChange.ipc$dispatch("1806168591", new Object[]{this, map});
        }
        if (map != null) {
            l().putAll(map);
        }
        return this;
    }

    @NotNull
    public final ClickCat p(@NotNull String... strArr) {
        int i;
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1165367733")) {
            return (ClickCat) ipChange.ipc$dispatch("1165367733", new Object[]{this, strArr});
        }
        k21.i(strArr, "args");
        while (i2 < strArr.length && (i = i2 + 1) < strArr.length) {
            l().put(strArr[i2], strArr[i]);
            i2 += 2;
        }
        return this;
    }

    @NotNull
    public final ClickCat q(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "788857691")) {
            return (ClickCat) ipChange.ipc$dispatch("788857691", new Object[]{this, str, str2, str3});
        }
        if (!(str == null || str.length() == 0)) {
            z = false;
        }
        if (z) {
            return r(str2, str3);
        }
        DogCat dogCat = DogCat.INSTANCE;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('.');
        if (str2 == null) {
            str2 = "default";
        }
        sb.append(str2);
        sb.append('.');
        if (str3 == null) {
            str3 = "0";
        }
        sb.append(str3);
        this.c = DogCat.b(dogCat, sb.toString(), null, 2, null);
        return this;
    }

    @NotNull
    public final ClickCat r(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "104672877")) {
            return (ClickCat) ipChange.ipc$dispatch("104672877", new Object[]{this, str, str2});
        }
        DogCat dogCat = DogCat.INSTANCE;
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "default";
        }
        sb.append(str);
        sb.append('.');
        if (str2 == null) {
            str2 = "0";
        }
        sb.append(str2);
        this.c = DogCat.b(dogCat, sb.toString(), null, 2, null);
        return this;
    }
}
