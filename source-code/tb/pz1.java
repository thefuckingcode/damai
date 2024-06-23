package tb;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.taobao.phenix.cache.memory.ReleasableReferenceListener;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public class pz1 extends so1 {
    private ReleasableReferenceListener g;
    private WeakReference<Drawable.Callback> h;
    private boolean i;

    public pz1(Resources resources, Bitmap bitmap, Rect rect, String str, String str2, int i2, int i3) {
        super(resources, bitmap, rect, str, str2, i2, i3);
    }

    @Override // tb.so1
    public NinePatchDrawable a() {
        NinePatchDrawable a = super.a();
        synchronized (this) {
            if (a != null) {
                ReleasableReferenceListener releasableReferenceListener = this.g;
                if (releasableReferenceListener != null) {
                    releasableReferenceListener.onReferenceDowngrade2Passable(this);
                }
            }
        }
        return a;
    }

    public void draw(Canvas canvas) {
        if (!this.i) {
            super.draw(canvas);
            Drawable.Callback callback = getCallback();
            Drawable.Callback callback2 = null;
            WeakReference<Drawable.Callback> weakReference = this.h;
            if (weakReference == null || (callback2 = weakReference.get()) != callback) {
                synchronized (this) {
                    if (callback2 != null) {
                        ReleasableReferenceListener releasableReferenceListener = this.g;
                        if (releasableReferenceListener != null) {
                            releasableReferenceListener.onReferenceDowngrade2Passable(this);
                        }
                    }
                }
                this.h = new WeakReference<>(callback);
                return;
            }
            return;
        }
        throw new RuntimeException("ReleasableBitmapDrawable has been released before drawing!");
    }

    public synchronized void j() {
        ReleasableReferenceListener releasableReferenceListener = this.g;
        if (releasableReferenceListener != null) {
            releasableReferenceListener.onReferenceDowngrade2Passable(this);
        }
    }

    public void k() {
        setCallback(null);
        this.i = true;
        synchronized (this) {
            ReleasableReferenceListener releasableReferenceListener = this.g;
            if (releasableReferenceListener != null) {
                releasableReferenceListener.onReferenceReleased(this);
            }
        }
    }

    public synchronized void l(ReleasableReferenceListener releasableReferenceListener) {
        this.g = releasableReferenceListener;
    }
}
