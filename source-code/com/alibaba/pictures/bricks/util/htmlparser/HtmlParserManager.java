package com.alibaba.pictures.bricks.util.htmlparser;

import android.content.Context;
import android.text.Spanned;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bm;
import tb.k21;
import tb.ky0;
import tb.m40;

/* compiled from: Taobao */
public final class HtmlParserManager {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private final int a;
    private final float b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;

    /* compiled from: Taobao */
    public interface OnParseFinishedListener {
        void onParseFinished(@Nullable List<b> list);
    }

    /* compiled from: Taobao */
    public interface OnSpanClickListener {
        void onSpanClick(int i, @NotNull String str);
    }

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final HtmlParserManager a(int i, float f, int i2, int i3, int i4, int i5) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1272859526")) {
                return new HtmlParserManager(i, f, i3, i2, i4, i5, null);
            }
            return (HtmlParserManager) ipChange.ipc$dispatch("-1272859526", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        private static transient /* synthetic */ IpChange $ipChange;
        private int a;
        @Nullable
        private Spanned b;
        private int c;
        private int d;
        private int e;
        private int f;
        @Nullable
        private String g;
        private int h;

        @Nullable
        public final Spanned a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2090223074")) {
                return this.b;
            }
            return (Spanned) ipChange.ipc$dispatch("2090223074", new Object[]{this});
        }

        public final int b() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1554090097")) {
                return this.f;
            }
            return ((Integer) ipChange.ipc$dispatch("-1554090097", new Object[]{this})).intValue();
        }

        public final int c() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1662324876")) {
                return this.e;
            }
            return ((Integer) ipChange.ipc$dispatch("-1662324876", new Object[]{this})).intValue();
        }

        @Nullable
        public final String d() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1336413564")) {
                return this.g;
            }
            return (String) ipChange.ipc$dispatch("1336413564", new Object[]{this});
        }

        public final int e() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "384963160")) {
                return this.h;
            }
            return ((Integer) ipChange.ipc$dispatch("384963160", new Object[]{this})).intValue();
        }

        public final int f() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "73950504")) {
                return this.a;
            }
            return ((Integer) ipChange.ipc$dispatch("73950504", new Object[]{this})).intValue();
        }

        public final void g(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "900466657")) {
                ipChange.ipc$dispatch("900466657", new Object[]{this, Integer.valueOf(i)});
            }
        }

        public final void h(@Nullable Spanned spanned) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1474754460")) {
                ipChange.ipc$dispatch("1474754460", new Object[]{this, spanned});
                return;
            }
            this.b = spanned;
        }

        public final void i(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-12089253")) {
                ipChange.ipc$dispatch("-12089253", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.f = i;
        }

        public final void j(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-932586578")) {
                ipChange.ipc$dispatch("-932586578", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.e = i;
        }

        public final void k(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "433806439")) {
                ipChange.ipc$dispatch("433806439", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.d = i;
        }

        public final void l(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1572217010")) {
                ipChange.ipc$dispatch("1572217010", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.h = i;
        }

        public final void m(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2091051654")) {
                ipChange.ipc$dispatch("-2091051654", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.a = i;
        }

        public final void n(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-918202846")) {
                ipChange.ipc$dispatch("-918202846", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.c = i;
        }

        @NotNull
        public String toString() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1957042599")) {
                return (String) ipChange.ipc$dispatch("1957042599", new Object[]{this});
            }
            String str = ", content:" + ((CharSequence) this.b) + ", width:" + this.c + ", height:" + this.d + ", damaiWidth:" + this.e + ", damaiHeight:" + this.f + "}";
            k21.h(str, "StringBuilder()\n        …  .append(\"}\").toString()");
            return str;
        }
    }

    private HtmlParserManager(int i, float f2, int i2, int i3, int i4, int i5) {
        this.a = i;
        this.b = f2;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
    }

    public /* synthetic */ HtmlParserManager(int i, float f2, int i2, int i3, int i4, int i5, m40 m40) {
        this(i, f2, i2, i3, i4, i5);
    }

    private final void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-315271360")) {
            ipChange.ipc$dispatch("-315271360", new Object[]{this});
            return;
        }
        bm a2 = bm.Companion.a();
        a2.i(this.c);
        a2.h(this.d);
        a2.e(this.e);
        a2.d(this.f);
        a2.g(this.b);
        a2.f(this.a);
    }

    public final void b(@NotNull Context context, @NotNull String str, @NotNull OnSpanClickListener onSpanClickListener, @NotNull OnParseFinishedListener onParseFinishedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "285463531")) {
            ipChange.ipc$dispatch("285463531", new Object[]{this, context, str, onSpanClickListener, onParseFinishedListener});
            return;
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, "content");
        k21.i(onSpanClickListener, "onSpanClickListener");
        k21.i(onParseFinishedListener, "onParseFinishedListener");
        if (!TextUtils.isEmpty(str)) {
            a();
            ky0.Companion.b(str).c(context, onSpanClickListener, onParseFinishedListener);
        }
    }
}
