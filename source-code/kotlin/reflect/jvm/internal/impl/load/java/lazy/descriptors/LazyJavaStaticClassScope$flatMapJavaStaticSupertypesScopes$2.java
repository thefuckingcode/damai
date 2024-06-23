package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

/* compiled from: LazyJavaStaticClassScope.kt */
public final class LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$2 extends DFS.AbstractNodeHandler<ClassDescriptor, Unit> {
    final /* synthetic */ Function1 $onJavaStaticScope;
    final /* synthetic */ Set $result;
    final /* synthetic */ ClassDescriptor $root;

    @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
    public void result() {
    }

    LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$2(ClassDescriptor classDescriptor, Set set, Function1 function1) {
        this.$root = classDescriptor;
        this.$result = set;
        this.$onJavaStaticScope = function1;
    }

    public boolean beforeChildren(ClassDescriptor classDescriptor) {
        Intrinsics.checkParameterIsNotNull(classDescriptor, "current");
        if (classDescriptor == this.$root) {
            return true;
        }
        MemberScope staticScope = classDescriptor.getStaticScope();
        Intrinsics.checkExpressionValueIsNotNull(staticScope, "current.staticScope");
        if (!(staticScope instanceof LazyJavaStaticScope)) {
            return true;
        }
        this.$result.addAll((Collection) this.$onJavaStaticScope.invoke(staticScope));
        return false;
    }
}
