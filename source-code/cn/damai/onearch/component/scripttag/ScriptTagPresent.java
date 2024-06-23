package cn.damai.onearch.component.scripttag;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import cn.damai.common.AppConfig;
import cn.damai.live.LiveActivity;
import cn.damai.onearch.component.scripttag.ScriptTagContract;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.request.DRParam;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.ut.device.UTDevice;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.component.GenericComponent;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.data.Request;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.loader.NodeParser;
import com.youku.arch.v3.util.IdGenerator;
import com.youku.live.livesdk.model.mtop.LiveFullInfo;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.m;
import tb.d20;
import tb.hp1;
import tb.jl1;
import tb.k21;
import tb.lp1;
import tb.m40;

public final class ScriptTagPresent extends AbsPresenter<GenericItem<ItemValue>, ScriptTagModel, ScriptTagContract.View> implements ScriptTagContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final a Companion = new a(null);
    public static final boolean NEED_ENCODE;
    public static final boolean NEED_SESSION;
    public static final String VERSION;
    private int currentSelectTagPosition;
    private String storeId;
    private IComponent<ComponentValue> targetComponent;

    public final class ScriptRequestBuilder implements RequestBuilder {
        private static transient /* synthetic */ IpChange $ipChange;
        private Map<String, Object> params = new LinkedHashMap();
        private long strategy = 2;
        private final int tabPosition;

        public ScriptRequestBuilder(int i) {
            ScriptTagPresent.this = r1;
            this.tabPosition = i;
        }

        @Override // com.youku.arch.v3.io.RequestBuilder
        public IRequest build(Map<String, ? extends Object> map) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "453821724")) {
                return (IRequest) ipChange.ipc$dispatch("453821724", new Object[]{this, map});
            }
            k21.i(map, Constants.CONFIG);
            this.params.put("patternName", "dm_app_script_store");
            this.params.put("patternVersion", LiveFullInfo.VER);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Activity activity = ((GenericItem) ScriptTagPresent.this.getItem()).getPageContext().getActivity();
            if (activity != null) {
                String utdid = UTDevice.getUtdid(activity);
                k21.h(utdid, "getUtdid(this)");
                linkedHashMap.put("utdid", utdid);
            }
            String c = d20.c();
            k21.h(c, "getCityId()");
            linkedHashMap.put("comboDamaiCityId", c);
            if (hp1.i(lp1.LOCATION)) {
                linkedHashMap.put("latitude", Double.valueOf(d20.n()));
                linkedHashMap.put("longitude", Double.valueOf(d20.o()));
            }
            String p = AppConfig.p();
            k21.h(p, "getTtid()");
            linkedHashMap.put(LiveActivity.OPTION_TTID, p);
            linkedHashMap.put("comboChannel", "1");
            linkedHashMap.put("pageNo", "1");
            linkedHashMap.put(Constants.Name.PAGE_SIZE, 10);
            String str = ScriptTagPresent.this.storeId;
            if (str != null) {
                linkedHashMap.put("storeId", str);
            }
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            String tagValue = ((ScriptTagModel) ScriptTagPresent.this.getModel()).getTagValue(this.tabPosition);
            if (tagValue.length() <= 0) {
                z = false;
            }
            Object obj = null;
            if (!z) {
                tagValue = null;
            }
            if (tagValue != null) {
                arrayList.add(tagValue);
            }
            jSONObject.put((Object) ((ScriptTagModel) ScriptTagPresent.this.getModel()).getTagsOption(), (Object) arrayList);
            String jSONString = JSON.toJSONString(jSONObject);
            k21.h(jSONString, "toJSONString(option)");
            linkedHashMap.put("option", jSONString);
            IComponent iComponent = ScriptTagPresent.this.targetComponent;
            if (iComponent != null) {
                JSONObject data = iComponent.getModule().getProperty().getData();
                String str2 = (String) (data != null ? data.get("nodeId") : null);
                JSONObject data2 = iComponent.getProperty().getData();
                if (data2 != null) {
                    obj = data2.get("nodeId");
                }
                DRParam dRParam = new DRParam(str2, (String) obj, JSON.toJSONString(linkedHashMap));
                this.params.put("dr", jl1.ARRAY_START + JSON.toJSONString(dRParam) + jl1.ARRAY_END);
            }
            Map<String, Object> map2 = this.params;
            String jSONString2 = JSON.toJSONString(linkedHashMap);
            k21.h(jSONString2, "toJSONString(args)");
            map2.put("args", jSONString2);
            return new Request.Builder().setApiName("mtop.damai.mec.aristotle.get").setVersion("2.0").setNeedECode(false).setNeedSession(false).setTimeout(10000).setStrategy(this.strategy).setRequestId(IdGenerator.getId()).setDataParams(new HashMap(this.params)).build();
        }
    }

    public final class ScriptRequestCallBack implements Callback {
        private static transient /* synthetic */ IpChange $ipChange;

        public ScriptRequestCallBack() {
            ScriptTagPresent.this = r1;
        }

        @Override // com.youku.arch.v3.io.Callback
        public void onResponse(IResponse iResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1341427889")) {
                ipChange.ipc$dispatch("-1341427889", new Object[]{this, iResponse});
                return;
            }
            k21.i(iResponse, "response");
            if (iResponse.isSuccess()) {
                ScriptTagPresent.this.handleLoadSuccess(iResponse);
            } else {
                ScriptTagPresent.this.handleLoadFailure();
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScriptTagPresent(String str, String str2, View view, EventHandler eventHandler, String str3) {
        super(str, str2, view, eventHandler, str3);
        k21.i(str, "mClassName");
        k21.i(str2, "vClassName");
        k21.i(eventHandler, "eventHandler");
    }

    public static final /* synthetic */ void access$createItems(ScriptTagPresent scriptTagPresent, Node node) {
        scriptTagPresent.createItems(node);
    }

    private final void createItems(Node node) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "40932415")) {
            ipChange.ipc$dispatch("40932415", new Object[]{this, node});
            return;
        }
        IComponent<ComponentValue> iComponent = this.targetComponent;
        GenericComponent genericComponent = iComponent instanceof GenericComponent ? (GenericComponent) iComponent : null;
        if (genericComponent != null && node.getType() == genericComponent.getType()) {
            genericComponent.initProperties(node);
            try {
                genericComponent.childItems.clear();
                List<Node> children = genericComponent.getProperty().getChildren();
                if (children != null) {
                    for (T t : children) {
                        int i2 = i + 1;
                        if (i < 0) {
                            m.p();
                        }
                        T t2 = t;
                        try {
                            IItem<ItemValue> createItem = genericComponent.createItem(new Config<>(genericComponent.getPageContext(), t2.getType(), t2, 0, false, 24, null));
                            if (createItem != null) {
                                genericComponent.childItems.add(createItem);
                                createItem.setIndex(i);
                                createItem.onAdd();
                                genericComponent.getChildIndexUpdater().onChildAdded(createItem);
                            }
                        } catch (Exception e) {
                            if (AppInfoProviderProxy.isDebuggable()) {
                                throw e;
                            }
                        }
                        i = i2;
                    }
                }
                genericComponent.getPageContext().runOnUIThreadLocked(new ScriptTagPresent$createItems$1$2(genericComponent));
            } catch (Exception e2) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw e2;
                }
            }
        }
    }

    /* access modifiers changed from: public */
    private final Node parseNode(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1845772560")) {
            return (Node) ipChange.ipc$dispatch("1845772560", new Object[]{this, jSONObject});
        }
        if (jSONObject.containsKey("data")) {
            jSONObject = jSONObject.getJSONObject("data");
            k21.h(jSONObject, "dataJsonObject.getJSONObject(Constants.DATA)");
        }
        return NodeParser.INSTANCE.parse(null, jSONObject);
    }

    public final void handleLoadFailure() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1891737445")) {
            ipChange.ipc$dispatch("1891737445", new Object[]{this});
            return;
        }
        ((GenericItem) getItem()).getPageContext().runOnUIThreadLocked(ScriptTagPresent$handleLoadFailure$1.INSTANCE);
    }

    public final void handleLoadSuccess(IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1140371405")) {
            ipChange.ipc$dispatch("1140371405", new Object[]{this, iResponse});
            return;
        }
        k21.i(iResponse, "response");
        ((GenericItem) getItem()).getPageContext().runOnLoaderThreadLocked(new ScriptTagPresent$handleLoadSuccess$1(iResponse, this));
    }

    @Override // cn.damai.onearch.component.scripttag.ScriptTagContract.Presenter
    public void selectTag(int i) {
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "119963072")) {
            ipChange.ipc$dispatch("119963072", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.currentSelectTagPosition = i;
        Action itemAction = getItemAction();
        if (!(itemAction == null || (trackInfo = itemAction.getTrackInfo()) == null)) {
            HashMap<String, String> args = trackInfo.getArgs();
            if (args != null) {
                k21.h(args, "args");
                args.put("tagId", ((ScriptTagModel) getModel()).getTagValue(i));
            }
            UserTrackProviderProxy.click(trackInfo, false);
        }
        ((GenericItem) getItem()).getPageContext().runOnLoaderThread(new ScriptTagPresent$selectTag$2(this, i));
    }

    public void init(GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-401499849")) {
            ipChange.ipc$dispatch("-401499849", new Object[]{this, genericItem});
            return;
        }
        k21.i(genericItem, "item");
        super.init((IItem) genericItem);
        Bundle bundle = genericItem.getPageContext().getBundle();
        this.storeId = bundle != null ? bundle.getString("storeId") : null;
        for (T t : genericItem.getComponent().getModule().getComponents()) {
            if (t.getType() == Integer.parseInt(((ScriptTagModel) getModel()).getTargetComponentType())) {
                this.targetComponent = t;
            }
        }
        ((ScriptTagContract.View) getView()).renderTags(((ScriptTagModel) getModel()).getTags(), this.currentSelectTagPosition);
    }
}
