package tb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.view.state.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class rp1 extends a {
    private static transient /* synthetic */ IpChange $ipChange;

    public rp1(Context context) {
        super(context, R$drawable.state_color_shape_3);
    }

    @Override // cn.damai.uikit.view.state.a
    public void b(@NonNull Drawable drawable, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2132826772")) {
            ipChange.ipc$dispatch("-2132826772", new Object[]{this, drawable, Integer.valueOf(i)});
        } else {
            a(drawable, (int) ((i > 45 ? ((((float) (i - 50)) * 0.9f) / 50.0f) + 0.1f : 1.0f - ((((float) i) * 0.9f) / 50.0f)) * 255.0f));
        }
    }
}
