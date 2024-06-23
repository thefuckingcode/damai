package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* access modifiers changed from: package-private */
/* compiled from: NewCapturedType.kt */
public final class NewCapturedTypeConstructor$refine$$inlined$let$lambda$1 extends Lambda implements Function0<List<? extends UnwrappedType>> {
    final /* synthetic */ KotlinTypeRefiner $kotlinTypeRefiner$inlined;
    final /* synthetic */ NewCapturedTypeConstructor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NewCapturedTypeConstructor$refine$$inlined$let$lambda$1(NewCapturedTypeConstructor newCapturedTypeConstructor, KotlinTypeRefiner kotlinTypeRefiner) {
        super(0);
        this.this$0 = newCapturedTypeConstructor;
        this.$kotlinTypeRefiner$inlined = kotlinTypeRefiner;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.types.UnwrappedType>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final List<? extends UnwrappedType> invoke() {
        List<UnwrappedType> supertypes = this.this$0.getSupertypes();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(supertypes, 10));
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().refine(this.$kotlinTypeRefiner$inlined));
        }
        return arrayList;
    }
}
