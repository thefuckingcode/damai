package tb;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class oj {
    @NotNull
    public static final oj INSTANCE = new oj();
    @JvmField
    public static final boolean brittleContainsOptimizationEnabled;

    static {
        String property = System.getProperty("kotlin.collections.convert_arg_to_set_in_removeAll");
        brittleContainsOptimizationEnabled = property != null ? Boolean.parseBoolean(property) : false;
    }

    private oj() {
    }
}
