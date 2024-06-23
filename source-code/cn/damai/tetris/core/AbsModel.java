package cn.damai.tetris.core;

import android.text.TextUtils;
import cn.damai.tetris.core.ut.TrackProxy;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: Taobao */
public abstract class AbsModel<T> implements IModel<BaseNode>, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    String abBucket;
    int offset = 0;
    JSONObject rawJson;
    StyleInfo styleInfo;
    TrackInfo trackInfo;

    @Override // cn.damai.tetris.core.IModel
    public JSONObject getABBucket() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1737427936")) {
            return (JSONObject) ipChange.ipc$dispatch("-1737427936", new Object[]{this});
        } else if (!TextUtils.isEmpty(this.abBucket)) {
            return (JSONObject) JSON.parseObject(this.abBucket, JSONObject.class);
        } else {
            return null;
        }
    }

    @Override // cn.damai.tetris.core.IModel
    public String getItemValue(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "216908757")) {
            return (String) ipChange.ipc$dispatch("216908757", new Object[]{this, str});
        } else if (this.rawJson == null || TextUtils.isEmpty(str)) {
            return null;
        } else {
            return this.rawJson.getString(str);
        }
    }

    @Override // cn.damai.tetris.core.IModel
    public int getOffset() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1546121771")) {
            return this.offset;
        }
        return ((Integer) ipChange.ipc$dispatch("1546121771", new Object[]{this})).intValue();
    }

    @Override // cn.damai.tetris.core.IModel
    public JSONObject getRawJson() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "751162863")) {
            return this.rawJson;
        }
        return (JSONObject) ipChange.ipc$dispatch("751162863", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.IModel
    public StyleInfo getStyleInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "85286459")) {
            return this.styleInfo;
        }
        return (StyleInfo) ipChange.ipc$dispatch("85286459", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.IModel
    public String getStyleValue(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1757725131")) {
            return (String) ipChange.ipc$dispatch("1757725131", new Object[]{this, str});
        } else if (this.styleInfo == null || TextUtils.isEmpty(str)) {
            return null;
        } else {
            return this.styleInfo.getString(str);
        }
    }

    @Override // cn.damai.tetris.core.IModel
    public TrackInfo getTrackInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1890972933")) {
            return this.trackInfo;
        }
        return (TrackInfo) ipChange.ipc$dispatch("-1890972933", new Object[]{this});
    }

    public abstract void parseModel(BaseNode baseNode);

    @Override // cn.damai.tetris.core.IModel
    public void parseModelData(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1609159888")) {
            ipChange.ipc$dispatch("-1609159888", new Object[]{this, baseNode});
        } else if (baseNode != null) {
            this.trackInfo = baseNode.trackInfo;
            this.styleInfo = baseNode.style;
            this.rawJson = (JSONObject) JSON.parseObject(baseNode.toJSONString(), JSONObject.class);
            this.abBucket = baseNode.abBucket;
            setOffset(baseNode.offset);
            try {
                parseModel(baseNode);
            } catch (Exception e) {
                e.printStackTrace();
                HashMap hashMap = new HashMap();
                if (this.trackInfo != null) {
                    hashMap.put("trackInfo", this.trackInfo.trackB + "." + this.trackInfo.trackC + "." + this.trackInfo.trackD);
                }
                hashMap.put("exception", e.getMessage());
                TrackProxy.c("-509", "组件数据解析异常", hashMap);
            }
        }
    }

    @Override // cn.damai.tetris.core.IModel
    public void setOffset(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1459295703")) {
            ipChange.ipc$dispatch("1459295703", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.offset = i;
    }
}
