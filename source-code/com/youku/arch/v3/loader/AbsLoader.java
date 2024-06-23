package com.youku.arch.v3.loader;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.bridge.WXBridgeManager;
import com.youku.arch.v3.DomainObject;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.event.FragmentEvent;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.util.ArchMontior;
import com.youku.arch.v3.util.ArchMontiorManager;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000 <*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0002=<B\u000f\u0012\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0004\b;\u0010\u001dJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\f\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0004J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016R\"\u0010\u0018\u001a\u00028\u00008\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00048\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u00048\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\"\u0010'\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\"\u0010+\u001a\u00020*8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R.\u00103\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u0001018\u0016@VX\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u00109\u001a\u00020\u00128V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/youku/arch/v3/loader/AbsLoader;", "Lcom/youku/arch/v3/DomainObject;", "HOST", "Lcom/youku/arch/v3/loader/PagingLoader;", "", "loadPage", "Ltb/ur2;", "loadNextPage", "", "", "", Constants.CONFIG, "load", "Lcom/youku/arch/v3/io/IResponse;", "response", "index", "handleLoadSuccess", "handleLoadFailure", "", "hasExtraData", "hasNextPage", "canLoadNextPage", "reload", "reset", "host", "Lcom/youku/arch/v3/DomainObject;", "getHost", "()Lcom/youku/arch/v3/DomainObject;", "setHost", "(Lcom/youku/arch/v3/DomainObject;)V", "startPage", "I", "getStartPage", "()I", "setStartPage", "(I)V", "loadingState", "getLoadingState", "setLoadingState", "loadingPage", "getLoadingPage", "setLoadingPage", "Lcom/youku/arch/v3/loader/LoadingViewManager;", "loadingViewManager", "Lcom/youku/arch/v3/loader/LoadingViewManager;", "getLoadingViewManager", "()Lcom/youku/arch/v3/loader/LoadingViewManager;", "setLoadingViewManager", "(Lcom/youku/arch/v3/loader/LoadingViewManager;)V", "Lcom/youku/arch/v3/io/Callback;", "value", WXBridgeManager.METHOD_CALLBACK, "Lcom/youku/arch/v3/io/Callback;", "getCallback", "()Lcom/youku/arch/v3/io/Callback;", "setCallback", "(Lcom/youku/arch/v3/io/Callback;)V", "isLoading", "()Z", "<init>", "Companion", "CallbackInterceptor", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public abstract class AbsLoader<HOST extends DomainObject> implements PagingLoader {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_PAGE_START = 1;
    @NotNull
    private static final String TAG = "AbsLoader";
    @Nullable
    private Callback callback = new CallbackInterceptor(this, null);
    @NotNull
    private HOST host;
    private volatile int loadingPage = getStartPage();
    private volatile int loadingState;
    @NotNull
    private LoadingViewManager loadingViewManager = new LoadingViewManager();
    private int startPage = 1;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/youku/arch/v3/loader/AbsLoader$CallbackInterceptor;", "Lcom/youku/arch/v3/io/Callback;", "Lcom/youku/arch/v3/io/IResponse;", "response", "Ltb/ur2;", "onResponse", WXBridgeManager.METHOD_CALLBACK, "Lcom/youku/arch/v3/io/Callback;", "<init>", "(Lcom/youku/arch/v3/loader/AbsLoader;Lcom/youku/arch/v3/io/Callback;)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public final class CallbackInterceptor implements Callback {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private final Callback callback;
        final /* synthetic */ AbsLoader<HOST> this$0;

        public CallbackInterceptor(@Nullable AbsLoader absLoader, Callback callback2) {
            k21.i(absLoader, "this$0");
            this.this$0 = absLoader;
            this.callback = callback2;
        }

        @Override // com.youku.arch.v3.io.Callback
        public void onResponse(@NotNull IResponse iResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1428689448")) {
                ipChange.ipc$dispatch("1428689448", new Object[]{this, iResponse});
                return;
            }
            k21.i(iResponse, "response");
            Event event = new Event(FragmentEvent.ON_RESPONSE_INTERCEPTOR);
            HashMap hashMap = new HashMap(2);
            hashMap.put("response", iResponse);
            event.data = hashMap;
            EventBus eventBus = this.this$0.getHost().getPageContext().getEventBus();
            if (eventBus != null) {
                eventBus.post(event);
            }
            Callback callback2 = this.callback;
            if (callback2 != null) {
                callback2.onResponse(iResponse);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/youku/arch/v3/loader/AbsLoader$Companion;", "", "", "DEFAULT_PAGE_START", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    public AbsLoader(@NotNull HOST host2) {
        k21.i(host2, "host");
        this.host = host2;
    }

    private final void loadNextPage(int i) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1310700032")) {
            ipChange.ipc$dispatch("1310700032", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        setLoadingState(1);
        if (i != getStartPage()) {
            getLoadingViewManager().onNextPageLoading();
        } else if (!hasExtraData() && this.host.getChildCount() == 0) {
            getLoadingViewManager().onLoading();
        }
        HashMap hashMap = new HashMap(2);
        if (i == getStartPage()) {
            z = true;
        }
        hashMap.put("cache", Boolean.valueOf(z));
        hashMap.put("index", Integer.valueOf(i));
        load(hashMap);
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public boolean canLoadNextPage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1490821003")) {
            return getLoadingState() == 0 || getLoadingState() == 2;
        }
        return ((Boolean) ipChange.ipc$dispatch("1490821003", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    @Nullable
    public Callback getCallback() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1850385588")) {
            return this.callback;
        }
        return (Callback) ipChange.ipc$dispatch("1850385588", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final HOST getHost() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-338251532")) {
            return this.host;
        }
        return (HOST) ((DomainObject) ipChange.ipc$dispatch("-338251532", new Object[]{this}));
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public int getLoadingPage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "464898857")) {
            return this.loadingPage;
        }
        return ((Integer) ipChange.ipc$dispatch("464898857", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    public int getLoadingState() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1987020423")) {
            return this.loadingState;
        }
        return ((Integer) ipChange.ipc$dispatch("1987020423", new Object[]{this})).intValue();
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    @NotNull
    public LoadingViewManager getLoadingViewManager() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1305239853")) {
            return this.loadingViewManager;
        }
        return (LoadingViewManager) ipChange.ipc$dispatch("-1305239853", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public int getStartPage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "333128771")) {
            return this.startPage;
        }
        return ((Integer) ipChange.ipc$dispatch("333128771", new Object[]{this})).intValue();
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void handleLoadFailure(@NotNull IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1337728164")) {
            ipChange.ipc$dispatch("1337728164", new Object[]{this, iResponse});
            return;
        }
        k21.i(iResponse, "response");
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void handleLoadSuccess(@NotNull IResponse iResponse, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1755640024")) {
            ipChange.ipc$dispatch("1755640024", new Object[]{this, iResponse, Integer.valueOf(i)});
            return;
        }
        k21.i(iResponse, "response");
    }

    /* access modifiers changed from: protected */
    public final boolean hasExtraData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-784348369")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-784348369", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public boolean hasNextPage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1959493703")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("1959493703", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public boolean isLoading() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "788786993")) {
            return getLoadingState() == 1;
        }
        return ((Boolean) ipChange.ipc$dispatch("788786993", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void load(@NotNull Map<String, ? extends Object> map) {
        ArchMontior archMontior;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-552410112")) {
            ipChange.ipc$dispatch("-552410112", new Object[]{this, map});
            return;
        }
        k21.i(map, Constants.CONFIG);
        Integer num = (Integer) map.get("index");
        int startPage2 = num == null ? getStartPage() : num.intValue();
        IRequest createRequest = this.host.createRequest(map);
        long currentTimeMillis = System.currentTimeMillis();
        if (createRequest != null) {
            String pageName = getHost().getPageContext().getPageName();
            if (!(pageName == null || (archMontior = ArchMontiorManager.Companion.get(pageName)) == null)) {
                archMontior.setRequestTime(System.currentTimeMillis());
                archMontior.setApiName(createRequest.getApiName());
            }
            getHost().request(createRequest, new AbsLoader$load$1$2(this, startPage2, currentTimeMillis));
        }
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void reload() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1247156782")) {
            ipChange.ipc$dispatch("-1247156782", new Object[]{this});
        } else if (!isLoading()) {
            setLoadingPage(getStartPage());
            loadNextPage(getLoadingPage());
        }
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1234026896")) {
            ipChange.ipc$dispatch("-1234026896", new Object[]{this});
            return;
        }
        setLoadingState(0);
        setLoadingPage(getStartPage());
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void setCallback(@Nullable Callback callback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-260549688")) {
            ipChange.ipc$dispatch("-260549688", new Object[]{this, callback2});
            return;
        }
        this.callback = new CallbackInterceptor(this, callback2);
    }

    /* access modifiers changed from: protected */
    public final void setHost(@NotNull HOST host2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-554786508")) {
            ipChange.ipc$dispatch("-554786508", new Object[]{this, host2});
            return;
        }
        k21.i(host2, "<set-?>");
        this.host = host2;
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void setLoadingPage(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1847941119")) {
            ipChange.ipc$dispatch("-1847941119", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.loadingPage = i;
    }

    /* access modifiers changed from: protected */
    public void setLoadingState(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-75607045")) {
            ipChange.ipc$dispatch("-75607045", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.loadingState = i;
    }

    public void setLoadingViewManager(@NotNull LoadingViewManager loadingViewManager2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "223053909")) {
            ipChange.ipc$dispatch("223053909", new Object[]{this, loadingViewManager2});
            return;
        }
        k21.i(loadingViewManager2, "<set-?>");
        this.loadingViewManager = loadingViewManager2;
    }

    /* access modifiers changed from: protected */
    public void setStartPage(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-94355673")) {
            ipChange.ipc$dispatch("-94355673", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.startPage = i;
    }

    @Override // com.youku.arch.v3.loader.PagingLoader
    public void loadNextPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1481740957")) {
            ipChange.ipc$dispatch("-1481740957", new Object[]{this});
        } else if (!isLoading()) {
            loadNextPage(getLoadingPage());
        }
    }
}
