package com.real.android.nativehtml.android;

import android.graphics.Paint;
import android.graphics.Typeface;
import com.real.android.nativehtml.common.css.CssEnum;
import com.real.android.nativehtml.common.css.CssProperty;
import com.real.android.nativehtml.common.css.CssUnit;
import com.real.android.nativehtml.common.layout.Layout;
import tb.ip;
import tb.jp;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class a {

    /* access modifiers changed from: package-private */
    /* renamed from: com.real.android.nativehtml.android.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class C0191a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        static {
            int[] iArr = new int[Layout.Directive.values().length];
            b = iArr;
            try {
                iArr[Layout.Directive.MINIMUM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            b[Layout.Directive.STRETCH.ordinal()] = 2;
            try {
                b[Layout.Directive.FIT_CONTENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[CssEnum.values().length];
            a = iArr2;
            iArr2[CssEnum.UNDERLINE.ordinal()] = 1;
            try {
                a[CssEnum.LINE_THROUGH.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static int a(Layout.Directive directive) {
        int i = C0191a.b[directive.ordinal()];
        if (i == 1) {
            return Integer.MIN_VALUE;
        }
        if (i == 2) {
            return 1073741824;
        }
        if (i == 3) {
            return 0;
        }
        throw new IllegalArgumentException();
    }

    static String b(jp jpVar) {
        CssProperty cssProperty = CssProperty.FONT_FAMILY;
        if (!jpVar.k(cssProperty)) {
            return "";
        }
        String b = ip.b(jpVar.h(cssProperty));
        return b.substring(b.lastIndexOf(44) + 1).trim();
    }

    static int c(jp jpVar) {
        int i = C0191a.a[jpVar.f(CssProperty.TEXT_DECORATION).ordinal()];
        if (i != 1) {
            return i != 2 ? 0 : 16;
        }
        return 8;
    }

    static int d(jp jpVar) {
        int i = jpVar.c(CssProperty.FONT_WEIGHT, CssUnit.NUMBER) > 600.0f ? 1 : 0;
        return jpVar.f(CssProperty.FONT_STYLE) == CssEnum.ITALIC ? i | 2 : i;
    }

    static Typeface e(jp jpVar) {
        int d = d(jpVar);
        if (!jpVar.k(CssProperty.FONT_FAMILY)) {
            return Typeface.defaultFromStyle(d);
        }
        return Typeface.create(b(jpVar), d);
    }

    public static void f(jp jpVar, float f, Paint paint) {
        paint.setTextSize(jpVar.g(CssProperty.FONT_SIZE, 0.0f) * f);
        paint.setTypeface(e(jpVar));
        paint.setFlags((paint.getFlags() & -25) | c(jpVar));
        paint.setColor(jpVar.e(CssProperty.COLOR));
    }
}
