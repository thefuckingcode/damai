package cn.damai.homepage.v2.feed;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.loader.v2.GenericComponentLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.GenericFactory;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.component.GenericComponent;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.loader.LoadingViewAdapter;
import com.youku.arch.v3.loader.LoadingViewManager;
import com.youku.arch.v3.loader.PagingLoader;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.fh0;
import tb.hx0;
import tb.k21;

/* compiled from: Taobao */
public final class FeedComponent extends GenericComponent<ComponentValue> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final IContext context;
    @NotNull
    private FeedLoadingListener feedLoadingListener = new FeedLoadingListener();

    /* compiled from: Taobao */
    public final class FeedComponentLoader extends GenericComponentLoader {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FeedComponent this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FeedComponentLoader(@NotNull FeedComponent feedComponent, IComponent<ComponentValue> iComponent) {
            super(iComponent);
            k21.i(iComponent, "component");
            this.this$0 = feedComponent;
        }

        @Override // com.alient.onearch.adapter.loader.v2.GenericComponentLoader
        public void handleItemNode(@NotNull ListIterator<Node> listIterator, @NotNull Node node) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1736069360")) {
                ipChange.ipc$dispatch("-1736069360", new Object[]{this, listIterator, node});
                return;
            }
            k21.i(listIterator, "itemIterator");
            k21.i(node, "itemNode");
            fh0.INSTANCE.a(node);
            super.handleItemNode(listIterator, node);
        }
    }

    /* compiled from: Taobao */
    public final class FeedLoadingListener extends LoadingViewAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public FeedLoadingListener() {
        }

        @Override // com.youku.arch.v3.loader.LoadingViewAdapter, com.youku.arch.v3.loader.ILoadingViewListener
        public void onAllPageLoaded() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-883160178")) {
                ipChange.ipc$dispatch("-883160178", new Object[]{this});
                return;
            }
            PagingLoader componentLoader = FeedComponent.this.getComponentLoader();
            if (componentLoader != null) {
                FeedComponent feedComponent = FeedComponent.this;
                feedComponent.getPageContext().runOnUIThread(new FeedComponent$FeedLoadingListener$onAllPageLoaded$1$1(componentLoader, feedComponent));
            }
        }

        @Override // com.youku.arch.v3.loader.LoadingViewAdapter, com.youku.arch.v3.loader.ILoadingViewListener
        public void onLoadNextFailure(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-222947972")) {
                ipChange.ipc$dispatch("-222947972", new Object[]{this, str});
                return;
            }
            FeedComponent.this.getPageContext().runOnUIThread(FeedComponent$FeedLoadingListener$onLoadNextFailure$1.INSTANCE);
        }
    }

    /* compiled from: Taobao */
    public final class FeedRequestBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public FeedRequestBuilder() {
        }

        @Override // com.youku.arch.v3.io.RequestBuilder
        @NotNull
        public IRequest build(@NotNull Map<String, ? extends Object> map) {
            Object obj;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1602003648")) {
                return (IRequest) ipChange.ipc$dispatch("1602003648", new Object[]{this, map});
            }
            k21.i(map, Constants.CONFIG);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            Object obj2 = map.get("index");
            if (obj2 != null) {
                hashMap2.put("pageNo", (Integer) obj2);
            }
            JSONObject data = FeedComponent.this.getProperty().getData();
            if (!(data == null || (obj = data.get("offSet")) == null)) {
                hashMap2.put("offSet", obj);
            }
            JSONObject data2 = FeedComponent.this.getModule().getProperty().getData();
            Object obj3 = null;
            String str = (String) (data2 != null ? data2.get("nodeId") : null);
            JSONObject data3 = FeedComponent.this.getProperty().getData();
            if (data3 != null) {
                obj3 = data3.get("nodeId");
            }
            return hx0.INSTANCE.a(2, hashMap2, hashMap, str, (String) obj3);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedComponent(@NotNull IContext iContext, @NotNull Node node) {
        super(iContext, node);
        k21.i(iContext, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(node, Constants.CONFIG);
        this.context = iContext;
        setComponentLoader(new FeedComponentLoader(this, this));
        setRequestBuilder(new FeedRequestBuilder());
    }

    @Override // com.youku.arch.v3.IItemManager, com.youku.arch.v3.core.component.GenericComponent
    @Nullable
    public IItem<ItemValue> createItem(@NotNull Config<Node> config) {
        Node node;
        JSONObject data;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        JSONObject jSONObject6;
        JSONObject jSONObject7;
        JSONObject jSONObject8;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "882832341")) {
            return (IItem) ipChange.ipc$dispatch("882832341", new Object[]{this, config});
        }
        k21.i(config, Constants.CONFIG);
        GenericFactory<IItem<ItemValue>, Node> itemFactory = getItemFactory();
        String str = null;
        IItem<ItemValue> create = itemFactory != null ? itemFactory.create(config) : null;
        if (create != null) {
            k21.g(this, "null cannot be cast to non-null type com.youku.arch.v3.IComponent<com.youku.arch.v3.core.ComponentValue>");
            create.setComponent(this);
            create.initProperties(config.getData());
            JSONObject data2 = create.getComponent().getProperty().getData();
            if (!(data2 == null || (jSONObject5 = data2.getJSONObject("action")) == null || (jSONObject6 = jSONObject5.getJSONObject("tab")) == null || (jSONObject7 = jSONObject6.getJSONObject("trackInfo")) == null || (jSONObject8 = jSONObject7.getJSONObject("args")) == null)) {
                str = jSONObject8.getString("titlelabel");
            }
            if (!(TextUtils.isEmpty(str) || (node = ((GenericItem) create).getNode()) == null || (data = node.getData()) == null || (jSONObject = data.getJSONObject("action")) == null || (jSONObject2 = jSONObject.getJSONObject("item")) == null || (jSONObject3 = jSONObject2.getJSONObject("trackInfo")) == null || (jSONObject4 = jSONObject3.getJSONObject("args")) == null)) {
                k21.h(jSONObject4, "getJSONObject(\"args\")");
                jSONObject4.put((Object) "titlelabel", (Object) str);
            }
        }
        return create;
    }

    @NotNull
    public final IContext getContext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1212194823")) {
            return this.context;
        }
        return (IContext) ipChange.ipc$dispatch("1212194823", new Object[]{this});
    }

    @Override // com.youku.arch.v3.DomainObject, com.youku.arch.v3.core.component.GenericComponent
    public void onAdd() {
        LoadingViewManager loadingViewManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "860215792")) {
            ipChange.ipc$dispatch("860215792", new Object[]{this});
            return;
        }
        super.onAdd();
        PagingLoader componentLoader = getComponentLoader();
        if (componentLoader != null && (loadingViewManager = componentLoader.getLoadingViewManager()) != null) {
            loadingViewManager.removeLoadingStateListener(this.feedLoadingListener);
            loadingViewManager.addLoadingStateListener(this.feedLoadingListener);
        }
    }

    @Override // com.youku.arch.v3.DomainObject, com.youku.arch.v3.core.component.GenericComponent
    public void onRemove() {
        LoadingViewManager loadingViewManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1201525813")) {
            ipChange.ipc$dispatch("1201525813", new Object[]{this});
            return;
        }
        super.onRemove();
        FeedLoadingListener feedLoadingListener2 = this.feedLoadingListener;
        PagingLoader componentLoader = getComponentLoader();
        if (componentLoader != null && (loadingViewManager = componentLoader.getLoadingViewManager()) != null) {
            loadingViewManager.removeLoadingStateListener(feedLoadingListener2);
        }
    }
}
