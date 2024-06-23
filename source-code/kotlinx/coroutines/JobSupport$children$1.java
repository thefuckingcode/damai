package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k12;
import tb.k21;
import tb.q81;
import tb.s82;
import tb.uh;
import tb.ur2;
import tb.xi1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Ltb/s82;", "Lkotlinx/coroutines/ChildJob;", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {1, 1}, l = {952, 954}, m = "invokeSuspend", n = {"this_$iv", "cur$iv"}, s = {"L$1", "L$2"})
/* compiled from: Taobao */
final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<s82<? super ChildJob>, Continuation<? super ur2>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ JobSupport this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JobSupport$children$1(JobSupport jobSupport, Continuation<? super JobSupport$children$1> continuation) {
        super(2, continuation);
        this.this$0 = jobSupport;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.this$0, continuation);
        jobSupport$children$1.L$0 = obj;
        return jobSupport$children$1;
    }

    @Nullable
    public final Object invoke(@NotNull s82<? super ChildJob> s82, @Nullable Continuation<? super ur2> continuation) {
        return ((JobSupport$children$1) create(s82, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        JobSupport$children$1 jobSupport$children$1;
        s82 s82;
        q81 q81;
        b bVar;
        xi1 list;
        Object obj2 = kotlin.coroutines.intrinsics.b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            s82 s822 = (s82) this.L$0;
            Object state$kotlinx_coroutines_core = this.this$0.getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof uh) {
                ChildJob childJob = ((uh) state$kotlinx_coroutines_core).e;
                this.label = 1;
                if (s822.a(childJob, this) == obj2) {
                    return obj2;
                }
            } else if ((state$kotlinx_coroutines_core instanceof Incomplete) && (list = ((Incomplete) state$kotlinx_coroutines_core).getList()) != null) {
                s82 = s822;
                jobSupport$children$1 = this;
                q81 = list;
                bVar = (b) list.j();
            }
            return ur2.INSTANCE;
        } else if (i == 1) {
            k12.b(obj);
            return ur2.INSTANCE;
        } else if (i == 2) {
            bVar = (b) this.L$2;
            q81 = (q81) this.L$1;
            s82 = (s82) this.L$0;
            k12.b(obj);
            jobSupport$children$1 = this;
            bVar = bVar.k();
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!k21.d(bVar, q81)) {
            if (bVar instanceof uh) {
                ChildJob childJob2 = ((uh) bVar).e;
                jobSupport$children$1.L$0 = s82;
                jobSupport$children$1.L$1 = q81;
                jobSupport$children$1.L$2 = bVar;
                jobSupport$children$1.label = 2;
                if (s82.a(childJob2, jobSupport$children$1) == obj2) {
                    return obj2;
                }
            }
            bVar = bVar.k();
            if (!k21.d(bVar, q81)) {
            }
        }
        return ur2.INSTANCE;
    }
}
