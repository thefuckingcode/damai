package tb;

import android.graphics.RectF;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class qx1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(float f, RectF rectF) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1204831269")) {
            ipChange.ipc$dispatch("-1204831269", new Object[]{Float.valueOf(f), rectF});
            return;
        }
        float width = rectF.width() / 2.0f;
        if (width > 1.0f) {
            float sqrt = (float) Math.sqrt((double) (2.0f * width * width));
            float sin = (float) (Math.sin((((double) Math.abs((((int) f) + 45) % 90)) * 3.141592653589793d) / 180.0d) * ((double) sqrt));
            float max = Math.max(sin, (float) Math.sqrt((double) ((sqrt * sqrt) - (sin * sin)))) - width;
            float f2 = sqrt - width;
            if (max <= 0.0f) {
                max = 0.0f;
            }
            if (max < f2) {
                f2 = max;
            }
            rectF.top = (float) Math.round(rectF.top - f2);
            rectF.bottom = (float) Math.round(rectF.bottom + f2);
            rectF.left = (float) Math.round(rectF.left - f2);
            rectF.right = (float) Math.round(rectF.right + f2);
        }
    }
}
