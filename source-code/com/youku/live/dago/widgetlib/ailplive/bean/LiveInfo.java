package com.youku.live.dago.widgetlib.ailplive.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.io.Serializable;

/* compiled from: Taobao */
public class LiveInfo implements Serializable, Cloneable {
    private static transient /* synthetic */ IpChange $ipChange;
    @JSONField(name = "roomId")
    public String liveId;
    public Mcs mcs;
    public int rs;

    /* compiled from: Taobao */
    public static class Mcs implements Serializable, Cloneable {
        public int mn;
        public String mu;
        public String pul;
        public int st;
        public int v;

        /* access modifiers changed from: protected */
        @Override // java.lang.Object
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    @Override // java.lang.Object
    public Object clone() throws CloneNotSupportedException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "827105317")) {
            return ipChange.ipc$dispatch("827105317", new Object[]{this});
        }
        LiveInfo liveInfo = (LiveInfo) super.clone();
        liveInfo.mcs = (Mcs) this.mcs.clone();
        return liveInfo;
    }

    public Object toJSON() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1937727179")) {
            return JSON.toJSON(this);
        }
        return ipChange.ipc$dispatch("-1937727179", new Object[]{this});
    }

    public JSONObject toJsonObject() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "51929310")) {
            return (JSONObject) ipChange.ipc$dispatch("51929310", new Object[]{this});
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("roomState", Integer.valueOf(this.rs));
        jSONObject.put("roomId", this.liveId);
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        Mcs mcs2 = this.mcs;
        if (mcs2 != null) {
            jSONObject2.put("micId", (Object) Integer.valueOf(mcs2.mn));
            jSONObject2.put("streamState", (Object) Integer.valueOf(this.mcs.st));
            if (!TextUtils.isEmpty(this.mcs.pul)) {
                String str = this.mcs.pul;
                if (str.contains("\\\\")) {
                    ((ILog) Dsl.getService(ILog.class)).e("fornia", "weex sdk one.pul has \\ origin" + str);
                    str = str.replaceAll("\\\\", "");
                }
                ((ILog) Dsl.getService(ILog.class)).e("fornia", "weex sdk origin:" + str);
                JSONObject jSONObject3 = null;
                try {
                    jSONObject3 = JSON.parseObject(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                jSONObject2.put("url", (Object) jSONObject3);
            }
        }
        jSONArray.add(jSONObject2);
        jSONObject.put("mics", (Object) jSONArray);
        return jSONObject;
    }
}
