package tb;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ez0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final LongSparseArray<a> a = new LongSparseArray<>();

    /* compiled from: Taobao */
    public static final class a {
        public long a;
        public long b;
        public boolean c;

        public a(long j, long j2, boolean z) {
            this.a = j;
            this.b = j2;
            this.c = z;
        }
    }

    @Nullable
    public static a a(long j) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1416718646")) {
            return a.get(j);
        }
        return (a) ipChange.ipc$dispatch("-1416718646", new Object[]{Long.valueOf(j)});
    }

    private static void b(long j, long j2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "341281447")) {
            ipChange.ipc$dispatch("341281447", new Object[]{Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)});
            return;
        }
        a.put(ep1.a(j2), new a(j, j2, z));
    }

    public static void c(long j, long j2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1204595280")) {
            ipChange.ipc$dispatch("1204595280", new Object[]{Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)});
            return;
        }
        b(j, j2, z);
    }

    public static void d(String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1802604958")) {
            ipChange.ipc$dispatch("-1802604958", new Object[]{str, Long.valueOf(j)});
        } else if (!TextUtils.isEmpty(str)) {
            try {
                c(Long.parseLong(str), j, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
