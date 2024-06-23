package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* compiled from: KClasses.kt */
final class KClasses$sam$org_jetbrains_kotlin_utils_DFS_Neighbors$0 implements DFS.Neighbors {
    private final /* synthetic */ Function1 function;

    KClasses$sam$org_jetbrains_kotlin_utils_DFS_Neighbors$0(Function1 function1) {
        this.function = function1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
    public final /* synthetic */ Iterable getNeighbors(Object obj) {
        return (Iterable) this.function.invoke(obj);
    }
}
