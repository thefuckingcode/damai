package tb;

import android.content.Context;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.Login;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class l8 {
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

        public final void a(@NotNull String str, @NotNull Context context) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "787196741")) {
                ipChange.ipc$dispatch("787196741", new Object[]{this, str, context});
                return;
            }
            k21.i(str, "itemid");
            k21.i(context, "mContext");
            String c = yb1.c(Login.getUserId());
            String str2 = "saved_audience_";
            if (!TextUtils.isEmpty(c) && c.length() == 32) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                k21.h(c, "md5");
                String substring = c.substring(8, 24);
                k21.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                sb.append(substring);
                sb.append('_');
                str2 = sb.toString();
            }
            xc2 b = xc2.b(context);
            b.f(str2 + str);
        }

        @NotNull
        public final String[] b(@NotNull String str, @NotNull Context context) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1340246165")) {
                return (String[]) ipChange.ipc$dispatch("-1340246165", new Object[]{this, str, context});
            }
            k21.i(str, "itemid");
            k21.i(context, "mContext");
            String c = yb1.c(Login.getUserId());
            String str2 = "saved_audience_";
            if (!TextUtils.isEmpty(c) && c.length() == 32) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                k21.h(c, "md5");
                String substring = c.substring(8, 24);
                k21.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                sb.append(substring);
                sb.append('_');
                str2 = sb.toString();
            }
            xc2 b = xc2.b(context);
            String d = b.d(str2 + str);
            k21.h(d, "getInstance(mContext).getString(key + itemid)");
            Object[] array = StringsKt__StringsKt.z0(d, new String[]{","}, false, 0, 6, null).toArray(new String[0]);
            k21.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return (String[]) array;
        }
    }
}
