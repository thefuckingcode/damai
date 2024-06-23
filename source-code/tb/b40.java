package tb;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.taobao.pexode.animate.AnimatedImage;
import com.taobao.rxm.common.Releasable;

/* compiled from: Taobao */
public class b40 implements Releasable {
    public static final int ANIMATE_IMAGE = 2;
    public static final int STATIC_BITMAP = 1;
    private qd0 a;
    private final int b;
    private final Bitmap c;
    private final Rect d;
    private final AnimatedImage e;

    public b40(qd0 qd0, Bitmap bitmap) {
        this(qd0, bitmap, null, null);
    }

    public AnimatedImage a() {
        return this.e;
    }

    public Bitmap b() {
        return this.c;
    }

    public Rect c() {
        return this.d;
    }

    public qd0 d() {
        return this.a;
    }

    public boolean e() {
        int i = this.b;
        if (i != 1 || this.c == null) {
            return i == 2 && this.e != null;
        }
        return true;
    }

    public boolean f() {
        return this.b == 1;
    }

    public boolean g() {
        qd0 qd0 = this.a;
        return qd0 == null || qd0.g;
    }

    @Override // com.taobao.rxm.common.Releasable
    public void release() {
        qd0 qd0 = this.a;
        if (qd0 != null) {
            qd0.release();
        }
        AnimatedImage animatedImage = this.e;
        if (animatedImage != null) {
            animatedImage.dispose();
        }
    }

    public String toString() {
        return "DecodedImage(type=" + this.b + ", bitmap=" + this.c + ", animated=" + this.e + jl1.BRACKET_END_STR;
    }

    public b40(qd0 qd0, Bitmap bitmap, AnimatedImage animatedImage, Rect rect) {
        if (bitmap != null) {
            this.b = 1;
        } else {
            this.b = 2;
        }
        this.a = qd0;
        this.c = bitmap;
        this.e = animatedImage;
        this.d = rect;
    }
}
