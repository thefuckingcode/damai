package tb;

import cn.damai.tetris.core.IContext;
import cn.damai.tetris.core.StyleInfo;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.structure.container.IContainer;
import cn.damai.tetris.v2.structure.layer.ILayer;
import cn.damai.tetris.v2.structure.module.IModule;
import cn.damai.tetris.v2.structure.section.ISection;
import cn.damai.tetris.v2.structure.section.SectionProperty;
import cn.damai.tetris.v2.util.CmsDxTemplate;
import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class gs0 implements ISection {
    private static transient /* synthetic */ IpChange $ipChange;
    private final IContext a;
    private SectionProperty b;
    private int c;
    private JSONObject d;
    private JSONObject e;
    private ILayer f;
    private int g = -1;
    private TrackInfo h;
    private StyleInfo i;
    private String j;
    private String k;
    private Object l;
    private JSONObject m;
    JSONObject n;
    JSONObject o;
    int p = 1;

    public gs0(IContext iContext, Node node) {
        this.a = iContext;
        JSONObject jSONObject = node.data;
        this.e = jSONObject;
        a(jSONObject);
    }

    private void a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-400154326")) {
            ipChange.ipc$dispatch("-400154326", new Object[]{this, jSONObject});
        } else if (jSONObject != null) {
            this.k = jSONObject.getString("componentId");
            this.j = jSONObject.getString("node_id");
            this.p = 1;
            try {
                this.p = jSONObject.getIntValue(OpenSimplePopupSubscriber.KEY_COMPONENT_TYPE);
                this.n = jSONObject.getJSONObject("dxConfig");
                this.o = jSONObject.getJSONObject("gaiaxConfig");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.p < 1) {
                this.p = 1;
            }
            if (wj2.DX_MUSIC_FESTIVAL_HOT_PROJECT_LIST_CID.equals(this.k) || wj2.DX_MUSIC_FESTIVAL_IP_LIST_CID.equals(this.k) || this.p == 2) {
                CmsDxTemplate validTemplateJson = CmsDxTemplate.getValidTemplateJson(jSONObject, this.k);
                if (validTemplateJson != null) {
                    this.c = o80.f(CmsDxTemplate.toDxJsonObj(validTemplateJson));
                } else if (o80.g(this.k)) {
                    this.c = o80.f(o80.c(this.k));
                }
                z = true;
            }
            if (this.p == 3 && (jSONObject2 = this.o) != null) {
                jSONObject2.put("componentId", (Object) this.k);
                this.c = vr0.b(this.o);
            }
            if (!z && this.p != 3) {
                this.c = wl.c(this.a.getActivity()).d(this.k);
            }
            this.d = jSONObject.getJSONObject("item");
            JSONObject jSONObject3 = jSONObject.getJSONObject("trackInfo");
            if (jSONObject3 instanceof TrackInfo) {
                this.h = (TrackInfo) jSONObject3;
            }
            JSONObject jSONObject4 = jSONObject.getJSONObject("styleInfo");
            if (jSONObject4 != null && (jSONObject4 instanceof StyleInfo)) {
                this.i = (StyleInfo) jSONObject4;
            }
            JSONObject jSONObject5 = jSONObject.getJSONObject("extraArgs");
            if (jSONObject5 != null && (jSONObject5 instanceof JSONObject)) {
                this.m = jSONObject5;
            }
        }
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public void addItem(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2062182717")) {
            ipChange.ipc$dispatch("-2062182717", new Object[]{this, jSONObject});
            return;
        }
        try {
            this.d = q41.a(this.d, jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public String getComponentId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "702779577")) {
            return this.k;
        }
        return (String) ipChange.ipc$dispatch("702779577", new Object[]{this});
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public int getComponentType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "872046843")) {
            return this.p;
        }
        return ((Integer) ipChange.ipc$dispatch("872046843", new Object[]{this})).intValue();
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public IContainer getContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-673930283")) {
            return (IContainer) ipChange.ipc$dispatch("-673930283", new Object[]{this});
        }
        ILayer iLayer = this.f;
        if (iLayer == null) {
            return null;
        }
        return iLayer.getContainer();
    }

    @Override // cn.damai.tetris.v2.common.Addressable
    public mn getCoordinate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1162418894")) {
            return (mn) ipChange.ipc$dispatch("1162418894", new Object[]{this});
        }
        int i2 = -1;
        int index = getModule() == null ? -1 : getModule().getIndex();
        if (getLayer() != null) {
            i2 = getLayer().getIndex();
        }
        return new mn(index, i2, getIndex());
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public JSONObject getDxConfig() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1760735445")) {
            return this.n;
        }
        return (JSONObject) ipChange.ipc$dispatch("1760735445", new Object[]{this});
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public Object getExtra() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1322409757")) {
            return this.l;
        }
        return ipChange.ipc$dispatch("-1322409757", new Object[]{this});
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public JSONObject getExtraArgs() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1828295118")) {
            return this.m;
        }
        return (JSONObject) ipChange.ipc$dispatch("-1828295118", new Object[]{this});
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public JSONObject getGaiaxConfig() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-75808585")) {
            return this.o;
        }
        return (JSONObject) ipChange.ipc$dispatch("-75808585", new Object[]{this});
    }

    @Override // cn.damai.tetris.v2.common.Addressable
    public int getIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1820764640")) {
            return ((Integer) ipChange.ipc$dispatch("-1820764640", new Object[]{this})).intValue();
        }
        ILayer iLayer = this.f;
        if (iLayer != null) {
            iLayer.updateChildIndex();
        }
        return this.g;
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public JSONObject getItem() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-784236392")) {
            return this.d;
        }
        return (JSONObject) ipChange.ipc$dispatch("-784236392", new Object[]{this});
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public ILayer getLayer() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-213347963")) {
            return this.f;
        }
        return (ILayer) ipChange.ipc$dispatch("-213347963", new Object[]{this});
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public IModule getModule() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-663657526")) {
            return (IModule) ipChange.ipc$dispatch("-663657526", new Object[]{this});
        }
        ILayer iLayer = this.f;
        if (iLayer == null) {
            return null;
        }
        return iLayer.getModule();
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public SectionProperty getProperty() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-518397965")) {
            return this.b;
        }
        return (SectionProperty) ipChange.ipc$dispatch("-518397965", new Object[]{this});
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public JSONObject getRawData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "425332653")) {
            return this.e;
        }
        return (JSONObject) ipChange.ipc$dispatch("425332653", new Object[]{this});
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public String getSectionId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-867722719")) {
            return this.j;
        }
        return (String) ipChange.ipc$dispatch("-867722719", new Object[]{this});
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public StyleInfo getStyleInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-256503173")) {
            return this.i;
        }
        return (StyleInfo) ipChange.ipc$dispatch("-256503173", new Object[]{this});
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public TrackInfo getTrackInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2062204731")) {
            return this.h;
        }
        return (TrackInfo) ipChange.ipc$dispatch("2062204731", new Object[]{this});
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public int getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-84223004")) {
            return this.c;
        }
        return ((Integer) ipChange.ipc$dispatch("-84223004", new Object[]{this})).intValue();
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public void setExtra(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "555569751")) {
            ipChange.ipc$dispatch("555569751", new Object[]{this, obj});
            return;
        }
        this.l = obj;
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public void setExtraArgs(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-497127278")) {
            ipChange.ipc$dispatch("-497127278", new Object[]{this, jSONObject});
            return;
        }
        this.m = jSONObject;
    }

    @Override // cn.damai.tetris.v2.common.Addressable
    public void setIndex(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "939893482")) {
            ipChange.ipc$dispatch("939893482", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.g = i2;
    }

    @Override // cn.damai.tetris.v2.structure.section.ISection
    public void setLayer(ILayer iLayer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "782266733")) {
            ipChange.ipc$dispatch("782266733", new Object[]{this, iLayer});
            return;
        }
        this.f = iLayer;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1021761891")) {
            return (String) ipChange.ipc$dispatch("1021761891", new Object[]{this});
        }
        return "GenericSection{mType=" + this.c + ", mItem=" + JSON.toJSONString(this.d) + ", rawData=" + JSON.toJSONString(this.e) + ", mLayer=" + this.f.toString() + ", mIndex=" + this.g + ", mTrackInfo=" + JSON.toJSONString(this.h) + ", styleInfo=" + JSON.toJSONString(this.i) + ", mSectionId='" + this.j + '\'' + ", mComponentId='" + this.k + '\'' + ", extra=" + JSON.toJSONString(this.l) + ", extraArgs=" + JSON.toJSONString(this.m) + ", dxConfig=" + JSON.toJSONString(this.n) + ", gaiaxConfig=" + JSON.toJSONString(this.o) + ", componentType=" + this.p + '}';
    }
}
