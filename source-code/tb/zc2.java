package tb;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: Taobao */
public class zc2 {
    public static String a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ut_setting", 4)) == null) {
            return null;
        }
        return sharedPreferences.getString(str, null);
    }

    public static void b(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context != null && (sharedPreferences = context.getSharedPreferences("ut_setting", 4)) != null && (edit = sharedPreferences.edit()) != null) {
            edit.putString(str, str2);
            edit.apply();
        }
    }
}
