package cn.damai.common.util;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.d20;
import tb.k21;

/* compiled from: Taobao */
public final class CompliantUtUtils {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final CompliantUtUtils INSTANCE = new CompliantUtUtils();
    @Nullable
    private static CompliantUtDelegate a;

    /* compiled from: Taobao */
    public interface CompliantUtDelegate {
        boolean isOpenPrivacyDoubleListInit();
    }

    private CompliantUtUtils() {
    }

    @JvmStatic
    public static final void a() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-940899936")) {
            ipChange.ipc$dispatch("-940899936", new Object[0]);
            return;
        }
        CompliantUtDelegate compliantUtDelegate = a;
        if (compliantUtDelegate != null && compliantUtDelegate.isOpenPrivacyDoubleListInit()) {
            z = true;
        }
        if (!z) {
            c.e().A(new HashMap(), "model", "device");
        }
    }

    @JvmStatic
    public static final void b(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-2121882088")) {
            ipChange.ipc$dispatch("-2121882088", new Object[]{str, str2});
            return;
        }
        CompliantUtDelegate compliantUtDelegate = a;
        if (!(compliantUtDelegate != null && compliantUtDelegate.isOpenPrivacyDoubleListInit())) {
            if (!(str == null || str.length() == 0)) {
                if (!(str2 == null || str2.length() == 0)) {
                    z = false;
                }
                if (!z) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("lat", str);
                    hashMap.put("lng", str2);
                    c.e().A(hashMap, "location", "location");
                }
            }
        }
    }

    @JvmStatic
    public static final void c(@Nullable String str) {
        long j;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1241169807")) {
            ipChange.ipc$dispatch("1241169807", new Object[]{str});
            return;
        }
        if (str == null || str.length() == 0) {
            z = true;
        }
        if (!z) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(d20.B("serverTimeDiff"))) {
                long currentTimeMillis = System.currentTimeMillis();
                String B = d20.B("serverTimeDiff");
                k21.h(B, "getString(\"serverTimeDiff\")");
                j = (currentTimeMillis + Long.parseLong(B)) / ((long) 1000);
            } else {
                j = System.currentTimeMillis() / ((long) 1000);
            }
            hashMap.put("havanaid", str);
            hashMap.put("logintime", String.valueOf(j));
            c.e().A(hashMap, "record", "login");
        }
    }

    @JvmStatic
    public static final void d() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "199036319")) {
            ipChange.ipc$dispatch("199036319", new Object[0]);
            return;
        }
        CompliantUtDelegate compliantUtDelegate = a;
        if (compliantUtDelegate != null && compliantUtDelegate.isOpenPrivacyDoubleListInit()) {
            z = true;
        }
        if (!z) {
            c.e().A(new HashMap(), "osversion", "device");
        }
    }

    @JvmStatic
    public static final void e(@Nullable String str) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "2038470891")) {
            ipChange.ipc$dispatch("2038470891", new Object[]{str});
            return;
        }
        if (str == null || str.length() == 0) {
            z = true;
        }
        if (!z) {
            HashMap hashMap = new HashMap();
            hashMap.put("phone", str);
            c.e().A(hashMap, "contact", NotificationCompat.CATEGORY_SOCIAL);
        }
    }

    @JvmStatic
    public static final void f(@NotNull CompliantUtDelegate compliantUtDelegate) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1454258694")) {
            ipChange.ipc$dispatch("-1454258694", new Object[]{compliantUtDelegate});
            return;
        }
        k21.i(compliantUtDelegate, "delegate");
        a = compliantUtDelegate;
    }
}
