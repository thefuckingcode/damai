package tb;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class xm0 {
    private final gg1<String> a = new gg1<>();
    private final Map<gg1<String>, Typeface> b = new HashMap();
    private final Map<String, Typeface> c = new HashMap();
    private final AssetManager d;
    private String e = ".ttf";

    public xm0(Drawable.Callback callback, @Nullable wm0 wm0) {
        if (!(callback instanceof View)) {
            o91.c("LottieDrawable must be inside of a view for images to work.");
            this.d = null;
            return;
        }
        this.d = ((View) callback).getContext().getAssets();
    }

    private Typeface a(String str) {
        Typeface typeface = this.c.get(str);
        if (typeface != null) {
            return typeface;
        }
        Typeface createFromAsset = Typeface.createFromAsset(this.d, "fonts/" + str + this.e);
        this.c.put(str, createFromAsset);
        return createFromAsset;
    }

    private Typeface d(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i = (!contains || !contains2) ? contains ? 2 : contains2 ? 1 : 0 : 3;
        if (typeface.getStyle() == i) {
            return typeface;
        }
        return Typeface.create(typeface, i);
    }

    public Typeface b(String str, String str2) {
        this.a.b(str, str2);
        Typeface typeface = this.b.get(this.a);
        if (typeface != null) {
            return typeface;
        }
        Typeface d2 = d(a(str), str2);
        this.b.put(this.a, d2);
        return d2;
    }

    public void c(@Nullable wm0 wm0) {
    }
}
