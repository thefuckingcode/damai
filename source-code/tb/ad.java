package tb;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ad extends Drawable {
    private static transient /* synthetic */ IpChange $ipChange;
    private Path a;
    private int b;
    private int c;
    private int d;
    private Paint e;

    public ad(int i, int i2, int i3, int i4) {
        Paint paint = new Paint(1);
        this.e = paint;
        this.b = i;
        this.c = i2;
        this.d = i3;
        paint.setStyle(Paint.Style.FILL);
    }

    public void draw(@NonNull Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-535349938")) {
            ipChange.ipc$dispatch("-535349938", new Object[]{this, canvas});
            return;
        }
        try {
            if (this.a != null) {
                canvas.save();
                canvas.clipPath(this.a);
                canvas.drawRect(getBounds(), this.e);
                canvas.restore();
                return;
            }
            canvas.drawRect(getBounds(), this.e);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public int getOpacity() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1555492665")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1555492665", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-770466494")) {
            ipChange.ipc$dispatch("-770466494", new Object[]{this, rect});
            return;
        }
        try {
            if (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect) <= this.b || com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect) <= this.b * 2) {
                this.a = null;
                return;
            }
            this.a = new Path();
            float height = (float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect);
            float width = (float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect);
            int i = this.b;
            float f = (height - ((float) i)) / 2.0f;
            float f2 = width / 2.0f;
            float f3 = height - ((float) i);
            this.a.addRoundRect(new RectF(0.0f, 0.0f, width, f3), f, f, Path.Direction.CW);
            this.a.moveTo(f2 - ((float) this.b), f3);
            this.a.lineTo(f2, height);
            this.a.lineTo(f2 + ((float) this.b), f3);
            this.a.close();
            this.e.setShader(new LinearGradient(0.0f, 0.0f, width, height, this.c, this.d, Shader.TileMode.CLAMP));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setAlpha(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1397086780")) {
            ipChange.ipc$dispatch("-1397086780", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1829292678")) {
            ipChange.ipc$dispatch("-1829292678", new Object[]{this, colorFilter});
        }
    }
}
