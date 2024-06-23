package com.taobao.weex.devtools.inspector.helper;

import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcPeer;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public abstract class PeersRegisteredListener implements PeerRegistrationListener {
    private AtomicInteger mPeers = new AtomicInteger(0);

    /* access modifiers changed from: protected */
    public abstract void onFirstPeerRegistered();

    /* access modifiers changed from: protected */
    public abstract void onLastPeerUnregistered();

    /* access modifiers changed from: protected */
    public void onPeerAdded(JsonRpcPeer jsonRpcPeer) {
    }

    @Override // com.taobao.weex.devtools.inspector.helper.PeerRegistrationListener
    public final void onPeerRegistered(JsonRpcPeer jsonRpcPeer) {
        if (this.mPeers.incrementAndGet() == 1) {
            onFirstPeerRegistered();
        }
        onPeerAdded(jsonRpcPeer);
    }

    /* access modifiers changed from: protected */
    public void onPeerRemoved(JsonRpcPeer jsonRpcPeer) {
    }

    @Override // com.taobao.weex.devtools.inspector.helper.PeerRegistrationListener
    public final void onPeerUnregistered(JsonRpcPeer jsonRpcPeer) {
        if (this.mPeers.decrementAndGet() == 0) {
            onLastPeerUnregistered();
        }
        onPeerRemoved(jsonRpcPeer);
    }
}
