package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* compiled from: RawType.kt */
final class RawTypeImpl$render$2 extends Lambda implements Function1<KotlinType, List<? extends String>> {
    final /* synthetic */ DescriptorRenderer $renderer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RawTypeImpl$render$2(DescriptorRenderer descriptorRenderer) {
        super(1);
        this.$renderer = descriptorRenderer;
    }

    public final List<String> invoke(KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "type");
        List<TypeProjection> arguments = kotlinType.getArguments();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arguments, 10));
        Iterator<T> it = arguments.iterator();
        while (it.hasNext()) {
            arrayList.add(this.$renderer.renderTypeProjection(it.next()));
        }
        return arrayList;
    }
}
