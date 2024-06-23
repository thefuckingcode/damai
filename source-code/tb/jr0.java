package tb;

import com.alibaba.fastjson.JSONObject;
import com.youku.gaiax.js.api.IGaiaXPromise;
import com.youku.gaiax.provider.module.js.GaiaXBuildInProviderModule;

/* compiled from: Taobao */
public final /* synthetic */ class jr0 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ IGaiaXPromise c;

    public /* synthetic */ jr0(String str, JSONObject jSONObject, IGaiaXPromise iGaiaXPromise) {
        this.a = str;
        this.b = jSONObject;
        this.c = iGaiaXPromise;
    }

    public final void run() {
        GaiaXBuildInProviderModule.a(this.a, this.b, this.c);
    }
}
