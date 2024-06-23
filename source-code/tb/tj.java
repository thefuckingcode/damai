package tb;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.FloatRange;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public class tj {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1001791547")) {
            return ((Integer) ipChange.ipc$dispatch("1001791547", new Object[]{str})).intValue();
        } else if (TextUtils.isEmpty(str)) {
            return Color.parseColor("#00000000");
        } else {
            Matcher matcher = Pattern.compile("^#[0-9a-fA-F]{6}$").matcher(str);
            if (TextUtils.isEmpty("#00000000") || !matcher.matches()) {
                str = "#00000000";
            }
            return Color.parseColor(str);
        }
    }

    public static String b(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1064608462")) {
            return (String) ipChange.ipc$dispatch("-1064608462", new Object[]{str});
        } else if (str.contains(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
            return str;
        } else {
            try {
                String[] split = str.replace("rgba", "").replace(jl1.BRACKET_START_STR, "").replace(jl1.BRACKET_END_STR, "").replace(StringUtils.LF, "").replace(" ", "").split(",");
                if (Integer.toHexString(Integer.parseInt(split[0])).length() == 1) {
                    str2 = "0" + Integer.toHexString(Integer.parseInt(split[0]));
                } else {
                    str2 = Integer.toHexString(Integer.parseInt(split[0]));
                }
                if (Integer.toHexString(Integer.parseInt(split[1])).length() == 1) {
                    str3 = "0" + Integer.toHexString(Integer.parseInt(split[1]));
                } else {
                    str3 = Integer.toHexString(Integer.parseInt(split[1]));
                }
                if (Integer.toHexString(Integer.parseInt(split[2])).length() == 1) {
                    str4 = "0" + Integer.toHexString(Integer.parseInt(split[2]));
                } else {
                    str4 = Integer.toHexString(Integer.parseInt(split[2]));
                }
                if (Integer.toHexString(Float.valueOf(Float.parseFloat(split[3]) * 255.0f).intValue()).length() == 1) {
                    str5 = "0" + Integer.toHexString(Float.valueOf(Float.parseFloat(split[3]) * 255.0f).intValue());
                } else {
                    str5 = Integer.toHexString(Float.valueOf(Float.parseFloat(split[3]) * 255.0f).intValue());
                }
                String str6 = Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str5 + str2 + str3 + str4;
                Color.parseColor(str);
                return str6;
            } catch (ArrayIndexOutOfBoundsException e) {
                g91.d(e);
                return "#ffffff";
            } catch (NumberFormatException e2) {
                g91.d(e2);
                return "#ffffff";
            } catch (IllegalArgumentException e3) {
                g91.d(e3);
                return "#ffffff";
            }
        }
    }

    public static int c(@FloatRange(from = 0.0d, to = 1.0d) float f, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-45143282")) {
            return ((Integer) ipChange.ipc$dispatch("-45143282", new Object[]{Float.valueOf(f), Integer.valueOf(i)})).intValue();
        }
        return Color.argb(Math.round(f * 255.0f), (16711680 & i) >> 16, (65280 & i) >> 8, i & 255);
    }
}
