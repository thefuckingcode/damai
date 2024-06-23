package tb;

import com.alibaba.appmonitor.event.EventType;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.HashMap;

/* compiled from: Taobao */
public class h82 {
    public static final String TNET_REQUEST_SEND_OFFLINE = "tnet_request_send";
    public static final String UPLOAD_TRAFFIC_OFFLINE = "upload_traffic";
    private static HashMap<Integer, String> g = null;
    public static int h = 1;
    public static int i = 2;
    public static int j = 3;
    public static int k = 4;
    public static int l = 5;
    public static int m = 6;
    public static final String module = "AppMonitor";
    public static int n = 7;
    public static int o = 8;
    public static int p = 9;
    public static int q = 10;
    public static int r = 11;
    public static int s = 12;
    public String a = "";
    public EventType b = null;
    public String c;
    public Double d;
    public DimensionValueSet e;
    public MeasureValueSet f;

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        g = hashMap;
        hashMap.put(1, "sampling_monitor");
        g.put(Integer.valueOf(i), "db_clean");
        g.put(Integer.valueOf(l), "db_monitor");
        g.put(Integer.valueOf(j), "upload_failed");
        g.put(Integer.valueOf(k), UPLOAD_TRAFFIC_OFFLINE);
        g.put(Integer.valueOf(m), "config_arrive");
        g.put(Integer.valueOf(n), TNET_REQUEST_SEND_OFFLINE);
        g.put(Integer.valueOf(o), "tnet_create_session");
        g.put(Integer.valueOf(p), "tnet_request_timeout");
        g.put(Integer.valueOf(q), "tent_request_error");
        g.put(Integer.valueOf(r), "datalen_overflow");
        g.put(Integer.valueOf(s), "logs_timeout");
    }

    private h82(String str, String str2, Double d2) {
        this.a = str;
        this.c = str2;
        this.d = d2;
        this.b = EventType.COUNTER;
    }

    public static h82 a(int i2, String str, Double d2) {
        return new h82(b(i2), str, d2);
    }

    private static String b(int i2) {
        return g.get(Integer.valueOf(i2));
    }

    public String toString() {
        return "SelfMonitorEvent{" + "arg='" + this.c + '\'' + ", monitorPoint='" + this.a + '\'' + ", type=" + this.b + ", value=" + this.d + ", dvs=" + this.e + ", mvs=" + this.f + '}';
    }
}
