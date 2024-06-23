package com.taobao.weex.devtools.inspector.helper;

import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcPeer;

/* compiled from: Taobao */
public interface PeerRegistrationListener {
    void onPeerRegistered(JsonRpcPeer jsonRpcPeer);

    void onPeerUnregistered(JsonRpcPeer jsonRpcPeer);
}
