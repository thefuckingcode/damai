package tb;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class rr extends Drawable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int SHAPE_CIRCLE = 2;
    public static final int SHAPE_ROUND = 1;
    private Paint a;
    private Paint b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private float h;
    private float i;
    private float j;
    private int k;
    private int l;
    private int[] m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private RectF r;

    /* compiled from: Taobao */
    public static class b {
        private static transient /* synthetic */ IpChange $ipChange;
        private int a;
        private int b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int[] g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private int l;
        private int m;

        public b() {
            this.e = 0;
            this.f = 0;
            this.a = 1;
            this.b = 12;
            this.c = Color.parseColor("#4d000000");
            this.d = 18;
            this.e = 0;
            this.f = 0;
            int[] iArr = new int[1];
            this.g = iArr;
            iArr[0] = 0;
            this.h = false;
            this.j = false;
            this.k = false;
            this.i = false;
            this.l = -1;
            this.m = -1;
        }

        public rr a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1140439682")) {
                return new rr(this.a, this.g, this.b, this.c, this.d, this.e, this.f, this.j, this.i, this.k, this.h, this.m, this.l);
            }
            return (rr) ipChange.ipc$dispatch("1140439682", new Object[]{this});
        }

        public b b(int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-223377797")) {
                return (b) ipChange.ipc$dispatch("-223377797", new Object[]{this, Integer.valueOf(i2)});
            }
            this.g[0] = i2;
            return this;
        }

        public b c(int[] iArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "944433640")) {
                return (b) ipChange.ipc$dispatch("944433640", new Object[]{this, iArr});
            }
            this.g = iArr;
            return this;
        }

        public b d(int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1909133396")) {
                return (b) ipChange.ipc$dispatch("1909133396", new Object[]{this, Integer.valueOf(i2)});
            }
            this.e = i2;
            return this;
        }

        public b e(int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-21485709")) {
                return (b) ipChange.ipc$dispatch("-21485709", new Object[]{this, Integer.valueOf(i2)});
            }
            this.f = i2;
            return this;
        }

        public b f(int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "26640278")) {
                return (b) ipChange.ipc$dispatch("26640278", new Object[]{this, Integer.valueOf(i2)});
            }
            this.c = i2;
            return this;
        }

        public b g(int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "932663853")) {
                return (b) ipChange.ipc$dispatch("932663853", new Object[]{this, Integer.valueOf(i2)});
            }
            this.d = i2;
            return this;
        }

        public b h(int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-488094312")) {
                return (b) ipChange.ipc$dispatch("-488094312", new Object[]{this, Integer.valueOf(i2)});
            }
            this.a = i2;
            return this;
        }

        public b i(int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1099985882")) {
                return (b) ipChange.ipc$dispatch("-1099985882", new Object[]{this, Integer.valueOf(i2)});
            }
            this.b = i2;
            return this;
        }
    }

    public static void a(View view, int i2, int i3, int i4, int i5, int i6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-592344510")) {
            ipChange.ipc$dispatch("-592344510", new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)});
            return;
        }
        rr a2 = new b().i(i2).f(i3).g(i4).d(i5).e(i6).a();
        view.setLayerType(1, null);
        ViewCompat.setBackground(view, a2);
    }

    public static void b(View view, int i2, int i3, int i4, int i5, int i6, int i7) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1182781183")) {
            ipChange.ipc$dispatch("-1182781183", new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)});
            return;
        }
        rr a2 = new b().b(i2).i(i3).f(i4).g(i5).d(i6).e(i7).a();
        view.setLayerType(1, null);
        ViewCompat.setBackground(view, a2);
    }

    public static void c(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1988518434")) {
            ipChange.ipc$dispatch("1988518434", new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)});
            return;
        }
        rr a2 = new b().h(i2).b(i3).i(i4).f(i5).g(i6).d(i7).e(i8).a();
        view.setLayerType(1, null);
        ViewCompat.setBackground(view, a2);
    }

    public static void d(View view, int[] iArr, int i2, int i3, int i4, int i5, int i6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-480890828")) {
            ipChange.ipc$dispatch("-480890828", new Object[]{view, iArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)});
            return;
        }
        rr a2 = new b().c(iArr).i(i2).f(i3).g(i4).d(i5).e(i6).a();
        view.setLayerType(1, null);
        ViewCompat.setBackground(view, a2);
    }

    private void e(RectF rectF) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-508305213")) {
            ipChange.ipc$dispatch("-508305213", new Object[]{this, rectF});
            return;
        }
        int[] iArr = this.m;
        if (iArr != null) {
            if (iArr.length == 1) {
                this.b.setColor(iArr[0]);
            } else {
                this.b.setShader(new LinearGradient(rectF.left, rectF.height() / 2.0f, rectF.right, rectF.height() / 2.0f, this.m, (float[]) null, Shader.TileMode.CLAMP));
            }
        }
        this.h = rectF.centerX();
        this.i = rectF.centerY();
        this.j = Math.min(rectF.width(), rectF.height()) / 2.0f;
    }

    public void draw(@NonNull Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1898026192")) {
            ipChange.ipc$dispatch("1898026192", new Object[]{this, canvas});
        } else if (this.f == 1) {
            RectF rectF = this.r;
            int i2 = this.g;
            canvas.drawRoundRect(rectF, (float) i2, (float) i2, this.a);
            RectF rectF2 = this.r;
            int i3 = this.g;
            canvas.drawRoundRect(rectF2, (float) i3, (float) i3, this.b);
        } else {
            canvas.drawCircle(this.h, this.i, this.j, this.a);
            canvas.drawCircle(this.h, this.i, this.j, this.b);
        }
    }

    public int getOpacity() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1334981897")) {
            return -3;
        }
        return ((Integer) ipChange.ipc$dispatch("-1334981897", new Object[]{this})).intValue();
    }

    public void setAlpha(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-520496570")) {
            ipChange.ipc$dispatch("-520496570", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.a.setAlpha(i2);
    }

    public void setBounds(int i2, int i3, int i4, int i5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-130196966")) {
            ipChange.ipc$dispatch("-130196966", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
            return;
        }
        super.setBounds(i2, i3, i4, i5);
        if (this.e < 0) {
            this.e = this.c;
        }
        if (this.d < 0) {
            this.d = this.c;
        }
        if (!this.p) {
            i2 = (i2 + this.e) - this.k;
        }
        if (!this.o) {
            i3 = (i3 + this.d) - this.l;
        }
        if (!this.q) {
            i4 = (i4 - this.e) - this.k;
        }
        if (!this.n) {
            i5 = (i5 - this.d) - this.l;
        }
        RectF rectF = new RectF((float) i2, (float) i3, (float) i4, (float) i5);
        this.r = rectF;
        e(rectF);
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "974496184")) {
            ipChange.ipc$dispatch("974496184", new Object[]{this, colorFilter});
            return;
        }
        this.a.setColorFilter(colorFilter);
    }

    private rr(int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2, boolean z3, boolean z4, int i8, int i9) {
        this.f = i2;
        this.m = iArr;
        this.g = i3;
        this.c = i5;
        this.k = i6;
        this.l = i7;
        this.n = z4;
        this.p = z;
        this.q = z3;
        this.o = z2;
        this.e = i8;
        this.d = i9;
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(0);
        this.a.setAntiAlias(true);
        this.a.setShadowLayer((float) i5, (float) i6, (float) i7, i4);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setAntiAlias(true);
        this.r = new RectF();
    }
}
