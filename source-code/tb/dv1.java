package tb;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class dv1 extends av1 implements PropertySetterDescriptor {
    private ValueParameterDescriptor m;
    @NotNull
    private final PropertySetterDescriptor n;

    /* JADX DEBUG: Multi-variable search result rejected for r20v0, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public dv1(@NotNull PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations, @NotNull Modality modality, @NotNull h60 h60, boolean z, boolean z2, boolean z3, @NotNull CallableMemberDescriptor.Kind kind, @Nullable PropertySetterDescriptor propertySetterDescriptor, @NotNull SourceElement sourceElement) {
        super(modality, h60, propertyDescriptor, annotations, og1.i("<set-" + propertyDescriptor.getName() + jl1.G), z, z2, z3, kind, sourceElement);
        dv1 dv1;
        dv1 dv12;
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
        if (propertySetterDescriptor != 0) {
            dv1 = this;
            dv12 = propertySetterDescriptor;
        } else {
            dv12 = this;
            dv1 = dv12;
        }
        dv1.n = dv12;
    }

    private static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 9:
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
                objArr[0] = "parameter";
                break;
            case 7:
                objArr[0] = "setterDescriptor";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        switch (i) {
            case 10:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 11:
                objArr[1] = "getValueParameters";
                break;
            case 12:
                objArr[1] = "getReturnType";
                break;
            case 13:
                objArr[1] = "getOriginal";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
        }
        switch (i) {
            case 6:
                objArr[2] = "initialize";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSetterParameter";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static ValueParameterDescriptorImpl j(@NotNull PropertySetterDescriptor propertySetterDescriptor, @NotNull g61 g61, @NotNull Annotations annotations) {
        if (propertySetterDescriptor == null) {
            a(7);
        }
        if (g61 == null) {
            a(8);
        }
        if (annotations == null) {
            a(9);
        }
        return new ValueParameterDescriptorImpl(propertySetterDescriptor, null, 0, annotations, og1.i("<set-?>"), g61, false, false, false, null, SourceElement.NO_SOURCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitPropertySetterDescriptor(this, d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    @NotNull
    public Collection<? extends PropertySetterDescriptor> getOverriddenDescriptors() {
        Collection<PropertyAccessorDescriptor> f = super.f(false);
        if (f == null) {
            a(10);
        }
        return f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public g61 getReturnType() {
        ib2 Y = DescriptorUtilsKt.g(this).Y();
        if (Y == null) {
            a(12);
        }
        return Y;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public List<ValueParameterDescriptor> getValueParameters() {
        ValueParameterDescriptor valueParameterDescriptor = this.m;
        if (valueParameterDescriptor != null) {
            List<ValueParameterDescriptor> singletonList = Collections.singletonList(valueParameterDescriptor);
            if (singletonList == null) {
                a(11);
            }
            return singletonList;
        }
        throw new IllegalStateException();
    }

    @NotNull
    /* renamed from: k */
    public PropertySetterDescriptor getOriginal() {
        PropertySetterDescriptor propertySetterDescriptor = this.n;
        if (propertySetterDescriptor == null) {
            a(13);
        }
        return propertySetterDescriptor;
    }

    public void l(@NotNull ValueParameterDescriptor valueParameterDescriptor) {
        if (valueParameterDescriptor == null) {
            a(6);
        }
        this.m = valueParameterDescriptor;
    }
}
