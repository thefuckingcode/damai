package com.taobao.android.riverlogger.remote;

import com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient;
import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft_17;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ServerHandshake;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class RVLWebSocketClient extends WebSocketClient {
    private static SSLSocketFactory sslSocketFactory;
    private final WebSocketCallback callback;
    private final AtomicBoolean isOpen = new AtomicBoolean(false);
    private final ConcurrentLinkedQueue<String> pendingMessages = new ConcurrentLinkedQueue<>();

    public RVLWebSocketClient(URI uri, WebSocketCallback webSocketCallback) {
        super(uri, new Draft_17(), null, 60000);
        if ("wss".equals(uri.getScheme())) {
            setSslSocketFactory(getSSLSocketFactory());
        }
        this.callback = webSocketCallback;
    }

    private static SSLSocketFactory getSSLSocketFactory() {
        if (sslSocketFactory == null) {
            try {
                TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance.init((KeyStore) null);
                TrustManager[] trustManagers = instance.getTrustManagers();
                if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                    throw new IllegalStateException("Unexpected default trust managers: " + Arrays.toString(trustManagers));
                }
                SSLContext instance2 = SSLContext.getInstance("SSL");
                instance2.init(null, new TrustManager[]{(X509TrustManager) trustManagers[0]}, null);
                sslSocketFactory = instance2.getSocketFactory();
            } catch (KeyManagementException | KeyStoreException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return sslSocketFactory;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void onClose(int i, String str, boolean z) {
        this.callback.onSocketClose(i, str);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void onError(Exception exc) {
        this.callback.onSocketError(exc.getMessage());
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void onMessage(String str) {
        if (str != null && str.length() > 0) {
            this.callback.onSocketMessage(str);
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void onOpen(ServerHandshake serverHandshake) {
        while (true) {
            String poll = this.pendingMessages.poll();
            if (poll != null) {
                super.send(poll);
            } else {
                this.isOpen.set(true);
                return;
            }
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket, com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void send(String str) {
        if (this.isOpen.get()) {
            super.send(str);
        } else {
            this.pendingMessages.add(str);
        }
    }
}
