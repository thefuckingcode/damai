package tb;

import android.graphics.Color;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.Locale;

/* compiled from: Taobao */
public class uj {
    public static int a(String str, int i) {
        if (str == null || str.length() <= 0) {
            return i;
        }
        String lowerCase = str.toLowerCase(Locale.SIMPLIFIED_CHINESE);
        StringBuilder sb = new StringBuilder(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
        int i2 = 1;
        while (i2 < 9 && i2 < lowerCase.length()) {
            char charAt = lowerCase.charAt(i2);
            if ((charAt >= '0' && charAt <= '9') || (charAt >= 'a' && charAt <= 'f')) {
                sb.append(charAt);
            }
            i2++;
        }
        String sb2 = sb.toString();
        if (sb2.length() == 7 || sb2.length() == 9) {
            return Color.parseColor(sb2);
        }
        return i;
    }
}
