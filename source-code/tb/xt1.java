package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class xt1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String[] a(long j) {
        String str;
        StringBuilder sb;
        StringBuilder sb2;
        String str2;
        StringBuilder sb3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "842335269")) {
            return (String[]) ipChange.ipc$dispatch("842335269", new Object[]{Long.valueOf(j)});
        }
        long j2 = j / 86400;
        long j3 = (j / 3600) % 24;
        long j4 = (j / 60) % 60;
        long j5 = j % 60;
        if (j2 == 0) {
            str = "";
        } else {
            if (j2 < 10) {
                sb3 = new StringBuilder();
                sb3.append("0");
            } else {
                sb3 = new StringBuilder();
                sb3.append("");
            }
            sb3.append(j2);
            str = sb3.toString();
        }
        if (j3 < 10) {
            sb = new StringBuilder();
            sb.append("0");
        } else {
            sb = new StringBuilder();
            sb.append("");
        }
        sb.append(j3);
        String sb4 = sb.toString();
        if (j4 < 10) {
            sb2 = new StringBuilder();
            sb2.append("0");
        } else {
            sb2 = new StringBuilder();
            sb2.append("");
        }
        sb2.append(j4);
        String sb5 = sb2.toString();
        if (j5 < 10) {
            str2 = "0" + j5;
        } else {
            str2 = "" + j5;
        }
        return new String[]{str, sb4, sb5, str2};
    }
}
