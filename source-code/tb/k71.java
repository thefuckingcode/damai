package tb;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class k71 extends Drawable {
    private static transient /* synthetic */ IpChange $ipChange;
    private Paint a;
    private int[] b;
    @Nullable
    private float[] c;
    private LinearGradient d;

    public k71() {
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setStyle(Paint.Style.FILL);
    }

    private boolean a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-347198852")) {
            return ((Boolean) ipChange.ipc$dispatch("-347198852", new Object[]{this})).booleanValue();
        }
        int[] iArr = this.b;
        if (iArr == null || iArr.length <= 1) {
            return false;
        }
        float[] fArr = this.c;
        if (fArr == null || iArr.length == fArr.length) {
            return true;
        }
        return false;
    }

    public void b(int[] iArr, @Nullable float[] fArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-981285541")) {
            ipChange.ipc$dispatch("-981285541", new Object[]{this, iArr, fArr});
            return;
        }
        this.b = iArr;
        this.c = fArr;
        this.d = null;
        invalidateSelf();
    }

    public void draw(@NonNull Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1454282643")) {
            ipChange.ipc$dispatch("1454282643", new Object[]{this, canvas});
            return;
        }
        Rect bounds = getBounds();
        if (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds) > 0 && a()) {
            if (this.d == null) {
                LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, (float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds), this.b, this.c, Shader.TileMode.CLAMP);
                this.d = linearGradient;
                this.a.setShader(linearGradient);
            }
            canvas.drawRect(bounds, this.a);
        }
    }

    public int getOpacity() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "162287892")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("162287892", new Object[]{this})).intValue();
    }

    public void setAlpha(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1190370441")) {
            ipChange.ipc$dispatch("1190370441", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-557817707")) {
            ipChange.ipc$dispatch("-557817707", new Object[]{this, colorFilter});
        }
    }
}
