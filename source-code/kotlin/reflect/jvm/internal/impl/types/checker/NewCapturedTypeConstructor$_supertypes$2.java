package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.es2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class NewCapturedTypeConstructor$_supertypes$2 extends Lambda implements Function0<List<? extends es2>> {
    final /* synthetic */ NewCapturedTypeConstructor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NewCapturedTypeConstructor$_supertypes$2(NewCapturedTypeConstructor newCapturedTypeConstructor) {
        super(0);
        this.this$0 = newCapturedTypeConstructor;
    }

    /* Return type fixed from 'java.util.List<tb.es2>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final List<? extends es2> invoke() {
        Function0 function0 = this.this$0.b;
        if (function0 == null) {
            return null;
        }
        return (List) function0.invoke();
    }
}
