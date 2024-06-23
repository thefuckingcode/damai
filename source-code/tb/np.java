package tb;

import android.database.Cursor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.LinkedHashMap;

/* compiled from: Taobao */
public final class np {
    private static transient /* synthetic */ IpChange $ipChange;

    public static k30 a(Cursor cursor) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-64651603")) {
            return (k30) ipChange.ipc$dispatch("-64651603", new Object[]{cursor});
        }
        k30 k30 = new k30();
        int columnCount = cursor.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            k30.a(cursor.getColumnName(i), cursor.getString(i));
        }
        return k30;
    }

    public static <T> T b(si2<T> si2, Cursor cursor) throws Throwable {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-58993005")) {
            return (T) ipChange.ipc$dispatch("-58993005", new Object[]{si2, cursor});
        }
        T a = si2.a();
        LinkedHashMap<String, ak> b = si2.b();
        int columnCount = cursor.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            ak akVar = b.get(cursor.getColumnName(i));
            if (akVar != null) {
                akVar.i(a, cursor, i);
            }
        }
        return a;
    }
}
