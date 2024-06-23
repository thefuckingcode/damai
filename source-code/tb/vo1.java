package tb;

import com.alibaba.fastjson.JSONObject;
import com.taobao.accs.common.Constants;
import com.taobao.update.datasource.UpdateListener;
import com.taobao.updatecenter.hotpatch.HotPatchManager;

/* compiled from: Taobao */
public class vo1 implements UpdateListener {
    @Override // com.taobao.update.datasource.UpdateListener
    public void onUpdate(boolean z, JSONObject jSONObject, String str) {
        String str2 = "";
        if (jSONObject == null || jSONObject.isEmpty()) {
            is2.a("data_receiver", z + str2, "-1", "the data is null or empty");
            return;
        }
        uo1 a = uo1.a(jSONObject);
        if (jSONObject.containsKey(Constants.KEY_DATA_ID)) {
            str2 = jSONObject.getString(Constants.KEY_DATA_ID);
        }
        HotPatchManager.getInstance().dealPatchInfo(a, str, str2);
        is2.b("data_receiver", str2);
    }
}
