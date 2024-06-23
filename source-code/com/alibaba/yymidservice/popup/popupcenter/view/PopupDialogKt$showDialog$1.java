package com.alibaba.yymidservice.popup.popupcenter.view;

import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.alibaba.yymidservice.popup.popupcenter.view.PopupDialogKt", f = "PopupDialog.kt", i = {0}, l = {22, 24}, m = "showDialog", n = {WPKFactory.INIT_KEY_CONTEXT}, s = {"L$0"})
/* compiled from: Taobao */
public final class PopupDialogKt$showDialog$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    PopupDialogKt$showDialog$1(Continuation<? super PopupDialogKt$showDialog$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return PopupDialogKt.a(null, null, this);
    }
}
