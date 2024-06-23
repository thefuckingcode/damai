package org.jetbrains.anko.appcompat.v7.coroutines;

import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.FitWindowsFrameLayout;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import com.lzy.okgo.cookie.SerializableCookie;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.CoroutineScope;
import kotlinx.coroutines.experimental.android.HandlerContextKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001aO\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0002\u0010\r\u001aE\u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\b\b\u0002\u0010\u0003\u001a\u00020\u00042'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\\\u0010\u0011\u001a\u00020\u0001*\u00020\u00122\b\b\u0002\u0010\u0003\u001a\u00020\u00042>\u0010\u0007\u001a:\b\u0001\u0012\u0004\u0012\u00020\t\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0013¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001as\u0010\u0019\u001a\u00020\u0001*\u00020\u001a2\b\b\u0002\u0010\u0003\u001a\u00020\u00042U\u0010\u0007\u001aQ\b\u0001\u0012\u0004\u0012\u00020\t\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001b¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0002\u0010\u001f\u001af\u0010 \u001a\u00020\u0001*\u00020!2\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062>\u0010\u0007\u001a:\b\u0001\u0012\u0004\u0012\u00020\t\u0012\u0015\u0012\u0013\u0018\u00010\"¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(#\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0013¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0002\u0010$\u001af\u0010 \u001a\u00020\u0001*\u00020%2\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062>\u0010\u0007\u001a:\b\u0001\u0012\u0004\u0012\u00020\t\u0012\u0015\u0012\u0013\u0018\u00010\"¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(#\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0013¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0002\u0010&\u001ao\u0010'\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042Q\u0010\u0007\u001aM\b\u0001\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b()\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001b¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0002\u0010*\u001a-\u0010+\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00010-¢\u0006\u0002\b\f\u001a\\\u0010/\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042>\u0010\u0007\u001a:\b\u0001\u0012\u0004\u0012\u00020\t\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b((\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0013¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0002\u00100\u001a-\u00101\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u00010-¢\u0006\u0002\b\f\u0002\u0004\n\u0002\b\t¨\u00063"}, d2 = {"onClose", "", "Landroidx/appcompat/widget/SearchView;", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "returnValue", "", "handler", "Lkotlin/Function2;", "Lkotlinx/coroutines/experimental/CoroutineScope;", "Lkotlin/coroutines/experimental/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroid/support/v7/widget/SearchView;Lkotlin/coroutines/experimental/CoroutineContext;ZLkotlin/jvm/functions/Function2;)V", "onDismiss", "Landroidx/appcompat/widget/ActivityChooserView;", "(Landroid/support/v7/widget/ActivityChooserView;Lkotlin/coroutines/experimental/CoroutineContext;Lkotlin/jvm/functions/Function2;)V", "onFitSystemWindows", "Landroidx/appcompat/widget/FitWindowsFrameLayout;", "Lkotlin/Function3;", "Landroid/graphics/Rect;", "Lkotlin/ParameterName;", SerializableCookie.NAME, "insets", "(Landroid/support/v7/widget/FitWindowsFrameLayout;Lkotlin/coroutines/experimental/CoroutineContext;Lkotlin/jvm/functions/Function3;)V", "onInflate", "Landroidx/appcompat/widget/ViewStubCompat;", "Lkotlin/Function4;", "stub", "Landroid/view/View;", "inflated", "(Landroid/support/v7/widget/ViewStubCompat;Lkotlin/coroutines/experimental/CoroutineContext;Lkotlin/jvm/functions/Function4;)V", "onMenuItemClick", "Landroidx/appcompat/widget/ActionMenuView;", "Landroid/view/MenuItem;", "item", "(Landroid/support/v7/widget/ActionMenuView;Lkotlin/coroutines/experimental/CoroutineContext;ZLkotlin/jvm/functions/Function3;)V", "Landroidx/appcompat/widget/Toolbar;", "(Landroid/support/v7/widget/Toolbar;Lkotlin/coroutines/experimental/CoroutineContext;ZLkotlin/jvm/functions/Function3;)V", "onQueryTextFocusChange", "v", "hasFocus", "(Landroid/support/v7/widget/SearchView;Lkotlin/coroutines/experimental/CoroutineContext;Lkotlin/jvm/functions/Function4;)V", "onQueryTextListener", "init", "Lkotlin/Function1;", "Lorg/jetbrains/anko/appcompat/v7/coroutines/__SearchView_OnQueryTextListener;", "onSearchClick", "(Landroid/support/v7/widget/SearchView;Lkotlin/coroutines/experimental/CoroutineContext;Lkotlin/jvm/functions/Function3;)V", "onSuggestionListener", "Lorg/jetbrains/anko/appcompat/v7/coroutines/__SearchView_OnSuggestionListener;", "anko-appcompat-v7-coroutines_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: ListenersWithCoroutines.kt */
public final class AppcompatV7CoroutinesListenersWithCoroutinesKt {
    public static /* bridge */ /* synthetic */ void onMenuItemClick$default(ActionMenuView actionMenuView, CoroutineContext coroutineContext, boolean z, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = HandlerContextKt.getUI();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        onMenuItemClick(actionMenuView, coroutineContext, z, function3);
    }

    public static final void onMenuItemClick(ActionMenuView actionMenuView, CoroutineContext coroutineContext, boolean z, Function3<? super CoroutineScope, ? super MenuItem, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(actionMenuView, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        actionMenuView.setOnMenuItemClickListener(new AppcompatV7CoroutinesListenersWithCoroutinesKt$onMenuItemClick$1(coroutineContext, function3, z));
    }

    public static /* bridge */ /* synthetic */ void onDismiss$default(ActivityChooserView activityChooserView, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = HandlerContextKt.getUI();
        }
        onDismiss(activityChooserView, coroutineContext, function2);
    }

    public static final void onDismiss(ActivityChooserView activityChooserView, CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(activityChooserView, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "handler");
        activityChooserView.setOnDismissListener(new AppcompatV7CoroutinesListenersWithCoroutinesKt$onDismiss$1(coroutineContext, function2));
    }

    public static /* bridge */ /* synthetic */ void onFitSystemWindows$default(FitWindowsFrameLayout fitWindowsFrameLayout, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = HandlerContextKt.getUI();
        }
        onFitSystemWindows(fitWindowsFrameLayout, coroutineContext, function3);
    }

    public static final void onFitSystemWindows(FitWindowsFrameLayout fitWindowsFrameLayout, CoroutineContext coroutineContext, Function3<? super CoroutineScope, ? super Rect, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(fitWindowsFrameLayout, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        fitWindowsFrameLayout.setOnFitSystemWindowsListener(new AppcompatV7CoroutinesListenersWithCoroutinesKt$onFitSystemWindows$1(coroutineContext, function3));
    }

    public static /* bridge */ /* synthetic */ void onClose$default(SearchView searchView, CoroutineContext coroutineContext, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = HandlerContextKt.getUI();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        onClose(searchView, coroutineContext, z, function2);
    }

    public static final void onClose(SearchView searchView, CoroutineContext coroutineContext, boolean z, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(searchView, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function2, "handler");
        searchView.setOnCloseListener(new AppcompatV7CoroutinesListenersWithCoroutinesKt$onClose$1(coroutineContext, function2, z));
    }

    public static /* bridge */ /* synthetic */ void onQueryTextFocusChange$default(SearchView searchView, CoroutineContext coroutineContext, Function4 function4, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = HandlerContextKt.getUI();
        }
        onQueryTextFocusChange(searchView, coroutineContext, function4);
    }

    public static final void onQueryTextFocusChange(SearchView searchView, CoroutineContext coroutineContext, Function4<? super CoroutineScope, ? super View, ? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkParameterIsNotNull(searchView, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function4, "handler");
        searchView.setOnQueryTextFocusChangeListener(new AppcompatV7CoroutinesListenersWithCoroutinesKt$onQueryTextFocusChange$1(coroutineContext, function4));
    }

    public static /* bridge */ /* synthetic */ void onQueryTextListener$default(SearchView searchView, CoroutineContext coroutineContext, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = HandlerContextKt.getUI();
        }
        onQueryTextListener(searchView, coroutineContext, function1);
    }

    public static final void onQueryTextListener(SearchView searchView, CoroutineContext coroutineContext, Function1<? super __SearchView_OnQueryTextListener, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(searchView, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        __SearchView_OnQueryTextListener __searchview_onquerytextlistener = new __SearchView_OnQueryTextListener(coroutineContext);
        function1.invoke(__searchview_onquerytextlistener);
        searchView.setOnQueryTextListener(__searchview_onquerytextlistener);
    }

    public static /* bridge */ /* synthetic */ void onSearchClick$default(SearchView searchView, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = HandlerContextKt.getUI();
        }
        onSearchClick(searchView, coroutineContext, function3);
    }

    public static final void onSearchClick(SearchView searchView, CoroutineContext coroutineContext, Function3<? super CoroutineScope, ? super View, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(searchView, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        searchView.setOnSearchClickListener(new AppcompatV7CoroutinesListenersWithCoroutinesKt$onSearchClick$1(coroutineContext, function3));
    }

    public static /* bridge */ /* synthetic */ void onSuggestionListener$default(SearchView searchView, CoroutineContext coroutineContext, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = HandlerContextKt.getUI();
        }
        onSuggestionListener(searchView, coroutineContext, function1);
    }

    public static final void onSuggestionListener(SearchView searchView, CoroutineContext coroutineContext, Function1<? super __SearchView_OnSuggestionListener, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(searchView, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        __SearchView_OnSuggestionListener __searchview_onsuggestionlistener = new __SearchView_OnSuggestionListener(coroutineContext);
        function1.invoke(__searchview_onsuggestionlistener);
        searchView.setOnSuggestionListener(__searchview_onsuggestionlistener);
    }

    public static /* bridge */ /* synthetic */ void onMenuItemClick$default(Toolbar toolbar, CoroutineContext coroutineContext, boolean z, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = HandlerContextKt.getUI();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        onMenuItemClick(toolbar, coroutineContext, z, function3);
    }

    public static final void onMenuItemClick(Toolbar toolbar, CoroutineContext coroutineContext, boolean z, Function3<? super CoroutineScope, ? super MenuItem, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(toolbar, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function3, "handler");
        toolbar.setOnMenuItemClickListener(new AppcompatV7CoroutinesListenersWithCoroutinesKt$onMenuItemClick$2(coroutineContext, function3, z));
    }

    public static /* bridge */ /* synthetic */ void onInflate$default(ViewStubCompat viewStubCompat, CoroutineContext coroutineContext, Function4 function4, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = HandlerContextKt.getUI();
        }
        onInflate(viewStubCompat, coroutineContext, function4);
    }

    public static final void onInflate(ViewStubCompat viewStubCompat, CoroutineContext coroutineContext, Function4<? super CoroutineScope, ? super ViewStubCompat, ? super View, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkParameterIsNotNull(viewStubCompat, "$receiver");
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(function4, "handler");
        viewStubCompat.setOnInflateListener(new AppcompatV7CoroutinesListenersWithCoroutinesKt$onInflate$1(coroutineContext, function4));
    }
}
