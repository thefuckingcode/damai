package tb;

import android.content.Context;
import android.os.Looper;
import android.util.TypedValue;
import java.io.File;
import java.io.FileFilter;

/* compiled from: Taobao */
public class j22 {

    /* compiled from: Taobao */
    static class a implements FileFilter {
        a() {
        }

        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (name.charAt(i) < '0' || name.charAt(i) > '9') {
                    return false;
                }
            }
            return true;
        }
    }

    static {
        new a();
    }

    public static String a(Class cls) {
        String name = cls.getName();
        return name.substring(name.lastIndexOf(46) + 1);
    }

    public static boolean b() {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }

    public static boolean c(Context context, int i) {
        CharSequence charSequence;
        TypedValue typedValue = new TypedValue();
        try {
            context.getResources().getValue(i, typedValue, true);
        } catch (Exception e) {
            kg0.c("TCommon", "get resources type value error=%s", e);
        }
        int i2 = typedValue.type;
        if ((i2 != 1 && i2 != 3) || (charSequence = typedValue.string) == null) {
            return false;
        }
        String charSequence2 = charSequence.toString();
        if (charSequence2.endsWith(".png") || charSequence2.endsWith(".jpg") || charSequence2.endsWith(".webp")) {
            return true;
        }
        return false;
    }
}
