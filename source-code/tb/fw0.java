package tb;

import android.app.Application;
import androidx.exifinterface.media.ExifInterface;
import cn.damai.abtest.ABTestOrangeModel;
import cn.damai.common.AppConfig;
import cn.damai.common.util.toastutil.a;
import com.alibaba.pictures.abtest.provider.ABTestProvider;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class fw0 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final fw0 INSTANCE = new fw0();
    @NotNull
    public static final String KEY_HOME_PAGE_FORCE_DEFAULT = "homepageModel";
    @NotNull
    public static final String TAG = "HomePageABHelper";
    @NotNull
    public static final String VALUE_MODEL_CMS = "cms";
    @NotNull
    public static final String VALUE_MODEL_DEFAULT = "ab";
    @NotNull
    public static final String VALUE_MODEL_OLD = "old";
    @JvmField
    @Nullable
    public static String a;

    private fw0() {
    }

    private final String a() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1252521866")) {
            return (String) ipChange.ipc$dispatch("1252521866", new Object[]{this});
        }
        String b = b();
        if (b == null || b.length() == 0) {
            z = true;
        }
        if (z) {
            return ABTestProvider.g(ABTestProvider.INSTANCE, d(), Long.valueOf(c()), null, 4, null);
        }
        return ABTestProvider.INSTANCE.f(d(), Long.valueOf(c()), b());
    }

    private final String b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "553293927")) {
            return (String) ipChange.ipc$dispatch("553293927", new Object[]{this});
        }
        ABTestOrangeModel a2 = b.INSTANCE.a();
        if (a2 != null) {
            return a2.homepageBucketId;
        }
        return null;
    }

    public final long c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-285670193")) {
            return ((Long) ipChange.ipc$dispatch("-285670193", new Object[]{this})).longValue();
        }
        ABTestOrangeModel a2 = b.INSTANCE.a();
        if (a2 != null) {
            return a2.homepageExperimentId;
        }
        return 126600209;
    }

    @NotNull
    public final String d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1100157002")) {
            return (String) ipChange.ipc$dispatch("1100157002", new Object[]{this});
        }
        ABTestOrangeModel a2 = b.INSTANCE.a();
        String str = a2 != null ? a2.homepageScenarioCode : null;
        return str == null ? "damai_home_ab" : str;
    }

    public final boolean e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "581265866")) {
            return ((Boolean) ipChange.ipc$dispatch("581265866", new Object[]{this})).booleanValue();
        }
        String string = pn.f().getString(KEY_HOME_PAGE_FORCE_DEFAULT, VALUE_MODEL_DEFAULT);
        if (k21.d(string, VALUE_MODEL_CMS)) {
            if (AppConfig.v()) {
                a.i(xs0.a(), "CMS首页");
            }
            return true;
        } else if (k21.d(string, "old")) {
            if (AppConfig.v()) {
                a.i(xs0.a(), "老首页");
            }
            return false;
        } else {
            a = a();
            if (AppConfig.v()) {
                Application a2 = xs0.a();
                StringBuilder sb = new StringBuilder();
                sb.append("AB逻辑:");
                String str = a;
                if (str == null) {
                    str = "空";
                }
                sb.append(str);
                sb.append((char) 26742);
                a.i(a2, sb.toString());
            }
            return !f();
        }
    }

    public final boolean f() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-934409308")) {
            return k21.d(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, a);
        }
        return ((Boolean) ipChange.ipc$dispatch("-934409308", new Object[]{this})).booleanValue();
    }
}
