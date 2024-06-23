package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.og1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class DeserializedClassDescriptor$DeserializedClassMemberScope$2$1 extends Lambda implements Function0<List<? extends og1>> {
    final /* synthetic */ List<og1> $it;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedClassDescriptor$DeserializedClassMemberScope$2$1(List<og1> list) {
        super(0);
        this.$it = list;
    }

    /* Return type fixed from 'java.util.List<tb.og1>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final List<? extends og1> invoke() {
        return this.$it;
    }
}
