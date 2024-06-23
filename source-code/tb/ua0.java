package tb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import com.alibaba.pictures.dolores.business.IDoloresRequestRouter;
import com.alibaba.pictures.dolores.business.IRequestInterceptor;
import com.alibaba.pictures.dolores.cache.ICacheManager;
import com.alibaba.pictures.dolores.config.IGlobalConfig;
import com.alibaba.pictures.dolores.convert.IJSONConverter;
import com.alibaba.pictures.dolores.log.IDoloresLog;
import com.alibaba.pictures.dolores.login.IDoloresLoginDelegate;
import com.alibaba.pictures.dolores.time.TimeSyncer;
import com.alibaba.pictures.dolores.transfer.IDataTransformerFactory;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ua0 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final String g = "DoloresBusiness";
    @Nullable
    private static IRequestInterceptor h;
    @Nullable
    private static IDoloresLoginDelegate i;
    private static boolean j;
    @Nullable
    private static IJSONConverter k;
    @Nullable
    private static IGlobalConfig l;
    @SuppressLint({"StaticFieldLeak"})
    private static ua0 m;
    @Nullable
    private IDoloresLog a;
    @Nullable
    private IDoloresRequestRouter b;
    @Nullable
    private String c;
    @Nullable
    private ICacheManager d;
    @Nullable
    private IDataTransformerFactory e;
    @NotNull
    private Context f;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        @Nullable
        public final IGlobalConfig a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1939972191")) {
                return ua0.l;
            }
            return (IGlobalConfig) ipChange.ipc$dispatch("1939972191", new Object[]{this});
        }

        @Nullable
        public final IRequestInterceptor b() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-259709427")) {
                return ua0.h;
            }
            return (IRequestInterceptor) ipChange.ipc$dispatch("-259709427", new Object[]{this});
        }

        @Nullable
        public final IJSONConverter c() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1600585625")) {
                return ua0.k;
            }
            return (IJSONConverter) ipChange.ipc$dispatch("-1600585625", new Object[]{this});
        }

        @Nullable
        public final IDoloresLoginDelegate d() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "974524155")) {
                return ua0.i;
            }
            return (IDoloresLoginDelegate) ipChange.ipc$dispatch("974524155", new Object[]{this});
        }

        @NotNull
        public final String e() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1882574933")) {
                return ua0.g;
            }
            return (String) ipChange.ipc$dispatch("-1882574933", new Object[]{this});
        }

        @JvmStatic
        @NotNull
        public final ua0 f(@NotNull Context context) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-767519414")) {
                return (ua0) ipChange.ipc$dispatch("-767519414", new Object[]{this, context});
            }
            k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
            Log.d(e(), "init: ");
            if (ua0.m == null) {
                ua0.m = new ua0(context, null);
            }
            TimeSyncer.INSTANCE.h(context);
            ua0 ua0 = ua0.m;
            k21.f(ua0);
            return ua0;
        }

        @JvmStatic
        @NotNull
        public final ua0 g() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1210723365")) {
                return (ua0) ipChange.ipc$dispatch("1210723365", new Object[]{this});
            } else if (ua0.m != null) {
                ua0 ua0 = ua0.m;
                k21.f(ua0);
                return ua0;
            } else {
                throw new RuntimeException("DoloresManager need init with context first!");
            }
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    private ua0(Context context) {
        this.f = context;
    }

    @JvmStatic
    @NotNull
    public static final ua0 o(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1993743362")) {
            return Companion.f(context);
        }
        return (ua0) ipChange.ipc$dispatch("1993743362", new Object[]{context});
    }

    @JvmStatic
    @NotNull
    public static final ua0 p() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-195108243") ? (ua0) ipChange.ipc$dispatch("-195108243", new Object[0]) : Companion.g();
    }

    public static final void q(@Nullable IGlobalConfig iGlobalConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2041279625")) {
            ipChange.ipc$dispatch("2041279625", new Object[]{iGlobalConfig});
            return;
        }
        l = iGlobalConfig;
    }

    public static final void r(@Nullable IRequestInterceptor iRequestInterceptor) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "347784541")) {
            ipChange.ipc$dispatch("347784541", new Object[]{iRequestInterceptor});
            return;
        }
        h = iRequestInterceptor;
    }

    public static final void s(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "54649832")) {
            ipChange.ipc$dispatch("54649832", new Object[]{Boolean.valueOf(z)});
            return;
        }
        j = z;
    }

    public static final void t(@Nullable IDoloresLoginDelegate iDoloresLoginDelegate) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1464403253")) {
            ipChange.ipc$dispatch("-1464403253", new Object[]{iDoloresLoginDelegate});
            return;
        }
        i = iDoloresLoginDelegate;
    }

    @Nullable
    public final ICacheManager h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1648144868")) {
            return (ICacheManager) ipChange.ipc$dispatch("-1648144868", new Object[]{this});
        }
        if (this.d == null) {
            this.d = i40.Companion.a(this.f, "dolorescache.db", "dolorestable", 1, -1);
        }
        return this.d;
    }

    @NotNull
    public final Context i() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "650355728")) {
            return this.f;
        }
        return (Context) ipChange.ipc$dispatch("650355728", new Object[]{this});
    }

    @Nullable
    public final IDataTransformerFactory j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-235264477")) {
            return (IDataTransformerFactory) ipChange.ipc$dispatch("-235264477", new Object[]{this});
        }
        if (this.e == null) {
            this.e = new n40();
        }
        return this.e;
    }

    @Nullable
    public final String k(@NotNull IGlobalConfig.Key key, @Nullable String str) {
        String globalConfig;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-665798715")) {
            return (String) ipChange.ipc$dispatch("-665798715", new Object[]{this, key, str});
        }
        k21.i(key, "key");
        IGlobalConfig iGlobalConfig = l;
        return (iGlobalConfig == null || (globalConfig = iGlobalConfig.getGlobalConfig(key, str)) == null) ? str : globalConfig;
    }

    @Nullable
    public final IDoloresLog l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154576584")) {
            return (IDoloresLog) ipChange.ipc$dispatch("-154576584", new Object[]{this});
        }
        if (this.a == null) {
            ab0 ab0 = new ab0();
            ab0.a(j);
            ur2 ur2 = ur2.INSTANCE;
            this.a = ab0;
        }
        return this.a;
    }

    @Nullable
    public final IDoloresRequestRouter m() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-997373617")) {
            return this.b;
        }
        return (IDoloresRequestRouter) ipChange.ipc$dispatch("-997373617", new Object[]{this});
    }

    @Nullable
    public final String n() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1296370712")) {
            return this.c;
        }
        return (String) ipChange.ipc$dispatch("1296370712", new Object[]{this});
    }

    public final void u(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1240029638")) {
            ipChange.ipc$dispatch("1240029638", new Object[]{this, str});
            return;
        }
        this.c = str;
    }

    public /* synthetic */ ua0(Context context, m40 m40) {
        this(context);
    }
}
