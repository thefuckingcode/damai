package org.jetbrains.anko;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.AnkoContext;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lorg/jetbrains/anko/DelegatingAnkoContext;", "T", "Landroid/view/ViewGroup;", "Lorg/jetbrains/anko/AnkoContext;", "owner", "(Landroid/view/ViewGroup;)V", "ctx", "Landroid/content/Context;", "getCtx", "()Landroid/content/Context;", "getOwner", "()Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "addView", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "commons-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: AnkoContext.kt */
public final class DelegatingAnkoContext<T extends ViewGroup> implements AnkoContext<T> {
    private final Context ctx;
    private final T owner;
    private final View view = getOwner();

    public DelegatingAnkoContext(T t) {
        Intrinsics.checkParameterIsNotNull(t, "owner");
        this.owner = t;
        Context context = getOwner().getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "owner.context");
        this.ctx = context;
    }

    @Override // org.jetbrains.anko.AnkoContext
    public T getOwner() {
        return this.owner;
    }

    @Override // org.jetbrains.anko.AnkoContext
    public void removeView(View view2) {
        Intrinsics.checkParameterIsNotNull(view2, "view");
        AnkoContext.DefaultImpls.removeView(this, view2);
    }

    @Override // org.jetbrains.anko.AnkoContext
    public void updateViewLayout(View view2, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(view2, "view");
        Intrinsics.checkParameterIsNotNull(layoutParams, "params");
        AnkoContext.DefaultImpls.updateViewLayout(this, view2, layoutParams);
    }

    @Override // org.jetbrains.anko.AnkoContext
    public Context getCtx() {
        return this.ctx;
    }

    @Override // org.jetbrains.anko.AnkoContext
    public View getView() {
        return this.view;
    }

    public void addView(View view2, ViewGroup.LayoutParams layoutParams) {
        if (view2 != null) {
            if (layoutParams == null) {
                getOwner().addView(view2);
            } else {
                getOwner().addView(view2, layoutParams);
            }
        }
    }
}
