package tb;

import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata;
import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher;
import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.ResponseDelivery;
import com.alibaba.gaiax.studio.third.socket.websocket.response.Response;

/* compiled from: Taobao */
public class mq1 implements Response<Framedata> {
    private Framedata a;

    mq1() {
    }

    /* renamed from: a */
    public Framedata getResponseData() {
        return this.a;
    }

    /* renamed from: b */
    public void setResponseData(Framedata framedata) {
        this.a = framedata;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.response.Response
    public void onResponse(IResponseDispatcher iResponseDispatcher, ResponseDelivery responseDelivery) {
        iResponseDispatcher.onPing(this.a, responseDelivery);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.response.Response
    public void release() {
        this.a = null;
        s02.g(this);
    }

    public String toString() {
        String str;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(hashCode());
        Framedata framedata = this.a;
        if (framedata == null) {
            str = "null";
        } else {
            str = framedata.toString();
        }
        objArr[1] = str;
        return String.format("[@PingResponse%s->Framedata:%s]", objArr);
    }
}
