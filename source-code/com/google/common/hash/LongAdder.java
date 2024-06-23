package com.google.common.hash;

import com.google.common.hash.Striped64;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LongAdder extends Striped64 implements LongAddable {
    private static final long serialVersionUID = 7249069246863182397L;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.busy = 0;
        this.cells = null;
        this.base = objectInputStream.readLong();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(sum());
    }

    @Override // com.google.common.hash.LongAddable
    public void add(long j) {
        int length;
        Striped64.b bVar;
        Striped64.b[] bVarArr = this.cells;
        if (bVarArr == null) {
            long j2 = this.base;
            if (casBase(j2, j2 + j)) {
                return;
            }
        }
        int[] iArr = Striped64.threadHashCode.get();
        boolean z = true;
        if (!(iArr == null || bVarArr == null || (length = bVarArr.length) < 1 || (bVar = bVarArr[(length - 1) & iArr[0]]) == null)) {
            long j3 = bVar.a;
            z = bVar.a(j3, j3 + j);
            if (z) {
                return;
            }
        }
        retryUpdate(j, iArr, z);
    }

    public void decrement() {
        add(-1);
    }

    public double doubleValue() {
        return (double) sum();
    }

    public float floatValue() {
        return (float) sum();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.hash.Striped64
    public final long fn(long j, long j2) {
        return j + j2;
    }

    @Override // com.google.common.hash.LongAddable
    public void increment() {
        add(1);
    }

    public int intValue() {
        return (int) sum();
    }

    public long longValue() {
        return sum();
    }

    public void reset() {
        internalReset(0);
    }

    @Override // com.google.common.hash.LongAddable
    public long sum() {
        long j = this.base;
        Striped64.b[] bVarArr = this.cells;
        if (bVarArr != null) {
            for (Striped64.b bVar : bVarArr) {
                if (bVar != null) {
                    j += bVar.a;
                }
            }
        }
        return j;
    }

    public long sumThenReset() {
        long j = this.base;
        Striped64.b[] bVarArr = this.cells;
        this.base = 0;
        if (bVarArr != null) {
            for (Striped64.b bVar : bVarArr) {
                if (bVar != null) {
                    j += bVar.a;
                    bVar.a = 0;
                }
            }
        }
        return j;
    }

    public String toString() {
        return Long.toString(sum());
    }
}
