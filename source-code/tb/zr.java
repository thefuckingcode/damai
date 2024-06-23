package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.mini.UTAnalytics;
import com.ut.mini.module.plugin.UTPlugin;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class zr extends UTPlugin {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @JvmStatic
        public final void a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1779467528")) {
                ipChange.ipc$dispatch("-1779467528", new Object[]{this});
                return;
            }
            try {
                UTAnalytics.getInstance().registerPlugin(new zr());
            } catch (Throwable th) {
                g91.d(th);
            }
        }
    }

    private final void a(Map<String, String> map, Map<String, String> map2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-52637131")) {
            ipChange.ipc$dispatch("-52637131", new Object[]{this, map, map2});
        } else if (map2 != null && map != null) {
            try {
                if (map2.containsKey("city")) {
                    String str = map2.get("city");
                    if (str == null || str.length() == 0) {
                        String d = d20.d();
                        k21.h(d, "getCityName()");
                        map.put("city", d);
                    } else if (jk1.a(str)) {
                        String d2 = d20.d();
                        k21.h(d2, "getCityName()");
                        map.put("city", d2);
                    } else if ((o.v(str, "市", false, 2, null)) && str.length() > 1) {
                        String substring = str.substring(0, str.length() - 1);
                        k21.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                        map.put("city", substring);
                    }
                } else {
                    String d3 = d20.d();
                    k21.h(d3, "getCityName()");
                    map.put("city", d3);
                }
            } catch (Exception e) {
                g91.d(e);
            }
        }
    }

    @JvmStatic
    public static final void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1236399568")) {
            ipChange.ipc$dispatch("-1236399568", new Object[0]);
        } else {
            Companion.a();
        }
    }

    @Override // com.ut.mini.module.plugin.UTPlugin
    @NotNull
    public int[] getAttentionEventIds() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-969159209")) {
            return new int[]{2001, 2101, 2201, 19999, 12002, 12003};
        }
        return (int[]) ipChange.ipc$dispatch("-969159209", new Object[]{this});
    }

    @Override // com.ut.mini.module.plugin.UTPlugin
    @NotNull
    public Map<String, String> onEventDispatch(@Nullable String str, int i, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1740044539")) {
            return (Map) ipChange.ipc$dispatch("-1740044539", new Object[]{this, str, Integer.valueOf(i), str2, str3, str4, map});
        }
        HashMap hashMap = new HashMap();
        a(hashMap, map);
        return hashMap;
    }
}
