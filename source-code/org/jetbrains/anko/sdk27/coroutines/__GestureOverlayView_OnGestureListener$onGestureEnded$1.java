package org.jetbrains.anko.sdk27.coroutines;

import android.gesture.GestureOverlayView;
import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.CoroutineScope;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/experimental/CoroutineScope;", "invoke", "(Lkotlinx/coroutines/experimental/CoroutineScope;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 11})
/* compiled from: ListenersWithCoroutines.kt */
final class __GestureOverlayView_OnGestureListener$onGestureEnded$1 extends CoroutineImpl implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MotionEvent $event;
    final /* synthetic */ Function4 $handler;
    final /* synthetic */ GestureOverlayView $overlay;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    __GestureOverlayView_OnGestureListener$onGestureEnded$1(Function4 function4, GestureOverlayView gestureOverlayView, MotionEvent motionEvent, Continuation continuation) {
        super(2, continuation);
        this.$handler = function4;
        this.$overlay = gestureOverlayView;
        this.$event = motionEvent;
    }

    public final Continuation<Unit> create(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(coroutineScope, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        __GestureOverlayView_OnGestureListener$onGestureEnded$1 __gestureoverlayview_ongesturelistener_ongestureended_1 = new __GestureOverlayView_OnGestureListener$onGestureEnded$1(this.$handler, this.$overlay, this.$event, continuation);
        __gestureoverlayview_ongesturelistener_ongestureended_1.p$ = coroutineScope;
        return __gestureoverlayview_ongesturelistener_ongestureended_1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((__GestureOverlayView_OnGestureListener$onGestureEnded$1) create(coroutineScope, continuation)).doResume(Unit.INSTANCE, null);
    }

    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public /* bridge */ /* synthetic */ Continuation create(Object obj, Continuation continuation) {
        return create((CoroutineScope) obj, (Continuation<? super Unit>) continuation);
    }

    @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
    public final Object doResume(Object obj, Throwable th) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (th != null) {
                throw th;
            }
        } else if (th == null) {
            CoroutineScope coroutineScope = this.p$;
            Function4 function4 = this.$handler;
            GestureOverlayView gestureOverlayView = this.$overlay;
            MotionEvent motionEvent = this.$event;
            this.label = 1;
            if (function4.invoke(coroutineScope, gestureOverlayView, motionEvent, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            throw th;
        }
        return Unit.INSTANCE;
    }
}
