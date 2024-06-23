package tb;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.WXConfig;
import com.taobao.weex.utils.WXViewUtils;
import java.util.Map;

/* compiled from: Taobao */
public class jx2 {
    public static final String KEY_USER_AGENT = "user-agent";
    private static String a;

    public static String a(Context context, Map<String, String> map) {
        String str;
        String str2;
        if (TextUtils.isEmpty(a)) {
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(WXConfig.sysModel));
            sb.append("(Android/");
            sb.append(map.get(WXConfig.sysVersion));
            sb.append(jl1.BRACKET_END_STR);
            String str3 = " ";
            sb.append(str3);
            sb.append(TextUtils.isEmpty(map.get(WXConfig.appGroup)) ? "" : map.get(WXConfig.appGroup));
            sb.append(jl1.BRACKET_START_STR);
            if (TextUtils.isEmpty(map.get("appName"))) {
                str = "";
            } else {
                str = map.get("appName");
            }
            sb.append(str);
            sb.append("/");
            sb.append(map.get("appVersion"));
            sb.append(jl1.BRACKET_END_STR);
            sb.append(str3);
            sb.append("Weex/");
            sb.append(map.get("weexVersion"));
            sb.append(str3);
            if (TextUtils.isEmpty(map.get(WXConfig.externalUserAgent))) {
                str2 = "";
            } else {
                str2 = map.get(WXConfig.externalUserAgent);
            }
            sb.append(str2);
            if (TextUtils.isEmpty(map.get(WXConfig.externalUserAgent))) {
                str3 = "";
            }
            sb.append(str3);
            sb.append(WXViewUtils.getScreenWidth(context) + Constants.Name.X + WXViewUtils.getScreenHeight(context));
            a = sb.toString();
        }
        return a;
    }
}
