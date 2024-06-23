package tb;

import kotlin.Result;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class in {
    @SinceKotlin(version = "1.3")
    public static final <T> void a(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        k21.i(function1, "<this>");
        k21.i(continuation, "completion");
        Continuation continuation2 = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.a(function1, continuation));
        Result.a aVar = Result.Companion;
        continuation2.resumeWith(Result.m913constructorimpl(ur2.INSTANCE));
    }

    @SinceKotlin(version = "1.3")
    public static final <R, T> void b(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation) {
        k21.i(function2, "<this>");
        k21.i(continuation, "completion");
        Continuation continuation2 = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.b(function2, r, continuation));
        Result.a aVar = Result.Companion;
        continuation2.resumeWith(Result.m913constructorimpl(ur2.INSTANCE));
    }
}
