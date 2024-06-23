package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import com.huawei.hms.opendevice.c;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.qj;
import tb.x61;
import tb.z61;

/* compiled from: Taobao */
public final class LazyJavaTypeParameterResolver implements TypeParameterResolver {
    @NotNull
    private final x61 a;
    @NotNull
    private final DeclarationDescriptor b;
    private final int c;
    @NotNull
    private final Map<JavaTypeParameter, Integer> d;
    @NotNull
    private final MemoizedFunctionToNullable<JavaTypeParameter, z61> e;

    public LazyJavaTypeParameterResolver(@NotNull x61 x61, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull JavaTypeParameterListOwner javaTypeParameterListOwner, int i) {
        k21.i(x61, c.a);
        k21.i(declarationDescriptor, "containingDeclaration");
        k21.i(javaTypeParameterListOwner, "typeParameterOwner");
        this.a = x61;
        this.b = declarationDescriptor;
        this.c = i;
        this.d = qj.d(javaTypeParameterListOwner.getTypeParameters());
        this.e = x61.e().createMemoizedFunctionWithNullableValues(new LazyJavaTypeParameterResolver$resolve$1(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver
    @Nullable
    public TypeParameterDescriptor resolveTypeParameter(@NotNull JavaTypeParameter javaTypeParameter) {
        k21.i(javaTypeParameter, "javaTypeParameter");
        z61 invoke = this.e.invoke(javaTypeParameter);
        return invoke == null ? this.a.f().resolveTypeParameter(javaTypeParameter) : invoke;
    }
}
