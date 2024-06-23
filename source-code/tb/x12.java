package tb;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: Taobao */
public class x12 extends Drawable {
    private Paint a;
    private RectF b;
    int c;

    public x12(Paint paint, int i) {
        this.a = paint;
        this.c = i;
    }

    public void draw(Canvas canvas) {
        RectF rectF = this.b;
        int i = this.c;
        canvas.drawRoundRect(rectF, (float) i, (float) i, this.a);
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.b = new RectF((float) i, (float) i2, (float) i3, (float) i4);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }
}
