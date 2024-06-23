package org.jsoup.nodes;

public class BooleanAttribute extends Attribute {
    /* access modifiers changed from: protected */
    @Override // org.jsoup.nodes.Attribute
    public boolean isBooleanAttribute() {
        return true;
    }

    public BooleanAttribute(String str) {
        super(str, "");
    }
}
