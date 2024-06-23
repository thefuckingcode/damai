package tb;

import android.taobao.windvane.standardmodal.WVStandardEventCenter;
import android.taobao.windvane.webview.IWVWebView;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class zi2 {
    @NotNull
    public static final zi2 INSTANCE = new zi2();

    private zi2() {
    }

    @JvmStatic
    public static final void a(@Nullable IWVWebView iWVWebView, @Nullable String str, @Nullable String str2) {
        WVStandardEventCenter.postNotificationToJS(iWVWebView, str, str2);
    }

    @JvmStatic
    public static final void b(@Nullable String str, @Nullable String str2) {
        WVStandardEventCenter.postNotificationToJS(str, str2);
    }
}
