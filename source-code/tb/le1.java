package tb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import com.alibaba.pictures.moimage.MoImageView;
import com.alibaba.pictures.moimage.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.bitmap.BitmapProcessor;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class le1 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private Uri a;
    private pe1 b;
    private Boolean c;
    private MoImageView.SimpleRequestListener d;
    private cq1 e;
    @NotNull
    private final Context f;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        @JvmStatic
        @NotNull
        public final le1 a(@NotNull Context context) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-658151500")) {
                return (le1) ipChange.ipc$dispatch("-658151500", new Object[]{this, context});
            }
            k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
            return new le1(context, null);
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* compiled from: Taobao */
    public static final class b extends ge {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // tb.ge
        @NotNull
        public String b(@Nullable String str, @Nullable String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1225502225")) {
                return (String) ipChange.ipc$dispatch("-1225502225", new Object[]{this, str, str2});
            }
            return str2 + this.a;
        }

        @Override // tb.ge
        @NotNull
        public String c(@Nullable String str, @Nullable String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2044287443")) {
                return (String) ipChange.ipc$dispatch("2044287443", new Object[]{this, str, str2});
            }
            return str2 + this.a;
        }
    }

    private le1(Context context) {
        this.f = context;
        this.c = Boolean.FALSE;
    }

    private final pe1 d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "895300316")) {
            return (pe1) ipChange.ipc$dispatch("895300316", new Object[]{this});
        }
        if (this.b == null) {
            this.b = new pe1();
        }
        pe1 pe1 = this.b;
        k21.f(pe1);
        return pe1;
    }

    private final void f(Integer num, ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "8109860")) {
            ipChange.ipc$dispatch("8109860", new Object[]{this, num, imageView});
            return;
        }
        imageView.setImageDrawable(null);
        if (num != null && num.intValue() != 0) {
            imageView.setBackgroundResource(num.intValue());
        }
    }

    private final void h(ImageView imageView) {
        Integer i;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "390178486")) {
            ipChange.ipc$dispatch("390178486", new Object[]{this, imageView});
            return;
        }
        me1 me1 = me1.INSTANCE;
        me1.b("MoImageLoader", ":-----load image with phenix!------");
        Context context = this.f;
        if (context == null || this.a == null) {
            me1.d("MoImageLoader", "context==null||targetUri==null,please check!");
        } else if (!(context instanceof Activity) || !((Activity) context).isDestroyed()) {
            String valueOf = String.valueOf(this.a);
            ke1 ke1 = ke1.INSTANCE;
            String str = null;
            if (!(!ke1.f(this.a) || (i = ke1.i(this.a)) == null || i.intValue() == 0)) {
                if (ke1.h(this.f, i.intValue())) {
                    valueOf = i42.r(i.intValue());
                } else {
                    try {
                        imageView.setImageResource(i.intValue());
                        MoImageView.SimpleRequestListener simpleRequestListener = this.d;
                        if (simpleRequestListener != null) {
                            simpleRequestListener.onResourceReady(null, String.valueOf(i.intValue()));
                        }
                    } catch (Exception e2) {
                        MoImageView.SimpleRequestListener simpleRequestListener2 = this.d;
                        if (simpleRequestListener2 != null) {
                            simpleRequestListener2.onLoadFailed(e2, String.valueOf(i.intValue()));
                        }
                    }
                    me1.INSTANCE.f("MoImageLoader", "非图片 类型的drawable资源直接走setImageResource(),return");
                    return;
                }
            }
            Uri uri = this.a;
            if (uri != null) {
                String path = uri.getPath();
                if (path == null || path.length() == 0) {
                    z = true;
                }
                if (!(!z)) {
                    uri = null;
                }
                if (uri != null) {
                    if (!k21.d("file", uri.getScheme()) || !a01.INSTANCE.g(this.f, uri.getPath())) {
                        String j = a01.INSTANCE.j(uri, valueOf);
                        if (j != null) {
                            valueOf = j;
                        }
                    } else {
                        valueOf = "file_q://" + uri.getPath();
                    }
                }
            }
            pe1 d2 = d();
            f(Integer.valueOf(d2.p()), imageView);
            ArrayList<BitmapProcessor> e3 = d2.e();
            int size = e3.size();
            BitmapProcessor[] bitmapProcessorArr = new BitmapProcessor[size];
            e3.toArray(bitmapProcessorArr);
            pe1 pe1 = this.b;
            if (pe1 != null) {
                str = pe1.l();
            }
            imageView.setTag(R$id.moimage_target_uri, k21.r(valueOf, str));
            vp1 v = tp1.o().v(valueOf, new b(str));
            if (k21.d(this.c, Boolean.TRUE)) {
                v.P();
            }
            v.m(new xp1(imageView, d2, this.d, valueOf));
            v.Q(new xp1(imageView, d2, this.d, valueOf));
            v.C(new xp1(imageView, d2, this.d, valueOf));
            this.e = v.h((BitmapProcessor[]) Arrays.copyOf(bitmapProcessorArr, size)).n();
        } else {
            me1.d("MoImageLoader", "context is a Activity&& this activity isDestroyed!!");
        }
    }

    @JvmStatic
    @NotNull
    public static final le1 p(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-942720596")) {
            return Companion.a(context);
        }
        return (le1) ipChange.ipc$dispatch("-942720596", new Object[]{context});
    }

    @NotNull
    public final le1 a(@Nullable MoImageView.SimpleRequestListener simpleRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1329544110")) {
            return (le1) ipChange.ipc$dispatch("-1329544110", new Object[]{this, simpleRequestListener});
        }
        this.d = simpleRequestListener;
        return this;
    }

    @NotNull
    public final le1 b(@Nullable pe1 pe1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "735740463")) {
            return (le1) ipChange.ipc$dispatch("735740463", new Object[]{this, pe1});
        }
        pe1 pe12 = this.b;
        if (pe12 == null) {
            this.b = pe1;
        } else if (pe12 != null) {
            pe12.u(pe1);
        }
        return this;
    }

    public final void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "853470840")) {
            ipChange.ipc$dispatch("853470840", new Object[]{this});
            return;
        }
        cq1 cq1 = this.e;
        if (cq1 != null) {
            if (!(!cq1.a())) {
                cq1 = null;
            }
            if (cq1 != null) {
                me1.INSTANCE.a("cancel--");
                cq1.cancel();
            }
        }
    }

    @NotNull
    public final le1 e(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "652348085")) {
            return (le1) ipChange.ipc$dispatch("652348085", new Object[]{this, Integer.valueOf(i)});
        }
        d().G(i);
        return this;
    }

    public final void g(@NotNull ImageView imageView) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "628975948")) {
            ipChange.ipc$dispatch("628975948", new Object[]{this, imageView});
            return;
        }
        k21.i(imageView, "imageView");
        pe1 d2 = d();
        if (d2.d() > 0 && d2.c() > 0) {
            z = false;
        }
        if (!z) {
            d2 = null;
        }
        if (!(d2 == null || imageView.getLayoutParams() == null)) {
            if (d2.d() <= 0) {
                d2.z(imageView.getLayoutParams().width);
            }
            if (d2.c() <= 0) {
                d2.y(imageView.getLayoutParams().height);
            }
        }
        h(imageView);
    }

    @NotNull
    public final le1 i(@Nullable Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2067425965")) {
            return (le1) ipChange.ipc$dispatch("2067425965", new Object[]{this, uri});
        }
        this.a = uri;
        return this;
    }

    @NotNull
    public final le1 j(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1768339506")) {
            return k(str, -1, -1);
        }
        return (le1) ipChange.ipc$dispatch("1768339506", new Object[]{this, str});
    }

    @NotNull
    public final le1 k(@Nullable String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1302698322")) {
            return (le1) ipChange.ipc$dispatch("1302698322", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (str != null) {
            ke1 ke1 = ke1.INSTANCE;
            if (!ke1.g(str)) {
                str = ke1.b(str, Integer.valueOf(i), Integer.valueOf(i2));
            }
        }
        pe1 d2 = d();
        d2.z(i);
        d2.y(i2);
        if (str != null) {
            try {
                if (str.length() != 0) {
                    z = false;
                }
            } catch (Exception e2) {
                me1 me1 = me1.INSTANCE;
                me1.b("MoImageLoader", "load-" + e2);
            }
        }
        if (!z) {
            this.a = Uri.parse(str);
        }
        return this;
    }

    public final void l(@NotNull Bitmap bitmap, @NotNull MoImageView moImageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1252200431")) {
            ipChange.ipc$dispatch("-1252200431", new Object[]{this, bitmap, moImageView});
            return;
        }
        k21.i(bitmap, "bm");
        k21.i(moImageView, "imageView");
        try {
            ArrayList<BitmapProcessor> e2 = d().e();
            String bitmap2 = bitmap.toString();
            Iterator<BitmapProcessor> it = e2.iterator();
            while (it.hasNext()) {
                bitmap = it.next().process(bitmap2, com.taobao.phenix.bitmap.b.a(), bitmap);
                k21.h(bitmap, "bitmapProcessor.process(…r.getInstance(), tBitmap)");
            }
            moImageView.setImageBitmap(bitmap);
        } catch (Exception e3) {
            me1.INSTANCE.c(e3.toString());
        }
    }

    @NotNull
    public final le1 m(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "396474794")) {
            return (le1) ipChange.ipc$dispatch("396474794", new Object[]{this, Integer.valueOf(i)});
        }
        d().H(i);
        return this;
    }

    public final void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-892432279")) {
            ipChange.ipc$dispatch("-892432279", new Object[]{this});
            return;
        }
        me1.INSTANCE.a("reset--");
        c();
        this.a = null;
        this.b = null;
        this.c = Boolean.FALSE;
        this.d = null;
        this.e = null;
    }

    @NotNull
    public final le1 o(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "274446032")) {
            return (le1) ipChange.ipc$dispatch("274446032", new Object[]{this, bool});
        }
        this.c = bool;
        return this;
    }

    public /* synthetic */ le1(Context context, m40 m40) {
        this(context);
    }
}
