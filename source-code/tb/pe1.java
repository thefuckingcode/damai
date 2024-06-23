package tb;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.alibaba.pictures.moimage.MoImageView;
import com.alibaba.pictures.moimage.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.bitmap.BitmapProcessor;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class pe1 {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private Boolean a;
    @Nullable
    private Boolean b;
    private int c;
    private int d;
    private int e;
    @Nullable
    private MoImageView.GScaleType f;
    @Nullable
    private MoImageView.GScaleType g;
    @Nullable
    private MoImageView.GScaleType h;
    @Nullable
    private PointF i;
    @NotNull
    private a j = new a();
    private boolean k;
    private int l;
    private int m;
    @NotNull
    private MoImageView.ImageViewType n = MoImageView.ImageViewType.DEFAULT;
    private Drawable o;
    private Drawable p;
    private int q;
    private int r;
    private boolean s;
    private int t;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        public static final C0308a Companion = new C0308a(null);
        private int a;
        private float[] b;
        private boolean c = true;
        private boolean d = true;
        private boolean e = true;
        private boolean f = true;
        private boolean g;
        private boolean h;
        private float i;
        private int j;

        /* renamed from: tb.pe1$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static final class C0308a {
            private static transient /* synthetic */ IpChange $ipChange;

            private C0308a() {
            }

            @JvmStatic
            @NotNull
            public final a a(float f) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-374861772")) {
                    return (a) ipChange.ipc$dispatch("-374861772", new Object[]{this, Float.valueOf(f)});
                }
                a aVar = new a();
                aVar.k(f);
                return aVar;
            }

            public /* synthetic */ C0308a(m40 m40) {
                this();
            }
        }

        private final float[] e() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1029373953")) {
                return (float[]) ipChange.ipc$dispatch("-1029373953", new Object[]{this});
            }
            if (this.b == null) {
                this.b = new float[8];
            }
            float[] fArr = this.b;
            k21.f(fArr);
            return fArr;
        }

        public final int a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2062867007")) {
                return this.a;
            }
            return ((Integer) ipChange.ipc$dispatch("-2062867007", new Object[]{this})).intValue();
        }

        public final int b() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "633954083")) {
                return this.j;
            }
            return ((Integer) ipChange.ipc$dispatch("633954083", new Object[]{this})).intValue();
        }

        public final float c() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-124345891")) {
                return this.i;
            }
            return ((Float) ipChange.ipc$dispatch("-124345891", new Object[]{this})).floatValue();
        }

        @NotNull
        public final float[] d() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1162404757")) {
                return (float[]) ipChange.ipc$dispatch("1162404757", new Object[]{this});
            }
            float[] fArr = this.b;
            if (fArr != null) {
                float[] fArr2 = fArr.length == 8 ? fArr : null;
                if (fArr2 != null) {
                    if (!this.c) {
                        fArr2[1] = 0.0f;
                        fArr2[0] = 0.0f;
                    }
                    if (!this.d) {
                        fArr2[2] = 0.0f;
                        fArr2[3] = 0.0f;
                    }
                    if (!this.f) {
                        fArr2[4] = 0.0f;
                        fArr2[5] = 0.0f;
                    }
                    if (!this.e) {
                        fArr2[6] = 0.0f;
                        fArr2[7] = 0.0f;
                    }
                }
            }
            return fArr != null ? fArr : new float[8];
        }

        public final boolean f() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1430985161")) {
                return this.h;
            }
            return ((Boolean) ipChange.ipc$dispatch("-1430985161", new Object[]{this})).booleanValue();
        }

        public final boolean g() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1559782411")) {
                return this.g;
            }
            return ((Boolean) ipChange.ipc$dispatch("1559782411", new Object[]{this})).booleanValue();
        }

        public final void h(int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-902196409")) {
                ipChange.ipc$dispatch("-902196409", new Object[]{this, Integer.valueOf(i2)});
                return;
            }
            if (i2 != 0) {
                this.g = true;
            }
            this.j = i2;
        }

        public final void i(float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1360305383")) {
                ipChange.ipc$dispatch("1360305383", new Object[]{this, Float.valueOf(f2)});
                return;
            }
            if (f2 > ((float) 0)) {
                this.g = true;
            }
            this.i = f2;
        }

        @NotNull
        public final a j(float f2, float f3, float f4, float f5) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1697895209")) {
                return (a) ipChange.ipc$dispatch("1697895209", new Object[]{this, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)});
            }
            float f6 = (float) 0;
            if (f2 > f6 || f3 > f6 || f4 > f6 || f5 > f6) {
                this.g = true;
            }
            float[] e2 = e();
            e2[0] = f2;
            e2[1] = f2;
            e2[2] = f3;
            e2[3] = f3;
            e2[4] = f4;
            e2[5] = f4;
            e2[6] = f5;
            e2[7] = f5;
            return this;
        }

        @NotNull
        public final a k(float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "646535468")) {
                return (a) ipChange.ipc$dispatch("646535468", new Object[]{this, Float.valueOf(f2)});
            }
            if (f2 > ((float) 0)) {
                this.g = true;
            }
            Arrays.fill(e(), f2);
            return this;
        }

        public final void l(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1789312721")) {
                ipChange.ipc$dispatch("1789312721", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            if (z) {
                this.g = true;
            }
            this.h = z;
        }

        public final void m(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1082313727")) {
                ipChange.ipc$dispatch("-1082313727", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            this.e = z;
        }

        public final void n(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1842192384")) {
                ipChange.ipc$dispatch("1842192384", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            this.f = z;
        }

        public final void o(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2051657013")) {
                ipChange.ipc$dispatch("-2051657013", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            this.c = z;
        }

        public final void p(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1857321590")) {
                ipChange.ipc$dispatch("1857321590", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            this.d = z;
        }

        public final void q(int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1321764929")) {
                ipChange.ipc$dispatch("1321764929", new Object[]{this, Integer.valueOf(i2)});
            }
        }
    }

    public pe1() {
        Boolean bool = Boolean.FALSE;
        this.a = bool;
        this.b = bool;
    }

    private final MoImageView.GScaleType r(TypedArray typedArray, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1530307451")) {
            return (MoImageView.GScaleType) ipChange.ipc$dispatch("1530307451", new Object[]{this, typedArray, Integer.valueOf(i2)});
        }
        switch (typedArray.getInt(i2, -1)) {
            case -1:
                return null;
            case 0:
                return MoImageView.GScaleType.FIT_XY;
            case 1:
                return MoImageView.GScaleType.FIT_START;
            case 2:
                return MoImageView.GScaleType.FIT_CENTER;
            case 3:
                return MoImageView.GScaleType.FIT_END;
            case 4:
                return MoImageView.GScaleType.CENTER;
            case 5:
                return MoImageView.GScaleType.CENTER_INSIDE;
            case 6:
                return MoImageView.GScaleType.CENTER_CROP;
            case 7:
                return MoImageView.GScaleType.FOCUS_CROP;
            case 8:
                return MoImageView.GScaleType.FOCUS_CROP;
            case 9:
                return MoImageView.GScaleType.FIT_WIDTH;
            case 10:
                return MoImageView.GScaleType.FIT_HEIGHT;
            default:
                throw new RuntimeException("XML attribute not specified!");
        }
    }

    private final MoImageView.GScaleType s(TypedArray typedArray, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2107785085")) {
            return (MoImageView.GScaleType) ipChange.ipc$dispatch("2107785085", new Object[]{this, typedArray, Integer.valueOf(i2)});
        }
        switch (typedArray.getInt(i2, -1)) {
            case -1:
                return null;
            case 0:
                return MoImageView.GScaleType.MATRIX;
            case 1:
                return MoImageView.GScaleType.FIT_XY;
            case 2:
                return MoImageView.GScaleType.FIT_START;
            case 3:
                return MoImageView.GScaleType.FIT_CENTER;
            case 4:
                return MoImageView.GScaleType.FIT_END;
            case 5:
                return MoImageView.GScaleType.CENTER;
            case 6:
                return MoImageView.GScaleType.CENTER_CROP;
            case 7:
                return MoImageView.GScaleType.CENTER_INSIDE;
            default:
                throw new RuntimeException("XML attribute not specified!");
        }
    }

    private final void v(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2078535755")) {
            ipChange.ipc$dispatch("-2078535755", new Object[]{this, context, attributeSet});
        } else if (context != null && attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MoImageView);
            k21.h(obtainStyledAttributes, "context.obtainStyledAttr… R.styleable.MoImageView)");
            try {
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i2 = 0; i2 < indexCount; i2++) {
                    int index = obtainStyledAttributes.getIndex(i2);
                    if (index == R$styleable.MoImageView_actualImageScaleType) {
                        this.f = r(obtainStyledAttributes, index);
                    } else if (index == R$styleable.MoImageView_placeholderImage) {
                        this.c = obtainStyledAttributes.getResourceId(index, 0);
                    } else if (index == R$styleable.MoImageView_placeholderImageScaleType) {
                        this.g = r(obtainStyledAttributes, index);
                    } else if (index == R$styleable.MoImageView_retryImageScaleType) {
                        r(obtainStyledAttributes, index);
                    } else if (index == R$styleable.MoImageView_failureImage) {
                        this.d = obtainStyledAttributes.getResourceId(index, 0);
                    } else if (index == R$styleable.MoImageView_failureImageScaleType) {
                        this.h = r(obtainStyledAttributes, index);
                    } else if (index == R$styleable.MoImageView_progressBarImageScaleType) {
                        r(obtainStyledAttributes, index);
                    } else if (index == R$styleable.MoImageView_progressBarAutoRotateInterval) {
                        this.e = obtainStyledAttributes.getInteger(index, this.e);
                    } else if (index == R$styleable.MoImageView_backgroundImage) {
                        obtainStyledAttributes.getResourceId(index, 0);
                    } else if (index == R$styleable.MoImageView_overlayImage) {
                        obtainStyledAttributes.getResourceId(index, 0);
                    } else if (index == R$styleable.MoImageView_roundAsCircle) {
                        this.j.l(obtainStyledAttributes.getBoolean(index, false));
                    } else if (index == R$styleable.MoImageView_roundedCornerRadius) {
                        this.j.k((float) obtainStyledAttributes.getDimensionPixelSize(index, 0));
                    } else if (index == R$styleable.MoImageView_roundTopLeft) {
                        this.j.o(obtainStyledAttributes.getBoolean(index, true));
                    } else if (index == R$styleable.MoImageView_roundTopRight) {
                        this.j.p(obtainStyledAttributes.getBoolean(index, true));
                    } else if (index == R$styleable.MoImageView_roundBottomLeft) {
                        this.j.m(obtainStyledAttributes.getBoolean(index, true));
                    } else if (index == R$styleable.MoImageView_roundBottomRight) {
                        this.j.n(obtainStyledAttributes.getBoolean(index, true));
                    } else if (index == R$styleable.MoImageView_roundingBorderWidth) {
                        this.j.i((float) obtainStyledAttributes.getDimensionPixelSize(index, 0));
                    } else if (index == R$styleable.MoImageView_roundingBorderColor) {
                        this.j.h(obtainStyledAttributes.getColor(index, 0));
                    } else if (index == R$styleable.MoImageView_roundingBorderPadding) {
                        this.j.q(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                    } else if (index == R$styleable.MoImageView_isForcedShowErrorImg) {
                        this.k = obtainStyledAttributes.getBoolean(index, false);
                    } else if (index == R$styleable.MoImageView_roundWithOverlayColor) {
                        obtainStyledAttributes.getColor(index, 0);
                    } else if (index == R$styleable.MoImageView_retryImage) {
                        obtainStyledAttributes.getResourceId(index, 0);
                    } else if (index == R$styleable.MoImageView_pressedStateOverlayImage) {
                        obtainStyledAttributes.getResourceId(index, 0);
                    } else if (index == R$styleable.MoImageView_progressBarImage) {
                        obtainStyledAttributes.getResourceId(index, 0);
                    } else if (index == R$styleable.MoImageView_fadeDuration) {
                        this.t = obtainStyledAttributes.getInt(index, 0);
                    } else {
                        int i3 = R$styleable.MoImageView_viewAspectRatio;
                    }
                }
            } catch (Exception e2) {
                me1 me1 = me1.INSTANCE;
                me1.c("ImageState_resolve:" + e2);
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
            obtainStyledAttributes.recycle();
            if (this.f == null) {
                TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, new int[]{16843037});
                k21.h(obtainStyledAttributes2, "context.obtainStyledAttributes(attrs, oriTagS)");
                try {
                    this.f = s(obtainStyledAttributes2, 0);
                } catch (Exception e3) {
                    me1 me12 = me1.INSTANCE;
                    me12.c("ImageState_resolve:" + e3);
                } catch (Throwable th2) {
                    obtainStyledAttributes2.recycle();
                    throw th2;
                }
                obtainStyledAttributes2.recycle();
            }
        }
    }

    public final void A(@Nullable Exception exc) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1257957233")) {
            ipChange.ipc$dispatch("-1257957233", new Object[]{this, exc});
        }
    }

    public final void B(@Nullable Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1521893470")) {
            ipChange.ipc$dispatch("1521893470", new Object[]{this, drawable});
            return;
        }
        this.p = drawable;
    }

    public final void C(@Nullable MoImageView.GScaleType gScaleType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "914855681")) {
            ipChange.ipc$dispatch("914855681", new Object[]{this, gScaleType});
            return;
        }
        this.h = gScaleType;
    }

    public final void D(int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2091911428")) {
            ipChange.ipc$dispatch("2091911428", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        this.l = i2;
        this.m = i3;
    }

    public final void E(@NotNull MoImageView.ImageViewType imageViewType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-987825994")) {
            ipChange.ipc$dispatch("-987825994", new Object[]{this, imageViewType});
            return;
        }
        k21.i(imageViewType, "<set-?>");
        this.n = imageViewType;
    }

    public final void F(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1890088034")) {
            ipChange.ipc$dispatch("1890088034", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.s = z;
    }

    public final void G(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-945446737")) {
            ipChange.ipc$dispatch("-945446737", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.d = i2;
    }

    public final void H(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-845240558")) {
            ipChange.ipc$dispatch("-845240558", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.c = i2;
    }

    public final void I(@Nullable Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1989358567")) {
            ipChange.ipc$dispatch("1989358567", new Object[]{this, drawable});
            return;
        }
        this.o = drawable;
    }

    public final void J(@Nullable MoImageView.GScaleType gScaleType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1583094346")) {
            ipChange.ipc$dispatch("1583094346", new Object[]{this, gScaleType});
            return;
        }
        this.g = gScaleType;
    }

    public final void K(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-842368769")) {
            ipChange.ipc$dispatch("-842368769", new Object[]{this, bool});
            return;
        }
        this.a = bool;
    }

    public final void L(@NotNull a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1313606814")) {
            ipChange.ipc$dispatch("-1313606814", new Object[]{this, aVar});
            return;
        }
        k21.i(aVar, "<set-?>");
        this.j = aVar;
    }

    public final void M(int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "586024117")) {
            ipChange.ipc$dispatch("586024117", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        this.q = i2;
        this.r = i3;
    }

    @NotNull
    public final pe1 a(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "903392690")) {
            return (pe1) ipChange.ipc$dispatch("903392690", new Object[]{this, context, attributeSet});
        }
        v(context, attributeSet);
        return this;
    }

    @Nullable
    public final PointF b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "859629639")) {
            return this.i;
        }
        return (PointF) ipChange.ipc$dispatch("859629639", new Object[]{this});
    }

    public final int c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2053310930")) {
            return this.r;
        }
        return ((Integer) ipChange.ipc$dispatch("-2053310930", new Object[]{this})).intValue();
    }

    public final int d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1369612533")) {
            return this.q;
        }
        return ((Integer) ipChange.ipc$dispatch("1369612533", new Object[]{this})).intValue();
    }

    @NotNull
    public final ArrayList<BitmapProcessor> e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1729067153")) {
            return (ArrayList) ipChange.ipc$dispatch("-1729067153", new Object[]{this});
        }
        ArrayList<BitmapProcessor> arrayList = new ArrayList<>();
        if (this.s) {
            return arrayList;
        }
        BitmapProcessor bitmapProcessor = null;
        MoImageView.GScaleType gScaleType = this.f;
        if (gScaleType != null) {
            if (gScaleType != null) {
                switch (qe1.$EnumSwitchMapping$0[gScaleType.ordinal()]) {
                    case 1:
                        bitmapProcessor = new yi0(this.q, this.r);
                        break;
                    case 2:
                        bitmapProcessor = new vi0(this.q, this.r);
                        break;
                    case 3:
                        bitmapProcessor = new lg(this.q, this.r);
                        break;
                    case 4:
                        bitmapProcessor = new zq1(this.q, this.r, this.i);
                        break;
                    case 5:
                        bitmapProcessor = new xi0(this.q, this.r);
                        break;
                    case 6:
                        bitmapProcessor = new wi0(this.q, this.r);
                        break;
                }
            }
            bitmapProcessor = new mg(this.q, this.r);
        }
        if (bitmapProcessor == null) {
            bitmapProcessor = this.j.g() ? new yi0(this.q, this.r) : new mg(this.q, this.r);
        }
        arrayList.add(bitmapProcessor);
        if ((!k21.d(this.a, Boolean.TRUE)) && this.n != MoImageView.ImageViewType.WEBPANI && this.j.g()) {
            arrayList.add(new up1(this.q, this.r, this.j));
        }
        return arrayList;
    }

    @Nullable
    public final Boolean f() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1954596930")) {
            return this.b;
        }
        return (Boolean) ipChange.ipc$dispatch("1954596930", new Object[]{this});
    }

    public final int g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1116399976")) {
            return this.t;
        }
        return ((Integer) ipChange.ipc$dispatch("-1116399976", new Object[]{this})).intValue();
    }

    @Nullable
    public final MoImageView.GScaleType h() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-607661375")) {
            return this.h;
        }
        return (MoImageView.GScaleType) ipChange.ipc$dispatch("-607661375", new Object[]{this});
    }

    public final int i() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1378253221")) {
            return this.m;
        }
        return ((Integer) ipChange.ipc$dispatch("1378253221", new Object[]{this})).intValue();
    }

    public final int j() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "649024158")) {
            return this.l;
        }
        return ((Integer) ipChange.ipc$dispatch("649024158", new Object[]{this})).intValue();
    }

    @NotNull
    public final MoImageView.ImageViewType k() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-900406080")) {
            return this.n;
        }
        return (MoImageView.ImageViewType) ipChange.ipc$dispatch("-900406080", new Object[]{this});
    }

    @NotNull
    public final String l() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2097564199")) {
            return (String) ipChange.ipc$dispatch("2097564199", new Object[]{this});
        }
        if (this.j.g()) {
            str = Arrays.toString(this.j.d());
            k21.h(str, "java.util.Arrays.toString(this)");
        } else {
            str = "";
        }
        return this.q + '-' + this.r + '-' + str;
    }

    @Nullable
    public final MoImageView.GScaleType m() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1184487056")) {
            return this.f;
        }
        return (MoImageView.GScaleType) ipChange.ipc$dispatch("1184487056", new Object[]{this});
    }

    public final int n() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "899392443")) {
            return this.d;
        }
        return ((Integer) ipChange.ipc$dispatch("899392443", new Object[]{this})).intValue();
    }

    public final boolean o() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1210187315")) {
            return this.k;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1210187315", new Object[]{this})).booleanValue();
    }

    public final int p() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1701842440")) {
            return this.c;
        }
        return ((Integer) ipChange.ipc$dispatch("-1701842440", new Object[]{this})).intValue();
    }

    @NotNull
    public final a q() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "671472878")) {
            return this.j;
        }
        return (a) ipChange.ipc$dispatch("671472878", new Object[]{this});
    }

    public final boolean t() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1453346398")) {
            return this.l <= 0 || this.m <= 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1453346398", new Object[]{this})).booleanValue();
    }

    public final void u(@Nullable pe1 pe1) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "568956250")) {
            ipChange.ipc$dispatch("568956250", new Object[]{this, pe1});
        } else if (pe1 != null) {
            MoImageView.ImageViewType imageViewType = pe1.n;
            if (imageViewType != null) {
                pe1.n = imageViewType;
            }
            MoImageView.GScaleType gScaleType = pe1.f;
            if (gScaleType != null) {
                this.f = gScaleType;
            }
            Drawable drawable = pe1.o;
            if (drawable != null) {
                this.o = drawable;
            }
            Integer valueOf = Integer.valueOf(pe1.c);
            Integer num = null;
            if (!(valueOf.intValue() != 0)) {
                valueOf = null;
            }
            if (valueOf != null) {
                this.c = valueOf.intValue();
            }
            MoImageView.GScaleType gScaleType2 = pe1.g;
            if (gScaleType2 != null) {
                this.g = gScaleType2;
            }
            Drawable drawable2 = pe1.p;
            if (drawable2 != null) {
                this.p = drawable2;
            }
            Integer valueOf2 = Integer.valueOf(pe1.d);
            if (valueOf2.intValue() == 0) {
                z = false;
            }
            if (z) {
                num = valueOf2;
            }
            if (num != null) {
                this.d = num.intValue();
            }
            MoImageView.GScaleType gScaleType3 = pe1.h;
            if (gScaleType3 != null) {
                this.h = gScaleType3;
            }
            PointF pointF = pe1.i;
            if (pointF != null) {
                this.i = pointF;
            }
            Boolean bool = pe1.b;
            if (bool != null) {
                this.b = Boolean.valueOf(bool.booleanValue());
            }
            this.q = pe1.q;
            this.r = pe1.r;
            this.l = pe1.l;
            this.m = pe1.m;
            this.j = pe1.j;
        }
    }

    public final void w(@Nullable PointF pointF) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1543284821")) {
            ipChange.ipc$dispatch("-1543284821", new Object[]{this, pointF});
            return;
        }
        this.i = pointF;
    }

    public final void x(@Nullable MoImageView.GScaleType gScaleType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1358686685")) {
            ipChange.ipc$dispatch("1358686685", new Object[]{this, gScaleType});
            return;
        }
        this.f = gScaleType;
    }

    public final void y(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1470794956")) {
            ipChange.ipc$dispatch("-1470794956", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.r = i2;
    }

    public final void z(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "821473717")) {
            ipChange.ipc$dispatch("821473717", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.q = i2;
    }
}
