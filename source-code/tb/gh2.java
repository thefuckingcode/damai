package tb;

import android.text.TextUtils;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.JsonUtility;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UtilityImpl;

/* compiled from: Taobao */
public class gh2 extends y9 {
    public static final String JSON_CMD_DISABLEPUSH = "disablePush";
    public static final String JSON_CMD_ENABLEPUSH = "enablePush";
    public String b;
    public String c;
    public String d;

    public static byte[] b(String str, String str2, String str3, boolean z) {
        gh2 gh2 = new gh2();
        gh2.b = str;
        gh2.c = str2;
        gh2.d = str3;
        if (z) {
            gh2.a = JSON_CMD_ENABLEPUSH;
        } else {
            gh2.a = JSON_CMD_DISABLEPUSH;
        }
        return gh2.a();
    }

    public byte[] a() {
        try {
            JsonUtility.JsonObjectBuilder jsonObjectBuilder = new JsonUtility.JsonObjectBuilder();
            jsonObjectBuilder.put("cmd", this.a).put("appKey", this.b);
            if (TextUtils.isEmpty(this.c)) {
                jsonObjectBuilder.put("utdid", this.d);
            } else {
                jsonObjectBuilder.put("deviceId", this.c);
            }
            if (OrangeAdapter.isRegIdSwitchEnableAndValid(GlobalClientInfo.getContext())) {
                jsonObjectBuilder.put("regId", OrangeAdapter.getRegId(GlobalClientInfo.getContext()));
                jsonObjectBuilder.put("utdid", UtilityImpl.getDeviceId(GlobalClientInfo.getContext()));
            }
            String jSONObject = jsonObjectBuilder.build().toString();
            ALog.i("SwitchDO", "buildData", "data", jSONObject);
            return jSONObject.getBytes("utf-8");
        } catch (Throwable th) {
            ALog.e("SwitchDO", "buildData", th, new Object[0]);
            return null;
        }
    }
}
