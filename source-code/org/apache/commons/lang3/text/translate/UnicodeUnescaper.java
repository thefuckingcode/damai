package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

@Deprecated
/* compiled from: Taobao */
public class UnicodeUnescaper extends CharSequenceTranslator {
    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i, Writer writer) throws IOException {
        int i2;
        int i3;
        if (charSequence.charAt(i) != '\\' || (i2 = i + 1) >= charSequence.length() || charSequence.charAt(i2) != 'u') {
            return 0;
        }
        int i4 = 2;
        while (true) {
            i3 = i + i4;
            if (i3 < charSequence.length() && charSequence.charAt(i3) == 'u') {
                i4++;
            }
        }
        if (i3 < charSequence.length() && charSequence.charAt(i3) == '+') {
            i4++;
        }
        int i5 = i + i4;
        int i6 = i5 + 4;
        if (i6 <= charSequence.length()) {
            CharSequence subSequence = charSequence.subSequence(i5, i6);
            try {
                writer.write((char) Integer.parseInt(subSequence.toString(), 16));
                return i4 + 4;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Unable to parse unicode value: " + ((Object) subSequence), e);
            }
        } else {
            throw new IllegalArgumentException("Less than 4 hex digits in unicode value: '" + ((Object) charSequence.subSequence(i, charSequence.length())) + "' due to end of CharSequence");
        }
    }
}
