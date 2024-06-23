package tb;

import java.util.List;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class u31 extends bv1 implements JavaCallableMemberDescriptor {
    private final boolean A;
    @Nullable
    private final Pair<CallableDescriptor.UserDataKey<?>, ?> B;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected u31(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull Modality modality, @NotNull h60 h60, boolean z, @NotNull og1 og1, @NotNull SourceElement sourceElement, @Nullable PropertyDescriptor propertyDescriptor, @NotNull CallableMemberDescriptor.Kind kind, boolean z2, @Nullable Pair<CallableDescriptor.UserDataKey<?>, ?> pair) {
        super(declarationDescriptor, propertyDescriptor, annotations, modality, h60, z, og1, kind, sourceElement, false, false, false, false, false, false);
        if (declarationDescriptor == null) {
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
        if (og1 == null) {
            a(4);
        }
        if (sourceElement == null) {
            a(5);
        }
        if (kind == null) {
            a(6);
        }
        this.A = z2;
        this.B = pair;
    }

    private static /* synthetic */ void a(int i) {
        String str = i != 21 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i != 21 ? 3 : 2)];
        switch (i) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case 12:
            case 18:
                objArr[0] = "source";
                break;
            case 6:
            case 16:
                objArr[0] = "kind";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 14:
                objArr[0] = "newModality";
                break;
            case 15:
                objArr[0] = "newVisibility";
                break;
            case 17:
                objArr[0] = "newName";
                break;
            case 19:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
        }
        if (i != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "create";
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            case 21:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i != 21) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @NotNull
    public static u31 v(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull Modality modality, @NotNull h60 h60, boolean z, @NotNull og1 og1, @NotNull SourceElement sourceElement, boolean z2) {
        if (declarationDescriptor == null) {
            a(7);
        }
        if (annotations == null) {
            a(8);
        }
        if (modality == null) {
            a(9);
        }
        if (h60 == null) {
            a(10);
        }
        if (og1 == null) {
            a(11);
        }
        if (sourceElement == null) {
            a(12);
        }
        return new u31(declarationDescriptor, annotations, modality, h60, z, og1, sourceElement, null, CallableMemberDescriptor.Kind.DECLARATION, z2, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    @NotNull
    public JavaCallableMemberDescriptor enhance(@Nullable g61 g61, @NotNull List<xu2> list, @NotNull g61 g612, @Nullable Pair<CallableDescriptor.UserDataKey<?>, ?> pair) {
        cv1 cv1;
        dv1 dv1;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        if (list == null) {
            a(19);
        }
        if (g612 == null) {
            a(20);
        }
        PropertyDescriptor original = getOriginal() == this ? null : getOriginal();
        u31 u31 = new u31(getContainingDeclaration(), getAnnotations(), getModality(), getVisibility(), isVar(), getName(), getSource(), original, getKind(), this.A, pair);
        cv1 k = getGetter();
        if (k != null) {
            cv1 = r15;
            cv1 cv12 = new cv1(u31, k.getAnnotations(), k.getModality(), k.getVisibility(), k.isDefault(), k.isExternal(), k.isInline(), getKind(), original == null ? null : original.getGetter(), k.getSource());
            cv1.h(k.getInitialSignatureDescriptor());
            cv1.k(g612);
        } else {
            cv1 = null;
        }
        PropertySetterDescriptor setter = getSetter();
        if (setter != null) {
            dv1 dv12 = new dv1(u31, setter.getAnnotations(), setter.getModality(), setter.getVisibility(), setter.isDefault(), setter.isExternal(), setter.isInline(), getKind(), original == null ? null : original.getSetter(), setter.getSource());
            dv12.h(dv12.getInitialSignatureDescriptor());
            dv12.l(setter.getValueParameters().get(0));
            dv1 = dv12;
        } else {
            dv1 = null;
        }
        u31.o(cv1, dv1, getBackingField(), getDelegateField());
        u31.s(p());
        NullableLazyValue<om<?>> nullableLazyValue = this.g;
        if (nullableLazyValue != null) {
            u31.e(nullableLazyValue);
        }
        u31.setOverriddenDescriptors(getOverriddenDescriptors());
        if (g61 == null) {
            receiverParameterDescriptor = null;
        } else {
            receiverParameterDescriptor = z50.f(this, g61, Annotations.Companion.b());
        }
        u31.t(g612, getTypeParameters(), getDispatchReceiverParameter(), receiverParameterDescriptor);
        return u31;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, tb.bv1, kotlin.reflect.jvm.internal.impl.descriptors.impl.b
    @Nullable
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> userDataKey) {
        Pair<CallableDescriptor.UserDataKey<?>, ?> pair = this.B;
        if (pair == null || !pair.getFirst().equals(userDataKey)) {
            return null;
        }
        return (V) this.B.getSecond();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.b
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // tb.bv1
    @NotNull
    public bv1 i(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Modality modality, @NotNull h60 h60, @Nullable PropertyDescriptor propertyDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @NotNull og1 og1, @NotNull SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            a(13);
        }
        if (modality == null) {
            a(14);
        }
        if (h60 == null) {
            a(15);
        }
        if (kind == null) {
            a(16);
        }
        if (og1 == null) {
            a(17);
        }
        if (sourceElement == null) {
            a(18);
        }
        return new u31(declarationDescriptor, getAnnotations(), modality, h60, isVar(), og1, sourceElement, propertyDescriptor, kind, this.A, this.B);
    }

    @Override // tb.bv1, kotlin.reflect.jvm.internal.impl.descriptors.impl.b, kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isConst() {
        g61 type = getType();
        return this.A && lm.a(type) && (!oo2.i(type) || b.C0(type));
    }
}
