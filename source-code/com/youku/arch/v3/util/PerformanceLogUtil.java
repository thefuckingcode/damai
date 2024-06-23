package com.youku.arch.v3.util;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.b;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R)\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00078B@\u0002X\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/youku/arch/v3/util/PerformanceLogUtil;", "", "", "markName", "Ltb/ur2;", "markStartPoint", "markEndPoint", "Ljava/util/concurrent/ConcurrentHashMap;", "", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Ljava/util/concurrent/ConcurrentHashMap;", "instance", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PerformanceLogUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final PerformanceLogUtil INSTANCE = new PerformanceLogUtil();
    @NotNull
    private static final Lazy instance$delegate = b.a(LazyThreadSafetyMode.SYNCHRONIZED, PerformanceLogUtil$instance$2.INSTANCE);

    private PerformanceLogUtil() {
    }

    private final ConcurrentHashMap<String, Long> getInstance() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1392736646")) {
            return (ConcurrentHashMap) instance$delegate.getValue();
        }
        return (ConcurrentHashMap) ipChange.ipc$dispatch("-1392736646", new Object[]{this});
    }

    public final synchronized void markEndPoint(@NotNull String str) {
        Long remove;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1132513851")) {
            ipChange.ipc$dispatch("1132513851", new Object[]{this, str});
            return;
        }
        k21.i(str, "markName");
        if (AppInfoProviderProxy.isDebuggable() && (remove = getInstance().remove(str)) != null) {
            long longValue = remove.longValue();
            Log.d("OneArch.Performance", "Code Segment " + str + " used " + (System.currentTimeMillis() - longValue) + " ms");
        }
    }

    public final synchronized void markStartPoint(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-342246718")) {
            ipChange.ipc$dispatch("-342246718", new Object[]{this, str});
            return;
        }
        k21.i(str, "markName");
        if (AppInfoProviderProxy.isDebuggable()) {
            getInstance().put(str, Long.valueOf(System.currentTimeMillis()));
            Log.d("OneArch.Performance", "Code Segment " + str + " start ");
        }
    }
}
