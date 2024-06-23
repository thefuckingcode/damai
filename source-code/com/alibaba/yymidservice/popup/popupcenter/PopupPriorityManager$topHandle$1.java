package com.alibaba.yymidservice.popup.popupcenter;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager", f = "PopupPriorityManager.kt", i = {0, 1}, l = {113, 118}, m = "topHandle", n = {"this", "this"}, s = {"L$0", "L$0"})
/* compiled from: Taobao */
final class PopupPriorityManager$topHandle$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PopupPriorityManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PopupPriorityManager$topHandle$1(PopupPriorityManager popupPriorityManager, Continuation<? super PopupPriorityManager$topHandle$1> continuation) {
        super(continuation);
        this.this$0 = popupPriorityManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return PopupPriorityManager.d(this.this$0, this);
    }
}
