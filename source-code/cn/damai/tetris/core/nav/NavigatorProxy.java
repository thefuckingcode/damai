package cn.damai.tetris.core.nav;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class NavigatorProxy {
    private static transient /* synthetic */ IpChange $ipChange;
    static INavigator a;

    /* compiled from: Taobao */
    public interface INavigator {
        void toUri(Context context, String str);
    }

    public static INavigator a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "677019735") ? (INavigator) ipChange.ipc$dispatch("677019735", new Object[0]) : a;
    }

    public static void b(INavigator iNavigator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1874946083")) {
            ipChange.ipc$dispatch("1874946083", new Object[]{iNavigator});
            return;
        }
        a = iNavigator;
    }
}
