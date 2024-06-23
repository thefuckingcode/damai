package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
final class PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$5 extends Lambda implements Function1<a.C0273a.C0274a, ur2> {
    final /* synthetic */ String $JFBiFunction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$5(String str) {
        super(1);
        this.$JFBiFunction = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(a.C0273a.C0274a aVar) {
        invoke(aVar);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull a.C0273a.C0274a aVar) {
        k21.i(aVar, "<this>");
        aVar.c(this.$JFBiFunction, PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.b);
    }
}
