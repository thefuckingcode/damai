package tb;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.gv1;

/* compiled from: Taobao */
public final class x5 implements AnnotationAndConstantLoader<AnnotationDescriptor, om<?>> {
    @NotNull
    private final y82 a;
    @NotNull
    private final z5 b;

    /* compiled from: Taobao */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotatedCallableKind.values().length];
            iArr[AnnotatedCallableKind.PROPERTY.ordinal()] = 1;
            iArr[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 2;
            iArr[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public x5(@NotNull ModuleDescriptor moduleDescriptor, @NotNull NotFoundClasses notFoundClasses, @NotNull y82 y82) {
        k21.i(moduleDescriptor, "module");
        k21.i(notFoundClasses, "notFoundClasses");
        k21.i(y82, "protocol");
        this.a = y82;
        this.b = new z5(moduleDescriptor, notFoundClasses);
    }

    @Nullable
    /* renamed from: a */
    public om<?> loadPropertyConstant(@NotNull gv1 gv1, @NotNull ProtoBuf$Property protoBuf$Property, @NotNull g61 g61) {
        k21.i(gv1, "container");
        k21.i(protoBuf$Property, "proto");
        k21.i(g61, "expectedType");
        ProtoBuf$Annotation.Argument.Value value = (ProtoBuf$Annotation.Argument.Value) fv1.a(protoBuf$Property, this.a.b());
        if (value == null) {
            return null;
        }
        return this.b.f(g61, value, gv1.b());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<AnnotationDescriptor> loadCallableAnnotations(@NotNull gv1 gv1, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind) {
        List<ProtoBuf$Annotation> list;
        k21.i(gv1, "container");
        k21.i(messageLite, "proto");
        k21.i(annotatedCallableKind, "kind");
        if (messageLite instanceof ProtoBuf$Constructor) {
            list = (List) ((ProtoBuf$Constructor) messageLite).getExtension(this.a.c());
        } else if (messageLite instanceof ProtoBuf$Function) {
            list = (List) ((ProtoBuf$Function) messageLite).getExtension(this.a.f());
        } else if (messageLite instanceof ProtoBuf$Property) {
            int i = a.$EnumSwitchMapping$0[annotatedCallableKind.ordinal()];
            if (i == 1) {
                list = (List) ((ProtoBuf$Property) messageLite).getExtension(this.a.h());
            } else if (i == 2) {
                list = (List) ((ProtoBuf$Property) messageLite).getExtension(this.a.i());
            } else if (i == 3) {
                list = (List) ((ProtoBuf$Property) messageLite).getExtension(this.a.j());
            } else {
                throw new IllegalStateException("Unsupported callable kind with property proto".toString());
            }
        } else {
            throw new IllegalStateException(k21.r("Unknown message: ", messageLite).toString());
        }
        if (list == null) {
            list = m.g();
        }
        ArrayList arrayList = new ArrayList(n.q(list, 10));
        for (ProtoBuf$Annotation protoBuf$Annotation : list) {
            arrayList.add(this.b.a(protoBuf$Annotation, gv1.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<AnnotationDescriptor> loadClassAnnotations(@NotNull gv1.a aVar) {
        k21.i(aVar, "container");
        List<ProtoBuf$Annotation> list = (List) aVar.f().getExtension(this.a.a());
        if (list == null) {
            list = m.g();
        }
        ArrayList arrayList = new ArrayList(n.q(list, 10));
        for (ProtoBuf$Annotation protoBuf$Annotation : list) {
            arrayList.add(this.b.a(protoBuf$Annotation, aVar.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<AnnotationDescriptor> loadEnumEntryAnnotations(@NotNull gv1 gv1, @NotNull ProtoBuf$EnumEntry protoBuf$EnumEntry) {
        k21.i(gv1, "container");
        k21.i(protoBuf$EnumEntry, "proto");
        List<ProtoBuf$Annotation> list = (List) protoBuf$EnumEntry.getExtension(this.a.d());
        if (list == null) {
            list = m.g();
        }
        ArrayList arrayList = new ArrayList(n.q(list, 10));
        for (ProtoBuf$Annotation protoBuf$Annotation : list) {
            arrayList.add(this.b.a(protoBuf$Annotation, gv1.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<AnnotationDescriptor> loadExtensionReceiverParameterAnnotations(@NotNull gv1 gv1, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind) {
        k21.i(gv1, "container");
        k21.i(messageLite, "proto");
        k21.i(annotatedCallableKind, "kind");
        return m.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<AnnotationDescriptor> loadPropertyBackingFieldAnnotations(@NotNull gv1 gv1, @NotNull ProtoBuf$Property protoBuf$Property) {
        k21.i(gv1, "container");
        k21.i(protoBuf$Property, "proto");
        return m.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<AnnotationDescriptor> loadPropertyDelegateFieldAnnotations(@NotNull gv1 gv1, @NotNull ProtoBuf$Property protoBuf$Property) {
        k21.i(gv1, "container");
        k21.i(protoBuf$Property, "proto");
        return m.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<AnnotationDescriptor> loadTypeAnnotations(@NotNull ProtoBuf$Type protoBuf$Type, @NotNull NameResolver nameResolver) {
        k21.i(protoBuf$Type, "proto");
        k21.i(nameResolver, "nameResolver");
        List<ProtoBuf$Annotation> list = (List) protoBuf$Type.getExtension(this.a.k());
        if (list == null) {
            list = m.g();
        }
        ArrayList arrayList = new ArrayList(n.q(list, 10));
        for (ProtoBuf$Annotation protoBuf$Annotation : list) {
            arrayList.add(this.b.a(protoBuf$Annotation, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<AnnotationDescriptor> loadTypeParameterAnnotations(@NotNull ProtoBuf$TypeParameter protoBuf$TypeParameter, @NotNull NameResolver nameResolver) {
        k21.i(protoBuf$TypeParameter, "proto");
        k21.i(nameResolver, "nameResolver");
        List<ProtoBuf$Annotation> list = (List) protoBuf$TypeParameter.getExtension(this.a.l());
        if (list == null) {
            list = m.g();
        }
        ArrayList arrayList = new ArrayList(n.q(list, 10));
        for (ProtoBuf$Annotation protoBuf$Annotation : list) {
            arrayList.add(this.b.a(protoBuf$Annotation, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    @NotNull
    public List<AnnotationDescriptor> loadValueParameterAnnotations(@NotNull gv1 gv1, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind, int i, @NotNull ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        k21.i(gv1, "container");
        k21.i(messageLite, "callableProto");
        k21.i(annotatedCallableKind, "kind");
        k21.i(protoBuf$ValueParameter, "proto");
        List<ProtoBuf$Annotation> list = (List) protoBuf$ValueParameter.getExtension(this.a.g());
        if (list == null) {
            list = m.g();
        }
        ArrayList arrayList = new ArrayList(n.q(list, 10));
        for (ProtoBuf$Annotation protoBuf$Annotation : list) {
            arrayList.add(this.b.a(protoBuf$Annotation, gv1.b()));
        }
        return arrayList;
    }
}
