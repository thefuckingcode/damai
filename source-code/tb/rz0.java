package tb;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.ImageAssetDelegate;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class rz0 {
    private static final Object e = new Object();
    private final Context a;
    private final String b;
    @Nullable
    private ImageAssetDelegate c;
    private final Map<String, na1> d;

    public rz0(Drawable.Callback callback, String str, ImageAssetDelegate imageAssetDelegate, Map<String, na1> map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.b = str;
        } else {
            this.b = str + v00.DIR;
        }
        if (!(callback instanceof View)) {
            o91.c("LottieDrawable must be inside of a view for images to work.");
            this.d = new HashMap();
            this.a = null;
            return;
        }
        this.a = ((View) callback).getContext();
        this.d = map;
        d(imageAssetDelegate);
    }

    private Bitmap c(String str, @Nullable Bitmap bitmap) {
        synchronized (e) {
            this.d.get(str).f(bitmap);
        }
        return bitmap;
    }

    @Nullable
    public Bitmap a(String str) {
        na1 na1 = this.d.get(str);
        if (na1 == null) {
            return null;
        }
        Bitmap a2 = na1.a();
        if (a2 != null) {
            return a2;
        }
        ImageAssetDelegate imageAssetDelegate = this.c;
        if (imageAssetDelegate != null) {
            Bitmap fetchBitmap = imageAssetDelegate.fetchBitmap(na1);
            if (fetchBitmap != null) {
                c(str, fetchBitmap);
            }
            return fetchBitmap;
        }
        String b2 = na1.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (!b2.startsWith("data:") || b2.indexOf("base64,") <= 0) {
            try {
                if (!TextUtils.isEmpty(this.b)) {
                    AssetManager assets = this.a.getAssets();
                    try {
                        return c(str, xt2.l(BitmapFactory.decodeStream(assets.open(this.b + b2), null, options), na1.e(), na1.c()));
                    } catch (IllegalArgumentException e2) {
                        o91.d("Unable to decode image.", e2);
                        return null;
                    }
                } else {
                    throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
                }
            } catch (IOException e3) {
                o91.d("Unable to open asset.", e3);
                return null;
            }
        } else {
            try {
                byte[] decode = Base64.decode(b2.substring(b2.indexOf(44) + 1), 0);
                return c(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e4) {
                o91.d("data URL did not have correct base64 format.", e4);
                return null;
            }
        }
    }

    public boolean b(Context context) {
        return (context == null && this.a == null) || this.a.equals(context);
    }

    public void d(@Nullable ImageAssetDelegate imageAssetDelegate) {
        this.c = imageAssetDelegate;
    }

    @Nullable
    public Bitmap e(String str, @Nullable Bitmap bitmap) {
        if (bitmap == null) {
            na1 na1 = this.d.get(str);
            Bitmap a2 = na1.a();
            na1.f(null);
            return a2;
        }
        Bitmap a3 = this.d.get(str).a();
        c(str, bitmap);
        return a3;
    }
}
