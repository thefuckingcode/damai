package androidx.core.net;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.alipay.sdk.m.n.a;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import tb.jl1;

/* compiled from: Taobao */
public final class MailTo {
    private static final String BCC = "bcc";
    private static final String BODY = "body";
    private static final String CC = "cc";
    private static final String MAILTO = "mailto";
    public static final String MAILTO_SCHEME = "mailto:";
    private static final String SUBJECT = "subject";
    private static final String TO = "to";
    private HashMap<String, String> mHeaders = new HashMap<>();

    private MailTo() {
    }

    public static boolean isMailTo(@Nullable String str) {
        return str != null && str.startsWith("mailto:");
    }

    @NonNull
    public static MailTo parse(@NonNull String str) throws ParseException {
        String str2;
        String str3;
        Preconditions.checkNotNull(str);
        if (isMailTo(str)) {
            int indexOf = str.indexOf(35);
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            int indexOf2 = str.indexOf(63);
            if (indexOf2 == -1) {
                str3 = Uri.decode(str.substring(7));
                str2 = null;
            } else {
                str3 = Uri.decode(str.substring(7, indexOf2));
                str2 = str.substring(indexOf2 + 1);
            }
            MailTo mailTo = new MailTo();
            if (str2 != null) {
                for (String str4 : str2.split("&")) {
                    String[] split = str4.split("=", 2);
                    if (split.length != 0) {
                        mailTo.mHeaders.put(Uri.decode(split[0]).toLowerCase(Locale.ROOT), split.length > 1 ? Uri.decode(split[1]) : null);
                    }
                }
            }
            String to = mailTo.getTo();
            if (to != null) {
                str3 = str3 + AVFSCacheConstants.COMMA_SEP + to;
            }
            mailTo.mHeaders.put("to", str3);
            return mailTo;
        }
        throw new ParseException("Not a mailto scheme");
    }

    @Nullable
    public String getBcc() {
        return this.mHeaders.get(BCC);
    }

    @Nullable
    public String getBody() {
        return this.mHeaders.get("body");
    }

    @Nullable
    public String getCc() {
        return this.mHeaders.get("cc");
    }

    @Nullable
    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    @Nullable
    public String getSubject() {
        return this.mHeaders.get("subject");
    }

    @Nullable
    public String getTo() {
        return this.mHeaders.get("to");
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("mailto:");
        sb.append(jl1.CONDITION_IF);
        for (Map.Entry<String, String> entry : this.mHeaders.entrySet()) {
            sb.append(Uri.encode(entry.getKey()));
            sb.append(a.h);
            sb.append(Uri.encode(entry.getValue()));
            sb.append('&');
        }
        return sb.toString();
    }

    public static boolean isMailTo(@Nullable Uri uri) {
        return uri != null && MAILTO.equals(uri.getScheme());
    }

    @NonNull
    public static MailTo parse(@NonNull Uri uri) throws ParseException {
        return parse(uri.toString());
    }
}
