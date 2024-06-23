package tb;

import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class lf0 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String DATA = "data";
    @NotNull
    public static final String DEFAULT_TYPE = "result";
    @NotNull
    public static final String ERR_CODE = "code";
    @NotNull
    public static final String ERR_MSG = "msg";
    @NotNull
    public static final String TYPE = "type";
    @Nullable
    private final Map<String, Object> a;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    private lf0(Map<String, ? extends Object> map, String str) {
        this.a = map;
    }

    @Nullable
    public abstract Map<String, Object> a();

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ lf0(Map map, String str, int i, m40 m40) {
        this(map, (i & 2) != 0 ? "result" : str);
    }

    public /* synthetic */ lf0(Map map, String str, m40 m40) {
        this(map, str);
    }
}
