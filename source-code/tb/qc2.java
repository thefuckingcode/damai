package tb;

import android.app.Application;
import com.alibaba.fastjson.JSONObject;
import com.taobao.update.datasource.UpdateListener;

/* compiled from: Taobao */
public class qc2 extends ks2 implements UpdateListener {

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        private static final qc2 a = new qc2();
    }

    public static qc2 instance() {
        return a.a;
    }

    public void init(Application application) {
    }

    @Override // com.taobao.update.datasource.UpdateListener
    public void onUpdate(boolean z, JSONObject jSONObject, String str) {
        ai2.a(jSONObject.toJSONString());
    }

    @Override // com.taobao.update.datasource.UpdateListener
    public void patchProcessListener(UpdateListener.PatchListener patchListener) {
    }

    public String registerName() {
        return js2.SOPATCH;
    }
}
