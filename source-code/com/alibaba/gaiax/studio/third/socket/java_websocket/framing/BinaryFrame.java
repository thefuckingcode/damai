package com.alibaba.gaiax.studio.third.socket.java_websocket.framing;

import androidx.annotation.Keep;
import com.alibaba.gaiax.studio.third.socket.java_websocket.enums.Opcode;

@Keep
/* compiled from: Taobao */
public class BinaryFrame extends DataFrame {
    public BinaryFrame() {
        super(Opcode.BINARY);
    }
}
