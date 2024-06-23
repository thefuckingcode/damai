package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.lzy.okgo.cookie.SerializableCookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
public final class AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 implements KotlinJvmBinaryClass.MemberVisitor {
    final /* synthetic */ HashMap $memberAnnotations;
    final /* synthetic */ HashMap $propertyConstants;
    final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader this$0;

    AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, HashMap hashMap, HashMap hashMap2) {
        this.this$0 = abstractBinaryClassAnnotationAndConstantLoader;
        this.$memberAnnotations = hashMap;
        this.$propertyConstants = hashMap2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor
    public KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod(Name name, String str) {
        Intrinsics.checkParameterIsNotNull(name, SerializableCookie.NAME);
        Intrinsics.checkParameterIsNotNull(str, "desc");
        MemberSignature.Companion companion = MemberSignature.Companion;
        String asString = name.asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "name.asString()");
        return new AnnotationVisitorForMethod(this, companion.fromMethodNameAndDesc(asString, str));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor
    public KotlinJvmBinaryClass.AnnotationVisitor visitField(Name name, String str, Object obj) {
        Object loadConstant;
        Intrinsics.checkParameterIsNotNull(name, SerializableCookie.NAME);
        Intrinsics.checkParameterIsNotNull(str, "desc");
        MemberSignature.Companion companion = MemberSignature.Companion;
        String asString = name.asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "name.asString()");
        MemberSignature fromFieldNameAndDesc = companion.fromFieldNameAndDesc(asString, str);
        if (!(obj == null || (loadConstant = this.this$0.loadConstant(str, obj)) == null)) {
            this.$propertyConstants.put(fromFieldNameAndDesc, loadConstant);
        }
        return new MemberAnnotationVisitor(this, fromFieldNameAndDesc);
    }

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public final class AnnotationVisitorForMethod extends MemberAnnotationVisitor implements KotlinJvmBinaryClass.MethodAnnotationVisitor {
        final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AnnotationVisitorForMethod(AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, MemberSignature memberSignature) {
            super(abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, memberSignature);
            Intrinsics.checkParameterIsNotNull(memberSignature, "signature");
            this.this$0 = abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MethodAnnotationVisitor
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation(int i, ClassId classId, SourceElement sourceElement) {
            Intrinsics.checkParameterIsNotNull(classId, "classId");
            Intrinsics.checkParameterIsNotNull(sourceElement, "source");
            MemberSignature fromMethodSignatureAndParameterIndex = MemberSignature.Companion.fromMethodSignatureAndParameterIndex(getSignature(), i);
            ArrayList arrayList = (List) this.this$0.$memberAnnotations.get(fromMethodSignatureAndParameterIndex);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.this$0.$memberAnnotations.put(fromMethodSignatureAndParameterIndex, arrayList);
            }
            return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationIfNotSpecial(this.this$0.this$0, classId, sourceElement, arrayList);
        }
    }

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public class MemberAnnotationVisitor implements KotlinJvmBinaryClass.AnnotationVisitor {
        private final ArrayList<A> result = new ArrayList<>();
        private final MemberSignature signature;
        final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 this$0;

        public MemberAnnotationVisitor(AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, MemberSignature memberSignature) {
            Intrinsics.checkParameterIsNotNull(memberSignature, "signature");
            this.this$0 = abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1;
            this.signature = memberSignature;
        }

        /* access modifiers changed from: protected */
        public final MemberSignature getSignature() {
            return this.signature;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId classId, SourceElement sourceElement) {
            Intrinsics.checkParameterIsNotNull(classId, "classId");
            Intrinsics.checkParameterIsNotNull(sourceElement, "source");
            return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationIfNotSpecial(this.this$0.this$0, classId, sourceElement, this.result);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
        public void visitEnd() {
            if (!this.result.isEmpty()) {
                this.this$0.$memberAnnotations.put(this.signature, this.result);
            }
        }
    }
}
