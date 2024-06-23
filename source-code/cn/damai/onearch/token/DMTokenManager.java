package cn.damai.onearch.token;

import android.content.Context;
import android.net.Uri;
import com.alient.resource.token.TokenManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.b;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class DMTokenManager {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final Lazy<DMTokenManager> a = b.a(LazyThreadSafetyMode.SYNCHRONIZED, DMTokenManager$Companion$instance$2.INSTANCE);

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final DMTokenManager a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1114021847")) {
                return (DMTokenManager) DMTokenManager.a.getValue();
            }
            return (DMTokenManager) ipChange.ipc$dispatch("-1114021847", new Object[]{this});
        }
    }

    public final void b(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-666273318")) {
            ipChange.ipc$dispatch("-666273318", new Object[]{this, context});
            return;
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        TokenManager instance = TokenManager.Companion.getInstance();
        Uri parse = Uri.parse("android.resource://commonbusiness/raw/token");
        k21.h(parse, "parse(ContentResolver.SC…ommonbusiness/raw/token\")");
        instance.init(context, parse);
    }
}
