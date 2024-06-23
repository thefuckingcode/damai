package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ie implements Comparable<ie> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int CACHE_CACHE_EXPIRED = 2;
    public static final int CACHE_CACHE_VALID = 1;
    public static final int CACHE_NO_CACHE = 0;
    @NotNull
    public static final a Companion = new a(null);
    private int a;
    private long b = System.currentTimeMillis();
    @Nullable
    private String c;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public ie(@NotNull String str, @Nullable String str2) {
        k21.i(str, "key");
        this.c = str2;
    }

    /* renamed from: a */
    public int compareTo(@NotNull ie ieVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-39823685")) {
            return ((Integer) ipChange.ipc$dispatch("-39823685", new Object[]{this, ieVar})).intValue();
        }
        k21.i(ieVar, "co");
        long j = this.b;
        long j2 = ieVar.b;
        if (j > j2) {
            return 1;
        }
        return j < j2 ? -1 : 0;
    }

    public final int b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1913258053")) {
            return this.a;
        }
        return ((Integer) ipChange.ipc$dispatch("1913258053", new Object[]{this})).intValue();
    }

    public final long c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1337614510")) {
            return this.b;
        }
        return ((Long) ipChange.ipc$dispatch("1337614510", new Object[]{this})).longValue();
    }

    @Nullable
    public final String d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "614796328")) {
            return this.c;
        }
        return (String) ipChange.ipc$dispatch("614796328", new Object[]{this});
    }

    public final void e(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1758665475")) {
            ipChange.ipc$dispatch("-1758665475", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.a = i;
    }

    public final void f(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "979932094")) {
            ipChange.ipc$dispatch("979932094", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.b = j;
    }

    public final void g(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "75217230")) {
            ipChange.ipc$dispatch("75217230", new Object[]{this, str});
            return;
        }
        this.c = str;
    }
}
