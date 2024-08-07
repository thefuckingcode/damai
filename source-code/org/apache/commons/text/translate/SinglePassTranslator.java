package org.apache.commons.text.translate;

import java.io.IOException;
import java.io.Writer;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public abstract class SinglePassTranslator extends CharSequenceTranslator {
    SinglePassTranslator() {
    }

    private String getClassName() {
        Class<?> cls = getClass();
        return cls.isAnonymousClass() ? cls.getName() : cls.getSimpleName();
    }

    @Override // org.apache.commons.text.translate.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i, Writer writer) throws IOException {
        if (i == 0) {
            translateWhole(charSequence, writer);
            return Character.codePointCount(charSequence, i, charSequence.length());
        }
        throw new IllegalArgumentException(getClassName() + ".translate(final CharSequence input, final int index, final Writer out) can not handle a non-zero index.");
    }

    /* access modifiers changed from: package-private */
    public abstract void translateWhole(CharSequence charSequence, Writer writer) throws IOException;
}
