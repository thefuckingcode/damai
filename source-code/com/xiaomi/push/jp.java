package com.xiaomi.push;

/* compiled from: Taobao */
public abstract class jp {
    public int a() {
        return 0;
    }

    public abstract int a(byte[] bArr, int i, int i2);

    public void a(int i) {
    }

    /* renamed from: a  reason: collision with other method in class */
    public abstract void m729a(byte[] bArr, int i, int i2);

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m730a() {
        return null;
    }

    public int b() {
        return -1;
    }

    public int b(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int a = a(bArr, i + i3, i2 - i3);
            if (a > 0) {
                i3 += a;
            } else {
                throw new jq("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes.");
            }
        }
        return i3;
    }
}
