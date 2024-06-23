package org.conscrypt;

import java.io.IOException;
import java.net.Socket;

public class PreKitKatPlatformOpenSSLSocketAdapterFactory extends BaseOpenSSLSocketAdapterFactory {
    public PreKitKatPlatformOpenSSLSocketAdapterFactory(OpenSSLSocketFactoryImpl openSSLSocketFactoryImpl) {
        super(openSSLSocketFactoryImpl);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.net.Socket, org.conscrypt.PreKitKatPlatformOpenSSLSocketImplAdapter] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // org.conscrypt.BaseOpenSSLSocketAdapterFactory
    public Socket wrap(OpenSSLSocketImpl openSSLSocketImpl) throws IOException {
        return new PreKitKatPlatformOpenSSLSocketImplAdapter(openSSLSocketImpl);
    }
}
