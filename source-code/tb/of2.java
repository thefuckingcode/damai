package tb;

import android.text.TextUtils;
import com.alibaba.gaiax.studio.third.socket.java_websocket.client.WebSocketClient;
import com.alibaba.gaiax.studio.third.socket.websocket.request.Request;

/* compiled from: Taobao */
public class of2 implements Request<String> {
    private String a;

    of2() {
    }

    /* renamed from: a */
    public String getRequestData() {
        return this.a;
    }

    /* renamed from: b */
    public void setRequestData(String str) {
        this.a = str;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.request.Request
    public void release() {
        d02.b(this);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.request.Request
    public void send(WebSocketClient webSocketClient) {
        webSocketClient.send(this.a);
    }

    public String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = TextUtils.isEmpty(this.a) ? "null" : this.a;
        return String.format("@StringRequest%s,requestText:%s", objArr);
    }
}
