package com.youku.arch.v3.loader;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ModuleValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.util.Util;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import tb.k21;
import tb.m40;

public class ModuleLoader extends AbsLoader<IModule<ModuleValue>> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_PAGE_START;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModuleLoader(IModule<ModuleValue> iModule) {
        super(iModule);
        k21.i(iModule, "module");
        setLoadingViewManager(((IModule) getHost()).getContainer().getPageLoader().getLoadingViewManager());
        setStartPage(2);
        setLoadingPage(getStartPage());
    }

    private final void createComponents(Node node, int i) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-361465568")) {
            ipChange.ipc$dispatch("-361465568", new Object[]{this, node, Integer.valueOf(i)});
            return;
        }
        if (node != null) {
            z = false;
        }
        Util.throwIf(z);
        k21.f(node);
        ((IModule) getHost()).initProperties(node);
        int childCount = ((IModule) getHost()).getChildCount();
        List<Node> children = ((IModule) getHost()).getProperty().getChildren();
        k21.f(children);
        ((IModule) getHost()).createComponents(children);
        ((IModule) getHost()).getPageContext().runOnUIThreadLocked(new ModuleLoader$createComponents$1(this, i, childCount));
    }

    private final Node parseNode(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-713289422")) {
            return (Node) ipChange.ipc$dispatch("-713289422", new Object[]{this, jSONObject});
        }
        if (jSONObject.containsKey("data")) {
            jSONObject = jSONObject.getJSONObject("data");
            k21.h(jSONObject, "dataResponse.getJSONObject(Constants.DATA)");
        }
        return NodeParser.INSTANCE.parse(null, jSONObject);
    }

    /* access modifiers changed from: public */
    private final void setLoadingViewState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1089770835")) {
            ipChange.ipc$dispatch("-1089770835", new Object[]{this});
        } else if (hasNext()) {
            getLoadingViewManager().onLoadNextSuccess();
            setLoadingPage(getLoadingPage() + 1);
            getLoadingPage();
            setLoadingState(0);
        } else {
            setLoadingState(3);
            getLoadingViewManager().onAllPageLoaded();
        }
    }

    @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.AbsLoader
    public void handleLoadFailure(IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-368380028")) {
            ipChange.ipc$dispatch("-368380028", new Object[]{this, iResponse});
            return;
        }
        k21.i(iResponse, "response");
        ((IModule) getHost()).getPageContext().runOnUIThreadLocked(new ModuleLoader$handleLoadFailure$1(this));
    }

    @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.AbsLoader
    public void handleLoadSuccess(IResponse iResponse, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "405893624")) {
            ipChange.ipc$dispatch("405893624", new Object[]{this, iResponse, Integer.valueOf(i)});
            return;
        }
        k21.i(iResponse, "response");
        setLoadingPage(i);
        ((IModule) getHost()).getPageContext().runOnLoaderThreadLocked(new ModuleLoader$handleLoadSuccess$1(this, iResponse, i));
    }

    public boolean hasNext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1175883082")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1175883082", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.AbsLoader
    public void load(Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "962201312")) {
            ipChange.ipc$dispatch("962201312", new Object[]{this, map});
            return;
        }
        k21.i(map, Constants.CONFIG);
        Object obj = map.get("index");
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) obj).intValue();
        IRequest createRequest = ((IModule) getHost()).createRequest(map);
        if (createRequest != null) {
            ((IModule) getHost()).request(createRequest, new ModuleLoader$load$1$1(this, intValue));
        }
    }

    @Override // com.youku.arch.v3.loader.PagingLoader, com.youku.arch.v3.loader.AbsLoader
    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1888622256")) {
            ipChange.ipc$dispatch("-1888622256", new Object[]{this});
            return;
        }
        setLoadingState(0);
        setLoadingPage(getStartPage());
    }
}
