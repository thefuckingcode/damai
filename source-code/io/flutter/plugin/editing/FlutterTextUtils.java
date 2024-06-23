package io.flutter.plugin.editing;

import io.flutter.embedding.engine.FlutterJNI;

/* compiled from: Taobao */
class FlutterTextUtils {
    public static final int CANCEL_TAG = 917631;
    public static final int CARRIAGE_RETURN = 13;
    public static final int COMBINING_ENCLOSING_KEYCAP = 8419;
    public static final int LINE_FEED = 10;
    public static final int ZERO_WIDTH_JOINER = 8205;
    private final FlutterJNI flutterJNI;

    public FlutterTextUtils(FlutterJNI flutterJNI2) {
        this.flutterJNI = flutterJNI2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:86:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0143 A[EDGE_INSN: B:97:0x0143->B:89:0x0143 ?: BREAK  , SYNTHETIC] */
    public int getOffsetAfter(CharSequence charSequence, int i) {
        int charCount;
        int length = charSequence.length();
        int i2 = length - 1;
        if (i >= i2) {
            return length;
        }
        int codePointAt = Character.codePointAt(charSequence, i);
        int charCount2 = Character.charCount(codePointAt);
        int i3 = i + charCount2;
        int i4 = 0;
        if (i3 == 0) {
            return 0;
        }
        if (codePointAt == 10) {
            if (Character.codePointAt(charSequence, i3) == 13) {
                charCount2++;
            }
            return i + charCount2;
        } else if (!isRegionalIndicatorSymbol(codePointAt)) {
            if (isKeycapBase(codePointAt)) {
                charCount2 += Character.charCount(codePointAt);
            }
            if (codePointAt == 8419) {
                int codePointBefore = Character.codePointBefore(charSequence, i3);
                int charCount3 = i3 + Character.charCount(codePointBefore);
                if (charCount3 < length && isVariationSelector(codePointBefore)) {
                    int codePointAt2 = Character.codePointAt(charSequence, charCount3);
                    if (isKeycapBase(codePointAt2)) {
                        charCount2 += Character.charCount(codePointBefore) + Character.charCount(codePointAt2);
                    }
                } else if (isKeycapBase(codePointBefore)) {
                    charCount2 += Character.charCount(codePointBefore);
                }
                return i + charCount2;
            }
            if (isEmoji(codePointAt)) {
                boolean z = false;
                int i5 = 0;
                while (true) {
                    if (z) {
                        charCount2 += Character.charCount(codePointAt) + i5 + 1;
                        z = false;
                    }
                    if (isEmojiModifier(codePointAt)) {
                        break;
                    }
                    if (i3 < length) {
                        codePointAt = Character.codePointAt(charSequence, i3);
                        i3 += Character.charCount(codePointAt);
                        if (codePointAt != 8419) {
                            if (!isEmojiModifier(codePointAt)) {
                                if (!isVariationSelector(codePointAt)) {
                                    if (codePointAt == 8205) {
                                        codePointAt = Character.codePointAt(charSequence, i3);
                                        i3 += Character.charCount(codePointAt);
                                        if (i3 < length && isVariationSelector(codePointAt)) {
                                            codePointAt = Character.codePointAt(charSequence, i3);
                                            int charCount4 = Character.charCount(codePointAt);
                                            i3 += Character.charCount(codePointAt);
                                            i5 = charCount4;
                                            z = true;
                                            if (i3 < length) {
                                                if (z) {
                                                    if (isEmoji(codePointAt)) {
                                                        break;
                                                    }
                                                } else {
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        } else {
                                            z = true;
                                        }
                                    }
                                } else {
                                    charCount = Character.charCount(codePointAt);
                                    break;
                                }
                            } else {
                                charCount = Character.charCount(codePointAt);
                                break;
                            }
                        } else {
                            int codePointBefore2 = Character.codePointBefore(charSequence, i3);
                            int charCount5 = i3 + Character.charCount(codePointBefore2);
                            if (charCount5 < length && isVariationSelector(codePointBefore2)) {
                                int codePointAt3 = Character.codePointAt(charSequence, charCount5);
                                if (isKeycapBase(codePointAt3)) {
                                    charCount2 += Character.charCount(codePointBefore2) + Character.charCount(codePointAt3);
                                }
                            } else if (isKeycapBase(codePointBefore2)) {
                                charCount2 += Character.charCount(codePointBefore2);
                            }
                            return i + charCount2;
                        }
                    }
                    i5 = 0;
                    if (i3 < length) {
                    }
                }
                charCount2 += charCount + 0;
            }
            return i + charCount2;
        } else if (i3 >= i2 || !isRegionalIndicatorSymbol(Character.codePointAt(charSequence, i3))) {
            return i3;
        } else {
            int i6 = i;
            while (i6 > 0 && isRegionalIndicatorSymbol(Character.codePointBefore(charSequence, i))) {
                i6 -= Character.charCount(Character.codePointBefore(charSequence, i));
                i4++;
            }
            if (i4 % 2 == 0) {
                charCount2 += 2;
            }
            return i + charCount2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:89:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0154 A[EDGE_INSN: B:99:0x0154->B:92:0x0154 ?: BREAK  , SYNTHETIC] */
    public int getOffsetBefore(CharSequence charSequence, int i) {
        int codePointBefore;
        int charCount;
        int charCount2;
        int i2 = 0;
        int i3 = 1;
        if (i <= 1 || (charCount2 = i - (charCount = Character.charCount((codePointBefore = Character.codePointBefore(charSequence, i))))) == 0) {
            return 0;
        }
        if (codePointBefore == 10) {
            if (Character.codePointBefore(charSequence, charCount2) == 13) {
                charCount++;
            }
            return i - charCount;
        } else if (isRegionalIndicatorSymbol(codePointBefore)) {
            int codePointBefore2 = Character.codePointBefore(charSequence, charCount2);
            int charCount3 = charCount2 - Character.charCount(codePointBefore2);
            while (charCount3 > 0 && isRegionalIndicatorSymbol(codePointBefore2)) {
                codePointBefore2 = Character.codePointBefore(charSequence, charCount3);
                charCount3 -= Character.charCount(codePointBefore2);
                i3++;
            }
            if (i3 % 2 == 0) {
                charCount += 2;
            }
            return i - charCount;
        } else if (codePointBefore == 8419) {
            int codePointBefore3 = Character.codePointBefore(charSequence, charCount2);
            int charCount4 = charCount2 - Character.charCount(codePointBefore3);
            if (charCount4 > 0 && isVariationSelector(codePointBefore3)) {
                int codePointBefore4 = Character.codePointBefore(charSequence, charCount4);
                if (isKeycapBase(codePointBefore4)) {
                    charCount += Character.charCount(codePointBefore3) + Character.charCount(codePointBefore4);
                }
            } else if (isKeycapBase(codePointBefore3)) {
                charCount += Character.charCount(codePointBefore3);
            }
            return i - charCount;
        } else {
            if (codePointBefore == 917631) {
                codePointBefore = Character.codePointBefore(charSequence, charCount2);
                int charCount5 = Character.charCount(codePointBefore);
                while (true) {
                    charCount2 -= charCount5;
                    if (charCount2 > 0 && isTagSpecChar(codePointBefore)) {
                        charCount += Character.charCount(codePointBefore);
                        codePointBefore = Character.codePointBefore(charSequence, charCount2);
                        charCount5 = Character.charCount(codePointBefore);
                    }
                }
                if (!isEmoji(codePointBefore)) {
                    return i - 2;
                }
                charCount += Character.charCount(codePointBefore);
            }
            if (isVariationSelector(codePointBefore)) {
                codePointBefore = Character.codePointBefore(charSequence, charCount2);
                if (!isEmoji(codePointBefore)) {
                    return i - charCount;
                }
                charCount += Character.charCount(codePointBefore);
                charCount2 -= charCount;
            }
            if (isEmoji(codePointBefore)) {
                boolean z = false;
                int i4 = 0;
                while (true) {
                    if (z) {
                        charCount += Character.charCount(codePointBefore) + i4 + 1;
                        z = false;
                    }
                    if (isEmojiModifier(codePointBefore)) {
                        int codePointBefore5 = Character.codePointBefore(charSequence, charCount2);
                        int charCount6 = charCount2 - Character.charCount(codePointBefore5);
                        if (charCount6 > 0 && isVariationSelector(codePointBefore5)) {
                            codePointBefore5 = Character.codePointBefore(charSequence, charCount6);
                            if (!isEmoji(codePointBefore5)) {
                                return i - charCount;
                            }
                            i2 = Character.charCount(codePointBefore5);
                            Character.charCount(codePointBefore5);
                        }
                        if (isEmojiModifierBase(codePointBefore5)) {
                            charCount += i2 + Character.charCount(codePointBefore5);
                        }
                    } else {
                        if (charCount2 > 0) {
                            codePointBefore = Character.codePointBefore(charSequence, charCount2);
                            charCount2 -= Character.charCount(codePointBefore);
                            if (codePointBefore == 8205) {
                                codePointBefore = Character.codePointBefore(charSequence, charCount2);
                                charCount2 -= Character.charCount(codePointBefore);
                                if (charCount2 > 0 && isVariationSelector(codePointBefore)) {
                                    codePointBefore = Character.codePointBefore(charSequence, charCount2);
                                    int charCount7 = Character.charCount(codePointBefore);
                                    charCount2 -= Character.charCount(codePointBefore);
                                    i4 = charCount7;
                                    z = true;
                                    if (charCount2 != 0) {
                                        if (z) {
                                            if (isEmoji(codePointBefore)) {
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                } else {
                                    z = true;
                                }
                            }
                        }
                        i4 = 0;
                        if (charCount2 != 0) {
                        }
                    }
                }
            }
            return i - charCount;
        }
    }

    public boolean isEmoji(int i) {
        return this.flutterJNI.nativeFlutterTextUtilsIsEmoji(i);
    }

    public boolean isEmojiModifier(int i) {
        return this.flutterJNI.nativeFlutterTextUtilsIsEmojiModifier(i);
    }

    public boolean isEmojiModifierBase(int i) {
        return this.flutterJNI.nativeFlutterTextUtilsIsEmojiModifierBase(i);
    }

    public boolean isKeycapBase(int i) {
        return (48 <= i && i <= 57) || i == 35 || i == 42;
    }

    public boolean isRegionalIndicatorSymbol(int i) {
        return this.flutterJNI.nativeFlutterTextUtilsIsRegionalIndicator(i);
    }

    public boolean isTagSpecChar(int i) {
        return 917536 <= i && i <= 917630;
    }

    public boolean isVariationSelector(int i) {
        return this.flutterJNI.nativeFlutterTextUtilsIsVariationSelector(i);
    }
}
