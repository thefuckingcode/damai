package kotlin.text;

import com.taobao.weex.ui.component.AbstractEditComponent;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public /* synthetic */ class Regex$findAll$2 extends FunctionReferenceImpl implements Function1<MatchResult, MatchResult> {
    public static final Regex$findAll$2 INSTANCE = new Regex$findAll$2();

    Regex$findAll$2() {
        super(1, MatchResult.class, AbstractEditComponent.ReturnTypes.NEXT, "next()Lkotlin/text/MatchResult;", 0);
    }

    @Nullable
    public final MatchResult invoke(@NotNull MatchResult matchResult) {
        k21.i(matchResult, "p0");
        return matchResult.next();
    }
}
