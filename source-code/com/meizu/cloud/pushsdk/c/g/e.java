package com.meizu.cloud.pushsdk.c.g;

import com.huawei.hms.opendevice.c;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public class e implements Serializable, Comparable<e> {
    static final char[] a = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final e b = a(new byte[0]);
    private static final long serialVersionUID = 1;
    final byte[] c;
    transient int d;
    transient String e;

    e(byte[] bArr) {
        this.c = bArr;
    }

    public static e a(InputStream inputStream, int i) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (i >= 0) {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read != -1) {
                    i2 += read;
                } else {
                    throw new EOFException();
                }
            }
            return new e(bArr);
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + i);
        }
    }

    public static e a(String str) {
        if (str != null) {
            e eVar = new e(str.getBytes(o.a));
            eVar.e = str;
            return eVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public static e a(byte... bArr) {
        if (bArr != null) {
            return new e((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    private e b(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.c));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        e a2 = a(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = e.class.getDeclaredField(c.a);
            declaredField.setAccessible(true);
            declaredField.set(this, a2.c);
        } catch (NoSuchFieldException unused) {
            throw new AssertionError();
        } catch (IllegalAccessException unused2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.c.length);
        objectOutputStream.write(this.c);
    }

    public byte a(int i) {
        return this.c[i];
    }

    /* renamed from: a */
    public int compareTo(e eVar) {
        int d2 = d();
        int d3 = eVar.d();
        int min = Math.min(d2, d3);
        for (int i = 0; i < min; i++) {
            int a2 = a(i) & 255;
            int a3 = eVar.a(i) & 255;
            if (a2 != a3) {
                return a2 < a3 ? -1 : 1;
            }
        }
        if (d2 == d3) {
            return 0;
        }
        return d2 < d3 ? -1 : 1;
    }

    public String a() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.c, o.a);
        this.e = str2;
        return str2;
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        byte[] bArr = this.c;
        bVar.c(bArr, 0, bArr.length);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        byte[] bArr2 = this.c;
        return i <= bArr2.length - i3 && i2 <= bArr.length - i3 && o.a(bArr2, i, bArr, i2, i3);
    }

    public e b() {
        return b(MessageDigestAlgorithms.MD5);
    }

    public String c() {
        byte[] bArr = this.c;
        char[] cArr = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = a;
            cArr[i] = cArr2[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public int d() {
        return this.c.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            int d2 = eVar.d();
            byte[] bArr = this.c;
            return d2 == bArr.length && eVar.a(0, bArr, 0, bArr.length);
        }
    }

    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.c);
        this.d = hashCode;
        return hashCode;
    }

    public String toString() {
        byte[] bArr = this.c;
        if (bArr.length == 0) {
            return "ByteString[size=0]";
        }
        if (bArr.length <= 16) {
            return String.format("ByteString[size=%s data=%s]", Integer.valueOf(bArr.length), c());
        }
        return String.format("ByteString[size=%s md5=%s]", Integer.valueOf(bArr.length), b().c());
    }
}
