package com.alibaba.gaiax.studio.third.socket.java_websocket.framing;

import androidx.annotation.Keep;
import com.alibaba.gaiax.studio.third.socket.java_websocket.enums.Opcode;
import com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions.InvalidDataException;

@Keep
/* compiled from: Taobao */
public abstract class DataFrame extends FramedataImpl1 {
    public DataFrame(Opcode opcode) {
        super(opcode);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.framing.FramedataImpl1
    public void isValid() throws InvalidDataException {
    }
}
