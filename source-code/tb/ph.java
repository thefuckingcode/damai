package tb;

import java.nio.charset.Charset;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class ph {
    @NotNull
    public static final ph INSTANCE = new ph();
    @JvmField
    @NotNull
    public static final Charset ISO_8859_1;
    @JvmField
    @NotNull
    public static final Charset US_ASCII;
    @JvmField
    @NotNull
    public static final Charset UTF_16;
    @JvmField
    @NotNull
    public static final Charset UTF_16BE;
    @JvmField
    @NotNull
    public static final Charset UTF_16LE;
    @JvmField
    @NotNull
    public static final Charset UTF_8;

    static {
        Charset forName = Charset.forName("UTF-8");
        k21.h(forName, "forName(\"UTF-8\")");
        UTF_8 = forName;
        Charset forName2 = Charset.forName("UTF-16");
        k21.h(forName2, "forName(\"UTF-16\")");
        UTF_16 = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        k21.h(forName3, "forName(\"UTF-16BE\")");
        UTF_16BE = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        k21.h(forName4, "forName(\"UTF-16LE\")");
        UTF_16LE = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        k21.h(forName5, "forName(\"US-ASCII\")");
        US_ASCII = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        k21.h(forName6, "forName(\"ISO-8859-1\")");
        ISO_8859_1 = forName6;
    }

    private ph() {
    }
}
