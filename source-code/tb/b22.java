package tb;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class b22 extends Drawable {
    private static transient /* synthetic */ IpChange $ipChange;
    private Bitmap a;
    private Paint b;
    private RectF c;
    private int d;
    private Bitmap e;

    public b22(Bitmap bitmap) {
        this.a = bitmap;
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setDither(true);
        Paint paint2 = this.b;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint2.setShader(new BitmapShader(bitmap, tileMode, tileMode));
    }

    public void a(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1103765665")) {
            ipChange.ipc$dispatch("1103765665", new Object[]{this, bitmap});
            return;
        }
        this.e = bitmap;
    }

    public void b(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "180913743")) {
            ipChange.ipc$dispatch("180913743", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.d = i;
    }

    public void draw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1145256153")) {
            ipChange.ipc$dispatch("-1145256153", new Object[]{this, canvas});
            return;
        }
        RectF rectF = this.c;
        int i = this.d;
        canvas.drawRoundRect(rectF, (float) i, (float) i, this.b);
        Bitmap bitmap = this.e;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (float) ((this.a.getWidth() / 2) - (this.e.getWidth() / 2)), (float) ((this.a.getHeight() / 2) - (this.e.getHeight() / 2)), this.b);
        }
    }

    public int getIntrinsicHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1874003167")) {
            return this.a.getHeight();
        }
        return ((Integer) ipChange.ipc$dispatch("1874003167", new Object[]{this})).intValue();
    }

    public int getIntrinsicWidth() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "942110756")) {
            return this.a.getWidth();
        }
        return ((Integer) ipChange.ipc$dispatch("942110756", new Object[]{this})).intValue();
    }

    public int getOpacity() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "645513728")) {
            return -3;
        }
        return ((Integer) ipChange.ipc$dispatch("645513728", new Object[]{this})).intValue();
    }

    public void setAlpha(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1149346275")) {
            ipChange.ipc$dispatch("-1149346275", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.b.setAlpha(i);
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "849222257")) {
            ipChange.ipc$dispatch("849222257", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.setBounds(i, i2, i3, i4);
        this.c = new RectF((float) i, (float) i2, (float) i3, (float) i4);
        Log.d("blockW", " change left: " + i + " , " + i2 + " , " + i3 + " , " + i4);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "738367105")) {
            ipChange.ipc$dispatch("738367105", new Object[]{this, colorFilter});
            return;
        }
        this.b.setColorFilter(colorFilter);
    }
}
