package com.real.android.nativehtml.common.dom;

import tb.jp;
import tb.sa0;

/* compiled from: Taobao */
public interface Element {
    String getAttribute(String str);

    HtmlCollection getChildren();

    jp getComputedStyle();

    ContentType getElementContentType();

    ElementType getElementType();

    String getLocalName();

    sa0 getOwnerDocument();

    Element getParentElement();

    jp getStyle();

    String getTextContent();

    void insertBefore(Element element, Element element2);

    void setAttribute(String str, String str2);

    void setComputedStyle(jp jpVar);

    void setParentElement(Element element);

    void setTextContent(String str);
}
