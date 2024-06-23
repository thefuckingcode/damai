package tb;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.responsive.R$styleable;
import com.alibaba.responsive.widget.size.OnResponsiveListener;

/* compiled from: Taobao */
public class c12 {
    private View a;
    private int b;
    private int c = 6;
    private int d = 15;
    private String e;
    private int f;
    private int g;
    private OnResponsiveListener h;
    private z02 i;

    public c12(View view) {
        this.a = view;
    }

    private void a(Context context) {
        if (this.f == 0) {
            this.f = f12.a(context, (float) this.c);
        }
        if (this.g == 0) {
            this.g = f12.a(context, (float) this.d);
        }
    }

    public int b() {
        return this.f;
    }

    public int c() {
        return this.g;
    }

    public void d(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.ResponsiveLayout, 0, 0);
            this.b = obtainStyledAttributes.getInt(R$styleable.ResponsiveLayout_layoutRatio, 0);
            obtainStyledAttributes.recycle();
        }
        a(context);
    }

    public z02 e(int i2, int i3) {
        if (this.i == null) {
            this.i = new z02();
        }
        int b2 = this.i.b();
        int d2 = this.i.d();
        this.i.a();
        z02 a2 = x21.a(f12.b(this.a), this.b, View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3), this.g, this.f, this.e, this.i);
        this.i = a2;
        if (!(this.h == null || (d2 == a2.d() && b2 == this.i.b()))) {
            this.h.onResponsive(this.i);
        }
        return this.i;
    }

    public void f(int i2) {
        this.f = i2;
    }

    public void g(int i2) {
        this.b = i2;
    }

    public void h(int i2) {
        this.g = i2;
    }

    public void i(OnResponsiveListener onResponsiveListener) {
        this.h = onResponsiveListener;
    }

    public void j(String str) {
        this.e = str;
    }
}
