package com.tencent.open.utils;

/* compiled from: Taobao */
public final class n implements Cloneable {
    private long a;

    public n(long j) {
        this.a = j;
    }

    public byte[] a() {
        long j = this.a;
        return new byte[]{(byte) ((int) (255 & j)), (byte) ((int) ((65280 & j) >> 8)), (byte) ((int) ((16711680 & j) >> 16)), (byte) ((int) ((j & 4278190080L) >> 24))};
    }

    public long b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof n) || this.a != ((n) obj).b()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (int) this.a;
    }
}
