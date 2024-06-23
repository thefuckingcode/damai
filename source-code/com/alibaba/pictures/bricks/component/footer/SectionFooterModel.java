package com.alibaba.pictures.bricks.component.footer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.component.footer.SectionFooterContract;
import com.alibaba.pictures.bricks.onearch.AbsModel;
import com.alient.oneservice.ut.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uc.webview.export.cyclone.StatAction;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;

/* compiled from: Taobao */
public class SectionFooterModel extends AbsModel<IItem<ItemValue>, Object> implements SectionFooterContract.Model<IItem<ItemValue>> {
    private static transient /* synthetic */ IpChange $ipChange;
    private String componentId;
    private JSONArray result;
    private int total;

    /* access modifiers changed from: protected */
    @Override // com.alibaba.pictures.bricks.onearch.AbsModel
    public TrackInfo compatParseTrackInfo(IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-497695462")) {
            return (TrackInfo) ipChange.ipc$dispatch("-497695462", new Object[]{this, iItem});
        }
        TrackInfo trackInfo = new TrackInfo();
        JSONObject jSONObject = iItem.getComponent().getModule().getContainer().getProperty().getData().getJSONObject("globalConfig");
        JSONObject jSONObject2 = iItem.getProperty().getData().getJSONObject("trackInfo");
        if (jSONObject2 != null) {
            jSONObject2.remove("spmd");
            if (jSONObject != null) {
                trackInfo.setSpmb(jSONObject.getString("pageName"));
            }
            trackInfo.setSpmc(jSONObject2.getString("spmc"));
            trackInfo.setArgs(parseTrackInfoArgs(jSONObject2));
        }
        return trackInfo;
    }

    @Override // com.alibaba.pictures.bricks.component.footer.SectionFooterContract.Model
    public String getComponentId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1457750942")) {
            return this.componentId;
        }
        return (String) ipChange.ipc$dispatch("1457750942", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.component.footer.SectionFooterContract.Model
    public JSONArray getResult() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1131680907")) {
            return this.result;
        }
        return (JSONArray) ipChange.ipc$dispatch("1131680907", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.component.footer.SectionFooterContract.Model
    public int getTotal() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1295016233")) {
            return this.total;
        }
        return ((Integer) ipChange.ipc$dispatch("1295016233", new Object[]{this})).intValue();
    }

    @Override // com.alient.onearch.adapter.view.AbsModel
    public void parseModelImpl(IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1664623644")) {
            ipChange.ipc$dispatch("-1664623644", new Object[]{this, iItem});
            return;
        }
        JSONObject data = iItem.getProperty().getData();
        this.componentId = data.getString("componentId");
        if (data.getJSONObject("item") != null) {
            this.total = data.getJSONObject("item").getIntValue(StatAction.KEY_TOTAL);
            this.result = data.getJSONObject("item").getJSONArray("list");
        }
    }
}
