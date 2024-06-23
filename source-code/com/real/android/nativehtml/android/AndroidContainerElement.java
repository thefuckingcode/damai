package com.real.android.nativehtml.android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.real.android.nativehtml.common.css.CssEnum;
import com.real.android.nativehtml.common.css.CssProperty;
import com.real.android.nativehtml.common.dom.ContentType;
import com.real.android.nativehtml.common.dom.Element;
import com.real.android.nativehtml.common.dom.HtmlCollection;
import com.real.android.nativehtml.common.layout.Layout;
import com.real.android.nativehtml.common.layout.a;
import com.real.android.nativehtml.common.layout.c;
import tb.cg2;
import tb.jp;
import tb.sa0;

/* compiled from: Taobao */
public class AndroidContainerElement extends AbstractAndroidComponentElement implements HtmlCollection {
    Layout layout;

    public AndroidContainerElement(Context context, sa0 sa0, String str) {
        super(context, sa0, str);
    }

    private Layout getLayout() {
        if (this.layout == null) {
            if (getLocalName().equals("table")) {
                this.layout = new c();
            } else {
                this.layout = new a();
            }
        }
        return this.layout;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public HtmlCollection getChildren() {
        return this;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public ContentType getElementContentType() {
        return ContentType.COMPONENTS;
    }

    @Override // com.real.android.nativehtml.common.layout.ComponentElement
    public float getIntrinsicContentBoxHeightForWidth(float f, float f2) {
        return getLayout().layout(this, 0.0f, 0.0f, f, true);
    }

    @Override // com.real.android.nativehtml.common.layout.ComponentElement
    public float getIntrinsicContentBoxWidth(Layout.Directive directive, float f) {
        return getLayout().measureWidth(this, directive, f);
    }

    @Override // com.real.android.nativehtml.common.dom.HtmlCollection
    public int getLength() {
        return getChildCount();
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public void insertBefore(Element element, Element element2) {
        if (element2 == null) {
            addView((View) element);
            return;
        }
        addView((View) element, indexOfChild((View) element2));
    }

    @Override // com.real.android.nativehtml.common.dom.HtmlCollection
    public Element item(int i) {
        return (Element) getChildAt(i);
    }

    @Override // com.real.android.nativehtml.android.AbstractAndroidComponentElement
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        CssEnum f = getComputedStyle().f(CssProperty.LIST_STYLE_TYPE);
        float a = getOwnerDocument().h().a();
        int i = 1;
        Paint.FontMetrics fontMetrics = null;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            jp computedStyle = ((Element) childAt).getComputedStyle();
            if (computedStyle.f(CssProperty.DISPLAY) == CssEnum.LIST_ITEM && f != CssEnum.NONE) {
                if (fontMetrics == null) {
                    fontMetrics = new Paint.FontMetrics();
                }
                int i3 = i + 1;
                String a2 = cg2.a(f, i);
                a.f(computedStyle, a, this.paint);
                this.paint.getFontMetrics(fontMetrics);
                float g = computedStyle.g(CssProperty.BORDER_TOP_WIDTH, 0.0f) + computedStyle.g(CssProperty.PADDING_TOP, 0.0f);
                canvas.drawText(a2, (childAt.getX() + ((computedStyle.g(CssProperty.BORDER_LEFT_WIDTH, 0.0f) + computedStyle.g(CssProperty.PADDING_LEFT, 0.0f)) * a)) - this.paint.measureText(a2), (childAt.getY() + (g * a)) - fontMetrics.top, this.paint);
                i = i3;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float a = getOwnerDocument().h().a();
        if (!getLocalName().equals("tr")) {
            jp computedStyle = getComputedStyle();
            float g = computedStyle.g(CssProperty.BORDER_LEFT_WIDTH, this.containingBoxWidth) + computedStyle.g(CssProperty.PADDING_LEFT, this.containingBoxWidth);
            Layout layout2 = getLayout();
            layout2.layout(this, g, computedStyle.g(CssProperty.BORDER_TOP_WIDTH, this.containingBoxWidth) + computedStyle.g(CssProperty.PADDING_TOP, this.containingBoxWidth), ((((float) (i3 - i)) / a) - g) - (computedStyle.g(CssProperty.BORDER_RIGHT_WIDTH, this.containingBoxWidth) + computedStyle.g(CssProperty.PADDING_RIGHT, this.containingBoxWidth)), false);
        }
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            float f3 = 0.0f;
            if (childAt instanceof AbstractAndroidComponentElement) {
                AbstractAndroidComponentElement abstractAndroidComponentElement = (AbstractAndroidComponentElement) childAt;
                f3 = abstractAndroidComponentElement.x * a;
                f2 = abstractAndroidComponentElement.y;
            } else if (childAt instanceof AndroidTextComponent) {
                AndroidTextComponent androidTextComponent = (AndroidTextComponent) childAt;
                f3 = androidTextComponent.x * a;
                f2 = androidTextComponent.y;
            } else {
                f = 0.0f;
                childAt.layout(Math.round(f3), Math.round(f), Math.round(f3 + ((float) childAt.getMeasuredWidth())), Math.round(f + ((float) childAt.getMeasuredHeight())));
            }
            f = f2 * a;
            childAt.layout(Math.round(f3), Math.round(f), Math.round(f3 + ((float) childAt.getMeasuredWidth())), Math.round(f + ((float) childAt.getMeasuredHeight())));
        }
    }

    public void onMeasure(int i, int i2) {
        float f;
        if (!(getParent() instanceof AndroidContainerElement)) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            float a = getOwnerDocument().h().a();
            float f2 = ((float) size) / a;
            jp computedStyle = getComputedStyle();
            float g = computedStyle.g(CssProperty.BORDER_LEFT_WIDTH, f2) + computedStyle.g(CssProperty.PADDING_LEFT, f2);
            float g2 = computedStyle.g(CssProperty.BORDER_TOP_WIDTH, f2) + computedStyle.g(CssProperty.PADDING_TOP, f2);
            float g3 = computedStyle.g(CssProperty.BORDER_BOTTOM_WIDTH, f2) + computedStyle.g(CssProperty.PADDING_BOTTOM, f2);
            float g4 = computedStyle.g(CssProperty.PADDING_RIGHT, f2) + computedStyle.g(CssProperty.BORDER_RIGHT_WIDTH, f2);
            if (mode == 1073741824) {
                f = (f2 - g) - g4;
            } else {
                f = getLayout().measureWidth(this, mode == Integer.MIN_VALUE ? Layout.Directive.MINIMUM : Layout.Directive.FIT_CONTENT, f2);
            }
            setMeasuredDimension(Math.round((g + f + g4) * a), Math.round((g2 + getLayout().layout(this, g, g2, f, true) + g3) * a));
            return;
        }
        throw new RuntimeException("onMeasure expected for root HTML container only");
    }
}
