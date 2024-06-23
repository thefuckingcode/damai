package tb;

import android.text.TextUtils;
import cn.damai.seatdecoder.common.bean.StaticStandSeat;
import cn.damai.seatdecoder.common.decoder.DecoderType;
import cn.damai.seatdecoder.seat.bean.SeatDataDecodeResult;
import cn.damai.seatdecoder.seat_vr.bean.Seat3DVrDataDecodeReulst;
import cn.damai.seatdecoder.seat_vr.bean.StaticSeat3DVrInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class gq {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[DecoderType.values().length];
            a = iArr;
            iArr[DecoderType.PB_GZIP.ordinal()] = 1;
            a[DecoderType.QUANTUM_GZIP.ordinal()] = 2;
        }
    }

    public static SeatDataDecodeResult a(String str, String str2) {
        DecoderType d;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1940700469")) {
            return (SeatDataDecodeResult) ipChange.ipc$dispatch("-1940700469", new Object[]{str, str2});
        }
        if (TextUtils.isEmpty(str2) || (d = d(str)) == null) {
            return null;
        }
        int i = a.a[d.ordinal()];
        if (i == 1) {
            try {
                return z62.b(str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (i == 2) {
            try {
                return a72.a(str2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static Seat3DVrDataDecodeReulst b(String str, String str2) {
        DecoderType d;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-767844463")) {
            return (Seat3DVrDataDecodeReulst) ipChange.ipc$dispatch("-767844463", new Object[]{str, str2});
        }
        if (!TextUtils.isEmpty(str2) && (d = d(str)) != null && a.a[d.ordinal()] == 1) {
            try {
                return s62.b(str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1601219754")) {
            return (String) ipChange.ipc$dispatch("1601219754", new Object[0]);
        }
        DecoderType[] values = DecoderType.values();
        if (values.length <= 0) {
            return null;
        }
        String str = "";
        for (DecoderType decoderType : values) {
            str = str + decoderType.getName() + ",";
        }
        return !TextUtils.isEmpty(str) ? str.substring(0, str.length() - 1) : str;
    }

    public static DecoderType d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1047293204")) {
            return (DecoderType) ipChange.ipc$dispatch("1047293204", new Object[]{str});
        } else if (TextUtils.isEmpty(str)) {
            return null;
        } else {
            DecoderType[] values = DecoderType.values();
            if (values.length <= 0) {
                return null;
            }
            for (int length = values.length - 1; length >= 0; length--) {
                DecoderType decoderType = values[length];
                if (str.equals(decoderType.getName())) {
                    return decoderType;
                }
            }
            return null;
        }
    }

    public static String e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1111645062") ? (String) ipChange.ipc$dispatch("-1111645062", new Object[0]) : "1.0.1";
    }

    public static boolean f(List<StaticStandSeat> list, String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2084525078")) {
            return c72.b(str, list);
        }
        return ((Boolean) ipChange.ipc$dispatch("2084525078", new Object[]{list, str})).booleanValue();
    }

    public static boolean g(Map<String, List<StaticSeat3DVrInfo>> map, String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1159571356")) {
            return q62.b(str, map);
        }
        return ((Boolean) ipChange.ipc$dispatch("1159571356", new Object[]{map, str})).booleanValue();
    }
}
