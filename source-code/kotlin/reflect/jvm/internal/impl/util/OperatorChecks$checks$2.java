package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
final class OperatorChecks$checks$2 extends Lambda implements Function1<FunctionDescriptor, String> {
    public static final OperatorChecks$checks$2 INSTANCE = new OperatorChecks$checks$2();

    OperatorChecks$checks$2() {
        super(1);
    }

    private static final boolean invoke$isAny(DeclarationDescriptor declarationDescriptor) {
        return (declarationDescriptor instanceof ClassDescriptor) && b.Z((ClassDescriptor) declarationDescriptor);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004c  */
    @Nullable
    public final String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        boolean z;
        k21.i(functionDescriptor, "<this>");
        OperatorChecks operatorChecks = OperatorChecks.INSTANCE;
        DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
        k21.h(containingDeclaration, "containingDeclaration");
        boolean z2 = true;
        if (!invoke$isAny(containingDeclaration)) {
            Collection<? extends FunctionDescriptor> overriddenDescriptors = functionDescriptor.getOverriddenDescriptors();
            k21.h(overriddenDescriptors, "overriddenDescriptors");
            if (!overriddenDescriptors.isEmpty()) {
                Iterator<T> it = overriddenDescriptors.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    DeclarationDescriptor containingDeclaration2 = it.next().getContainingDeclaration();
                    k21.h(containingDeclaration2, "it.containingDeclaration");
                    if (invoke$isAny(containingDeclaration2)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    z2 = false;
                }
            }
            z = false;
            if (!z) {
            }
        }
        if (!z2) {
            return "must override ''equals()'' in Any";
        }
        return null;
    }
}
