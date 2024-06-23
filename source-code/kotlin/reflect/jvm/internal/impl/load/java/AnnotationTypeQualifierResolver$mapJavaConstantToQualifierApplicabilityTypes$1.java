package kotlin.reflect.jvm.internal.impl.load.java;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.ae0;
import tb.k21;

/* compiled from: Taobao */
final class AnnotationTypeQualifierResolver$mapJavaConstantToQualifierApplicabilityTypes$1 extends Lambda implements Function2<ae0, AnnotationQualifierApplicabilityType, Boolean> {
    public static final AnnotationTypeQualifierResolver$mapJavaConstantToQualifierApplicabilityTypes$1 INSTANCE = new AnnotationTypeQualifierResolver$mapJavaConstantToQualifierApplicabilityTypes$1();

    AnnotationTypeQualifierResolver$mapJavaConstantToQualifierApplicabilityTypes$1() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(ae0 ae0, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        return Boolean.valueOf(invoke(ae0, annotationQualifierApplicabilityType));
    }

    public final boolean invoke(@NotNull ae0 ae0, @NotNull AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        k21.i(ae0, "<this>");
        k21.i(annotationQualifierApplicabilityType, AdvanceSetting.NETWORK_TYPE);
        return k21.d(ae0.c().d(), annotationQualifierApplicabilityType.getJavaTarget());
    }
}
