package tb;

import com.alibaba.pictures.dolores.cache.ICacheDataFilter;
import com.alibaba.pictures.dolores.cache.ICacheManager;
import com.alibaba.pictures.dolores.time.TimeSyncer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class va0 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    private static final String a = "DoloresCacheWrapper";

    @Nullable
    public static final ie a(@Nullable je jeVar) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1849256826")) {
            return (ie) ipChange.ipc$dispatch("1849256826", new Object[]{jeVar});
        }
        if (jeVar != null) {
            String a2 = jeVar.a();
            if (a2 == null || a2.length() == 0) {
                z = true;
            }
            if (!z) {
                try {
                    String str = a;
                    vp.a(str, "get key:" + jeVar.a() + ",value:***");
                    ICacheManager h = ua0.Companion.g().h();
                    ie obtain = h != null ? h.obtain(jeVar.a(), jeVar.c()) : null;
                    b(jeVar, obtain);
                    return obtain;
                } catch (Exception e) {
                    vp.b(a, e);
                }
            }
        }
        return null;
    }

    public static final void b(@Nullable je jeVar, @Nullable ie ieVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1466438620")) {
            ipChange.ipc$dispatch("-1466438620", new Object[]{jeVar, ieVar});
        } else if (ieVar != null) {
            String d = ieVar.d();
            long c = ieVar.c();
            if (d == null) {
                ieVar.e(0);
            }
            if (TimeSyncer.INSTANCE.g() - c < (jeVar != null ? jeVar.b() : 0)) {
                ieVar.e(1);
            } else {
                ieVar.e(2);
            }
        }
    }

    public static final void c(@Nullable je jeVar, @Nullable byte[] bArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1410491607")) {
            ipChange.ipc$dispatch("-1410491607", new Object[]{jeVar, bArr});
            return;
        }
        if ((jeVar != null ? jeVar.a() : null) != null && bArr != null) {
            try {
                String a2 = jeVar.a();
                String str = new String(bArr, ph.UTF_8);
                ICacheDataFilter f = jeVar.f();
                if (f != null) {
                    str = f.doFilter(a2, str);
                }
                String str2 = a;
                vp.a(str2, "save key:" + a2 + ",value-***");
                ICacheManager h = ua0.Companion.g().h();
                if (h != null) {
                    h.save(a2, str, jeVar.c());
                    return;
                }
                vp.c(str2, "cacheManager == null,you need set a CacheManager!");
                ur2 ur2 = ur2.INSTANCE;
            } catch (Exception e) {
                vp.b(a, e);
            }
        }
    }
}
