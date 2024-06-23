package org.jetbrains.anko.sdk27.coroutines;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.experimental.CoroutineScope;
import kotlinx.coroutines.experimental.Job;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\bH\u0016J=\u0010\u000f\u001a\u00020\n2-\u0010\u0011\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\bH\u0016J=\u0010\u0013\u001a\u00020\n2-\u0010\u0011\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0002\u0010\u0012R<\u0010\u0005\u001a+\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0006¢\u0006\u0002\b\fX\u000eø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\rR<\u0010\u000e\u001a+\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0006¢\u0006\u0002\b\fX\u000eø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\t¨\u0006\u0014"}, d2 = {"Lorg/jetbrains/anko/sdk27/coroutines/__View_OnAttachStateChangeListener;", "Landroid/view/View$OnAttachStateChangeListener;", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "(Lkotlin/coroutines/experimental/CoroutineContext;)V", "_onViewAttachedToWindow", "Lkotlin/Function3;", "Lkotlinx/coroutines/experimental/CoroutineScope;", "Landroid/view/View;", "Lkotlin/coroutines/experimental/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function3;", "_onViewDetachedFromWindow", "onViewAttachedToWindow", "v", "listener", "(Lkotlin/jvm/functions/Function3;)V", "onViewDetachedFromWindow", "anko-sdk27-coroutines_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: ListenersWithCoroutines.kt */
public final class __View_OnAttachStateChangeListener implements View.OnAttachStateChangeListener {
    private Function3<? super CoroutineScope, ? super View, ? super Continuation<? super Unit>, ? extends Object> _onViewAttachedToWindow;
    private Function3<? super CoroutineScope, ? super View, ? super Continuation<? super Unit>, ? extends Object> _onViewDetachedFromWindow;
    private final CoroutineContext context;

    public __View_OnAttachStateChangeListener(CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        this.context = coroutineContext;
    }

    public void onViewAttachedToWindow(View view) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        Function3<? super CoroutineScope, ? super View, ? super Continuation<? super Unit>, ? extends Object> function3 = this._onViewAttachedToWindow;
        if (function3 != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.context, null, null, null, new __View_OnAttachStateChangeListener$onViewAttachedToWindow$1(function3, view, null), 14, null);
        }
    }

    public final void onViewAttachedToWindow(Function3<? super CoroutineScope, ? super View, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "listener");
        this._onViewAttachedToWindow = function3;
    }

    public void onViewDetachedFromWindow(View view) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        Function3<? super CoroutineScope, ? super View, ? super Continuation<? super Unit>, ? extends Object> function3 = this._onViewDetachedFromWindow;
        if (function3 != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.context, null, null, null, new __View_OnAttachStateChangeListener$onViewDetachedFromWindow$1(function3, view, null), 14, null);
        }
    }

    public final void onViewDetachedFromWindow(Function3<? super CoroutineScope, ? super View, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "listener");
        this._onViewDetachedFromWindow = function3;
    }
}
