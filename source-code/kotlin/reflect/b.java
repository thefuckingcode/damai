package kotlin.reflect;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.NotImplementedError;
import kotlin.collections.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* access modifiers changed from: package-private */
@ExperimentalStdlibApi
/* compiled from: Taobao */
public final class b implements TypeVariable<GenericDeclaration>, TypeImpl {
    @NotNull
    private final KTypeParameter a;

    public b(@NotNull KTypeParameter kTypeParameter) {
        k21.i(kTypeParameter, "typeParameter");
        this.a = kTypeParameter;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) obj;
            return k21.d(getName(), typeVariable.getName()) && k21.d(getGenericDeclaration(), typeVariable.getGenericDeclaration());
        }
    }

    @NotNull
    public Type[] getBounds() {
        List<KType> upperBounds = this.a.getUpperBounds();
        ArrayList arrayList = new ArrayList(n.q(upperBounds, 10));
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(TypesJVMKt.c(it.next(), true));
        }
        Object[] array = arrayList.toArray(new Type[0]);
        k21.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (Type[]) array;
    }

    @Override // java.lang.reflect.TypeVariable
    @NotNull
    public GenericDeclaration getGenericDeclaration() {
        throw new NotImplementedError("An operation is not implemented: " + ("getGenericDeclaration() is not yet supported for type variables created from KType: " + this.a));
    }

    @NotNull
    public String getName() {
        return this.a.getName();
    }

    @Override // kotlin.reflect.TypeImpl
    @NotNull
    public String getTypeName() {
        return getName();
    }

    public int hashCode() {
        return getName().hashCode() ^ getGenericDeclaration().hashCode();
    }

    @NotNull
    public String toString() {
        return getTypeName();
    }
}
