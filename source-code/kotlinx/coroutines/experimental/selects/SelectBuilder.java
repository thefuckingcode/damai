package kotlinx.coroutines.experimental.selects;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002JD\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\b\u0002\u0010\u0007\u001a\u00060\bj\u0002`\t2\u001c\u0010\n\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bH&ø\u0001\u0000¢\u0006\u0002\u0010\rJ3\u0010\u000e\u001a\u00020\u0004*\u00020\u000f2\u001c\u0010\n\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bH¦\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0010JE\u0010\u000e\u001a\u00020\u0004\"\u0004\b\u0001\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110\u00122\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013H¦\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0014JY\u0010\u000e\u001a\u00020\u0004\"\u0004\b\u0001\u0010\u0015\"\u0004\b\u0002\u0010\u0011*\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00110\u00162\u0006\u0010\u0017\u001a\u0002H\u00152\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013H¦\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0018JS\u0010\u000e\u001a\u00020\u0004\"\u0004\b\u0001\u0010\u0015\"\u0004\b\u0002\u0010\u0011*\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u0015\u0012\u0004\u0012\u0002H\u00110\u00162\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u0002\u0004\n\u0002\b\t¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/experimental/selects/SelectBuilder;", "R", "", "onTimeout", "", "time", "", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlinx/coroutines/experimental/timeunit/TimeUnit;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/experimental/Continuation;", "(JLjava/util/concurrent/TimeUnit;Lkotlin/jvm/functions/Function1;)V", "invoke", "Lkotlinx/coroutines/experimental/selects/SelectClause0;", "(Lkotlinx/coroutines/experimental/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/experimental/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/experimental/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/experimental/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/experimental/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Lkotlinx/coroutines/experimental/selects/SelectClause2;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Select.kt */
public interface SelectBuilder<R> {
    void invoke(SelectClause0 selectClause0, Function1<? super Continuation<? super R>, ? extends Object> function1);

    <Q> void invoke(SelectClause1<? extends Q> selectClause1, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2);

    <P, Q> void invoke(SelectClause2<? super P, ? extends Q> selectClause2, P p, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2);

    <P, Q> void invoke(SelectClause2<? super P, ? extends Q> selectClause2, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2);

    void onTimeout(long j, TimeUnit timeUnit, Function1<? super Continuation<? super R>, ? extends Object> function1);

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 10})
    /* compiled from: Select.kt */
    public static final class DefaultImpls {
        public static <R, P, Q> void invoke(SelectBuilder<? super R> selectBuilder, SelectClause2<? super P, ? extends Q> selectClause2, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
            Intrinsics.checkParameterIsNotNull(selectClause2, "$receiver");
            Intrinsics.checkParameterIsNotNull(function2, "block");
            selectBuilder.invoke(selectClause2, null, function2);
        }

        public static /* bridge */ /* synthetic */ void onTimeout$default(SelectBuilder selectBuilder, long j, TimeUnit timeUnit, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    timeUnit = TimeUnit.MILLISECONDS;
                }
                selectBuilder.onTimeout(j, timeUnit, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onTimeout");
        }
    }
}
