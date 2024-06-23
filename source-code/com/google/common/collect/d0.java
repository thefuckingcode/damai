package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;

@GwtCompatible(emulated = true, serializable = true)
/* compiled from: Taobao */
class d0<K> extends c0<K> {
    @VisibleForTesting
    transient long[] i;
    private transient int j;
    private transient int k;

    d0(int i2) {
        this(i2, 1.0f);
    }

    private int E(int i2) {
        return (int) (this.i[i2] >>> 32);
    }

    private int F(int i2) {
        return (int) this.i[i2];
    }

    private void G(int i2, int i3) {
        long[] jArr = this.i;
        jArr[i2] = (jArr[i2] & 4294967295L) | (((long) i3) << 32);
    }

    private void H(int i2, int i3) {
        if (i2 == -2) {
            this.j = i3;
        } else {
            I(i2, i3);
        }
        if (i3 == -2) {
            this.k = i2;
        } else {
            G(i3, i2);
        }
    }

    private void I(int i2, int i3) {
        long[] jArr = this.i;
        jArr[i2] = (jArr[i2] & -4294967296L) | (((long) i3) & 4294967295L);
    }

    @Override // com.google.common.collect.c0
    public void a() {
        super.a();
        this.j = -2;
        this.k = -2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.c0
    public int e() {
        int i2 = this.j;
        if (i2 == -2) {
            return -1;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.c0
    public void n(int i2, float f) {
        super.n(i2, f);
        this.j = -2;
        this.k = -2;
        long[] jArr = new long[i2];
        this.i = jArr;
        Arrays.fill(jArr, -1L);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.c0
    public void o(int i2, K k2, int i3, int i4) {
        super.o(i2, k2, i3, i4);
        H(this.k, i2);
        H(i2, -2);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.c0
    public void p(int i2) {
        int C = C() - 1;
        H(E(i2), F(i2));
        if (i2 < C) {
            H(E(C), i2);
            H(i2, F(C));
        }
        super.p(i2);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.c0
    public int s(int i2) {
        int F = F(i2);
        if (F == -2) {
            return -1;
        }
        return F;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.c0
    public int t(int i2, int i3) {
        return i2 == C() ? i3 : i2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.c0
    public void y(int i2) {
        super.y(i2);
        long[] jArr = this.i;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i2);
        this.i = copyOf;
        Arrays.fill(copyOf, length, i2, -1L);
    }

    d0(int i2, float f) {
        super(i2, f);
    }
}
