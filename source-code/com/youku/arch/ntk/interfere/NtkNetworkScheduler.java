package com.youku.arch.ntk.interfere;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.player.networkscheduler.INetworkScheduleInterface;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class NtkNetworkScheduler implements INetworkScheduleInterface {
    private static transient /* synthetic */ IpChange $ipChange;
    private Map<String, String> a;
    private Mode b;

    /* renamed from: com.youku.arch.ntk.interfere.NtkNetworkScheduler$1  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[Mode.values().length];
            a = iArr;
            iArr[Mode.NONE.ordinal()] = 1;
            a[Mode.LOCAL_DNS_FIRST.ordinal()] = 2;
            try {
                a[Mode.DOMAIN_MAPPING.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: Taobao */
    public enum Mode {
        NONE,
        LOCAL_DNS_FIRST,
        DOMAIN_MAPPING
    }

    /* compiled from: Taobao */
    private static class a {
        private static final NtkNetworkScheduler a = new NtkNetworkScheduler(null);
    }

    private NtkNetworkScheduler() {
        this.a = new HashMap();
        this.b = Mode.NONE;
    }

    /* synthetic */ NtkNetworkScheduler(AnonymousClass1 r1) {
        this();
    }

    public static NtkNetworkScheduler a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1845021455") ? (NtkNetworkScheduler) ipChange.ipc$dispatch("-1845021455", new Object[0]) : a.a;
    }

    public void a(Mode mode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-276529302")) {
            ipChange.ipc$dispatch("-276529302", new Object[]{this, mode});
            return;
        }
        this.b = mode;
    }

    public void a(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-956471706")) {
            ipChange.ipc$dispatch("-956471706", new Object[]{this, str, str2});
            return;
        }
        this.a.put(str, str2);
    }
}
