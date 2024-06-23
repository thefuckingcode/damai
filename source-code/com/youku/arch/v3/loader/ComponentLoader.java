package com.youku.arch.v3.loader;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.component.GenericComponent;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.util.ArchMontior;
import com.youku.arch.v3.util.ArchMontiorManager;
import com.youku.arch.v3.util.LogUtil;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u001a2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u001aB\u0015\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016¨\u0006\u001b"}, d2 = {"Lcom/youku/arch/v3/loader/ComponentLoader;", "Lcom/youku/arch/v3/loader/AbsLoader;", "Lcom/youku/arch/v3/IComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", "", "", "", Constants.CONFIG, "Ltb/ur2;", "load", "Lcom/youku/arch/v3/io/IResponse;", "response", "", "index", "handleLoadSuccess", "handleLoadFailure", "Lcom/youku/arch/v3/core/Node;", "node", "createItems", "Lcom/alibaba/fastjson/JSONObject;", "parseNode", "setLoadingViewState", "reset", "component", "<init>", "(Lcom/youku/arch/v3/IComponent;)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public class ComponentLoader extends AbsLoader<IComponent<ComponentValue>> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_PAGE_START = 2;
    public static final int REFRESH_PAGE_INDEX = 1;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/youku/arch/v3/loader/ComponentLoader$Companion;", "", "", "DEFAULT_PAGE_START", "I", "REFRESH_PAGE_INDEX", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComponentLoader(@NotNull IComponent<ComponentValue> iComponent) {
        super(iComponent);
        RefreshLayout refreshLayout;
        k21.i(iComponent, "component");
        GenericFragment fragment = ((IComponent) getHost()).getPageContext().getFragment();
        if (!(fragment == null || (refreshLayout = fragment.getRefreshLayout()) == null)) {
            RefreshLayoutManger refreshLayoutManger = new RefreshLayoutManger();
            refreshLayoutManger.setRefreshLayout(refreshLayout);
            getLoadingViewManager().addLoadingStateListener(refreshLayoutManger);
        }
        setStartPage(2);
        setLoadingPage(getStartPage());
    }

    public void createItems(@NotNull Node node, int i) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1603987063")) {
            ipChange.ipc$dispatch("1603987063", new Object[]{this, node, Integer.valueOf(i)});
            return;
        }
        k21.i(node, "node");
        IComponent iComponent = (IComponent) getHost();
        if (node.getType() == iComponent.getType()) {
            int childCount = iComponent.getChildCount();
            iComponent.initProperties(node);
            if (i == 1) {
                ((GenericComponent) getHost()).childItems.clear();
            }
            List<Node> children = node.getChildren();
            if (children == null || children.isEmpty()) {
                z = true;
            }
            if (z) {
                iComponent.getPageContext().runOnUIThread(new ComponentLoader$createItems$1$1(i, iComponent, childCount, this));
            } else {
                iComponent.getPageContext().runOnUIThreadLocked(new ComponentLoader$createItems$1$2(iComponent, this, i, childCount));
            }
        } else {
            ((IComponent) getHost()).getPageContext().runOnUIThread(new ComponentLoader$createItems$1$3(this));
        }
    }

    @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.AbsLoader
    public void handleLoadFailure(@NotNull IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1821103545")) {
            ipChange.ipc$dispatch("1821103545", new Object[]{this, iResponse});
            return;
        }
        k21.i(iResponse, "response");
        ((IComponent) getHost()).getPageContext().runOnUIThread(new ComponentLoader$handleLoadFailure$1(this));
    }

    @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.AbsLoader
    public void handleLoadSuccess(@NotNull IResponse iResponse, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-439592349")) {
            ipChange.ipc$dispatch("-439592349", new Object[]{this, iResponse, Integer.valueOf(i)});
            return;
        }
        k21.i(iResponse, "response");
        setLoadingPage(i);
        ((IComponent) getHost()).getPageContext().runOnLoaderThreadLocked(new ComponentLoader$handleLoadSuccess$1(iResponse, this, i));
    }

    @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.AbsLoader
    public void load(@NotNull Map<String, ? extends Object> map) {
        ArchMontior archMontior;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-360366123")) {
            ipChange.ipc$dispatch("-360366123", new Object[]{this, map});
            return;
        }
        k21.i(map, Constants.CONFIG);
        Object obj = map.get("index");
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) obj).intValue();
        IComponent iComponent = (IComponent) getHost();
        IRequest createRequest = iComponent.createRequest(map);
        if (createRequest != null) {
            String pageName = ((IComponent) getHost()).getPageContext().getPageName();
            if (!(pageName == null || (archMontior = ArchMontiorManager.Companion.get(pageName)) == null)) {
                LogUtil.d(ArchMontiorManager.TAG, "ComponentLoader request +++ ");
                archMontior.setRequestTime(System.currentTimeMillis());
                archMontior.setApiName(createRequest.getApiName());
            }
            iComponent.request(createRequest, new ComponentLoader$load$1$1$2(this, intValue));
        }
    }

    @Nullable
    public Node parseNode(@NotNull JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1266575843")) {
            return (Node) ipChange.ipc$dispatch("-1266575843", new Object[]{this, jSONObject});
        }
        k21.i(jSONObject, "response");
        if (jSONObject.containsKey("data")) {
            jSONObject = jSONObject.getJSONObject("data");
            k21.h(jSONObject, "dataJsonObject.getJSONObject(Constants.DATA)");
        }
        return NodeParser.INSTANCE.parse(null, jSONObject);
    }

    @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.AbsLoader
    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1922645243")) {
            ipChange.ipc$dispatch("-1922645243", new Object[]{this});
            return;
        }
        setLoadingState(0);
        setLoadingPage(getStartPage());
    }

    public void setLoadingViewState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1882629026")) {
            ipChange.ipc$dispatch("1882629026", new Object[]{this});
        } else if (((IComponent) getHost()).hasNext()) {
            getLoadingViewManager().onLoadNextSuccess();
            setLoadingPage(getLoadingPage() + 1);
            getLoadingPage();
            setLoadingState(0);
        } else {
            setLoadingState(3);
            getLoadingViewManager().onAllPageLoaded();
        }
    }
}
