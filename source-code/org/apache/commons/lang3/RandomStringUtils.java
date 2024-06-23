package org.apache.commons.lang3;

import java.util.Random;
import org.apache.commons.text.RandomStringGenerator;
import tb.jl1;

/* compiled from: Taobao */
public class RandomStringUtils {
    private static final Random RANDOM = new Random();

    public static String random(int i) {
        return random(i, false, false);
    }

    public static String randomAlphabetic(int i) {
        return random(i, true, false);
    }

    public static String randomAlphanumeric(int i) {
        return random(i, true, true);
    }

    public static String randomAscii(int i) {
        return random(i, 32, 127, false, false);
    }

    public static String randomGraph(int i) {
        return random(i, 33, 126, false, false);
    }

    public static String randomNumeric(int i) {
        return random(i, false, true);
    }

    public static String randomPrint(int i) {
        return random(i, 32, 126, false, false);
    }

    public static String random(int i, boolean z, boolean z2) {
        return random(i, 0, 0, z, z2);
    }

    public static String randomAlphabetic(int i, int i2) {
        return randomAlphabetic(RandomUtils.nextInt(i, i2));
    }

    public static String randomAlphanumeric(int i, int i2) {
        return randomAlphanumeric(RandomUtils.nextInt(i, i2));
    }

    public static String randomAscii(int i, int i2) {
        return randomAscii(RandomUtils.nextInt(i, i2));
    }

    public static String randomGraph(int i, int i2) {
        return randomGraph(RandomUtils.nextInt(i, i2));
    }

    public static String randomNumeric(int i, int i2) {
        return randomNumeric(RandomUtils.nextInt(i, i2));
    }

    public static String randomPrint(int i, int i2) {
        return randomPrint(RandomUtils.nextInt(i, i2));
    }

    public static String random(int i, int i2, int i3, boolean z, boolean z2) {
        return random(i, i2, i3, z, z2, null, RANDOM);
    }

    public static String random(int i, int i2, int i3, boolean z, boolean z2, char... cArr) {
        return random(i, i2, i3, z, z2, cArr, RANDOM);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0089, code lost:
        if (r2 != 19) goto L_0x0096;
     */
    public static String random(int i, int i2, int i3, boolean z, boolean z2, char[] cArr, Random random) {
        char c;
        if (i == 0) {
            return "";
        }
        if (i < 0) {
            throw new IllegalArgumentException("Requested random string length " + i + " is less than 0.");
        } else if (cArr == null || cArr.length != 0) {
            if (i2 == 0 && i3 == 0) {
                if (cArr != null) {
                    i3 = cArr.length;
                } else if (z || z2) {
                    i3 = 123;
                    i2 = 32;
                } else {
                    i3 = RandomStringGenerator.Builder.DEFAULT_MAXIMUM_CODE_POINT;
                }
            } else if (i3 <= i2) {
                throw new IllegalArgumentException("Parameter end (" + i3 + ") must be greater than start (" + i2 + jl1.BRACKET_END_STR);
            }
            if (cArr != null || ((!z2 || i3 > 48) && (!z || i3 > 65))) {
                StringBuilder sb = new StringBuilder(i);
                int i4 = i3 - i2;
                while (true) {
                    int i5 = i - 1;
                    if (i == 0) {
                        return sb.toString();
                    }
                    if (cArr == null) {
                        int nextInt = random.nextInt(i4) + i2;
                        int type = Character.getType(nextInt);
                        if (!(type == 0 || type == 18)) {
                            c = nextInt;
                        }
                    } else {
                        c = cArr[random.nextInt(i4) + i2];
                        int charCount = Character.charCount(c == 1 ? 1 : 0);
                        if (i5 != 0 || charCount <= 1) {
                            if ((!z || !Character.isLetter(c)) && ((!z2 || !Character.isDigit(c)) && (z || z2))) {
                                i5++;
                            } else {
                                sb.appendCodePoint(c);
                                if (charCount == 2) {
                                    i5--;
                                }
                            }
                            i = i5;
                        }
                    }
                    i = i5 + 1;
                }
            } else {
                throw new IllegalArgumentException("Parameter end (" + i3 + ") must be greater then (" + 48 + ") for generating digits " + "or greater then (" + 65 + ") for generating letters.");
            }
        } else {
            throw new IllegalArgumentException("The chars array must not be empty");
        }
    }

    public static String random(int i, String str) {
        if (str == null) {
            return random(i, 0, 0, false, false, null, RANDOM);
        }
        return random(i, str.toCharArray());
    }

    public static String random(int i, char... cArr) {
        if (cArr == null) {
            return random(i, 0, 0, false, false, null, RANDOM);
        }
        return random(i, 0, cArr.length, false, false, cArr, RANDOM);
    }
}
