package tb;

import android.database.Cursor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class iz0 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(Cursor cursor) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1352241400")) {
            ipChange.ipc$dispatch("-1352241400", new Object[]{cursor});
        } else if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                k91.b(th.getMessage(), th);
            }
        }
    }
}
