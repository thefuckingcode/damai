package com.youku.live.dago.widgetlib.ailpbaselib.utils;

import android.os.Build;
import android.text.Html;
import android.util.Base64;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* compiled from: Taobao */
public final class EncodeUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    private EncodeUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static byte[] base64Decode(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "248055846")) {
            return Base64.decode(str, 2);
        }
        return (byte[]) ipChange.ipc$dispatch("248055846", new Object[]{str});
    }

    public static byte[] base64Encode(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "57910862")) {
            return base64Encode(str.getBytes());
        }
        return (byte[]) ipChange.ipc$dispatch("57910862", new Object[]{str});
    }

    public static String base64Encode2String(byte[] bArr) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1570098743")) {
            return Base64.encodeToString(bArr, 2);
        }
        return (String) ipChange.ipc$dispatch("1570098743", new Object[]{bArr});
    }

    public static byte[] base64UrlSafeEncode(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2021001002")) {
            return Base64.encode(str.getBytes(), 8);
        }
        return (byte[]) ipChange.ipc$dispatch("-2021001002", new Object[]{str});
    }

    public static CharSequence htmlDecode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2065927073")) {
            return (CharSequence) ipChange.ipc$dispatch("-2065927073", new Object[]{str});
        } else if (Build.VERSION.SDK_INT >= 24) {
            return Html.fromHtml(str, 0);
        } else {
            return Html.fromHtml(str);
        }
    }

    public static String htmlEncode(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1104631379")) {
            return (String) ipChange.ipc$dispatch("1104631379", new Object[]{charSequence});
        }
        StringBuilder sb = new StringBuilder();
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (charAt == '\"') {
                sb.append("&quot;");
            } else if (charAt == '<') {
                sb.append("&lt;");
            } else if (charAt == '>') {
                sb.append("&gt;");
            } else if (charAt == '&') {
                sb.append("&amp;");
            } else if (charAt != '\'') {
                sb.append(charAt);
            } else {
                sb.append("&#39;");
            }
        }
        return sb.toString();
    }

    public static String urlDecode(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1415409709")) {
            return urlDecode(str, "UTF-8");
        }
        return (String) ipChange.ipc$dispatch("-1415409709", new Object[]{str});
    }

    public static String urlEncode(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2111561211")) {
            return urlEncode(str, "UTF-8");
        }
        return (String) ipChange.ipc$dispatch("2111561211", new Object[]{str});
    }

    public static byte[] base64Decode(byte[] bArr) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-549903671")) {
            return Base64.decode(bArr, 2);
        }
        return (byte[]) ipChange.ipc$dispatch("-549903671", new Object[]{bArr});
    }

    public static byte[] base64Encode(byte[] bArr) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "586486001")) {
            return Base64.encode(bArr, 2);
        }
        return (byte[]) ipChange.ipc$dispatch("586486001", new Object[]{bArr});
    }

    public static String urlDecode(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1005694089")) {
            return (String) ipChange.ipc$dispatch("1005694089", new Object[]{str, str2});
        }
        try {
            return URLDecoder.decode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static String urlEncode(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1582481585")) {
            return (String) ipChange.ipc$dispatch("1582481585", new Object[]{str, str2});
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }
}
