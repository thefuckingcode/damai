package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class jt2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static Map<String, String> a(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1793157010")) {
            return (Map) ipChange.ipc$dispatch("-1793157010", new Object[]{map});
        }
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (map == null || map.size() <= 0 || (r1 = map.keySet().iterator()) == null) {
            return null;
        }
        for (String str : map.keySet()) {
            String b = b(map.get(str));
            if (str != null) {
                hashMap.put(str, b);
            }
        }
        return hashMap;
    }

    public static String b(Object obj) {
        StringBuilder sb;
        int byteValue;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-996609904")) {
            return (String) ipChange.ipc$dispatch("-996609904", new Object[]{obj});
        } else if (obj == null) {
            return "";
        } else {
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof Integer) {
                sb = new StringBuilder();
                sb.append("");
                byteValue = ((Integer) obj).intValue();
            } else {
                if (obj instanceof Long) {
                    sb = new StringBuilder();
                    sb.append("");
                    sb.append(((Long) obj).longValue());
                } else if (obj instanceof Double) {
                    sb = new StringBuilder();
                    sb.append("");
                    sb.append(((Double) obj).doubleValue());
                } else if (obj instanceof Float) {
                    sb = new StringBuilder();
                    sb.append("");
                    sb.append(((Float) obj).floatValue());
                } else if (obj instanceof Short) {
                    sb = new StringBuilder();
                    sb.append("");
                    byteValue = ((Short) obj).shortValue();
                } else if (obj instanceof Byte) {
                    sb = new StringBuilder();
                    sb.append("");
                    byteValue = ((Byte) obj).byteValue();
                } else if (obj instanceof Boolean) {
                    return ((Boolean) obj).toString();
                } else {
                    return obj instanceof Character ? ((Character) obj).toString() : obj.toString();
                }
                return sb.toString();
            }
            sb.append(byteValue);
            return sb.toString();
        }
    }
}
