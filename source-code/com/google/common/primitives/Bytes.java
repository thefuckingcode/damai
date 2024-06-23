package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;

@GwtCompatible
/* compiled from: Taobao */
public final class Bytes {

    @GwtCompatible
    /* compiled from: Taobao */
    private static class ByteArrayAsList extends AbstractList<Byte> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final byte[] array;
        final int end;
        final int start;

        ByteArrayAsList(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Byte) && Bytes.d(this.array, ((Byte) obj).byteValue(), this.start, this.end) != -1;
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteArrayAsList)) {
                return super.equals(obj);
            }
            ByteArrayAsList byteArrayAsList = (ByteArrayAsList) obj;
            int size = size();
            if (byteArrayAsList.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.array[this.start + i] != byteArrayAsList.array[byteArrayAsList.start + i]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 1;
            for (int i2 = this.start; i2 < this.end; i2++) {
                i = (i * 31) + Bytes.c(this.array[i2]);
            }
            return i;
        }

        public int indexOf(Object obj) {
            int d;
            if (!(obj instanceof Byte) || (d = Bytes.d(this.array, ((Byte) obj).byteValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return d - this.start;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(Object obj) {
            int e;
            if (!(obj instanceof Byte) || (e = Bytes.e(this.array, ((Byte) obj).byteValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return e - this.start;
        }

        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.List, java.util.AbstractList
        public List<Byte> subList(int i, int i2) {
            ds1.v(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            byte[] bArr = this.array;
            int i3 = this.start;
            return new ByteArrayAsList(bArr, i + i3, i3 + i2);
        }

        /* access modifiers changed from: package-private */
        public byte[] toByteArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
            sb.append(jl1.ARRAY_START);
            sb.append((int) this.array[this.start]);
            int i = this.start;
            while (true) {
                i++;
                if (i < this.end) {
                    sb.append(AVFSCacheConstants.COMMA_SEP);
                    sb.append((int) this.array[i]);
                } else {
                    sb.append(jl1.ARRAY_END);
                    return sb.toString();
                }
            }
        }

        ByteArrayAsList(byte[] bArr, int i, int i2) {
            this.array = bArr;
            this.start = i;
            this.end = i2;
        }

        @Override // java.util.List, java.util.AbstractList
        public Byte get(int i) {
            ds1.n(i, size());
            return Byte.valueOf(this.array[this.start + i]);
        }

        public Byte set(int i, Byte b) {
            ds1.n(i, size());
            byte[] bArr = this.array;
            int i2 = this.start;
            byte b2 = bArr[i2 + i];
            bArr[i2 + i] = ((Byte) ds1.p(b)).byteValue();
            return Byte.valueOf(b2);
        }
    }

    public static int c(byte b) {
        return b;
    }

    /* access modifiers changed from: private */
    public static int d(byte[] bArr, byte b, int i, int i2) {
        while (i < i2) {
            if (bArr[i] == b) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static int e(byte[] bArr, byte b, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            if (bArr[i3] == b) {
                return i3;
            }
        }
        return -1;
    }
}
