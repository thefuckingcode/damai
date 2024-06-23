package kotlinx.coroutines.flow;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b11;
import tb.k12;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H@"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7", f = "Zip.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Taobao */
public final class FlowKt__ZipKt$combineTransform$7 extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super ur2>, Object> {
    final /* synthetic */ Flow<T>[] $flowArray;
    final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super ur2>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H@"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "", AdvanceSetting.NETWORK_TYPE, "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2", f = "Zip.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2  reason: invalid class name */
    /* compiled from: Taobao */
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super R>, T[], Continuation<? super ur2>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        @Nullable
        public final Object invoke(@NotNull FlowCollector<? super R> flowCollector, @NotNull T[] tArr, @Nullable Continuation<? super ur2> continuation) {
            AnonymousClass2 r0 = new AnonymousClass2(r3, continuation);
            r0.L$0 = flowCollector;
            r0.L$1 = tArr;
            return r0.invokeSuspend(ur2.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object obj2 = b.d();
            int i = this.label;
            if (i == 0) {
                k12.b(obj);
                Function3<FlowCollector<? super R>, T[], Continuation<? super ur2>, Object> function3 = r3;
                this.L$0 = null;
                this.label = 1;
                if (function3.invoke((FlowCollector) this.L$0, (Object[]) this.L$1, this) == obj2) {
                    return obj2;
                }
            } else if (i == 1) {
                k12.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return ur2.INSTANCE;
        }

        @Nullable
        public final Object invokeSuspend$$forInline(@NotNull Object obj) {
            r3.invoke((FlowCollector) this.L$0, (Object[]) this.L$1, this);
            return ur2.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function3<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T[], ? super kotlin.coroutines.Continuation<? super tb.ur2>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineTransform$7(Flow<T>[] flowArr, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super ur2>, ? extends Object> function3, Continuation<? super FlowKt__ZipKt$combineTransform$7> continuation) {
        super(2, continuation);
        this.$flowArray = flowArr;
        this.$transform = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__ZipKt$combineTransform$7 flowKt__ZipKt$combineTransform$7 = new FlowKt__ZipKt$combineTransform$7(this.$flowArray, this.$transform, continuation);
        flowKt__ZipKt$combineTransform$7.L$0 = obj;
        return flowKt__ZipKt$combineTransform$7;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super R> flowCollector, @Nullable Continuation<? super ur2> continuation) {
        return ((FlowKt__ZipKt$combineTransform$7) create(flowCollector, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2 = b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            Flow<T>[] flowArr = this.$flowArray;
            k21.n();
            final Flow<T>[] flowArr2 = this.$flowArray;
            AnonymousClass1 r3 = new Function0<T[]>() {
                /* class kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7.AnonymousClass1 */

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final T[] invoke() {
                    int length = r2.length;
                    k21.o(0, "T?");
                    return (T[]) new Object[length];
                }
            };
            final Function3<FlowCollector<? super R>, T[], Continuation<? super ur2>, Object> function3 = this.$transform;
            AnonymousClass2 r4 = new AnonymousClass2(null);
            this.label = 1;
            if (CombineKt.a((FlowCollector) this.L$0, flowArr, r3, r4, this) == obj2) {
                return obj2;
            }
        } else if (i == 1) {
            k12.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return ur2.INSTANCE;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        Flow<T>[] flowArr = this.$flowArray;
        k21.n();
        final Flow<T>[] flowArr2 = this.$flowArray;
        AnonymousClass1 r1 = new Function0<T[]>() {
            /* class kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7.AnonymousClass1 */

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final T[] invoke() {
                int length = flowArr2.length;
                k21.o(0, "T?");
                return (T[]) new Object[length];
            }
        };
        final Function3<FlowCollector<? super R>, T[], Continuation<? super ur2>, Object> function3 = this.$transform;
        AnonymousClass2 r2 = new AnonymousClass2(null);
        b11.c(0);
        CombineKt.a((FlowCollector) this.L$0, flowArr, r1, r2, this);
        b11.c(1);
        return ur2.INSTANCE;
    }
}
