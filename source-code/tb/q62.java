package tb;

import android.text.TextUtils;
import cn.damai.seatdecoder.seat_vr.bean.StaticSeat3DVrInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class q62 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static p62 a(Map<String, List<StaticSeat3DVrInfo>> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1602139881")) {
            return (p62) ipChange.ipc$dispatch("-1602139881", new Object[]{map});
        } else if (map == null) {
            return null;
        } else {
            Iterator<Map.Entry<String, List<StaticSeat3DVrInfo>>> it = map.entrySet().iterator();
            long j = 0;
            long j2 = 0;
            long j3 = 0;
            long j4 = 0;
            long j5 = 0;
            long j6 = 0;
            long j7 = 0;
            long j8 = 0;
            while (it.hasNext()) {
                Map.Entry<String, List<StaticSeat3DVrInfo>> next = it.next();
                if (next != null) {
                    List<StaticSeat3DVrInfo> value = next.getValue();
                    long j9 = j7;
                    int i = 0;
                    while (i < value.size()) {
                        StaticSeat3DVrInfo staticSeat3DVrInfo = value.get(i);
                        long d = j ^ ((long) nu0.d(staticSeat3DVrInfo.getSid()));
                        j2 ^= (long) nu0.d(staticSeat3DVrInfo.getFloorId());
                        j3 ^= (long) nu0.a(staticSeat3DVrInfo.getFov());
                        j4 ^= (long) nu0.a(staticSeat3DVrInfo.getFov());
                        j5 ^= (long) nu0.a(staticSeat3DVrInfo.getFov());
                        j6 ^= (long) nu0.e(staticSeat3DVrInfo.getImg());
                        j9 ^= (long) nu0.e(staticSeat3DVrInfo.getThumb());
                        j8 ^= (long) nu0.e(staticSeat3DVrInfo.getImgHash());
                        i++;
                        j = d;
                    }
                    it = it;
                    j7 = j9;
                }
            }
            p62 p62 = new p62();
            p62.m(String.valueOf(j));
            p62.n(String.valueOf(j2));
            p62.i(String.valueOf(j3));
            p62.j(String.valueOf(j4));
            p62.p(String.valueOf(j5));
            p62.l(String.valueOf(j6));
            p62.o(String.valueOf(j7));
            p62.k(String.valueOf(j8));
            return p62;
        }
    }

    public static boolean b(String str, Map<String, List<StaticSeat3DVrInfo>> map) {
        p62 a;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "79790489")) {
            return ((Boolean) ipChange.ipc$dispatch("79790489", new Object[]{str, map})).booleanValue();
        }
        if (TextUtils.isEmpty(str) || map == null || (a = a(map)) == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("sidHash");
            if ((string != null && !string.equals(a.e())) || (string == null && a.e() != null)) {
                return false;
            }
            String string2 = jSONObject.getString("standIdHash");
            if ((string2 != null && !string2.equals(a.f())) || (string2 == null && a.f() != null)) {
                return false;
            }
            String string3 = jSONObject.getString("fovHash");
            if ((string3 != null && !string3.equals(a.a())) || (string3 == null && a.a() != null)) {
                return false;
            }
            String string4 = jSONObject.getString("horizontalHash");
            if ((string4 != null && !string4.equals(a.b())) || (string4 == null && a.b() != null)) {
                return false;
            }
            String string5 = jSONObject.getString("verticalHash");
            if ((string5 != null && !string5.equals(a.h())) || (string5 == null && a.h() != null)) {
                return false;
            }
            String string6 = jSONObject.getString("imgHash");
            if ((string6 != null && !string6.equals(a.d())) || (string6 == null && a.d() != null)) {
                return false;
            }
            String string7 = jSONObject.getString("thumbHash");
            if ((string7 != null && !string7.equals(a.g())) || (string7 == null && a.g() != null)) {
                return false;
            }
            String string8 = jSONObject.getString("imgEncryptHash");
            return (string8 == null || string8.equals(a.c())) && (string8 != null || a.c() == null);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
