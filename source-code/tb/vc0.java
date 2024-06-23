package tb;

import com.real.android.nativehtml.common.dom.ContentType;
import com.real.android.nativehtml.common.dom.Element;
import com.real.android.nativehtml.common.dom.ElementType;
import com.real.android.nativehtml.common.dom.HtmlCollection;
import com.real.android.nativehtml.common.util.HtmlCollectionImpl;
import java.util.HashMap;

/* compiled from: Taobao */
public class vc0 implements Element {
    protected ElementType a;
    protected Element b;
    protected String c;
    protected sa0 d;
    protected HashMap<String, String> e;
    protected jp f;
    protected jp g;
    protected String h;
    protected HtmlCollectionImpl i;
    protected ContentType j;

    public vc0(sa0 sa0, String str, ElementType elementType, ContentType contentType) {
        this.d = sa0;
        this.a = elementType;
        this.c = str;
        this.j = contentType;
    }

    public static String a(Element element) {
        StringBuilder sb = new StringBuilder();
        HtmlCollection children = element.getChildren();
        for (int i2 = 0; i2 < children.getLength(); i2++) {
            sb.append(children.item(i2).getTextContent());
        }
        return sb.toString();
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public String getAttribute(String str) {
        HashMap<String, String> hashMap = this.e;
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(str);
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public HtmlCollection getChildren() {
        HtmlCollectionImpl htmlCollectionImpl = this.i;
        return htmlCollectionImpl == null ? HtmlCollection.EMPTY : htmlCollectionImpl;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public jp getComputedStyle() {
        return this.g;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public ContentType getElementContentType() {
        return this.j;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public ElementType getElementType() {
        return this.a;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public String getLocalName() {
        return this.c;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public sa0 getOwnerDocument() {
        return this.d;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public Element getParentElement() {
        return this.b;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public jp getStyle() {
        return this.f;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public String getTextContent() {
        String str = this.h;
        if (str != null) {
            return str;
        }
        HtmlCollectionImpl htmlCollectionImpl = this.i;
        return (htmlCollectionImpl == null || htmlCollectionImpl.getLength() == 0) ? "" : a(this);
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public void insertBefore(Element element, Element element2) {
        int i2;
        HtmlCollectionImpl htmlCollectionImpl = this.i;
        if (htmlCollectionImpl == null) {
            this.i = new HtmlCollectionImpl();
            i2 = 0;
        } else if (element2 == null || htmlCollectionImpl == null) {
            i2 = htmlCollectionImpl.getLength();
        } else {
            i2 = htmlCollectionImpl.indexOf(element2);
            if (i2 == -1) {
                i2 = this.i.getLength();
            }
        }
        this.i.add(i2, element);
        element.setParentElement(this);
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public void setAttribute(String str, String str2) {
        if (this.e == null) {
            this.e = new HashMap<>();
        }
        this.e.put(str, str2);
        if (str.equals("style")) {
            this.f = jp.b(str2);
        }
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public void setComputedStyle(jp jpVar) {
        this.g = jpVar;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public void setParentElement(Element element) {
        this.b = element;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public void setTextContent(String str) {
        this.h = str;
        this.i = null;
    }
}
