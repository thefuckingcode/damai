package kotlinx.coroutines.experimental;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004\"\b\u0012\u0004\u0012\u0002H\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a%\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0004\"\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\fH@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u001b\u0010\u0007\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\n0\fH@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0002\u0004\n\u0002\b\t¨\u0006\u000e"}, d2 = {"awaitAll", "", "T", "deferreds", "", "Lkotlinx/coroutines/experimental/Deferred;", "([Lkotlinx/coroutines/experimental/Deferred;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "joinAll", "", "jobs", "Lkotlinx/coroutines/experimental/Job;", "([Lkotlinx/coroutines/experimental/Job;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/Collection;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 10})
/* compiled from: Await.kt */
public final class AwaitKt {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    public static final <T> Object awaitAll(Deferred<? extends T>[] deferredArr, Continuation<? super List<? extends T>> continuation) {
        AwaitKt$awaitAll$1 awaitKt$awaitAll$1;
        int label;
        if (continuation instanceof AwaitKt$awaitAll$1) {
            awaitKt$awaitAll$1 = (AwaitKt$awaitAll$1) continuation;
            if ((awaitKt$awaitAll$1.getLabel() & Integer.MIN_VALUE) != 0) {
                awaitKt$awaitAll$1.setLabel(awaitKt$awaitAll$1.getLabel() - Integer.MIN_VALUE);
                Object obj = awaitKt$awaitAll$1.data;
                Throwable th = awaitKt$awaitAll$1.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = awaitKt$awaitAll$1.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        Deferred[] deferredArr2 = (Deferred[]) awaitKt$awaitAll$1.L$0;
                        if (th != null) {
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th == null) {
                    if (deferredArr.length == 0) {
                        return CollectionsKt.emptyList();
                    }
                    AwaitAll awaitAll = new AwaitAll(deferredArr);
                    awaitKt$awaitAll$1.L$0 = deferredArr;
                    awaitKt$awaitAll$1.setLabel(1);
                    obj = awaitAll.await(awaitKt$awaitAll$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    throw th;
                }
                return (List) obj;
            }
        }
        awaitKt$awaitAll$1 = new AwaitKt$awaitAll$1(continuation);
        Object obj2 = awaitKt$awaitAll$1.data;
        Throwable th2 = awaitKt$awaitAll$1.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = awaitKt$awaitAll$1.getLabel();
        if (label == 0) {
        }
        return (List) obj2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    public static final <T> Object awaitAll(Collection<? extends Deferred<? extends T>> collection, Continuation<? super List<? extends T>> continuation) {
        AwaitKt$awaitAll$2 awaitKt$awaitAll$2;
        int label;
        if (continuation instanceof AwaitKt$awaitAll$2) {
            awaitKt$awaitAll$2 = (AwaitKt$awaitAll$2) continuation;
            if ((awaitKt$awaitAll$2.getLabel() & Integer.MIN_VALUE) != 0) {
                awaitKt$awaitAll$2.setLabel(awaitKt$awaitAll$2.getLabel() - Integer.MIN_VALUE);
                Object obj = awaitKt$awaitAll$2.data;
                Throwable th = awaitKt$awaitAll$2.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = awaitKt$awaitAll$2.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        Collection collection2 = (Collection) awaitKt$awaitAll$2.L$0;
                        if (th != null) {
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th != null) {
                    throw th;
                } else if (collection.isEmpty()) {
                    return CollectionsKt.emptyList();
                } else {
                    if (collection != null) {
                        Object[] array = collection.toArray(new Deferred[0]);
                        if (array != null) {
                            AwaitAll awaitAll = new AwaitAll((Deferred[]) array);
                            awaitKt$awaitAll$2.L$0 = collection;
                            awaitKt$awaitAll$2.setLabel(1);
                            obj = awaitAll.await(awaitKt$awaitAll$2);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
                    }
                }
                return (List) obj;
            }
        }
        awaitKt$awaitAll$2 = new AwaitKt$awaitAll$2(continuation);
        Object obj2 = awaitKt$awaitAll$2.data;
        Throwable th2 = awaitKt$awaitAll$2.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = awaitKt$awaitAll$2.getLabel();
        if (label == 0) {
        }
        return (List) obj2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    public static final Object joinAll(Job[] jobArr, Continuation<? super Unit> continuation) {
        AwaitKt$joinAll$1 awaitKt$joinAll$1;
        int label;
        Job[] jobArr2;
        int i;
        int i2;
        Object obj;
        AwaitKt$joinAll$1 awaitKt$joinAll$12;
        Job[] jobArr3;
        if (continuation instanceof AwaitKt$joinAll$1) {
            awaitKt$joinAll$1 = (AwaitKt$joinAll$1) continuation;
            if ((awaitKt$joinAll$1.getLabel() & Integer.MIN_VALUE) != 0) {
                awaitKt$joinAll$1.setLabel(awaitKt$joinAll$1.getLabel() - Integer.MIN_VALUE);
                Object obj2 = awaitKt$joinAll$1.data;
                Throwable th = awaitKt$joinAll$1.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = awaitKt$joinAll$1.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        Job job = (Job) awaitKt$joinAll$1.L$3;
                        Job job2 = (Job) awaitKt$joinAll$1.L$2;
                        i = awaitKt$joinAll$1.I$1;
                        int i3 = awaitKt$joinAll$1.I$0;
                        Job[] jobArr4 = (Job[]) awaitKt$joinAll$1.L$1;
                        Job[] jobArr5 = (Job[]) awaitKt$joinAll$1.L$0;
                        if (th == null) {
                            jobArr2 = jobArr4;
                            i2 = i3;
                            obj = coroutine_suspended;
                            awaitKt$joinAll$12 = awaitKt$joinAll$1;
                            jobArr3 = jobArr5;
                            i++;
                        } else {
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th == null) {
                    i2 = jobArr.length;
                    obj = coroutine_suspended;
                    jobArr2 = jobArr;
                    awaitKt$joinAll$12 = awaitKt$joinAll$1;
                    jobArr3 = jobArr2;
                    i = 0;
                } else {
                    throw th;
                }
                if (i < i2) {
                    Job job3 = jobArr2[i];
                    awaitKt$joinAll$12.L$0 = jobArr3;
                    awaitKt$joinAll$12.L$1 = jobArr2;
                    awaitKt$joinAll$12.I$0 = i2;
                    awaitKt$joinAll$12.I$1 = i;
                    awaitKt$joinAll$12.L$2 = job3;
                    awaitKt$joinAll$12.L$3 = job3;
                    awaitKt$joinAll$12.setLabel(1);
                    if (job3.join(awaitKt$joinAll$12) == obj) {
                        return obj;
                    }
                    i++;
                    if (i < i2) {
                    }
                }
                return Unit.INSTANCE;
            }
        }
        awaitKt$joinAll$1 = new AwaitKt$joinAll$1(continuation);
        Object obj22 = awaitKt$joinAll$1.data;
        Throwable th2 = awaitKt$joinAll$1.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = awaitKt$joinAll$1.getLabel();
        if (label == 0) {
        }
        if (i < i2) {
        }
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    public static final Object joinAll(Collection<? extends Job> collection, Continuation<? super Unit> continuation) {
        AwaitKt$joinAll$3 awaitKt$joinAll$3;
        int label;
        Collection<? extends Job> collection2;
        Iterator<T> it;
        Iterable iterable;
        if (continuation instanceof AwaitKt$joinAll$3) {
            awaitKt$joinAll$3 = (AwaitKt$joinAll$3) continuation;
            if ((awaitKt$joinAll$3.getLabel() & Integer.MIN_VALUE) != 0) {
                awaitKt$joinAll$3.setLabel(awaitKt$joinAll$3.getLabel() - Integer.MIN_VALUE);
                Object obj = awaitKt$joinAll$3.data;
                Throwable th = awaitKt$joinAll$3.exception;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                label = awaitKt$joinAll$3.getLabel();
                if (label == 0) {
                    if (label == 1) {
                        Job job = (Job) awaitKt$joinAll$3.L$4;
                        Object obj2 = awaitKt$joinAll$3.L$3;
                        it = (Iterator) awaitKt$joinAll$3.L$2;
                        iterable = (Iterable) awaitKt$joinAll$3.L$1;
                        Collection<? extends Job> collection3 = (Collection) awaitKt$joinAll$3.L$0;
                        if (th == null) {
                            collection2 = collection3;
                        } else {
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else if (th == null) {
                    Collection<? extends Job> collection4 = collection;
                    Iterator<T> it2 = collection4.iterator();
                    collection2 = collection;
                    it = it2;
                    iterable = collection4;
                } else {
                    throw th;
                }
                while (it.hasNext()) {
                    Object next = it.next();
                    Job job2 = (Job) next;
                    awaitKt$joinAll$3.L$0 = collection2;
                    awaitKt$joinAll$3.L$1 = iterable;
                    awaitKt$joinAll$3.L$2 = it;
                    awaitKt$joinAll$3.L$3 = next;
                    awaitKt$joinAll$3.L$4 = job2;
                    awaitKt$joinAll$3.setLabel(1);
                    if (job2.join(awaitKt$joinAll$3) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        awaitKt$joinAll$3 = new AwaitKt$joinAll$3(continuation);
        Object obj3 = awaitKt$joinAll$3.data;
        Throwable th2 = awaitKt$joinAll$3.exception;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        label = awaitKt$joinAll$3.getLabel();
        if (label == 0) {
        }
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }
}
