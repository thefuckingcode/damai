package tb;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class mp1 {
    private String a = "";
    private SharedPreferences b = null;
    private SharedPreferences.Editor c = null;
    private Context d = null;

    public mp1(Context context, String str, String str2, boolean z, boolean z2) {
        this.a = str2;
        this.d = context;
        if (context != null) {
            this.b = context.getSharedPreferences(str2, 0);
        }
    }

    private void c() {
        SharedPreferences sharedPreferences;
        if (this.c == null && (sharedPreferences = this.b) != null) {
            this.c = sharedPreferences.edit();
        }
    }

    public boolean a() {
        Context context;
        SharedPreferences.Editor editor = this.c;
        if (editor != null) {
            if (Build.VERSION.SDK_INT >= 9) {
                p22.a(editor);
            } else {
                editor.commit();
            }
        }
        if (this.b == null || (context = this.d) == null) {
            return true;
        }
        this.b = context.getSharedPreferences(this.a, 0);
        return true;
    }

    public String b(String str) {
        SharedPreferences sharedPreferences = this.b;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!zf2.f(string)) {
                return string;
            }
        }
        return "";
    }

    public void d(String str, String str2) {
        c();
        SharedPreferences.Editor editor = this.c;
        if (editor != null) {
            editor.putString(str, str2);
        }
    }
}
