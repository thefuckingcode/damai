package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LazyJavaClassDescriptor$declaredParameters$1 extends Lambda implements Function0<List<? extends TypeParameterDescriptor>> {
    final /* synthetic */ LazyJavaClassDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaClassDescriptor$declaredParameters$1(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        super(0);
        this.this$0 = lazyJavaClassDescriptor;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final List<? extends TypeParameterDescriptor> invoke() {
        List<JavaTypeParameter> typeParameters = this.this$0.j().getTypeParameters();
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.this$0;
        ArrayList arrayList = new ArrayList(n.q(typeParameters, 10));
        for (T t : typeParameters) {
            TypeParameterDescriptor resolveTypeParameter = lazyJavaClassDescriptor.k.f().resolveTypeParameter(t);
            if (resolveTypeParameter != null) {
                arrayList.add(resolveTypeParameter);
            } else {
                throw new AssertionError("Parameter " + ((Object) t) + " surely belongs to class " + lazyJavaClassDescriptor.j() + ", so it must be resolved");
            }
        }
        return arrayList;
    }
}
