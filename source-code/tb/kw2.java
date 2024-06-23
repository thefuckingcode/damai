package tb;

import android.util.LruCache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Collection;

/* compiled from: Taobao */
public class kw2 {
    private static transient /* synthetic */ IpChange $ipChange;

    static {
        new LruCache(32);
    }

    public static boolean a(Collection collection) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1150824977")) {
            return collection == null || collection.size() == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("1150824977", new Object[]{collection})).booleanValue();
    }
}
