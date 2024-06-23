package kotlin.reflect.full;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\u0010\u0000\u001a$\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00040\u00012\u000e\u0010\u0005\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/KType;", "kotlin.jvm.PlatformType", "", "current", "getNeighbors"}, k = 3, mv = {1, 1, 16})
/* compiled from: KClasses.kt */
final class KClasses$allSupertypes$1<N> implements DFS.Neighbors<KType> {
    public static final KClasses$allSupertypes$1 INSTANCE = new KClasses$allSupertypes$1();

    KClasses$allSupertypes$1() {
    }

    public final Iterable<KType> getNeighbors(KType kType) {
        KClassifier classifier = kType.getClassifier();
        if (!(classifier instanceof KClass)) {
            classifier = null;
        }
        KClass kClass = (KClass) classifier;
        if (kClass != null) {
            List<KType> supertypes = kClass.getSupertypes();
            if (kType.getArguments().isEmpty()) {
                return supertypes;
            }
            if (kType != null) {
                TypeSubstitutor create = TypeSubstitutor.create(((KTypeImpl) kType).getType());
                List<KType> list = supertypes;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (T t : list) {
                    if (t != null) {
                        KotlinType substitute = create.substitute(t.getType(), Variance.INVARIANT);
                        if (substitute != null) {
                            Intrinsics.checkExpressionValueIsNotNull(substitute, "substitutor.substitute((…: $supertype ($current)\")");
                            arrayList.add(new KTypeImpl(substitute, KClasses$allSupertypes$1$1$1$1.INSTANCE));
                        } else {
                            throw new KotlinReflectionInternalError("Type substitution failed: " + ((Object) t) + " (" + kType + ')');
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                    }
                }
                return arrayList;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
        }
        throw new KotlinReflectionInternalError("Supertype not a class: " + kType);
    }
}
