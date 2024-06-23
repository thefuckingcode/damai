package org.conscrypt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ClientSessionContext extends AbstractSessionContext {
    private SSLClientSessionCache persistentCache;
    private final Map<HostAndPort, List<NativeSslSession>> sessionsByHostAndPort = new HashMap();

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractSessionContext
    public NativeSslSession getSessionFromPersistentCache(byte[] bArr) {
        return null;
    }

    ClientSessionContext() {
        super(10);
    }

    public void setPersistentCache(SSLClientSessionCache sSLClientSessionCache) {
        this.persistentCache = sSLClientSessionCache;
    }

    /* access modifiers changed from: package-private */
    public synchronized NativeSslSession getCachedSession(String str, int i, SSLParametersImpl sSLParametersImpl) {
        boolean z;
        if (str == null) {
            return null;
        }
        NativeSslSession session = getSession(str, i);
        if (session == null) {
            return null;
        }
        String protocol = session.getProtocol();
        String[] strArr = sSLParametersImpl.enabledProtocols;
        int length = strArr.length;
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            } else if (protocol.equals(strArr[i2])) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (!z) {
            return null;
        }
        String cipherSuite = session.getCipherSuite();
        String[] enabledCipherSuites = sSLParametersImpl.getEnabledCipherSuites();
        int length2 = enabledCipherSuites.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length2) {
                break;
            } else if (cipherSuite.equals(enabledCipherSuites[i3])) {
                z2 = true;
                break;
            } else {
                i3++;
            }
        }
        if (!z2) {
            return null;
        }
        if (session.isSingleUse()) {
            removeSession(session);
        }
        return session;
    }

    /* access modifiers changed from: package-private */
    public int size() {
        int i;
        synchronized (this.sessionsByHostAndPort) {
            i = 0;
            for (List<NativeSslSession> list : this.sessionsByHostAndPort.values()) {
                i += list.size();
            }
        }
        return i;
    }

    private NativeSslSession getSession(String str, int i) {
        NativeSslSession nativeSslSession;
        byte[] sessionData;
        NativeSslSession newInstance;
        if (str == null) {
            return null;
        }
        HostAndPort hostAndPort = new HostAndPort(str, i);
        synchronized (this.sessionsByHostAndPort) {
            List<NativeSslSession> list = this.sessionsByHostAndPort.get(hostAndPort);
            nativeSslSession = (list == null || list.size() <= 0) ? null : list.get(0);
        }
        if (nativeSslSession != null && nativeSslSession.isValid()) {
            return nativeSslSession;
        }
        SSLClientSessionCache sSLClientSessionCache = this.persistentCache;
        if (sSLClientSessionCache == null || (sessionData = sSLClientSessionCache.getSessionData(str, i)) == null || (newInstance = NativeSslSession.newInstance(this, sessionData, str, i)) == null || !newInstance.isValid()) {
            return null;
        }
        putSession(hostAndPort, newInstance);
        return newInstance;
    }

    private void putSession(HostAndPort hostAndPort, NativeSslSession nativeSslSession) {
        synchronized (this.sessionsByHostAndPort) {
            List<NativeSslSession> list = this.sessionsByHostAndPort.get(hostAndPort);
            if (list == null) {
                list = new ArrayList<>();
                this.sessionsByHostAndPort.put(hostAndPort, list);
            }
            if (list.size() > 0 && list.get(0).isSingleUse() != nativeSslSession.isSingleUse()) {
                while (!list.isEmpty()) {
                    removeSession(list.get(0));
                }
                this.sessionsByHostAndPort.put(hostAndPort, list);
            }
            list.add(nativeSslSession);
        }
    }

    private void removeSession(HostAndPort hostAndPort, NativeSslSession nativeSslSession) {
        synchronized (this.sessionsByHostAndPort) {
            List<NativeSslSession> list = this.sessionsByHostAndPort.get(hostAndPort);
            if (list != null) {
                list.remove(nativeSslSession);
                if (list.isEmpty()) {
                    this.sessionsByHostAndPort.remove(hostAndPort);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractSessionContext
    public void onBeforeAddSession(NativeSslSession nativeSslSession) {
        byte[] bytes;
        String peerHost = nativeSslSession.getPeerHost();
        int peerPort = nativeSslSession.getPeerPort();
        if (peerHost != null) {
            putSession(new HostAndPort(peerHost, peerPort), nativeSslSession);
            if (this.persistentCache != null && !nativeSslSession.isSingleUse() && (bytes = nativeSslSession.toBytes()) != null) {
                this.persistentCache.putSessionData(nativeSslSession.toSSLSession(), bytes);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // org.conscrypt.AbstractSessionContext
    public void onBeforeRemoveSession(NativeSslSession nativeSslSession) {
        String peerHost = nativeSslSession.getPeerHost();
        if (peerHost != null) {
            removeSession(new HostAndPort(peerHost, nativeSslSession.getPeerPort()), nativeSslSession);
        }
    }

    /* access modifiers changed from: private */
    public static final class HostAndPort {
        final String host;
        final int port;

        HostAndPort(String str, int i) {
            this.host = str;
            this.port = i;
        }

        public int hashCode() {
            return (this.host.hashCode() * 31) + this.port;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof HostAndPort)) {
                return false;
            }
            HostAndPort hostAndPort = (HostAndPort) obj;
            if (!this.host.equals(hostAndPort.host) || this.port != hostAndPort.port) {
                return false;
            }
            return true;
        }
    }
}
