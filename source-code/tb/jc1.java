package tb;

import java.util.Comparator;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class jc1 implements Comparator<DeclarationDescriptor> {
    public static final jc1 INSTANCE = new jc1();

    private jc1() {
    }

    @Nullable
    private static Integer b(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        int c = c(declarationDescriptor2) - c(declarationDescriptor);
        if (c != 0) {
            return Integer.valueOf(c);
        }
        if (f60.B(declarationDescriptor) && f60.B(declarationDescriptor2)) {
            return 0;
        }
        int c2 = declarationDescriptor.getName().compareTo(declarationDescriptor2.getName());
        if (c2 != 0) {
            return Integer.valueOf(c2);
        }
        return null;
    }

    private static int c(DeclarationDescriptor declarationDescriptor) {
        if (f60.B(declarationDescriptor)) {
            return 8;
        }
        if (declarationDescriptor instanceof ConstructorDescriptor) {
            return 7;
        }
        if (declarationDescriptor instanceof PropertyDescriptor) {
            return ((PropertyDescriptor) declarationDescriptor).getExtensionReceiverParameter() == null ? 6 : 5;
        }
        if (declarationDescriptor instanceof FunctionDescriptor) {
            return ((FunctionDescriptor) declarationDescriptor).getExtensionReceiverParameter() == null ? 4 : 3;
        }
        if (declarationDescriptor instanceof ClassDescriptor) {
            return 2;
        }
        return declarationDescriptor instanceof TypeAliasDescriptor ? 1 : 0;
    }

    /* renamed from: a */
    public int compare(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        Integer b = b(declarationDescriptor, declarationDescriptor2);
        if (b != null) {
            return b.intValue();
        }
        return 0;
    }
}
