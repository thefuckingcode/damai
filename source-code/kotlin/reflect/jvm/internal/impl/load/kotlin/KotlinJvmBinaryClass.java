package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.og1;
import tb.oi;
import tb.pi;

/* compiled from: Taobao */
public interface KotlinJvmBinaryClass {

    /* compiled from: Taobao */
    public interface AnnotationArgumentVisitor {
        void visit(@Nullable og1 og1, @Nullable Object obj);

        @Nullable
        AnnotationArgumentVisitor visitAnnotation(@NotNull og1 og1, @NotNull oi oiVar);

        @Nullable
        AnnotationArrayArgumentVisitor visitArray(@NotNull og1 og1);

        void visitClassLiteral(@NotNull og1 og1, @NotNull pi piVar);

        void visitEnd();

        void visitEnum(@NotNull og1 og1, @NotNull oi oiVar, @NotNull og1 og12);
    }

    /* compiled from: Taobao */
    public interface AnnotationArrayArgumentVisitor {
        void visit(@Nullable Object obj);

        void visitClassLiteral(@NotNull pi piVar);

        void visitEnd();

        void visitEnum(@NotNull oi oiVar, @NotNull og1 og1);
    }

    /* compiled from: Taobao */
    public interface AnnotationVisitor {
        @Nullable
        AnnotationArgumentVisitor visitAnnotation(@NotNull oi oiVar, @NotNull SourceElement sourceElement);

        void visitEnd();
    }

    /* compiled from: Taobao */
    public interface MemberVisitor {
        @Nullable
        AnnotationVisitor visitField(@NotNull og1 og1, @NotNull String str, @Nullable Object obj);

        @Nullable
        MethodAnnotationVisitor visitMethod(@NotNull og1 og1, @NotNull String str);
    }

    /* compiled from: Taobao */
    public interface MethodAnnotationVisitor extends AnnotationVisitor {
        @Nullable
        AnnotationArgumentVisitor visitParameterAnnotation(int i, @NotNull oi oiVar, @NotNull SourceElement sourceElement);
    }

    @NotNull
    KotlinClassHeader getClassHeader();

    @NotNull
    oi getClassId();

    @NotNull
    String getLocation();

    void loadClassAnnotations(@NotNull AnnotationVisitor annotationVisitor, @Nullable byte[] bArr);

    void visitMembers(@NotNull MemberVisitor memberVisitor, @Nullable byte[] bArr);
}
