package org.apache.commons.text.diff;

/* compiled from: Taobao */
public class StringsComparator {
    private final String left;
    private final String right;
    private final int[] vDown;
    private final int[] vUp;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class Snake {
        private final int diag;
        private final int end;
        private final int start;

        Snake(int i, int i2, int i3) {
            this.start = i;
            this.end = i2;
            this.diag = i3;
        }

        public int getDiag() {
            return this.diag;
        }

        public int getEnd() {
            return this.end;
        }

        public int getStart() {
            return this.start;
        }
    }

    public StringsComparator(String str, String str2) {
        this.left = str;
        this.right = str2;
        int length = str.length() + str2.length() + 2;
        this.vDown = new int[length];
        this.vUp = new int[length];
    }

    private void buildScript(int i, int i2, int i3, int i4, EditScript<Character> editScript) {
        Snake middleSnake = getMiddleSnake(i, i2, i3, i4);
        if (middleSnake == null || ((middleSnake.getStart() == i2 && middleSnake.getDiag() == i2 - i4) || (middleSnake.getEnd() == i && middleSnake.getDiag() == i - i3))) {
            int i5 = i;
            int i6 = i3;
            while (true) {
                if (i5 < i2 || i6 < i4) {
                    if (i5 < i2 && i6 < i4 && this.left.charAt(i5) == this.right.charAt(i6)) {
                        editScript.append(new KeepCommand<>(Character.valueOf(this.left.charAt(i5))));
                        i5++;
                    } else if (i2 - i > i4 - i3) {
                        editScript.append(new DeleteCommand<>(Character.valueOf(this.left.charAt(i5))));
                        i5++;
                    } else {
                        editScript.append(new InsertCommand<>(Character.valueOf(this.right.charAt(i6))));
                    }
                    i6++;
                } else {
                    return;
                }
            }
        } else {
            buildScript(i, middleSnake.getStart(), i3, middleSnake.getStart() - middleSnake.getDiag(), editScript);
            for (int start = middleSnake.getStart(); start < middleSnake.getEnd(); start++) {
                editScript.append(new KeepCommand<>(Character.valueOf(this.left.charAt(start))));
            }
            buildScript(middleSnake.getEnd(), i2, middleSnake.getEnd() - middleSnake.getDiag(), i4, editScript);
        }
    }

    private Snake buildSnake(int i, int i2, int i3, int i4) {
        int i5 = i;
        while (true) {
            int i6 = i5 - i2;
            if (i6 < i4 && i5 < i3 && this.left.charAt(i5) == this.right.charAt(i6)) {
                i5++;
            }
        }
        return new Snake(i, i5, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        if (r6[r5 - 1] < r6[r5 + 1]) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ae, code lost:
        if (r6[r7 + 1] <= r6[r7 - 1]) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x010a, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x008a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00fe A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0093 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0107 A[SYNTHETIC] */
    private Snake getMiddleSnake(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int[] iArr;
        int i7;
        int i8;
        int[] iArr2;
        int i9;
        int i10 = i2 - i;
        int i11 = i4 - i3;
        if (i10 == 0 || i11 == 0) {
            return null;
        }
        int i12 = i10 - i11;
        int i13 = i11 + i10;
        if (i13 % 2 != 0) {
            i13++;
        }
        int i14 = i13 / 2;
        int i15 = i14 + 1;
        this.vDown[i15] = i;
        this.vUp[i15] = i2 + 1;
        int i16 = 0;
        while (i16 <= i14) {
            int i17 = -i16;
            for (int i18 = i17; i18 <= i16; i18 += 2) {
                int i19 = i18 + i14;
                if (i18 != i17) {
                    if (i18 != i16) {
                        int[] iArr3 = this.vDown;
                    }
                    int[] iArr4 = this.vDown;
                    iArr4[i19] = iArr4[i19 - 1] + 1;
                    i7 = this.vDown[i19];
                    i8 = ((i7 - i) + i3) - i18;
                    while (i7 < i2 && i8 < i4 && this.left.charAt(i7) == this.right.charAt(i8)) {
                        i7++;
                        this.vDown[i19] = i7;
                        i8++;
                    }
                    if (i12 % 2 != 0 && i12 - i16 <= i18 && i18 <= i12 + i16) {
                        iArr2 = this.vUp;
                        i9 = i19 - i12;
                        if (iArr2[i9] > this.vDown[i19]) {
                            return buildSnake(iArr2[i9], (i18 + i) - i3, i2, i4);
                        }
                    }
                }
                int[] iArr5 = this.vDown;
                iArr5[i19] = iArr5[i19 + 1];
                i7 = this.vDown[i19];
                i8 = ((i7 - i) + i3) - i18;
                while (i7 < i2) {
                    i7++;
                    this.vDown[i19] = i7;
                    i8++;
                }
                iArr2 = this.vUp;
                i9 = i19 - i12;
                if (iArr2[i9] > this.vDown[i19]) {
                }
            }
            int i20 = i12 - i16;
            int i21 = i20;
            while (true) {
                int i22 = i12 + i16;
                if (i21 > i22) {
                    break;
                }
                int i23 = (i21 + i14) - i12;
                if (i21 != i20) {
                    if (i21 != i22) {
                        int[] iArr6 = this.vUp;
                    }
                    int[] iArr7 = this.vUp;
                    iArr7[i23] = iArr7[i23 - 1];
                    i5 = this.vUp[i23] - 1;
                    i6 = ((i5 - i) + i3) - i21;
                    while (i5 >= i && i6 >= i3 && this.left.charAt(i5) == this.right.charAt(i6)) {
                        this.vUp[i23] = i5;
                        i6--;
                        i5--;
                    }
                    if (i12 % 2 == 0 && i17 <= i21 && i21 <= i16) {
                        iArr = this.vUp;
                        if (iArr[i23] > this.vDown[i23 + i12]) {
                            return buildSnake(iArr[i23], (i21 + i) - i3, i2, i4);
                        }
                    }
                    i21 += 2;
                }
                int[] iArr8 = this.vUp;
                iArr8[i23] = iArr8[i23 + 1] - 1;
                i5 = this.vUp[i23] - 1;
                i6 = ((i5 - i) + i3) - i21;
                while (i5 >= i) {
                    this.vUp[i23] = i5;
                    i6--;
                    i5--;
                }
                iArr = this.vUp;
                if (iArr[i23] > this.vDown[i23 + i12]) {
                }
            }
        }
        throw new RuntimeException("Internal Error");
    }

    public EditScript<Character> getScript() {
        EditScript<Character> editScript = new EditScript<>();
        buildScript(0, this.left.length(), 0, this.right.length(), editScript);
        return editScript;
    }
}
