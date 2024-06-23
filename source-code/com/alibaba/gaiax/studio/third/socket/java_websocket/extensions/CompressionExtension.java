package com.alibaba.gaiax.studio.third.socket.java_websocket.extensions;

import androidx.annotation.Keep;
import com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions.InvalidDataException;
import com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions.InvalidFrameException;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.ControlFrame;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.DataFrame;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata;

@Keep
/* compiled from: Taobao */
public abstract class CompressionExtension extends DefaultExtension {
    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.extensions.IExtension, com.alibaba.gaiax.studio.third.socket.java_websocket.extensions.DefaultExtension
    public void isFrameValid(Framedata framedata) throws InvalidDataException {
        if ((framedata instanceof DataFrame) && (framedata.isRSV2() || framedata.isRSV3())) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.isRSV1() + " RSV2: " + framedata.isRSV2() + " RSV3: " + framedata.isRSV3());
        } else if (!(framedata instanceof ControlFrame)) {
        } else {
            if (framedata.isRSV1() || framedata.isRSV2() || framedata.isRSV3()) {
                throw new InvalidFrameException("bad rsv RSV1: " + framedata.isRSV1() + " RSV2: " + framedata.isRSV2() + " RSV3: " + framedata.isRSV3());
            }
        }
    }
}
