package cn.damai.im;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.model.AliMeTokenInfo;
import cn.damai.im.request.AliMeTokenRequest;
import cn.damai.login.LoginManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import tb.d20;
import tb.gr;
import tb.xf2;
import tb.xs0;
import tb.yb1;

/* compiled from: Taobao */
public class AliMeUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String FROM_ACT = "damai_act";
    public static final String FROM_MESSAGE = "damai_msgbox";
    public static final String FROM_MINE = "damai_my";
    public static final String FROM_ORDER_DETAILS = "damai_orderdetail";
    public static final String FROM_ORDER_DETAIL_QUEST = "iUDekVTy3V";
    public static final String FROM_PROJECT_COMMON_PROBLEM = "2HoHjCkg7r";
    public static final String FROM_PROJECT_DETAIL = "damai_itemdetail";
    public static final String FROM_REALNAME_AUTH = "gNmJo1Iie8";
    public static final String FROM_SERVICE = "scfLHscDFa";
    public static final String FROM_SERVICE_PROBLEM = "que7SHuM7F";
    public static final String SESSION_COUPON_DETAIL = "ThV7YhIIcU";
    public static final String SESSION_COUPON_ORDER_DETAIL = "HKBKjpGqSO";
    public static final String SESSION_SCRIPT_COUPON_DETAIL = "K3WTW8mCj6";
    private static String a = "";

    /* compiled from: Taobao */
    public interface AliMeTokenListener {
        void onFailed();

        void onSuccess(String str);
    }

    /* compiled from: Taobao */
    public interface OnAliMeTokenListener {
        void onFailed(String str, String str2);

        void onSuccess(String str);
    }

    /* compiled from: Taobao */
    public interface UserCodeListener {
        void onFailed();

        void onSuccess(long j);
    }

    /* compiled from: Taobao */
    public class a implements UserCodeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ long b;
        final /* synthetic */ Context c;

        /* renamed from: cn.damai.im.AliMeUtil$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class C0023a implements AliMeTokenListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C0023a() {
            }

            @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
            public void onFailed() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-21095515")) {
                    ipChange.ipc$dispatch("-21095515", new Object[]{this});
                    return;
                }
                AliMeUtil.o();
            }

            @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
            public void onSuccess(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1436629807")) {
                    ipChange.ipc$dispatch("1436629807", new Object[]{this, str});
                    return;
                }
                String c = AliMeUtil.c(a.this.a, str);
                AliMeUtil.b(a.this.c, c + "&projectId=" + a.this.b);
            }
        }

        a(String str, long j, Context context) {
            this.a = str;
            this.b = j;
            this.c = context;
        }

        @Override // cn.damai.im.AliMeUtil.UserCodeListener
        public void onFailed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "13531288")) {
                ipChange.ipc$dispatch("13531288", new Object[]{this});
                return;
            }
            AliMeUtil.o();
        }

        @Override // cn.damai.im.AliMeUtil.UserCodeListener
        public void onSuccess(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1449105678")) {
                ipChange.ipc$dispatch("-1449105678", new Object[]{this, Long.valueOf(j)});
                return;
            }
            AliMeUtil.e(j, this.a, new C0023a());
        }
    }

    /* compiled from: Taobao */
    public class b implements UserCodeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ Context d;

        /* compiled from: Taobao */
        public class a implements AliMeTokenListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
            public void onFailed() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1332214182")) {
                    ipChange.ipc$dispatch("1332214182", new Object[]{this});
                    return;
                }
                AliMeUtil.o();
            }

            @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
            public void onSuccess(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-908037234")) {
                    ipChange.ipc$dispatch("-908037234", new Object[]{this, str});
                } else if (!TextUtils.isEmpty(str)) {
                    b bVar = b.this;
                    AliMeUtil.b(b.this.d, AliMeUtil.f(bVar.a, str, bVar.b, bVar.c));
                } else {
                    AliMeUtil.o();
                }
            }
        }

        b(String str, String str2, String str3, Context context) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = context;
        }

        @Override // cn.damai.im.AliMeUtil.UserCodeListener
        public void onFailed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1521083097")) {
                ipChange.ipc$dispatch("1521083097", new Object[]{this});
                return;
            }
            AliMeUtil.o();
        }

        @Override // cn.damai.im.AliMeUtil.UserCodeListener
        public void onSuccess(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-95795981")) {
                ipChange.ipc$dispatch("-95795981", new Object[]{this, Long.valueOf(j)});
                return;
            }
            AliMeUtil.e(j, this.a, new a());
        }
    }

    public static void b(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1855972401")) {
            ipChange.ipc$dispatch("1855972401", new Object[]{context, str});
            return;
        }
        Intent intent = new Intent(context, AliMeActivity.class);
        intent.putExtra("url", str);
        context.startActivity(intent);
    }

    public static String c(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1745566092")) {
            return (String) ipChange.ipc$dispatch("1745566092", new Object[]{str, str2});
        }
        return "https://ai.alimebot.taobao.com/intl/index.htm?from=" + str + "&v=3&_user_access_token=" + str2;
    }

    public static void d(int i, String str, final OnAliMeTokenListener onAliMeTokenListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1380063454")) {
            ipChange.ipc$dispatch("1380063454", new Object[]{Integer.valueOf(i), str, onAliMeTokenListener});
            return;
        }
        AliMeTokenRequest aliMeTokenRequest = new AliMeTokenRequest();
        aliMeTokenRequest.userCode = String.valueOf(i);
        aliMeTokenRequest.from = str;
        aliMeTokenRequest.v = "3";
        aliMeTokenRequest.request(new DMMtopRequestListener<AliMeTokenInfo>(AliMeTokenInfo.class) {
            /* class cn.damai.im.AliMeUtil.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1387166122")) {
                    ipChange.ipc$dispatch("1387166122", new Object[]{this, str, str2});
                    return;
                }
                OnAliMeTokenListener onAliMeTokenListener = onAliMeTokenListener;
                if (onAliMeTokenListener != null) {
                    onAliMeTokenListener.onFailed(str, str2);
                }
            }

            public void onSuccess(AliMeTokenInfo aliMeTokenInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "342909218")) {
                    ipChange.ipc$dispatch("342909218", new Object[]{this, aliMeTokenInfo});
                } else if (aliMeTokenInfo != null) {
                    OnAliMeTokenListener onAliMeTokenListener = onAliMeTokenListener;
                    if (onAliMeTokenListener != null) {
                        onAliMeTokenListener.onSuccess(aliMeTokenInfo.getResult());
                    }
                } else {
                    OnAliMeTokenListener onAliMeTokenListener2 = onAliMeTokenListener;
                    if (onAliMeTokenListener2 != null) {
                        onAliMeTokenListener2.onFailed("", "");
                    }
                }
            }
        });
    }

    public static void e(long j, String str, final AliMeTokenListener aliMeTokenListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-548100930")) {
            ipChange.ipc$dispatch("-548100930", new Object[]{Long.valueOf(j), str, aliMeTokenListener});
            return;
        }
        AliMeTokenRequest aliMeTokenRequest = new AliMeTokenRequest();
        aliMeTokenRequest.userCode = String.valueOf(j);
        aliMeTokenRequest.from = str;
        aliMeTokenRequest.v = "3";
        aliMeTokenRequest.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
        aliMeTokenRequest.sign = yb1.d(aliMeTokenRequest.toSignParamMap());
        aliMeTokenRequest.request(new DMMtopRequestListener<AliMeTokenInfo>(AliMeTokenInfo.class) {
            /* class cn.damai.im.AliMeUtil.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1394925481")) {
                    ipChange.ipc$dispatch("1394925481", new Object[]{this, str, str2});
                } else if (aliMeTokenListener != null) {
                    if ("FAIL_SYS_SESSION_EXPIRED".equals(str)) {
                        String unused = AliMeUtil.a = "true";
                    }
                    aliMeTokenListener.onFailed();
                    String unused2 = AliMeUtil.a = "";
                }
            }

            public void onSuccess(AliMeTokenInfo aliMeTokenInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2144210557")) {
                    ipChange.ipc$dispatch("-2144210557", new Object[]{this, aliMeTokenInfo});
                } else if (aliMeTokenInfo != null) {
                    AliMeTokenListener aliMeTokenListener = aliMeTokenListener;
                    if (aliMeTokenListener != null) {
                        aliMeTokenListener.onSuccess(aliMeTokenInfo.getResult());
                    }
                } else {
                    AliMeTokenListener aliMeTokenListener2 = aliMeTokenListener;
                    if (aliMeTokenListener2 != null) {
                        aliMeTokenListener2.onFailed();
                    }
                }
            }
        });
    }

    public static String f(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1824886622")) {
            return (String) ipChange.ipc$dispatch("-1824886622", new Object[]{str, str2, str3, str4});
        } else if (FROM_PROJECT_DETAIL.equals(str) || SESSION_COUPON_DETAIL.equals(str)) {
            return c(str, str2) + "&" + "projectId=" + str3;
        } else if (!FROM_PROJECT_COMMON_PROBLEM.equals(str) && !FROM_SERVICE_PROBLEM.equals(str) && !SESSION_SCRIPT_COUPON_DETAIL.equals(str)) {
            return c(str, str2);
        } else if (TextUtils.isEmpty(str4)) {
            return c(str, str2);
        } else {
            return c(str, str2) + "&" + i(str3) + "&" + "attemptquery=" + URLEncoder.encode(str4);
        }
    }

    public static String g(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1846974360")) {
            return (String) ipChange.ipc$dispatch("1846974360", new Object[]{str, str2, str3, str4, str5});
        }
        return c(str, str2) + "&" + i(str3) + "&" + "attemptquery=" + str5 + "&" + "orderId=" + str4;
    }

    public static String h(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1846311768")) {
            return (String) ipChange.ipc$dispatch("-1846311768", new Object[]{str, str2, str3, str4});
        }
        return c(str, str2) + "&" + i(str3) + "&" + "orderId=" + str4;
    }

    private static String i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-800241618")) {
            return (String) ipChange.ipc$dispatch("-800241618", new Object[]{str});
        }
        return "sopExtParam=" + URLEncoder.encode("{\"projectId\":\"" + str + "\"}");
    }

    public static void j(UserCodeListener userCodeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-343371106")) {
            ipChange.ipc$dispatch("-343371106", new Object[]{userCodeListener});
        } else if (!LoginManager.k().q()) {
            n();
        } else if (!xf2.j(d20.E())) {
            userCodeListener.onSuccess(Long.parseLong(d20.E()));
        }
    }

    public static void k(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "349626864")) {
            ipChange.ipc$dispatch("349626864", new Object[]{context, str});
            return;
        }
        l(context, str, 0);
    }

    public static void l(Context context, String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2046438700")) {
            ipChange.ipc$dispatch("-2046438700", new Object[]{context, str, Long.valueOf(j)});
            return;
        }
        j(new a(str, j, context));
    }

    public static void m(Context context, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "544464644")) {
            ipChange.ipc$dispatch("544464644", new Object[]{context, str, str2, str3});
            return;
        }
        j(new b(str, str2, str3, context));
    }

    private static void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2053553948")) {
            ipChange.ipc$dispatch("2053553948", new Object[0]);
        } else {
            DMNav.from(xs0.a().getApplicationContext()).toUri(gr.f());
        }
    }

    public static void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1043768836")) {
            ipChange.ipc$dispatch("1043768836", new Object[0]);
        } else if (!"true".equals(a)) {
            ToastUtil.a().j(xs0.a().getApplicationContext(), "小蜜现在无法识别你的身份，请点击链接再次尝试！");
        }
    }

    public static void p(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1298016536")) {
            ipChange.ipc$dispatch("1298016536", new Object[]{str, str2});
        } else if (!"FAIL_SYS_SESSION_EXPIRED".equals(str)) {
            o();
        }
    }
}
