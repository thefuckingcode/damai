package tb;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* compiled from: Taobao */
public abstract class go1 extends Drawable {
    protected Paint a;

    protected go1() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.a.setAntiAlias(true);
        this.a.setColor(-5592406);
    }

    public void a(int i) {
        this.a.setColor(i);
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }
}
