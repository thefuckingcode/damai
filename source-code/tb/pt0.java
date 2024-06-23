package tb;

import android.net.Uri;
import android.os.Bundle;
import com.alipay.sdk.m.n.a;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class pt0 {
    @NotNull
    public static final pt0 INSTANCE = new pt0();

    private pt0() {
    }

    @NotNull
    public final Bundle a(@Nullable String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            Uri parse = Uri.parse(str);
            try {
                k21.h(parse, "uri");
                for (String str2 : parse.getQueryParameterNames()) {
                    bundle.putString(str2, parse.getQueryParameter(str2));
                }
            } catch (Exception e) {
                j91.a("TaoMaiH5Util", "parse url error:" + e);
            }
        }
        return bundle;
    }

    @Nullable
    public final String b(@Nullable String str, @NotNull String str2) {
        Uri uri;
        String str3;
        k21.i(str2, "key");
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            uri = Uri.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
            uri = null;
        }
        if (uri == null) {
            return null;
        }
        if (uri.isOpaque()) {
            return null;
        }
        String queryParameter = uri.getQueryParameter(str2);
        if (!(queryParameter == null || queryParameter.length() == 0)) {
            return queryParameter;
        }
        try {
            str3 = uri.getQueryParameter("__webview_options__");
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = null;
        }
        if (str3 == null || str3.length() == 0) {
            return null;
        }
        int length = str3.length();
        int i = 0;
        while (true) {
            int i2 = StringsKt__StringsKt.e0(str3, '&', i, false, 4, null);
            int i3 = i2 != -1 ? i2 : length;
            int i4 = StringsKt__StringsKt.e0(str3, a.h, i, false, 4, null);
            int i5 = (i4 > i3 || i4 == -1) ? i3 : i4;
            if (i5 - i != str2.length() || !(o.A(str3, i, str2, 0, str2.length(), false, 16, null))) {
                if (i2 == -1) {
                    return null;
                }
                i = i2 + 1;
            } else if (i5 == i3) {
                return "";
            } else {
                String substring = str3.substring(i5 + 1, i3);
                k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
        }
    }
}
