package com.alipay.android.phone.mobilesdk.socketcraft.drafts;

import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ClientHandshake;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ClientHandshakeBuilder;

/* compiled from: Taobao */
public class Draft_17 extends Draft_10 {
    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft, com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft_10
    public Draft.HandshakeState acceptHandshakeAsServer(ClientHandshake clientHandshake) {
        if (Draft_10.readVersion(clientHandshake) == 13) {
            return Draft.HandshakeState.MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft, com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft_10
    public Draft copyInstance() {
        return new Draft_17();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft, com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft_10
    public ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder clientHandshakeBuilder) {
        super.postProcessHandshakeRequestAsClient(clientHandshakeBuilder);
        clientHandshakeBuilder.put("Sec-WebSocket-Version", "13");
        return clientHandshakeBuilder;
    }
}
