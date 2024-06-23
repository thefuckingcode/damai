package tb;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.k;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class mb extends AbstractBinaryClassAnnotationAndConstantLoader<AnnotationDescriptor, om<?>> {
    @NotNull
    private final ModuleDescriptor c;
    @NotNull
    private final NotFoundClasses d;
    @NotNull
    private final z5 e;

    /* compiled from: Taobao */
    public static final class a implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        @NotNull
        private final HashMap<og1, om<?>> a = new HashMap<>();
        final /* synthetic */ ClassDescriptor b;
        final /* synthetic */ mb c;
        final /* synthetic */ List<AnnotationDescriptor> d;
        final /* synthetic */ SourceElement e;

        /* renamed from: tb.mb$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static final class C0306a implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
            private final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor a;
            final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor b;
            final /* synthetic */ a c;
            final /* synthetic */ og1 d;
            final /* synthetic */ ArrayList<AnnotationDescriptor> e;

            C0306a(KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, a aVar, og1 og1, ArrayList<AnnotationDescriptor> arrayList) {
                this.b = annotationArgumentVisitor;
                this.c = aVar;
                this.d = og1;
                this.e = arrayList;
                this.a = annotationArgumentVisitor;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public void visit(@Nullable og1 og1, @Nullable Object obj) {
                this.a.visit(og1, obj);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            @Nullable
            public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull og1 og1, @NotNull oi oiVar) {
                k21.i(og1, "name");
                k21.i(oiVar, "classId");
                return this.a.visitAnnotation(og1, oiVar);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            @Nullable
            public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@NotNull og1 og1) {
                k21.i(og1, "name");
                return this.a.visitArray(og1);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public void visitClassLiteral(@NotNull og1 og1, @NotNull pi piVar) {
                k21.i(og1, "name");
                k21.i(piVar, "value");
                this.a.visitClassLiteral(og1, piVar);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public void visitEnd() {
                this.b.visitEnd();
                this.c.a.put(this.d, new c6((AnnotationDescriptor) k.o0(this.e)));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public void visitEnum(@NotNull og1 og1, @NotNull oi oiVar, @NotNull og1 og12) {
                k21.i(og1, "name");
                k21.i(oiVar, "enumClassId");
                k21.i(og12, "enumEntryName");
                this.a.visitEnum(og1, oiVar, og12);
            }
        }

        /* compiled from: Taobao */
        public static final class b implements KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor {
            @NotNull
            private final ArrayList<om<?>> a = new ArrayList<>();
            final /* synthetic */ a b;
            final /* synthetic */ og1 c;
            final /* synthetic */ ClassDescriptor d;

            b(a aVar, og1 og1, ClassDescriptor classDescriptor) {
                this.b = aVar;
                this.c = og1;
                this.d = classDescriptor;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
            public void visit(@Nullable Object obj) {
                this.a.add(this.b.c(this.c, obj));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
            public void visitClassLiteral(@NotNull pi piVar) {
                k21.i(piVar, "value");
                this.a.add(new n51(piVar));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
            public void visitEnd() {
                ValueParameterDescriptor b2 = c60.b(this.c, this.d);
                if (b2 != null) {
                    HashMap hashMap = this.b.a;
                    og1 og1 = this.c;
                    ConstantValueFactory constantValueFactory = ConstantValueFactory.INSTANCE;
                    List<? extends om<?>> c2 = qj.c(this.a);
                    g61 type = b2.getType();
                    k21.h(type, "parameter.type");
                    hashMap.put(og1, constantValueFactory.b(c2, type));
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
            public void visitEnum(@NotNull oi oiVar, @NotNull og1 og1) {
                k21.i(oiVar, "enumClassId");
                k21.i(og1, "enumEntryName");
                this.a.add(new ae0(oiVar, og1));
            }
        }

        a(ClassDescriptor classDescriptor, mb mbVar, List<AnnotationDescriptor> list, SourceElement sourceElement) {
            this.b = classDescriptor;
            this.c = mbVar;
            this.d = list;
            this.e = sourceElement;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final om<?> c(og1 og1, Object obj) {
            om<?> c2 = ConstantValueFactory.INSTANCE.c(obj);
            return c2 == null ? ne0.Companion.a(k21.r("Unsupported annotation argument: ", og1)) : c2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(@Nullable og1 og1, @Nullable Object obj) {
            if (og1 != null) {
                this.a.put(og1, c(og1, obj));
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull og1 og1, @NotNull oi oiVar) {
            k21.i(og1, "name");
            k21.i(oiVar, "classId");
            ArrayList arrayList = new ArrayList();
            mb mbVar = this.c;
            SourceElement sourceElement = SourceElement.NO_SOURCE;
            k21.h(sourceElement, "NO_SOURCE");
            KotlinJvmBinaryClass.AnnotationArgumentVisitor m = mbVar.m(oiVar, sourceElement, arrayList);
            k21.f(m);
            return new C0306a(m, this, og1, arrayList);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@NotNull og1 og1) {
            k21.i(og1, "name");
            return new b(this, og1, this.b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(@NotNull og1 og1, @NotNull pi piVar) {
            k21.i(og1, "name");
            k21.i(piVar, "value");
            this.a.put(og1, new n51(piVar));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnd() {
            this.d.add(new kotlin.reflect.jvm.internal.impl.descriptors.annotations.a(this.b.getDefaultType(), this.a, this.e));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(@NotNull og1 og1, @NotNull oi oiVar, @NotNull og1 og12) {
            k21.i(og1, "name");
            k21.i(oiVar, "enumClassId");
            k21.i(og12, "enumEntryName");
            this.a.put(og1, new ae0(oiVar, og12));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public mb(@NotNull ModuleDescriptor moduleDescriptor, @NotNull NotFoundClasses notFoundClasses, @NotNull StorageManager storageManager, @NotNull KotlinClassFinder kotlinClassFinder) {
        super(storageManager, kotlinClassFinder);
        k21.i(moduleDescriptor, "module");
        k21.i(notFoundClasses, "notFoundClasses");
        k21.i(storageManager, "storageManager");
        k21.i(kotlinClassFinder, "kotlinClassFinder");
        this.c = moduleDescriptor;
        this.d = notFoundClasses;
        this.e = new z5(moduleDescriptor, notFoundClasses);
    }

    private final ClassDescriptor w(oi oiVar) {
        return FindClassInModuleKt.c(this.c, oiVar, this.d);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader
    @Nullable
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor m(@NotNull oi oiVar, @NotNull SourceElement sourceElement, @NotNull List<AnnotationDescriptor> list) {
        k21.i(oiVar, "annotationClassId");
        k21.i(sourceElement, "source");
        k21.i(list, "result");
        return new a(w(oiVar), this, list, sourceElement);
    }

    /* access modifiers changed from: protected */
    @Nullable
    /* renamed from: u */
    public om<?> p(@NotNull String str, @NotNull Object obj) {
        k21.i(str, SocialConstants.PARAM_APP_DESC);
        k21.i(obj, "initializer");
        boolean z = false;
        if (StringsKt__StringsKt.Q("ZBCS", str, false, 2, null)) {
            int intValue = ((Integer) obj).intValue();
            int hashCode = str.hashCode();
            if (hashCode != 66) {
                if (hashCode != 67) {
                    if (hashCode != 83) {
                        if (hashCode == 90 && str.equals("Z")) {
                            if (intValue != 0) {
                                z = true;
                            }
                            obj = Boolean.valueOf(z);
                        }
                    } else if (str.equals(ExifInterface.LATITUDE_SOUTH)) {
                        obj = Short.valueOf((short) intValue);
                    }
                } else if (str.equals("C")) {
                    obj = Character.valueOf((char) intValue);
                }
            } else if (str.equals("B")) {
                obj = Byte.valueOf((byte) intValue);
            }
            throw new AssertionError(str);
        }
        return ConstantValueFactory.INSTANCE.c(obj);
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: v */
    public AnnotationDescriptor r(@NotNull ProtoBuf$Annotation protoBuf$Annotation, @NotNull NameResolver nameResolver) {
        k21.i(protoBuf$Annotation, "proto");
        k21.i(nameResolver, "nameResolver");
        return this.e.a(protoBuf$Annotation, nameResolver);
    }

    /* access modifiers changed from: protected */
    @Nullable
    /* renamed from: x */
    public om<?> t(@NotNull om<?> omVar) {
        om<?> aq2;
        k21.i(omVar, "constant");
        if (omVar instanceof zd) {
            aq2 = new kp2(((Number) ((zd) omVar).b()).byteValue());
        } else if (omVar instanceof qa2) {
            aq2 = new fq2(((Number) ((qa2) omVar).b()).shortValue());
        } else if (omVar instanceof z11) {
            aq2 = new xp2(((Number) ((z11) omVar).b()).intValue());
        } else if (!(omVar instanceof ka1)) {
            return omVar;
        } else {
            aq2 = new aq2(((Number) ((ka1) omVar).b()).longValue());
        }
        return aq2;
    }
}
