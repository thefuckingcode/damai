package org.jetbrains.anko;

import android.app.Activity;
import android.app.Fragment;
import android.app.Service;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.tencent.smtt.sdk.WebView;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.internals.AnkoInternals;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000V\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\b\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001\u001a#\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\b\u001a\r\u0010\b\u001a\u00020\t*\u00020\tH\b\u001a\r\u0010\n\u001a\u00020\t*\u00020\tH\b\u001a\r\u0010\u000b\u001a\u00020\t*\u00020\tH\b\u001a)\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u0004H\b\u001a&\u0010\f\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u001a-\u0010\f\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u0004H\b\u001a\r\u0010\u000f\u001a\u00020\t*\u00020\tH\b\u001aN\u0010\u0010\u001a\u00020\t\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020\u0012*\u00020\u00022.\u0010\u0013\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00150\u0014\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0015H\b¢\u0006\u0002\u0010\u0016\u001aN\u0010\u0010\u001a\u00020\t\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020\u0012*\u00020\u00062.\u0010\u0013\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00150\u0014\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0015H\b¢\u0006\u0002\u0010\u0017\u001aR\u0010\u0010\u001a\u00020\t\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020\u0012*\u0006\u0012\u0002\b\u00030\u00072.\u0010\u0013\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00150\u0014\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0015H\b¢\u0006\u0002\u0010\u0018\u001a\u0015\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0004H\b\u001a\u0012\u0010\u0019\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0004\u001a\u0019\u0010\u0019\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u001a\u001a\u00020\u0004H\b\u001a\r\u0010\u001b\u001a\u00020\t*\u00020\tH\b\u001a\r\u0010\u001c\u001a\u00020\t*\u00020\tH\b\u001a\r\u0010\u0005\u001a\u00020\t*\u00020\tH\b\u001a\r\u0010\u001d\u001a\u00020\t*\u00020\tH\b\u001a\r\u0010\u001e\u001a\u00020\t*\u00020\tH\b\u001a\u001f\u0010\u001f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u0004H\b\u001a\u001c\u0010\u001f\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u001a#\u0010\u001f\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u0004H\b\u001a\u001f\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u0004H\b\u001a\u001c\u0010 \u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u0004\u001a#\u0010 \u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u0004H\b\u001a\r\u0010!\u001a\u00020\t*\u00020\tH\b\u001aN\u0010\"\u001a\u00020#\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020$*\u00020\u00022.\u0010\u0013\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00150\u0014\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0015H\b¢\u0006\u0002\u0010%\u001aN\u0010\"\u001a\u00020#\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020$*\u00020\u00062.\u0010\u0013\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00150\u0014\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0015H\b¢\u0006\u0002\u0010&\u001aR\u0010\"\u001a\u00020#\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020$*\u0006\u0012\u0002\b\u00030\u00072.\u0010\u0013\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00150\u0014\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0015H\b¢\u0006\u0002\u0010'\u001aV\u0010(\u001a\u00020#\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020$*\u00020$2\u0006\u0010)\u001a\u00020*2.\u0010\u0013\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00150\u0014\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0015H\b¢\u0006\u0002\u0010+\u001aV\u0010(\u001a\u00020#\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020$*\u00020\u00022\u0006\u0010)\u001a\u00020*2.\u0010\u0013\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00150\u0014\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0015H\b¢\u0006\u0002\u0010,\u001aP\u0010-\u001a\u0004\u0018\u00010.\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020/*\u00020\u00022.\u0010\u0013\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00150\u0014\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0015H\b¢\u0006\u0002\u00100\u001aP\u0010-\u001a\u0004\u0018\u00010.\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020/*\u00020\u00062.\u0010\u0013\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00150\u0014\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0015H\b¢\u0006\u0002\u00101\u001aT\u0010-\u001a\u0004\u0018\u00010.\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020/*\u0006\u0012\u0002\b\u00030\u00072.\u0010\u0013\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00150\u0014\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0015H\b¢\u0006\u0002\u00102\u001aN\u00103\u001a\u00020\u0001\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020/*\u00020\u00022.\u0010\u0013\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00150\u0014\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0015H\b¢\u0006\u0002\u00104\u001aN\u00103\u001a\u00020\u0001\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020/*\u00020\u00062.\u0010\u0013\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00150\u0014\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0015H\b¢\u0006\u0002\u00105\u001aR\u00103\u001a\u00020\u0001\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020/*\u0006\u0012\u0002\b\u00030\u00072.\u0010\u0013\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00150\u0014\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0015H\b¢\u0006\u0002\u00106¨\u00067"}, d2 = {"browse", "", "Landroid/app/Fragment;", "url", "", "newTask", "Landroid/content/Context;", "Lorg/jetbrains/anko/AnkoContext;", "clearTask", "Landroid/content/Intent;", "clearTop", "clearWhenTaskReset", NotificationCompat.CATEGORY_EMAIL, "subject", "text", "excludeFromRecents", "intentFor", "T", "", "params", "", "Lkotlin/Pair;", "(Landroid/app/Fragment;[Lkotlin/Pair;)Landroid/content/Intent;", "(Landroid/content/Context;[Lkotlin/Pair;)Landroid/content/Intent;", "(Lorg/jetbrains/anko/AnkoContext;[Lkotlin/Pair;)Landroid/content/Intent;", "makeCall", "number", "multipleTask", "newDocument", "noAnimation", "noHistory", "sendSMS", "share", "singleTop", "startActivity", "", "Landroid/app/Activity;", "(Landroid/app/Fragment;[Lkotlin/Pair;)V", "(Landroid/content/Context;[Lkotlin/Pair;)V", "(Lorg/jetbrains/anko/AnkoContext;[Lkotlin/Pair;)V", "startActivityForResult", "requestCode", "", "(Landroid/app/Activity;I[Lkotlin/Pair;)V", "(Landroid/app/Fragment;I[Lkotlin/Pair;)V", "startService", "Landroid/content/ComponentName;", "Landroid/app/Service;", "(Landroid/app/Fragment;[Lkotlin/Pair;)Landroid/content/ComponentName;", "(Landroid/content/Context;[Lkotlin/Pair;)Landroid/content/ComponentName;", "(Lorg/jetbrains/anko/AnkoContext;[Lkotlin/Pair;)Landroid/content/ComponentName;", "stopService", "(Landroid/app/Fragment;[Lkotlin/Pair;)Z", "(Landroid/content/Context;[Lkotlin/Pair;)Z", "(Lorg/jetbrains/anko/AnkoContext;[Lkotlin/Pair;)Z", "commons-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: Intents.kt */
public final class IntentsKt {
    private static final <T extends Activity> void startActivity(Context context, Pair<String, ? extends Object>... pairArr) {
        Intrinsics.reifiedOperationMarker(4, "T");
        AnkoInternals.internalStartActivity(context, Activity.class, pairArr);
    }

    private static final <T extends Activity> void startActivity(AnkoContext<?> ankoContext, Pair<String, ? extends Object>... pairArr) {
        Context ctx = ankoContext.getCtx();
        Intrinsics.reifiedOperationMarker(4, "T");
        AnkoInternals.internalStartActivity(ctx, Activity.class, pairArr);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    private static final <T extends Activity> void startActivity(Fragment fragment, Pair<String, ? extends Object>... pairArr) {
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        Intrinsics.reifiedOperationMarker(4, "T");
        AnkoInternals.internalStartActivity(activity, Activity.class, pairArr);
    }

    private static final <T extends Activity> void startActivityForResult(Activity activity, int i, Pair<String, ? extends Object>... pairArr) {
        Intrinsics.reifiedOperationMarker(4, "T");
        AnkoInternals.internalStartActivityForResult(activity, Activity.class, i, pairArr);
    }

    private static final <T extends Service> ComponentName startService(Context context, Pair<String, ? extends Object>... pairArr) {
        Intrinsics.reifiedOperationMarker(4, "T");
        return AnkoInternals.internalStartService(context, Service.class, pairArr);
    }

    private static final <T extends Service> ComponentName startService(AnkoContext<?> ankoContext, Pair<String, ? extends Object>... pairArr) {
        Context ctx = ankoContext.getCtx();
        Intrinsics.reifiedOperationMarker(4, "T");
        return AnkoInternals.internalStartService(ctx, Service.class, pairArr);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    private static final <T extends Service> ComponentName startService(Fragment fragment, Pair<String, ? extends Object>... pairArr) {
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        Intrinsics.reifiedOperationMarker(4, "T");
        return AnkoInternals.internalStartService(activity, Service.class, pairArr);
    }

    private static final <T extends Service> boolean stopService(Context context, Pair<String, ? extends Object>... pairArr) {
        Intrinsics.reifiedOperationMarker(4, "T");
        return AnkoInternals.internalStopService(context, Service.class, pairArr);
    }

    private static final <T extends Service> boolean stopService(AnkoContext<?> ankoContext, Pair<String, ? extends Object>... pairArr) {
        Context ctx = ankoContext.getCtx();
        Intrinsics.reifiedOperationMarker(4, "T");
        return AnkoInternals.internalStopService(ctx, Service.class, pairArr);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    private static final <T extends Service> boolean stopService(Fragment fragment, Pair<String, ? extends Object>... pairArr) {
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        Intrinsics.reifiedOperationMarker(4, "T");
        return AnkoInternals.internalStopService(activity, Service.class, pairArr);
    }

    private static final <T> Intent intentFor(Context context, Pair<String, ? extends Object>... pairArr) {
        Intrinsics.reifiedOperationMarker(4, "T");
        return AnkoInternals.createIntent(context, Object.class, pairArr);
    }

    private static final <T> Intent intentFor(AnkoContext<?> ankoContext, Pair<String, ? extends Object>... pairArr) {
        Context ctx = ankoContext.getCtx();
        Intrinsics.reifiedOperationMarker(4, "T");
        return AnkoInternals.createIntent(ctx, Object.class, pairArr);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    private static final <T> Intent intentFor(Fragment fragment, Pair<String, ? extends Object>... pairArr) {
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        Intrinsics.reifiedOperationMarker(4, "T");
        return AnkoInternals.createIntent(activity, Object.class, pairArr);
    }

    public static final Intent clearTask(Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "$receiver");
        intent.addFlags(32768);
        return intent;
    }

    public static final Intent clearTop(Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "$receiver");
        intent.addFlags(67108864);
        return intent;
    }

    @Deprecated(message = "Deprecated in Android", replaceWith = @ReplaceWith(expression = "org.jetbrains.anko.newDocument", imports = {}))
    public static final Intent clearWhenTaskReset(Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "$receiver");
        intent.addFlags(524288);
        return intent;
    }

    public static final Intent newDocument(Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "$receiver");
        if (Build.VERSION.SDK_INT >= 21) {
            intent.addFlags(524288);
        } else {
            intent.addFlags(524288);
        }
        return intent;
    }

    public static final Intent excludeFromRecents(Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "$receiver");
        intent.addFlags(8388608);
        return intent;
    }

    public static final Intent multipleTask(Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "$receiver");
        intent.addFlags(134217728);
        return intent;
    }

    public static final Intent newTask(Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "$receiver");
        intent.addFlags(268435456);
        return intent;
    }

    public static final Intent noAnimation(Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "$receiver");
        intent.addFlags(65536);
        return intent;
    }

    public static final Intent noHistory(Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "$receiver");
        intent.addFlags(1073741824);
        return intent;
    }

    public static final Intent singleTop(Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "$receiver");
        intent.addFlags(536870912);
        return intent;
    }

    public static final boolean browse(AnkoContext<?> ankoContext, String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "url");
        return browse(ankoContext.getCtx(), str, z);
    }

    public static /* bridge */ /* synthetic */ boolean browse$default(AnkoContext ankoContext, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "url");
        return browse(ankoContext.getCtx(), str, z);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final boolean browse(Fragment fragment, String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "url");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return browse(activity, str, z);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static /* bridge */ /* synthetic */ boolean browse$default(Fragment fragment, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "url");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return browse(activity, str, z);
    }

    public static /* bridge */ /* synthetic */ boolean browse$default(Context context, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return browse(context, str, z);
    }

    public static final boolean browse(Context context, String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "url");
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            if (z) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static final boolean share(AnkoContext<?> ankoContext, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "text");
        Intrinsics.checkParameterIsNotNull(str2, "subject");
        return share(ankoContext.getCtx(), str, str2);
    }

    public static /* bridge */ /* synthetic */ boolean share$default(AnkoContext ankoContext, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "text");
        Intrinsics.checkParameterIsNotNull(str2, "subject");
        return share(ankoContext.getCtx(), str, str2);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final boolean share(Fragment fragment, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "text");
        Intrinsics.checkParameterIsNotNull(str2, "subject");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return share(activity, str, str2);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static /* bridge */ /* synthetic */ boolean share$default(Fragment fragment, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "text");
        Intrinsics.checkParameterIsNotNull(str2, "subject");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return share(activity, str, str2);
    }

    public static /* bridge */ /* synthetic */ boolean share$default(Context context, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return share(context, str, str2);
    }

    public static final boolean share(Context context, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "text");
        Intrinsics.checkParameterIsNotNull(str2, "subject");
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", str2);
            intent.putExtra("android.intent.extra.TEXT", str);
            context.startActivity(Intent.createChooser(intent, null));
            return true;
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static final boolean email(AnkoContext<?> ankoContext, String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, NotificationCompat.CATEGORY_EMAIL);
        Intrinsics.checkParameterIsNotNull(str2, "subject");
        Intrinsics.checkParameterIsNotNull(str3, "text");
        return email(ankoContext.getCtx(), str, str2, str3);
    }

    public static /* bridge */ /* synthetic */ boolean email$default(AnkoContext ankoContext, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "";
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, NotificationCompat.CATEGORY_EMAIL);
        Intrinsics.checkParameterIsNotNull(str2, "subject");
        Intrinsics.checkParameterIsNotNull(str3, "text");
        return email(ankoContext.getCtx(), str, str2, str3);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final boolean email(Fragment fragment, String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, NotificationCompat.CATEGORY_EMAIL);
        Intrinsics.checkParameterIsNotNull(str2, "subject");
        Intrinsics.checkParameterIsNotNull(str3, "text");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return email(activity, str, str2, str3);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static /* bridge */ /* synthetic */ boolean email$default(Fragment fragment, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "";
        }
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, NotificationCompat.CATEGORY_EMAIL);
        Intrinsics.checkParameterIsNotNull(str2, "subject");
        Intrinsics.checkParameterIsNotNull(str3, "text");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return email(activity, str, str2, str3);
    }

    public static /* bridge */ /* synthetic */ boolean email$default(Context context, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "";
        }
        return email(context, str, str2, str3);
    }

    public static final boolean email(Context context, String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, NotificationCompat.CATEGORY_EMAIL);
        Intrinsics.checkParameterIsNotNull(str2, "subject");
        Intrinsics.checkParameterIsNotNull(str3, "text");
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse(WebView.SCHEME_MAILTO));
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        if (str2.length() > 0) {
            intent.putExtra("android.intent.extra.SUBJECT", str2);
        }
        if (str3.length() > 0) {
            intent.putExtra("android.intent.extra.TEXT", str3);
        }
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            return false;
        }
        context.startActivity(intent);
        return true;
    }

    public static final boolean makeCall(AnkoContext<?> ankoContext, String str) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "number");
        return makeCall(ankoContext.getCtx(), str);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final boolean makeCall(Fragment fragment, String str) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "number");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return makeCall(activity, str);
    }

    public static final boolean makeCall(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "number");
        try {
            context.startActivity(new Intent("android.intent.action.CALL", Uri.parse(WebView.SCHEME_TEL + str)));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static final boolean sendSMS(AnkoContext<?> ankoContext, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "number");
        Intrinsics.checkParameterIsNotNull(str2, "text");
        return sendSMS(ankoContext.getCtx(), str, str2);
    }

    public static /* bridge */ /* synthetic */ boolean sendSMS$default(AnkoContext ankoContext, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        Intrinsics.checkParameterIsNotNull(ankoContext, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "number");
        Intrinsics.checkParameterIsNotNull(str2, "text");
        return sendSMS(ankoContext.getCtx(), str, str2);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static final boolean sendSMS(Fragment fragment, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "number");
        Intrinsics.checkParameterIsNotNull(str2, "text");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return sendSMS(activity, str, str2);
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    public static /* bridge */ /* synthetic */ boolean sendSMS$default(Fragment fragment, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        Intrinsics.checkParameterIsNotNull(fragment, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "number");
        Intrinsics.checkParameterIsNotNull(str2, "text");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        return sendSMS(activity, str, str2);
    }

    public static /* bridge */ /* synthetic */ boolean sendSMS$default(Context context, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return sendSMS(context, str, str2);
    }

    public static final boolean sendSMS(Context context, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(context, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, "number");
        Intrinsics.checkParameterIsNotNull(str2, "text");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("sms:" + str));
            intent.putExtra("sms_body", str2);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Deprecated(message = "Use support library fragments instead. Framework fragments were deprecated in API 28.")
    private static final <T extends Activity> void startActivityForResult(Fragment fragment, int i, Pair<String, ? extends Object>... pairArr) {
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity");
        Intrinsics.reifiedOperationMarker(4, "T");
        fragment.startActivityForResult(AnkoInternals.createIntent(activity, Activity.class, pairArr), i);
    }
}
