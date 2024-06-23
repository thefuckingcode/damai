package tb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.taobao.phenix.bitmap.BitmapProcessor;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.phenix.intf.event.IRetryHandlerOnFailure;
import com.taobao.rxm.produce.Producer;
import com.taobao.rxm.schedule.SchedulerSupplier;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: Taobao */
public class vp1 extends d1 {
    private static int[] m;
    private final com.taobao.phenix.request.a a;
    private int b;
    private Drawable c;
    private int d;
    private Drawable e;
    private WeakReference<ImageView> f;
    private IPhenixListener<qg0> g;
    private IPhenixListener<ug2> h;
    private IPhenixListener<fc1> i;
    private IPhenixListener<wp1> j;
    private IPhenixListener<gt1> k;
    private IRetryHandlerOnFailure l;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements IPhenixListener<ug2> {
        a() {
        }

        /* renamed from: a */
        public boolean onHappen(ug2 ug2) {
            ImageView imageView;
            if (vp1.this.f == null || (imageView = (ImageView) vp1.this.f.get()) == null) {
                return false;
            }
            if (ug2.f() == null) {
                return true;
            }
            imageView.setImageDrawable(ug2.f());
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements IPhenixListener<fc1> {
        b() {
        }

        /* renamed from: a */
        public boolean onHappen(fc1 fc1) {
            ImageView imageView;
            if (vp1.this.f == null || (imageView = (ImageView) vp1.this.f.get()) == null) {
                return false;
            }
            if (vp1.this.b != 0) {
                imageView.setImageResource(vp1.this.b);
                return true;
            } else if (vp1.this.c == null) {
                return true;
            } else {
                imageView.setImageDrawable(vp1.this.c);
                return true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c implements IPhenixListener<qg0> {
        c() {
        }

        /* renamed from: a */
        public boolean onHappen(qg0 qg0) {
            ImageView imageView;
            if (vp1.this.f == null || (imageView = (ImageView) vp1.this.f.get()) == null) {
                return false;
            }
            if (vp1.this.d != 0) {
                imageView.setImageResource(vp1.this.d);
                return true;
            } else if (vp1.this.e == null) {
                return true;
            } else {
                imageView.setImageDrawable(vp1.this.e);
                return true;
            }
        }
    }

    vp1(ef1 ef1, String str, ge geVar) {
        this.a = new com.taobao.phenix.request.a(str, geVar, tp1.o().isGenericTypeCheckEnabled());
        J(tp1.o().q());
        M(tp1.o().r());
    }

    private cq1 o(ImageView imageView) {
        this.f = new WeakReference<>(imageView);
        return m(new c()).C(new b()).Q(new a()).n();
    }

    public static int[] v(Context context) {
        if (m == null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            m = new int[]{com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics), com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics)};
        }
        return m;
    }

    public vp1 A(View view) {
        int[] v = v(view.getContext());
        return B(view, v[0], v[1]);
    }

    public vp1 B(View view, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        if (!(view == null || (layoutParams = view.getLayoutParams()) == null)) {
            int i4 = layoutParams.width;
            if (i4 > 0) {
                this.a.n0(i4);
            } else if (i4 != -2) {
                this.a.n0(view.getWidth());
            }
            int i5 = layoutParams.height;
            if (i5 > 0) {
                this.a.m0(i5);
            } else if (i5 != -2) {
                this.a.m0(view.getHeight());
            }
        }
        if (this.a.J() <= 0) {
            this.a.n0(i2);
        }
        if (this.a.I() <= 0) {
            this.a.m0(i3);
        }
        return this;
    }

    public vp1 C(IPhenixListener<fc1> iPhenixListener) {
        this.i = iPhenixListener;
        return this;
    }

    public vp1 D(boolean z) {
        this.a.e0(z);
        return this;
    }

    public vp1 E(int i2) {
        this.a.o0(i2);
        return this;
    }

    @Deprecated
    public vp1 F(boolean z) {
        return this;
    }

    public vp1 G() {
        this.a.f0(true);
        return this;
    }

    public vp1 H(int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Placeholder image resource invalid.");
        } else if (this.c == null) {
            this.b = i2;
            return this;
        } else {
            throw new IllegalStateException("Placeholder image already set.");
        }
    }

    public vp1 I(Drawable drawable) {
        if (this.b == 0) {
            this.c = drawable;
            return this;
        }
        throw new IllegalStateException("Placeholder image already set.");
    }

    public vp1 J(boolean z) {
        this.a.v(z, 2);
        return this;
    }

    public vp1 K(boolean z) {
        this.a.h0(z);
        return this;
    }

    public vp1 L(IRetryHandlerOnFailure iRetryHandlerOnFailure) {
        this.l = iRetryHandlerOnFailure;
        return this;
    }

    public vp1 M(boolean z) {
        this.a.v(z, 4);
        return this;
    }

    public vp1 N(int i2) {
        this.a.q(i2);
        return this;
    }

    public vp1 O(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a.q0(str);
        }
        return this;
    }

    public vp1 P() {
        this.a.s0();
        return this;
    }

    public vp1 Q(IPhenixListener<ug2> iPhenixListener) {
        this.h = iPhenixListener;
        return this;
    }

    public String R() {
        return this.a.G().k();
    }

    public vp1 f(String str, String str2) {
        this.a.t(str, str2);
        return this;
    }

    public vp1 g(int i2, boolean z) {
        if (i2 == 1 || i2 == 3) {
            this.a.w(i2, z);
        }
        return this;
    }

    public vp1 h(BitmapProcessor... bitmapProcessorArr) {
        if (bitmapProcessorArr != null && bitmapProcessorArr.length > 0) {
            this.a.j0(bitmapProcessorArr);
        }
        return this;
    }

    public vp1 i(IPhenixListener<wp1> iPhenixListener) {
        this.j = iPhenixListener;
        return this;
    }

    public vp1 j(int i2) {
        this.a.l0(i2);
        return this;
    }

    public vp1 k(int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Error image resource invalid.");
        } else if (this.e == null) {
            this.d = i2;
            return this;
        } else {
            throw new IllegalStateException("Error image already set.");
        }
    }

    public vp1 l(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Error image may not be null.");
        } else if (this.d == 0) {
            this.e = drawable;
            return this;
        } else {
            throw new IllegalStateException("Error image already set.");
        }
    }

    public vp1 m(IPhenixListener<qg0> iPhenixListener) {
        this.g = iPhenixListener;
        return this;
    }

    public cq1 n() {
        String str;
        cq1 P = this.a.P();
        if (TextUtils.isEmpty(this.a.N())) {
            IPhenixListener<qg0> iPhenixListener = this.g;
            if (iPhenixListener != null) {
                iPhenixListener.onHappen(new qg0(P));
            }
            return P;
        }
        Map<String, String> H = this.a.H();
        if (!(H == null || (str = H.get("bundle_biz_code")) == null)) {
            this.a.U().r = str;
        }
        jj1 m2 = tp1.o().m();
        Producer<so1, com.taobao.phenix.request.a> b2 = m2.get();
        SchedulerSupplier c2 = m2.c();
        b2.produceResults(new yp1(this.a, this, tp1.o().k(), c2, tp1.o().j()).consumeOn(c2.forUiThread()));
        return P;
    }

    public vp1 p(boolean z) {
        this.a.y(z);
        return this;
    }

    public IPhenixListener<wp1> q() {
        return this.j;
    }

    public IPhenixListener<qg0> r() {
        return this.g;
    }

    public IPhenixListener<fc1> s() {
        return this.i;
    }

    public IPhenixListener<gt1> t() {
        return this.k;
    }

    public IRetryHandlerOnFailure u() {
        return this.l;
    }

    public IPhenixListener<ug2> w() {
        return this.h;
    }

    public int x() {
        com.taobao.phenix.request.a aVar = this.a;
        if (aVar != null) {
            return aVar.d();
        }
        return -1;
    }

    public cq1 y(ImageView imageView) {
        return z(imageView, 1.0f);
    }

    public cq1 z(ImageView imageView, float f2) {
        A(imageView);
        if (f2 > 1.0f) {
            com.taobao.phenix.request.a aVar = this.a;
            aVar.n0((int) (((float) aVar.J()) / f2));
            com.taobao.phenix.request.a aVar2 = this.a;
            aVar2.m0((int) (((float) aVar2.I()) / f2));
        }
        return o(imageView);
    }
}
