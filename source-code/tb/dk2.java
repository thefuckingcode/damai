package tb;

import android.text.TextUtils;
import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.IResponseDispatcher;
import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.ResponseDelivery;
import com.alibaba.gaiax.studio.third.socket.websocket.response.Response;

/* compiled from: Taobao */
public class dk2 implements Response<String> {
    private String a;

    dk2() {
    }

    /* renamed from: a */
    public String getResponseData() {
        return this.a;
    }

    /* renamed from: b */
    public void setResponseData(String str) {
        this.a = str;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.response.Response
    public void onResponse(IResponseDispatcher iResponseDispatcher, ResponseDelivery responseDelivery) {
        iResponseDispatcher.onMessage(this.a, responseDelivery);
        release();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.response.Response
    public void release() {
        s02.i(this);
    }

    public String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = TextUtils.isEmpty(this.a) ? "null" : this.a;
        return String.format("[@TextResponse%s->responseText:%s]", objArr);
    }
}
