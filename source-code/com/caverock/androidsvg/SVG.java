package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import com.caverock.androidsvg.CSSParser;
import com.youku.arch.solid.monitor.SolidMonitor;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import tb.j32;
import tb.jl1;

/* compiled from: Taobao */
public class SVG {
    private static j32 e = null;
    private static boolean f = true;
    private w a = null;
    private float b = 96.0f;
    private CSSParser.m c = new CSSParser.m();
    private Map<String, a0> d = new HashMap();

    /* compiled from: Taobao */
    static class Colour extends SvgPaint {
        static final Colour BLACK = new Colour(-16777216);
        static final Colour TRANSPARENT = new Colour(0);
        int colour;

        Colour(int i) {
            this.colour = i;
        }

        public String toString() {
            return String.format("#%08x", Integer.valueOf(this.colour));
        }
    }

    /* compiled from: Taobao */
    static class CurrentColor extends SvgPaint {
        private static CurrentColor instance = new CurrentColor();

        private CurrentColor() {
        }

        static CurrentColor getInstance() {
            return instance;
        }
    }

    /* compiled from: Taobao */
    enum GradientSpread {
        pad,
        reflect,
        repeat
    }

    /* compiled from: Taobao */
    interface HasTransform {
        void setTransform(Matrix matrix);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class Length implements Cloneable {
        Unit unit;
        float value;

        Length(float f, Unit unit2) {
            this.value = f;
            this.unit = unit2;
        }

        /* access modifiers changed from: package-private */
        public float floatValue() {
            return this.value;
        }

        /* access modifiers changed from: package-private */
        public float floatValueX(e eVar) {
            switch (a.a[this.unit.ordinal()]) {
                case 1:
                    return this.value;
                case 2:
                    return this.value * eVar.Y();
                case 3:
                    return this.value * eVar.Z();
                case 4:
                    return this.value * eVar.b0();
                case 5:
                    return (this.value * eVar.b0()) / 2.54f;
                case 6:
                    return (this.value * eVar.b0()) / 25.4f;
                case 7:
                    return (this.value * eVar.b0()) / 72.0f;
                case 8:
                    return (this.value * eVar.b0()) / 6.0f;
                case 9:
                    b a0 = eVar.a0();
                    if (a0 == null) {
                        return this.value;
                    }
                    return (this.value * a0.c) / 100.0f;
                default:
                    return this.value;
            }
        }

        /* access modifiers changed from: package-private */
        public float floatValueY(e eVar) {
            if (this.unit != Unit.percent) {
                return floatValueX(eVar);
            }
            b a0 = eVar.a0();
            if (a0 == null) {
                return this.value;
            }
            return (this.value * a0.d) / 100.0f;
        }

        /* access modifiers changed from: package-private */
        public boolean isNegative() {
            return this.value < 0.0f;
        }

        /* access modifiers changed from: package-private */
        public boolean isZero() {
            return this.value == 0.0f;
        }

        public String toString() {
            return String.valueOf(this.value) + this.unit;
        }

        /* access modifiers changed from: package-private */
        public float floatValue(e eVar) {
            if (this.unit != Unit.percent) {
                return floatValueX(eVar);
            }
            b a0 = eVar.a0();
            if (a0 == null) {
                return this.value;
            }
            float f = a0.c;
            float f2 = a0.d;
            if (f == f2) {
                return (this.value * f) / 100.0f;
            }
            return (this.value * ((float) (Math.sqrt((double) ((f * f) + (f2 * f2))) / 1.414213562373095d))) / 100.0f;
        }

        Length(float f) {
            this.value = f;
            this.unit = Unit.px;
        }

        /* access modifiers changed from: package-private */
        public float floatValue(e eVar, float f) {
            if (this.unit == Unit.percent) {
                return (this.value * f) / 100.0f;
            }
            return floatValueX(eVar);
        }

        /* access modifiers changed from: package-private */
        public float floatValue(float f) {
            int i = a.a[this.unit.ordinal()];
            if (i == 1) {
                return this.value;
            }
            switch (i) {
                case 4:
                    return this.value * f;
                case 5:
                    return (this.value * f) / 2.54f;
                case 6:
                    return (this.value * f) / 25.4f;
                case 7:
                    return (this.value * f) / 72.0f;
                case 8:
                    return (this.value * f) / 6.0f;
                default:
                    return this.value;
            }
        }
    }

    /* compiled from: Taobao */
    interface NotDirectlyRendered {
    }

    /* compiled from: Taobao */
    static class PaintReference extends SvgPaint {
        SvgPaint fallback;
        String href;

        PaintReference(String str, SvgPaint svgPaint) {
            this.href = str;
            this.fallback = svgPaint;
        }

        public String toString() {
            return this.href + " " + this.fallback;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface PathInterface {
        void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5);

        void close();

        void cubicTo(float f, float f2, float f3, float f4, float f5, float f6);

        void lineTo(float f, float f2);

        void moveTo(float f, float f2);

        void quadTo(float f, float f2, float f3, float f4);
    }

    /* compiled from: Taobao */
    static class Style implements Cloneable {
        static final int FONT_WEIGHT_BOLD = 700;
        static final int FONT_WEIGHT_BOLDER = 1;
        static final int FONT_WEIGHT_LIGHTER = -1;
        static final int FONT_WEIGHT_NORMAL = 400;
        c clip;
        String clipPath;
        FillRule clipRule;
        Colour color;
        TextDirection direction;
        Boolean display;
        SvgPaint fill;
        Float fillOpacity;
        FillRule fillRule;
        List<String> fontFamily;
        Length fontSize;
        FontStyle fontStyle;
        Integer fontWeight;
        RenderQuality imageRendering;
        boolean important = false;
        String markerEnd;
        String markerMid;
        String markerStart;
        String mask;
        Float opacity;
        Boolean overflow;
        SvgPaint solidColor;
        Float solidOpacity;
        long specifiedFlags = 0;
        SvgPaint stopColor;
        Float stopOpacity;
        SvgPaint stroke;
        Length[] strokeDashArray;
        Length strokeDashOffset;
        LineCap strokeLineCap;
        LineJoin strokeLineJoin;
        Float strokeMiterLimit;
        Float strokeOpacity;
        Length strokeWidth;
        TextAnchor textAnchor;
        TextDecoration textDecoration;
        VectorEffect vectorEffect;
        SvgPaint viewportFill;
        Float viewportFillOpacity;
        Boolean visibility;

        /* compiled from: Taobao */
        public enum FillRule {
            NonZero,
            EvenOdd
        }

        /* compiled from: Taobao */
        public enum FontStyle {
            Normal,
            Italic,
            Oblique
        }

        /* compiled from: Taobao */
        public enum LineCap {
            Butt,
            Round,
            Square
        }

        /* compiled from: Taobao */
        public enum LineJoin {
            Miter,
            Round,
            Bevel
        }

        /* compiled from: Taobao */
        public enum RenderQuality {
            auto,
            optimizeQuality,
            optimizeSpeed
        }

        /* compiled from: Taobao */
        public enum TextAnchor {
            Start,
            Middle,
            End
        }

        /* compiled from: Taobao */
        public enum TextDecoration {
            None,
            Underline,
            Overline,
            LineThrough,
            Blink
        }

        /* compiled from: Taobao */
        public enum TextDirection {
            LTR,
            RTL
        }

        /* compiled from: Taobao */
        public enum VectorEffect {
            None,
            NonScalingStroke
        }

        Style() {
        }

        static Style getDefaultStyle() {
            Style style = new Style();
            style.specifiedFlags = -1;
            style.important = false;
            Colour colour = Colour.BLACK;
            style.fill = colour;
            FillRule fillRule2 = FillRule.NonZero;
            style.fillRule = fillRule2;
            Float valueOf = Float.valueOf(1.0f);
            style.fillOpacity = valueOf;
            style.stroke = null;
            style.strokeOpacity = valueOf;
            style.strokeWidth = new Length(1.0f);
            style.strokeLineCap = LineCap.Butt;
            style.strokeLineJoin = LineJoin.Miter;
            style.strokeMiterLimit = Float.valueOf(4.0f);
            style.strokeDashArray = null;
            style.strokeDashOffset = new Length(0.0f);
            style.opacity = valueOf;
            style.color = colour;
            style.fontFamily = null;
            style.fontSize = new Length(12.0f, Unit.pt);
            style.fontWeight = 400;
            style.fontStyle = FontStyle.Normal;
            style.textDecoration = TextDecoration.None;
            style.direction = TextDirection.LTR;
            style.textAnchor = TextAnchor.Start;
            Boolean bool = Boolean.TRUE;
            style.overflow = bool;
            style.clip = null;
            style.markerStart = null;
            style.markerMid = null;
            style.markerEnd = null;
            style.display = bool;
            style.visibility = bool;
            style.stopColor = colour;
            style.stopOpacity = valueOf;
            style.clipPath = null;
            style.clipRule = fillRule2;
            style.mask = null;
            style.solidColor = null;
            style.solidOpacity = valueOf;
            style.viewportFill = null;
            style.viewportFillOpacity = valueOf;
            style.vectorEffect = VectorEffect.None;
            style.imageRendering = RenderQuality.auto;
            return style;
        }

        /* access modifiers changed from: protected */
        @Override // java.lang.Object
        public Object clone() throws CloneNotSupportedException {
            Style style = (Style) super.clone();
            Length[] lengthArr = this.strokeDashArray;
            if (lengthArr != null) {
                style.strokeDashArray = (Length[]) lengthArr.clone();
            }
            return style;
        }

        /* access modifiers changed from: package-private */
        public void resetNonInheritingProperties(boolean z) {
            Boolean bool = Boolean.TRUE;
            this.display = bool;
            if (!z) {
                bool = Boolean.FALSE;
            }
            this.overflow = bool;
            this.clip = null;
            this.clipPath = null;
            this.opacity = Float.valueOf(1.0f);
            this.stopColor = Colour.BLACK;
            this.stopOpacity = Float.valueOf(1.0f);
            this.mask = null;
            this.solidColor = null;
            this.solidOpacity = Float.valueOf(1.0f);
            this.viewportFill = null;
            this.viewportFillOpacity = Float.valueOf(1.0f);
            this.vectorEffect = VectorEffect.None;
        }
    }

    /* compiled from: Taobao */
    interface SvgConditional {
        String getRequiredExtensions();

        Set<String> getRequiredFeatures();

        Set<String> getRequiredFonts();

        Set<String> getRequiredFormats();

        Set<String> getSystemLanguage();

        void setRequiredExtensions(String str);

        void setRequiredFeatures(Set<String> set);

        void setRequiredFonts(Set<String> set);

        void setRequiredFormats(Set<String> set);

        void setSystemLanguage(Set<String> set);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface SvgContainer {
        void addChild(c0 c0Var) throws SVGParseException;

        List<c0> getChildren();
    }

    /* compiled from: Taobao */
    static abstract class SvgPaint implements Cloneable {
        SvgPaint() {
        }
    }

    /* compiled from: Taobao */
    interface TextChild {
        TextRoot getTextRoot();

        void setTextRoot(TextRoot textRoot);
    }

    /* compiled from: Taobao */
    interface TextRoot {
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum Unit {
        px,
        em,
        ex,
        in,
        cm,
        mm,
        pt,
        pc,
        percent
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[Unit.values().length];
            a = iArr;
            iArr[Unit.px.ordinal()] = 1;
            a[Unit.em.ordinal()] = 2;
            a[Unit.ex.ordinal()] = 3;
            a[Unit.in.ordinal()] = 4;
            a[Unit.cm.ordinal()] = 5;
            a[Unit.mm.ordinal()] = 6;
            a[Unit.pt.ordinal()] = 7;
            a[Unit.pc.ordinal()] = 8;
            try {
                a[Unit.percent.ordinal()] = 9;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static abstract class a0 extends c0 {
        String c = null;
        Boolean d = null;
        Style e = null;
        Style f = null;
        List<String> g = null;

        a0() {
        }

        public String toString() {
            return a();
        }
    }

    /* compiled from: Taobao */
    static class b0 extends h {
        Length m;
        Length n;
        Length o;
        Length p;

        b0() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "linearGradient";
        }
    }

    /* compiled from: Taobao */
    static class c {
        Length a;
        Length b;
        Length c;
        Length d;

        c(Length length, Length length2, Length length3, Length length4) {
            this.a = length;
            this.b = length2;
            this.c = length3;
            this.d = length4;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class c0 {
        SVG a;
        SvgContainer b;

        c0() {
        }

        /* access modifiers changed from: package-private */
        public String a() {
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class d extends i {
        Length o;
        Length p;
        Length q;

        d() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "circle";
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static abstract class d0 extends x {
        PreserveAspectRatio n = null;

        d0() {
        }
    }

    /* compiled from: Taobao */
    static class e extends j implements NotDirectlyRendered {
        Boolean o;

        e() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0, com.caverock.androidsvg.SVG.j
        public String a() {
            return "clipPath";
        }
    }

    /* compiled from: Taobao */
    static class e0 extends h {
        Length m;
        Length n;
        Length o;
        Length p;
        Length q;

        e0() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "radialGradient";
        }
    }

    /* compiled from: Taobao */
    static class f extends j implements NotDirectlyRendered {
        f() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0, com.caverock.androidsvg.SVG.j
        public String a() {
            return "defs";
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static abstract class f0 extends d0 {
        b o;

        f0() {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class g extends i {
        Length o;
        Length p;
        Length q;
        Length r;

        g() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "ellipse";
        }
    }

    /* compiled from: Taobao */
    static class g0 extends j {
        g0() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0, com.caverock.androidsvg.SVG.j
        public String a() {
            return "switch";
        }
    }

    /* compiled from: Taobao */
    static abstract class h extends a0 implements SvgContainer {
        List<c0> h = new ArrayList();
        Boolean i;
        Matrix j;
        GradientSpread k;
        String l;

        h() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(c0 c0Var) throws SVGParseException {
            if (c0Var instanceof v) {
                this.h.add(c0Var);
                return;
            }
            throw new SVGParseException("Gradient elements cannot contain " + c0Var + " elements.");
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<c0> getChildren() {
            return this.h;
        }
    }

    /* compiled from: Taobao */
    static class h0 extends f0 implements NotDirectlyRendered {
        h0() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "symbol";
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static abstract class i extends y implements HasTransform {
        Matrix n;

        i() {
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix matrix) {
            this.n = matrix;
        }
    }

    /* compiled from: Taobao */
    static class i0 extends l0 implements TextChild {
        String n;
        private TextRoot o;

        i0() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "tref";
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.o;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public void setTextRoot(TextRoot textRoot) {
            this.o = textRoot;
        }
    }

    /* compiled from: Taobao */
    static class j extends x implements HasTransform {
        Matrix n;

        j() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return SolidMonitor.CHECK_TYPE_GROUP;
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix matrix) {
            this.n = matrix;
        }
    }

    /* compiled from: Taobao */
    static class j0 extends n0 implements TextChild {
        private TextRoot r;

        j0() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "tspan";
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.r;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public void setTextRoot(TextRoot textRoot) {
            this.r = textRoot;
        }
    }

    /* compiled from: Taobao */
    static class k extends d0 implements HasTransform {
        String o;
        Length p;
        Length q;
        Length r;
        Length s;
        Matrix t;

        k() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "image";
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix matrix) {
            this.t = matrix;
        }
    }

    /* compiled from: Taobao */
    static class k0 extends n0 implements HasTransform, TextRoot {
        Matrix r;

        k0() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "text";
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix matrix) {
            this.r = matrix;
        }
    }

    /* compiled from: Taobao */
    static class l extends i {
        Length o;
        Length p;
        Length q;
        Length r;

        l() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "line";
        }
    }

    /* compiled from: Taobao */
    static abstract class l0 extends x {
        l0() {
        }

        @Override // com.caverock.androidsvg.SVG.x, com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(c0 c0Var) throws SVGParseException {
            if (c0Var instanceof TextChild) {
                this.i.add(c0Var);
                return;
            }
            throw new SVGParseException("Text content elements cannot contain " + c0Var + " elements.");
        }
    }

    /* compiled from: Taobao */
    static class m extends f0 implements NotDirectlyRendered {
        boolean p;
        Length q;
        Length r;
        Length s;
        Length t;
        Float u;

        m() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "marker";
        }
    }

    /* compiled from: Taobao */
    static class m0 extends l0 implements TextChild {
        String n;
        Length o;
        private TextRoot p;

        m0() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "textPath";
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.p;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public void setTextRoot(TextRoot textRoot) {
            this.p = textRoot;
        }
    }

    /* compiled from: Taobao */
    static class n extends x implements NotDirectlyRendered {
        Boolean n;
        Boolean o;
        Length p;
        Length q;
        Length r;
        Length s;

        n() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "mask";
        }
    }

    /* compiled from: Taobao */
    static abstract class n0 extends l0 {
        List<Length> n;
        List<Length> o;
        List<Length> p;
        List<Length> q;

        n0() {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class o extends i {
        p o;
        Float p;

        o() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return com.alibaba.security.realidentity.jsbridge.a.V;
        }
    }

    /* compiled from: Taobao */
    static class o0 extends c0 implements TextChild {
        String c;
        private TextRoot d;

        o0(String str) {
            this.c = str;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.d;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public void setTextRoot(TextRoot textRoot) {
            this.d = textRoot;
        }

        public String toString() {
            return "TextChild: '" + this.c + "'";
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class p implements PathInterface {
        private byte[] a = new byte[8];
        private int b = 0;
        private float[] c = new float[16];
        private int d = 0;

        p() {
        }

        private void a(byte b2) {
            int i = this.b;
            byte[] bArr = this.a;
            if (i == bArr.length) {
                byte[] bArr2 = new byte[(bArr.length * 2)];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                this.a = bArr2;
            }
            byte[] bArr3 = this.a;
            int i2 = this.b;
            this.b = i2 + 1;
            bArr3[i2] = b2;
        }

        private void b(int i) {
            float[] fArr = this.c;
            if (fArr.length < this.d + i) {
                float[] fArr2 = new float[(fArr.length * 2)];
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                this.c = fArr2;
            }
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            a((byte) ((z ? 2 : 0) | 4 | (z2 ? 1 : 0)));
            b(5);
            float[] fArr = this.c;
            int i = this.d;
            int i2 = i + 1;
            this.d = i2;
            fArr[i] = f;
            int i3 = i2 + 1;
            this.d = i3;
            fArr[i2] = f2;
            int i4 = i3 + 1;
            this.d = i4;
            fArr[i3] = f3;
            int i5 = i4 + 1;
            this.d = i5;
            fArr[i4] = f4;
            this.d = i5 + 1;
            fArr[i5] = f5;
        }

        /* access modifiers changed from: package-private */
        public void c(PathInterface pathInterface) {
            int i;
            int i2 = 0;
            for (int i3 = 0; i3 < this.b; i3++) {
                byte b2 = this.a[i3];
                if (b2 == 0) {
                    float[] fArr = this.c;
                    int i4 = i2 + 1;
                    i = i4 + 1;
                    pathInterface.moveTo(fArr[i2], fArr[i4]);
                } else if (b2 != 1) {
                    if (b2 == 2) {
                        float[] fArr2 = this.c;
                        int i5 = i2 + 1;
                        float f = fArr2[i2];
                        int i6 = i5 + 1;
                        float f2 = fArr2[i5];
                        int i7 = i6 + 1;
                        float f3 = fArr2[i6];
                        int i8 = i7 + 1;
                        float f4 = fArr2[i7];
                        int i9 = i8 + 1;
                        float f5 = fArr2[i8];
                        i2 = i9 + 1;
                        pathInterface.cubicTo(f, f2, f3, f4, f5, fArr2[i9]);
                    } else if (b2 == 3) {
                        float[] fArr3 = this.c;
                        int i10 = i2 + 1;
                        int i11 = i10 + 1;
                        int i12 = i11 + 1;
                        pathInterface.quadTo(fArr3[i2], fArr3[i10], fArr3[i11], fArr3[i12]);
                        i2 = i12 + 1;
                    } else if (b2 != 8) {
                        boolean z = (b2 & 2) != 0;
                        boolean z2 = (b2 & 1) != 0;
                        float[] fArr4 = this.c;
                        int i13 = i2 + 1;
                        float f6 = fArr4[i2];
                        int i14 = i13 + 1;
                        float f7 = fArr4[i13];
                        int i15 = i14 + 1;
                        float f8 = fArr4[i14];
                        int i16 = i15 + 1;
                        pathInterface.arcTo(f6, f7, f8, z, z2, fArr4[i15], fArr4[i16]);
                        i2 = i16 + 1;
                    } else {
                        pathInterface.close();
                    }
                } else {
                    float[] fArr5 = this.c;
                    int i17 = i2 + 1;
                    i = i17 + 1;
                    pathInterface.lineTo(fArr5[i2], fArr5[i17]);
                }
                i2 = i;
            }
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void close() {
            a((byte) 8);
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
            a((byte) 2);
            b(6);
            float[] fArr = this.c;
            int i = this.d;
            int i2 = i + 1;
            this.d = i2;
            fArr[i] = f;
            int i3 = i2 + 1;
            this.d = i3;
            fArr[i2] = f2;
            int i4 = i3 + 1;
            this.d = i4;
            fArr[i3] = f3;
            int i5 = i4 + 1;
            this.d = i5;
            fArr[i4] = f4;
            int i6 = i5 + 1;
            this.d = i6;
            fArr[i5] = f5;
            this.d = i6 + 1;
            fArr[i6] = f6;
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            return this.b == 0;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void lineTo(float f, float f2) {
            a((byte) 1);
            b(2);
            float[] fArr = this.c;
            int i = this.d;
            int i2 = i + 1;
            this.d = i2;
            fArr[i] = f;
            this.d = i2 + 1;
            fArr[i2] = f2;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void moveTo(float f, float f2) {
            a((byte) 0);
            b(2);
            float[] fArr = this.c;
            int i = this.d;
            int i2 = i + 1;
            this.d = i2;
            fArr[i] = f;
            this.d = i2 + 1;
            fArr[i2] = f2;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void quadTo(float f, float f2, float f3, float f4) {
            a((byte) 3);
            b(4);
            float[] fArr = this.c;
            int i = this.d;
            int i2 = i + 1;
            this.d = i2;
            fArr[i] = f;
            int i3 = i2 + 1;
            this.d = i3;
            fArr[i2] = f2;
            int i4 = i3 + 1;
            this.d = i4;
            fArr[i3] = f3;
            this.d = i4 + 1;
            fArr[i4] = f4;
        }
    }

    /* compiled from: Taobao */
    static class p0 extends j {
        String o;
        Length p;
        Length q;
        Length r;
        Length s;

        p0() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0, com.caverock.androidsvg.SVG.j
        public String a() {
            return "use";
        }
    }

    /* compiled from: Taobao */
    static class q extends f0 implements NotDirectlyRendered {
        Boolean p;
        Boolean q;
        Matrix r;
        Length s;
        Length t;
        Length u;
        Length v;
        String w;

        q() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "pattern";
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class q0 extends f0 implements NotDirectlyRendered {
        q0() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "view";
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class r extends i {
        float[] o;

        r() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "polyline";
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class s extends r {
        s() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.r, com.caverock.androidsvg.SVG.c0
        public String a() {
            return "polygon";
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class t extends i {
        Length o;
        Length p;
        Length q;
        Length r;
        Length s;
        Length t;

        t() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "rect";
        }
    }

    /* compiled from: Taobao */
    static class u extends a0 implements SvgContainer {
        u() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "solidColor";
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(c0 c0Var) {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<c0> getChildren() {
            return Collections.emptyList();
        }
    }

    /* compiled from: Taobao */
    static class v extends a0 implements SvgContainer {
        Float h;

        v() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "stop";
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(c0 c0Var) {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<c0> getChildren() {
            return Collections.emptyList();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class w extends f0 {
        Length p;
        Length q;
        Length r;
        Length s;
        public String t;

        w() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.c0
        public String a() {
            return "svg";
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static abstract class x extends z implements SvgConditional, SvgContainer {
        List<c0> i = new ArrayList();
        Set<String> j = null;
        String k = null;
        Set<String> l = null;
        Set<String> m = null;

        x() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(c0 c0Var) throws SVGParseException {
            this.i.add(c0Var);
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<c0> getChildren() {
            return this.i;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public String getRequiredExtensions() {
            return this.k;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFeatures() {
            return this.j;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFonts() {
            return this.m;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFormats() {
            return this.l;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getSystemLanguage() {
            return null;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredExtensions(String str) {
            this.k = str;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFeatures(Set<String> set) {
            this.j = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFonts(Set<String> set) {
            this.m = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFormats(Set<String> set) {
            this.l = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setSystemLanguage(Set<String> set) {
        }
    }

    /* compiled from: Taobao */
    static abstract class y extends z implements SvgConditional {
        Set<String> i = null;
        String j = null;
        Set<String> k = null;
        Set<String> l = null;
        Set<String> m = null;

        y() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public String getRequiredExtensions() {
            return this.j;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFeatures() {
            return this.i;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFonts() {
            return this.m;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFormats() {
            return this.l;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getSystemLanguage() {
            return this.k;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredExtensions(String str) {
            this.j = str;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFeatures(Set<String> set) {
            this.i = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFonts(Set<String> set) {
            this.m = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFormats(Set<String> set) {
            this.l = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setSystemLanguage(Set<String> set) {
            this.k = set;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static abstract class z extends a0 {
        b h = null;

        z() {
        }
    }

    SVG() {
    }

    private String c(String str) {
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1).replace("\\\"", "\"");
        } else if (str.startsWith("'") && str.endsWith("'")) {
            str = str.substring(1, str.length() - 1).replace("\\'", "'");
        }
        return str.replace("\\\n", "").replace("\\A", StringUtils.LF);
    }

    private a0 e(SvgContainer svgContainer, String str) {
        a0 e2;
        a0 a0Var = (a0) svgContainer;
        if (str.equals(a0Var.c)) {
            return a0Var;
        }
        for (c0 c0Var : svgContainer.getChildren()) {
            if (c0Var instanceof a0) {
                a0 a0Var2 = (a0) c0Var;
                if (str.equals(a0Var2.c)) {
                    return a0Var2;
                }
                if ((c0Var instanceof SvgContainer) && (e2 = e((SvgContainer) c0Var, str)) != null) {
                    return e2;
                }
            }
        }
        return null;
    }

    static j32 g() {
        return e;
    }

    public static SVG h(InputStream inputStream) throws SVGParseException {
        return new SVGParser().z(inputStream, f);
    }

    public static SVG i(Context context, int i2) throws SVGParseException {
        return j(context.getResources(), i2);
    }

    public static SVG j(Resources resources, int i2) throws SVGParseException {
        SVGParser sVGParser = new SVGParser();
        InputStream openRawResource = resources.openRawResource(i2);
        try {
            return sVGParser.z(openRawResource, f);
        } finally {
            try {
                openRawResource.close();
            } catch (IOException unused) {
            }
        }
    }

    public static SVG k(String str) throws SVGParseException {
        return new SVGParser().z(new ByteArrayInputStream(str.getBytes()), f);
    }

    /* access modifiers changed from: package-private */
    public void a(CSSParser.m mVar) {
        this.c.b(mVar);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.c.e(CSSParser.Source.RenderOptions);
    }

    /* access modifiers changed from: package-private */
    public List<CSSParser.k> d() {
        return this.c.c();
    }

    /* access modifiers changed from: package-private */
    public a0 f(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.equals(this.a.c)) {
            return this.a;
        }
        if (this.d.containsKey(str)) {
            return this.d.get(str);
        }
        a0 e2 = e(this.a, str);
        this.d.put(str, e2);
        return e2;
    }

    /* access modifiers changed from: package-private */
    public w l() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return !this.c.d();
    }

    public Picture n(int i2, int i3, d dVar) {
        Picture picture = new Picture();
        Canvas beginRecording = picture.beginRecording(i2, i3);
        if (dVar == null || dVar.f == null) {
            dVar = dVar == null ? new d() : new d(dVar);
            dVar.h(0.0f, 0.0f, (float) i2, (float) i3);
        }
        new e(beginRecording, this.b).O0(this, dVar);
        picture.endRecording();
        return picture;
    }

    public Picture o(d dVar) {
        b bVar;
        Unit unit;
        Length length;
        if (dVar == null || !dVar.f()) {
            w wVar = this.a;
            bVar = wVar != null ? wVar.o : null;
        } else {
            bVar = dVar.d;
        }
        if (dVar != null && dVar.g()) {
            return n((int) Math.ceil((double) dVar.f.b()), (int) Math.ceil((double) dVar.f.c()), dVar);
        }
        w wVar2 = this.a;
        Length length2 = wVar2.r;
        if (length2 != null && length2.unit != (unit = Unit.percent) && (length = wVar2.s) != null && length.unit != unit) {
            return n((int) Math.ceil((double) length2.floatValue(this.b)), (int) Math.ceil((double) this.a.s.floatValue(this.b)), dVar);
        }
        if (length2 == null || bVar == null) {
            Length length3 = wVar2.s;
            if (length3 == null || bVar == null) {
                if (bVar != null) {
                    float f2 = bVar.c;
                    if (f2 > 0.0f) {
                        float f3 = bVar.d;
                        if (f3 > 0.0f) {
                            return n((int) f2, (int) f3, dVar);
                        }
                    }
                }
                return n(512, 512, dVar);
            }
            float floatValue = length3.floatValue(this.b);
            return n((int) Math.ceil((double) ((bVar.c * floatValue) / bVar.d)), (int) Math.ceil((double) floatValue), dVar);
        }
        float floatValue2 = length2.floatValue(this.b);
        return n((int) Math.ceil((double) floatValue2), (int) Math.ceil((double) ((bVar.d * floatValue2) / bVar.c)), dVar);
    }

    /* access modifiers changed from: package-private */
    public c0 p(String str) {
        if (str == null) {
            return null;
        }
        String c2 = c(str);
        if (c2.length() <= 1 || !c2.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
            return null;
        }
        return f(c2.substring(1));
    }

    /* access modifiers changed from: package-private */
    public void q(String str) {
    }

    /* access modifiers changed from: package-private */
    public void r(w wVar) {
        this.a = wVar;
    }

    /* access modifiers changed from: package-private */
    public void s(String str) {
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b {
        float a;
        float b;
        float c;
        float d;

        b(float f, float f2, float f3, float f4) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
        }

        static b a(float f, float f2, float f3, float f4) {
            return new b(f, f2, f3 - f, f4 - f2);
        }

        /* access modifiers changed from: package-private */
        public float b() {
            return this.a + this.c;
        }

        /* access modifiers changed from: package-private */
        public float c() {
            return this.b + this.d;
        }

        /* access modifiers changed from: package-private */
        public void d(b bVar) {
            float f = bVar.a;
            if (f < this.a) {
                this.a = f;
            }
            float f2 = bVar.b;
            if (f2 < this.b) {
                this.b = f2;
            }
            if (bVar.b() > b()) {
                this.c = bVar.b() - this.a;
            }
            if (bVar.c() > c()) {
                this.d = bVar.c() - this.b;
            }
        }

        public String toString() {
            return jl1.ARRAY_START_STR + this.a + " " + this.b + " " + this.c + " " + this.d + jl1.ARRAY_END_STR;
        }

        b(b bVar) {
            this.a = bVar.a;
            this.b = bVar.b;
            this.c = bVar.c;
            this.d = bVar.d;
        }
    }
}
