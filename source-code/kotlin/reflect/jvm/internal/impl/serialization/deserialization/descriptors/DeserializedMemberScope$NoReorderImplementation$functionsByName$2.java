package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.og1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class DeserializedMemberScope$NoReorderImplementation$functionsByName$2 extends Lambda implements Function0<Map<og1, ? extends List<? extends SimpleFunctionDescriptor>>> {
    final /* synthetic */ DeserializedMemberScope.NoReorderImplementation this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedMemberScope$NoReorderImplementation$functionsByName$2(DeserializedMemberScope.NoReorderImplementation noReorderImplementation) {
        super(0);
        this.this$0 = noReorderImplementation;
    }

    /* Return type fixed from 'java.util.Map<tb.og1, java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Map<og1, ? extends List<? extends SimpleFunctionDescriptor>> invoke() {
        List list = this.this$0.t();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            og1 name = ((SimpleFunctionDescriptor) obj).getName();
            k21.h(name, "it.name");
            Object obj2 = linkedHashMap.get(name);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(name, obj2);
            }
            ((List) obj2).add(obj);
        }
        return linkedHashMap;
    }
}
