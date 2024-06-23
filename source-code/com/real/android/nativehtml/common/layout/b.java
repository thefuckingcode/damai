package com.real.android.nativehtml.common.layout;

import com.real.android.nativehtml.common.css.CssEnum;
import com.real.android.nativehtml.common.css.CssProperty;
import com.real.android.nativehtml.common.layout.Layout;
import tb.jp;

/* compiled from: Taobao */
public class b {
    public static float a(ComponentElement componentElement, float f, float f2) {
        jp computedStyle = componentElement.getComputedStyle();
        return computedStyle.g(CssProperty.BORDER_TOP_WIDTH, f2) + computedStyle.g(CssProperty.PADDING_TOP, f2) + d(componentElement, f, f2) + computedStyle.g(CssProperty.PADDING_BOTTOM, f2) + computedStyle.g(CssProperty.BORDER_BOTTOM_WIDTH, f2);
    }

    public static float[] b(ComponentElement componentElement, Layout.Directive directive, float f) {
        float e = e(componentElement, directive, f);
        jp computedStyle = componentElement.getComputedStyle();
        return new float[]{computedStyle.g(CssProperty.BORDER_LEFT_WIDTH, f) + computedStyle.g(CssProperty.PADDING_LEFT, f) + e + computedStyle.g(CssProperty.PADDING_RIGHT, f) + computedStyle.g(CssProperty.BORDER_RIGHT_WIDTH, f), a(componentElement, e, f)};
    }

    public static float c(ComponentElement componentElement, Layout.Directive directive, float f) {
        jp computedStyle = componentElement.getComputedStyle();
        return computedStyle.g(CssProperty.BORDER_LEFT_WIDTH, f) + computedStyle.g(CssProperty.PADDING_LEFT, f) + e(componentElement, directive, f) + computedStyle.g(CssProperty.PADDING_RIGHT, f) + computedStyle.g(CssProperty.BORDER_RIGHT_WIDTH, f);
    }

    public static float d(ComponentElement componentElement, float f, float f2) {
        jp computedStyle = componentElement.getComputedStyle();
        CssProperty cssProperty = CssProperty.HEIGHT;
        if (computedStyle.k(cssProperty)) {
            return computedStyle.g(cssProperty, f2);
        }
        return componentElement.getIntrinsicContentBoxHeightForWidth(f, f2);
    }

    public static float e(ComponentElement componentElement, Layout.Directive directive, float f) {
        jp computedStyle = componentElement.getComputedStyle();
        CssProperty cssProperty = CssProperty.WIDTH;
        if (computedStyle.k(cssProperty)) {
            return computedStyle.g(cssProperty, f);
        }
        float g = (((((f - computedStyle.g(CssProperty.MARGIN_LEFT, f)) - computedStyle.g(CssProperty.BORDER_LEFT_WIDTH, f)) - computedStyle.g(CssProperty.PADDING_LEFT, f)) - computedStyle.g(CssProperty.PADDING_RIGHT, f)) - computedStyle.g(CssProperty.BORDER_RIGHT_WIDTH, f)) - computedStyle.g(CssProperty.MARGIN_RIGHT, f);
        if (computedStyle.f(CssProperty.DISPLAY) == CssEnum.BLOCK && directive == Layout.Directive.STRETCH) {
            return g;
        }
        return Math.min(g, componentElement.getIntrinsicContentBoxWidth(directive, g));
    }

    public static boolean f(ComponentElement componentElement) {
        jp computedStyle = componentElement.getComputedStyle();
        CssEnum f = computedStyle.f(CssProperty.DISPLAY);
        return f == CssEnum.NONE || ((f == CssEnum.BLOCK || f == CssEnum.TABLE) && computedStyle.f(CssProperty.POSITION) == CssEnum.ABSOLUTE);
    }

    public static boolean g(ComponentElement componentElement, float f, float f2, float f3, boolean z, ComponentElement componentElement2) {
        float f4;
        boolean f5 = f(componentElement2);
        if (!f5 || z || componentElement2.getComputedStyle().f(CssProperty.DISPLAY) == CssEnum.NONE) {
            return f5;
        }
        jp computedStyle = componentElement2.getComputedStyle();
        float g = computedStyle.g(CssProperty.BORDER_LEFT_WIDTH, f3) + computedStyle.g(CssProperty.PADDING_LEFT, f3);
        float g2 = computedStyle.g(CssProperty.BORDER_RIGHT_WIDTH, f3) + computedStyle.g(CssProperty.PADDING_RIGHT, f3);
        float g3 = computedStyle.g(CssProperty.BORDER_TOP_WIDTH, f3) + computedStyle.g(CssProperty.PADDING_TOP, f3);
        float g4 = computedStyle.g(CssProperty.BORDER_BOTTOM_WIDTH, f3) + computedStyle.g(CssProperty.PADDING_BOTTOM, f3);
        float e = e(componentElement2, Layout.Directive.MINIMUM, f3);
        float f6 = g2 + g + e;
        float d = g4 + d(componentElement2, e, f3) + g3;
        CssProperty cssProperty = CssProperty.LEFT;
        if (computedStyle.k(cssProperty)) {
            f4 = computedStyle.g(cssProperty, f3) + f;
        } else {
            CssProperty cssProperty2 = CssProperty.RIGHT;
            f4 = computedStyle.k(cssProperty2) ? ((f + f3) - f6) - computedStyle.g(cssProperty2, f3) : f;
        }
        CssProperty cssProperty3 = CssProperty.TOP;
        if (computedStyle.k(cssProperty3)) {
            g3 = computedStyle.g(cssProperty3, f3) + f2;
        }
        componentElement2.setBorderBoxBounds(f4, g3, f6, d, f3);
        return true;
    }
}
