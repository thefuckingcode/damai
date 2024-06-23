package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.huawei.hms.opendevice.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.x;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ae2;
import tb.bj0;
import tb.dh2;
import tb.ed2;
import tb.eh2;
import tb.en0;
import tb.g61;
import tb.h61;
import tb.hv1;
import tb.ib2;
import tb.jl1;
import tb.jv1;
import tb.k21;
import tb.l60;
import tb.m40;
import tb.m60;
import tb.me0;
import tb.oi;
import tb.qg1;
import tb.rn0;
import tb.vo2;

/* compiled from: Taobao */
public final class TypeDeserializer {
    @NotNull
    private final l60 a;
    @Nullable
    private final TypeDeserializer b;
    @NotNull
    private final String c;
    @NotNull
    private final String d;
    private boolean e;
    @NotNull
    private final Function1<Integer, ClassifierDescriptor> f;
    @NotNull
    private final Function1<Integer, ClassifierDescriptor> g;
    @NotNull
    private final Map<Integer, TypeParameterDescriptor> h;

    public TypeDeserializer(@NotNull l60 l60, @Nullable TypeDeserializer typeDeserializer, @NotNull List<ProtoBuf$TypeParameter> list, @NotNull String str, @NotNull String str2, boolean z) {
        Map<Integer, TypeParameterDescriptor> map;
        k21.i(l60, c.a);
        k21.i(list, "typeParameterProtos");
        k21.i(str, "debugName");
        k21.i(str2, "containerPresentableName");
        this.a = l60;
        this.b = typeDeserializer;
        this.c = str;
        this.d = str2;
        this.e = z;
        this.f = l60.h().createMemoizedFunctionWithNullableValues(new TypeDeserializer$classifierDescriptors$1(this));
        this.g = l60.h().createMemoizedFunctionWithNullableValues(new TypeDeserializer$typeAliasDescriptors$1(this));
        if (list.isEmpty()) {
            map = x.i();
        } else {
            map = new LinkedHashMap<>();
            int i = 0;
            for (ProtoBuf$TypeParameter protoBuf$TypeParameter : list) {
                map.put(Integer.valueOf(protoBuf$TypeParameter.getId()), new DeserializedTypeParameterDescriptor(this.a, protoBuf$TypeParameter, i));
                i++;
            }
        }
        this.h = map;
    }

    /* access modifiers changed from: private */
    public final ClassifierDescriptor d(int i) {
        oi a2 = qg1.a(this.a.g(), i);
        if (a2.k()) {
            return this.a.c().b(a2);
        }
        return FindClassInModuleKt.b(this.a.c().p(), a2);
    }

    private final ib2 e(int i) {
        if (qg1.a(this.a.g(), i).k()) {
            return this.a.c().n().getReplacementTypeForLocalClassifiers();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final ClassifierDescriptor f(int i) {
        oi a2 = qg1.a(this.a.g(), i);
        if (a2.k()) {
            return null;
        }
        return FindClassInModuleKt.d(this.a.c().p(), a2);
    }

    private final ib2 g(g61 g61, g61 g612) {
        b e2 = TypeUtilsKt.e(g61);
        Annotations annotations = g61.getAnnotations();
        g61 h2 = rn0.h(g61);
        List<TypeProjection> list = CollectionsKt___CollectionsKt.M(rn0.j(g61), 1);
        ArrayList arrayList = new ArrayList(n.q(list, 10));
        for (TypeProjection typeProjection : list) {
            arrayList.add(typeProjection.getType());
        }
        return rn0.a(e2, annotations, h2, arrayList, null, g612, true).j(g61.d());
    }

    private final ib2 h(Annotations annotations, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z) {
        int size;
        int size2 = typeConstructor.getParameters().size() - list.size();
        ib2 ib2 = null;
        if (size2 == 0) {
            ib2 = i(annotations, typeConstructor, list, z);
        } else if (size2 == 1 && (size = list.size() - 1) >= 0) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            TypeConstructor typeConstructor2 = typeConstructor.getBuiltIns().W(size).getTypeConstructor();
            k21.h(typeConstructor2, "functionTypeConstructor.builtIns.getSuspendFunction(arity).typeConstructor");
            ib2 = KotlinTypeFactory.i(annotations, typeConstructor2, list, z, null, 16, null);
        }
        if (ib2 != null) {
            return ib2;
        }
        ib2 n = me0.n(k21.r("Bad suspend function in metadata with constructor: ", typeConstructor), list);
        k21.h(n, "createErrorTypeWithArguments(\n            \"Bad suspend function in metadata with constructor: $functionTypeConstructor\",\n            arguments\n        )");
        return n;
    }

    private final ib2 i(Annotations annotations, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z) {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        ib2 i = KotlinTypeFactory.i(annotations, typeConstructor, list, z, null, 16, null);
        if (!rn0.n(i)) {
            return null;
        }
        return o(i);
    }

    private static final List<ProtoBuf$Type.Argument> m(ProtoBuf$Type protoBuf$Type, TypeDeserializer typeDeserializer) {
        List<ProtoBuf$Type.Argument> argumentList = protoBuf$Type.getArgumentList();
        k21.h(argumentList, "argumentList");
        ProtoBuf$Type f2 = jv1.f(protoBuf$Type, typeDeserializer.a.j());
        List<ProtoBuf$Type.Argument> m = f2 == null ? null : m(f2, typeDeserializer);
        if (m == null) {
            m = m.g();
        }
        return CollectionsKt___CollectionsKt.k0(argumentList, m);
    }

    public static /* synthetic */ ib2 n(TypeDeserializer typeDeserializer, ProtoBuf$Type protoBuf$Type, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return typeDeserializer.l(protoBuf$Type, z);
    }

    private final ib2 o(g61 g61) {
        boolean releaseCoroutines = this.a.c().g().getReleaseCoroutines();
        TypeProjection typeProjection = (TypeProjection) k.d0(rn0.j(g61));
        en0 en0 = null;
        g61 type = typeProjection == null ? null : typeProjection.getType();
        if (type == null) {
            return null;
        }
        ClassifierDescriptor declarationDescriptor = type.c().getDeclarationDescriptor();
        en0 i = declarationDescriptor == null ? null : DescriptorUtilsKt.i(declarationDescriptor);
        boolean z = true;
        if (type.b().size() != 1 || (!eh2.a(i, true) && !eh2.a(i, false))) {
            return (ib2) g61;
        }
        g61 type2 = ((TypeProjection) k.o0(type.b())).getType();
        k21.h(type2, "continuationArgumentType.arguments.single().type");
        DeclarationDescriptor e2 = this.a.e();
        if (!(e2 instanceof CallableDescriptor)) {
            e2 = null;
        }
        CallableDescriptor callableDescriptor = (CallableDescriptor) e2;
        if (callableDescriptor != null) {
            en0 = DescriptorUtilsKt.e(callableDescriptor);
        }
        if (k21.d(en0, dh2.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            return g(g61, type2);
        }
        if (!this.e && (!releaseCoroutines || !eh2.a(i, !releaseCoroutines))) {
            z = false;
        }
        this.e = z;
        return g(g61, type2);
    }

    private final TypeProjection q(TypeParameterDescriptor typeParameterDescriptor, ProtoBuf$Type.Argument argument) {
        if (argument.getProjection() != ProtoBuf$Type.Argument.Projection.STAR) {
            hv1 hv1 = hv1.INSTANCE;
            ProtoBuf$Type.Argument.Projection projection = argument.getProjection();
            k21.h(projection, "typeArgumentProto.projection");
            Variance c2 = hv1.c(projection);
            ProtoBuf$Type l = jv1.l(argument, this.a.j());
            if (l == null) {
                return new vo2(me0.j("No type recorded"));
            }
            return new vo2(c2, p(l));
        } else if (typeParameterDescriptor == null) {
            return new ae2(this.a.c().p().getBuiltIns());
        } else {
            return new StarProjectionImpl(typeParameterDescriptor);
        }
    }

    private final TypeConstructor r(ProtoBuf$Type protoBuf$Type) {
        TypeConstructor typeConstructor;
        T t;
        TypeConstructor typeConstructor2;
        if (protoBuf$Type.hasClassName()) {
            ClassifierDescriptor invoke = this.f.invoke(Integer.valueOf(protoBuf$Type.getClassName()));
            if (invoke == null) {
                invoke = s(this, protoBuf$Type, protoBuf$Type.getClassName());
            }
            TypeConstructor typeConstructor3 = invoke.getTypeConstructor();
            k21.h(typeConstructor3, "classifierDescriptors(proto.className) ?: notFoundClass(proto.className)).typeConstructor");
            return typeConstructor3;
        } else if (protoBuf$Type.hasTypeParameter()) {
            TypeConstructor t2 = t(protoBuf$Type.getTypeParameter());
            if (t2 != null) {
                return t2;
            }
            TypeConstructor k = me0.k("Unknown type parameter " + protoBuf$Type.getTypeParameter() + ". Please try recompiling module containing \"" + this.d + jl1.QUOTE);
            k21.h(k, "createErrorTypeConstructor(\n                        \"Unknown type parameter ${proto.typeParameter}. Please try recompiling module containing \\\"$containerPresentableName\\\"\"\n                    )");
            return k;
        } else if (protoBuf$Type.hasTypeParameterName()) {
            DeclarationDescriptor e2 = this.a.e();
            String string = this.a.g().getString(protoBuf$Type.getTypeParameterName());
            Iterator<T> it = k().iterator();
            while (true) {
                typeConstructor = null;
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (k21.d(t.getName().b(), string)) {
                    break;
                }
            }
            T t3 = t;
            if (t3 != null) {
                typeConstructor = t3.getTypeConstructor();
            }
            if (typeConstructor == null) {
                typeConstructor2 = me0.k("Deserialized type parameter " + string + " in " + e2);
            } else {
                typeConstructor2 = typeConstructor;
            }
            k21.h(typeConstructor2, "{\n                val container = c.containingDeclaration\n                val name = c.nameResolver.getString(proto.typeParameterName)\n                val parameter = ownTypeParameters.find { it.name.asString() == name }\n                parameter?.typeConstructor ?: ErrorUtils.createErrorTypeConstructor(\"Deserialized type parameter $name in $container\")\n            }");
            return typeConstructor2;
        } else if (protoBuf$Type.hasTypeAliasName()) {
            ClassifierDescriptor invoke2 = this.g.invoke(Integer.valueOf(protoBuf$Type.getTypeAliasName()));
            if (invoke2 == null) {
                invoke2 = s(this, protoBuf$Type, protoBuf$Type.getTypeAliasName());
            }
            TypeConstructor typeConstructor4 = invoke2.getTypeConstructor();
            k21.h(typeConstructor4, "typeAliasDescriptors(proto.typeAliasName) ?: notFoundClass(proto.typeAliasName)).typeConstructor");
            return typeConstructor4;
        } else {
            TypeConstructor k2 = me0.k("Unknown type");
            k21.h(k2, "createErrorTypeConstructor(\"Unknown type\")");
            return k2;
        }
    }

    private static final ClassDescriptor s(TypeDeserializer typeDeserializer, ProtoBuf$Type protoBuf$Type, int i) {
        oi a2 = qg1.a(typeDeserializer.a.g(), i);
        List<Integer> list = SequencesKt___SequencesKt.C(SequencesKt___SequencesKt.v(SequencesKt__SequencesKt.h(protoBuf$Type, new TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$1(typeDeserializer)), TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2.INSTANCE));
        int i2 = SequencesKt___SequencesKt.m(SequencesKt__SequencesKt.h(a2, TypeDeserializer$typeConstructor$notFoundClass$classNestingLevel$1.INSTANCE));
        while (list.size() < i2) {
            list.add(0);
        }
        return typeDeserializer.a.c().q().d(a2, list);
    }

    private final TypeConstructor t(int i) {
        TypeParameterDescriptor typeParameterDescriptor = this.h.get(Integer.valueOf(i));
        TypeConstructor typeConstructor = typeParameterDescriptor == null ? null : typeParameterDescriptor.getTypeConstructor();
        if (typeConstructor != null) {
            return typeConstructor;
        }
        TypeDeserializer typeDeserializer = this.b;
        if (typeDeserializer == null) {
            return null;
        }
        return typeDeserializer.t(i);
    }

    public final boolean j() {
        return this.e;
    }

    @NotNull
    public final List<TypeParameterDescriptor> k() {
        return CollectionsKt___CollectionsKt.y0(this.h.values());
    }

    @NotNull
    public final ib2 l(@NotNull ProtoBuf$Type protoBuf$Type, boolean z) {
        ib2 ib2;
        ib2 ib22;
        ib2 j;
        k21.i(protoBuf$Type, "proto");
        if (protoBuf$Type.hasClassName()) {
            ib2 = e(protoBuf$Type.getClassName());
        } else {
            ib2 = protoBuf$Type.hasTypeAliasName() ? e(protoBuf$Type.getTypeAliasName()) : null;
        }
        if (ib2 != null) {
            return ib2;
        }
        TypeConstructor r = r(protoBuf$Type);
        if (me0.r(r.getDeclarationDescriptor())) {
            ib2 o = me0.o(r.toString(), r);
            k21.h(o, "createErrorTypeWithCustomConstructor(constructor.toString(), constructor)");
            return o;
        }
        m60 m60 = new m60(this.a.h(), new TypeDeserializer$simpleType$annotations$1(this, protoBuf$Type));
        List<ProtoBuf$Type.Argument> m = m(protoBuf$Type, this);
        ArrayList arrayList = new ArrayList(n.q(m, 10));
        int i = 0;
        for (T t : m) {
            int i2 = i + 1;
            if (i < 0) {
                m.p();
            }
            List<TypeParameterDescriptor> parameters = r.getParameters();
            k21.h(parameters, "constructor.parameters");
            arrayList.add(q((TypeParameterDescriptor) k.S(parameters, i), t));
            i = i2;
        }
        List<? extends TypeProjection> list = CollectionsKt___CollectionsKt.y0(arrayList);
        ClassifierDescriptor declarationDescriptor = r.getDeclarationDescriptor();
        if (!z || !(declarationDescriptor instanceof TypeAliasDescriptor)) {
            Boolean g2 = bj0.SUSPEND_TYPE.d(protoBuf$Type.getFlags());
            k21.h(g2, "SUSPEND_TYPE.get(proto.flags)");
            if (g2.booleanValue()) {
                ib22 = h(m60, r, list, protoBuf$Type.getNullable());
            } else {
                KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
                ib22 = KotlinTypeFactory.i(m60, r, list, protoBuf$Type.getNullable(), null, 16, null);
            }
        } else {
            KotlinTypeFactory kotlinTypeFactory2 = KotlinTypeFactory.INSTANCE;
            ib2 b2 = KotlinTypeFactory.b((TypeAliasDescriptor) declarationDescriptor, list);
            ib22 = b2.j(h61.b(b2) || protoBuf$Type.getNullable()).k(Annotations.Companion.a(CollectionsKt___CollectionsKt.i0(m60, b2.getAnnotations())));
        }
        ProtoBuf$Type a2 = jv1.a(protoBuf$Type, this.a.j());
        if (!(a2 == null || (j = ed2.j(ib22, l(a2, false))) == null)) {
            ib22 = j;
        }
        return protoBuf$Type.hasClassName() ? this.a.c().t().transformPlatformType(qg1.a(this.a.g(), protoBuf$Type.getClassName()), ib22) : ib22;
    }

    @NotNull
    public final g61 p(@NotNull ProtoBuf$Type protoBuf$Type) {
        k21.i(protoBuf$Type, "proto");
        if (!protoBuf$Type.hasFlexibleTypeCapabilitiesId()) {
            return l(protoBuf$Type, true);
        }
        String string = this.a.g().getString(protoBuf$Type.getFlexibleTypeCapabilitiesId());
        ib2 n = n(this, protoBuf$Type, false, 2, null);
        ProtoBuf$Type c2 = jv1.c(protoBuf$Type, this.a.j());
        k21.f(c2);
        return this.a.c().l().create(protoBuf$Type, string, n, n(this, c2, false, 2, null));
    }

    @NotNull
    public String toString() {
        String str = this.c;
        TypeDeserializer typeDeserializer = this.b;
        return k21.r(str, typeDeserializer == null ? "" : k21.r(". Child of ", typeDeserializer.c));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TypeDeserializer(l60 l60, TypeDeserializer typeDeserializer, List list, String str, String str2, boolean z, int i, m40 m40) {
        this(l60, typeDeserializer, list, str, str2, (i & 32) != 0 ? false : z);
    }
}
