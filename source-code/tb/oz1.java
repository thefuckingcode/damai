package tb;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.JsonUtility;
import com.taobao.accs.utl.RomInfoCollecter;
import com.taobao.accs.utl.UtilityImpl;

/* compiled from: Taobao */
public class oz1 extends y9 {
    public static final String JSON_CMD_REGISTER = "register";
    public String b;
    public String c;
    public String d;
    public String e = String.valueOf((int) Constants.SDK_VERSION_CODE);
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;

    public static byte[] b(Context context, String str, String str2) {
        oz1 oz1;
        Throwable th;
        try {
            String deviceId = UtilityImpl.getDeviceId(context);
            String packageName = context.getPackageName();
            String str3 = GlobalClientInfo.getInstance(context).getPackageInfo().versionName;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(deviceId)) {
                if (!TextUtils.isEmpty(str3)) {
                    oz1 = new oz1();
                    try {
                        oz1.a = "register";
                        oz1.b = str;
                        oz1.c = deviceId;
                        oz1.d = str3;
                        oz1.f = str2;
                        oz1.g = packageName;
                        oz1.j = Build.getBRAND();
                        oz1.k = Build.getMODEL();
                        String isNotificationEnabled = AdapterUtilityImpl.isNotificationEnabled(context);
                        oz1.h = isNotificationEnabled;
                        UtilityImpl.saveNotificationState(context, Constants.SP_CHANNEL_FILE_NAME, isNotificationEnabled);
                        oz1.i = RomInfoCollecter.getCollecter().collect();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    return oz1.a();
                }
            }
            ALog.e("RegisterDO", "buildRegister param null", "appKey", str, "utdid", deviceId, "appVersion", str3);
            return null;
        } catch (Throwable th3) {
            th = th3;
            oz1 = null;
            try {
                ALog.w("RegisterDO", "buildRegister", th.getMessage());
                if (oz1 == null) {
                    return null;
                }
                return oz1.a();
            } finally {
                if (oz1 != null) {
                    oz1.a();
                }
            }
        }
    }

    public byte[] a() {
        try {
            String jSONObject = new JsonUtility.JsonObjectBuilder().put("cmd", this.a).put("appKey", this.b).put("utdid", this.c).put("appVersion", this.d).put("sdkVersion", this.e).put("ttid", this.f).put("packageName", this.g).put("notifyEnable", this.h).put("romInfo", this.i).put("c0", this.j).put("c1", this.k).put("c2", this.l).put("c3", this.m).put("c4", this.n).put("c5", this.o).put("c6", this.p).build().toString();
            ALog.i("RegisterDO", "buildData", "data", jSONObject);
            return jSONObject.getBytes("utf-8");
        } catch (Throwable th) {
            ALog.e("RegisterDO", "buildData", th, new Object[0]);
            return null;
        }
    }
}
