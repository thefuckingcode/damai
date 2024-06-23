package com.alibaba.gaiax.studio.third.socket.java_websocket.framing;

import androidx.annotation.Keep;
import com.alibaba.gaiax.studio.third.socket.java_websocket.enums.Opcode;
import com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions.InvalidDataException;
import com.alibaba.gaiax.studio.third.socket.java_websocket.util.Charsetfunctions;

@Keep
/* compiled from: Taobao */
public class TextFrame extends DataFrame {
    public TextFrame() {
        super(Opcode.TEXT);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.framing.FramedataImpl1, com.alibaba.gaiax.studio.third.socket.java_websocket.framing.DataFrame
    public void isValid() throws InvalidDataException {
        super.isValid();
        if (!Charsetfunctions.isValidUTF8(getPayloadData())) {
            throw new InvalidDataException(1007, "Received text is no valid utf8 string!");
        }
    }
}
