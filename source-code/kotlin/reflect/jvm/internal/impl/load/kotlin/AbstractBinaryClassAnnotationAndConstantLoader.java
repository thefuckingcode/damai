package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.tencent.open.SocialConstants;
import com.tencent.open.SocialOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a51;
import tb.ap2;
import tb.bj0;
import tb.cd2;
import tb.cs2;
import tb.d51;
import tb.d61;
import tb.en0;
import tb.f61;
import tb.fv1;
import tb.g51;
import tb.g61;
import tb.gv1;
import tb.i51;
import tb.jv1;
import tb.k21;
import tb.og1;
import tb.oi;
import tb.qc1;
import tb.qi;
import tb.v00;

public abstract class AbstractBinaryClassAnnotationAndConstantLoader<A, C> implements AnnotationAndConstantLoader<A, C> {
    private final KotlinClassFinder a;
    private final MemoizedFunctionToNotNull<KotlinJvmBinaryClass, a<A, C>> b;

    public enum PropertyRelatedElement {
        PROPERTY,
        BACKING_FIELD,
        DELEGATE_FIELD
    }

    public static final class a<A, C> {
        private final Map<qc1, List<A>> a;
        private final Map<qc1, C> b;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Map<tb.qc1, ? extends java.util.List<? extends A>> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Map<tb.qc1, ? extends C> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Map<qc1, ? extends List<? extends A>> map, Map<qc1, ? extends C> map2) {
            k21.i(map, "memberAnnotations");
            k21.i(map2, "propertyConstants");
            this.a = map;
            this.b = map2;
        }

        public final Map<qc1, List<A>> a() {
            return this.a;
        }

        public final Map<qc1, C> b() {
            return this.b;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotatedCallableKind.values().length];
            iArr[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 1;
            iArr[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 2;
            iArr[AnnotatedCallableKind.PROPERTY.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final class c implements KotlinJvmBinaryClass.MemberVisitor {
        final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> a;
        final /* synthetic */ HashMap<qc1, List<A>> b;
        final /* synthetic */ HashMap<qc1, C> c;

        public final class a extends b implements KotlinJvmBinaryClass.MethodAnnotationVisitor {
            final /* synthetic */ c d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(c cVar, qc1 qc1) {
                super(cVar, qc1);
                k21.i(cVar, "this$0");
                k21.i(qc1, SocialOperation.GAME_SIGNATURE);
                this.d = cVar;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MethodAnnotationVisitor
            public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation(int i, oi oiVar, SourceElement sourceElement) {
                k21.i(oiVar, "classId");
                k21.i(sourceElement, "source");
                qc1 e = qc1.Companion.e(a(), i);
                List<A> list = this.d.b.get(e);
                if (list == null) {
                    list = new ArrayList<>();
                    this.d.b.put(e, list);
                }
                return this.d.a.n(oiVar, sourceElement, list);
            }
        }

        public class b implements KotlinJvmBinaryClass.AnnotationVisitor {
            private final qc1 a;
            private final ArrayList<A> b = new ArrayList<>();
            final /* synthetic */ c c;

            public b(c cVar, qc1 qc1) {
                k21.i(cVar, "this$0");
                k21.i(qc1, SocialOperation.GAME_SIGNATURE);
                this.c = cVar;
                this.a = qc1;
            }

            public final qc1 a() {
                return this.a;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
            public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(oi oiVar, SourceElement sourceElement) {
                k21.i(oiVar, "classId");
                k21.i(sourceElement, "source");
                return this.c.a.n(oiVar, sourceElement, this.b);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
            public void visitEnd() {
                if (!this.b.isEmpty()) {
                    this.c.b.put(this.a, this.b);
                }
            }
        }

        c(AbstractBinaryClassAnnotationAndConstantLoader<A, C> abstractBinaryClassAnnotationAndConstantLoader, HashMap<qc1, List<A>> hashMap, HashMap<qc1, C> hashMap2) {
            this.a = abstractBinaryClassAnnotationAndConstantLoader;
            this.b = hashMap;
            this.c = hashMap2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor
        public KotlinJvmBinaryClass.AnnotationVisitor visitField(og1 og1, String str, Object obj) {
            C p;
            k21.i(og1, "name");
            k21.i(str, SocialConstants.PARAM_APP_DESC);
            qc1.a aVar = qc1.Companion;
            String b2 = og1.b();
            k21.h(b2, "name.asString()");
            qc1 a2 = aVar.a(b2, str);
            if (!(obj == null || (p = this.a.p(str, obj)) == null)) {
                this.c.put(a2, p);
            }
            return new b(this, a2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor
        public KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod(og1 og1, String str) {
            k21.i(og1, "name");
            k21.i(str, SocialConstants.PARAM_APP_DESC);
            qc1.a aVar = qc1.Companion;
            String b2 = og1.b();
            k21.h(b2, "name.asString()");
            return new a(this, aVar.d(b2, str));
        }
    }

    public static final class d implements KotlinJvmBinaryClass.AnnotationVisitor {
        final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> a;
        final /* synthetic */ ArrayList<A> b;

        d(AbstractBinaryClassAnnotationAndConstantLoader<A, C> abstractBinaryClassAnnotationAndConstantLoader, ArrayList<A> arrayList) {
            this.a = abstractBinaryClassAnnotationAndConstantLoader;
            this.b = arrayList;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(oi oiVar, SourceElement sourceElement) {
            k21.i(oiVar, "classId");
            k21.i(sourceElement, "source");
            return this.a.n(oiVar, sourceElement, this.b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
        public void visitEnd() {
        }
    }

    public AbstractBinaryClassAnnotationAndConstantLoader(StorageManager storageManager, KotlinClassFinder kotlinClassFinder) {
        k21.i(storageManager, "storageManager");
        k21.i(kotlinClassFinder, "kotlinClassFinder");
        this.a = kotlinClassFinder;
        this.b = storageManager.createMemoizedFunction(new AbstractBinaryClassAnnotationAndConstantLoader$storage$1(this));
    }

    private final int c(gv1 gv1, MessageLite messageLite) {
        if (messageLite instanceof ProtoBuf$Function) {
            if (jv1.d((ProtoBuf$Function) messageLite)) {
                return 1;
            }
        } else if (messageLite instanceof ProtoBuf$Property) {
            if (jv1.e((ProtoBuf$Property) messageLite)) {
                return 1;
            }
        } else if (messageLite instanceof ProtoBuf$Constructor) {
            gv1.a aVar = (gv1.a) gv1;
            if (aVar.g() == ProtoBuf$Class.Kind.ENUM_CLASS) {
                return 2;
            }
            if (aVar.i()) {
                return 1;
            }
        } else {
            throw new UnsupportedOperationException(k21.r("Unsupported message: ", messageLite.getClass()));
        }
        return 0;
    }

    private final List<A> d(gv1 gv1, qc1 qc1, boolean z, boolean z2, Boolean bool, boolean z3) {
        KotlinJvmBinaryClass f = f(gv1, l(gv1, z, z2, bool, z3));
        if (f == null) {
            return m.g();
        }
        List<A> list = this.b.invoke(f).a().get(qc1);
        return list == null ? m.g() : list;
    }

    static /* synthetic */ List e(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, gv1 gv1, qc1 qc1, boolean z, boolean z2, Boolean bool, boolean z3, int i, Object obj) {
        if (obj == null) {
            return abstractBinaryClassAnnotationAndConstantLoader.d(gv1, qc1, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? false : z3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
    }

    private final KotlinJvmBinaryClass f(gv1 gv1, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (kotlinJvmBinaryClass != null) {
            return kotlinJvmBinaryClass;
        }
        if (gv1 instanceof gv1.a) {
            return s((gv1.a) gv1);
        }
        return null;
    }

    private final qc1 h(MessageLite messageLite, NameResolver nameResolver, ap2 ap2, AnnotatedCallableKind annotatedCallableKind, boolean z) {
        if (messageLite instanceof ProtoBuf$Constructor) {
            qc1.a aVar = qc1.Companion;
            d51.b b2 = i51.INSTANCE.b((ProtoBuf$Constructor) messageLite, nameResolver, ap2);
            if (b2 == null) {
                return null;
            }
            return aVar.b(b2);
        } else if (messageLite instanceof ProtoBuf$Function) {
            qc1.a aVar2 = qc1.Companion;
            d51.b e = i51.INSTANCE.e((ProtoBuf$Function) messageLite, nameResolver, ap2);
            if (e == null) {
                return null;
            }
            return aVar2.b(e);
        } else if (!(messageLite instanceof ProtoBuf$Property)) {
            return null;
        } else {
            GeneratedMessageLite.c<ProtoBuf$Property, JvmProtoBuf.JvmPropertySignature> cVar = JvmProtoBuf.propertySignature;
            k21.h(cVar, "propertySignature");
            JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) fv1.a((GeneratedMessageLite.ExtendableMessage) messageLite, cVar);
            if (jvmPropertySignature == null) {
                return null;
            }
            int i = b.$EnumSwitchMapping$0[annotatedCallableKind.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return j((ProtoBuf$Property) messageLite, nameResolver, ap2, true, true, z);
                } else if (!jvmPropertySignature.hasSetter()) {
                    return null;
                } else {
                    qc1.a aVar3 = qc1.Companion;
                    JvmProtoBuf.JvmMethodSignature setter = jvmPropertySignature.getSetter();
                    k21.h(setter, "signature.setter");
                    return aVar3.c(nameResolver, setter);
                }
            } else if (!jvmPropertySignature.hasGetter()) {
                return null;
            } else {
                qc1.a aVar4 = qc1.Companion;
                JvmProtoBuf.JvmMethodSignature getter = jvmPropertySignature.getGetter();
                k21.h(getter, "signature.getter");
                return aVar4.c(nameResolver, getter);
            }
        }
    }

    static /* synthetic */ qc1 i(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, MessageLite messageLite, NameResolver nameResolver, ap2 ap2, AnnotatedCallableKind annotatedCallableKind, boolean z, int i, Object obj) {
        if (obj == null) {
            return abstractBinaryClassAnnotationAndConstantLoader.h(messageLite, nameResolver, ap2, annotatedCallableKind, (i & 16) != 0 ? false : z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
    }

    private final qc1 j(ProtoBuf$Property protoBuf$Property, NameResolver nameResolver, ap2 ap2, boolean z, boolean z2, boolean z3) {
        GeneratedMessageLite.c<ProtoBuf$Property, JvmProtoBuf.JvmPropertySignature> cVar = JvmProtoBuf.propertySignature;
        k21.h(cVar, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) fv1.a(protoBuf$Property, cVar);
        if (jvmPropertySignature == null) {
            return null;
        }
        if (z) {
            d51.a c2 = i51.INSTANCE.c(protoBuf$Property, nameResolver, ap2, z3);
            if (c2 == null) {
                return null;
            }
            return qc1.Companion.b(c2);
        } else if (!z2 || !jvmPropertySignature.hasSyntheticMethod()) {
            return null;
        } else {
            qc1.a aVar = qc1.Companion;
            JvmProtoBuf.JvmMethodSignature syntheticMethod = jvmPropertySignature.getSyntheticMethod();
            k21.h(syntheticMethod, "signature.syntheticMethod");
            return aVar.c(nameResolver, syntheticMethod);
        }
    }

    static /* synthetic */ qc1 k(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, ProtoBuf$Property protoBuf$Property, NameResolver nameResolver, ap2 ap2, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if (obj == null) {
            return abstractBinaryClassAnnotationAndConstantLoader.j(protoBuf$Property, nameResolver, ap2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? true : z3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPropertySignature");
    }

    private final KotlinJvmBinaryClass l(gv1 gv1, boolean z, boolean z2, Boolean bool, boolean z3) {
        gv1.a h;
        if (z) {
            if (bool != null) {
                if (gv1 instanceof gv1.a) {
                    gv1.a aVar = (gv1.a) gv1;
                    if (aVar.g() == ProtoBuf$Class.Kind.INTERFACE) {
                        KotlinClassFinder kotlinClassFinder = this.a;
                        oi d2 = aVar.e().d(og1.f("DefaultImpls"));
                        k21.h(d2, "container.classId.createNestedClassId(Name.identifier(JvmAbi.DEFAULT_IMPLS_CLASS_NAME))");
                        return d61.b(kotlinClassFinder, d2);
                    }
                }
                if (bool.booleanValue() && (gv1 instanceof gv1.b)) {
                    SourceElement c2 = gv1.c();
                    g51 g51 = c2 instanceof g51 ? (g51) c2 : null;
                    a51 b2 = g51 == null ? null : g51.b();
                    if (b2 != null) {
                        KotlinClassFinder kotlinClassFinder2 = this.a;
                        String f = b2.f();
                        k21.h(f, "facadeClassName.internalName");
                        oi m = oi.m(new en0(o.E(f, v00.DIR, '.', false, 4, null)));
                        k21.h(m, "topLevel(FqName(facadeClassName.internalName.replace('/', '.')))");
                        return d61.b(kotlinClassFinder2, m);
                    }
                }
            } else {
                throw new IllegalStateException(("isConst should not be null for property (container=" + gv1 + ')').toString());
            }
        }
        if (z2 && (gv1 instanceof gv1.a)) {
            gv1.a aVar2 = (gv1.a) gv1;
            if (aVar2.g() == ProtoBuf$Class.Kind.COMPANION_OBJECT && (h = aVar2.h()) != null && (h.g() == ProtoBuf$Class.Kind.CLASS || h.g() == ProtoBuf$Class.Kind.ENUM_CLASS || (z3 && (h.g() == ProtoBuf$Class.Kind.INTERFACE || h.g() == ProtoBuf$Class.Kind.ANNOTATION_CLASS)))) {
                return s(h);
            }
        }
        if (!(gv1 instanceof gv1.b) || !(gv1.c() instanceof g51)) {
            return null;
        }
        SourceElement c3 = gv1.c();
        Objects.requireNonNull(c3, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
        g51 g512 = (g51) c3;
        KotlinJvmBinaryClass c4 = g512.c();
        return c4 == null ? d61.b(this.a, g512.a()) : c4;
    }

    private final KotlinJvmBinaryClass.AnnotationArgumentVisitor n(oi oiVar, SourceElement sourceElement, List<A> list) {
        if (cd2.INSTANCE.a().contains(oiVar)) {
            return null;
        }
        return m(oiVar, sourceElement, list);
    }

    /* access modifiers changed from: public */
    private final a<A, C> o(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        kotlinJvmBinaryClass.visitMembers(new c(this, hashMap, hashMap2), g(kotlinJvmBinaryClass));
        return new a<>(hashMap, hashMap2);
    }

    private final List<A> q(gv1 gv1, ProtoBuf$Property protoBuf$Property, PropertyRelatedElement propertyRelatedElement) {
        Boolean g = bj0.IS_CONST.d(protoBuf$Property.getFlags());
        k21.h(g, "IS_CONST.get(proto.flags)");
        boolean booleanValue = g.booleanValue();
        i51 i51 = i51.INSTANCE;
        boolean f = i51.f(protoBuf$Property);
        if (propertyRelatedElement == PropertyRelatedElement.PROPERTY) {
            qc1 k = k(this, protoBuf$Property, gv1.b(), gv1.d(), false, true, false, 40, null);
            if (k == null) {
                return m.g();
            }
            return e(this, gv1, k, true, false, Boolean.valueOf(booleanValue), f, 8, null);
        }
        qc1 k2 = k(this, protoBuf$Property, gv1.b(), gv1.d(), true, false, false, 48, null);
        if (k2 == null) {
            return m.g();
        }
        boolean z = false;
        boolean z2 = StringsKt__StringsKt.Q(k2.a(), "$delegate", false, 2, null);
        if (propertyRelatedElement == PropertyRelatedElement.DELEGATE_FIELD) {
            z = true;
        }
        if (z2 != z) {
            return m.g();
        }
        return d(gv1, k2, true, true, Boolean.valueOf(booleanValue), f);
    }

    private final KotlinJvmBinaryClass s(gv1.a aVar) {
        SourceElement c2 = aVar.c();
        f61 f61 = c2 instanceof f61 ? (f61) c2 : null;
        if (f61 == null) {
            return null;
        }
        return f61.a();
    }

    public byte[] g(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        k21.i(kotlinJvmBinaryClass, "kotlinClass");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadCallableAnnotations(gv1 gv1, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        k21.i(gv1, "container");
        k21.i(messageLite, "proto");
        k21.i(annotatedCallableKind, "kind");
        if (annotatedCallableKind == AnnotatedCallableKind.PROPERTY) {
            return q(gv1, (ProtoBuf$Property) messageLite, PropertyRelatedElement.PROPERTY);
        }
        qc1 i = i(this, messageLite, gv1.b(), gv1.d(), annotatedCallableKind, false, 16, null);
        if (i == null) {
            return m.g();
        }
        return e(this, gv1, i, false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadClassAnnotations(gv1.a aVar) {
        k21.i(aVar, "container");
        KotlinJvmBinaryClass s = s(aVar);
        if (s != null) {
            ArrayList arrayList = new ArrayList(1);
            s.loadClassAnnotations(new d(this, arrayList), g(s));
            return arrayList;
        }
        throw new IllegalStateException(k21.r("Class for loading annotations is not found: ", aVar.a()).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadEnumEntryAnnotations(gv1 gv1, ProtoBuf$EnumEntry protoBuf$EnumEntry) {
        k21.i(gv1, "container");
        k21.i(protoBuf$EnumEntry, "proto");
        qc1.a aVar = qc1.Companion;
        String string = gv1.b().getString(protoBuf$EnumEntry.getName());
        qi qiVar = qi.INSTANCE;
        String c2 = ((gv1.a) gv1).e().c();
        k21.h(c2, "container as ProtoContainer.Class).classId.asString()");
        return e(this, gv1, aVar.a(string, qi.b(c2)), false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadExtensionReceiverParameterAnnotations(gv1 gv1, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        k21.i(gv1, "container");
        k21.i(messageLite, "proto");
        k21.i(annotatedCallableKind, "kind");
        qc1 i = i(this, messageLite, gv1.b(), gv1.d(), annotatedCallableKind, false, 16, null);
        if (i != null) {
            return e(this, gv1, qc1.Companion.e(i, 0), false, false, null, false, 60, null);
        }
        return m.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadPropertyBackingFieldAnnotations(gv1 gv1, ProtoBuf$Property protoBuf$Property) {
        k21.i(gv1, "container");
        k21.i(protoBuf$Property, "proto");
        return q(gv1, protoBuf$Property, PropertyRelatedElement.BACKING_FIELD);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public C loadPropertyConstant(gv1 gv1, ProtoBuf$Property protoBuf$Property, g61 g61) {
        qc1 h;
        C c2;
        k21.i(gv1, "container");
        k21.i(protoBuf$Property, "proto");
        k21.i(g61, "expectedType");
        Boolean g = bj0.IS_CONST.d(protoBuf$Property.getFlags());
        i51 i51 = i51.INSTANCE;
        KotlinJvmBinaryClass f = f(gv1, l(gv1, true, true, g, i51.f(protoBuf$Property)));
        if (f == null || (h = h(protoBuf$Property, gv1.b(), gv1.d(), AnnotatedCallableKind.PROPERTY, f.getClassHeader().d().d(DeserializedDescriptorResolver.Companion.a()))) == null || (c2 = this.b.invoke(f).b().get(h)) == null) {
            return null;
        }
        cs2 cs2 = cs2.INSTANCE;
        return cs2.d(g61) ? t(c2) : c2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadPropertyDelegateFieldAnnotations(gv1 gv1, ProtoBuf$Property protoBuf$Property) {
        k21.i(gv1, "container");
        k21.i(protoBuf$Property, "proto");
        return q(gv1, protoBuf$Property, PropertyRelatedElement.DELEGATE_FIELD);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadTypeAnnotations(ProtoBuf$Type protoBuf$Type, NameResolver nameResolver) {
        k21.i(protoBuf$Type, "proto");
        k21.i(nameResolver, "nameResolver");
        Object extension = protoBuf$Type.getExtension(JvmProtoBuf.typeAnnotation);
        k21.h(extension, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable<ProtoBuf$Annotation> iterable = (Iterable) extension;
        ArrayList arrayList = new ArrayList(n.q(iterable, 10));
        for (ProtoBuf$Annotation protoBuf$Annotation : iterable) {
            k21.h(protoBuf$Annotation, AdvanceSetting.NETWORK_TYPE);
            arrayList.add(r(protoBuf$Annotation, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadTypeParameterAnnotations(ProtoBuf$TypeParameter protoBuf$TypeParameter, NameResolver nameResolver) {
        k21.i(protoBuf$TypeParameter, "proto");
        k21.i(nameResolver, "nameResolver");
        Object extension = protoBuf$TypeParameter.getExtension(JvmProtoBuf.typeParameterAnnotation);
        k21.h(extension, "proto.getExtension(JvmProtoBuf.typeParameterAnnotation)");
        Iterable<ProtoBuf$Annotation> iterable = (Iterable) extension;
        ArrayList arrayList = new ArrayList(n.q(iterable, 10));
        for (ProtoBuf$Annotation protoBuf$Annotation : iterable) {
            k21.h(protoBuf$Annotation, AdvanceSetting.NETWORK_TYPE);
            arrayList.add(r(protoBuf$Annotation, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadValueParameterAnnotations(gv1 gv1, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i, ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        k21.i(gv1, "container");
        k21.i(messageLite, "callableProto");
        k21.i(annotatedCallableKind, "kind");
        k21.i(protoBuf$ValueParameter, "proto");
        qc1 i2 = i(this, messageLite, gv1.b(), gv1.d(), annotatedCallableKind, false, 16, null);
        if (i2 == null) {
            return m.g();
        }
        return e(this, gv1, qc1.Companion.e(i2, i + c(gv1, messageLite)), false, false, null, false, 60, null);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract KotlinJvmBinaryClass.AnnotationArgumentVisitor m(@NotNull oi oiVar, @NotNull SourceElement sourceElement, @NotNull List<A> list);

    /* access modifiers changed from: protected */
    @Nullable
    public abstract C p(@NotNull String str, @NotNull Object obj);

    /* access modifiers changed from: protected */
    @NotNull
    public abstract A r(@NotNull ProtoBuf$Annotation protoBuf$Annotation, @NotNull NameResolver nameResolver);

    /* access modifiers changed from: protected */
    @Nullable
    public abstract C t(@NotNull C c2);
}
