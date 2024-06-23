package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.zip.Checksum;
import tb.ds1;

/* access modifiers changed from: package-private */
@Immutable
/* compiled from: Taobao */
public final class ChecksumHashFunction extends b implements Serializable {
    private static final long serialVersionUID = 0;
    private final int bits;
    private final ImmutableSupplier<? extends Checksum> checksumSupplier;
    private final String toString;

    /* compiled from: Taobao */
    private final class b extends a {
        private final Checksum b;

        /* access modifiers changed from: protected */
        @Override // com.google.common.hash.a
        public void b(byte b2) {
            this.b.update(b2);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.hash.a
        public void e(byte[] bArr, int i, int i2) {
            this.b.update(bArr, i, i2);
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            long value = this.b.getValue();
            if (ChecksumHashFunction.this.bits == 32) {
                return HashCode.fromInt((int) value);
            }
            return HashCode.fromLong(value);
        }

        private b(Checksum checksum) {
            this.b = (Checksum) ds1.p(checksum);
        }
    }

    ChecksumHashFunction(ImmutableSupplier<? extends Checksum> immutableSupplier, int i, String str) {
        this.checksumSupplier = (ImmutableSupplier) ds1.p(immutableSupplier);
        ds1.f(i == 32 || i == 64, "bits (%s) must be either 32 or 64", i);
        this.bits = i;
        this.toString = (String) ds1.p(str);
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.bits;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new b((Checksum) this.checksumSupplier.get());
    }

    public String toString() {
        return this.toString;
    }
}
