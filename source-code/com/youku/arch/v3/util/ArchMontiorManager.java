package com.youku.arch.v3.util;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.ut.UserTrackProviderProxy;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.gl1;
import tb.k21;
import tb.m40;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/youku/arch/v3/util/ArchMontiorManager;", "", "<init>", "()V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class ArchMontiorManager {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "OneArch.ArchMontiorManager";
    @NotNull
    private static HashMap<String, ArchMontior> archMontiors = new HashMap<>();
    public static Function1<? super String, ? extends ArchMontior> createArchMontiorInstance;
    private static int defaultSampling = 10000;
    @NotNull
    private static final Lazy<ArchMontiorManager> instance$delegate = b.a(LazyThreadSafetyMode.SYNCHRONIZED, ArchMontiorManager$Companion$instance$2.INSTANCE);
    public static Function0<ur2> registerComponentMonitor;
    public static Function0<ur2> registerPageMonitor;
    @NotNull
    private static HashMap<String, Integer> sampling = new HashMap<>();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b.\u0010/J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R.\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00158\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00158\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001d\u0010$\u001a\u00020\u001f8F@\u0006X\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b%\u0010&R2\u0010)\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060'j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006`(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R2\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0'j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n`(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010*¨\u00060"}, d2 = {"Lcom/youku/arch/v3/util/ArchMontiorManager$Companion;", "", "", "checkInit", "", "pageName", "Lcom/youku/arch/v3/util/ArchMontior;", gl1.TYPE_OPEN_URL_METHOD_GET, "Ltb/ur2;", "release", "", "s", "setSampling", "needStat", "Lkotlin/Function1;", "createArchMontiorInstance", "Lkotlin/jvm/functions/Function1;", "getCreateArchMontiorInstance", "()Lkotlin/jvm/functions/Function1;", "setCreateArchMontiorInstance", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "registerPageMonitor", "Lkotlin/jvm/functions/Function0;", "getRegisterPageMonitor", "()Lkotlin/jvm/functions/Function0;", "setRegisterPageMonitor", "(Lkotlin/jvm/functions/Function0;)V", "registerComponentMonitor", "getRegisterComponentMonitor", "setRegisterComponentMonitor", "Lcom/youku/arch/v3/util/ArchMontiorManager;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/arch/v3/util/ArchMontiorManager;", "instance", "TAG", "Ljava/lang/String;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "archMontiors", "Ljava/util/HashMap;", "defaultSampling", "I", "sampling", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private static transient /* synthetic */ IpChange $ipChange;

        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        public final boolean checkInit() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-460460110")) {
                return ArchMontiorManager.createArchMontiorInstance != null;
            }
            return ((Boolean) ipChange.ipc$dispatch("-460460110", new Object[]{this})).booleanValue();
        }

        @Nullable
        public final ArchMontior get(@NotNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-123190915")) {
                return (ArchMontior) ipChange.ipc$dispatch("-123190915", new Object[]{this, str});
            }
            k21.i(str, "pageName");
            if (!ArchMontiorManager.archMontiors.containsKey(str)) {
                if (ArchMontiorManager.createArchMontiorInstance != null) {
                    ArchMontiorManager.archMontiors.put(str, getCreateArchMontiorInstance().invoke(str));
                }
                if (ArchMontiorManager.registerPageMonitor != null) {
                    getRegisterPageMonitor().invoke();
                }
                if (ArchMontiorManager.registerComponentMonitor != null) {
                    getRegisterComponentMonitor().invoke();
                }
            }
            return (ArchMontior) ArchMontiorManager.archMontiors.get(str);
        }

        /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super java.lang.String, ? extends com.youku.arch.v3.util.ArchMontior>, kotlin.jvm.functions.Function1<java.lang.String, com.youku.arch.v3.util.ArchMontior> */
        @NotNull
        public final Function1<String, ArchMontior> getCreateArchMontiorInstance() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "35905417")) {
                return (Function1) ipChange.ipc$dispatch("35905417", new Object[]{this});
            }
            Function1 function1 = ArchMontiorManager.createArchMontiorInstance;
            if (function1 != null) {
                return function1;
            }
            k21.A("createArchMontiorInstance");
            return null;
        }

        @NotNull
        public final ArchMontiorManager getInstance() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "117919725")) {
                return (ArchMontiorManager) ArchMontiorManager.instance$delegate.getValue();
            }
            return (ArchMontiorManager) ipChange.ipc$dispatch("117919725", new Object[]{this});
        }

        @NotNull
        public final Function0<ur2> getRegisterComponentMonitor() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1363465939")) {
                return (Function0) ipChange.ipc$dispatch("-1363465939", new Object[]{this});
            }
            Function0<ur2> function0 = ArchMontiorManager.registerComponentMonitor;
            if (function0 != null) {
                return function0;
            }
            k21.A("registerComponentMonitor");
            return null;
        }

        @NotNull
        public final Function0<ur2> getRegisterPageMonitor() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1761087093")) {
                return (Function0) ipChange.ipc$dispatch("-1761087093", new Object[]{this});
            }
            Function0<ur2> function0 = ArchMontiorManager.registerPageMonitor;
            if (function0 != null) {
                return function0;
            }
            k21.A("registerPageMonitor");
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x005c A[ORIG_RETURN, RETURN, SYNTHETIC] */
        public final boolean needStat(@NotNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1475343640")) {
                return ((Boolean) ipChange.ipc$dispatch("-1475343640", new Object[]{this, str})).booleanValue();
            }
            k21.i(str, "pageName");
            String utdid = UserTrackProviderProxy.getUtdid();
            if (utdid != null) {
                int abs = Math.abs(utdid.hashCode()) % 10000;
                if (ArchMontiorManager.sampling.containsKey(str)) {
                    Object obj = ArchMontiorManager.sampling.get(str);
                    k21.f(obj);
                    k21.h(obj, "sampling[pageName]!!");
                    if (abs < ((Number) obj).intValue()) {
                        return true;
                    }
                    return false;
                } else if (abs >= ArchMontiorManager.defaultSampling) {
                    return false;
                }
            }
            return true;
        }

        public final void release(@NotNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2030584887")) {
                ipChange.ipc$dispatch("-2030584887", new Object[]{this, str});
                return;
            }
            k21.i(str, "pageName");
            LogUtil.d(ArchMontiorManager.TAG, "release");
            ArchMontiorManager.archMontiors.remove(str);
        }

        public final void setCreateArchMontiorInstance(@NotNull Function1<? super String, ? extends ArchMontior> function1) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1652286789")) {
                ipChange.ipc$dispatch("1652286789", new Object[]{this, function1});
                return;
            }
            k21.i(function1, "<set-?>");
            ArchMontiorManager.createArchMontiorInstance = function1;
        }

        public final void setRegisterComponentMonitor(@NotNull Function0<ur2> function0) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-788502549")) {
                ipChange.ipc$dispatch("-788502549", new Object[]{this, function0});
                return;
            }
            k21.i(function0, "<set-?>");
            ArchMontiorManager.registerComponentMonitor = function0;
        }

        public final void setRegisterPageMonitor(@NotNull Function0<ur2> function0) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1034953755")) {
                ipChange.ipc$dispatch("-1034953755", new Object[]{this, function0});
                return;
            }
            k21.i(function0, "<set-?>");
            ArchMontiorManager.registerPageMonitor = function0;
        }

        public final void setSampling(int i, @Nullable String str) {
            ur2 ur2;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "717959504")) {
                ipChange.ipc$dispatch("717959504", new Object[]{this, Integer.valueOf(i), str});
                return;
            }
            if (str == null) {
                ur2 = null;
            } else {
                ArchMontiorManager.sampling.put(str, Integer.valueOf(i));
                ur2 = ur2.INSTANCE;
            }
            if (ur2 == null) {
                Companion companion = ArchMontiorManager.Companion;
                ArchMontiorManager.defaultSampling = i;
            }
        }
    }
}
