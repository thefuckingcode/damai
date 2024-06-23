package org.apache.commons.text.similarity;

import java.lang.reflect.Array;
import java.util.Arrays;

/* compiled from: Taobao */
public class LevenshteinDetailedDistance implements EditDistance<LevenshteinResults> {
    private static final LevenshteinDetailedDistance DEFAULT_INSTANCE = new LevenshteinDetailedDistance();
    private final Integer threshold;

    public LevenshteinDetailedDistance() {
        this(null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        if (r15.charAt(r1 - 1) == r16.charAt(r0 - 1)) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006a, code lost:
        if (r18 != false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0070, code lost:
        r3 = r3 + 1;
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0080, code lost:
        if (r18 != false) goto L_0x0070;
     */
    private static LevenshteinResults findDetailedResults(CharSequence charSequence, CharSequence charSequence2, int[][] iArr, boolean z) {
        int i;
        int i2;
        boolean z2;
        int length = charSequence2.length();
        int length2 = charSequence.length();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (length >= 0 && length2 >= 0) {
            if (length2 == 0) {
                i = -1;
            } else {
                i = iArr[length][length2 - 1];
            }
            if (length == 0) {
                i2 = -1;
            } else {
                i2 = iArr[length - 1][length2];
            }
            int i6 = (length <= 0 || length2 <= 0) ? -1 : iArr[length - 1][length2 - 1];
            if (i == -1 && i2 == -1 && i6 == -1) {
                break;
            }
            int i7 = iArr[length][length2];
            if (length2 <= 0 || length <= 0) {
                int i8 = i7 - 1;
                boolean z3 = true;
                if ((i8 == i && i7 <= i6 && i7 <= i2) || (i6 == -1 && i2 == -1)) {
                    length2--;
                } else if ((i8 != i2 || i7 > i6 || i7 > i) && !(i6 == -1 && i == -1)) {
                    z2 = false;
                    z3 = false;
                    if (!z3 && !z2) {
                        i5++;
                    }
                } else {
                    length--;
                }
                i4++;
                z2 = false;
                i5++;
            }
            length2--;
            length--;
        }
        return new LevenshteinResults(Integer.valueOf(i4 + i3 + i5), Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i5));
    }

    public static LevenshteinDetailedDistance getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static LevenshteinResults limitedCompare(CharSequence charSequence, CharSequence charSequence2, int i) {
        boolean z;
        int i2;
        int i3;
        CharSequence charSequence3;
        CharSequence charSequence4;
        int i4;
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        } else if (i >= 0) {
            int length = charSequence.length();
            int length2 = charSequence2.length();
            int i5 = -1;
            int i6 = 0;
            if (length == 0) {
                return length2 <= i ? new LevenshteinResults(Integer.valueOf(length2), Integer.valueOf(length2), 0, 0) : new LevenshteinResults(-1, 0, 0, 0);
            }
            if (length2 == 0) {
                return length <= i ? new LevenshteinResults(Integer.valueOf(length), 0, Integer.valueOf(length), 0) : new LevenshteinResults(-1, 0, 0, 0);
            }
            int i7 = 1;
            if (length > length2) {
                i2 = charSequence.length();
                i3 = length2;
                z = true;
                charSequence3 = charSequence;
                charSequence4 = charSequence2;
            } else {
                i3 = length;
                i2 = length2;
                z = false;
                charSequence4 = charSequence;
                charSequence3 = charSequence2;
            }
            int i8 = i3 + 1;
            int[] iArr = new int[i8];
            int[] iArr2 = new int[i8];
            int[] iArr3 = new int[2];
            iArr3[1] = i8;
            iArr3[0] = i2 + 1;
            int[][] iArr4 = (int[][]) Array.newInstance(int.class, iArr3);
            for (int i9 = 0; i9 <= i3; i9++) {
                iArr4[0][i9] = i9;
            }
            for (int i10 = 0; i10 <= i2; i10++) {
                iArr4[i10][0] = i10;
            }
            int min = Math.min(i3, i) + 1;
            for (int i11 = 0; i11 < min; i11++) {
                iArr[i11] = i11;
            }
            int i12 = Integer.MAX_VALUE;
            Arrays.fill(iArr, min, i8, Integer.MAX_VALUE);
            Arrays.fill(iArr2, Integer.MAX_VALUE);
            int i13 = 1;
            while (i13 <= i2) {
                char charAt = charSequence3.charAt(i13 - 1);
                iArr2[i6] = i13;
                int max = Math.max(i7, i13 - i);
                if (i13 > i12 - i) {
                    i4 = i3;
                } else {
                    i4 = Math.min(i3, i13 + i);
                }
                if (max > i4) {
                    return new LevenshteinResults(Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i6), Integer.valueOf(i6));
                }
                if (max > 1) {
                    iArr2[max - 1] = i12;
                }
                while (max <= i4) {
                    int i14 = max - 1;
                    if (charSequence4.charAt(i14) == charAt) {
                        iArr2[max] = iArr[i14];
                    } else {
                        iArr2[max] = Math.min(Math.min(iArr2[i14], iArr[max]), iArr[i14]) + 1;
                    }
                    iArr4[i13][max] = iArr2[max];
                    max++;
                }
                i13++;
                i5 = -1;
                i6 = 0;
                i7 = 1;
                i12 = Integer.MAX_VALUE;
                iArr2 = iArr;
                iArr = iArr2;
            }
            if (iArr[i3] <= i) {
                return findDetailedResults(charSequence4, charSequence3, iArr4, z);
            }
            return new LevenshteinResults(-1, 0, 0, 0);
        } else {
            throw new IllegalArgumentException("Threshold must not be negative");
        }
    }

    private static LevenshteinResults unlimitedCompare(CharSequence charSequence, CharSequence charSequence2) {
        boolean z;
        int i;
        int i2;
        CharSequence charSequence3;
        CharSequence charSequence4;
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        int length = charSequence.length();
        int length2 = charSequence2.length();
        char c = 0;
        if (length == 0) {
            return new LevenshteinResults(Integer.valueOf(length2), Integer.valueOf(length2), 0, 0);
        }
        if (length2 == 0) {
            return new LevenshteinResults(Integer.valueOf(length), 0, Integer.valueOf(length), 0);
        }
        if (length > length2) {
            i = charSequence.length();
            i2 = length2;
            z = true;
            charSequence3 = charSequence;
            charSequence4 = charSequence2;
        } else {
            i2 = length;
            i = length2;
            z = false;
            charSequence4 = charSequence;
            charSequence3 = charSequence2;
        }
        int i3 = i2 + 1;
        int[] iArr = new int[i3];
        int[] iArr2 = new int[i3];
        int[] iArr3 = new int[2];
        iArr3[1] = i3;
        iArr3[0] = i + 1;
        int[][] iArr4 = (int[][]) Array.newInstance(int.class, iArr3);
        for (int i4 = 0; i4 <= i2; i4++) {
            iArr4[0][i4] = i4;
        }
        for (int i5 = 0; i5 <= i; i5++) {
            iArr4[i5][0] = i5;
        }
        for (int i6 = 0; i6 <= i2; i6++) {
            iArr[i6] = i6;
        }
        int i7 = 1;
        while (true) {
            iArr2 = iArr;
            iArr = iArr2;
            if (i7 > i) {
                return findDetailedResults(charSequence4, charSequence3, iArr4, z);
            }
            char charAt = charSequence3.charAt(i7 - 1);
            iArr[c] = i7;
            for (int i8 = 1; i8 <= i2; i8++) {
                int i9 = i8 - 1;
                iArr[i8] = Math.min(Math.min(iArr[i9] + 1, iArr2[i8] + 1), iArr2[i9] + (charSequence4.charAt(i9) == charAt ? 0 : 1));
                iArr4[i7][i8] = iArr[i8];
            }
            i7++;
            c = 0;
        }
    }

    public Integer getThreshold() {
        return this.threshold;
    }

    public LevenshteinDetailedDistance(Integer num) {
        if (num == null || num.intValue() >= 0) {
            this.threshold = num;
            return;
        }
        throw new IllegalArgumentException("Threshold must not be negative");
    }

    @Override // org.apache.commons.text.similarity.EditDistance, org.apache.commons.text.similarity.SimilarityScore
    public LevenshteinResults apply(CharSequence charSequence, CharSequence charSequence2) {
        Integer num = this.threshold;
        if (num != null) {
            return limitedCompare(charSequence, charSequence2, num.intValue());
        }
        return unlimitedCompare(charSequence, charSequence2);
    }
}
