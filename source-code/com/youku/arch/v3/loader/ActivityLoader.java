package com.youku.arch.v3.loader;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.bridge.WXBridgeManager;
import com.youku.arch.v3.core.ActivityContext;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.page.GenericActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 8*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u00018B\u000f\u0012\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0004\b7\u0010\u001bJ\u001c\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016R\"\u0010\u0016\u001a\u00028\u00008\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u000f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u00020\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b)\u0010+R\"\u0010,\u001a\u00020\u000f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b,\u0010\u001d\u001a\u0004\b-\u0010\u001f\"\u0004\b.\u0010!R\u001e\u00100\u001a\u0004\u0018\u00010/8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R$\u00104\u001a\u0004\u0018\u00010\"8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b4\u0010$\u001a\u0004\b5\u0010&\"\u0004\b6\u0010(¨\u00069"}, d2 = {"Lcom/youku/arch/v3/loader/ActivityLoader;", "Lcom/youku/arch/v3/page/GenericActivity;", "HOST", "Lcom/youku/arch/v3/loader/PagingLoader;", "", "", "", Constants.CONFIG, "Ltb/ur2;", "load", "reload", "reset", "Lcom/youku/arch/v3/io/IResponse;", "response", "handleLoadFailure", "", "index", "handleLoadSuccess", "loadNextPage", "", "hasNextPage", "canLoadNextPage", "host", "Lcom/youku/arch/v3/page/GenericActivity;", "getHost", "()Lcom/youku/arch/v3/page/GenericActivity;", "setHost", "(Lcom/youku/arch/v3/page/GenericActivity;)V", "loadingState", "I", "getLoadingState", "()I", "setLoadingState", "(I)V", "Lcom/youku/arch/v3/io/Callback;", "callBack", "Lcom/youku/arch/v3/io/Callback;", "getCallBack", "()Lcom/youku/arch/v3/io/Callback;", "setCallBack", "(Lcom/youku/arch/v3/io/Callback;)V", "isLoading", "Z", "()Z", "loadingPage", "getLoadingPage", "setLoadingPage", "Lcom/youku/arch/v3/loader/LoadingViewManager;", "loadingViewManager", "Lcom/youku/arch/v3/loader/LoadingViewManager;", "getLoadingViewManager", "()Lcom/youku/arch/v3/loader/LoadingViewManager;", WXBridgeManager.METHOD_CALLBACK, "getCallback", "setCallback", "<init>", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public class ActivityLoader<HOST extends GenericActivity> implements PagingLoader {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "OneArch.ActivityLoader";
    @Nullable
    private Callback callBack;
    @Nullable
    private Callback callback;
    @NotNull
    private HOST host;
    private final boolean isLoading;
    private int loadingPage;
    private int loadingState;
    @Nullable
    private final LoadingViewManager loadingViewManager;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/loader/ActivityLoader$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    public ActivityLoader(@NotNull HOST host2) {
        k21.i(host2, "host");
        this.host = host2;
        this.isLoading = getLoadingState() != 1 ? false : true;
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public boolean canLoadNextPage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2078459048")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("2078459048", new Object[]{this})).booleanValue();
    }

    @Nullable
    public final Callback getCallBack() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2127658865")) {
            return this.callBack;
        }
        return (Callback) ipChange.ipc$dispatch("2127658865", new Object[]{this});
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    @Nullable
    public Callback getCallback() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-204738671")) {
            return this.callback;
        }
        return (Callback) ipChange.ipc$dispatch("-204738671", new Object[]{this});
    }

    @NotNull
    public final HOST getHost() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1498583924")) {
            return this.host;
        }
        return (HOST) ((GenericActivity) ipChange.ipc$dispatch("1498583924", new Object[]{this}));
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public int getLoadingPage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1592233580")) {
            return this.loadingPage;
        }
        return ((Integer) ipChange.ipc$dispatch("1592233580", new Object[]{this})).intValue();
    }

    public int getLoadingState() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1720308828")) {
            return this.loadingState;
        }
        return ((Integer) ipChange.ipc$dispatch("-1720308828", new Object[]{this})).intValue();
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    @Nullable
    public LoadingViewManager getLoadingViewManager() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "413754032")) {
            return this.loadingViewManager;
        }
        return (LoadingViewManager) ipChange.ipc$dispatch("413754032", new Object[]{this});
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void handleLoadFailure(@NotNull IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1956169087")) {
            ipChange.ipc$dispatch("-1956169087", new Object[]{this, iResponse});
            return;
        }
        k21.i(iResponse, "response");
        setLoadingState(0);
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void handleLoadSuccess(@NotNull IResponse iResponse, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1570926949")) {
            ipChange.ipc$dispatch("-1570926949", new Object[]{this, iResponse, Integer.valueOf(i)});
            return;
        }
        k21.i(iResponse, "response");
        ActivityContext activityContext = this.host.getActivityContext();
        if (activityContext != null) {
            activityContext.runOnLoaderThreadLocked(new ActivityLoader$handleLoadSuccess$1(this, iResponse));
        }
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public boolean hasNextPage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2005089252")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("2005089252", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public boolean isLoading() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1329598962")) {
            return this.isLoading;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1329598962", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void load(@NotNull Map<String, ? extends Object> map) {
        ActivityContext activityContext;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "634892957")) {
            ipChange.ipc$dispatch("634892957", new Object[]{this, map});
            return;
        }
        k21.i(map, Constants.CONFIG);
        setLoadingState(1);
        IRequest build = this.host.getRequestBuilder().build(map);
        if (build != null && (activityContext = getHost().getActivityContext()) != null) {
            activityContext.runOnLoaderThread(new ActivityLoader$load$1$1(build, this));
        }
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void loadNextPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-68278938")) {
            ipChange.ipc$dispatch("-68278938", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void reload() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1039623147")) {
            ipChange.ipc$dispatch("-1039623147", new Object[]{this});
            return;
        }
        load(new LinkedHashMap());
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1642974259")) {
            ipChange.ipc$dispatch("-1642974259", new Object[]{this});
            return;
        }
        setLoadingState(0);
    }

    public final void setCallBack(@Nullable Callback callback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-255012693")) {
            ipChange.ipc$dispatch("-255012693", new Object[]{this, callback2});
            return;
        }
        this.callBack = callback2;
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void setCallback(@Nullable Callback callback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "455107723")) {
            ipChange.ipc$dispatch("455107723", new Object[]{this, callback2});
            return;
        }
        this.callback = callback2;
    }

    public final void setHost(@NotNull HOST host2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2022833998")) {
            ipChange.ipc$dispatch("2022833998", new Object[]{this, host2});
            return;
        }
        k21.i(host2, "<set-?>");
        this.host = host2;
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void setLoadingPage(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1260303074")) {
            ipChange.ipc$dispatch("-1260303074", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.loadingPage = i;
    }

    public void setLoadingState(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "961303166")) {
            ipChange.ipc$dispatch("961303166", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.loadingState = i;
    }
}
