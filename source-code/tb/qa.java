package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.convertor.IConverter;
import cn.damai.tetris.v2.convertor.ILayerStyleBuilder;
import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* compiled from: Taobao */
public class qa {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_DAOJISHI = "key_daojishi";
    public static final String KEY_ITEMRESULT = "result";
    public static final String KEY_PROJECT = "key_project";
    public static final String KEY_SHOW_DIS = "key_showDis";
    public static final String TRACKKEY_CATEGORY_NAME = "track_categoryName";
    public static final String TRACKKEY_CITY = "track_city";
    public static final String TRACKKEY_CURRENT_ITEM_TOTAL = "track_currentItemTotal";
    public static final String TRACKKEY_IS_CURRENT_CITY = "isCurrentCity";
    private static TreeSet<String> b = new TreeSet<>();
    private static HashMap<String, IConverter<BaseResponse, BaseSection, GlobalConfig, List<Node>>> c = new HashMap<>();
    private static HashMap<String, ILayerStyleBuilder> d = new HashMap<>();
    public String a = "BaseResponse2Node";

    public static void a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "654858647")) {
            ipChange.ipc$dispatch("654858647", new Object[]{str});
            return;
        }
        b.add(str);
    }

    public static void b(String str, IConverter<BaseResponse, BaseSection, GlobalConfig, List<Node>> iConverter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-198386712")) {
            ipChange.ipc$dispatch("-198386712", new Object[]{str, iConverter});
            return;
        }
        c.put(str, iConverter);
    }

    public static void c(String str, ILayerStyleBuilder iLayerStyleBuilder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1730108421")) {
            ipChange.ipc$dispatch("-1730108421", new Object[]{str, iLayerStyleBuilder});
            return;
        }
        d.put(str, iLayerStyleBuilder);
    }

    public static void d(BaseResponse baseResponse, TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "86904376")) {
            ipChange.ipc$dispatch("86904376", new Object[]{baseResponse, trackInfo});
        } else if (baseResponse != null && !kw2.a(baseResponse.layers) && trackInfo != null) {
            Iterator<BaseLayer> it = baseResponse.layers.iterator();
            while (it.hasNext()) {
                List<BaseSection> sections = it.next().getSections();
                if (sections != null) {
                    for (BaseSection baseSection : sections) {
                        if (baseSection != null && j(baseSection.getComponentId())) {
                            baseSection.setTrackInfo(trackInfo);
                        }
                    }
                }
            }
        }
    }

    @NonNull
    private TrackInfo h(String str, BaseSection baseSection, GlobalConfig globalConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-115452084")) {
            return (TrackInfo) ipChange.ipc$dispatch("-115452084", new Object[]{this, str, baseSection, globalConfig});
        }
        TrackInfo trackInfo = new TrackInfo();
        if (baseSection.getTrackInfo() != null) {
            trackInfo = baseSection.getTrackInfo();
        }
        if (!TextUtils.isEmpty(str)) {
            trackInfo.trackB = str;
        }
        if (!TextUtils.isEmpty(trackInfo.getString("spmc"))) {
            trackInfo.trackC = trackInfo.getString("spmc");
        }
        if (!(globalConfig == null || globalConfig.getBuzUTMap() == null)) {
            trackInfo.getInnerMap().putAll(globalConfig.getBuzUTMap());
        }
        return trackInfo;
    }

    public static boolean j(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1167090715")) {
            return TextUtils.equals(wj2.DISCOVER_FEED_COMPONENT_ID, str);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1167090715", new Object[]{str})).booleanValue();
    }

    public static boolean k(BaseResponse baseResponse) {
        NodeData item;
        Boolean bool;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1695288199")) {
            return ((Boolean) ipChange.ipc$dispatch("1695288199", new Object[]{baseResponse})).booleanValue();
        }
        if (baseResponse != null && !kw2.a(baseResponse.layers)) {
            ArrayList<BaseLayer> arrayList = baseResponse.layers;
            for (int i = 0; i < arrayList.size(); i++) {
                List<BaseSection> sections = arrayList.get(i).getSections();
                if (!kw2.a(sections)) {
                    for (BaseSection baseSection : sections) {
                        if (!(!j(baseSection.getComponentId()) || (item = baseSection.getItem()) == null || (bool = item.getBoolean(wj2.HAS_NEXT)) == null)) {
                            return bool.booleanValue();
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01f3  */
    private List<Node> m(BaseResponse baseResponse, BaseLayer baseLayer, GlobalConfig globalConfig, int i) {
        Iterator<BaseSection> it;
        Node node;
        List<Node> arrayList;
        IpChange ipChange = $ipChange;
        int i2 = 0;
        int i3 = 1;
        if (AndroidInstantRuntime.support(ipChange, "-1758823749")) {
            return (List) ipChange.ipc$dispatch("-1758823749", new Object[]{this, baseResponse, baseLayer, globalConfig, Integer.valueOf(i)});
        } else if (baseLayer == null || baseLayer.getSections() == null) {
            n91.a(this.a, "========= parseByBaseLayer ========= error null : ");
            return null;
        } else {
            n91.a(this.a, "========= start parseByBaseLayer ========= : ");
            ArrayList arrayList2 = new ArrayList();
            Iterator<BaseSection> it2 = baseLayer.getSections().iterator();
            while (it2.hasNext()) {
                BaseSection next = it2.next();
                if (next != null) {
                    if (i2 == 0 && baseLayer.getStyle() != null) {
                        if (next.getStyle() == null) {
                            next.setStyle(new JSONObject());
                        }
                        if (baseLayer.getStyle().getConnerStyle() != null && baseLayer.getStyle().getConnerStyle().fillet) {
                            next.getStyle().put("native", (Object) baseLayer.getStyle().getConnerStyle());
                        }
                    }
                    if (j(next.getComponentId()) && next.getStyle() != null && !TextUtils.isEmpty(next.getStyle().getString("title"))) {
                        if (i <= i3 && next.getItem() != null && next.getItem().getJSONArray("card") != null && next.getItem().getJSONArray("card").size() > 0) {
                            Node node2 = new Node();
                            JSONObject jSONObject = new JSONObject();
                            node2.data = jSONObject;
                            jSONObject.put("node_id", (Object) baseLayer.getLayerId());
                            node2.data.put("layer_server_cid", (Object) "dm_card_common_title");
                            node2.data.put(Constants.LAYOUT_TYPE, (Object) "linear");
                            node2.children = new ArrayList();
                            BaseSection baseSection = new BaseSection();
                            baseSection.setComponentId("dm_card_common_title");
                            JSONObject jSONObject2 = new JSONObject();
                            it = it2;
                            jSONObject2.put("title", (Object) next.getStyle().getString("title"));
                            baseSection.setItem(jSONObject2);
                            node2.children.addAll(l(baseSection, globalConfig));
                            arrayList2.add(node2);
                            i2++;
                            node = new Node();
                            JSONObject jSONObject3 = new JSONObject();
                            node.data = jSONObject3;
                            jSONObject3.put("node_id", (Object) baseLayer.getLayerId());
                            node.data.put("key_layer_id", (Object) baseLayer.getLayerId());
                            node.data.put("layer_server_cid", (Object) next.getComponentId());
                            if (d.get(next.getComponentId()) == null) {
                                String str = this.a;
                                n91.a(str, "========= iLayerStyleBuilder setLayerStyle  ========= : " + next.getComponentId());
                                d.get(next.getComponentId()).setLayerStyle(next, node);
                            } else {
                                String str2 = this.a;
                                n91.a(str2, "========= iLayerStyleBuilder default  ========= : " + next.getComponentId());
                                node.data.put(Constants.LAYOUT_TYPE, (Object) "linear");
                            }
                            node.children = new ArrayList();
                            arrayList = new ArrayList<>();
                            if (!i(next.getComponentId())) {
                                String str3 = this.a;
                                n91.a(str3, "========= parseByBaseLayer black id  ========= : " + next.getComponentId());
                                Node n = n(next, globalConfig, next.getItem());
                                if (n != null) {
                                    arrayList.add(n);
                                }
                            } else if (c.get(next.getComponentId()) != null) {
                                String str4 = this.a;
                                n91.a(str4, "========= parseByBaseLayer converter ========= : " + next.getComponentId());
                                arrayList = c.get(next.getComponentId()).convert(baseResponse, next, globalConfig, this);
                            } else {
                                String str5 = this.a;
                                n91.a(str5, "========= parseByBaseLayer default parse2NodeBySection ========= : " + next.getComponentId());
                                arrayList = l(next, globalConfig);
                            }
                            if (arrayList != null && arrayList.size() > 0) {
                                node.children.addAll(arrayList);
                            }
                            arrayList2.add(node);
                            it2 = it;
                            i3 = 1;
                        }
                    }
                    it = it2;
                    i2++;
                    node = new Node();
                    JSONObject jSONObject32 = new JSONObject();
                    node.data = jSONObject32;
                    jSONObject32.put("node_id", (Object) baseLayer.getLayerId());
                    node.data.put("key_layer_id", (Object) baseLayer.getLayerId());
                    node.data.put("layer_server_cid", (Object) next.getComponentId());
                    if (d.get(next.getComponentId()) == null) {
                    }
                    node.children = new ArrayList();
                    arrayList = new ArrayList<>();
                    if (!i(next.getComponentId())) {
                    }
                    node.children.addAll(arrayList);
                    arrayList2.add(node);
                    it2 = it;
                    i3 = 1;
                }
            }
            return arrayList2;
        }
    }

    public static List<BaseLayer> o(List<BaseLayer> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1965558810")) {
            return (List) ipChange.ipc$dispatch("1965558810", new Object[]{list});
        } else if (list == null || list.size() <= 0) {
            return null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (BaseLayer baseLayer : list) {
                List<BaseSection> sections = baseLayer.getSections();
                if (sections != null && sections.size() > 0) {
                    for (BaseSection baseSection : sections) {
                        BaseLayer baseLayer2 = new BaseLayer();
                        baseLayer2.setLayerId(baseLayer.getLayerId());
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(baseSection);
                        baseLayer2.setSections(arrayList2);
                        arrayList.add(baseLayer2);
                    }
                }
            }
            return arrayList;
        }
    }

    public Node e(BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1143756795")) {
            return (Node) ipChange.ipc$dispatch("1143756795", new Object[]{this, baseResponse});
        }
        GlobalConfig globalConfig = null;
        if (baseResponse == null || baseResponse.layers == null) {
            n91.a(this.a, "========= start convert ========= error : null  ");
            return null;
        }
        new pa().b(baseResponse);
        GlobalConfig globalConfig2 = baseResponse.globalConfig;
        if (globalConfig2 != null) {
            globalConfig = globalConfig2;
        }
        Node node = new Node();
        node.children = new ArrayList();
        Node node2 = new Node();
        node2.children = new ArrayList();
        node.children.add(node2);
        String str = this.a;
        n91.a(str, "========= start convert ========= response : " + baseResponse);
        Iterator<BaseLayer> it = baseResponse.layers.iterator();
        while (it.hasNext()) {
            List<Node> m = m(baseResponse, it.next(), globalConfig, 0);
            if (m != null) {
                node2.children.addAll(m);
            }
        }
        String str2 = this.a;
        n91.a(str2, "========= end convert ========= node : " + node);
        return node;
    }

    public List<Node> f(BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1919012445")) {
            return g(baseResponse, 0);
        }
        return (List) ipChange.ipc$dispatch("-1919012445", new Object[]{this, baseResponse});
    }

    public List<Node> g(BaseResponse baseResponse, int i) {
        ArrayList<BaseLayer> arrayList;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1042668280")) {
            return (List) ipChange.ipc$dispatch("-1042668280", new Object[]{this, baseResponse, Integer.valueOf(i)});
        }
        if (baseResponse == null || (arrayList = baseResponse.layers) == null || arrayList.isEmpty()) {
            return new ArrayList();
        }
        List<Node> m = m(baseResponse, baseResponse.layers.get(0), baseResponse.globalConfig, i);
        ArrayList arrayList2 = new ArrayList();
        if (m != null) {
            for (Node node : m) {
                arrayList2.addAll(node.children);
            }
        }
        return arrayList2;
    }

    public boolean i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-224908958")) {
            return ((Boolean) ipChange.ipc$dispatch("-224908958", new Object[]{this, str})).booleanValue();
        } else if (TextUtils.isEmpty(str)) {
            return false;
        } else {
            return b.contains(str);
        }
    }

    public List<Node> l(BaseSection baseSection, GlobalConfig globalConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1972744584")) {
            return (List) ipChange.ipc$dispatch("1972744584", new Object[]{this, baseSection, globalConfig});
        } else if (baseSection == null) {
            n91.a(this.a, "========= start parse2NodeBySection error null ========= ");
            return null;
        } else {
            String str = this.a;
            n91.a(str, "========= start parse2NodeBySection ========= id : " + baseSection.getComponentId());
            ArrayList arrayList = new ArrayList();
            if (baseSection.getItem() == null) {
                baseSection.setItem(new JSONObject());
            }
            NodeData item = baseSection.getItem();
            if (!item.containsKey("result") || !(item.get("result") instanceof JSONArray) || baseSection.getComponentType() != 1) {
                String str2 = this.a;
                n91.a(str2, "========= start parse2NodeBySection parse JSONObject ========= : " + baseSection.getItem());
                Node n = n(baseSection, globalConfig, baseSection.getItem());
                if (n != null) {
                    arrayList.add(n);
                }
            } else {
                JSONArray jSONArray = item.getJSONArray("result");
                String str3 = this.a;
                n91.a(str3, "========= start parse2NodeBySection parse JSONArray ========= : " + jSONArray);
                if (jSONArray != null && jSONArray.size() > 0) {
                    for (int i = 0; i < jSONArray.size(); i++) {
                        Node n2 = n(baseSection, globalConfig, jSONArray.getJSONObject(i));
                        if (n2 != null) {
                            if (i > 0 && baseSection.getStyle() != null && baseSection.getStyle().containsKey("native")) {
                                baseSection.getStyle().remove("native");
                                n2.data.put("styleInfo", (Object) baseSection.getStyle());
                            }
                            arrayList.add(n2);
                        }
                    }
                }
            }
            String str4 = this.a;
            n91.a(str4, "========= end parse2NodeBySection ========= nodeList : " + arrayList);
            return arrayList;
        }
    }

    public Node n(BaseSection baseSection, GlobalConfig globalConfig, JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "653815046")) {
            return (Node) ipChange.ipc$dispatch("653815046", new Object[]{this, baseSection, globalConfig, jSONObject});
        }
        String str = null;
        if (jSONObject == null || jSONObject.isEmpty()) {
            return null;
        }
        Node node = new Node();
        JSONObject jSONObject2 = new JSONObject();
        node.data = jSONObject2;
        jSONObject2.put("node_id", (Object) baseSection.getSectionId());
        node.data.put("componentId", (Object) baseSection.getComponentId());
        node.data.put("item", (Object) jSONObject);
        int componentType = baseSection.getComponentType();
        node.data.put(OpenSimplePopupSubscriber.KEY_COMPONENT_TYPE, (Object) Integer.valueOf(componentType));
        node.data.put("dxConfig", (Object) baseSection.getDxConfig());
        node.data.put("gaiaxConfig", (Object) baseSection.getGaiaxConfig());
        if (componentType == 2 && globalConfig != null) {
            String componentId = baseSection.getComponentId();
            if (TextUtils.equals("damai_home_brand_list", componentId) || TextUtils.equals("damai_home_market_ad", componentId)) {
                node.data.put("globalConfig", (Object) globalConfig.fixDxGlobalCon());
            }
        }
        if (globalConfig != null) {
            str = globalConfig.pageName;
        }
        node.data.put("trackInfo", (Object) h(str, baseSection, globalConfig));
        node.data.put("styleInfo", (Object) baseSection.getStyle());
        JSONObject jSONObject3 = globalConfig.extraInfo;
        if (jSONObject3 != null) {
            node.data.put("extraArgs", (Object) jSONObject3);
        }
        node.data.put("abBucket", (Object) baseSection.getAbBucket());
        return node;
    }
}
