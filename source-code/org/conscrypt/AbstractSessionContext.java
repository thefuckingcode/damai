package org.conscrypt;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;

/* access modifiers changed from: package-private */
public abstract class AbstractSessionContext implements SSLSessionContext {
    private static final int DEFAULT_SESSION_TIMEOUT_SECONDS = 28800;
    private volatile int maximumSize;
    private final Map<ByteArray, NativeSslSession> sessions = new LinkedHashMap<ByteArray, NativeSslSession>() {
        /* class org.conscrypt.AbstractSessionContext.AnonymousClass1 */

        /* access modifiers changed from: protected */
        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<ByteArray, NativeSslSession> entry) {
            if (AbstractSessionContext.this.maximumSize <= 0 || size() <= AbstractSessionContext.this.maximumSize) {
                return false;
            }
            AbstractSessionContext.this.onBeforeRemoveSession(entry.getValue());
            return true;
        }
    };
    final long sslCtxNativePointer = NativeCrypto.SSL_CTX_new();
    private volatile int timeout = DEFAULT_SESSION_TIMEOUT_SECONDS;

    /* access modifiers changed from: package-private */
    public abstract NativeSslSession getSessionFromPersistentCache(byte[] bArr);

    /* access modifiers changed from: package-private */
    public abstract void onBeforeAddSession(NativeSslSession nativeSslSession);

    /* access modifiers changed from: package-private */
    public abstract void onBeforeRemoveSession(NativeSslSession nativeSslSession);

    AbstractSessionContext(int i) {
        this.maximumSize = i;
    }

    @Override // javax.net.ssl.SSLSessionContext
    public final Enumeration<byte[]> getIds() {
        final Iterator it;
        synchronized (this.sessions) {
            it = Arrays.asList(this.sessions.values().toArray(new NativeSslSession[this.sessions.size()])).iterator();
        }
        return new Enumeration<byte[]>() {
            /* class org.conscrypt.AbstractSessionContext.AnonymousClass2 */
            private NativeSslSession next;

            public boolean hasMoreElements() {
                if (this.next != null) {
                    return true;
                }
                while (it.hasNext()) {
                    NativeSslSession nativeSslSession = (NativeSslSession) it.next();
                    if (nativeSslSession.isValid()) {
                        this.next = nativeSslSession;
                        return true;
                    }
                }
                this.next = null;
                return false;
            }

            @Override // java.util.Enumeration
            public byte[] nextElement() {
                if (hasMoreElements()) {
                    byte[] id = this.next.getId();
                    this.next = null;
                    return id;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public final SSLSession getSession(byte[] bArr) {
        NativeSslSession nativeSslSession;
        if (bArr != null) {
            ByteArray byteArray = new ByteArray(bArr);
            synchronized (this.sessions) {
                nativeSslSession = this.sessions.get(byteArray);
            }
            if (nativeSslSession == null || !nativeSslSession.isValid()) {
                return null;
            }
            return nativeSslSession.toSSLSession();
        }
        throw new NullPointerException("sessionId");
    }

    public final int getSessionCacheSize() {
        return this.maximumSize;
    }

    public final int getSessionTimeout() {
        return this.timeout;
    }

    @Override // javax.net.ssl.SSLSessionContext
    public final void setSessionTimeout(int i) throws IllegalArgumentException {
        if (i >= 0) {
            synchronized (this.sessions) {
                this.timeout = i;
                if (i > 0) {
                    NativeCrypto.SSL_CTX_set_timeout(this.sslCtxNativePointer, this, (long) i);
                } else {
                    NativeCrypto.SSL_CTX_set_timeout(this.sslCtxNativePointer, this, 2147483647L);
                }
                Iterator<NativeSslSession> it = this.sessions.values().iterator();
                while (it.hasNext()) {
                    NativeSslSession next = it.next();
                    if (!next.isValid()) {
                        onBeforeRemoveSession(next);
                        it.remove();
                    }
                }
            }
            return;
        }
        throw new IllegalArgumentException("seconds < 0");
    }

    @Override // javax.net.ssl.SSLSessionContext
    public final void setSessionCacheSize(int i) throws IllegalArgumentException {
        if (i >= 0) {
            int i2 = this.maximumSize;
            this.maximumSize = i;
            if (i < i2) {
                trimToSize();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("size < 0");
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() throws Throwable {
        try {
            NativeCrypto.SSL_CTX_free(this.sslCtxNativePointer, this);
        } finally {
            super.finalize();
        }
    }

    /* access modifiers changed from: package-private */
    public final void cacheSession(NativeSslSession nativeSslSession) {
        byte[] id = nativeSslSession.getId();
        if (id != null && id.length != 0) {
            synchronized (this.sessions) {
                ByteArray byteArray = new ByteArray(id);
                if (this.sessions.containsKey(byteArray)) {
                    removeSession(this.sessions.get(byteArray));
                }
                onBeforeAddSession(nativeSslSession);
                this.sessions.put(byteArray, nativeSslSession);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void removeSession(NativeSslSession nativeSslSession) {
        byte[] id = nativeSslSession.getId();
        if (id != null && id.length != 0) {
            onBeforeRemoveSession(nativeSslSession);
            ByteArray byteArray = new ByteArray(id);
            synchronized (this.sessions) {
                this.sessions.remove(byteArray);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final NativeSslSession getSessionFromCache(byte[] bArr) {
        NativeSslSession nativeSslSession;
        if (bArr == null) {
            return null;
        }
        synchronized (this.sessions) {
            nativeSslSession = this.sessions.get(new ByteArray(bArr));
        }
        if (nativeSslSession == null || !nativeSslSession.isValid()) {
            return getSessionFromPersistentCache(bArr);
        }
        if (nativeSslSession.isSingleUse()) {
            removeSession(nativeSslSession);
        }
        return nativeSslSession;
    }

    private void trimToSize() {
        synchronized (this.sessions) {
            int size = this.sessions.size();
            if (size > this.maximumSize) {
                int i = size - this.maximumSize;
                Iterator<NativeSslSession> it = this.sessions.values().iterator();
                while (true) {
                    int i2 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    onBeforeRemoveSession(it.next());
                    it.remove();
                    i = i2;
                }
            }
        }
    }
}
