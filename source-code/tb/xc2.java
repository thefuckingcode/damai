package tb;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
public class xc2 {
    public static final String FILE_NAME = "taomai.h5cache";
    public static final String KEY_FILM_DETAIL_HIGHLIGHT_FIRST_PRE = "highlight_first_0";
    public static final String KEY_FILM_DETAIL_MOVIEDATE_FIRST_PRE = "moviedate_first_0";
    @Nullable
    private static xc2 c;
    private Context a;
    private int b;

    private xc2() {
    }

    @NonNull
    public static synchronized xc2 a() {
        xc2 c2;
        synchronized (xc2.class) {
            c2 = c(xi2.a, 0);
        }
        return c2;
    }

    @NonNull
    public static synchronized xc2 b(@NonNull Context context) {
        xc2 c2;
        synchronized (xc2.class) {
            c2 = c(context, 0);
        }
        return c2;
    }

    @NonNull
    public static synchronized xc2 c(@NonNull Context context, int i) {
        xc2 xc2;
        synchronized (xc2.class) {
            if (c == null) {
                c = new xc2();
            }
            c.a = context.getApplicationContext();
            xc2 = c;
            xc2.b = i;
        }
        return xc2;
    }

    @NonNull
    public String d(@NonNull String str) {
        SharedPreferences sharedPreferences = this.a.getSharedPreferences(FILE_NAME, this.b);
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString(str, "");
    }

    public void e(@NonNull String str, @NonNull String str2) {
        this.a.getSharedPreferences(FILE_NAME, this.b).edit().putString(str, str2).apply();
    }

    public void f(@NonNull String str) {
        this.a.getSharedPreferences(FILE_NAME, this.b).edit().remove(str).apply();
    }
}
