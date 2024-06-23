package tb;

import android.content.Context;
import com.ta.utdid2.device.UTDevice;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.JsonUtility;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UtilityImpl;
import org.json.JSONObject;

/* compiled from: Taobao */
public class ze0 {
    private static final String a = "ze0";

    public static byte[] a(Context context, int i, long j) {
        try {
            JSONObject build = new JsonUtility.JsonObjectBuilder().put("id", Integer.valueOf(i)).put("utdid", UTDevice.getUtdid(context)).put("appKey", ACCSManager.mDefaultAppkey).put("regId", OrangeAdapter.isRegIdSwitchEnableAndValid(context) ? OrangeAdapter.getRegId(context) : "").put("aaid", UtilityImpl.getAaid(context)).put("happenTime", Long.valueOf(j)).put("type", "device").build();
            byte[] bytes = build.toString().getBytes("utf-8");
            ALog.i(a, "buildEventData", "data", build.toString());
            return bytes;
        } catch (Throwable th) {
            ALog.e(a, "buildEventData", th, new Object[0]);
            return null;
        }
    }
}
