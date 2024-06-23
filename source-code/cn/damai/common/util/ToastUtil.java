package cn.damai.common.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.RawRes;
import cn.damai.common.R$id;
import cn.damai.common.R$layout;
import cn.damai.common.R$string;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.bk2;
import tb.g91;
import tb.xs0;
import tb.yh1;

/* compiled from: Taobao */
public class ToastUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public enum ToastLottieType {
        TYPE_SUCCESS(0, "成功");
        
        String name;
        int type;

        private ToastLottieType(int i, String str) {
            this.type = i;
            this.name = str;
        }
    }

    /* compiled from: Taobao */
    private static class b {
        private static final ToastUtil a = new ToastUtil();
    }

    public static final ToastUtil a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-456941317") ? (ToastUtil) ipChange.ipc$dispatch("-456941317", new Object[0]) : b.a;
    }

    public static void b(CharSequence charSequence, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1347967486")) {
            ipChange.ipc$dispatch("-1347967486", new Object[]{charSequence, Integer.valueOf(i)});
            return;
        }
        d(xs0.a().getApplicationContext(), null, charSequence);
    }

    public static void c(Context context, int i, int i2) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-789824819")) {
            ipChange.ipc$dispatch("-789824819", new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        String str2 = "";
        if (i != 0) {
            try {
                str = bk2.b(context, i);
            } catch (Exception e) {
                g91.c("ToastUtil", e.getMessage());
                return;
            }
        } else {
            str = str2;
        }
        if (i2 != 0) {
            str2 = bk2.b(context, i2);
        }
        d(context, str, str2);
    }

    public static void d(Context context, CharSequence charSequence, CharSequence charSequence2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1246216437")) {
            ipChange.ipc$dispatch("1246216437", new Object[]{context, charSequence, charSequence2});
            return;
        }
        cn.damai.common.util.toastutil.a.j(xs0.a().getApplicationContext(), cn.damai.common.util.toastutil.a.b(context, charSequence, charSequence2), 0, 17, 0, 0);
    }

    public static void f(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1139781893")) {
            ipChange.ipc$dispatch("1139781893", new Object[]{charSequence});
            return;
        }
        d(xs0.a().getApplicationContext(), null, charSequence);
    }

    public static void h(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-202506606")) {
            ipChange.ipc$dispatch("-202506606", new Object[]{Integer.valueOf(i)});
            return;
        }
        c(xs0.a().getApplicationContext(), 0, i);
    }

    public static void i(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1559021621")) {
            ipChange.ipc$dispatch("1559021621", new Object[]{charSequence});
            return;
        }
        d(xs0.a().getApplicationContext(), null, charSequence);
    }

    public static void k(String str, String str2, @RawRes int i) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "659926185")) {
            ipChange.ipc$dispatch("659926185", new Object[]{str, str2, Integer.valueOf(i)});
            return;
        }
        View inflate = LayoutInflater.from(xs0.a().getApplicationContext()).inflate(R$layout.toast_custom_lottie_v2, (ViewGroup) null);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R$id.toast_lottie_view_v2);
        if (i != 0) {
            lottieAnimationView.setAnimation(i);
            lottieAnimationView.setVisibility(0);
        }
        TextView textView = (TextView) inflate.findViewById(R$id.toast_title_v2);
        TextView textView2 = (TextView) inflate.findViewById(R$id.toast_sub_title_v2);
        textView.setText(str);
        textView.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        textView2.setText(str2);
        if (TextUtils.isEmpty(str2)) {
            i2 = 8;
        }
        textView2.setVisibility(i2);
        cn.damai.common.util.toastutil.a.j(xs0.a().getApplicationContext(), inflate, 0, 17, 0, 0);
    }

    public void e(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-117274057")) {
            ipChange.ipc$dispatch("-117274057", new Object[]{this, context, str});
            return;
        }
        d(context, null, str);
    }

    public void g(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1003863798")) {
            ipChange.ipc$dispatch("1003863798", new Object[]{this, context});
        } else if (!yh1.b(context)) {
            j(context, context.getResources().getString(R$string.damai_base_net_toast));
        }
    }

    public void j(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1745691956")) {
            ipChange.ipc$dispatch("-1745691956", new Object[]{this, context, str});
            return;
        }
        if (context == null) {
            context = xs0.a();
        }
        if (!TextUtils.isEmpty(str)) {
            d(context, null, str);
        }
    }

    private ToastUtil() {
    }
}
