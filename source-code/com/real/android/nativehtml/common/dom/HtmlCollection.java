package com.real.android.nativehtml.common.dom;

/* compiled from: Taobao */
public interface HtmlCollection {
    public static final HtmlCollection EMPTY = new a();

    /* compiled from: Taobao */
    static class a implements HtmlCollection {
        a() {
        }

        @Override // com.real.android.nativehtml.common.dom.HtmlCollection
        public int getLength() {
            return 0;
        }

        @Override // com.real.android.nativehtml.common.dom.HtmlCollection
        public Element item(int i) {
            return null;
        }
    }

    int getLength();

    Element item(int i);
}
