package tb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class ap1 extends go1 {
    protected static final Region n = new Region();
    protected static final Region o = new Region(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected List<Path> b;
    protected List<Integer> c;
    protected int d = 1;
    protected int e = 1;
    protected int f = 0;
    protected int g = 0;
    protected int h;
    protected int i;
    protected List<Path> j;
    protected List<String> k;
    private Bitmap l;
    private boolean m;

    private void b(int i2, int i3) {
        Bitmap bitmap = this.l;
        if (bitmap == null || i2 != bitmap.getWidth() || i3 != this.l.getHeight()) {
            this.l = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            this.m = true;
        }
    }

    private void c(Canvas canvas) {
        canvas.translate((float) (-this.f), (float) (-this.g));
        if (this.b != null) {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                List<Integer> list = this.c;
                if (list != null && i2 < list.size()) {
                    this.a.setColor(this.c.get(i2).intValue());
                }
                canvas.drawPath(this.b.get(i2), this.a);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void d() {
        Integer num;
        Integer num2;
        Integer num3;
        int i2;
        int i3;
        int i4;
        List<Path> list = this.b;
        Integer num4 = null;
        if (list != null) {
            Integer num5 = null;
            num2 = null;
            num = null;
            for (Path path : list) {
                Region region = n;
                region.setPath(path, o);
                Rect bounds = region.getBounds();
                num4 = Integer.valueOf(Math.min(num4 == null ? bounds.top : num4.intValue(), bounds.top));
                num5 = Integer.valueOf(Math.min(num5 == null ? bounds.left : num5.intValue(), bounds.left));
                num2 = Integer.valueOf(Math.max(num2 == null ? bounds.right : num2.intValue(), bounds.right));
                num = Integer.valueOf(Math.max(num == null ? bounds.bottom : num.intValue(), bounds.bottom));
            }
            num3 = num4;
            num4 = num5;
        } else {
            num3 = null;
            num2 = null;
            num = null;
        }
        int i5 = 0;
        if (num4 == null) {
            i2 = 0;
        } else {
            i2 = num4.intValue();
        }
        this.f = i2;
        if (num3 == null) {
            i3 = 0;
        } else {
            i3 = num3.intValue();
        }
        this.g = i3;
        if (num2 == null) {
            i4 = 0;
        } else {
            i4 = num2.intValue() - this.f;
        }
        this.d = i4;
        if (num != null) {
            i5 = num.intValue() - this.g;
        }
        this.e = i5;
        if (this.h == 0) {
            this.h = this.d;
        }
        if (this.i == 0) {
            this.i = i5;
        }
        Rect bounds2 = getBounds();
        int i6 = bounds2.left;
        int i7 = bounds2.top;
        super.setBounds(i6, i7, this.d + i6, this.e + i7);
    }

    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int width = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds);
        int height = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds);
        if (this.a.getAlpha() == 255) {
            canvas.save();
            canvas.translate((float) (bounds.left - this.f), (float) (bounds.top - this.g));
            if (this.b != null) {
                for (int i2 = 0; i2 < this.b.size(); i2++) {
                    List<Integer> list = this.c;
                    if (list != null && i2 < list.size()) {
                        this.a.setColor(this.c.get(i2).intValue());
                    }
                    canvas.drawPath(this.b.get(i2), this.a);
                }
                this.a.setAlpha(255);
            }
            canvas.restore();
            return;
        }
        b(width, height);
        if (this.m) {
            this.l.eraseColor(0);
            c(new Canvas(this.l));
            this.m = false;
        }
        canvas.drawBitmap(this.l, (float) bounds.left, (float) bounds.top, this.a);
    }

    public void e(int... iArr) {
        this.c = new ArrayList();
        for (int i2 : iArr) {
            this.c.add(Integer.valueOf(i2));
        }
    }

    public void f(String... strArr) {
        this.i = 0;
        this.h = 0;
        this.k = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        this.b = arrayList;
        for (String str : strArr) {
            this.k.add(str);
            this.j.add(zo1.d(str));
        }
        d();
    }

    public void g(int i2) {
        Rect bounds = getBounds();
        float height = (((float) i2) * 1.0f) / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds));
        setBounds((int) (((float) bounds.left) * height), (int) (((float) bounds.top) * height), (int) (((float) bounds.right) * height), (int) (((float) bounds.bottom) * height));
    }

    public void h(int i2) {
        Rect bounds = getBounds();
        float width = (((float) i2) * 1.0f) / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds));
        setBounds((int) (((float) bounds.left) * width), (int) (((float) bounds.top) * width), (int) (((float) bounds.right) * width), (int) (((float) bounds.bottom) * width));
    }

    public void setBounds(int i2, int i3, int i4, int i5) {
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        List<Path> list = this.j;
        if (list == null || list.size() <= 0 || (i6 == this.d && i7 == this.e)) {
            super.setBounds(i2, i3, i4, i5);
            return;
        }
        this.b = zo1.h((((float) i6) * 1.0f) / ((float) this.h), (((float) i7) * 1.0f) / ((float) this.i), this.j, this.k);
        d();
    }

    public void setBounds(@NonNull Rect rect) {
        setBounds(rect.left, rect.top, rect.right, rect.bottom);
    }
}
