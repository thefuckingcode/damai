package com.taobao.android.dinamicx.monitor;

import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import java.util.Set;
import tb.we0;
import tb.xe0;

/* compiled from: Taobao */
public class RuntimeProfilingInfoCollector {
    private static RuntimeProfilingInfoCollector c;
    private Set<ICollector> a;
    private Set<EventChainCollector> b;

    /* compiled from: Taobao */
    public interface EventChainCollector {
        void onCollectChainNodeInfo(we0 we0, xe0 xe0);

        void onCollectChainStartInfo(we0 we0);
    }

    /* compiled from: Taobao */
    public interface ICollector {
        void onCollectErrorInfo(e eVar, boolean z);

        void onCollectPerformanceInfo(int i, String str, String str2, String str3, DXTemplateItem dXTemplateItem, double d);
    }

    private RuntimeProfilingInfoCollector() {
    }

    @NonNull
    public static RuntimeProfilingInfoCollector c() {
        if (c == null) {
            synchronized (RuntimeProfilingInfoCollector.class) {
                if (c == null) {
                    c = new RuntimeProfilingInfoCollector();
                }
            }
        }
        return c;
    }

    public void a(@NonNull e eVar, boolean z) {
        Set<ICollector> set = this.a;
        if (set != null) {
            for (ICollector iCollector : set) {
                try {
                    iCollector.onCollectErrorInfo(eVar, z);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public void b(int i, String str, String str2, String str3, DXTemplateItem dXTemplateItem, double d) {
        Set<ICollector> set = this.a;
        if (set != null) {
            for (ICollector iCollector : set) {
                try {
                    iCollector.onCollectPerformanceInfo(i, str, str2, str3, dXTemplateItem, d);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public void d(we0 we0, xe0 xe0) {
        Set<EventChainCollector> set = this.b;
        if (set != null) {
            for (EventChainCollector eventChainCollector : set) {
                try {
                    eventChainCollector.onCollectChainNodeInfo(we0, xe0);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public void e(we0 we0) {
        Set<EventChainCollector> set = this.b;
        if (set != null) {
            for (EventChainCollector eventChainCollector : set) {
                try {
                    eventChainCollector.onCollectChainStartInfo(we0);
                } catch (Throwable unused) {
                }
            }
        }
    }
}
