package com.alibaba.gaiax.studio.third.socket.java_websocket.framing;

import androidx.annotation.Keep;
import com.alibaba.gaiax.studio.third.socket.java_websocket.enums.Opcode;

@Keep
/* compiled from: Taobao */
public class ContinuousFrame extends DataFrame {
    public ContinuousFrame() {
        super(Opcode.CONTINUOUS);
    }
}
