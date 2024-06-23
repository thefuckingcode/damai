package kotlinx.coroutines.experimental;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutinesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.intrinsics.CancellableKt;
import kotlinx.coroutines.experimental.intrinsics.UndispatchedKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JC\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\u001c\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\\\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\b2'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0010¢\u0006\u0002\b\u00112\u0006\u0010\u0012\u001a\u0002H\u000f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017\u0002\u0004\n\u0002\b\t¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/experimental/CoroutineStart;", "", "(Ljava/lang/String;I)V", "isLazy", "", "()Z", "invoke", "", "T", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/experimental/Continuation;", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)V", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: CoroutineStart.kt */
public enum CoroutineStart {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 10})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CoroutineStart.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[CoroutineStart.DEFAULT.ordinal()] = 1;
            iArr[CoroutineStart.ATOMIC.ordinal()] = 2;
            iArr[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            iArr[CoroutineStart.LAZY.ordinal()] = 4;
            int[] iArr2 = new int[CoroutineStart.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[CoroutineStart.DEFAULT.ordinal()] = 1;
            iArr2[CoroutineStart.ATOMIC.ordinal()] = 2;
            iArr2[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            iArr2[CoroutineStart.LAZY.ordinal()] = 4;
        }
    }

    public final <T> void invoke(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(function1, "block");
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            CancellableKt.startCoroutineCancellable(function1, continuation);
        } else if (i == 2) {
            CoroutinesKt.startCoroutine(function1, continuation);
        } else if (i == 3) {
            UndispatchedKt.startCoroutineUndispatched(function1, continuation);
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final <R, T> void invoke(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(function2, "block");
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        int i = WhenMappings.$EnumSwitchMapping$1[ordinal()];
        if (i == 1) {
            CancellableKt.startCoroutineCancellable(function2, r, continuation);
        } else if (i == 2) {
            CoroutinesKt.startCoroutine(function2, r, continuation);
        } else if (i == 3) {
            UndispatchedKt.startCoroutineUndispatched(function2, r, continuation);
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }
}
