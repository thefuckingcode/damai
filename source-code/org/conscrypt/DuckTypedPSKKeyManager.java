package org.conscrypt;

import java.lang.reflect.Method;
import java.net.Socket;
import javax.crypto.SecretKey;
import javax.net.ssl.SSLEngine;

/* access modifiers changed from: package-private */
@Deprecated
public final class DuckTypedPSKKeyManager implements PSKKeyManager {
    private final Object mDelegate;

    private DuckTypedPSKKeyManager(Object obj) {
        this.mDelegate = obj;
    }

    static DuckTypedPSKKeyManager getInstance(Object obj) throws NoSuchMethodException {
        Class<?> cls = obj.getClass();
        Method[] methods = PSKKeyManager.class.getMethods();
        for (Method method : methods) {
            if (!method.isSynthetic()) {
                Method method2 = cls.getMethod(method.getName(), method.getParameterTypes());
                Class<?> returnType = method2.getReturnType();
                Class<?> returnType2 = method.getReturnType();
                if (!returnType2.isAssignableFrom(returnType)) {
                    throw new NoSuchMethodException(method2 + " return value (" + returnType + ") incompatible with target return value (" + returnType2 + ")");
                }
            }
        }
        return new DuckTypedPSKKeyManager(obj);
    }

    @Override // org.conscrypt.PSKKeyManager
    public String chooseServerKeyIdentityHint(Socket socket) {
        try {
            return (String) this.mDelegate.getClass().getMethod("chooseServerKeyIdentityHint", Socket.class).invoke(this.mDelegate, socket);
        } catch (Exception e) {
            throw new RuntimeException("Failed to invoke chooseServerKeyIdentityHint", e);
        }
    }

    @Override // org.conscrypt.PSKKeyManager
    public String chooseServerKeyIdentityHint(SSLEngine sSLEngine) {
        try {
            return (String) this.mDelegate.getClass().getMethod("chooseServerKeyIdentityHint", SSLEngine.class).invoke(this.mDelegate, sSLEngine);
        } catch (Exception e) {
            throw new RuntimeException("Failed to invoke chooseServerKeyIdentityHint", e);
        }
    }

    @Override // org.conscrypt.PSKKeyManager
    public String chooseClientKeyIdentity(String str, Socket socket) {
        try {
            return (String) this.mDelegate.getClass().getMethod("chooseClientKeyIdentity", String.class, Socket.class).invoke(this.mDelegate, str, socket);
        } catch (Exception e) {
            throw new RuntimeException("Failed to invoke chooseClientKeyIdentity", e);
        }
    }

    @Override // org.conscrypt.PSKKeyManager
    public String chooseClientKeyIdentity(String str, SSLEngine sSLEngine) {
        try {
            return (String) this.mDelegate.getClass().getMethod("chooseClientKeyIdentity", String.class, SSLEngine.class).invoke(this.mDelegate, str, sSLEngine);
        } catch (Exception e) {
            throw new RuntimeException("Failed to invoke chooseClientKeyIdentity", e);
        }
    }

    @Override // org.conscrypt.PSKKeyManager
    public SecretKey getKey(String str, String str2, Socket socket) {
        try {
            return (SecretKey) this.mDelegate.getClass().getMethod("getKey", String.class, String.class, Socket.class).invoke(this.mDelegate, str, str2, socket);
        } catch (Exception e) {
            throw new RuntimeException("Failed to invoke getKey", e);
        }
    }

    @Override // org.conscrypt.PSKKeyManager
    public SecretKey getKey(String str, String str2, SSLEngine sSLEngine) {
        try {
            return (SecretKey) this.mDelegate.getClass().getMethod("getKey", String.class, String.class, SSLEngine.class).invoke(this.mDelegate, str, str2, sSLEngine);
        } catch (Exception e) {
            throw new RuntimeException("Failed to invoke getKey", e);
        }
    }
}
