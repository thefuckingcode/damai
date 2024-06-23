package org.conscrypt;

abstract class PeerInfoProvider {
    private static final PeerInfoProvider NULL_PEER_INFO_PROVIDER = new PeerInfoProvider() {
        /* class org.conscrypt.PeerInfoProvider.AnonymousClass1 */

        /* access modifiers changed from: package-private */
        @Override // org.conscrypt.PeerInfoProvider
        public String getHostname() {
            return null;
        }

        @Override // org.conscrypt.PeerInfoProvider
        public String getHostnameOrIP() {
            return null;
        }

        @Override // org.conscrypt.PeerInfoProvider
        public int getPort() {
            return -1;
        }
    };

    /* access modifiers changed from: package-private */
    public abstract String getHostname();

    /* access modifiers changed from: package-private */
    public abstract String getHostnameOrIP();

    /* access modifiers changed from: package-private */
    public abstract int getPort();

    PeerInfoProvider() {
    }

    static PeerInfoProvider nullProvider() {
        return NULL_PEER_INFO_PROVIDER;
    }

    static PeerInfoProvider forHostAndPort(final String str, final int i) {
        return new PeerInfoProvider() {
            /* class org.conscrypt.PeerInfoProvider.AnonymousClass2 */

            /* access modifiers changed from: package-private */
            @Override // org.conscrypt.PeerInfoProvider
            public String getHostname() {
                return str;
            }

            @Override // org.conscrypt.PeerInfoProvider
            public String getHostnameOrIP() {
                return str;
            }

            @Override // org.conscrypt.PeerInfoProvider
            public int getPort() {
                return i;
            }
        };
    }
}
