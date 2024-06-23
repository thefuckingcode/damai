package org.jetbrains.anko.internals;

import android.app.Activity;
import android.app.Service;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import androidx.core.app.NotificationCompat;
import java.io.Serializable;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.text.StringsKt;
import org.jetbrains.anko.AnkoContext;
import org.jetbrains.anko.AnkoContextImpl;
import org.jetbrains.anko.AnkoException;
import org.jetbrains.anko.Orientation;
import org.jetbrains.anko.ScreenSize;
import org.jetbrains.anko.UiMode;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002UVB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0005\u001a\u00020\u0006\"\b\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u0002H\u0007¢\u0006\u0002\u0010\fJ%\u0010\u0005\u001a\u00020\u0006\"\b\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u0002H\u0007¢\u0006\u0002\u0010\u000fJ%\u0010\u0005\u001a\u00020\u0006\"\b\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u0002H\u0007¢\u0006\u0002\u0010\u0012J\"\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0016JI\u0010\u0017\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u00072\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u001a2\u001c\u0010\u001b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d0\u001cH\u0007¢\u0006\u0002\u0010\u001eJ3\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00182\u001c\u0010\u001b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d0\u001cH\u0003¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J-\u0010#\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00070\u001aH\u0007¢\u0006\u0002\u0010%JC\u0010&\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u001a2\u001c\u0010\u001b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d0\u001cH\u0007¢\u0006\u0002\u0010'JK\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\n2\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u001a2\u0006\u0010*\u001a\u00020+2\u001c\u0010\u001b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d0\u001cH\u0007¢\u0006\u0002\u0010,JE\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u0002000\u001a2\u001c\u0010\u001b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d0\u001cH\u0007¢\u0006\u0002\u00101JC\u00102\u001a\u0002032\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u0002000\u001a2\u001c\u0010\u001b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001d0\u001cH\u0007¢\u0006\u0002\u00104J\u0006\u00105\u001a\u000206J\u0001\u00107\u001a\u0002032\u0006\u0010\r\u001a\u00020\u000e2\b\u00108\u001a\u0004\u0018\u0001092\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010\u00042\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010?\u001a\u0004\u0018\u0001032\b\u0010@\u001a\u0004\u0018\u00010+2\b\u0010A\u001a\u0004\u0018\u00010+2\b\u0010B\u001a\u0004\u0018\u00010C2\b\u0010D\u001a\u0004\u0018\u0001032\b\u0010E\u001a\u0004\u0018\u0001032\b\u0010F\u001a\u0004\u0018\u00010+H\u0007¢\u0006\u0002\u0010GJ0\u0010H\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010I\u001a\u00020J2\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u0002H\u00070\u0016H\b¢\u0006\u0002\u0010LJ\u0016\u0010M\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020+JO\u0010O\u001a\b\u0012\u0004\u0012\u0002H\u00070P\"\u0004\b\u0000\u0010\u0007*\u0002H\u00072\u0006\u0010\r\u001a\u00020\u000e2\u001d\u0010Q\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070P\u0012\u0004\u0012\u00020\u00060\u0016¢\u0006\u0002\bR2\b\b\u0002\u0010S\u001a\u000203H\b¢\u0006\u0002\u0010TR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lorg/jetbrains/anko/internals/AnkoInternals;", "", "()V", "NO_GETTER", "", "addView", "", "T", "Landroid/view/View;", "activity", "Landroid/app/Activity;", "view", "(Landroid/app/Activity;Landroid/view/View;)V", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;Landroid/view/View;)V", "manager", "Landroid/view/ViewManager;", "(Landroid/view/ViewManager;Landroid/view/View;)V", "applyRecursively", "v", "style", "Lkotlin/Function1;", "createIntent", "Landroid/content/Intent;", "clazz", "Ljava/lang/Class;", "params", "", "Lkotlin/Pair;", "(Landroid/content/Context;Ljava/lang/Class;[Lkotlin/Pair;)Landroid/content/Intent;", "fillIntentArguments", "intent", "(Landroid/content/Intent;[Lkotlin/Pair;)V", "getContext", "initiateView", "viewClass", "(Landroid/content/Context;Ljava/lang/Class;)Landroid/view/View;", "internalStartActivity", "(Landroid/content/Context;Ljava/lang/Class;[Lkotlin/Pair;)V", "internalStartActivityForResult", "act", "requestCode", "", "(Landroid/app/Activity;Ljava/lang/Class;I[Lkotlin/Pair;)V", "internalStartService", "Landroid/content/ComponentName;", NotificationCompat.CATEGORY_SERVICE, "Landroid/app/Service;", "(Landroid/content/Context;Ljava/lang/Class;[Lkotlin/Pair;)Landroid/content/ComponentName;", "internalStopService", "", "(Landroid/content/Context;Ljava/lang/Class;[Lkotlin/Pair;)Z", "noGetter", "", "testConfiguration", "screenSize", "Lorg/jetbrains/anko/ScreenSize;", "density", "Lkotlin/ranges/ClosedRange;", "language", "orientation", "Lorg/jetbrains/anko/Orientation;", "long", "fromSdk", "sdk", "uiMode", "Lorg/jetbrains/anko/UiMode;", "nightMode", "rightToLeft", "smallestWidth", "(Landroid/content/Context;Lorg/jetbrains/anko/ScreenSize;Lkotlin/ranges/ClosedRange;Ljava/lang/String;Lorg/jetbrains/anko/Orientation;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lorg/jetbrains/anko/UiMode;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)Z", "useCursor", "cursor", "Landroid/database/Cursor;", "f", "(Landroid/database/Cursor;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "wrapContextIfNeeded", "theme", "createAnkoContext", "Lorg/jetbrains/anko/AnkoContext;", "init", "Lkotlin/ExtensionFunctionType;", "setContentView", "(Ljava/lang/Object;Landroid/content/Context;Lkotlin/jvm/functions/Function1;Z)Lorg/jetbrains/anko/AnkoContext;", "AnkoContextThemeWrapper", "InternalConfiguration", "commons-base_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: Internals.kt */
public final class AnkoInternals {
    public static final AnkoInternals INSTANCE = new AnkoInternals();
    public static final String NO_GETTER = "Property does not have a getter";

    private AnkoInternals() {
    }

    public final Void noGetter() {
        throw new AnkoException(NO_GETTER);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lorg/jetbrains/anko/internals/AnkoInternals$AnkoContextThemeWrapper;", "Landroid/view/ContextThemeWrapper;", "base", "Landroid/content/Context;", "theme", "", "(Landroid/content/Context;I)V", "getTheme", "()I", "commons-base_release"}, k = 1, mv = {1, 1, 11})
    /* compiled from: Internals.kt */
    private static final class AnkoContextThemeWrapper extends ContextThemeWrapper {
        private final int theme;

        public AnkoContextThemeWrapper(Context context, int i) {
            super(context, i);
            this.theme = i;
        }

        public final int getTheme() {
            return this.theme;
        }
    }

    public final <T extends View> void addView(ViewManager viewManager, T t) {
        Intrinsics.checkParameterIsNotNull(viewManager, "manager");
        Intrinsics.checkParameterIsNotNull(t, "view");
        if (viewManager instanceof ViewGroup) {
            ((ViewGroup) viewManager).addView(t);
        } else if (viewManager instanceof AnkoContext) {
            viewManager.addView(t, null);
        } else {
            throw new AnkoException(viewManager + " is the wrong parent");
        }
    }

    public final Context wrapContextIfNeeded(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        if (i != 0) {
            return (!(context instanceof AnkoContextThemeWrapper) || ((AnkoContextThemeWrapper) context).getTheme() != i) ? new AnkoContextThemeWrapper(context, i) : context;
        }
        return context;
    }

    public final void applyRecursively(View view, Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        Intrinsics.checkParameterIsNotNull(function1, "style");
        function1.invoke(view);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount() - 1;
            int i = 0;
            if (childCount >= 0) {
                while (true) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt != null) {
                        INSTANCE.applyRecursively(childAt, function1);
                    }
                    if (i != childCount) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public final Context getContext(ViewManager viewManager) {
        Intrinsics.checkParameterIsNotNull(viewManager, "manager");
        if (viewManager instanceof ViewGroup) {
            Context context = ((ViewGroup) viewManager).getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "manager.context");
            return context;
        } else if (viewManager instanceof AnkoContext) {
            return ((AnkoContext) viewManager).getCtx();
        } else {
            throw new AnkoException(viewManager + " is the wrong parent");
        }
    }

    public static /* bridge */ /* synthetic */ AnkoContext createAnkoContext$default(AnkoInternals ankoInternals, Object obj, Context context, Function1 function1, boolean z, int i, Object obj2) {
        if ((i & 4) != 0) {
            z = false;
        }
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        AnkoContextImpl ankoContextImpl = new AnkoContextImpl(context, obj, z);
        function1.invoke(ankoContextImpl);
        return ankoContextImpl;
    }

    public final <T> AnkoContext<T> createAnkoContext(T t, Context context, Function1<? super AnkoContext<? extends T>, Unit> function1, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        AnkoContextImpl ankoContextImpl = new AnkoContextImpl(context, t, z);
        function1.invoke(ankoContextImpl);
        return ankoContextImpl;
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lorg/jetbrains/anko/internals/AnkoInternals$InternalConfiguration;", "", "()V", "SCREENLAYOUT_LAYOUTDIR_MASK", "", "getSCREENLAYOUT_LAYOUTDIR_MASK", "()I", "SCREENLAYOUT_LAYOUTDIR_RTL", "getSCREENLAYOUT_LAYOUTDIR_RTL", "SCREENLAYOUT_LAYOUTDIR_SHIFT", "getSCREENLAYOUT_LAYOUTDIR_SHIFT", "UI_MODE_TYPE_APPLIANCE", "getUI_MODE_TYPE_APPLIANCE", "UI_MODE_TYPE_WATCH", "getUI_MODE_TYPE_WATCH", "commons-base_release"}, k = 1, mv = {1, 1, 11})
    /* compiled from: Internals.kt */
    private static final class InternalConfiguration {
        public static final InternalConfiguration INSTANCE = new InternalConfiguration();
        private static final int SCREENLAYOUT_LAYOUTDIR_MASK = SCREENLAYOUT_LAYOUTDIR_MASK;
        private static final int SCREENLAYOUT_LAYOUTDIR_RTL = (2 << 6);
        private static final int SCREENLAYOUT_LAYOUTDIR_SHIFT = 6;
        private static final int UI_MODE_TYPE_APPLIANCE = 5;
        private static final int UI_MODE_TYPE_WATCH = 6;

        private InternalConfiguration() {
        }

        public final int getSCREENLAYOUT_LAYOUTDIR_MASK() {
            return SCREENLAYOUT_LAYOUTDIR_MASK;
        }

        public final int getSCREENLAYOUT_LAYOUTDIR_SHIFT() {
            return SCREENLAYOUT_LAYOUTDIR_SHIFT;
        }

        public final int getSCREENLAYOUT_LAYOUTDIR_RTL() {
            return SCREENLAYOUT_LAYOUTDIR_RTL;
        }

        public final int getUI_MODE_TYPE_APPLIANCE() {
            return UI_MODE_TYPE_APPLIANCE;
        }

        public final int getUI_MODE_TYPE_WATCH() {
            return UI_MODE_TYPE_WATCH;
        }
    }

    @JvmStatic
    public static final <T> Intent createIntent(Context context, Class<? extends T> cls, Pair<String, ? extends Object>[] pairArr) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(cls, "clazz");
        Intrinsics.checkParameterIsNotNull(pairArr, "params");
        Intent intent = new Intent(context, cls);
        if (!(pairArr.length == 0)) {
            fillIntentArguments(intent, pairArr);
        }
        return intent;
    }

    @JvmStatic
    public static final void internalStartActivity(Context context, Class<? extends Activity> cls, Pair<String, ? extends Object>[] pairArr) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(cls, "activity");
        Intrinsics.checkParameterIsNotNull(pairArr, "params");
        context.startActivity(createIntent(context, cls, pairArr));
    }

    @JvmStatic
    public static final void internalStartActivityForResult(Activity activity, Class<? extends Activity> cls, int i, Pair<String, ? extends Object>[] pairArr) {
        Intrinsics.checkParameterIsNotNull(activity, "act");
        Intrinsics.checkParameterIsNotNull(cls, "activity");
        Intrinsics.checkParameterIsNotNull(pairArr, "params");
        activity.startActivityForResult(createIntent(activity, cls, pairArr), i);
    }

    @JvmStatic
    public static final ComponentName internalStartService(Context context, Class<? extends Service> cls, Pair<String, ? extends Object>[] pairArr) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(cls, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkParameterIsNotNull(pairArr, "params");
        return context.startService(createIntent(context, cls, pairArr));
    }

    @JvmStatic
    public static final boolean internalStopService(Context context, Class<? extends Service> cls, Pair<String, ? extends Object>[] pairArr) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(cls, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkParameterIsNotNull(pairArr, "params");
        return context.stopService(createIntent(context, cls, pairArr));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlin.io.CloseableKt.closeFinally(r3, r4);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        r0 = move-exception;
     */
    @JvmStatic
    public static final <T> T useCursor(Cursor cursor, Function1<? super Cursor, ? extends T> function1) {
        T t;
        Intrinsics.checkParameterIsNotNull(cursor, "cursor");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        if (Build.VERSION.SDK_INT >= 16) {
            Cursor cursor2 = cursor;
            Throwable th = null;
            t = (T) function1.invoke(cursor2);
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(cursor2, th);
            InlineMarker.finallyEnd(1);
        } else {
            try {
                t = (T) function1.invoke(cursor);
            } finally {
                InlineMarker.finallyStart(1);
                try {
                    cursor.close();
                } catch (Exception unused) {
                }
                InlineMarker.finallyEnd(1);
            }
        }
        return t;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        r5 = r1.invoke().newInstance(r5, null);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, "getConstructor2().newInstance(ctx, null)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0041, code lost:
        return (T) ((android.view.View) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0063, code lost:
        throw new org.jetbrains.anko.AnkoException("Can't initiate View of class " + r6.getName() + ": can't find proper constructor");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x002a */
    @JvmStatic
    public static final <T extends View> T initiateView(Context context, Class<T> cls) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(cls, "viewClass");
        AnkoInternals$initiateView$1 ankoInternals$initiateView$1 = new AnkoInternals$initiateView$1(cls);
        AnkoInternals$initiateView$2 ankoInternals$initiateView$2 = new AnkoInternals$initiateView$2(cls);
        Object newInstance = ankoInternals$initiateView$1.invoke().newInstance(context);
        Intrinsics.checkExpressionValueIsNotNull(newInstance, "getConstructor1().newInstance(ctx)");
        return (T) ((View) newInstance);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:123:0x015d, code lost:
        if (r29.booleanValue() != false) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0071, code lost:
        if (r1 != r22.getEndInclusive().intValue()) goto L_0x0074;
     */
    @JvmStatic
    public static final boolean testConfiguration(Context context, ScreenSize screenSize, ClosedRange<Integer> closedRange, String str, Orientation orientation, Boolean bool, Integer num, Integer num2, UiMode uiMode, Boolean bool2, Boolean bool3, Integer num3) {
        int nightMode;
        String str2;
        DisplayMetrics displayMetrics;
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Resources resources = context.getResources();
        UiModeManager uiModeManager = null;
        Configuration configuration = resources != null ? resources.getConfiguration() : null;
        if (screenSize != null) {
            if (configuration == null) {
                return false;
            }
            int i = configuration.screenLayout & 15;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4 && screenSize != ScreenSize.XLARGE) {
                            return false;
                        }
                    } else if (screenSize != ScreenSize.LARGE) {
                        return false;
                    }
                } else if (screenSize != ScreenSize.NORMAL) {
                    return false;
                }
            } else if (screenSize != ScreenSize.SMALL) {
                return false;
            }
        }
        if (closedRange != null) {
            Resources resources2 = context.getResources();
            if (!(resources2 == null || (displayMetrics = resources2.getDisplayMetrics()) == null)) {
                int i2 = displayMetrics.densityDpi;
                if (closedRange.contains(Integer.valueOf(i2))) {
                }
            }
            return false;
        }
        if (str != null) {
            Locale locale = Locale.getDefault();
            if (StringsKt.indexOf$default((CharSequence) str, '_', 0, false, 6, (Object) null) >= 0) {
                str2 = locale.toString();
            } else {
                Intrinsics.checkExpressionValueIsNotNull(locale, "locale");
                str2 = locale.getLanguage();
            }
            if (!Intrinsics.areEqual(str2, str)) {
                return false;
            }
        }
        if (orientation != null) {
            if (configuration == null) {
                return false;
            }
            int i3 = configuration.orientation;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3 && orientation != Orientation.SQUARE) {
                        return false;
                    }
                } else if (orientation != Orientation.LANDSCAPE) {
                    return false;
                }
            } else if (orientation != Orientation.PORTRAIT) {
                return false;
            }
        }
        if (bool != null) {
            if (configuration == null) {
                return false;
            }
            int i4 = configuration.screenLayout & 48;
            if (i4 == 32 && !bool.booleanValue()) {
                return false;
            }
            if (i4 == 16 && bool.booleanValue()) {
                return false;
            }
        }
        if (num != null && Intrinsics.compare(Build.VERSION.SDK_INT, num.intValue()) < 0) {
            return false;
        }
        if (num2 != null && Build.VERSION.SDK_INT != num2.intValue()) {
            return false;
        }
        if (uiMode != null) {
            if (configuration == null) {
                return false;
            }
            int i5 = configuration.uiMode & 15;
            if (i5 == 1) {
                if (uiMode != UiMode.NORMAL) {
                    return false;
                }
            } else if (i5 == 2) {
                if (uiMode != UiMode.DESK) {
                    return false;
                }
            } else if (i5 == 3) {
                if (uiMode != UiMode.CAR) {
                    return false;
                }
            } else if (i5 == 4) {
                if (uiMode != UiMode.TELEVISION) {
                    return false;
                }
            } else if (i5 == InternalConfiguration.INSTANCE.getUI_MODE_TYPE_APPLIANCE()) {
                if (uiMode != UiMode.APPLIANCE) {
                    return false;
                }
            } else if (i5 == InternalConfiguration.INSTANCE.getUI_MODE_TYPE_WATCH() && uiMode != UiMode.WATCH) {
                return false;
            }
        }
        if (bool2 != null) {
            Object systemService = context.getSystemService("uimode");
            if (systemService instanceof UiModeManager) {
                uiModeManager = systemService;
            }
            UiModeManager uiModeManager2 = uiModeManager;
            if (uiModeManager2 == null || ((nightMode = uiModeManager2.getNightMode()) == 2 && !bool2.booleanValue())) {
                return false;
            }
            if (nightMode == 1) {
            }
        }
        if (bool3 != null) {
            if (configuration == null) {
                return false;
            }
            if (!Intrinsics.areEqual(Boolean.valueOf((configuration.screenLayout & InternalConfiguration.INSTANCE.getSCREENLAYOUT_LAYOUTDIR_MASK()) == InternalConfiguration.INSTANCE.getSCREENLAYOUT_LAYOUTDIR_RTL()), bool3)) {
                return false;
            }
        }
        if (num3 != null) {
            if (configuration == null) {
                return false;
            }
            if (configuration.smallestScreenWidthDp == 0) {
                if (num3.intValue() != 0) {
                    return false;
                }
            } else if (Intrinsics.compare(configuration.smallestScreenWidthDp, num3.intValue()) < 0) {
                return false;
            }
        }
        return true;
    }

    public final <T extends View> void addView(Context context, T t) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        Intrinsics.checkParameterIsNotNull(t, "view");
        INSTANCE.addView(new AnkoContextImpl(context, context, false), t);
    }

    public final <T extends View> void addView(Activity activity, T t) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(t, "view");
        INSTANCE.addView(new AnkoContextImpl(activity, this, true), t);
    }

    @JvmStatic
    private static final void fillIntentArguments(Intent intent, Pair<String, ? extends Object>[] pairArr) {
        for (Pair<String, ? extends Object> pair : pairArr) {
            Object second = pair.getSecond();
            if (second == null) {
                intent.putExtra(pair.getFirst(), (Serializable) null);
            } else if (second instanceof Integer) {
                intent.putExtra(pair.getFirst(), ((Number) second).intValue());
            } else if (second instanceof Long) {
                intent.putExtra(pair.getFirst(), ((Number) second).longValue());
            } else if (second instanceof CharSequence) {
                intent.putExtra(pair.getFirst(), (CharSequence) second);
            } else if (second instanceof String) {
                intent.putExtra(pair.getFirst(), (String) second);
            } else if (second instanceof Float) {
                intent.putExtra(pair.getFirst(), ((Number) second).floatValue());
            } else if (second instanceof Double) {
                intent.putExtra(pair.getFirst(), ((Number) second).doubleValue());
            } else if (second instanceof Character) {
                intent.putExtra(pair.getFirst(), ((Character) second).charValue());
            } else if (second instanceof Short) {
                intent.putExtra(pair.getFirst(), ((Number) second).shortValue());
            } else if (second instanceof Boolean) {
                intent.putExtra(pair.getFirst(), ((Boolean) second).booleanValue());
            } else if (second instanceof Serializable) {
                intent.putExtra(pair.getFirst(), (Serializable) second);
            } else if (second instanceof Bundle) {
                intent.putExtra(pair.getFirst(), (Bundle) second);
            } else if (second instanceof Parcelable) {
                intent.putExtra(pair.getFirst(), (Parcelable) second);
            } else if (second instanceof Object[]) {
                Object[] objArr = (Object[]) second;
                if (objArr instanceof CharSequence[]) {
                    intent.putExtra(pair.getFirst(), (Serializable) second);
                } else if (objArr instanceof String[]) {
                    intent.putExtra(pair.getFirst(), (Serializable) second);
                } else if (objArr instanceof Parcelable[]) {
                    intent.putExtra(pair.getFirst(), (Serializable) second);
                } else {
                    throw new AnkoException("Intent extra " + pair.getFirst() + " has wrong type " + objArr.getClass().getName());
                }
            } else if (second instanceof int[]) {
                intent.putExtra(pair.getFirst(), (int[]) second);
            } else if (second instanceof long[]) {
                intent.putExtra(pair.getFirst(), (long[]) second);
            } else if (second instanceof float[]) {
                intent.putExtra(pair.getFirst(), (float[]) second);
            } else if (second instanceof double[]) {
                intent.putExtra(pair.getFirst(), (double[]) second);
            } else if (second instanceof char[]) {
                intent.putExtra(pair.getFirst(), (char[]) second);
            } else if (second instanceof short[]) {
                intent.putExtra(pair.getFirst(), (short[]) second);
            } else if (second instanceof boolean[]) {
                intent.putExtra(pair.getFirst(), (boolean[]) second);
            } else {
                throw new AnkoException("Intent extra " + pair.getFirst() + " has wrong type " + second.getClass().getName());
            }
        }
    }
}
