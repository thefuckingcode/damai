package cn.damai.h5container;

import android.content.Context;
import android.content.Intent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.taobao.orange.OrangeConfig;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.b;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.rr2;

/* compiled from: Taobao */
public final class UniH5ContainerSwitcher {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    private static final String BLACKLIST_DEFAULT = "(m.(wapa.)?taopiaopiao.com/tickets/vip/pages/center/index.html)";
    @NotNull
    private static final String CONFIG_WINDVANE_COMMON_RULE = "blackList";
    @NotNull
    private static final String CONFIG_WINDVANE_SWITCH = "open";
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Lazy<UniH5ContainerSwitcher> Instance$delegate = b.a(LazyThreadSafetyMode.SYNCHRONIZED, UniH5ContainerSwitcher$Companion$Instance$2.INSTANCE);
    @NotNull
    private static final String ORANGE_GROUP = "movie_windvane";
    @Nullable
    private String blackList;
    private boolean openSwitch = true;

    /* compiled from: Taobao */
    public static final class Companion {
        private static transient /* synthetic */ IpChange $ipChange;

        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @NotNull
        public final UniH5ContainerSwitcher getInstance() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "691316085")) {
                return (UniH5ContainerSwitcher) UniH5ContainerSwitcher.Instance$delegate.getValue();
            }
            return (UniH5ContainerSwitcher) ipChange.ipc$dispatch("691316085", new Object[]{this});
        }
    }

    @NotNull
    public static final UniH5ContainerSwitcher getInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-572095235") ? (UniH5ContainerSwitcher) ipChange.ipc$dispatch("-572095235", new Object[0]) : Companion.getInstance();
    }

    private final boolean notInBlackList(String str) {
        String str2;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1464665057")) {
            return ((Boolean) ipChange.ipc$dispatch("1464665057", new Object[]{this, str})).booleanValue();
        }
        if (str == null || str.length() == 0) {
            z = true;
        }
        if (z || (str2 = this.blackList) == null) {
            return true;
        }
        try {
            return true ^ Pattern.compile(str2, 2).matcher(str).find();
        } catch (Exception unused) {
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: registerOrangeConfig$lambda-0  reason: not valid java name */
    public static final void m31registerOrangeConfig$lambda0(UniH5ContainerSwitcher uniH5ContainerSwitcher, String str, Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "595342060")) {
            ipChange.ipc$dispatch("595342060", new Object[]{uniH5ContainerSwitcher, str, map});
            return;
        }
        k21.i(uniH5ContainerSwitcher, "this$0");
        if (k21.d(str, ORANGE_GROUP)) {
            uniH5ContainerSwitcher.openSwitch = k21.d(OrangeConfig.getInstance().getConfig(str, "open", "true"), "true");
            uniH5ContainerSwitcher.blackList = OrangeConfig.getInstance().getConfig(str, CONFIG_WINDVANE_COMMON_RULE, null);
        }
    }

    public final void registerOrangeConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1075107003")) {
            ipChange.ipc$dispatch("-1075107003", new Object[]{this});
            return;
        }
        OrangeConfig.getInstance().registerListener(new String[]{ORANGE_GROUP}, new rr2(this), true);
    }

    public final boolean shouldInterceptUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-423873690")) {
            return this.openSwitch && notInBlackList(str);
        }
        return ((Boolean) ipChange.ipc$dispatch("-423873690", new Object[]{this, str})).booleanValue();
    }

    public final void startUniH5Activity(@NotNull Context context, @NotNull Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1152130537")) {
            ipChange.ipc$dispatch("-1152130537", new Object[]{this, context, intent});
            return;
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
    }
}
