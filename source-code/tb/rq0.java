package tb;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.studio.GXSocket;

/* compiled from: Taobao */
public final /* synthetic */ class rq0 implements Runnable {
    public final /* synthetic */ GXSocket a;
    public final /* synthetic */ String b;
    public final /* synthetic */ JSONObject c;

    public /* synthetic */ rq0(GXSocket gXSocket, String str, JSONObject jSONObject) {
        this.a = gXSocket;
        this.b = str;
        this.c = jSONObject;
    }

    public final void run() {
        GXSocket.i(this.a, this.b, this.c);
    }
}
