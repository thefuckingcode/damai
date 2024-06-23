package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: Taobao */
public class v20 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static {
        new SimpleDateFormat("dd天 hh:mm:ss");
        new SimpleDateFormat("MM月dd日 EEEE HH:mm");
        new SimpleDateFormat("yyyy年MM月");
        new SimpleDateFormat("yyyy.MM.dd");
        new SimpleDateFormat("yyyy.MM.dd HH:mm");
    }

    public static String a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1136962073")) {
            return (String) ipChange.ipc$dispatch("1136962073", new Object[]{str});
        }
        return new SimpleDateFormat(str).format(new Date(System.currentTimeMillis())).toString();
    }

    public static Date b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "384324906")) {
            return (Date) ipChange.ipc$dispatch("384324906", new Object[]{str});
        }
        try {
            return a.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
