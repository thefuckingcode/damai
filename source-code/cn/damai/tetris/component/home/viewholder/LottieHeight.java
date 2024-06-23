package cn.damai.tetris.component.home.viewholder;

import android.app.Application;
import android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.n42;
import tb.xs0;

/* compiled from: Taobao */
public class LottieHeight implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int getHomeLottieViewHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "791852711")) {
            return ((Integer) ipChange.ipc$dispatch("791852711", new Object[0])).intValue();
        }
        Application a = xs0.a();
        DisplayMetrics displayMetrics = a.getResources().getDisplayMetrics();
        return n42.a(a, (float) ((int) ((((float) ((int) (((float) com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics)) / displayMetrics.density))) / 392.0f) * 420.0f)));
    }
}
