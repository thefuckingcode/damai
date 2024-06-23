package org.conscrypt;

abstract class NativeRef {
    final long address;

    /* access modifiers changed from: package-private */
    public abstract void doFree(long j);

    NativeRef(long j) {
        if (j != 0) {
            this.address = j;
            return;
        }
        throw new NullPointerException("address == 0");
    }

    public boolean equals(Object obj) {
        if ((obj instanceof NativeRef) && ((NativeRef) obj).address == this.address) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.address;
        return (int) (j ^ (j >>> 32));
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            long j = this.address;
            if (j != 0) {
                doFree(j);
            }
        } finally {
            super.finalize();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class EC_GROUP extends NativeRef {
        EC_GROUP(long j) {
            super(j);
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.NativeRef
        public void doFree(long j) {
            NativeCrypto.EC_GROUP_clear_free(j);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class EC_POINT extends NativeRef {
        EC_POINT(long j) {
            super(j);
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.NativeRef
        public void doFree(long j) {
            NativeCrypto.EC_POINT_clear_free(j);
        }
    }

    static final class EVP_CIPHER_CTX extends NativeRef {
        EVP_CIPHER_CTX(long j) {
            super(j);
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.NativeRef
        public void doFree(long j) {
            NativeCrypto.EVP_CIPHER_CTX_free(j);
        }
    }

    static final class EVP_MD_CTX extends NativeRef {
        EVP_MD_CTX(long j) {
            super(j);
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.NativeRef
        public void doFree(long j) {
            NativeCrypto.EVP_MD_CTX_destroy(j);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class EVP_PKEY extends NativeRef {
        EVP_PKEY(long j) {
            super(j);
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.NativeRef
        public void doFree(long j) {
            NativeCrypto.EVP_PKEY_free(j);
        }
    }

    static final class EVP_PKEY_CTX extends NativeRef {
        EVP_PKEY_CTX(long j) {
            super(j);
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.NativeRef
        public void doFree(long j) {
            NativeCrypto.EVP_PKEY_CTX_free(j);
        }
    }

    static final class HMAC_CTX extends NativeRef {
        HMAC_CTX(long j) {
            super(j);
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.NativeRef
        public void doFree(long j) {
            NativeCrypto.HMAC_CTX_free(j);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class SSL_SESSION extends NativeRef {
        SSL_SESSION(long j) {
            super(j);
        }

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.NativeRef
        public void doFree(long j) {
            NativeCrypto.SSL_SESSION_free(j);
        }
    }
}
