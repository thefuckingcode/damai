package tb;

import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class j42 {
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.Collection<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Collection<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final <T> Collection<T> a(@Nullable Collection<? extends T> collection, @NotNull Collection<? extends T> collection2) {
        k21.i(collection2, "collection");
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == 0) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: tb.ac2<kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final ac2<MemberScope> b(@NotNull Iterable<? extends MemberScope> iterable) {
        k21.i(iterable, "scopes");
        ac2<MemberScope> ac2 = new ac2<>();
        for (Object obj : iterable) {
            MemberScope memberScope = (MemberScope) obj;
            if ((memberScope == null || memberScope == MemberScope.b.INSTANCE) ? false : true) {
                ac2.add(obj);
            }
        }
        return ac2;
    }
}
