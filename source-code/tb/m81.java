package tb;

import com.alibaba.pictures.piclocation.LocationDataStatus;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class m81 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @JvmField
    public double a;
    @JvmField
    public double b;
    @JvmField
    @Nullable
    public String c = "";
    @JvmField
    @Nullable
    public String d = "";
    @JvmField
    @Nullable
    public String e;
    @JvmField
    @Nullable
    public String f;
    @JvmField
    @Nullable
    public LocationDataStatus g;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public m81(double d2, double d3) {
        this.a = d2;
        this.b = d3;
    }

    @NotNull
    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1967589511")) {
            return (String) ipChange.ipc$dispatch("-1967589511", new Object[]{this});
        }
        return "LocationInfoPic{latitude=" + this.a + ", longitude=" + this.b + ", cityId='" + this.c + '\'' + ", cityName='" + this.d + '\'' + '}';
    }
}
