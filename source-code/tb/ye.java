package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* compiled from: Taobao */
public class ye {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(Calendar calendar, Calendar calendar2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-717461333")) {
            ipChange.ipc$dispatch("-717461333", new Object[]{calendar, calendar2});
            return;
        }
        int g = g(calendar);
        int f = f(calendar);
        int b = b(calendar);
        calendar2.clear();
        calendar2.set(g, f, b);
    }

    public static int b(Calendar calendar) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "520569093")) {
            return calendar.get(5);
        }
        return ((Integer) ipChange.ipc$dispatch("520569093", new Object[]{calendar})).intValue();
    }

    public static int c(Calendar calendar) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1234805018")) {
            return calendar.get(7);
        }
        return ((Integer) ipChange.ipc$dispatch("1234805018", new Object[]{calendar})).intValue();
    }

    @NonNull
    public static Calendar d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-32486833")) {
            return (Calendar) ipChange.ipc$dispatch("-32486833", new Object[0]);
        }
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        a(instance, instance);
        return instance;
    }

    public static Calendar e(@Nullable Date date) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-319205170")) {
            return (Calendar) ipChange.ipc$dispatch("-319205170", new Object[]{date});
        }
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        if (date != null) {
            instance.setTime(date);
        }
        a(instance, instance);
        return instance;
    }

    public static int f(Calendar calendar) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1848059809")) {
            return calendar.get(2);
        }
        return ((Integer) ipChange.ipc$dispatch("1848059809", new Object[]{calendar})).intValue();
    }

    public static int g(Calendar calendar) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1112973172")) {
            return calendar.get(1);
        }
        return ((Integer) ipChange.ipc$dispatch("1112973172", new Object[]{calendar})).intValue();
    }
}
