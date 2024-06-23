package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.b;
import kotlin.collections.n;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.g60;
import tb.g61;
import tb.h60;
import tb.k21;
import tb.m40;
import tb.og1;
import tb.om;

/* compiled from: Taobao */
public class ValueParameterDescriptorImpl extends b implements ValueParameterDescriptor {
    @NotNull
    public static final a Companion = new a(null);
    private final int f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    @Nullable
    private final g61 j;
    @NotNull
    private final ValueParameterDescriptor k;

    /* compiled from: Taobao */
    public static final class WithDestructuringDeclaration extends ValueParameterDescriptorImpl {
        @NotNull
        private final Lazy l;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WithDestructuringDeclaration(@NotNull CallableDescriptor callableDescriptor, @Nullable ValueParameterDescriptor valueParameterDescriptor, int i, @NotNull Annotations annotations, @NotNull og1 og1, @NotNull g61 g61, boolean z, boolean z2, boolean z3, @Nullable g61 g612, @NotNull SourceElement sourceElement, @NotNull Function0<? extends List<? extends VariableDescriptor>> function0) {
            super(callableDescriptor, valueParameterDescriptor, i, annotations, og1, g61, z, z2, z3, g612, sourceElement);
            k21.i(callableDescriptor, "containingDeclaration");
            k21.i(annotations, "annotations");
            k21.i(og1, "name");
            k21.i(g61, "outType");
            k21.i(sourceElement, "source");
            k21.i(function0, "destructuringVariables");
            this.l = b.b(function0);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
        @NotNull
        public ValueParameterDescriptor copy(@NotNull CallableDescriptor callableDescriptor, @NotNull og1 og1, int i) {
            k21.i(callableDescriptor, "newOwner");
            k21.i(og1, "newName");
            Annotations annotations = getAnnotations();
            k21.h(annotations, "annotations");
            g61 type = getType();
            k21.h(type, "type");
            boolean declaresDefaultValue = declaresDefaultValue();
            boolean isCrossinline = isCrossinline();
            boolean isNoinline = isNoinline();
            g61 varargElementType = getVarargElementType();
            SourceElement sourceElement = SourceElement.NO_SOURCE;
            k21.h(sourceElement, "NO_SOURCE");
            return new WithDestructuringDeclaration(callableDescriptor, null, i, annotations, og1, type, declaresDefaultValue, isCrossinline, isNoinline, varargElementType, sourceElement, new ValueParameterDescriptorImpl$WithDestructuringDeclaration$copy$1(this));
        }

        @NotNull
        public final List<VariableDescriptor> h() {
            return (List) this.l.getValue();
        }
    }

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @JvmStatic
        @NotNull
        public final ValueParameterDescriptorImpl a(@NotNull CallableDescriptor callableDescriptor, @Nullable ValueParameterDescriptor valueParameterDescriptor, int i, @NotNull Annotations annotations, @NotNull og1 og1, @NotNull g61 g61, boolean z, boolean z2, boolean z3, @Nullable g61 g612, @NotNull SourceElement sourceElement, @Nullable Function0<? extends List<? extends VariableDescriptor>> function0) {
            k21.i(callableDescriptor, "containingDeclaration");
            k21.i(annotations, "annotations");
            k21.i(og1, "name");
            k21.i(g61, "outType");
            k21.i(sourceElement, "source");
            if (function0 == null) {
                return new ValueParameterDescriptorImpl(callableDescriptor, valueParameterDescriptor, i, annotations, og1, g61, z, z2, z3, g612, sourceElement);
            }
            return new WithDestructuringDeclaration(callableDescriptor, valueParameterDescriptor, i, annotations, og1, g61, z, z2, z3, g612, sourceElement, function0);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ValueParameterDescriptorImpl(@NotNull CallableDescriptor callableDescriptor, @Nullable ValueParameterDescriptor valueParameterDescriptor, int i2, @NotNull Annotations annotations, @NotNull og1 og1, @NotNull g61 g61, boolean z, boolean z2, boolean z3, @Nullable g61 g612, @NotNull SourceElement sourceElement) {
        super(callableDescriptor, annotations, og1, g61, sourceElement);
        k21.i(callableDescriptor, "containingDeclaration");
        k21.i(annotations, "annotations");
        k21.i(og1, "name");
        k21.i(g61, "outType");
        k21.i(sourceElement, "source");
        this.f = i2;
        this.g = z;
        this.h = z2;
        this.i = z3;
        this.j = g612;
        this.k = valueParameterDescriptor == null ? this : valueParameterDescriptor;
    }

    @JvmStatic
    @NotNull
    public static final ValueParameterDescriptorImpl e(@NotNull CallableDescriptor callableDescriptor, @Nullable ValueParameterDescriptor valueParameterDescriptor, int i2, @NotNull Annotations annotations, @NotNull og1 og1, @NotNull g61 g61, boolean z, boolean z2, boolean z3, @Nullable g61 g612, @NotNull SourceElement sourceElement, @Nullable Function0<? extends List<? extends VariableDescriptor>> function0) {
        return Companion.a(callableDescriptor, valueParameterDescriptor, i2, annotations, og1, g61, z, z2, z3, g612, sourceElement, function0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        k21.i(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.visitValueParameterDescriptor(this, d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    @NotNull
    public ValueParameterDescriptor copy(@NotNull CallableDescriptor callableDescriptor, @NotNull og1 og1, int i2) {
        k21.i(callableDescriptor, "newOwner");
        k21.i(og1, "newName");
        Annotations annotations = getAnnotations();
        k21.h(annotations, "annotations");
        g61 type = getType();
        k21.h(type, "type");
        boolean declaresDefaultValue = declaresDefaultValue();
        boolean isCrossinline = isCrossinline();
        boolean isNoinline = isNoinline();
        g61 varargElementType = getVarargElementType();
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        k21.h(sourceElement, "NO_SOURCE");
        return new ValueParameterDescriptorImpl(callableDescriptor, null, i2, annotations, og1, type, declaresDefaultValue, isCrossinline, isNoinline, varargElementType, sourceElement);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public boolean declaresDefaultValue() {
        return this.g && ((CallableMemberDescriptor) getContainingDeclaration()).getKind().isReal();
    }

    @Nullable
    public Void f() {
        return null;
    }

    @NotNull
    /* renamed from: g */
    public ValueParameterDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        k21.i(typeSubstitutor, "substitutor");
        if (typeSubstitutor.k()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public /* bridge */ /* synthetic */ om getCompileTimeInitializer() {
        return (om) f();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public int getIndex() {
        return this.f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    @NotNull
    public Collection<ValueParameterDescriptor> getOverriddenDescriptors() {
        Collection<? extends CallableDescriptor> overriddenDescriptors = getContainingDeclaration().getOverriddenDescriptors();
        k21.h(overriddenDescriptors, "containingDeclaration.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(n.q(overriddenDescriptors, 10));
        Iterator<T> it = overriddenDescriptors.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValueParameters().get(getIndex()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    @Nullable
    public g61 getVarargElementType() {
        return this.j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
    @NotNull
    public h60 getVisibility() {
        h60 h60 = g60.LOCAL;
        k21.h(h60, "LOCAL");
        return h60;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public boolean isCrossinline() {
        return this.h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isLateInit() {
        return ValueParameterDescriptor.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public boolean isNoinline() {
        return this.i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isVar() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor, tb.w30, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ValueDescriptor
    @NotNull
    public CallableDescriptor getContainingDeclaration() {
        return (CallableDescriptor) super.getContainingDeclaration();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor, tb.w30, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, tb.v30
    @NotNull
    public ValueParameterDescriptor getOriginal() {
        ValueParameterDescriptor valueParameterDescriptor = this.k;
        return valueParameterDescriptor == this ? this : valueParameterDescriptor.getOriginal();
    }
}
