package tb;

import android.text.TextUtils;
import cn.damai.seatdecoder.common.bean.StaticSeat;
import cn.damai.seatdecoder.common.bean.StaticStandSeat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class c72 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static y62 a(List<StaticStandSeat> list) {
        int i;
        List<StaticStandSeat> list2 = list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1723309197")) {
            return (y62) ipChange.ipc$dispatch("1723309197", new Object[]{list2});
        } else if (list2 == null || list.isEmpty()) {
            return null;
        } else {
            long j = 0;
            long j2 = 0;
            long j3 = 0;
            long j4 = 0;
            long j5 = 0;
            long j6 = 0;
            long j7 = 0;
            long j8 = 0;
            long j9 = 0;
            long j10 = 0;
            long j11 = 0;
            int i2 = 0;
            while (i2 < list.size()) {
                StaticStandSeat staticStandSeat = list2.get(i2);
                if (staticStandSeat.getSeats() == null) {
                    i = i2;
                } else {
                    List<StaticSeat> seats = staticStandSeat.getSeats();
                    i = i2;
                    int i3 = 0;
                    while (i3 < seats.size()) {
                        StaticSeat staticSeat = seats.get(i3);
                        long c = j ^ ((long) nu0.c(staticSeat.getSid()));
                        j2 ^= (long) nu0.b(staticSeat.getX());
                        j3 ^= (long) nu0.b(staticSeat.getY());
                        j4 ^= (long) nu0.e(staticSeat.getChint());
                        j5 ^= (long) nu0.e(staticSeat.getFn());
                        j6 ^= (long) nu0.e(staticSeat.getRhint());
                        j7 ^= (long) nu0.c(staticSeat.getPlid());
                        j8 ^= (long) nu0.c(staticSeat.getGroupId());
                        j9 ^= (long) nu0.c(staticSeat.getGroupPriceId());
                        j10 ^= (long) nu0.a(staticSeat.getAngle());
                        j11 ^= (long) nu0.b(staticSeat.getI());
                        i3++;
                        seats = seats;
                        j = c;
                    }
                }
                i2 = i + 1;
                list2 = list;
            }
            y62 y62 = new y62();
            y62.s(String.valueOf(j));
            y62.u(String.valueOf(j2));
            y62.v(String.valueOf(j3));
            y62.m(String.valueOf(j4));
            y62.n(String.valueOf(j5));
            y62.r(String.valueOf(j6));
            y62.q(String.valueOf(j7));
            y62.o(String.valueOf(j8));
            y62.p(String.valueOf(j9));
            y62.l(String.valueOf(j10));
            y62.t(String.valueOf(j11));
            return y62;
        }
    }

    public static boolean b(String str, List<StaticStandSeat> list) {
        y62 a;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "448166659")) {
            return ((Boolean) ipChange.ipc$dispatch("448166659", new Object[]{str, list})).booleanValue();
        }
        if (TextUtils.isEmpty(str) || list == null || (a = a(list)) == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("sidHash");
            if ((string != null && !string.equals(a.h())) || (string == null && a.h() != null)) {
                return false;
            }
            String string2 = jSONObject.getString("xHash");
            if ((string2 != null && !string2.equals(a.j())) || (string2 == null && a.j() != null)) {
                return false;
            }
            String string3 = jSONObject.getString("yHash");
            if ((string3 != null && !string3.equals(a.k())) || (string3 == null && a.k() != null)) {
                return false;
            }
            String string4 = jSONObject.getString("chintHash");
            if ((string4 != null && !string4.equals(a.b())) || (string4 == null && a.b() != null)) {
                return false;
            }
            String string5 = jSONObject.getString("fnHash");
            if ((string5 != null && !string5.equals(a.c())) || (string5 == null && a.c() != null)) {
                return false;
            }
            String string6 = jSONObject.getString("rhintHash");
            if ((string6 != null && !string6.equals(a.g())) || (string6 == null && a.g() != null)) {
                return false;
            }
            String string7 = jSONObject.getString("plidHash");
            if ((string7 != null && !string7.equals(a.f())) || (string7 == null && a.f() != null)) {
                return false;
            }
            String string8 = jSONObject.getString("groupIdHash");
            if ((string8 != null && !string8.equals(a.d())) || (string8 == null && a.d() != null)) {
                return false;
            }
            String string9 = jSONObject.getString("groupPriceIdHash");
            if ((string9 != null && !string9.equals(a.e())) || (string9 == null && a.e() != null)) {
                return false;
            }
            String string10 = jSONObject.getString("angleHash");
            if ((string10 != null && !string10.equals(a.a())) || (string10 == null && a.a() != null)) {
                return false;
            }
            String string11 = jSONObject.getString("iHash");
            return (string11 == null || string11.equals(a.i())) && (string11 != null || a.i() == null);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
