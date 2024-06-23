package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions;

/* compiled from: FunctionInvokeDescriptor.kt */
public final class FunctionInvokeDescriptor extends SimpleFunctionDescriptorImpl {
    public static final Factory Factory = new Factory(null);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public boolean isTailrec() {
        return false;
    }

    public /* synthetic */ FunctionInvokeDescriptor(DeclarationDescriptor declarationDescriptor, FunctionInvokeDescriptor functionInvokeDescriptor, CallableMemberDescriptor.Kind kind, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(declarationDescriptor, functionInvokeDescriptor, kind, z);
    }

    private FunctionInvokeDescriptor(DeclarationDescriptor declarationDescriptor, FunctionInvokeDescriptor functionInvokeDescriptor, CallableMemberDescriptor.Kind kind, boolean z) {
        super(declarationDescriptor, functionInvokeDescriptor, Annotations.Companion.getEMPTY(), OperatorNameConventions.INVOKE, kind, SourceElement.NO_SOURCE);
        setOperator(true);
        setSuspend(z);
        setHasStableParameterNames(false);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public FunctionDescriptor doSubstitute(FunctionDescriptorImpl.CopyConfiguration copyConfiguration) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(copyConfiguration, "configuration");
        FunctionInvokeDescriptor functionInvokeDescriptor = (FunctionInvokeDescriptor) super.doSubstitute(copyConfiguration);
        if (functionInvokeDescriptor == null) {
            return null;
        }
        List<ValueParameterDescriptor> valueParameters = functionInvokeDescriptor.getValueParameters();
        Intrinsics.checkExpressionValueIsNotNull(valueParameters, "substituted.valueParameters");
        List<ValueParameterDescriptor> list = valueParameters;
        boolean z2 = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                Intrinsics.checkExpressionValueIsNotNull(next, "it");
                KotlinType type = next.getType();
                Intrinsics.checkExpressionValueIsNotNull(type, "it.type");
                if (FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type) != null) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
        }
        z2 = true;
        if (z2) {
            return functionInvokeDescriptor;
        }
        List<ValueParameterDescriptor> valueParameters2 = functionInvokeDescriptor.getValueParameters();
        Intrinsics.checkExpressionValueIsNotNull(valueParameters2, "substituted.valueParameters");
        List<ValueParameterDescriptor> list2 = valueParameters2;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (T t : list2) {
            Intrinsics.checkExpressionValueIsNotNull(t, "it");
            KotlinType type2 = t.getType();
            Intrinsics.checkExpressionValueIsNotNull(type2, "it.type");
            arrayList.add(FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type2));
        }
        return functionInvokeDescriptor.replaceParameterNames(arrayList);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        Intrinsics.checkParameterIsNotNull(declarationDescriptor, "newOwner");
        Intrinsics.checkParameterIsNotNull(kind, "kind");
        Intrinsics.checkParameterIsNotNull(annotations, "annotations");
        Intrinsics.checkParameterIsNotNull(sourceElement, "source");
        return new FunctionInvokeDescriptor(declarationDescriptor, (FunctionInvokeDescriptor) functionDescriptor, kind, isSuspend());
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ae  */
    private final FunctionDescriptor replaceParameterNames(List<Name> list) {
        FunctionDescriptor doSubstitute;
        boolean z;
        Name name;
        int size = getValueParameters().size() - list.size();
        boolean z2 = true;
        List<ValueParameterDescriptor> valueParameters = getValueParameters();
        Intrinsics.checkExpressionValueIsNotNull(valueParameters, "valueParameters");
        List<ValueParameterDescriptor> list2 = valueParameters;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (T t : list2) {
            Intrinsics.checkExpressionValueIsNotNull(t, "it");
            Name name2 = t.getName();
            Intrinsics.checkExpressionValueIsNotNull(name2, "it.name");
            int index = t.getIndex();
            int i = index - size;
            if (i >= 0 && (name = list.get(i)) != null) {
                name2 = name;
            }
            arrayList.add(t.copy(this, name2, index));
        }
        ArrayList arrayList2 = arrayList;
        FunctionDescriptorImpl.CopyConfiguration newCopyBuilder = newCopyBuilder(TypeSubstitutor.EMPTY);
        List<Name> list3 = list;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator<T> it = list3.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next() == null) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            FunctionDescriptorImpl.CopyConfiguration original = newCopyBuilder.setHasSynthesizedParameterNames(z2).setValueParameters((List<ValueParameterDescriptor>) arrayList2).setOriginal((CallableMemberDescriptor) getOriginal());
            Intrinsics.checkExpressionValueIsNotNull(original, "newCopyBuilder(TypeSubst…   .setOriginal(original)");
            doSubstitute = super.doSubstitute(original);
            if (doSubstitute == null) {
                Intrinsics.throwNpe();
            }
            return doSubstitute;
        }
        z2 = false;
        FunctionDescriptorImpl.CopyConfiguration original2 = newCopyBuilder.setHasSynthesizedParameterNames(z2).setValueParameters((List<ValueParameterDescriptor>) arrayList2).setOriginal((CallableMemberDescriptor) getOriginal());
        Intrinsics.checkExpressionValueIsNotNull(original2, "newCopyBuilder(TypeSubst…   .setOriginal(original)");
        doSubstitute = super.doSubstitute(original2);
        if (doSubstitute == null) {
        }
        return doSubstitute;
    }

    /* compiled from: FunctionInvokeDescriptor.kt */
    public static final class Factory {
        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FunctionInvokeDescriptor create(FunctionClassDescriptor functionClassDescriptor, boolean z) {
            Intrinsics.checkParameterIsNotNull(functionClassDescriptor, "functionClass");
            List<TypeParameterDescriptor> declaredTypeParameters = functionClassDescriptor.getDeclaredTypeParameters();
            FunctionInvokeDescriptor functionInvokeDescriptor = new FunctionInvokeDescriptor(functionClassDescriptor, null, CallableMemberDescriptor.Kind.DECLARATION, z, null);
            ReceiverParameterDescriptor thisAsReceiverParameter = functionClassDescriptor.getThisAsReceiverParameter();
            List emptyList = CollectionsKt.emptyList();
            ArrayList arrayList = new ArrayList();
            for (T t : declaredTypeParameters) {
                if (!(t.getVariance() == Variance.IN_VARIANCE)) {
                    break;
                }
                arrayList.add(t);
            }
            Iterable<IndexedValue> withIndex = CollectionsKt.withIndex(arrayList);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(withIndex, 10));
            for (IndexedValue indexedValue : withIndex) {
                arrayList2.add(FunctionInvokeDescriptor.Factory.createValueParameter(functionInvokeDescriptor, indexedValue.getIndex(), (TypeParameterDescriptor) indexedValue.getValue()));
            }
            functionInvokeDescriptor.initialize((ReceiverParameterDescriptor) null, thisAsReceiverParameter, emptyList, (List) arrayList2, (KotlinType) ((TypeParameterDescriptor) CollectionsKt.last((List) declaredTypeParameters)).getDefaultType(), Modality.ABSTRACT, Visibilities.PUBLIC);
            functionInvokeDescriptor.setHasSynthesizedParameterNames(true);
            return functionInvokeDescriptor;
        }

        private final ValueParameterDescriptor createValueParameter(FunctionInvokeDescriptor functionInvokeDescriptor, int i, TypeParameterDescriptor typeParameterDescriptor) {
            String str;
            String asString = typeParameterDescriptor.getName().asString();
            Intrinsics.checkExpressionValueIsNotNull(asString, "typeParameter.name.asString()");
            int hashCode = asString.hashCode();
            if (hashCode != 69) {
                if (hashCode == 84 && asString.equals("T")) {
                    str = "instance";
                    Annotations empty = Annotations.Companion.getEMPTY();
                    Name identifier = Name.identifier(str);
                    Intrinsics.checkExpressionValueIsNotNull(identifier, "Name.identifier(name)");
                    SimpleType defaultType = typeParameterDescriptor.getDefaultType();
                    Intrinsics.checkExpressionValueIsNotNull(defaultType, "typeParameter.defaultType");
                    SourceElement sourceElement = SourceElement.NO_SOURCE;
                    Intrinsics.checkExpressionValueIsNotNull(sourceElement, "SourceElement.NO_SOURCE");
                    return new ValueParameterDescriptorImpl(functionInvokeDescriptor, null, i, empty, identifier, defaultType, false, false, false, null, sourceElement);
                }
            } else if (asString.equals("E")) {
                str = "receiver";
                Annotations empty2 = Annotations.Companion.getEMPTY();
                Name identifier2 = Name.identifier(str);
                Intrinsics.checkExpressionValueIsNotNull(identifier2, "Name.identifier(name)");
                SimpleType defaultType2 = typeParameterDescriptor.getDefaultType();
                Intrinsics.checkExpressionValueIsNotNull(defaultType2, "typeParameter.defaultType");
                SourceElement sourceElement2 = SourceElement.NO_SOURCE;
                Intrinsics.checkExpressionValueIsNotNull(sourceElement2, "SourceElement.NO_SOURCE");
                return new ValueParameterDescriptorImpl(functionInvokeDescriptor, null, i, empty2, identifier2, defaultType2, false, false, false, null, sourceElement2);
            }
            if (asString != null) {
                str = asString.toLowerCase();
                Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).toLowerCase()");
                Annotations empty22 = Annotations.Companion.getEMPTY();
                Name identifier22 = Name.identifier(str);
                Intrinsics.checkExpressionValueIsNotNull(identifier22, "Name.identifier(name)");
                SimpleType defaultType22 = typeParameterDescriptor.getDefaultType();
                Intrinsics.checkExpressionValueIsNotNull(defaultType22, "typeParameter.defaultType");
                SourceElement sourceElement22 = SourceElement.NO_SOURCE;
                Intrinsics.checkExpressionValueIsNotNull(sourceElement22, "SourceElement.NO_SOURCE");
                return new ValueParameterDescriptorImpl(functionInvokeDescriptor, null, i, empty22, identifier22, defaultType22, false, false, false, null, sourceElement22);
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
    }
}
