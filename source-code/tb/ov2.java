package tb;

import android.content.Context;
import android.util.Log;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.player.DMVideoPlayer;
import cn.damai.player.utils.network.NetworkType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
public class ov2 extends b {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        private static final ov2 a = new ov2();
    }

    public static final ov2 f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "3139269") ? (ov2) ipChange.ipc$dispatch("3139269", new Object[0]) : a.a;
    }

    public void g(Context context, String str, String str2, long j) {
        String str3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "536255402")) {
            ipChange.ipc$dispatch("536255402", new Object[]{this, context, str, str2, Long.valueOf(j)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_id", str);
        try {
            NetworkType b = zh1.b(context);
            if (b == NetworkType.NETWORK_WIFI) {
                str3 = "wifi";
            } else if (b == NetworkType.NETWORK_4G) {
                str3 = "4g";
            } else if (b == NetworkType.NETWORK_3G) {
                str3 = "3g";
            } else {
                str3 = b == NetworkType.NETWORK_2G ? "2g" : "unknow";
            }
            hashMap.put("networkType", str3);
            Log.e(DMVideoPlayer.TAG, "video_id: " + str + " networkType: " + str3 + " timeConsumed: " + j);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (j > 0) {
            hashMap.put("timeConsumed", String.valueOf(j));
        }
        c.e().D("video_performance", str2, "", "", hashMap, 19999);
    }
}
