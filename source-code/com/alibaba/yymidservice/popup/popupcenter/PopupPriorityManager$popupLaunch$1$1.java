package com.alibaba.yymidservice.popup.popupcenter;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jr1;
import tb.k12;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager$popupLaunch$1$1", f = "PopupPriorityManager.kt", i = {}, l = {97, 100, 103}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Taobao */
public final class PopupPriorityManager$popupLaunch$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ur2>, Object> {
    int label;
    final /* synthetic */ PopupPriorityManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PopupPriorityManager$popupLaunch$1$1(PopupPriorityManager popupPriorityManager, Continuation<? super PopupPriorityManager$popupLaunch$1$1> continuation) {
        super(2, continuation);
        this.this$0 = popupPriorityManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<ur2> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PopupPriorityManager$popupLaunch$1$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ur2> continuation) {
        return ((PopupPriorityManager$popupLaunch$1$1) create(coroutineScope, continuation)).invokeSuspend(ur2.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        PopupPriorityManager popupPriorityManager;
        Object obj2 = b.d();
        int i = this.label;
        if (i == 0) {
            k12.b(obj);
            PopupPriorityManager popupPriorityManager2 = this.this$0;
            this.label = 1;
            obj = PopupPriorityManager.d(popupPriorityManager2, this);
            if (obj == obj2) {
                return obj2;
            }
        } else if (i == 1) {
            k12.b(obj);
        } else if (i == 2) {
            k12.b(obj);
            popupPriorityManager = this.this$0;
            this.label = 3;
            if (PopupPriorityManager.b(popupPriorityManager, (jr1) obj, this) == obj2) {
                return obj2;
            }
            return ur2.INSTANCE;
        } else if (i == 3) {
            k12.b(obj);
            return ur2.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PopupPriorityManager popupPriorityManager3 = this.this$0;
        this.label = 2;
        obj = PopupPriorityManager.c(popupPriorityManager3, (jr1) obj, this);
        if (obj == obj2) {
            return obj2;
        }
        popupPriorityManager = this.this$0;
        this.label = 3;
        if (PopupPriorityManager.b(popupPriorityManager, (jr1) obj, this) == obj2) {
        }
        return ur2.INSTANCE;
    }
}
