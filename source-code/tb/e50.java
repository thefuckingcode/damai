package tb;

import android.util.Log;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata;
import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher;
import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.ResponseDelivery;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
public class e50 implements IResponseDispatcher {
    @Override // com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher
    public void onConnectFailed(Throwable th, ResponseDelivery responseDelivery) {
        responseDelivery.onConnectFailed(th);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher
    public void onConnected(ResponseDelivery responseDelivery) {
        responseDelivery.onConnected();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher
    public void onDisconnect(ResponseDelivery responseDelivery) {
        if (responseDelivery != null) {
            responseDelivery.onDisconnect();
        } else {
            Log.e("DefaultResponseDispatch", "onDisconnect: ResponseDelivery is null");
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher
    public void onMessage(String str, ResponseDelivery responseDelivery) {
        responseDelivery.onMessage(str, (Object) null);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher
    public void onPing(Framedata framedata, ResponseDelivery responseDelivery) {
        responseDelivery.onPing(framedata);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher
    public void onPong(Framedata framedata, ResponseDelivery responseDelivery) {
        responseDelivery.onPong(framedata);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher
    public void onSendDataError(ie0 ie0, ResponseDelivery responseDelivery) {
        responseDelivery.onSendDataError(ie0);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher
    public void onMessage(ByteBuffer byteBuffer, ResponseDelivery responseDelivery) {
        responseDelivery.onMessage(byteBuffer, (Object) null);
    }
}
