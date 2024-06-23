package tb;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.open.SocialConstants;
import com.youku.live.dago.liveplayback.widget.pip.PipUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.a;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class pn0 extends fb2 {
    @NotNull
    public static final a Factory = new a(null);

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        private final ValueParameterDescriptor b(pn0 pn0, int i, TypeParameterDescriptor typeParameterDescriptor) {
            String str;
            String b = typeParameterDescriptor.getName().b();
            k21.h(b, "typeParameter.name.asString()");
            if (k21.d(b, "T")) {
                str = "instance";
            } else if (k21.d(b, ExifInterface.LONGITUDE_EAST)) {
                str = SocialConstants.PARAM_RECEIVER;
            } else {
                str = b.toLowerCase();
                k21.h(str, "(this as java.lang.String).toLowerCase()");
            }
            Annotations b2 = Annotations.Companion.b();
            og1 f = og1.f(str);
            k21.h(f, "identifier(name)");
            ib2 defaultType = typeParameterDescriptor.getDefaultType();
            k21.h(defaultType, "typeParameter.defaultType");
            SourceElement sourceElement = SourceElement.NO_SOURCE;
            k21.h(sourceElement, "NO_SOURCE");
            return new ValueParameterDescriptorImpl(pn0, null, i, b2, f, defaultType, false, false, false, null, sourceElement);
        }

        @NotNull
        public final pn0 a(@NotNull nn0 nn0, boolean z) {
            k21.i(nn0, "functionClass");
            List<TypeParameterDescriptor> declaredTypeParameters = nn0.getDeclaredTypeParameters();
            pn0 pn0 = new pn0(nn0, null, CallableMemberDescriptor.Kind.DECLARATION, z, null);
            ReceiverParameterDescriptor thisAsReceiverParameter = nn0.getThisAsReceiverParameter();
            List<? extends TypeParameterDescriptor> list = m.g();
            ArrayList arrayList = new ArrayList();
            for (T t : declaredTypeParameters) {
                if (!(t.getVariance() == Variance.IN_VARIANCE)) {
                    break;
                }
                arrayList.add(t);
            }
            Iterable<s01> iterable = CollectionsKt___CollectionsKt.E0(arrayList);
            ArrayList arrayList2 = new ArrayList(n.q(iterable, 10));
            for (s01 s01 : iterable) {
                arrayList2.add(b(pn0, s01.c(), (TypeParameterDescriptor) s01.d()));
            }
            pn0.l(null, thisAsReceiverParameter, list, arrayList2, ((TypeParameterDescriptor) k.b0(declaredTypeParameters)).getDefaultType(), Modality.ABSTRACT, g60.PUBLIC);
            pn0.t(true);
            return pn0;
        }
    }

    private pn0(DeclarationDescriptor declarationDescriptor, pn0 pn0, CallableMemberDescriptor.Kind kind, boolean z) {
        super(declarationDescriptor, pn0, Annotations.Companion.b(), il1.INVOKE, kind, SourceElement.NO_SOURCE);
        z(true);
        B(z);
        s(false);
    }

    public /* synthetic */ pn0(DeclarationDescriptor declarationDescriptor, pn0 pn0, CallableMemberDescriptor.Kind kind, boolean z, m40 m40) {
        this(declarationDescriptor, pn0, kind, z);
    }

    private final FunctionDescriptor J(List<og1> list) {
        boolean z;
        og1 og1;
        int size = getValueParameters().size() - list.size();
        boolean z2 = true;
        List<ValueParameterDescriptor> valueParameters = getValueParameters();
        k21.h(valueParameters, "valueParameters");
        ArrayList arrayList = new ArrayList(n.q(valueParameters, 10));
        for (T t : valueParameters) {
            og1 name = t.getName();
            k21.h(name, "it.name");
            int index = t.getIndex();
            int i = index - size;
            if (i >= 0 && (og1 = list.get(i)) != null) {
                name = og1;
            }
            arrayList.add(t.copy(this, name, index));
        }
        a.c m = m(TypeSubstitutor.EMPTY);
        if (!list.isEmpty()) {
            Iterator<T> it = list.iterator();
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
        }
        z2 = false;
        a.c t2 = m.m(z2).setValueParameters(arrayList).setOriginal(getOriginal());
        k21.h(t2, "newCopyBuilder(TypeSubstitutor.EMPTY)\n                .setHasSynthesizedParameterNames(parameterNames.any { it == null })\n                .setValueParameters(newValueParameters)\n                .setOriginal(original)");
        FunctionDescriptor g = super.g(t2);
        k21.f(g);
        return g;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, tb.fb2
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.impl.a f(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable og1 og1, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        k21.i(declarationDescriptor, "newOwner");
        k21.i(kind, "kind");
        k21.i(annotations, "annotations");
        k21.i(sourceElement, "source");
        return new pn0(declarationDescriptor, (pn0) functionDescriptor, kind, isSuspend());
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d  */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a
    @Nullable
    public FunctionDescriptor g(@NotNull a.c cVar) {
        boolean z;
        k21.i(cVar, PipUtils.DAGO_PIP_MODE_CONFIGURATION);
        pn0 pn0 = (pn0) super.g(cVar);
        if (pn0 == null) {
            return null;
        }
        List<ValueParameterDescriptor> valueParameters = pn0.getValueParameters();
        k21.h(valueParameters, "substituted.valueParameters");
        boolean z2 = false;
        if (!(valueParameters instanceof Collection) || !valueParameters.isEmpty()) {
            Iterator<T> it = valueParameters.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                g61 type = it.next().getType();
                k21.h(type, "it.type");
                if (rn0.c(type) != null) {
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
            if (!z2) {
                return pn0;
            }
            List<ValueParameterDescriptor> valueParameters2 = pn0.getValueParameters();
            k21.h(valueParameters2, "substituted.valueParameters");
            ArrayList arrayList = new ArrayList(n.q(valueParameters2, 10));
            Iterator<T> it2 = valueParameters2.iterator();
            while (it2.hasNext()) {
                g61 type2 = it2.next().getType();
                k21.h(type2, "it.type");
                arrayList.add(rn0.c(type2));
            }
            return pn0.J(arrayList);
        }
        z2 = true;
        if (!z2) {
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isTailrec() {
        return false;
    }
}
