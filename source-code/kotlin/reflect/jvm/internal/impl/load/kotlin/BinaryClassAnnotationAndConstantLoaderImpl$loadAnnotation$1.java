package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.lzy.okgo.cookie.SerializableCookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;

/* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
public final class BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1 implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
    final /* synthetic */ ClassDescriptor $annotationClass;
    final /* synthetic */ List $result;
    final /* synthetic */ SourceElement $source;
    private final HashMap<Name, ConstantValue<?>> arguments = new HashMap<>();
    final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl this$0;

    BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1(BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl, ClassDescriptor classDescriptor, List list, SourceElement sourceElement) {
        this.this$0 = binaryClassAnnotationAndConstantLoaderImpl;
        this.$annotationClass = classDescriptor;
        this.$result = list;
        this.$source = sourceElement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public void visit(Name name, Object obj) {
        if (name != null) {
            this.arguments.put(name, createConstant(name, obj));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public void visitClassLiteral(Name name, ClassLiteralValue classLiteralValue) {
        Intrinsics.checkParameterIsNotNull(name, SerializableCookie.NAME);
        Intrinsics.checkParameterIsNotNull(classLiteralValue, "value");
        this.arguments.put(name, new KClassValue(classLiteralValue));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public void visitEnum(Name name, ClassId classId, Name name2) {
        Intrinsics.checkParameterIsNotNull(name, SerializableCookie.NAME);
        Intrinsics.checkParameterIsNotNull(classId, "enumClassId");
        Intrinsics.checkParameterIsNotNull(name2, "enumEntryName");
        this.arguments.put(name, new EnumValue(classId, name2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(Name name) {
        Intrinsics.checkParameterIsNotNull(name, SerializableCookie.NAME);
        return new BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1$visitArray$1(this, name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(Name name, ClassId classId) {
        Intrinsics.checkParameterIsNotNull(name, SerializableCookie.NAME);
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        ArrayList arrayList = new ArrayList();
        BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl = this.this$0;
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        Intrinsics.checkExpressionValueIsNotNull(sourceElement, "SourceElement.NO_SOURCE");
        KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation = binaryClassAnnotationAndConstantLoaderImpl.loadAnnotation(classId, sourceElement, arrayList);
        if (loadAnnotation == null) {
            Intrinsics.throwNpe();
        }
        return new BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1$visitAnnotation$1(this, loadAnnotation, name, arrayList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
    public void visitEnd() {
        this.$result.add(new AnnotationDescriptorImpl(this.$annotationClass.getDefaultType(), this.arguments, this.$source));
    }

    /* access modifiers changed from: private */
    public final ConstantValue<?> createConstant(Name name, Object obj) {
        ConstantValue<?> createConstantValue = ConstantValueFactory.INSTANCE.createConstantValue(obj);
        if (createConstantValue != null) {
            return createConstantValue;
        }
        ErrorValue.Companion companion = ErrorValue.Companion;
        return companion.create("Unsupported annotation argument: " + name);
    }
}
