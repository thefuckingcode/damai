package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public class s30 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(List<ByteBuffer> list, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1797967450")) {
            ipChange.ipc$dispatch("-1797967450", new Object[]{list, str});
        } else if (nn.c()) {
            String str2 = str + ":=";
            Iterator<ByteBuffer> it = list.iterator();
            while (it.hasNext()) {
                str2 = str2 + tf2.d(it.next()) + "|";
            }
            nn.a("binary", str2);
        }
    }

    public static void b(List<Long> list, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "697579594")) {
            ipChange.ipc$dispatch("697579594", new Object[]{list, str});
        } else if (nn.c()) {
            String str2 = str + ":=";
            Iterator<Long> it = list.iterator();
            while (it.hasNext()) {
                str2 = str2 + tf2.e(String.valueOf(it.next().longValue()).getBytes()) + "|";
            }
            nn.a("binary", str2);
        }
    }

    public static void c(List<Long> list, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "480104799")) {
            ipChange.ipc$dispatch("480104799", new Object[]{list, str});
        } else if (nn.c()) {
            String str2 = str + ":=";
            Iterator<Long> it = list.iterator();
            while (it.hasNext()) {
                str2 = str2 + it.next() + "|";
            }
            nn.a("binary", str2);
        }
    }

    public static void d(List<String> list, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2108685610")) {
            ipChange.ipc$dispatch("2108685610", new Object[]{list, str});
        } else if (nn.c()) {
            String str2 = str + ":=";
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                str2 = str2 + it.next() + "|";
            }
            nn.a("binary", str2);
        }
    }
}
