package tb;

import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

public final class hg0 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static final void a(TextView textView, String str, int i) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-303344088")) {
            ipChange.ipc$dispatch("-303344088", new Object[]{textView, str, Integer.valueOf(i)});
            return;
        }
        k21.i(textView, "<this>");
        if (!(str == null || str.length() == 0)) {
            z = false;
        }
        if (z) {
            textView.setVisibility(i);
            return;
        }
        textView.setVisibility(0);
        textView.setText(str);
    }

    public static /* synthetic */ void b(TextView textView, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8;
        }
        a(textView, str, i);
    }
}
