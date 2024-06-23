package tb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.taobao.pexode.Pexode;
import com.taobao.pexode.common.NdkCore;
import com.taobao.pexode.common.NewBitmapFactory;
import com.taobao.pexode.decoder.d;

/* compiled from: Taobao */
public class a8 implements NewBitmapFactory {

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        private static final a8 a = new a8();
    }

    public static a8 a() {
        return a.a;
    }

    @Override // com.taobao.pexode.common.NewBitmapFactory
    public Bitmap newBitmap(int i, int i2, Bitmap.Config config) {
        Bitmap bitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = config;
        d.d(options, true);
        com.taobao.pexode.a f = com.taobao.pexode.a.f();
        int i3 = jd0.FIXED_JPG_LENGTH;
        byte[] a2 = jd0.a(i, i2, f.g(i3));
        if (a2 != null) {
            bitmap = BitmapFactory.decodeByteArray(a2, 0, i3, options);
            com.taobao.pexode.a.f().h(a2);
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            bitmap.setHasAlpha(true);
        }
        return bitmap;
    }

    @Override // com.taobao.pexode.common.NewBitmapFactory
    public Bitmap newBitmapWithPin(int i, int i2, Bitmap.Config config) {
        Bitmap newBitmap = newBitmap(i, i2, config);
        if (newBitmap == null) {
            return newBitmap;
        }
        try {
            NdkCore.nativePinBitmap(newBitmap);
            newBitmap.eraseColor(0);
            return newBitmap;
        } catch (Throwable th) {
            kg0.c(Pexode.TAG, "AshmemBitmapFactory native pin bitmap error=%s", th);
            return null;
        }
    }
}
