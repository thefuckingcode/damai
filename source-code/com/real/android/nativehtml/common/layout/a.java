package com.real.android.nativehtml.common.layout;

import com.real.android.nativehtml.common.css.CssEnum;
import com.real.android.nativehtml.common.css.CssProperty;
import com.real.android.nativehtml.common.dom.Element;
import com.real.android.nativehtml.common.dom.HtmlCollection;
import com.real.android.nativehtml.common.layout.Layout;
import tb.jp;

/* compiled from: Taobao */
public class a implements Layout {

    /* access modifiers changed from: package-private */
    /* renamed from: com.real.android.nativehtml.common.layout.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class C0193a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[CssEnum.values().length];
            a = iArr;
            iArr[CssEnum.TOP.ordinal()] = 1;
            a[CssEnum.BOTTOM.ordinal()] = 2;
        }
    }

    private static void a(Element element, StringBuilder sb, float f, float f2, float f3) {
        float f4;
        if (sb != null) {
            CssEnum f5 = element.getComputedStyle().f(CssProperty.TEXT_ALIGN);
            CssEnum f6 = element.getComputedStyle().f(CssProperty.VERTICAL_ALIGN);
            if (f5 == CssEnum.RIGHT) {
                f4 = f2 - f;
            } else {
                f4 = f5 == CssEnum.CENTER ? (f2 - f) / 2.0f : 0.0f;
            }
            for (int i = 0; i < sb.length(); i += 2) {
                char charAt = sb.charAt(i);
                float charAt2 = (float) sb.charAt(i + 1);
                int i2 = C0193a.a[f6.ordinal()];
                ((ComponentElement) element.getChildren().item(charAt)).moveRelative(f4, i2 != 1 ? i2 != 2 ? (f3 - charAt2) / 2.0f : f3 - charAt2 : 0.0f);
            }
            sb.setLength(0);
        }
    }

    @Override // com.real.android.nativehtml.common.layout.Layout
    public float layout(ComponentElement componentElement, float f, float f2, float f3, boolean z) {
        StringBuilder sb;
        ComponentElement componentElement2;
        float f4;
        float f5;
        HtmlCollection children = componentElement.getChildren();
        if (z) {
            sb = null;
        } else {
            sb = new StringBuilder();
        }
        int i = 0;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        while (i < componentElement.getChildren().getLength()) {
            ComponentElement componentElement3 = (ComponentElement) children.item(i);
            jp computedStyle = componentElement3.getComputedStyle();
            CssEnum f10 = computedStyle.f(CssProperty.DISPLAY);
            if (!b.g(componentElement, f, f2, f3, z, componentElement3)) {
                float g = computedStyle.g(CssProperty.MARGIN_LEFT, f3);
                float g2 = computedStyle.g(CssProperty.MARGIN_RIGHT, f3);
                if (f10 == CssEnum.BLOCK || f10 == CssEnum.TABLE || f10 == CssEnum.LIST_ITEM) {
                    componentElement2 = componentElement3;
                    if (f6 > 0.0f) {
                        a(componentElement, sb, f6 - f, f3, f7);
                        f8 += f7;
                        f6 = 0.0f;
                        f7 = 0.0f;
                    }
                    float max = f8 + Math.max(f9, computedStyle.g(CssProperty.MARGIN_TOP, f3));
                    Layout.Directive directive = Layout.Directive.STRETCH;
                    float e = b.e(componentElement2, directive, f3);
                    float c = b.c(componentElement2, directive, f3);
                    float a = b.a(componentElement2, e, f3);
                    if (!z) {
                        componentElement2.setBorderBoxBounds(f + g, max + f, c, a, f3);
                    }
                    f8 = max + a;
                    f9 = computedStyle.g(CssProperty.MARGIN_BOTTOM, f3);
                } else {
                    int i2 = (f6 > 0.0f ? 1 : (f6 == 0.0f ? 0 : -1));
                    if (i2 == 0) {
                        f8 += f9;
                        f9 = 0.0f;
                    }
                    Layout.Directive directive2 = Layout.Directive.FIT_CONTENT;
                    componentElement2 = componentElement3;
                    float e2 = b.e(componentElement2, directive2, f3);
                    float c2 = b.c(componentElement2, directive2, f3);
                    float f11 = g + c2 + g2;
                    float a2 = b.a(componentElement2, e2, f3);
                    if (i2 > 0 && f6 + f11 > f3) {
                        a(componentElement, sb, f6, f3, f7);
                        f8 += f7;
                        f6 = 0.0f;
                    }
                    if (!z) {
                        float f12 = f8 + f2;
                        f4 = f8;
                        f5 = a2;
                        componentElement2.setBorderBoxBounds(f6 + f + g, f12, c2, a2, f3);
                        sb.append((char) i);
                        sb.append((char) ((int) f5));
                    } else {
                        f4 = f8;
                        f5 = a2;
                    }
                    f6 += f11;
                    f7 = Math.max(f7, f5);
                    f8 = f4;
                }
                if (computedStyle.f(CssProperty.POSITION) == CssEnum.RELATIVE) {
                    float g3 = computedStyle.g(CssProperty.LEFT, f3) - computedStyle.g(CssProperty.RIGHT, f3);
                    float g4 = computedStyle.g(CssProperty.TOP, f3) - computedStyle.g(CssProperty.BOTTOM, f3);
                    if (g3 != 0.0f || g4 != 0.0f) {
                        componentElement2.moveRelative(g3, g4);
                    }
                }
            }
            i++;
            children = children;
        }
        if (f6 > 0.0f) {
            a(componentElement, sb, f6, f3, f7);
            f8 += f7;
        }
        return f8 + f9;
    }

    @Override // com.real.android.nativehtml.common.layout.Layout
    public float measureWidth(ComponentElement componentElement, Layout.Directive directive, float f) {
        HtmlCollection children = componentElement.getChildren();
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i = 0; i < children.getLength(); i++) {
            ComponentElement componentElement2 = (ComponentElement) componentElement.getChildren().item(i);
            jp computedStyle = componentElement2.getComputedStyle();
            CssEnum f4 = computedStyle.f(CssProperty.DISPLAY);
            if (!b.f(componentElement2)) {
                float g = computedStyle.g(CssProperty.MARGIN_LEFT, f);
                float g2 = computedStyle.g(CssProperty.MARGIN_RIGHT, f);
                if (f4 == CssEnum.BLOCK || f4 == CssEnum.TABLE || f4 == CssEnum.LIST_ITEM || directive == Layout.Directive.MINIMUM) {
                    if (f2 > 0.0f) {
                        f3 = Math.max(f2, f3);
                    }
                    f3 = Math.max(f3, g + b.c(componentElement2, directive, f) + g2);
                } else {
                    f2 += g + b.c(componentElement2, Layout.Directive.FIT_CONTENT, f) + g2;
                }
            }
        }
        return Math.max(f2, f3);
    }
}
