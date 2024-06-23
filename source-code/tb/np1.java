package tb;

import android.graphics.Bitmap;
import android.os.Build;
import com.taobao.pexode.animate.AnimatedImage;

/* compiled from: Taobao */
public class np1 {
    public Bitmap a;
    public AnimatedImage b;

    public static np1 a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        np1 np1 = new np1();
        np1.a = bitmap;
        if (Build.VERSION.SDK_INT > 23) {
            bitmap.prepareToDraw();
        }
        return np1;
    }

    public static np1 b(AnimatedImage animatedImage) {
        if (animatedImage == null) {
            return null;
        }
        np1 np1 = new np1();
        np1.b = animatedImage;
        return np1;
    }

    public String toString() {
        return "PexodeResult(bitmap=" + this.a + ", animated=" + this.b + jl1.BRACKET_END_STR;
    }
}
