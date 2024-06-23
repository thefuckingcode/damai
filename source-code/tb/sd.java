package tb;

import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher;
import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.ResponseDelivery;
import com.alibaba.gaiax.studio.third.socket.websocket.response.Response;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
public class sd implements Response<ByteBuffer> {
    private ByteBuffer a;

    sd() {
    }

    /* renamed from: a */
    public ByteBuffer getResponseData() {
        return this.a;
    }

    /* renamed from: b */
    public void setResponseData(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.response.Response
    public void onResponse(IResponseDispatcher iResponseDispatcher, ResponseDelivery responseDelivery) {
        iResponseDispatcher.onMessage(this.a, responseDelivery);
        release();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.response.Response
    public void release() {
        s02.f(this);
    }

    public String toString() {
        String str;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(hashCode());
        ByteBuffer byteBuffer = this.a;
        if (byteBuffer == null) {
            str = "null";
        } else {
            str = byteBuffer.toString();
        }
        objArr[1] = str;
        return String.format("[@ByteBufferResponse%s->ByteBuffer:%s]", objArr);
    }
}
