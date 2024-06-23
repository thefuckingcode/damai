package com.alibaba.yymidservice.popup.popupcenter;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager", f = "PopupPriorityManager.kt", i = {}, l = {210}, m = "interceptAction", n = {}, s = {})
/* compiled from: Taobao */
final class PopupPriorityManager$interceptAction$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PopupPriorityManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PopupPriorityManager$interceptAction$1(PopupPriorityManager popupPriorityManager, Continuation<? super PopupPriorityManager$interceptAction$1> continuation) {
        super(continuation);
        this.this$0 = popupPriorityManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return PopupPriorityManager.a(this.this$0, null, null, this);
    }
}
