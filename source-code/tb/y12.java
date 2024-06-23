package tb;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class y12 extends GradientDrawable {
    private static transient /* synthetic */ IpChange $ipChange;
    private float a;
    private Path b;

    public y12(GradientDrawable.Orientation orientation, int[] iArr, float f) {
        super(orientation, iArr);
        this.a = f;
    }

    public void draw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "922162931")) {
            ipChange.ipc$dispatch("922162931", new Object[]{this, canvas});
            return;
        }
        if (this.b != null) {
            canvas.save();
            canvas.clipPath(this.b);
        }
        super.draw(canvas);
        if (this.b != null) {
            canvas.restore();
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1885468185")) {
            ipChange.ipc$dispatch("-1885468185", new Object[]{this, rect});
            return;
        }
        super.onBoundsChange(rect);
        float f = this.a;
        if (f <= 0.0f || f >= ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect)) || this.a >= ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect))) {
            this.b = null;
            return;
        }
        this.b = new Path();
        RectF rectF = new RectF(rect);
        Path path = this.b;
        float f2 = this.a;
        path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
    }
}
