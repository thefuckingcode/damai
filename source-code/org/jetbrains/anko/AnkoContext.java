package org.jetbrains.anko;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u0013*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0001\u0013J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lorg/jetbrains/anko/AnkoContext;", "T", "Landroid/view/ViewManager;", "ctx", "Landroid/content/Context;", "getCtx", "()Landroid/content/Context;", "owner", "getOwner", "()Ljava/lang/Object;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "removeView", "", "updateViewLayout", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "commons-base_release"}, k = 1, mv = {1, 1, 11})
@AnkoContextDslMarker
/* compiled from: AnkoContext.kt */
public interface AnkoContext<T> extends ViewManager {
    public static final Companion Companion = Companion.$$INSTANCE;

    Context getCtx();

    T getOwner();

    View getView();

    void removeView(View view);

    void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams);

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 11})
    /* compiled from: AnkoContext.kt */
    public static final class DefaultImpls {
        public static <T> void updateViewLayout(AnkoContext<? extends T> ankoContext, View view, ViewGroup.LayoutParams layoutParams) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            Intrinsics.checkParameterIsNotNull(layoutParams, "params");
            throw new UnsupportedOperationException();
        }

        public static <T> void removeView(AnkoContext<? extends T> ankoContext, View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            throw new UnsupportedOperationException();
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u0002H\u00052\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nJ#\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\r2\u0006\u0010\b\u001a\u0002H\u0005¢\u0006\u0002\u0010\u000eJ1\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u0002H\u00052\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n¨\u0006\u0010"}, d2 = {"Lorg/jetbrains/anko/AnkoContext$Companion;", "", "()V", "create", "Lorg/jetbrains/anko/AnkoContext;", "T", "ctx", "Landroid/content/Context;", "owner", "setContentView", "", "(Landroid/content/Context;Ljava/lang/Object;Z)Lorg/jetbrains/anko/AnkoContext;", "createDelegate", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)Lorg/jetbrains/anko/AnkoContext;", "createReusable", "commons-base_release"}, k = 1, mv = {1, 1, 11})
    /* compiled from: AnkoContext.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* bridge */ /* synthetic */ AnkoContext create$default(Companion companion, Context context, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.create(context, z);
        }

        public final AnkoContext<Context> create(Context context, boolean z) {
            Intrinsics.checkParameterIsNotNull(context, "ctx");
            return new AnkoContextImpl(context, context, z);
        }

        public static /* bridge */ /* synthetic */ AnkoContext createReusable$default(Companion companion, Context context, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.createReusable(context, z);
        }

        public final AnkoContext<Context> createReusable(Context context, boolean z) {
            Intrinsics.checkParameterIsNotNull(context, "ctx");
            return new ReusableAnkoContext(context, context, z);
        }

        public static /* bridge */ /* synthetic */ AnkoContext create$default(Companion companion, Context context, Object obj, boolean z, int i, Object obj2) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.create(context, obj, z);
        }

        public final <T> AnkoContext<T> create(Context context, T t, boolean z) {
            Intrinsics.checkParameterIsNotNull(context, "ctx");
            return new AnkoContextImpl(context, t, z);
        }

        public static /* bridge */ /* synthetic */ AnkoContext createReusable$default(Companion companion, Context context, Object obj, boolean z, int i, Object obj2) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.createReusable(context, obj, z);
        }

        public final <T> AnkoContext<T> createReusable(Context context, T t, boolean z) {
            Intrinsics.checkParameterIsNotNull(context, "ctx");
            return new ReusableAnkoContext(context, t, z);
        }

        public final <T extends ViewGroup> AnkoContext<T> createDelegate(T t) {
            Intrinsics.checkParameterIsNotNull(t, "owner");
            return new DelegatingAnkoContext(t);
        }
    }
}
