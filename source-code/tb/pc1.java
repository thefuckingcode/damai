package tb;

import java.util.HashSet;
import java.util.Set;
import kotlin.collections.r;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class pc1 {
    @Nullable
    public static final Set<og1> a(@NotNull Iterable<? extends MemberScope> iterable) {
        k21.i(iterable, "<this>");
        HashSet hashSet = new HashSet();
        for (MemberScope memberScope : iterable) {
            Set<og1> classifierNames = memberScope.getClassifierNames();
            if (classifierNames == null) {
                return null;
            }
            boolean unused = r.v(hashSet, classifierNames);
        }
        return hashSet;
    }
}
