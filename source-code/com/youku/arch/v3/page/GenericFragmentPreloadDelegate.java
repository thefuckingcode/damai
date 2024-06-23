package com.youku.arch.v3.page;

import android.app.Activity;
import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.adapter.ContentAdapter;
import com.youku.arch.v3.core.ActivityContext;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.PageContainer;
import com.youku.arch.v3.core.PageContext;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.event.FragmentEvent;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.loader.PageLoader;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import com.youku.kubus.Subscribe;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\bO\u0010PJ\u0006\u0010\u0004\u001a\u00020\u0003J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007J\u0006\u0010\n\u001a\u00020\u0003R\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010<\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010C\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010I\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N¨\u0006Q"}, d2 = {"Lcom/youku/arch/v3/page/GenericFragmentPreloadDelegate;", "Lcom/youku/arch/v3/page/IDelegate;", "Lcom/youku/arch/v3/page/GenericFragment;", "Ltb/ur2;", "preload", "container", "setDelegatedContainer", "Lcom/youku/kubus/Event;", "event", "onFragmentDestroy", "release", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/youku/arch/v3/core/PageContext;", Constants.PAGE_CONTEXT, "Lcom/youku/arch/v3/core/PageContext;", "getPageContext", "()Lcom/youku/arch/v3/core/PageContext;", "setPageContext", "(Lcom/youku/arch/v3/core/PageContext;)V", "Lcom/youku/arch/v3/core/PageContainer;", "Lcom/youku/arch/v3/core/ModelValue;", "pageContainer", "Lcom/youku/arch/v3/core/PageContainer;", "getPageContainer", "()Lcom/youku/arch/v3/core/PageContainer;", "setPageContainer", "(Lcom/youku/arch/v3/core/PageContainer;)V", "", "pageName", "Ljava/lang/String;", "getPageName", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "Lcom/youku/arch/v3/core/ActivityContext;", "activityContext", "Lcom/youku/arch/v3/core/ActivityContext;", "getActivityContext", "()Lcom/youku/arch/v3/core/ActivityContext;", "setActivityContext", "(Lcom/youku/arch/v3/core/ActivityContext;)V", "Lcom/youku/arch/v3/page/RecycleViewSettings;", "recyclerViewSettings", "Lcom/youku/arch/v3/page/RecycleViewSettings;", "getRecyclerViewSettings", "()Lcom/youku/arch/v3/page/RecycleViewSettings;", "setRecyclerViewSettings", "(Lcom/youku/arch/v3/page/RecycleViewSettings;)V", "Lcom/youku/arch/v3/core/ConfigManager;", "configManager", "Lcom/youku/arch/v3/core/ConfigManager;", "getConfigManager", "()Lcom/youku/arch/v3/core/ConfigManager;", "setConfigManager", "(Lcom/youku/arch/v3/core/ConfigManager;)V", "Lcom/youku/arch/v3/io/RequestBuilder;", "requestBuilder", "Lcom/youku/arch/v3/io/RequestBuilder;", "getRequestBuilder", "()Lcom/youku/arch/v3/io/RequestBuilder;", "setRequestBuilder", "(Lcom/youku/arch/v3/io/RequestBuilder;)V", "Lcom/youku/arch/v3/loader/PageLoader;", "pageLoader", "Lcom/youku/arch/v3/loader/PageLoader;", "getPageLoader", "()Lcom/youku/arch/v3/loader/PageLoader;", "setPageLoader", "(Lcom/youku/arch/v3/loader/PageLoader;)V", "genericFragment", "Lcom/youku/arch/v3/page/GenericFragment;", "getGenericFragment", "()Lcom/youku/arch/v3/page/GenericFragment;", "setGenericFragment", "(Lcom/youku/arch/v3/page/GenericFragment;)V", "<init>", "(Landroid/content/Context;)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public class GenericFragmentPreloadDelegate implements IDelegate<GenericFragment> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private ActivityContext activityContext;
    @Nullable
    private ConfigManager configManager;
    @NotNull
    private final Context context;
    @Nullable
    private GenericFragment genericFragment;
    @Nullable
    private PageContainer<ModelValue> pageContainer;
    @Nullable
    private PageContext pageContext;
    @Nullable
    private PageLoader pageLoader;
    @Nullable
    private String pageName;
    @Nullable
    private RecycleViewSettings recyclerViewSettings;
    @Nullable
    private RequestBuilder requestBuilder;

    public GenericFragmentPreloadDelegate(@NotNull Context context2) {
        k21.i(context2, WPKFactory.INIT_KEY_CONTEXT);
        this.context = context2;
    }

    @Nullable
    public final ActivityContext getActivityContext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1357194309")) {
            return this.activityContext;
        }
        return (ActivityContext) ipChange.ipc$dispatch("-1357194309", new Object[]{this});
    }

    @Nullable
    public final ConfigManager getConfigManager() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-452269029")) {
            return this.configManager;
        }
        return (ConfigManager) ipChange.ipc$dispatch("-452269029", new Object[]{this});
    }

    @NotNull
    public final Context getContext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "987638486")) {
            return this.context;
        }
        return (Context) ipChange.ipc$dispatch("987638486", new Object[]{this});
    }

    @Nullable
    public final GenericFragment getGenericFragment() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1835525397")) {
            return this.genericFragment;
        }
        return (GenericFragment) ipChange.ipc$dispatch("-1835525397", new Object[]{this});
    }

    @Nullable
    public final PageContainer<ModelValue> getPageContainer() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1278709243")) {
            return this.pageContainer;
        }
        return (PageContainer) ipChange.ipc$dispatch("1278709243", new Object[]{this});
    }

    @Nullable
    public final PageContext getPageContext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1034969157")) {
            return this.pageContext;
        }
        return (PageContext) ipChange.ipc$dispatch("-1034969157", new Object[]{this});
    }

    @Nullable
    public final PageLoader getPageLoader() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-507864517")) {
            return this.pageLoader;
        }
        return (PageLoader) ipChange.ipc$dispatch("-507864517", new Object[]{this});
    }

    @Nullable
    public final String getPageName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1277630723")) {
            return this.pageName;
        }
        return (String) ipChange.ipc$dispatch("-1277630723", new Object[]{this});
    }

    @Nullable
    public final RecycleViewSettings getRecyclerViewSettings() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-177078905")) {
            return this.recyclerViewSettings;
        }
        return (RecycleViewSettings) ipChange.ipc$dispatch("-177078905", new Object[]{this});
    }

    @Nullable
    public final RequestBuilder getRequestBuilder() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2070599622")) {
            return this.requestBuilder;
        }
        return (RequestBuilder) ipChange.ipc$dispatch("-2070599622", new Object[]{this});
    }

    @Subscribe(eventType = {FragmentEvent.ON_FRAGMENT_DESTROY})
    public final void onFragmentDestroy(@Nullable Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-583638004")) {
            ipChange.ipc$dispatch("-583638004", new Object[]{this, event});
            return;
        }
        release();
    }

    public final void preload() {
        PageContainer<ModelValue> pageContainer2;
        ContentAdapter adapter;
        PageContainer<ModelValue> pageContainer3;
        PageContext pageContext2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-216995446")) {
            ipChange.ipc$dispatch("-216995446", new Object[]{this});
            return;
        }
        PageContext pageContext3 = this.pageContext;
        if (pageContext3 != null) {
            Context context2 = getContext();
            pageContext3.setActivity(context2 instanceof Activity ? (Activity) context2 : null);
            pageContext3.setPageContainer(getPageContainer());
            pageContext3.setPageName(getPageName());
            pageContext3.setBaseContext(getActivityContext() != null ? getActivityContext() : new ActivityContext());
        }
        ConfigManager configManager2 = this.configManager;
        if (!(configManager2 == null || (pageContext2 = getPageContext()) == null)) {
            pageContext2.setConfigManager(configManager2);
        }
        RecycleViewSettings recycleViewSettings = this.recyclerViewSettings;
        if (!(recycleViewSettings == null || (adapter = recycleViewSettings.getAdapter()) == null || (pageContainer3 = getPageContainer()) == null)) {
            pageContainer3.setContentAdapter(adapter);
        }
        RequestBuilder requestBuilder2 = this.requestBuilder;
        if (!(requestBuilder2 == null || (pageContainer2 = getPageContainer()) == null)) {
            pageContainer2.setRequestBuilder(requestBuilder2);
        }
        PageLoader pageLoader2 = this.pageLoader;
        if (pageLoader2 != null) {
            PageContainer<ModelValue> pageContainer4 = getPageContainer();
            if (pageContainer4 != null) {
                pageContainer4.setPageLoader(pageLoader2);
            }
            pageLoader2.load(new HashMap());
        }
    }

    public final void release() {
        PageContext pageContext2;
        EventBus eventBus;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1574893876")) {
            ipChange.ipc$dispatch("-1574893876", new Object[]{this});
            return;
        }
        GenericFragment genericFragment2 = this.genericFragment;
        if (!(genericFragment2 == null || (pageContext2 = genericFragment2.getPageContext()) == null || (eventBus = pageContext2.getEventBus()) == null || !eventBus.isRegistered(this))) {
            eventBus.unregister(this);
        }
        this.pageContext = null;
        this.activityContext = null;
        this.pageContainer = null;
        this.configManager = null;
        this.pageLoader = null;
    }

    public final void setActivityContext(@Nullable ActivityContext activityContext2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1382066539")) {
            ipChange.ipc$dispatch("1382066539", new Object[]{this, activityContext2});
            return;
        }
        this.activityContext = activityContext2;
    }

    public final void setConfigManager(@Nullable ConfigManager configManager2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-463449387")) {
            ipChange.ipc$dispatch("-463449387", new Object[]{this, configManager2});
            return;
        }
        this.configManager = configManager2;
    }

    public final void setGenericFragment(@Nullable GenericFragment genericFragment2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "266419565")) {
            ipChange.ipc$dispatch("266419565", new Object[]{this, genericFragment2});
            return;
        }
        this.genericFragment = genericFragment2;
    }

    public final void setPageContainer(@Nullable PageContainer<ModelValue> pageContainer2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-575824889")) {
            ipChange.ipc$dispatch("-575824889", new Object[]{this, pageContainer2});
            return;
        }
        this.pageContainer = pageContainer2;
    }

    public final void setPageContext(@Nullable PageContext pageContext2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-36535317")) {
            ipChange.ipc$dispatch("-36535317", new Object[]{this, pageContext2});
            return;
        }
        this.pageContext = pageContext2;
    }

    public final void setPageLoader(@Nullable PageLoader pageLoader2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1448359553")) {
            ipChange.ipc$dispatch("1448359553", new Object[]{this, pageLoader2});
            return;
        }
        this.pageLoader = pageLoader2;
    }

    public final void setPageName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-834174591")) {
            ipChange.ipc$dispatch("-834174591", new Object[]{this, str});
            return;
        }
        this.pageName = str;
    }

    public final void setRecyclerViewSettings(@Nullable RecycleViewSettings recycleViewSettings) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1689623791")) {
            ipChange.ipc$dispatch("-1689623791", new Object[]{this, recycleViewSettings});
            return;
        }
        this.recyclerViewSettings = recycleViewSettings;
    }

    public final void setRequestBuilder(@Nullable RequestBuilder requestBuilder2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1428927852")) {
            ipChange.ipc$dispatch("-1428927852", new Object[]{this, requestBuilder2});
            return;
        }
        this.requestBuilder = requestBuilder2;
    }

    public void setDelegatedContainer(@Nullable GenericFragment genericFragment2) {
        PageContext pageContext2;
        EventBus eventBus;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-359612278")) {
            ipChange.ipc$dispatch("-359612278", new Object[]{this, genericFragment2});
            return;
        }
        this.genericFragment = genericFragment2;
        if (genericFragment2 != null && (pageContext2 = genericFragment2.getPageContext()) != null && (eventBus = pageContext2.getEventBus()) != null && !eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
    }
}
