package tb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.TypedValue;
import com.alibaba.pictures.moimage.IImageUrlFixer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.text.o;

public final class ke1 {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final String ANDROID_RESOURCE_SCHEME;
    public static final String FOREWARD_SLASH;
    public static final ke1 INSTANCE = new ke1();
    public static final String PRELOAD_IMG;
    public static final String SCHEME_FILE_Q;
    public static final String SCHEME_SLASH;

    private ke1() {
    }

    public static /* synthetic */ Bitmap d(ke1 ke1, Drawable drawable, Integer num, Integer num2, int i, Object obj) {
        if ((i & 2) != 0) {
            num = -1;
        }
        if ((i & 4) != 0) {
            num2 = -1;
        }
        return ke1.c(drawable, num, num2);
    }

    public final String a(String str) {
        IImageUrlFixer e;
        String addPrefixIfNeeded;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1152396641")) {
            return (String) ipChange.ipc$dispatch("-1152396641", new Object[]{this, str});
        }
        return (str == null || (e = ne1.INSTANCE.e()) == null || (addPrefixIfNeeded = e.addPrefixIfNeeded(str)) == null) ? str : addPrefixIfNeeded;
    }

    public final String b(String str, Integer num, Integer num2) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-540427406")) {
            return (String) ipChange.ipc$dispatch("-540427406", new Object[]{this, str, num, num2});
        }
        if (str == null) {
            return null;
        }
        if (num2 == null || num2.intValue() <= 0 || num == null || num.intValue() <= 0) {
            IImageUrlFixer e = ne1.INSTANCE.e();
            if (e == null || (str2 = e.addPrefixIfNeeded(str)) == null) {
                return str;
            }
        } else {
            IImageUrlFixer e2 = ne1.INSTANCE.e();
            if (e2 == null || (str2 = e2.autoFix(str, num.intValue(), num2.intValue())) == null) {
                return str;
            }
        }
        return str2;
    }

    public final Bitmap c(Drawable drawable, Integer num, Integer num2) {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1219606980")) {
            return (Bitmap) ipChange.ipc$dispatch("-1219606980", new Object[]{this, drawable, num, num2});
        } else if (drawable == null) {
            return null;
        } else {
            if (num == null || num.intValue() <= 0 || num2 == null || num.intValue() <= 0) {
                i2 = drawable.getIntrinsicWidth();
                i = drawable.getIntrinsicHeight();
            } else {
                i2 = 0;
                i = 0;
            }
            if (i2 == 0 || i == 0) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(i2, i, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, i2, i);
            drawable.draw(canvas);
            canvas.setBitmap(null);
            return createBitmap;
        }
    }

    public final Bitmap.Config e(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1830194908")) {
            return (Bitmap.Config) ipChange.ipc$dispatch("1830194908", new Object[]{this, bitmap});
        }
        if ((bitmap != null ? bitmap.getConfig() : null) == null) {
            return Bitmap.Config.ARGB_8888;
        }
        Bitmap.Config config = bitmap.getConfig();
        k21.h(config, "bitmap.config");
        return config;
    }

    public final boolean f(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "519357452")) {
            return ((Boolean) ipChange.ipc$dispatch("519357452", new Object[]{this, uri})).booleanValue();
        }
        return k21.d(uri != null ? uri.getScheme() : null, ANDROID_RESOURCE_SCHEME);
    }

    public final boolean g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "448029628")) {
            return ((Boolean) ipChange.ipc$dispatch("448029628", new Object[]{this, str})).booleanValue();
        } else if (str == null) {
            return false;
        } else {
            Uri parse = Uri.parse(str);
            k21.h(parse, "oriUri");
            if (parse.getScheme() == null || !(!k21.d(parse.getScheme(), "http")) || !(!k21.d(parse.getScheme(), "https"))) {
                return false;
            }
            return true;
        }
    }

    public final boolean h(Context context, int i) {
        CharSequence charSequence;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1557417414")) {
            return ((Boolean) ipChange.ipc$dispatch("-1557417414", new Object[]{this, context, Integer.valueOf(i)})).booleanValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        TypedValue typedValue = new TypedValue();
        try {
            context.getResources().getValue(i, typedValue, true);
        } catch (Exception e) {
            me1 me1 = me1.INSTANCE;
            me1.d("MoImageHelper", "isPictureResource:get resources type value error=" + e);
        }
        int i2 = typedValue.type;
        if ((i2 == 1 || i2 == 3) && (charSequence = typedValue.string) != null) {
            String obj = charSequence.toString();
            if ((o.v(obj, ".png", false, 2, null)) || (o.v(obj, ".jpg", false, 2, null)) || (o.v(obj, ".webp", false, 2, null))) {
                return true;
            }
        }
        return false;
    }

    public final Integer i(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1565688570")) {
            return (Integer) ipChange.ipc$dispatch("1565688570", new Object[]{this, uri});
        }
        if (!k21.d(uri != null ? uri.getScheme() : null, ANDROID_RESOURCE_SCHEME) || uri.getPath() == null) {
            return null;
        }
        try {
            String path = uri.getPath();
            k21.f(path);
            k21.h(path, "uri.path!!");
            if (path != null) {
                String substring = path.substring(1);
                k21.h(substring, "(this as java.lang.String).substring(startIndex)");
                return Integer.valueOf(substring);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (Exception unused) {
            me1.INSTANCE.c("MoImageHelper:resolveIdFromMoUri:本地资源图片仅限设置ID");
            return null;
        }
    }

    public final Uri j(Context context, Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1562944413")) {
            return (Uri) ipChange.ipc$dispatch("1562944413", new Object[]{this, context, num});
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (num == null) {
            return null;
        }
        return Uri.parse("pictures.android.resource://" + context.getPackageName() + "/" + num);
    }
}
