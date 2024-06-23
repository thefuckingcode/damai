package tb;

import android.content.Intent;
import com.alibaba.fastjson.JSONObject;

/* compiled from: Taobao */
public class e9 extends fl1 {
    private void q() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", (Object) f9.KEY_STATUS_H5_BACK);
        k(this.k, jSONObject);
        this.c.getDataManager().respondToLinkage(this.e);
    }

    @Override // tb.va, tb.fl1
    public void h(jn2 jn2) {
        super.h(jn2);
    }

    /* access modifiers changed from: protected */
    @Override // tb.fl1
    public void m(Intent intent, int i) {
        if (i != -1 || intent == null) {
            q();
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", (Object) f9.KEY_STATUS_H5_ASYNC_REQUEST);
        k(this.k, jSONObject);
        super.m(intent, i);
    }
}
