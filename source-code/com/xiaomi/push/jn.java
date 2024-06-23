package com.xiaomi.push;

/* compiled from: Taobao */
public class jn extends jp {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private ix f806a;

    public jn(int i) {
        this.f806a = new ix(i);
    }

    @Override // com.xiaomi.push.jp, com.xiaomi.push.jp
    public int a(byte[] bArr, int i, int i2) {
        byte[] a2 = this.f806a.m685a();
        if (i2 > this.f806a.a() - this.a) {
            i2 = this.f806a.a() - this.a;
        }
        if (i2 > 0) {
            System.arraycopy(a2, this.a, bArr, i, i2);
            this.a += i2;
        }
        return i2;
    }

    @Override // com.xiaomi.push.jp, com.xiaomi.push.jp
    /* renamed from: a  reason: collision with other method in class */
    public void m726a(byte[] bArr, int i, int i2) {
        this.f806a.write(bArr, i, i2);
    }

    public int a_() {
        return this.f806a.size();
    }
}
