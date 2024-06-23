package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ClassMapperLite.kt */
final class ClassMapperLite$map$1$1 extends Lambda implements Function2<String, String, Unit> {
    final /* synthetic */ Map $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClassMapperLite$map$1$1(Map map) {
        super(2);
        this.$this_apply = map;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
        invoke(str, str2);
        return Unit.INSTANCE;
    }

    public final void invoke(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "kotlinSimpleName");
        Intrinsics.checkParameterIsNotNull(str2, "javaInternalName");
        this.$this_apply.put("kotlin/" + str, 'L' + str2 + ';');
    }
}
