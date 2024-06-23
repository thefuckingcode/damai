package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import org.jetbrains.annotations.NotNull;
import tb.i61;
import tb.ii1;

/* compiled from: Taobao */
public interface NewKotlinTypeChecker extends KotlinTypeChecker {
    @NotNull
    public static final a Companion = a.a;

    /* compiled from: Taobao */
    public static final class a {
        static final /* synthetic */ a a = new a();
        @NotNull
        private static final ii1 b = new ii1(i61.a.INSTANCE);

        private a() {
        }

        @NotNull
        public final ii1 a() {
            return b;
        }
    }

    @NotNull
    i61 getKotlinTypeRefiner();

    @NotNull
    OverridingUtil getOverridingUtil();
}
