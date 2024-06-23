package com.real.android.nativehtml.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.ViewGroup;
import com.real.android.nativehtml.common.css.CssEnum;
import com.real.android.nativehtml.common.css.CssProperty;
import com.real.android.nativehtml.common.dom.Element;
import com.real.android.nativehtml.common.dom.ElementType;
import com.real.android.nativehtml.common.layout.ComponentElement;
import java.util.HashMap;
import tb.jp;
import tb.sa0;
import tb.vc0;

/* compiled from: Taobao */
public abstract class AbstractAndroidComponentElement extends ViewGroup implements ComponentElement {
    private HashMap<String, String> attributes;
    jp computedStyle;
    float containingBoxWidth;
    final sa0 document;
    final String name;
    Paint paint = new Paint();
    jp style;
    float x;
    float y;

    public AbstractAndroidComponentElement(Context context, sa0 sa0, String str) {
        super(context);
        this.name = str;
        this.document = sa0;
        setWillNotDraw(false);
        setClipChildren(false);
    }

    private void drawBackground(Canvas canvas, int i, int i2, int i3, int i4) {
        jp computedStyle2 = getComputedStyle();
        CssProperty cssProperty = CssProperty.BACKGROUND_COLOR;
        if (computedStyle2.k(cssProperty)) {
            this.paint.setColor(computedStyle2.e(cssProperty));
            this.paint.setStyle(Paint.Style.FILL);
            canvas.drawRect((float) i, (float) i2, (float) (i + i3), (float) (i2 + i4), this.paint);
        }
        CssProperty cssProperty2 = CssProperty.BACKGROUND_IMAGE;
        if (computedStyle2.k(cssProperty2)) {
            Bitmap a = ((AndroidPlatform) getOwnerDocument().f()).a(this, getOwnerDocument().j(computedStyle2.h(cssProperty2)));
            if (a != null) {
                canvas.save();
                canvas.clipRect(i, i2, i + i3, i2 + i4);
                CssEnum f = computedStyle2.f(CssProperty.BACKGROUND_REPEAT);
                if (f == CssEnum.REPEAT_Y || f == CssEnum.REPEAT) {
                    int i5 = 0;
                    do {
                        if (f == CssEnum.REPEAT) {
                            int i6 = 0;
                            do {
                                canvas.drawBitmap(a, (float) (i + i6), (float) (i2 + i5), (Paint) null);
                                i6 += a.getWidth();
                            } while (i6 < i3);
                        } else {
                            canvas.drawBitmap(a, (float) (i + 0), (float) (i2 + i5), (Paint) null);
                        }
                        i5 += a.getHeight();
                    } while (i5 < i4);
                } else if (f == CssEnum.REPEAT_X) {
                    int i7 = 0;
                    do {
                        canvas.drawBitmap(a, (float) (i + i7), (float) (i2 + 0), (Paint) null);
                        i7 += a.getWidth();
                    } while (i7 < i3);
                } else {
                    canvas.drawBitmap(a, (float) (i + 0), (float) (i2 + 0), (Paint) null);
                }
                canvas.restore();
            }
        }
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public String getAttribute(String str) {
        HashMap<String, String> hashMap = this.attributes;
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(str);
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public jp getComputedStyle() {
        return this.computedStyle;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public ElementType getElementType() {
        return ElementType.COMPONENT;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public String getLocalName() {
        return this.name;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public sa0 getOwnerDocument() {
        return this.document;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public Element getParentElement() {
        if (getParent() instanceof Element) {
            return (Element) getParent();
        }
        return null;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public jp getStyle() {
        return this.style;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public String getTextContent() {
        return vc0.a(this);
    }

    @Override // com.real.android.nativehtml.common.layout.ComponentElement
    public void moveRelative(float f, float f2) {
        this.x += f;
        this.y += f2;
    }

    public void onDraw(Canvas canvas) {
        float a = getOwnerDocument().h().a();
        int round = Math.round(this.computedStyle.g(CssProperty.BORDER_LEFT_WIDTH, this.containingBoxWidth) * a);
        int round2 = Math.round(this.computedStyle.g(CssProperty.BORDER_RIGHT_WIDTH, this.containingBoxWidth) * a);
        int round3 = Math.round(this.computedStyle.g(CssProperty.BORDER_TOP_WIDTH, this.containingBoxWidth) * a);
        int round4 = Math.round(a * this.computedStyle.g(CssProperty.BORDER_BOTTOM_WIDTH, this.containingBoxWidth));
        int width = getWidth();
        int height = getHeight();
        drawBackground(canvas, round, round3, getWidth() - round2, getHeight() - round4);
        this.paint.setStyle(Paint.Style.STROKE);
        if (round3 > 0 && this.computedStyle.f(CssProperty.BORDER_TOP_STYLE) != CssEnum.NONE) {
            this.paint.setColor(this.computedStyle.e(CssProperty.BORDER_TOP_COLOR));
            int i = (round << 8) / round3;
            int i2 = (round2 << 8) / round3;
            for (int i3 = 0; i3 < round3; i3++) {
                float f = (float) i3;
                canvas.drawLine((float) ((i3 * i) >> 8), f, (float) ((width - 1) - ((i3 * i2) >> 8)), f, this.paint);
            }
        }
        if (round2 > 0 && this.computedStyle.f(CssProperty.BORDER_RIGHT_STYLE) != CssEnum.NONE) {
            this.paint.setColor(this.computedStyle.e(CssProperty.BORDER_RIGHT_COLOR));
            int i4 = (round3 << 8) / round2;
            int i5 = (round4 << 8) / round2;
            for (int i6 = 0; i6 < round2; i6++) {
                float f2 = (float) ((width - 1) - i6);
                canvas.drawLine(f2, (float) ((i6 * i4) >> 8), f2, (float) ((height - 1) - ((i6 * i5) >> 8)), this.paint);
            }
        }
        if (round4 > 0 && this.computedStyle.f(CssProperty.BORDER_BOTTOM_STYLE) != CssEnum.NONE) {
            this.paint.setColor(this.computedStyle.e(CssProperty.BORDER_BOTTOM_COLOR));
            int i7 = (round << 8) / round4;
            int i8 = (round2 << 8) / round4;
            for (int i9 = 0; i9 < round4; i9++) {
                float f3 = (float) ((height - 1) - i9);
                canvas.drawLine((float) ((i9 * i7) >> 8), f3, (float) (((width - 1) - ((i9 * i8) >> 8)) - 1), f3, this.paint);
            }
        }
        if (round > 0 && this.computedStyle.f(CssProperty.BORDER_LEFT_STYLE) != CssEnum.NONE) {
            this.paint.setColor(this.computedStyle.e(CssProperty.BORDER_LEFT_COLOR));
            int i10 = (round3 << 8) / round;
            int i11 = (round4 << 8) / round;
            for (int i12 = 0; i12 < round; i12++) {
                float f4 = (float) i12;
                canvas.drawLine(f4, (float) ((i12 * i10) >> 8), f4, (float) ((height - 1) - ((i12 * i11) >> 8)), this.paint);
            }
        }
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public void setAttribute(String str, String str2) {
        if (this.attributes == null) {
            this.attributes = new HashMap<>();
        }
        this.attributes.put(str, str2);
        if (str.equals("style")) {
            this.style = jp.b(str2);
        }
    }

    @Override // com.real.android.nativehtml.common.layout.ComponentElement
    public void setBorderBoxBounds(float f, float f2, float f3, float f4, float f5) {
        this.containingBoxWidth = f5;
        this.x = f;
        this.y = f2;
        float a = this.document.h().a();
        setMeasuredDimension(Math.round(f3 * a), Math.round(f4 * a));
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public void setComputedStyle(jp jpVar) {
        this.computedStyle = jpVar;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public void setParentElement(Element element) {
        if (element == null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public void setTextContent(String str) {
    }
}
