package tb;

import android.content.res.Resources;
import com.taobao.pexode.animate.AnimatedImage;
import com.taobao.phenix.animate.AnimatedImageDrawable;

/* compiled from: Taobao */
public class t5 extends me {
    final AnimatedImage i;

    public t5(AnimatedImage animatedImage, String str, String str2, int i2, int i3) {
        super(str, str2, i2, i3);
        this.i = animatedImage;
    }

    @Override // tb.me
    public int c() {
        AnimatedImage animatedImage = this.i;
        if (animatedImage == null) {
            return 0;
        }
        return animatedImage.getSizeInBytes();
    }

    /* access modifiers changed from: protected */
    @Override // tb.me
    public so1 d(String str, String str2, int i2, int i3, boolean z, Resources resources) {
        return new AnimatedImageDrawable(str, str2, i2, i3, this.i);
    }
}
