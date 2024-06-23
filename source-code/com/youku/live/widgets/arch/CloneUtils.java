package com.youku.live.widgets.arch;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.protocol.IDeepClonable;
import java.util.Map;

/* compiled from: Taobao */
public class CloneUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    public static Double clone(Double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "782995036")) {
            return (Double) ipChange.ipc$dispatch("782995036", new Object[]{d});
        } else if (d == null) {
            return null;
        } else {
            return Double.valueOf(d.doubleValue());
        }
    }

    public static Float clone(Float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1609752040")) {
            return (Float) ipChange.ipc$dispatch("1609752040", new Object[]{f});
        } else if (f == null) {
            return null;
        } else {
            return Float.valueOf(f.floatValue());
        }
    }

    public static Integer clone(Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1274203812")) {
            return (Integer) ipChange.ipc$dispatch("1274203812", new Object[]{num});
        } else if (num == null) {
            return null;
        } else {
            return Integer.valueOf(num.intValue());
        }
    }

    public static Long clone(Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-402813892")) {
            return (Long) ipChange.ipc$dispatch("-402813892", new Object[]{l});
        } else if (l == null) {
            return null;
        } else {
            return Long.valueOf(l.longValue());
        }
    }

    public static Boolean clone(Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1638454192")) {
            return (Boolean) ipChange.ipc$dispatch("-1638454192", new Object[]{bool});
        } else if (bool == null) {
            return null;
        } else {
            return Boolean.valueOf(bool.booleanValue());
        }
    }

    public static <Type> Type clone(Type type) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-932153060")) {
            return (Type) ipChange.ipc$dispatch("-932153060", new Object[]{type});
        } else if (type instanceof IDeepClonable) {
            return (Type) type.deepClone();
        } else {
            if (type instanceof Map) {
                return null;
            }
            return type;
        }
    }
}
