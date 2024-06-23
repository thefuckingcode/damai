package kotlinx.coroutines.experimental.selects;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.jvm.functions.Function2;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003JP\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0002\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\t\u001a\u00028\u00002\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\f\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000bH&ø\u0001\u0000¢\u0006\u0002\u0010\r\u0002\u0004\n\u0002\b\t¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/experimental/selects/SelectClause2;", "P", "Q", "", "registerSelectClause2", "", "R", "select", "Lkotlinx/coroutines/experimental/selects/SelectInstance;", "param", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/experimental/Continuation;", "(Lkotlinx/coroutines/experimental/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: Select.kt */
public interface SelectClause2<P, Q> {
    <R> void registerSelectClause2(SelectInstance<? super R> selectInstance, P p, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2);
}
