package tb;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class cv1 extends av1 implements PropertyGetterDescriptor {
    private g61 m;
    @NotNull
    private final PropertyGetterDescriptor n;

    /* JADX DEBUG: Multi-variable search result rejected for r20v0, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public cv1(@NotNull PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations, @NotNull Modality modality, @NotNull h60 h60, boolean z, boolean z2, boolean z3, @NotNull CallableMemberDescriptor.Kind kind, @Nullable PropertyGetterDescriptor propertyGetterDescriptor, @NotNull SourceElement sourceElement) {
        super(modality, h60, propertyDescriptor, annotations, og1.i("<get-" + propertyDescriptor.getName() + jl1.G), z, z2, z3, kind, sourceElement);
        cv1 cv1;
        cv1 cv12;
        if (propertyDescriptor == null) {
            a(0);
        }
        if (annotations == null) {
            a(1);
        }
        if (modality == null) {
            a(2);
        }
        if (h60 == null) {
            a(3);
        }
        if (kind == null) {
            a(4);
        }
        if (sourceElement == null) {
            a(5);
        }
        if (propertyGetterDescriptor != 0) {
            cv1 = this;
            cv12 = propertyGetterDescriptor;
        } else {
            cv12 = this;
            cv1 = cv12;
        }
        cv1.n = cv12;
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 6 || i == 7 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 6 || i == 7 || i == 8) ? 2 : 3)];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "visibility";
                break;
            case 4:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        if (i == 6) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i == 7) {
            objArr[1] = "getValueParameters";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
        } else {
            objArr[1] = "getOriginal";
        }
        if (!(i == 6 || i == 7 || i == 8)) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i == 6 || i == 7 || i == 8) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitPropertyGetterDescriptor(this, d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    @NotNull
    public Collection<? extends PropertyGetterDescriptor> getOverriddenDescriptors() {
        Collection<PropertyAccessorDescriptor> f = super.f(true);
        if (f == null) {
            a(6);
        }
        return f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public g61 getReturnType() {
        return this.m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList == null) {
            a(7);
        }
        return emptyList;
    }

    @NotNull
    /* renamed from: j */
    public PropertyGetterDescriptor getOriginal() {
        PropertyGetterDescriptor propertyGetterDescriptor = this.n;
        if (propertyGetterDescriptor == null) {
            a(8);
        }
        return propertyGetterDescriptor;
    }

    public void k(g61 g61) {
        if (g61 == null) {
            g61 = getCorrespondingProperty().getType();
        }
        this.m = g61;
    }
}
