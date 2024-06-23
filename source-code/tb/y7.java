package tb;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
public class y7 extends go1 {
    private int b = 0;
    private int c = 0;
    private Path d = new Path();

    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int width = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds);
        int height = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds);
        if (!(this.b == width && this.c == height)) {
            this.d.reset();
            float f = (float) ((width * 30) / 225);
            float f2 = f * 0.70710677f;
            float f3 = f / 0.70710677f;
            float f4 = (float) width;
            float f5 = f4 / 2.0f;
            float f6 = (float) height;
            this.d.moveTo(f5, f6);
            float f7 = f6 / 2.0f;
            this.d.lineTo(0.0f, f7);
            float f8 = f7 - f2;
            this.d.lineTo(f2, f8);
            float f9 = f / 2.0f;
            float f10 = f5 - f9;
            float f11 = (f6 - f3) - f9;
            this.d.lineTo(f10, f11);
            this.d.lineTo(f10, 0.0f);
            float f12 = f5 + f9;
            this.d.lineTo(f12, 0.0f);
            this.d.lineTo(f12, f11);
            this.d.lineTo(f4 - f2, f8);
            this.d.lineTo(f4, f7);
            this.d.close();
            this.b = width;
            this.c = height;
        }
        canvas.drawPath(this.d, this.a);
    }
}
