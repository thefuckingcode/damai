package tb;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.annotation.DrawableRes;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;

/* compiled from: Taobao */
public class gf2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1936846675")) {
            return (String) ipChange.ipc$dispatch("1936846675", new Object[]{str, str2});
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str2);
            }
            return sb.toString();
        } else {
            return str + " | " + str2;
        }
    }

    public static SpannableStringBuilder b(Context context, @DrawableRes int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1834428349")) {
            return (SpannableStringBuilder) ipChange.ipc$dispatch("-1834428349", new Object[]{context, Integer.valueOf(i), str});
        } else if (context == null) {
            return null;
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Constants.Name.PREFIX);
            spannableStringBuilder.setSpan(new d01(context, i), 0, 6, 33);
            spannableStringBuilder.append((CharSequence) " ");
            if (!TextUtils.isEmpty(str)) {
                spannableStringBuilder.append((CharSequence) str);
            }
            return spannableStringBuilder;
        }
    }
}
