package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.ib2;
import tb.k21;

/* compiled from: Taobao */
final class TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1 extends Lambda implements Function0<String> {
    final /* synthetic */ Set<ib2> $inputTypes;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.Set<? extends tb.ib2> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1(Set<? extends ib2> set) {
        super(0);
        this.$inputTypes = set;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final String invoke() {
        return k21.r("This collections cannot be empty! input types: ", CollectionsKt___CollectionsKt.Z(this.$inputTypes, null, null, null, 0, null, null, 63, null));
    }
}
