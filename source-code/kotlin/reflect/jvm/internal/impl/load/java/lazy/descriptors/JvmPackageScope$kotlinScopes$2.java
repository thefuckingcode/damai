package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import tb.j42;

/* compiled from: Taobao */
final class JvmPackageScope$kotlinScopes$2 extends Lambda implements Function0<MemberScope[]> {
    final /* synthetic */ JvmPackageScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JvmPackageScope$kotlinScopes$2(JvmPackageScope jvmPackageScope) {
        super(0);
        this.this$0 = jvmPackageScope;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final MemberScope[] invoke() {
        Collection<KotlinJvmBinaryClass> values = JvmPackageScope.b(this.this$0).g().values();
        JvmPackageScope jvmPackageScope = this.this$0;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            MemberScope d = JvmPackageScope.a(jvmPackageScope).a().b().d(JvmPackageScope.b(jvmPackageScope), it.next());
            if (d != null) {
                arrayList.add(d);
            }
        }
        Object[] array = j42.b(arrayList).toArray(new MemberScope[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (MemberScope[]) array;
    }
}
