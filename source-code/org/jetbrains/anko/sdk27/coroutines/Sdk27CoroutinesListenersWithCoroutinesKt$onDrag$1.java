package org.jetbrains.anko.sdk27.coroutines;

import android.view.DragEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.experimental.CoroutineScope;
import kotlinx.coroutines.experimental.Job;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_EVENT, "Landroid/view/DragEvent;", "onDrag"}, k = 3, mv = {1, 1, 11})
/* compiled from: ListenersWithCoroutines.kt */
public final class Sdk27CoroutinesListenersWithCoroutinesKt$onDrag$1 implements View.OnDragListener {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ Function4 $handler;
    final /* synthetic */ boolean $returnValue;

    Sdk27CoroutinesListenersWithCoroutinesKt$onDrag$1(CoroutineContext coroutineContext, Function4 function4, boolean z) {
        this.$context = coroutineContext;
        this.$handler = function4;
        this.$returnValue = z;
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/experimental/CoroutineScope;", "invoke", "(Lkotlinx/coroutines/experimental/CoroutineScope;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 11})
    /* renamed from: org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt$onDrag$1$1  reason: invalid class name */
    /* compiled from: ListenersWithCoroutines.kt */
    static final class AnonymousClass1 extends CoroutineImpl implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private CoroutineScope p$;
        final /* synthetic */ Sdk27CoroutinesListenersWithCoroutinesKt$onDrag$1 this$0;

        {
            this.this$0 = r1;
        }

        @Override // kotlin.coroutines.experimental.jvm.internal.CoroutineImpl
        public /* bridge */ /* synthetic */ Continuation create(Object obj, Continuation continuation) {
            return create((CoroutineScope) obj, (Continuation<? super Unit>) continuation);
        }

        public final Continuation<Unit> create(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Intrinsics.checkParameterIsNotNull(coroutineScope, "$receiver");
            Intrinsics.checkParameterIsNotNull(continuation, "continuation");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, view, dragEvent, continuation);
            r0.p$ = coroutineScope;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).doResume(Unit.INSTANCE, null);
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
                Function4 function4 = this.this$0.$handler;
                View view = view;
                Intrinsics.checkExpressionValueIsNotNull(view, "v");
                DragEvent dragEvent = dragEvent;
                Intrinsics.checkExpressionValueIsNotNull(dragEvent, NotificationCompat.CATEGORY_EVENT);
                this.label = 1;
                if (function4.invoke(coroutineScope, view, dragEvent, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw th;
            }
            return Unit.INSTANCE;
        }
    }

    public final boolean onDrag(final View view, final DragEvent dragEvent) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.$context, null, null, null, new AnonymousClass1(this, null), 14, null);
        return this.$returnValue;
    }
}
