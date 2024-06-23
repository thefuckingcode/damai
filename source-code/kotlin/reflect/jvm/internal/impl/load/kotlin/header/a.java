package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.e51;
import tb.en0;
import tb.og1;
import tb.oi;
import tb.pi;
import tb.u41;
import tb.y41;

/* compiled from: Taobao */
public class a implements KotlinJvmBinaryClass.AnnotationVisitor {
    private static final boolean j = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
    private static final Map<oi, KotlinClassHeader.Kind> k;
    private int[] a = null;
    private y41 b = null;
    private String c = null;
    private int d = 0;
    private String e = null;
    private String[] f = null;
    private String[] g = null;
    private String[] h = null;
    private KotlinClassHeader.Kind i = null;

    /* compiled from: Taobao */
    private static abstract class b implements KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor {
        private final List<String> a = new ArrayList();

        private static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "enumEntryName";
            } else if (i != 2) {
                objArr[0] = "enumClassId";
            } else {
                objArr[0] = "classLiteralValue";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            if (i != 2) {
                objArr[2] = "visitEnum";
            } else {
                objArr[2] = "visitClassLiteral";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* access modifiers changed from: protected */
        public abstract void b(@NotNull String[] strArr);

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visit(@Nullable Object obj) {
            if (obj instanceof String) {
                this.a.add((String) obj);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitClassLiteral(@NotNull pi piVar) {
            if (piVar == null) {
                a(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitEnd() {
            b((String[]) this.a.toArray(new String[0]));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitEnum(@NotNull oi oiVar, @NotNull og1 og1) {
            if (oiVar == null) {
                a(0);
            }
            if (og1 == null) {
                a(1);
            }
        }
    }

    /* compiled from: Taobao */
    private class c implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {

        /* access modifiers changed from: package-private */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.header.a$c$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class C0277a extends b {
            C0277a() {
            }

            private static /* synthetic */ void a(int i) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"));
            }

            /* access modifiers changed from: protected */
            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.a.b
            public void b(@NotNull String[] strArr) {
                if (strArr == null) {
                    a(0);
                }
                a.this.f = strArr;
            }
        }

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class b extends b {
            b() {
            }

            private static /* synthetic */ void a(int i) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd"));
            }

            /* access modifiers changed from: protected */
            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.a.b
            public void b(@NotNull String[] strArr) {
                if (strArr == null) {
                    a(0);
                }
                a.this.g = strArr;
            }
        }

        private c() {
        }

        private static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "classLiteralValue";
            } else if (i == 7) {
                objArr[0] = "classId";
            } else if (i == 4) {
                objArr[0] = "enumClassId";
            } else if (i != 5) {
                objArr[0] = "name";
            } else {
                objArr[0] = "enumEntryName";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            switch (i) {
                case 2:
                    objArr[2] = "visitArray";
                    break;
                case 3:
                case 4:
                case 5:
                    objArr[2] = "visitEnum";
                    break;
                case 6:
                case 7:
                    objArr[2] = "visitAnnotation";
                    break;
                default:
                    objArr[2] = "visitClassLiteral";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor b() {
            return new C0277a();
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor c() {
            return new b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(@Nullable og1 og1, @Nullable Object obj) {
            if (og1 != null) {
                String b2 = og1.b();
                if ("k".equals(b2)) {
                    if (obj instanceof Integer) {
                        a.this.i = KotlinClassHeader.Kind.getById(((Integer) obj).intValue());
                    }
                } else if ("mv".equals(b2)) {
                    if (obj instanceof int[]) {
                        a.this.a = (int[]) obj;
                    }
                } else if ("bv".equals(b2)) {
                    if (obj instanceof int[]) {
                        a.this.b = new y41((int[]) obj);
                    }
                } else if ("xs".equals(b2)) {
                    if (obj instanceof String) {
                        a.this.c = (String) obj;
                    }
                } else if ("xi".equals(b2)) {
                    if (obj instanceof Integer) {
                        a.this.d = ((Integer) obj).intValue();
                    }
                } else if (IRequestConst.PN.equals(b2) && (obj instanceof String)) {
                    a.this.e = (String) obj;
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull og1 og1, @NotNull oi oiVar) {
            if (og1 == null) {
                a(6);
            }
            if (oiVar != null) {
                return null;
            }
            a(7);
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@NotNull og1 og1) {
            if (og1 == null) {
                a(2);
            }
            String b2 = og1.b();
            if ("d1".equals(b2)) {
                return b();
            }
            if ("d2".equals(b2)) {
                return c();
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(@NotNull og1 og1, @NotNull pi piVar) {
            if (og1 == null) {
                a(0);
            }
            if (piVar == null) {
                a(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnd() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(@NotNull og1 og1, @NotNull oi oiVar, @NotNull og1 og12) {
            if (og1 == null) {
                a(3);
            }
            if (oiVar == null) {
                a(4);
            }
            if (og12 == null) {
                a(5);
            }
        }
    }

    /* compiled from: Taobao */
    private class d implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {

        /* access modifiers changed from: package-private */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.header.a$d$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class C0278a extends b {
            C0278a() {
            }

            private static /* synthetic */ void a(int i) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd"));
            }

            /* access modifiers changed from: protected */
            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.a.b
            public void b(@NotNull String[] strArr) {
                if (strArr == null) {
                    a(0);
                }
                a.this.f = strArr;
            }
        }

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class b extends b {
            b() {
            }

            private static /* synthetic */ void a(int i) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd"));
            }

            /* access modifiers changed from: protected */
            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.a.b
            public void b(@NotNull String[] strArr) {
                if (strArr == null) {
                    a(0);
                }
                a.this.g = strArr;
            }
        }

        private d() {
        }

        private static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "classLiteralValue";
            } else if (i == 7) {
                objArr[0] = "classId";
            } else if (i == 4) {
                objArr[0] = "enumClassId";
            } else if (i != 5) {
                objArr[0] = "name";
            } else {
                objArr[0] = "enumEntryName";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            switch (i) {
                case 2:
                    objArr[2] = "visitArray";
                    break;
                case 3:
                case 4:
                case 5:
                    objArr[2] = "visitEnum";
                    break;
                case 6:
                case 7:
                    objArr[2] = "visitAnnotation";
                    break;
                default:
                    objArr[2] = "visitClassLiteral";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor b() {
            return new C0278a();
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor c() {
            return new b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(@Nullable og1 og1, @Nullable Object obj) {
            if (og1 != null) {
                String b2 = og1.b();
                if ("version".equals(b2)) {
                    if (obj instanceof int[]) {
                        int[] iArr = (int[]) obj;
                        a.this.a = iArr;
                        if (a.this.b == null) {
                            a.this.b = new y41(iArr);
                        }
                    }
                } else if ("multifileClassName".equals(b2)) {
                    a.this.c = obj instanceof String ? (String) obj : null;
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull og1 og1, @NotNull oi oiVar) {
            if (og1 == null) {
                a(6);
            }
            if (oiVar != null) {
                return null;
            }
            a(7);
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@NotNull og1 og1) {
            if (og1 == null) {
                a(2);
            }
            String b2 = og1.b();
            if ("data".equals(b2) || "filePartClassNames".equals(b2)) {
                return b();
            }
            if ("strings".equals(b2)) {
                return c();
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(@NotNull og1 og1, @NotNull pi piVar) {
            if (og1 == null) {
                a(0);
            }
            if (piVar == null) {
                a(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnd() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(@NotNull og1 og1, @NotNull oi oiVar, @NotNull og1 og12) {
            if (og1 == null) {
                a(3);
            }
            if (oiVar == null) {
                a(4);
            }
            if (og12 == null) {
                a(5);
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        k = hashMap;
        hashMap.put(oi.m(new en0("kotlin.jvm.internal.KotlinClass")), KotlinClassHeader.Kind.CLASS);
        hashMap.put(oi.m(new en0("kotlin.jvm.internal.KotlinFileFacade")), KotlinClassHeader.Kind.FILE_FACADE);
        hashMap.put(oi.m(new en0("kotlin.jvm.internal.KotlinMultifileClass")), KotlinClassHeader.Kind.MULTIFILE_CLASS);
        hashMap.put(oi.m(new en0("kotlin.jvm.internal.KotlinMultifileClassPart")), KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
        hashMap.put(oi.m(new en0("kotlin.jvm.internal.KotlinSyntheticClass")), KotlinClassHeader.Kind.SYNTHETIC_CLASS);
    }

    private static /* synthetic */ void a(int i2) {
        Object[] objArr = new Object[3];
        if (i2 != 1) {
            objArr[0] = "classId";
        } else {
            objArr[0] = "source";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        objArr[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    private boolean l() {
        KotlinClassHeader.Kind kind = this.i;
        return kind == KotlinClassHeader.Kind.CLASS || kind == KotlinClassHeader.Kind.FILE_FACADE || kind == KotlinClassHeader.Kind.MULTIFILE_CLASS_PART;
    }

    @Nullable
    public KotlinClassHeader k() {
        if (this.i == null || this.a == null) {
            return null;
        }
        e51 e51 = new e51(this.a, (this.d & 8) != 0);
        if (!e51.h()) {
            this.h = this.f;
            this.f = null;
        } else if (l() && this.f == null) {
            return null;
        }
        KotlinClassHeader.Kind kind = this.i;
        y41 y41 = this.b;
        if (y41 == null) {
            y41 = y41.INSTANCE;
        }
        return new KotlinClassHeader(kind, e51, y41, this.f, this.h, this.g, this.c, this.d, this.e);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    @Nullable
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull oi oiVar, @NotNull SourceElement sourceElement) {
        KotlinClassHeader.Kind kind;
        if (oiVar == null) {
            a(0);
        }
        if (sourceElement == null) {
            a(1);
        }
        if (oiVar.b().equals(u41.METADATA_FQ_NAME)) {
            return new c();
        }
        if (j || this.i != null || (kind = k.get(oiVar)) == null) {
            return null;
        }
        this.i = kind;
        return new d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    public void visitEnd() {
    }
}
