package tb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.view.state.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class pp1 extends a {
    private static transient /* synthetic */ IpChange $ipChange;

    public pp1(Context context) {
        super(context, R$drawable.state_color_shape_1);
    }

    @Override // cn.damai.uikit.view.state.a
    public void b(@NonNull Drawable drawable, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1601440746")) {
            ipChange.ipc$dispatch("1601440746", new Object[]{this, drawable, Integer.valueOf(i)});
        } else {
            a(drawable, (int) ((i > 35 ? ((((float) (i - 35)) * 0.65f) / 65.0f) + 0.35f : 1.0f - ((((float) i) * 0.65f) / 35.0f)) * 255.0f));
        }
    }
}
