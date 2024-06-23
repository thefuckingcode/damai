package kotlinx.coroutines.flow.internal;

import com.youku.live.dago.module.DagoPlayerInteract;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.h;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.f;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ek1;
import tb.fh;
import tb.k12;
import tb.s01;
import tb.ur2;
import tb.wg;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H@"}, d2 = {"R", "T", "Lkotlinx/coroutines/CoroutineScope;", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0}, l = {57, 79, 82}, m = "invokeSuspend", n = {"latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues"}, s = {"L$0", "L$1", "L$2", "I$0"})
/* compiled from: Taobao */
public final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ur2>, Object> {
    final /* synthetic */ Function0<T[]> $arrayFactory;
    final /* synthetic */ Flow<T>[] $flows;
    final /* synthetic */ FlowCollector<R> $this_combineInternal;
    final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super ur2>, Object> $transform;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H@"}, d2 = {"R", "T", "Lkotlinx/coroutines/CoroutineScope;", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", i = {}, l = {DagoPlayerInteract.UNIT_ANCHOR_INFO_WIDTH}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ur2>, Object> {
        int label;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(flowArr, i5, atomicInteger, b3, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ur2> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(ur2.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object obj2 = b.d();
            int i = this.label;
            if (i == 0) {
                k12.b(obj);
                Flow<T>[] flowArr = flowArr;
                int i2 = i5;
                Flow<T> flow = flowArr[i2];
                CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 combineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 = new CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1(b3, i2);
                this.label = 1;
                if (flow.collect(combineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1, this) == obj2) {
                    return obj2;
                }
            } else if (i == 1) {
                try {
                    k12.b(obj);
                } catch (Throwable th) {
                    if (atomicInteger.decrementAndGet() == 0) {
                        SendChannel.a.a(b3, null, 1, null);
                    }
                    throw th;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (atomicInteger.decrementAndGet() == 0) {
                SendChannel.a.a(b3, null, 1, null);
            }
            return ur2.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.flow.Flow<? extends T>[] */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function3<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T[], ? super kotlin.coroutines.Continuation<? super tb.ur2>, ? extends java.lang.Object> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlinx.coroutines.flow.FlowCollector<? super R> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$combineInternal$2(Flow<? extends T>[] flowArr, Function0<T[]> function0, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super ur2>, ? extends Object> function3, FlowCollector<? super R> flowCollector, Continuation<? super CombineKt$combineInternal$2> continuation) {
        super(2, continuation);
        this.$flows = flowArr;
        this.$arrayFactory = function0;
        this.$transform = function3;
        this.$this_combineInternal = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, continuation);
        combineKt$combineInternal$2.L$0 = obj;
        return combineKt$combineInternal$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ur2> continuation) {
        return ((CombineKt$combineInternal$2) create(coroutineScope, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f1 A[LOOP:1: B:29:0x00f1->B:35:0x0115, LOOP_START, PHI: r3 r10 
      PHI: (r3v2 int) = (r3v1 int), (r3v3 int) binds: [B:26:0x00ec, B:35:0x0115] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r10v3 tb.s01) = (r10v2 tb.s01), (r10v16 tb.s01) binds: [B:26:0x00ec, B:35:0x0115] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Unknown variable types count: 3 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object[] objArr;
        int i;
        CombineKt$combineInternal$2 combineKt$combineInternal$2;
        Channel channel;
        byte b;
        byte[] bArr;
        Object[] objArr2;
        Object obj2;
        CombineKt$combineInternal$2 combineKt$combineInternal$22;
        Channel channel2;
        byte b2;
        int i2;
        s01 s01;
        Object[] objArr3;
        Object obj3 = b.d();
        int i3 = this.label;
        int i4 = 2;
        if (i3 == 0) {
            k12.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            i = this.$flows.length;
            if (i == 0) {
                return ur2.INSTANCE;
            }
            objArr = new Object[i];
            h.k(objArr, ek1.UNINITIALIZED, 0, 0, 6, null);
            final Channel b3 = wg.b(i, null, null, 6, null);
            final AtomicInteger atomicInteger = new AtomicInteger(i);
            if (i > 0) {
                final int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    final Flow<T>[] flowArr = this.$flows;
                    Job unused = f.b(coroutineScope, null, null, new AnonymousClass1(null), 3, null);
                    if (i6 >= i) {
                        break;
                    }
                    i5 = i6;
                    atomicInteger = atomicInteger;
                }
            }
            bArr = new byte[i];
            combineKt$combineInternal$2 = this;
            channel = b3;
            b = 0;
        } else if (i3 == 1) {
            ?? r2 = this.I$1;
            i2 = this.I$0;
            byte[] bArr2 = (byte[]) this.L$2;
            channel2 = (Channel) this.L$1;
            k12.b(obj);
            obj2 = ((fh) obj).l();
            objArr2 = (Object[]) this.L$0;
            combineKt$combineInternal$22 = this;
            b2 = r2;
            bArr = bArr2;
            s01 = (s01) fh.f(obj2);
            if (s01 == null) {
                do {
                    int c = s01.c();
                    Object obj4 = objArr2[c];
                    objArr2[c] = s01.d();
                    if (obj4 == ek1.UNINITIALIZED) {
                        i2--;
                    }
                    if (bArr[c] == b2) {
                        break;
                    }
                    bArr[c] = (byte) b2;
                    s01 = (s01) fh.f(channel2.m929tryReceivePtdJZtk());
                } while (s01 != null);
                if (i2 != 0) {
                    objArr3 = objArr2;
                } else {
                    T[] invoke = combineKt$combineInternal$22.$arrayFactory.invoke();
                    if (invoke == null) {
                        Function3<FlowCollector<? super R>, T[], Continuation<? super ur2>, Object> function3 = combineKt$combineInternal$22.$transform;
                        FlowCollector<R> flowCollector = combineKt$combineInternal$22.$this_combineInternal;
                        combineKt$combineInternal$22.L$0 = objArr2;
                        combineKt$combineInternal$22.L$1 = channel2;
                        combineKt$combineInternal$22.L$2 = bArr;
                        combineKt$combineInternal$22.I$0 = i2;
                        combineKt$combineInternal$22.I$1 = b2;
                        combineKt$combineInternal$22.label = i4;
                        if (function3.invoke(flowCollector, objArr2, combineKt$combineInternal$22) == obj3) {
                            return obj3;
                        }
                        i = i2;
                        b = b2;
                        channel = channel2;
                        combineKt$combineInternal$2 = combineKt$combineInternal$22;
                        objArr = objArr2;
                        return obj3;
                    }
                    objArr3 = objArr2;
                    Object[] unused2 = h.f(objArr2, invoke, 0, 0, 0, 14, null);
                    Function3<FlowCollector<? super R>, T[], Continuation<? super ur2>, Object> function32 = combineKt$combineInternal$22.$transform;
                    FlowCollector<R> flowCollector2 = combineKt$combineInternal$22.$this_combineInternal;
                    combineKt$combineInternal$22.L$0 = objArr3;
                    combineKt$combineInternal$22.L$1 = channel2;
                    combineKt$combineInternal$22.L$2 = bArr;
                    combineKt$combineInternal$22.I$0 = i2;
                    combineKt$combineInternal$22.I$1 = b2;
                    combineKt$combineInternal$22.label = 3;
                    if (function32.invoke(flowCollector2, invoke, combineKt$combineInternal$22) == obj3) {
                        return obj3;
                    }
                }
                i = i2;
                objArr = objArr3;
                b = b2;
                channel = channel2;
                combineKt$combineInternal$2 = combineKt$combineInternal$22;
                i4 = 2;
            }
            return ur2.INSTANCE;
        } else if (i3 == 2) {
            ?? r22 = this.I$1;
            int i7 = this.I$0;
            k12.b(obj);
            i = i7;
            objArr = (Object[]) this.L$0;
            b = r22;
            bArr = (byte[]) this.L$2;
            channel = (Channel) this.L$1;
            combineKt$combineInternal$2 = this;
        } else if (i3 == 3) {
            ?? r23 = this.I$1;
            int i8 = this.I$0;
            k12.b(obj);
            i = i8;
            objArr = (Object[]) this.L$0;
            b = r23;
            bArr = (byte[]) this.L$2;
            channel = (Channel) this.L$1;
            combineKt$combineInternal$2 = this;
            i4 = 2;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        byte b4 = (byte) (b + 1);
        combineKt$combineInternal$2.L$0 = objArr;
        combineKt$combineInternal$2.L$1 = channel;
        combineKt$combineInternal$2.L$2 = bArr;
        combineKt$combineInternal$2.I$0 = i;
        combineKt$combineInternal$2.I$1 = b4;
        combineKt$combineInternal$2.label = 1;
        obj2 = channel.m928receiveCatchingJP2dKIU(combineKt$combineInternal$2);
        if (obj2 == obj3) {
            return obj3;
        }
        combineKt$combineInternal$22 = combineKt$combineInternal$2;
        objArr2 = objArr;
        channel2 = channel;
        b2 = b4;
        i2 = i;
        s01 = (s01) fh.f(obj2);
        if (s01 == null) {
        }
        return ur2.INSTANCE;
        return obj3;
    }
}
