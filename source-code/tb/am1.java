package tb;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.commonbusiness.calendar.remind.CalendarsResolver;
import cn.damai.uikit.view.DMThemeDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class am1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ADD_CALENDER_SUFFIX = "_addcalender";
    public static final String SHOW_CALENDER_POP_SUFFIX = "_poptip";
    public static final String SHOW_CALENDER_POP_TAG = "show_poptip";

    /* compiled from: Taobao */
    public class a implements CalendarsResolver.RemindMeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void addRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "775399175")) {
                ipChange.ipc$dispatch("775399175", new Object[]{this});
            }
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void candelRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "685832531")) {
                ipChange.ipc$dispatch("685832531", new Object[]{this});
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ long b;
        final /* synthetic */ CalendarsResolver.RemindMeListener c;
        final /* synthetic */ Activity d;

        b(String str, long j, CalendarsResolver.RemindMeListener remindMeListener, Activity activity) {
            this.a = str;
            this.b = j;
            this.c = remindMeListener;
            this.d = activity;
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "80541537")) {
                ipChange.ipc$dispatch("80541537", new Object[]{this});
            } else if (!TextUtils.isEmpty(this.a) && this.b > 0) {
                CalendarsResolver.i().k(this.c);
                CalendarsResolver.i().l(1440).b(this.d, this.a, "", this.b);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ long b;
        final /* synthetic */ CalendarsResolver.RemindMeListener c;
        final /* synthetic */ Activity d;

        c(String str, long j, CalendarsResolver.RemindMeListener remindMeListener, Activity activity) {
            this.a = str;
            this.b = j;
            this.c = remindMeListener;
            this.d = activity;
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-429992640")) {
                ipChange.ipc$dispatch("-429992640", new Object[]{this});
            } else if (!TextUtils.isEmpty(this.a) && this.b > 0) {
                CalendarsResolver.i().k(this.c);
                CalendarsResolver.i().l(1440).h(this.d, this.a, this.b);
            }
        }
    }

    public static void a(Activity activity, String str, long j, CalendarsResolver.RemindMeListener remindMeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1064089548")) {
            ipChange.ipc$dispatch("-1064089548", new Object[]{activity, str, Long.valueOf(j), remindMeListener});
        } else if (activity != null) {
            hp1.b(activity, false, lp1.CALENDAR, "才能设置开演提醒", new b(str, j, remindMeListener, activity));
        }
    }

    public static void b(Activity activity, String str, long j, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "586230207")) {
            ipChange.ipc$dispatch("586230207", new Object[]{activity, str, Long.valueOf(j), str2});
        } else if (activity != null && hp1.i(lp1.CALENDAR) && d(activity, str, j)) {
            c(activity, str, j, new a());
        }
    }

    private static void c(Activity activity, String str, long j, CalendarsResolver.RemindMeListener remindMeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1070001081")) {
            ipChange.ipc$dispatch("1070001081", new Object[]{activity, str, Long.valueOf(j), remindMeListener});
        } else if (activity != null) {
            hp1.b(activity, false, lp1.CALENDAR, "才能设置开演提醒", new c(str, j, remindMeListener, activity));
        }
    }

    public static boolean d(Context context, String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "66474732")) {
            return ((Boolean) ipChange.ipc$dispatch("66474732", new Object[]{context, str, Long.valueOf(j)})).booleanValue();
        } else if (!hp1.i(lp1.CALENDAR) || context == null || TextUtils.isEmpty(str) || j <= 0) {
            return false;
        } else {
            return CalendarsResolver.i().j(context, str, j);
        }
    }

    public static void e(Activity activity, String str, String str2, long j, CalendarsResolver.RemindMeListener remindMeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "878612536")) {
            ipChange.ipc$dispatch("878612536", new Object[]{activity, str, str2, Long.valueOf(j), remindMeListener});
        } else if (activity != null) {
            String str3 = "1";
            if (!hp1.i(lp1.CALENDAR)) {
                a(activity, str, j, remindMeListener);
            } else if (!d(activity, str, j)) {
                a(activity, str, j, remindMeListener);
            } else {
                c(activity, str, j, remindMeListener);
                str3 = "2";
            }
            cn.damai.common.user.c.e().x(ln2.r().j1(str2, str3, j));
        }
    }

    public static void f(Activity activity, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2037536099")) {
            ipChange.ipc$dispatch("-2037536099", new Object[]{activity, str, str2});
        } else if (activity != null) {
            new DMThemeDialog(activity).r(DMThemeDialog.DMDialogTheme.THEME_PERMISSION_CALENDAR).o(str).f(true).k(str2).i("知道了", null).show();
        }
    }
}
