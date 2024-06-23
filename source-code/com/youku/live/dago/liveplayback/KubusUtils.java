package com.youku.live.dago.liveplayback;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.kubus.Event;
import com.youku.kubus.Response;
import java.util.Map;

/* compiled from: Taobao */
public class KubusUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    public static <T> T request(AlixPlayerContext alixPlayerContext, String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1125676919")) {
            return (T) request(alixPlayerContext, new Event(str));
        }
        return (T) ipChange.ipc$dispatch("-1125676919", new Object[]{alixPlayerContext, str});
    }

    public static boolean requestBoolean(AlixPlayerContext alixPlayerContext, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1138644381")) {
            return ((Boolean) ipChange.ipc$dispatch("-1138644381", new Object[]{alixPlayerContext, str})).booleanValue();
        }
        Event event = new Event(str);
        try {
            Response request = alixPlayerContext.getEventBus().request(event, null);
            if (request.code == 200) {
                boolean booleanValue = ((Boolean) request.body).booleanValue();
                alixPlayerContext.getEventBus().release(event);
                return booleanValue;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            alixPlayerContext.getEventBus().release(event);
            throw th;
        }
        alixPlayerContext.getEventBus().release(event);
        return false;
    }

    public static int requestInt(AlixPlayerContext alixPlayerContext, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "589245291")) {
            return ((Integer) ipChange.ipc$dispatch("589245291", new Object[]{alixPlayerContext, str})).intValue();
        }
        Event event = new Event(str);
        try {
            Response request = alixPlayerContext.getEventBus().request(event, null);
            if (request.code == 200) {
                int intValue = ((Integer) request.body).intValue();
                alixPlayerContext.getEventBus().release(event);
                return intValue;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            alixPlayerContext.getEventBus().release(event);
            throw th;
        }
        alixPlayerContext.getEventBus().release(event);
        return -1;
    }

    public static Map requestMap(AlixPlayerContext alixPlayerContext, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2123370464")) {
            return (Map) ipChange.ipc$dispatch("-2123370464", new Object[]{alixPlayerContext, str});
        }
        Event event = new Event(str);
        try {
            Response request = alixPlayerContext.getEventBus().request(event, null);
            if (request.code == 200) {
                Map map = (Map) request.body;
                alixPlayerContext.getEventBus().release(event);
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            alixPlayerContext.getEventBus().release(event);
            throw th;
        }
        alixPlayerContext.getEventBus().release(event);
        return null;
    }

    public static <T> T request(AlixPlayerContext alixPlayerContext, Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2067304387")) {
            return (T) ipChange.ipc$dispatch("-2067304387", new Object[]{alixPlayerContext, event});
        }
        try {
            Response request = alixPlayerContext.getEventBus().request(event, null);
            if (request.code == 200) {
                T t = (T) request.body;
                alixPlayerContext.getEventBus().release(event);
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            alixPlayerContext.getEventBus().release(event);
            throw th;
        }
        alixPlayerContext.getEventBus().release(event);
        return null;
    }

    public static boolean requestBoolean(AlixPlayerContext alixPlayerContext, Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1962860349")) {
            return ((Boolean) ipChange.ipc$dispatch("-1962860349", new Object[]{alixPlayerContext, event})).booleanValue();
        }
        try {
            Response request = alixPlayerContext.getEventBus().request(event, null);
            if (request.code == 200) {
                boolean booleanValue = ((Boolean) request.body).booleanValue();
                alixPlayerContext.getEventBus().release(event);
                return booleanValue;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            alixPlayerContext.getEventBus().release(event);
            throw th;
        }
        alixPlayerContext.getEventBus().release(event);
        return false;
    }
}
