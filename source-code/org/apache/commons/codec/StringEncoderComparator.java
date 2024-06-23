package org.apache.commons.codec;

import java.util.Comparator;

/* compiled from: Taobao */
public class StringEncoderComparator implements Comparator {
    private final StringEncoder stringEncoder;

    @Deprecated
    public StringEncoderComparator() {
        this.stringEncoder = null;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        try {
            return ((Comparable) this.stringEncoder.encode(obj)).compareTo((Comparable) this.stringEncoder.encode(obj2));
        } catch (EncoderException unused) {
            return 0;
        }
    }

    public StringEncoderComparator(StringEncoder stringEncoder2) {
        this.stringEncoder = stringEncoder2;
    }
}
