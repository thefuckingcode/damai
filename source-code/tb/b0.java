package tb;

import com.taobao.monitor.impl.trace.IDispatcher;

/* compiled from: Taobao */
public class b0 {
    public static final String ACTIVITY_FPS_DISPATCHER = "ACTIVITY_FPS_DISPATCHER";
    public static final String ACTIVITY_LIFECYCLE_DISPATCHER = "ACTIVITY_LIFECYCLE_DISPATCHER";
    public static final String APPLICATION_BACKGROUND_CHANGED_DISPATCHER = "APPLICATION_BACKGROUND_CHANGED_DISPATCHER";
    public static final String APPLICATION_GC_DISPATCHER = "APPLICATION_GC_DISPATCHER";
    public static final String APPLICATION_LOW_MEMORY_DISPATCHER = "APPLICATION_LOW_MEMORY_DISPATCHER";
    public static final String CUSTOM_PAGE_LIFECYCLE_DISPATCHER = "CUSTOM_PAGE_LIFECYCLE_DISPATCHER";
    public static final String FRAGMENT_LIFECYCLE_DISPATCHER = "FRAGMENT_LIFECYCLE_DISPATCHER";
    public static final String FRAGMENT_LIFECYCLE_FUNCTION_DISPATCHER = "FRAGMENT_LIFECYCLE_FUNCTION_DISPATCHER";
    public static final String IMAGE_STAGE_DISPATCHER = "IMAGE_STAGE_DISPATCHER";
    public static final String NETWORK_STAGE_DISPATCHER = "NETWORK_STAGE_DISPATCHER";
    public static final String PAGE_LEAVE_DISPATCHER = "PAGE_LEAVE_DISPATCHER";
    public static final String PAGE_RENDER_DISPATCHER = "PAGE_RENDER_DISPATCHER";
    public static final String WINDOW_EVENT_DISPATCHER = "WINDOW_EVENT_DISPATCHER";
    private static final b0 a = new b0();

    private b0() {
    }

    public static IDispatcher a(String str) {
        return e90.b(str);
    }

    public static b0 b() {
        return a;
    }
}
