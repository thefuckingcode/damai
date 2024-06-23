package tb;

import android.text.TextUtils;

/* compiled from: Taobao */
public class jg0 {
    public static String a(String str) {
        return (TextUtils.isEmpty(str) || !TextUtils.equals("#E1E5EA", str.toUpperCase())) ? str : "#F6F7F8";
    }
}
