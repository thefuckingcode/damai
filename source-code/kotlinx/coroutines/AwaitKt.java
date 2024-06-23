package kotlinx.coroutines;

import java.util.Collection;
import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.ur2;

/* compiled from: Taobao */
public final class AwaitKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    public static final Object a(@NotNull Collection<? extends Job> collection, @NotNull Continuation<? super ur2> continuation) {
        AwaitKt$joinAll$3 awaitKt$joinAll$3;
        int i;
        Iterator<T> it;
        if (continuation instanceof AwaitKt$joinAll$3) {
            awaitKt$joinAll$3 = (AwaitKt$joinAll$3) continuation;
            int i2 = awaitKt$joinAll$3.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                awaitKt$joinAll$3.label = i2 - Integer.MIN_VALUE;
                Object obj = awaitKt$joinAll$3.result;
                Object obj2 = b.d();
                i = awaitKt$joinAll$3.label;
                if (i != 0) {
                    k12.b(obj);
                    it = collection.iterator();
                } else if (i == 1) {
                    it = (Iterator) awaitKt$joinAll$3.L$0;
                    k12.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                while (it.hasNext()) {
                    awaitKt$joinAll$3.L$0 = it;
                    awaitKt$joinAll$3.label = 1;
                    if (((Job) it.next()).join(awaitKt$joinAll$3) == obj2) {
                        return obj2;
                    }
                }
                return ur2.INSTANCE;
            }
        }
        awaitKt$joinAll$3 = new AwaitKt$joinAll$3(continuation);
        Object obj3 = awaitKt$joinAll$3.result;
        Object obj22 = b.d();
        i = awaitKt$joinAll$3.label;
        if (i != 0) {
        }
        while (it.hasNext()) {
        }
        return ur2.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    public static final Object b(@NotNull Job[] jobArr, @NotNull Continuation<? super ur2> continuation) {
        AwaitKt$joinAll$1 awaitKt$joinAll$1;
        int i;
        Job[] jobArr2;
        int i2;
        int i3;
        if (continuation instanceof AwaitKt$joinAll$1) {
            awaitKt$joinAll$1 = (AwaitKt$joinAll$1) continuation;
            int i4 = awaitKt$joinAll$1.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                awaitKt$joinAll$1.label = i4 - Integer.MIN_VALUE;
                Object obj = awaitKt$joinAll$1.result;
                Object obj2 = b.d();
                i = awaitKt$joinAll$1.label;
                if (i != 0) {
                    k12.b(obj);
                    i3 = jobArr.length;
                    jobArr2 = jobArr;
                    i2 = 0;
                } else if (i == 1) {
                    i2 = awaitKt$joinAll$1.I$1;
                    i3 = awaitKt$joinAll$1.I$0;
                    k12.b(obj);
                    jobArr2 = (Job[]) awaitKt$joinAll$1.L$0;
                    i2++;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (i2 < i3) {
                    Job job = jobArr2[i2];
                    awaitKt$joinAll$1.L$0 = jobArr2;
                    awaitKt$joinAll$1.I$0 = i3;
                    awaitKt$joinAll$1.I$1 = i2;
                    awaitKt$joinAll$1.label = 1;
                    if (job.join(awaitKt$joinAll$1) == obj2) {
                        return obj2;
                    }
                    i2++;
                    if (i2 < i3) {
                    }
                }
                return ur2.INSTANCE;
            }
        }
        awaitKt$joinAll$1 = new AwaitKt$joinAll$1(continuation);
        Object obj3 = awaitKt$joinAll$1.result;
        Object obj22 = b.d();
        i = awaitKt$joinAll$1.label;
        if (i != 0) {
        }
        if (i2 < i3) {
        }
        return ur2.INSTANCE;
    }
}
