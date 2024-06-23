package kotlinx.coroutines.flow;

import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.youku.uplayer.AliMediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/SharingCommand;", "", AdUtConstants.XAD_UT_ARG_COUNT, "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", i = {1, 2, 3}, l = {AliMediaPlayer.UPLAYER_PROPERTY_TYPE_JITTER_MONITOR_LOWSPEED_THRESHOLD, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_DOWNLOAD_TIMEOUT_FACTOR, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_IS_WIFI, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_IS_AudioMode, AliMediaPlayer.UPLAYER_UPS_START_GEAR}, m = "invokeSuspend", n = {"$this$transformLatest", "$this$transformLatest", "$this$transformLatest"}, s = {"L$0", "L$0", "L$0"})
/* compiled from: Taobao */
final class StartedWhileSubscribed$command$1 extends SuspendLambda implements Function3<FlowCollector<? super SharingCommand>, Integer, Continuation<? super ur2>, Object> {
    /* synthetic */ int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ k this$0;

    StartedWhileSubscribed$command$1(k kVar, Continuation<? super StartedWhileSubscribed$command$1> continuation) {
        super(3, continuation);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super SharingCommand> flowCollector, Integer num, Continuation<? super ur2> continuation) {
        return invoke(flowCollector, num.intValue(), continuation);
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super SharingCommand> flowCollector, int i, @Nullable Continuation<? super ur2> continuation) {
        StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new StartedWhileSubscribed$command$1(this.this$0, continuation);
        startedWhileSubscribed$command$1.L$0 = flowCollector;
        startedWhileSubscribed$command$1.I$0 = i;
        return startedWhileSubscribed$command$1.invokeSuspend(ur2.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x008d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009b A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        FlowCollector flowCollector;
        SharingCommand sharingCommand;
        long a;
        Object obj2 = b.d();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    flowCollector = (FlowCollector) this.L$0;
                    k12.b(obj);
                } else if (i == 3) {
                    flowCollector = (FlowCollector) this.L$0;
                    k12.b(obj);
                    a = k.a(this.this$0);
                    this.L$0 = flowCollector;
                    this.label = 4;
                    if (DelayKt.b(a, this) == obj2) {
                        return obj2;
                    }
                    sharingCommand = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                    this.L$0 = null;
                    this.label = 5;
                    if (flowCollector.emit(sharingCommand, this) == obj2) {
                    }
                    return ur2.INSTANCE;
                } else if (i == 4) {
                    flowCollector = (FlowCollector) this.L$0;
                    k12.b(obj);
                    sharingCommand = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
                    this.L$0 = null;
                    this.label = 5;
                    if (flowCollector.emit(sharingCommand, this) == obj2) {
                        return obj2;
                    }
                    return ur2.INSTANCE;
                } else if (i != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
            k12.b(obj);
            return ur2.INSTANCE;
        }
        k12.b(obj);
        flowCollector = (FlowCollector) this.L$0;
        if (this.I$0 > 0) {
            SharingCommand sharingCommand2 = SharingCommand.START;
            this.label = 1;
            if (flowCollector.emit(sharingCommand2, this) == obj2) {
                return obj2;
            }
            return ur2.INSTANCE;
        }
        long b = k.b(this.this$0);
        this.L$0 = flowCollector;
        this.label = 2;
        if (DelayKt.b(b, this) == obj2) {
            return obj2;
        }
        if (k.a(this.this$0) > 0) {
            SharingCommand sharingCommand3 = SharingCommand.STOP;
            this.L$0 = flowCollector;
            this.label = 3;
            if (flowCollector.emit(sharingCommand3, this) == obj2) {
                return obj2;
            }
            a = k.a(this.this$0);
            this.L$0 = flowCollector;
            this.label = 4;
            if (DelayKt.b(a, this) == obj2) {
            }
        }
        sharingCommand = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
        this.L$0 = null;
        this.label = 5;
        if (flowCollector.emit(sharingCommand, this) == obj2) {
        }
        return ur2.INSTANCE;
    }
}
