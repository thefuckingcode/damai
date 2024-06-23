package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.pd1;
import tb.x61;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LazyJavaClassMemberScope$constructors$1 extends Lambda implements Function0<List<? extends ClassConstructorDescriptor>> {
    final /* synthetic */ x61 $c;
    final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaClassMemberScope$constructors$1(LazyJavaClassMemberScope lazyJavaClassMemberScope, x61 x61) {
        super(0);
        this.this$0 = lazyJavaClassMemberScope;
        this.$c = x61;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final List<? extends ClassConstructorDescriptor> invoke() {
        Collection<JavaConstructor> constructors = this.this$0.n.getConstructors();
        ArrayList arrayList = new ArrayList(constructors.size());
        for (JavaConstructor javaConstructor : constructors) {
            arrayList.add(this.this$0.y0(javaConstructor));
        }
        if (this.this$0.n.isRecord()) {
            ClassConstructorDescriptor classConstructorDescriptor = this.this$0.X();
            boolean z = false;
            String c = pd1.c(classConstructorDescriptor, false, false, 2, null);
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (k21.d(pd1.c((ClassConstructorDescriptor) it.next(), false, false, 2, null), c)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                arrayList.add(classConstructorDescriptor);
                this.$c.a().g().recordConstructor(this.this$0.n, classConstructorDescriptor);
            }
        }
        SignatureEnhancement q = this.$c.a().q();
        x61 x61 = this.$c;
        LazyJavaClassMemberScope lazyJavaClassMemberScope = this.this$0;
        boolean isEmpty = arrayList.isEmpty();
        Collection collection = arrayList;
        if (isEmpty) {
            collection = m.k(lazyJavaClassMemberScope.W());
        }
        return CollectionsKt___CollectionsKt.y0(q.e(x61, collection == 1 ? 1 : 0));
    }
}
