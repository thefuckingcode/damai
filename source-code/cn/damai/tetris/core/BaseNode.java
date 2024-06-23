package cn.damai.tetris.core;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class BaseNode implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    String abBucket;
    int componentType = 1;
    JSONObject dxConfig;
    JSONObject gaiaxConfig;
    NodeData item;
    int offset;
    StyleInfo style;
    TrackInfo trackInfo;

    public String getAbBucket() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1396738908")) {
            return this.abBucket;
        }
        return (String) ipChange.ipc$dispatch("1396738908", new Object[]{this});
    }

    public int getComponentType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2080465193")) {
            return this.componentType;
        }
        return ((Integer) ipChange.ipc$dispatch("-2080465193", new Object[]{this})).intValue();
    }

    public JSONObject getDxConfig() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-120411783")) {
            return this.dxConfig;
        }
        return (JSONObject) ipChange.ipc$dispatch("-120411783", new Object[]{this});
    }

    public JSONObject getGaiaxConfig() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-599599725")) {
            return this.gaiaxConfig;
        }
        return (JSONObject) ipChange.ipc$dispatch("-599599725", new Object[]{this});
    }

    public NodeData getItem() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-899416340")) {
            return this.item;
        }
        return (NodeData) ipChange.ipc$dispatch("-899416340", new Object[]{this});
    }

    public int getOffset() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1252464655")) {
            return this.offset;
        }
        return ((Integer) ipChange.ipc$dispatch("1252464655", new Object[]{this})).intValue();
    }

    public StyleInfo getStyle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1392436049")) {
            return this.style;
        }
        return (StyleInfo) ipChange.ipc$dispatch("1392436049", new Object[]{this});
    }

    public TrackInfo getTrackInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "181057503")) {
            return this.trackInfo;
        }
        return (TrackInfo) ipChange.ipc$dispatch("181057503", new Object[]{this});
    }

    @Deprecated
    public TrackInfo getTrackInfoBeta() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-494564241")) {
            return this.trackInfo;
        }
        return (TrackInfo) ipChange.ipc$dispatch("-494564241", new Object[]{this});
    }

    public void setAbBucket(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "466905346")) {
            ipChange.ipc$dispatch("466905346", new Object[]{this, str});
            return;
        }
        this.abBucket = str;
    }

    public void setComponentType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-680805101")) {
            ipChange.ipc$dispatch("-680805101", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.componentType = i;
    }

    public void setDxConfig(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "39047875")) {
            ipChange.ipc$dispatch("39047875", new Object[]{this, jSONObject});
            return;
        }
        this.dxConfig = jSONObject;
    }

    public void setGaiaxConfig(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1596139601")) {
            ipChange.ipc$dispatch("1596139601", new Object[]{this, jSONObject});
            return;
        }
        this.gaiaxConfig = jSONObject;
    }

    public void setItem(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "351711072")) {
            ipChange.ipc$dispatch("351711072", new Object[]{this, jSONObject});
            return;
        }
        this.item = new NodeData(jSONObject);
    }

    public void setNodeData(NodeData nodeData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1709723465")) {
            ipChange.ipc$dispatch("1709723465", new Object[]{this, nodeData});
            return;
        }
        this.item = nodeData;
    }

    public void setOffset(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "945859699")) {
            ipChange.ipc$dispatch("945859699", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.offset = i;
    }

    public void setStyle(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "298258906")) {
            ipChange.ipc$dispatch("298258906", new Object[]{this, jSONObject});
        } else if (jSONObject != null) {
            this.style = new StyleInfo(jSONObject);
        }
    }

    public void setTrackInfo(TrackInfo trackInfo2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-954117863")) {
            ipChange.ipc$dispatch("-954117863", new Object[]{this, trackInfo2});
            return;
        }
        this.trackInfo = trackInfo2;
    }

    @Deprecated
    public void setTrackInfoBeta(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1384813486")) {
            ipChange.ipc$dispatch("-1384813486", new Object[]{this, jSONObject});
            return;
        }
        this.trackInfo = new TrackInfo(jSONObject);
    }

    public String toJSONString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1497155695")) {
            return (String) ipChange.ipc$dispatch("1497155695", new Object[]{this});
        }
        NodeData nodeData = this.item;
        if (nodeData != null) {
            return nodeData.toJSONString();
        }
        return null;
    }

    @Deprecated
    public void setTrackInfoBeta(TrackInfo trackInfo2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1886607223")) {
            ipChange.ipc$dispatch("-1886607223", new Object[]{this, trackInfo2});
            return;
        }
        this.trackInfo = trackInfo2;
    }
}
