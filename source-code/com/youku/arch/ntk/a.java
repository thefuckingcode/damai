package com.youku.arch.ntk;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class a {
    private static transient /* synthetic */ IpChange $ipChange;
    private static AbstractC0255a a;

    /* renamed from: com.youku.arch.ntk.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public interface AbstractC0255a {
    }

    public static synchronized void a(AbstractC0255a aVar) {
        synchronized (a.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1576383874")) {
                ipChange.ipc$dispatch("1576383874", new Object[]{aVar});
                return;
            }
            a = aVar;
        }
    }
}
