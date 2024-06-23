package tb;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.m;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class cd2 {
    @NotNull
    public static final cd2 INSTANCE = new cd2();
    @NotNull
    private static final Set<oi> a;

    static {
        List<en0> list = m.j(u41.METADATA_FQ_NAME, u41.JETBRAINS_NOT_NULL_ANNOTATION, u41.JETBRAINS_NULLABLE_ANNOTATION, u41.TARGET_ANNOTATION, u41.RETENTION_ANNOTATION, u41.DOCUMENTED_ANNOTATION);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (en0 en0 : list) {
            linkedHashSet.add(oi.m(en0));
        }
        a = linkedHashSet;
    }

    private cd2() {
    }

    @NotNull
    public final Set<oi> a() {
        return a;
    }
}
