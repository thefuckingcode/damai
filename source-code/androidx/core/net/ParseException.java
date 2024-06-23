package androidx.core.net;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
public class ParseException extends RuntimeException {
    @NonNull
    public final String response;

    ParseException(@NonNull String str) {
        super(str);
        this.response = str;
    }
}
