package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.n;
import kotlin.collections.w;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.og1;
import tb.ww1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class DeserializedMemberScope$NoReorderImplementation$typeAliasesByName$2 extends Lambda implements Function0<Map<og1, ? extends TypeAliasDescriptor>> {
    final /* synthetic */ DeserializedMemberScope.NoReorderImplementation this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedMemberScope$NoReorderImplementation$typeAliasesByName$2(DeserializedMemberScope.NoReorderImplementation noReorderImplementation) {
        super(0);
        this.this$0 = noReorderImplementation;
    }

    /* Return type fixed from 'java.util.Map<tb.og1, kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Map<og1, ? extends TypeAliasDescriptor> invoke() {
        List list = this.this$0.v();
        LinkedHashMap linkedHashMap = new LinkedHashMap(ww1.a(w.e(n.q(list, 10)), 16));
        for (Object obj : list) {
            og1 name = ((TypeAliasDescriptor) obj).getName();
            k21.h(name, "it.name");
            linkedHashMap.put(name, obj);
        }
        return linkedHashMap;
    }
}
