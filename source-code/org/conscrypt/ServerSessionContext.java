package org.conscrypt;

public final class ServerSessionContext extends AbstractSessionContext {
    private SSLServerSessionCache persistentCache;

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractSessionContext
    public void onBeforeRemoveSession(NativeSslSession nativeSslSession) {
    }

    ServerSessionContext() {
        super(100);
        NativeCrypto.SSL_CTX_set_session_id_context(this.sslCtxNativePointer, this, new byte[]{32});
    }

    public void setPersistentCache(SSLServerSessionCache sSLServerSessionCache) {
        this.persistentCache = sSLServerSessionCache;
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractSessionContext
    public NativeSslSession getSessionFromPersistentCache(byte[] bArr) {
        byte[] sessionData;
        NativeSslSession newInstance;
        SSLServerSessionCache sSLServerSessionCache = this.persistentCache;
        if (sSLServerSessionCache == null || (sessionData = sSLServerSessionCache.getSessionData(bArr)) == null || (newInstance = NativeSslSession.newInstance(this, sessionData, null, -1)) == null || !newInstance.isValid()) {
            return null;
        }
        cacheSession(newInstance);
        return newInstance;
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractSessionContext
    public void onBeforeAddSession(NativeSslSession nativeSslSession) {
        byte[] bytes;
        if (this.persistentCache != null && (bytes = nativeSslSession.toBytes()) != null) {
            this.persistentCache.putSessionData(nativeSslSession.toSSLSession(), bytes);
        }
    }
}
