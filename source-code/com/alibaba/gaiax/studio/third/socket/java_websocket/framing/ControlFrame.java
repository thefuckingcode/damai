package com.alibaba.gaiax.studio.third.socket.java_websocket.framing;

import androidx.annotation.Keep;
import com.alibaba.gaiax.studio.third.socket.java_websocket.enums.Opcode;
import com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions.InvalidDataException;
import com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions.InvalidFrameException;

@Keep
/* compiled from: Taobao */
public abstract class ControlFrame extends FramedataImpl1 {
    public ControlFrame(Opcode opcode) {
        super(opcode);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.framing.FramedataImpl1
    public void isValid() throws InvalidDataException {
        if (!isFin()) {
            throw new InvalidFrameException("Control frame cant have fin==false set");
        } else if (isRSV1()) {
            throw new InvalidFrameException("Control frame cant have rsv1==true set");
        } else if (isRSV2()) {
            throw new InvalidFrameException("Control frame cant have rsv2==true set");
        } else if (isRSV3()) {
            throw new InvalidFrameException("Control frame cant have rsv3==true set");
        }
    }
}
