package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import tb.g61;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public interface SupertypeLoopChecker {

    /* compiled from: Taobao */
    public static final class a implements SupertypeLoopChecker {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Collection<? extends tb.g61> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker
        @NotNull
        public Collection<g61> findLoopsInSupertypesAndDisconnect(@NotNull TypeConstructor typeConstructor, @NotNull Collection<? extends g61> collection, @NotNull Function1<? super TypeConstructor, ? extends Iterable<? extends g61>> function1, @NotNull Function1<? super g61, ur2> function12) {
            k21.i(typeConstructor, "currentTypeConstructor");
            k21.i(collection, "superTypes");
            k21.i(function1, "neighbors");
            k21.i(function12, "reportLoop");
            return collection;
        }
    }

    @NotNull
    Collection<g61> findLoopsInSupertypesAndDisconnect(@NotNull TypeConstructor typeConstructor, @NotNull Collection<? extends g61> collection, @NotNull Function1<? super TypeConstructor, ? extends Iterable<? extends g61>> function1, @NotNull Function1<? super g61, ur2> function12);
}
