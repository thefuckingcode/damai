package tb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.view.state.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class qp1 extends a {
    private static transient /* synthetic */ IpChange $ipChange;

    public qp1(Context context) {
        super(context, R$drawable.state_color_shape_2);
    }

    @Override // cn.damai.uikit.view.state.a
    public void b(@NonNull Drawable drawable, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1881790635")) {
            ipChange.ipc$dispatch("1881790635", new Object[]{this, drawable, Integer.valueOf(i)});
        } else {
            a(drawable, (int) ((i < 25 ? 1.0f - ((((float) i) * 0.34f) / 25.0f) : i < 50 ? ((((float) (i - 25)) * 0.34f) / 25.0f) + 0.66f : i < 75 ? 1.55f : 0.45f + ((((float) (i - 75)) * 0.55f) / 25.0f)) * 255.0f));
        }
    }
}
