package cn.damai.ultron.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.uikit.view.DMThemeDialog;
import cn.damai.ultron.view.activity.DmOrderActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ka0;
import tb.oa0;
import tb.yh1;

/* compiled from: Taobao */
public class DmUltronRequestErrorUtils {
    private static transient /* synthetic */ IpChange $ipChange;
    private static DmUltronRequestErrorUtils d;
    private BizType a;
    private DefaultError b = DefaultError.ERROR_LAYOUT;
    private NetError c = NetError.NO_NETWORK_TOAST;

    /* compiled from: Taobao */
    public enum BizType {
        BUILD,
        ADJUEST,
        CREATE
    }

    /* compiled from: Taobao */
    public enum DefaultError {
        ERROR_LAYOUT,
        DIALOG
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum ErrorType {
        NO_NETWORK,
        NO_NETWORK_TOAST,
        TOAST,
        BACK,
        BACK_SEAT,
        ORDER_LIST,
        BUILD_ADJUST_LIMIT,
        CREATE_LIMIT,
        ITEM_EXPIRED,
        DEFAULT_ERROR_LAYOUT,
        DEFAULT_DIALOG,
        LIMIT_DIALOG,
        NONE
    }

    /* compiled from: Taobao */
    public enum NetError {
        NO_NETWORK,
        NO_NETWORK_TOAST
    }

    /* compiled from: Taobao */
    public class a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DmOrderActivity a;

        a(DmUltronRequestErrorUtils dmUltronRequestErrorUtils, DmOrderActivity dmOrderActivity) {
            this.a = dmOrderActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2128211671")) {
                ipChange.ipc$dispatch("2128211671", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            this.a.finish();
        }
    }

    /* compiled from: Taobao */
    public class b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DmOrderActivity a;

        b(DmUltronRequestErrorUtils dmUltronRequestErrorUtils, DmOrderActivity dmOrderActivity) {
            this.a = dmOrderActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1197174602")) {
                ipChange.ipc$dispatch("-1197174602", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            DMNav.from(this.a).toUri(NavUri.b("my_showorder"));
            this.a.finish();
        }
    }

    /* compiled from: Taobao */
    public class c implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DmOrderActivity a;

        c(DmUltronRequestErrorUtils dmUltronRequestErrorUtils, DmOrderActivity dmOrderActivity) {
            this.a = dmOrderActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-227593579")) {
                ipChange.ipc$dispatch("-227593579", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            this.a.finish();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class d {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(35:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31|32|33|34|35|36|38) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00ab */
        static {
            int[] iArr = new int[ErrorType.values().length];
            b = iArr;
            try {
                iArr[ErrorType.NO_NETWORK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[ErrorType.NO_NETWORK_TOAST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            b[ErrorType.TOAST.ordinal()] = 3;
            b[ErrorType.BACK.ordinal()] = 4;
            b[ErrorType.BACK_SEAT.ordinal()] = 5;
            b[ErrorType.DEFAULT_DIALOG.ordinal()] = 6;
            b[ErrorType.ORDER_LIST.ordinal()] = 7;
            b[ErrorType.BUILD_ADJUST_LIMIT.ordinal()] = 8;
            b[ErrorType.CREATE_LIMIT.ordinal()] = 9;
            b[ErrorType.ITEM_EXPIRED.ordinal()] = 10;
            b[ErrorType.DEFAULT_ERROR_LAYOUT.ordinal()] = 11;
            b[ErrorType.LIMIT_DIALOG.ordinal()] = 12;
            int[] iArr2 = new int[BizType.values().length];
            a = iArr2;
            iArr2[BizType.BUILD.ordinal()] = 1;
            a[BizType.ADJUEST.ordinal()] = 2;
            try {
                a[BizType.CREATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private ErrorType c(Activity activity, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1212183200")) {
            return (ErrorType) ipChange.ipc$dispatch("-1212183200", new Object[]{this, activity, str});
        }
        if (!yh1.b(activity)) {
            NetError netError = this.c;
            if (netError == NetError.NO_NETWORK) {
                return ErrorType.NO_NETWORK;
            }
            if (netError == NetError.NO_NETWORK_TOAST) {
                return ErrorType.NO_NETWORK_TOAST;
            }
        }
        int i = d.a[this.a.ordinal()];
        if (i == 1 || i == 2) {
            for (String str2 : ka0.d) {
                if (str2.equalsIgnoreCase(str)) {
                    return ErrorType.ITEM_EXPIRED;
                }
            }
        } else if (i == 3) {
            if (str.startsWith("B-00203-4")) {
                return ErrorType.ORDER_LIST;
            }
            if (str.startsWith("B-00203-1")) {
                return ErrorType.TOAST;
            }
            if ("CUSTOM_REASON_CANNOT_BUY_C".equals(str) || "CUSTOM_REASON_CANNOT_BUY".equals(str) || "F-10007-10-10-025".equals(str) || "MAX_BUY_QUANTITY_EXCEEDED".equals(str)) {
                return ErrorType.LIMIT_DIALOG;
            }
            return ErrorType.BACK;
        }
        for (String str3 : ka0.e) {
            if (str3.equalsIgnoreCase(str)) {
                return ErrorType.DEFAULT_DIALOG;
            }
        }
        if (this.b == DefaultError.ERROR_LAYOUT) {
            return ErrorType.DEFAULT_ERROR_LAYOUT;
        }
        return ErrorType.DEFAULT_DIALOG;
    }

    public static synchronized DmUltronRequestErrorUtils d() {
        synchronized (DmUltronRequestErrorUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "615395929")) {
                return (DmUltronRequestErrorUtils) ipChange.ipc$dispatch("615395929", new Object[0]);
            }
            if (d == null) {
                d = new DmUltronRequestErrorUtils();
            }
            return d;
        }
    }

    private boolean e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "597828222")) {
            return ((Boolean) ipChange.ipc$dispatch("597828222", new Object[]{this, str})).booleanValue();
        } else if (oa0.f().g(str)) {
            return false;
        } else {
            for (String str2 : ka0.d) {
                if (str2.equalsIgnoreCase(str)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0062  */
    public DmUltronRequestErrorUtils a(DmOrderActivity dmOrderActivity, String str, String str2, String str3) {
        String str4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2094986285")) {
            return (DmUltronRequestErrorUtils) ipChange.ipc$dispatch("2094986285", new Object[]{this, dmOrderActivity, str, str2, str3});
        }
        ErrorType errorType = null;
        if (!TextUtils.isEmpty(str)) {
            int i = d.a[this.a.ordinal()];
            if (i == 1 || i == 2) {
                str4 = ka0.a(str);
                if (!TextUtils.isEmpty(str4)) {
                    errorType = ErrorType.BUILD_ADJUST_LIMIT;
                    if (errorType != null) {
                        b(dmOrderActivity, errorType, str, str4, str3);
                    } else {
                        b(dmOrderActivity, c(dmOrderActivity, str), str, str4, str3);
                        if (e(str)) {
                            BizType bizType = this.a;
                            if (bizType == BizType.BUILD) {
                                oa0.f().c(dmOrderActivity, str3, str, str4);
                            } else if (bizType == BizType.ADJUEST) {
                                oa0.f().b(dmOrderActivity, str3, str, str4);
                            } else {
                                oa0.f().d(dmOrderActivity, str3, str, str4);
                            }
                        }
                    }
                    return this;
                }
            } else if (i == 3) {
                str4 = ka0.b(str);
                if (!TextUtils.isEmpty(str4)) {
                    errorType = ErrorType.BACK;
                    if (errorType != null) {
                    }
                    return this;
                }
            }
        }
        str4 = str2;
        if (errorType != null) {
        }
        return this;
    }

    public void b(DmOrderActivity dmOrderActivity, ErrorType errorType, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-78504397")) {
            ipChange.ipc$dispatch("-78504397", new Object[]{this, dmOrderActivity, errorType, str, str2, str3});
            return;
        }
        switch (d.b[errorType.ordinal()]) {
            case 1:
                if (dmOrderActivity != null) {
                    dmOrderActivity.dmErrorViewHolder.f(this.a, 0, str, str2, str3);
                    return;
                }
                return;
            case 2:
                ToastUtil.i("网络异常，请稍后重试");
                return;
            case 3:
                ToastUtil.i(str2);
                return;
            case 4:
            case 5:
            case 6:
                if (dmOrderActivity != null) {
                    new DMThemeDialog(dmOrderActivity).r(DMThemeDialog.DMDialogTheme.THEME_ORDER_FAILURE).k(str2).i("我知道了", new a(this, dmOrderActivity)).show();
                    return;
                }
                return;
            case 7:
                if (dmOrderActivity != null) {
                    new DMThemeDialog(dmOrderActivity).r(DMThemeDialog.DMDialogTheme.THEME_ORDER_FAILURE).k(str2).i("查看订单", new b(this, dmOrderActivity)).show();
                    return;
                }
                return;
            case 8:
            case 9:
                if (dmOrderActivity != null) {
                    dmOrderActivity.dmErrorViewHolder.f(this.a, 5, str, str2, str3);
                    return;
                }
                return;
            case 10:
                if (dmOrderActivity != null) {
                    dmOrderActivity.dmErrorViewHolder.f(this.a, 6, str, str2, str3);
                    return;
                }
                return;
            case 11:
                if (dmOrderActivity != null) {
                    dmOrderActivity.dmErrorViewHolder.f(this.a, 0, str, str2, str3);
                    return;
                }
                return;
            case 12:
                if (dmOrderActivity != null) {
                    new DMThemeDialog(dmOrderActivity).r(DMThemeDialog.DMDialogTheme.THEME_ORDER_FAILURE).k("亲，您当前账户或购票人已超出限购数量，您可以调整数量、更换购票账户或购票人").i("我知道了", new c(this, dmOrderActivity)).show();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public DmUltronRequestErrorUtils f(BizType bizType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1939325312")) {
            return (DmUltronRequestErrorUtils) ipChange.ipc$dispatch("1939325312", new Object[]{this, bizType});
        }
        this.a = bizType;
        return this;
    }

    public DmUltronRequestErrorUtils g(DefaultError defaultError) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1634190628")) {
            return (DmUltronRequestErrorUtils) ipChange.ipc$dispatch("-1634190628", new Object[]{this, defaultError});
        }
        this.b = defaultError;
        return this;
    }

    public DmUltronRequestErrorUtils h(NetError netError) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2056285844")) {
            return (DmUltronRequestErrorUtils) ipChange.ipc$dispatch("2056285844", new Object[]{this, netError});
        }
        this.c = netError;
        return this;
    }
}
