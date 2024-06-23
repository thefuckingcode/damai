package com.real.android.nativehtml.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting;
import com.real.android.nativehtml.common.css.CssEnum;
import com.real.android.nativehtml.common.css.CssProperty;
import com.real.android.nativehtml.common.dom.ContentType;
import com.real.android.nativehtml.common.dom.Element;
import com.real.android.nativehtml.common.dom.ElementType;
import com.real.android.nativehtml.common.dom.HtmlCollection;
import com.real.android.nativehtml.common.layout.ComponentElement;
import com.real.android.nativehtml.common.layout.Layout;
import com.real.android.nativehtml.common.util.HtmlCollectionImpl;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import tb.jp;
import tb.sa0;
import tb.vc0;

/* compiled from: Taobao */
public class AndroidTextComponent extends TextView implements ComponentElement {
    private static final jp EMTPY_STYLE = new jp();
    static final int PAINT_MASK = -25;
    private static final String TAG = "AndroidTextComponent";
    private HtmlCollectionImpl children = new HtmlCollectionImpl();
    private jp computedStyle;
    SpannableStringBuilder content = new SpannableStringBuilder("");
    float contentBoxWidth;
    private boolean dirty;
    private final sa0 document;
    float x;
    float y;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends ClickableSpan {
        final /* synthetic */ Element a;

        a(Element element) {
            this.a = element;
        }

        public void onClick(View view) {
            AndroidTextComponent.this.document.g().openLink(AndroidTextComponent.this.document.j(this.a.getAttribute("href")));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[CssEnum.values().length];
            a = iArr;
            iArr[CssEnum.RIGHT.ordinal()] = 1;
            a[CssEnum.CENTER.ordinal()] = 2;
            a[CssEnum.UNDERLINE.ordinal()] = 3;
            a[CssEnum.LINE_THROUGH.ordinal()] = 4;
            a[CssEnum.SUB.ordinal()] = 5;
            try {
                a[CssEnum.SUPER.ordinal()] = 6;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public AndroidTextComponent(Context context, sa0 sa0) {
        super(context);
        this.document = sa0;
        setTextIsSelectable(true);
    }

    private void validateContent() {
        if (this.dirty) {
            this.dirty = false;
            this.content.clear();
            this.content.clearSpans();
            for (int i = 0; i < this.children.getLength(); i++) {
                updateChild(this.children.item(i), this.computedStyle);
            }
            setText(this.content);
        }
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public String getAttribute(String str) {
        return null;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public HtmlCollection getChildren() {
        return this.children;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public jp getComputedStyle() {
        return this.computedStyle;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public ContentType getElementContentType() {
        return ContentType.FORMATTED_TEXT;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public ElementType getElementType() {
        return ElementType.COMPONENT;
    }

    @Override // com.real.android.nativehtml.common.layout.ComponentElement
    public float getIntrinsicContentBoxHeightForWidth(float f, float f2) {
        validateContent();
        float a2 = this.document.h().a();
        measure(Math.round(f * a2) | 1073741824, 0);
        return ((float) getMeasuredHeight()) / a2;
    }

    @Override // com.real.android.nativehtml.common.layout.ComponentElement
    public float getIntrinsicContentBoxWidth(Layout.Directive directive, float f) {
        validateContent();
        float a2 = this.document.h().a();
        measure(Math.round(f * a2) | Integer.MIN_VALUE, 0);
        return ((float) getMeasuredWidth()) / a2;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public String getLocalName() {
        return "text-container";
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public sa0 getOwnerDocument() {
        return this.document;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public Element getParentElement() {
        return (Element) getParent();
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public jp getStyle() {
        return EMTPY_STYLE;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public String getTextContent() {
        return vc0.a(this);
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public void insertBefore(Element element, Element element2) {
        this.children.insertBefore(this, element, element2);
        this.dirty = true;
    }

    @Override // com.real.android.nativehtml.common.layout.ComponentElement
    public void moveRelative(float f, float f2) {
        this.x += f;
        this.y += f2;
    }

    public void requestLayout() {
        this.dirty = true;
        super.requestLayout();
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public void setAttribute(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.real.android.nativehtml.common.layout.ComponentElement
    public void setBorderBoxBounds(float f, float f2, float f3, float f4, float f5) {
        this.contentBoxWidth = f5;
        this.x = f;
        this.y = f2;
        float a2 = this.document.h().a();
        setMeasuredDimension(Math.round(f3 * a2), Math.round(f4 * a2));
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public void setComputedStyle(jp jpVar) {
        this.computedStyle = jpVar;
        float g = jpVar.g(CssProperty.FONT_SIZE, 0.0f) * this.document.h().a();
        boolean z = false;
        setTextSize(0, g);
        setTextColor(jpVar.e(CssProperty.COLOR));
        setTypeface(a.e(jpVar));
        setPaintFlags((getPaintFlags() & PAINT_MASK) | a.c(jpVar));
        if (jpVar.f(CssProperty.USER_SELECT) != CssEnum.NONE) {
            z = true;
        }
        setTextIsSelectable(z);
        int i = b.a[this.computedStyle.f(CssProperty.TEXT_ALIGN).ordinal()];
        if (i == 1) {
            setGravity(5);
        } else if (i != 2) {
            setGravity(3);
        } else {
            setGravity(17);
        }
        this.dirty = true;
        if (HtmlView.isTextOneLine()) {
            setSingleLine(true);
            setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public void setParentElement(Element element) {
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public void setTextContent(String str) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void updateChild(Element element, jp jpVar) {
        String attribute;
        Bitmap a2;
        int length = this.content.length();
        HtmlCollection children2 = element.getChildren();
        jp computedStyle2 = element.getComputedStyle();
        if (element.getLocalName().equals(BrightRemindSetting.BRIGHT_REMIND)) {
            this.content.append((CharSequence) StringUtils.LF);
        } else if (element.getLocalName().equals("img")) {
            this.content.append((CharSequence) "□");
        } else if (children2.getLength() != 0) {
            for (int i = 0; i < children2.getLength(); i++) {
                updateChild(children2.item(i), computedStyle2);
            }
        } else {
            this.content.append((CharSequence) element.getTextContent());
        }
        int length2 = this.content.length();
        ArrayList arrayList = new ArrayList();
        float a3 = this.document.h().a();
        if (element.getLocalName().equals("img") && (attribute = element.getAttribute("src")) != null && !attribute.isEmpty() && (a2 = ((AndroidPlatform) this.document.f()).a(element, this.document.j(attribute))) != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getContext().getResources(), a2);
            float width = (float) a2.getWidth();
            float height = (float) a2.getHeight();
            CssProperty cssProperty = CssProperty.WIDTH;
            if (computedStyle2.k(cssProperty)) {
                width = computedStyle2.g(cssProperty, this.contentBoxWidth);
                if (computedStyle2.k(CssProperty.HEIGHT)) {
                    height = computedStyle2.g(cssProperty, this.contentBoxWidth);
                } else {
                    height *= width / ((float) a2.getWidth());
                }
            } else {
                CssProperty cssProperty2 = CssProperty.HEIGHT;
                if (computedStyle2.k(cssProperty2)) {
                    height = computedStyle2.g(cssProperty2, this.contentBoxWidth);
                    width *= height / ((float) a2.getHeight());
                }
            }
            bitmapDrawable.setBounds(0, 0, Math.round(width * a3), Math.round(height * a3));
            arrayList.add(new ImageSpan(bitmapDrawable, 1));
        }
        String b2 = a.b(computedStyle2);
        if (!b2.equals(a.b(jpVar))) {
            arrayList.add(new TypefaceSpan(b2));
        }
        int d = a.d(computedStyle2);
        if (d != a.d(jpVar)) {
            arrayList.add(new StyleSpan(d));
        }
        CssProperty cssProperty3 = CssProperty.FONT_SIZE;
        float g = jpVar.g(cssProperty3, 0.0f);
        if (g != computedStyle2.g(cssProperty3, 0.0f)) {
            arrayList.add(new AbsoluteSizeSpan(Math.round(g * a3)));
        }
        CssProperty cssProperty4 = CssProperty.COLOR;
        int e = computedStyle2.e(cssProperty4);
        if (e != jpVar.e(cssProperty4)) {
            arrayList.add(new ForegroundColorSpan(e));
        }
        CssProperty cssProperty5 = CssProperty.TEXT_DECORATION;
        CssEnum f = computedStyle2.f(cssProperty5);
        if (f != jpVar.f(cssProperty5)) {
            int i2 = b.a[f.ordinal()];
            if (i2 == 3) {
                arrayList.add(new UnderlineSpan());
            } else if (i2 == 4) {
                arrayList.add(new StrikethroughSpan());
            }
        }
        CssProperty cssProperty6 = CssProperty.VERTICAL_ALIGN;
        CssEnum f2 = computedStyle2.f(cssProperty6);
        if (f2 != jpVar.f(cssProperty6)) {
            int i3 = b.a[f2.ordinal()];
            if (i3 == 5) {
                arrayList.add(new SubscriptSpan());
            } else if (i3 == 6) {
                arrayList.add(new SuperscriptSpan());
            }
        }
        if (element.getLocalName().equals("a") && element.getAttribute("href") != null) {
            setTextIsSelectable(false);
            setMovementMethod(LinkMovementMethod.getInstance());
            arrayList.add(new a(element));
        }
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.content.setSpan(it.next(), length, length2, 0);
            }
        }
    }
}
