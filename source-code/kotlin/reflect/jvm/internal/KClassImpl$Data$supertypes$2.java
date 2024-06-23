package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import tb.f60;
import tb.g61;
import tb.ib2;
import tb.k21;
import tb.qj;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KClassImpl$Data$supertypes$2 extends Lambda implements Function0<List<? extends KTypeImpl>> {
    final /* synthetic */ KClassImpl.Data this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KClassImpl$Data$supertypes$2(KClassImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.KTypeImpl>' to match base method */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0090  */
    @Override // kotlin.jvm.functions.Function0
    public final List<? extends KTypeImpl> invoke() {
        boolean z;
        TypeConstructor typeConstructor = this.this$0.n().getTypeConstructor();
        k21.h(typeConstructor, "descriptor.typeConstructor");
        Collection<g61> supertypes = typeConstructor.getSupertypes();
        k21.h(supertypes, "descriptor.typeConstructor.supertypes");
        ArrayList arrayList = new ArrayList(supertypes.size());
        for (T t : supertypes) {
            k21.h(t, "kotlinType");
            arrayList.add(new KTypeImpl(t, new KClassImpl$Data$supertypes$2$$special$$inlined$mapTo$lambda$1(t, this)));
        }
        if (!b.B0(this.this$0.n())) {
            boolean z2 = false;
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ClassDescriptor e = f60.e(((KTypeImpl) it.next()).c());
                    k21.h(e, "DescriptorUtils.getClassDescriptorForType(it.type)");
                    ClassKind kind = e.getKind();
                    k21.h(kind, "DescriptorUtils.getClass…ptorForType(it.type).kind");
                    if (kind == ClassKind.INTERFACE || kind == ClassKind.ANNOTATION_CLASS) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        break;
                    }
                }
                if (z2) {
                    ib2 i = DescriptorUtilsKt.g(this.this$0.n()).i();
                    k21.h(i, "descriptor.builtIns.anyType");
                    arrayList.add(new KTypeImpl(i, AnonymousClass3.INSTANCE));
                }
            }
            z2 = true;
            if (z2) {
            }
        }
        return qj.c(arrayList);
    }
}
