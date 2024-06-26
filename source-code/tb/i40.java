package tb;

import android.content.Context;
import com.alibaba.pictures.dolores.cache.ICacheManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class i40 implements ICacheManager {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static String b = "dolorescache.db";
    private static long c = 86400000;
    @NotNull
    private final r22 a;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        @NotNull
        public final i40 a(@NotNull Context context, @NotNull String str, @NotNull String str2, int i, long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1919816189")) {
                return (i40) ipChange.ipc$dispatch("-1919816189", new Object[]{this, context, str, str2, Integer.valueOf(i), Long.valueOf(j)});
            }
            k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
            k21.i(str, "dbName");
            k21.i(str2, "tbName");
            b(str);
            d(str2);
            int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i2 > 0) {
                c(j);
            } else if (i2 == 0) {
                c(31536000000L);
            }
            return new i40(context, str, str2, i, j, null);
        }

        public final void b(@NotNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "346583651")) {
                ipChange.ipc$dispatch("346583651", new Object[]{this, str});
                return;
            }
            k21.i(str, "<set-?>");
            i40.b = str;
        }

        public final void c(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-24445922")) {
                ipChange.ipc$dispatch("-24445922", new Object[]{this, Long.valueOf(j)});
                return;
            }
            i40.c = j;
        }

        public final void d(@NotNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1447461261")) {
                ipChange.ipc$dispatch("-1447461261", new Object[]{this, str});
                return;
            }
            k21.i(str, "<set-?>");
            i40.c(str);
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    private i40(Context context, String str, String str2, int i, long j) {
        this.a = new r22(context, str, null, i, str2);
    }

    public static final /* synthetic */ void c(String str) {
    }

    @Override // com.alibaba.pictures.dolores.cache.ICacheManager
    public void clearCache() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-642112887")) {
            ipChange.ipc$dispatch("-642112887", new Object[]{this});
            return;
        }
        this.a.a();
    }

    @Override // com.alibaba.pictures.dolores.cache.ICacheManager
    @Nullable
    public String getCacheFileName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-115681323")) {
            return b;
        }
        return (String) ipChange.ipc$dispatch("-115681323", new Object[]{this});
    }

    @Override // com.alibaba.pictures.dolores.cache.ICacheManager
    public long getCachedTime(@Nullable String str) {
        ie d;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1065032891")) {
            return ((Long) ipChange.ipc$dispatch("-1065032891", new Object[]{this, str})).longValue();
        }
        if (str == null || (d = this.a.d(str)) == null) {
            return 0;
        }
        return d.c();
    }

    @Override // com.alibaba.pictures.dolores.cache.ICacheManager
    @Nullable
    public ie obtain(@Nullable String str, boolean z) {
        ie d;
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "910782102")) {
            return (ie) ipChange.ipc$dispatch("910782102", new Object[]{this, str, Boolean.valueOf(z)});
        }
        if (str == null || (d = this.a.d(str)) == null) {
            return null;
        }
        if (System.currentTimeMillis() - d.c() > c) {
            remove(str);
            return null;
        }
        if (z) {
            String d2 = d.d();
            if (!(d2 == null || d2.length() == 0)) {
                z2 = false;
            }
            if (!z2) {
                d.g(xa0.INSTANCE.decrypt(d.d()));
            }
        }
        return d;
    }

    @Override // com.alibaba.pictures.dolores.cache.ICacheManager
    @Nullable
    public String remove(@Nullable String str) {
        ie d;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "137840764")) {
            return (String) ipChange.ipc$dispatch("137840764", new Object[]{this, str});
        }
        if (str == null || (d = this.a.d(str)) == null) {
            return null;
        }
        String d2 = d.d();
        this.a.c(str);
        return d2;
    }

    @Override // com.alibaba.pictures.dolores.cache.ICacheManager
    @Nullable
    public String save(@Nullable String str, @Nullable String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "71008673")) {
            return (String) ipChange.ipc$dispatch("71008673", new Object[]{this, str, str2, Boolean.valueOf(z)});
        } else if (str == null) {
            return null;
        } else {
            if (z) {
                str2 = xa0.INSTANCE.encrypt(str2);
            }
            ie d = this.a.d(str);
            if (d != null) {
                String d2 = d.d();
                this.a.f(str, str2);
                return d2;
            }
            this.a.e(str, str2);
            return null;
        }
    }

    @Override // com.alibaba.pictures.dolores.cache.ICacheManager
    public void updateCachedTime(@Nullable String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-813476076")) {
            ipChange.ipc$dispatch("-813476076", new Object[]{this, str, Long.valueOf(j)});
            return;
        }
        this.a.g(str, Long.valueOf(j));
    }

    public /* synthetic */ i40(Context context, String str, String str2, int i, long j, m40 m40) {
        this(context, str, str2, i, j);
    }
}
