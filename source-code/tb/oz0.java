package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class oz0 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ANDROID_SYS_API_FLOW_LIMIT_LOCKED = "ANDROID_SYS_API_FLOW_LIMIT_LOCKED";
    public static final String ANDROID_SYS_NETWORK_ERROR = "ANDROID_SYS_NETWORK_ERROR";
    public static final String ANDROID_SYS_NO_NETWORK = "ANDROID_SYS_NO_NETWORK";
    public static final String FAIL_SYS_FLOWLIMIT = "FAIL_SYS_FLOWLIMIT";
    public static final String FAIL_SYS_HTTP_CONNECT_TIMEOUT = "FAIL_SYS_HTTP_CONNECT_TIMEOUT";
    public static final String FAIL_SYS_HTTP_RESPONSE_TIMEOUT = "FAIL_SYS_HTTP_RESPONSE_TIMEOUT";
    public static final String FAIL_SYS_REQUEST_QUEUED = "FAIL_SYS_REQUEST_QUEUED";
    public static final String FAIL_SYS_SERVICE_FAULT = "FAIL_SYS_SERVICE_FAULT";
    public static final String FAIL_SYS_SERVICE_TIMEOUT = "FAIL_SYS_SERVICE_TIMEOUT";
    public static final String FAIL_SYS_TRAFFIC_LIMIT = "FAIL_SYS_TRAFFIC_LIMIT";
    public static final String SYSTEM_ERROR = "SYSTEM_ERROR";
    private static oz0 b;
    private List<String> a;

    private oz0() {
    }

    private void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1758807093")) {
            ipChange.ipc$dispatch("-1758807093", new Object[]{this});
        } else if (f92.d(this.a)) {
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            arrayList.add(FAIL_SYS_FLOWLIMIT);
            this.a.add(FAIL_SYS_TRAFFIC_LIMIT);
            this.a.add("FAIL_SYS_REQUEST_QUEUED");
            this.a.add("ANDROID_SYS_NO_NETWORK");
            this.a.add("ANDROID_SYS_API_FLOW_LIMIT_LOCKED");
            this.a.add("ANDROID_SYS_NETWORK_ERROR");
        }
    }

    public static synchronized oz0 b() {
        synchronized (oz0.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1813264705")) {
                return (oz0) ipChange.ipc$dispatch("1813264705", new Object[0]);
            }
            if (b == null) {
                b = new oz0();
            }
            return b;
        }
    }

    public boolean c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1115019892")) {
            return ((Boolean) ipChange.ipc$dispatch("-1115019892", new Object[]{this, str})).booleanValue();
        } else if (TextUtils.isEmpty(str)) {
            return false;
        } else {
            a();
            return this.a.contains(str);
        }
    }
}
