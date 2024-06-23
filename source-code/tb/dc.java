package tb;

import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class dc {
    @NotNull
    public static final a Companion = new a(null);
    private static String a;
    private static String b;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public final boolean a(@Nullable List<String> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1437389994")) {
                return ((Boolean) ipChange.ipc$dispatch("1437389994", new Object[]{this, list})).booleanValue();
            }
            if (dc.a == null) {
                dc.a = Build.VERSION.getRELEASE();
            }
            if (dc.b == null) {
                dc.b = Build.getMODEL();
            }
            if (!(o.x(dc.a, "10", false, 2, null)) || list == null || !(CollectionsKt___CollectionsKt.J(list, dc.b))) {
                return false;
            }
            return true;
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }
}
