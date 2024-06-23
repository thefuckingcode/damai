package tb;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class di extends Drawable {
    private static transient /* synthetic */ IpChange $ipChange;
    private Paint a;
    private int b = Math.min(this.c.getWidth(), this.c.getHeight());
    private Bitmap c;

    public di(Bitmap bitmap) {
        this.c = bitmap;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setShader(bitmapShader);
    }

    public void draw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1063760556")) {
            ipChange.ipc$dispatch("1063760556", new Object[]{this, canvas});
            return;
        }
        int i = this.b;
        canvas.drawCircle((float) (i / 2), (float) (i / 2), (float) (i / 2), this.a);
    }

    public int getIntrinsicHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "268966522")) {
            return this.b;
        }
        return ((Integer) ipChange.ipc$dispatch("268966522", new Object[]{this})).intValue();
    }

    public int getIntrinsicWidth() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1583072041")) {
            return this.b;
        }
        return ((Integer) ipChange.ipc$dispatch("1583072041", new Object[]{this})).intValue();
    }

    public int getOpacity() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1254120805")) {
            return -3;
        }
        return ((Integer) ipChange.ipc$dispatch("-1254120805", new Object[]{this})).intValue();
    }

    public void setAlpha(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1283227170")) {
            ipChange.ipc$dispatch("1283227170", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1232301988")) {
            ipChange.ipc$dispatch("-1232301988", new Object[]{this, colorFilter});
            return;
        }
        this.a.setColorFilter(colorFilter);
    }
}
