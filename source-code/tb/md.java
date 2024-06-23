package tb;

import com.alibaba.security.realidentity.jsbridge.a;
import java.io.InputStream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class md {
    @Nullable
    public final InputStream a(@NotNull String str) {
        k21.i(str, a.V);
        ClassLoader classLoader = md.class.getClassLoader();
        InputStream resourceAsStream = classLoader == null ? null : classLoader.getResourceAsStream(str);
        return resourceAsStream == null ? ClassLoader.getSystemResourceAsStream(str) : resourceAsStream;
    }
}
