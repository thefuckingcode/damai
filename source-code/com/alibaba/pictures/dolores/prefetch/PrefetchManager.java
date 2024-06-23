package com.alibaba.pictures.dolores.prefetch;

import android.os.Bundle;
import com.alibaba.pictures.dolores.config.IGlobalConfig;
import com.alibaba.pictures.dolores.prefetch.page.PrefetchPageMo;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.b;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsKt;
import org.android.spdy.spduLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.db0;
import tb.m40;
import tb.ta0;
import tb.ua0;
import tb.ur2;

/* compiled from: Taobao */
public final class PrefetchManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String TAG = "MtopPrefetch";
    @NotNull
    private static final Lazy c = b.a(LazyThreadSafetyMode.SYNCHRONIZED, PrefetchManager$Companion$instance$2.INSTANCE);
    private final Lazy a = b.b(PrefetchManager$pageList$2.INSTANCE);
    @Nullable
    private String b;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    private final HashMap<String, PrefetchPageMo> b() {
        Object value;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1354709305")) {
            value = ipChange.ipc$dispatch("1354709305", new Object[]{this});
        } else {
            value = this.a.getValue();
        }
        return (HashMap) value;
    }

    /* access modifiers changed from: private */
    public final void c(String str, Bundle bundle) {
        ta0 a2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-546039429")) {
            ipChange.ipc$dispatch("-546039429", new Object[]{this, str, bundle});
            return;
        }
        if (!(str == null || str.length() == 0)) {
            String str2 = this.b;
            if (str2 == null) {
                IGlobalConfig a3 = ua0.Companion.a();
                str2 = a3 != null ? a3.getGlobalConfig(IGlobalConfig.Key.PREFETCH_BLACK_LIST, null) : null;
            }
            if (str2 == null || !(StringsKt__StringsKt.Q(str2, str, false, 2, null))) {
                PrefetchPageMo prefetchPageMo = b().get(str);
                if (prefetchPageMo == null) {
                    spduLog.Logd(TAG, "数据预加载未配置页面" + str);
                    return;
                }
                ArrayList<PrefetchRequestBuilder<?>> requestList = prefetchPageMo.getRequestList();
                if (requestList != null) {
                    for (T t : requestList) {
                        if (t instanceof PrefetchRequestAction) {
                            Function2<Bundle, PrefetchPageMo, ur2> requestAction = t.getRequestAction();
                            if (requestAction != null) {
                                requestAction.invoke(bundle, prefetchPageMo);
                            }
                        } else {
                            DoloresRequest build = t.build(bundle);
                            spduLog.Logd(TAG, "数据预加载开始加载" + str + " request:" + build);
                            if (!(build == null || (a2 = db0.a(build)) == null)) {
                                ta0.e(a2, prefetchPageMo.getExpireTime(), null, 2, null);
                            }
                        }
                    }
                    return;
                }
                return;
            }
            spduLog.Logd(TAG, "数据预加载页面在黑名单中，放弃预加载" + str);
        }
    }
}
