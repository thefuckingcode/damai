package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import tb.a41;
import tb.es1;
import tb.gl1;
import tb.lf1;

public final class PredefinedEnhancementInfoKt {
    private static final a41 a = new a41(NullabilityQualifier.NULLABLE, null, false, false, 8, null);
    private static final a41 b;
    private static final a41 c;
    private static final Map<String, es1> d;

    static {
        NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        b = new a41(nullabilityQualifier, null, false, false, 8, null);
        c = new a41(nullabilityQualifier, null, true, false, 8, null);
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        String h = signatureBuildingComponents.h("Object");
        String g = signatureBuildingComponents.g("Predicate");
        String g2 = signatureBuildingComponents.g("Function");
        String g3 = signatureBuildingComponents.g("Consumer");
        String g4 = signatureBuildingComponents.g("BiFunction");
        String g5 = signatureBuildingComponents.g("BiConsumer");
        String g6 = signatureBuildingComponents.g("UnaryOperator");
        String i = signatureBuildingComponents.i("stream/Stream");
        String i2 = signatureBuildingComponents.i("Optional");
        a aVar = new a();
        new a.C0273a(aVar, signatureBuildingComponents.i("Iterator")).a("forEachRemaining", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$1$1(g3));
        new a.C0273a(aVar, signatureBuildingComponents.h("Iterable")).a("spliterator", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$2$1(signatureBuildingComponents));
        a.C0273a aVar2 = new a.C0273a(aVar, signatureBuildingComponents.i("Collection"));
        aVar2.a("removeIf", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$3$1(g));
        aVar2.a(lf1.RESOURCE_STREAM, new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$3$2(i));
        aVar2.a("parallelStream", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$3$3(i));
        new a.C0273a(aVar, signatureBuildingComponents.i("List")).a("replaceAll", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$4$1(g6));
        a.C0273a aVar3 = new a.C0273a(aVar, signatureBuildingComponents.i("Map"));
        aVar3.a("forEach", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$1(g5));
        aVar3.a("putIfAbsent", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$2(h));
        aVar3.a("replace", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$3(h));
        aVar3.a("replace", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$4(h));
        aVar3.a("replaceAll", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$5(g4));
        aVar3.a("compute", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$6(h, g4));
        aVar3.a("computeIfAbsent", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$7(h, g2));
        aVar3.a("computeIfPresent", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$8(h, g4));
        aVar3.a("merge", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$9(h, g4));
        a.C0273a aVar4 = new a.C0273a(aVar, i2);
        aVar4.a(DXRecyclerLayout.LOAD_MORE_EMPTY, new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$1(i2));
        aVar4.a("of", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$2(h, i2));
        aVar4.a("ofNullable", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$3(h, i2));
        aVar4.a(gl1.TYPE_OPEN_URL_METHOD_GET, new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$4(h));
        aVar4.a("ifPresent", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$5(g3));
        new a.C0273a(aVar, signatureBuildingComponents.h("ref/Reference")).a(gl1.TYPE_OPEN_URL_METHOD_GET, new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$7$1(h));
        new a.C0273a(aVar, g).a("test", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$8$1(h));
        new a.C0273a(aVar, signatureBuildingComponents.g("BiPredicate")).a("test", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$9$1(h));
        new a.C0273a(aVar, g3).a("accept", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$10$1(h));
        new a.C0273a(aVar, g5).a("accept", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$11$1(h));
        new a.C0273a(aVar, g2).a("apply", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$12$1(h));
        new a.C0273a(aVar, g4).a("apply", new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$13$1(h));
        new a.C0273a(aVar, signatureBuildingComponents.g("Supplier")).a(gl1.TYPE_OPEN_URL_METHOD_GET, new PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$14$1(h));
        d = aVar.b();
    }

    public static final Map<String, es1> d() {
        return d;
    }
}
