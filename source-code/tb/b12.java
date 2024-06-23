package tb;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.pictures.responsive.R$styleable;
import com.alibaba.pictures.responsive.size.OnResponsiveListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class b12 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final View a;
    private int b;
    private final int c = 6;
    private final int d = 15;
    @Nullable
    private String e;
    private int f;
    private int g;
    @Nullable
    private OnResponsiveListener h;
    @Nullable
    private a12 i;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public b12(@NotNull View view) {
        k21.i(view, "view");
        this.a = view;
    }

    private final void a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1825118825")) {
            ipChange.ipc$dispatch("-1825118825", new Object[]{this, context});
            return;
        }
        if (this.f == 0) {
            this.f = g12.a(context, (float) this.c);
        }
        if (this.g == 0) {
            this.g = g12.a(context, (float) this.d);
        }
    }

    public final int b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "811662680")) {
            return this.f;
        }
        return ((Integer) ipChange.ipc$dispatch("811662680", new Object[]{this})).intValue();
    }

    public final int c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2048069256")) {
            return this.g;
        }
        return ((Integer) ipChange.ipc$dispatch("-2048069256", new Object[]{this})).intValue();
    }

    public final void d(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-379498426")) {
            ipChange.ipc$dispatch("-379498426", new Object[]{this, context, attributeSet});
            return;
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.OneResponsiveLayout, 0, 0);
            k21.h(obtainStyledAttributes, "context.theme.obtainStyl…neResponsiveLayout, 0, 0)");
            this.b = obtainStyledAttributes.getInt(R$styleable.OneResponsiveLayout_rc, 0);
            obtainStyledAttributes.recycle();
        }
        a(context);
    }

    @NotNull
    public final a12 e(int i2, int i3) {
        OnResponsiveListener onResponsiveListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "788773690")) {
            return (a12) ipChange.ipc$dispatch("788773690", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        if (this.i == null) {
            this.i = new a12();
        }
        a12 a12 = this.i;
        if (a12 != null) {
            int b2 = a12.b();
            int d2 = a12.d();
            a12 a122 = this.i;
            if (a122 != null) {
                a122.a();
            }
            a12 a2 = w21.INSTANCE.a(g12.c(this.a), this.b, View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3), c(), b(), this.e, this.i);
            if (!((d2 == a2.d() && b2 == a2.b()) || (onResponsiveListener = this.h) == null)) {
                onResponsiveListener.onResponsive(a2);
            }
            ur2 ur2 = ur2.INSTANCE;
            this.i = a2;
        }
        a12 a123 = this.i;
        k21.f(a123);
        return a123;
    }

    public final void f(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-696810678")) {
            ipChange.ipc$dispatch("-696810678", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.f = i2;
    }

    public final void g(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-340602335")) {
            ipChange.ipc$dispatch("-340602335", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.b = i2;
    }

    public final void h(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1708523562")) {
            ipChange.ipc$dispatch("1708523562", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.g = i2;
    }

    public final void i(@Nullable OnResponsiveListener onResponsiveListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1599397842")) {
            ipChange.ipc$dispatch("-1599397842", new Object[]{this, onResponsiveListener});
            return;
        }
        this.h = onResponsiveListener;
    }

    public final void j(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-934754782")) {
            ipChange.ipc$dispatch("-934754782", new Object[]{this, str});
            return;
        }
        this.e = str;
    }
}
