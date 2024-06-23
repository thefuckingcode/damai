package org.jetbrains.anko.sdk27.coroutines;

import android.widget.SearchView;
import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.experimental.CoroutineScope;
import kotlinx.coroutines.experimental.Job;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JG\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\n2-\u0010\u0014\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\bH\u0016JG\u0010\u0017\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\n2-\u0010\u0014\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\bH\u0016R<\u0010\u0005\u001a+\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0006¢\u0006\u0002\b\fX\u000eø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R<\u0010\u000f\u001a+\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0006¢\u0006\u0002\b\fX\u000eø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\t¨\u0006\u0018"}, d2 = {"Lorg/jetbrains/anko/sdk27/coroutines/__SearchView_OnSuggestionListener;", "Landroid/widget/SearchView$OnSuggestionListener;", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "(Lkotlin/coroutines/experimental/CoroutineContext;)V", "_onSuggestionClick", "Lkotlin/Function3;", "Lkotlinx/coroutines/experimental/CoroutineScope;", "", "Lkotlin/coroutines/experimental/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function3;", "_onSuggestionClick_returnValue", "_onSuggestionSelect", "_onSuggestionSelect_returnValue", "onSuggestionClick", "", "returnValue", "listener", "(ZLkotlin/jvm/functions/Function3;)V", "position", "onSuggestionSelect", "anko-sdk27-coroutines_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: ListenersWithCoroutines.kt */
public final class __SearchView_OnSuggestionListener implements SearchView.OnSuggestionListener {
    private Function3<? super CoroutineScope, ? super Integer, ? super Continuation<? super Boolean>, ? extends Object> _onSuggestionClick;
    private boolean _onSuggestionClick_returnValue;
    private Function3<? super CoroutineScope, ? super Integer, ? super Continuation<? super Boolean>, ? extends Object> _onSuggestionSelect;
    private boolean _onSuggestionSelect_returnValue;
    private final CoroutineContext context;

    public __SearchView_OnSuggestionListener(CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        this.context = coroutineContext;
    }

    public boolean onSuggestionSelect(int i) {
        boolean z = this._onSuggestionSelect_returnValue;
        Function3<? super CoroutineScope, ? super Integer, ? super Continuation<? super Boolean>, ? extends Object> function3 = this._onSuggestionSelect;
        if (function3 != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.context, null, null, null, new __SearchView_OnSuggestionListener$onSuggestionSelect$1(function3, i, null), 14, null);
        }
        return z;
    }

    public static /* bridge */ /* synthetic */ void onSuggestionSelect$default(__SearchView_OnSuggestionListener __searchview_onsuggestionlistener, boolean z, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        __searchview_onsuggestionlistener.onSuggestionSelect(z, function3);
    }

    public final void onSuggestionSelect(boolean z, Function3<? super CoroutineScope, ? super Integer, ? super Continuation<? super Boolean>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "listener");
        this._onSuggestionSelect = function3;
        this._onSuggestionSelect_returnValue = z;
    }

    public boolean onSuggestionClick(int i) {
        boolean z = this._onSuggestionClick_returnValue;
        Function3<? super CoroutineScope, ? super Integer, ? super Continuation<? super Boolean>, ? extends Object> function3 = this._onSuggestionClick;
        if (function3 != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.context, null, null, null, new __SearchView_OnSuggestionListener$onSuggestionClick$1(function3, i, null), 14, null);
        }
        return z;
    }

    public static /* bridge */ /* synthetic */ void onSuggestionClick$default(__SearchView_OnSuggestionListener __searchview_onsuggestionlistener, boolean z, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        __searchview_onsuggestionlistener.onSuggestionClick(z, function3);
    }

    public final void onSuggestionClick(boolean z, Function3<? super CoroutineScope, ? super Integer, ? super Continuation<? super Boolean>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "listener");
        this._onSuggestionClick = function3;
        this._onSuggestionClick_returnValue = z;
    }
}
