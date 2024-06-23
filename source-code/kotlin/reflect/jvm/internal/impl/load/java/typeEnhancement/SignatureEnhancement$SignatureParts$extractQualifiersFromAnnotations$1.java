package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* access modifiers changed from: package-private */
/* compiled from: signatureEnhancement.kt */
public final class SignatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$1 extends Lambda implements Function2<List<? extends FqName>, T, T> {
    final /* synthetic */ Annotations $composedAnnotation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$1(Annotations annotations) {
        super(2);
        this.$composedAnnotation = annotations;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(List<? extends FqName> list, Object obj) {
        return invoke((List<FqName>) list, obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    public final <T> T invoke(List<FqName> list, T t) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(list, "$this$ifPresent");
        Intrinsics.checkParameterIsNotNull(t, "qualifier");
        List<FqName> list2 = list;
        boolean z2 = true;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (this.$composedAnnotation.findAnnotation(it.next()) != null) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            if (!z2) {
                return t;
            }
            return null;
        }
        z2 = false;
        if (!z2) {
        }
    }
}
