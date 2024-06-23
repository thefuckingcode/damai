package com.taobao.weex.devtools.inspector.network;

import android.content.Context;
import com.taobao.weex.devtools.common.Util;
import com.taobao.weex.devtools.inspector.helper.ChromePeerManager;
import com.taobao.weex.devtools.inspector.helper.PeersRegisteredListener;
import javax.annotation.Nullable;

/* compiled from: Taobao */
public class NetworkPeerManager extends ChromePeerManager {
    private static NetworkPeerManager sInstance;
    private AsyncPrettyPrinterRegistry mAsyncPrettyPrinterRegistry;
    private AsyncPrettyPrinterInitializer mPrettyPrinterInitializer;
    private final ResponseBodyFileManager mResponseBodyFileManager;
    private final PeersRegisteredListener mTempFileCleanup;

    public NetworkPeerManager(ResponseBodyFileManager responseBodyFileManager) {
        AnonymousClass1 r0 = new PeersRegisteredListener() {
            /* class com.taobao.weex.devtools.inspector.network.NetworkPeerManager.AnonymousClass1 */

            /* access modifiers changed from: protected */
            @Override // com.taobao.weex.devtools.inspector.helper.PeersRegisteredListener
            public void onFirstPeerRegistered() {
                AsyncPrettyPrinterExecutorHolder.ensureInitialized();
                if (NetworkPeerManager.this.mAsyncPrettyPrinterRegistry == null && NetworkPeerManager.this.mPrettyPrinterInitializer != null) {
                    NetworkPeerManager.this.mAsyncPrettyPrinterRegistry = new AsyncPrettyPrinterRegistry();
                    NetworkPeerManager.this.mPrettyPrinterInitializer.populatePrettyPrinters(NetworkPeerManager.this.mAsyncPrettyPrinterRegistry);
                }
                NetworkPeerManager.this.mResponseBodyFileManager.cleanupFiles();
            }

            /* access modifiers changed from: protected */
            @Override // com.taobao.weex.devtools.inspector.helper.PeersRegisteredListener
            public void onLastPeerUnregistered() {
                NetworkPeerManager.this.mResponseBodyFileManager.cleanupFiles();
                AsyncPrettyPrinterExecutorHolder.shutdown();
            }
        };
        this.mTempFileCleanup = r0;
        this.mResponseBodyFileManager = responseBodyFileManager;
        setListener(r0);
    }

    @Nullable
    public static synchronized NetworkPeerManager getInstanceOrNull() {
        NetworkPeerManager networkPeerManager;
        synchronized (NetworkPeerManager.class) {
            networkPeerManager = sInstance;
        }
        return networkPeerManager;
    }

    public static synchronized NetworkPeerManager getOrCreateInstance(Context context) {
        NetworkPeerManager networkPeerManager;
        synchronized (NetworkPeerManager.class) {
            if (sInstance == null) {
                sInstance = new NetworkPeerManager(new ResponseBodyFileManager(context.getApplicationContext()));
            }
            networkPeerManager = sInstance;
        }
        return networkPeerManager;
    }

    @Nullable
    public AsyncPrettyPrinterRegistry getAsyncPrettyPrinterRegistry() {
        return this.mAsyncPrettyPrinterRegistry;
    }

    public ResponseBodyFileManager getResponseBodyFileManager() {
        return this.mResponseBodyFileManager;
    }

    public void setPrettyPrinterInitializer(AsyncPrettyPrinterInitializer asyncPrettyPrinterInitializer) {
        Util.throwIfNotNull(this.mPrettyPrinterInitializer);
        this.mPrettyPrinterInitializer = (AsyncPrettyPrinterInitializer) Util.throwIfNull(asyncPrettyPrinterInitializer);
    }
}
