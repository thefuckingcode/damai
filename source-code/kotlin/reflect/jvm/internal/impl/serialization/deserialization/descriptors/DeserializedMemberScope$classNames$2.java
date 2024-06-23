package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.og1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class DeserializedMemberScope$classNames$2 extends Lambda implements Function0<Set<? extends og1>> {
    final /* synthetic */ Function0<Collection<og1>> $classNames;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function0<? extends java.util.Collection<tb.og1>> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedMemberScope$classNames$2(Function0<? extends Collection<og1>> function0) {
        super(0);
        this.$classNames = function0;
    }

    /* Return type fixed from 'java.util.Set<tb.og1>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Set<? extends og1> invoke() {
        return CollectionsKt___CollectionsKt.C0(this.$classNames.invoke());
    }
}
