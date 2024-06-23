package org.apache.commons.text.similarity;

import java.util.Arrays;

/* compiled from: Taobao */
public class JaroWinklerDistance implements SimilarityScore<Double> {
    public static final int INDEX_NOT_FOUND = -1;

    protected static int[] matches(CharSequence charSequence, CharSequence charSequence2) {
        CharSequence charSequence3;
        CharSequence charSequence4;
        if (charSequence.length() > charSequence2.length()) {
            charSequence4 = charSequence;
            charSequence3 = charSequence2;
        } else {
            charSequence3 = charSequence;
            charSequence4 = charSequence2;
        }
        int max = Math.max((charSequence4.length() / 2) - 1, 0);
        int[] iArr = new int[charSequence3.length()];
        Arrays.fill(iArr, -1);
        boolean[] zArr = new boolean[charSequence4.length()];
        int i = 0;
        for (int i2 = 0; i2 < charSequence3.length(); i2++) {
            char charAt = charSequence3.charAt(i2);
            int max2 = Math.max(i2 - max, 0);
            int min = Math.min(i2 + max + 1, charSequence4.length());
            while (true) {
                if (max2 >= min) {
                    break;
                }
                if (!zArr[max2] && charAt == charSequence4.charAt(max2)) {
                    iArr[i2] = max2;
                    zArr[max2] = true;
                    i++;
                    break;
                }
                max2++;
            }
        }
        char[] cArr = new char[i];
        char[] cArr2 = new char[i];
        int i3 = 0;
        for (int i4 = 0; i4 < charSequence3.length(); i4++) {
            if (iArr[i4] != -1) {
                cArr[i3] = charSequence3.charAt(i4);
                i3++;
            }
        }
        int i5 = 0;
        for (int i6 = 0; i6 < charSequence4.length(); i6++) {
            if (zArr[i6]) {
                cArr2[i5] = charSequence4.charAt(i6);
                i5++;
            }
        }
        int i7 = 0;
        for (int i8 = 0; i8 < i; i8++) {
            if (cArr[i8] != cArr2[i8]) {
                i7++;
            }
        }
        int i9 = 0;
        int i10 = 0;
        while (i9 < charSequence3.length() && charSequence.charAt(i9) == charSequence2.charAt(i9)) {
            i10++;
            i9++;
        }
        return new int[]{i, i7 / 2, i10, charSequence4.length()};
    }

    @Override // org.apache.commons.text.similarity.SimilarityScore
    public Double apply(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        int[] matches = matches(charSequence, charSequence2);
        double d = (double) matches[0];
        if (d == 0.0d) {
            return Double.valueOf(0.0d);
        }
        double length = (((d / ((double) charSequence.length())) + (d / ((double) charSequence2.length()))) + ((d - ((double) matches[1])) / d)) / 3.0d;
        if (length >= 0.7d) {
            length += Math.min(0.1d, 1.0d / ((double) matches[3])) * ((double) matches[2]) * (1.0d - length);
        }
        return Double.valueOf(length);
    }
}
