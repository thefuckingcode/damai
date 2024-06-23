package okhttp3;

import java.io.IOException;
import javax.annotation.Nullable;
import tb.o8;

/* compiled from: Taobao */
public interface Authenticator {
    public static final Authenticator NONE = o8.a;

    @Nullable
    o authenticate(@Nullable s sVar, q qVar) throws IOException;
}
