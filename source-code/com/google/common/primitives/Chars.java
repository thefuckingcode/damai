package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public final class Chars {
    public static final int BYTES = 2;

    @GwtCompatible
    /* compiled from: Taobao */
    private static class CharArrayAsList extends AbstractList<Character> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final char[] array;
        final int end;
        final int start;

        CharArrayAsList(char[] cArr) {
            this(cArr, 0, cArr.length);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Character) && Chars.e(this.array, ((Character) obj).charValue(), this.start, this.end) != -1;
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CharArrayAsList)) {
                return super.equals(obj);
            }
            CharArrayAsList charArrayAsList = (CharArrayAsList) obj;
            int size = size();
            if (charArrayAsList.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.array[this.start + i] != charArrayAsList.array[charArrayAsList.start + i]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 1;
            for (int i2 = this.start; i2 < this.end; i2++) {
                i = (i * 31) + Chars.d(this.array[i2]);
            }
            return i;
        }

        public int indexOf(Object obj) {
            int e;
            if (!(obj instanceof Character) || (e = Chars.e(this.array, ((Character) obj).charValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return e - this.start;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(Object obj) {
            int f;
            if (!(obj instanceof Character) || (f = Chars.f(this.array, ((Character) obj).charValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return f - this.start;
        }

        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.List, java.util.AbstractList
        public List<Character> subList(int i, int i2) {
            ds1.v(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            char[] cArr = this.array;
            int i3 = this.start;
            return new CharArrayAsList(cArr, i + i3, i3 + i2);
        }

        /* access modifiers changed from: package-private */
        public char[] toCharArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 3);
            sb.append(jl1.ARRAY_START);
            sb.append(this.array[this.start]);
            int i = this.start;
            while (true) {
                i++;
                if (i < this.end) {
                    sb.append(AVFSCacheConstants.COMMA_SEP);
                    sb.append(this.array[i]);
                } else {
                    sb.append(jl1.ARRAY_END);
                    return sb.toString();
                }
            }
        }

        CharArrayAsList(char[] cArr, int i, int i2) {
            this.array = cArr;
            this.start = i;
            this.end = i2;
        }

        @Override // java.util.List, java.util.AbstractList
        public Character get(int i) {
            ds1.n(i, size());
            return Character.valueOf(this.array[this.start + i]);
        }

        public Character set(int i, Character ch) {
            ds1.n(i, size());
            char[] cArr = this.array;
            int i2 = this.start;
            char c = cArr[i2 + i];
            cArr[i2 + i] = ((Character) ds1.p(ch)).charValue();
            return Character.valueOf(c);
        }
    }

    /* compiled from: Taobao */
    private enum LexicographicalComparator implements Comparator<char[]> {
        INSTANCE;

        public String toString() {
            return "Chars.lexicographicalComparator()";
        }

        public int compare(char[] cArr, char[] cArr2) {
            int min = Math.min(cArr.length, cArr2.length);
            for (int i = 0; i < min; i++) {
                int c = Chars.c(cArr[i], cArr2[i]);
                if (c != 0) {
                    return c;
                }
            }
            return cArr.length - cArr2.length;
        }
    }

    public static int c(char c, char c2) {
        return c - c2;
    }

    public static int d(char c) {
        return c;
    }

    /* access modifiers changed from: private */
    public static int e(char[] cArr, char c, int i, int i2) {
        while (i < i2) {
            if (cArr[i] == c) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static int f(char[] cArr, char c, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            if (cArr[i3] == c) {
                return i3;
            }
        }
        return -1;
    }
}
