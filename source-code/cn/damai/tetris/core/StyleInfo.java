package cn.damai.tetris.core;

import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class StyleInfo extends JSONObject {
    private static transient /* synthetic */ IpChange $ipChange;
    ConnerStyle connerStyle;
    public int padding = 0;
    public int padding_left = 0;

    public StyleInfo(@NonNull JSONObject jSONObject) {
        super(jSONObject.getInnerMap());
    }

    public ConnerStyle getConnerStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-761674523")) {
            return (ConnerStyle) ipChange.ipc$dispatch("-761674523", new Object[]{this});
        }
        ConnerStyle connerStyle2 = this.connerStyle;
        if (connerStyle2 != null) {
            return connerStyle2;
        }
        if (get("native") == null) {
            return null;
        }
        try {
            this.connerStyle = (ConnerStyle) JSON.parseObject(getJSONObject("native").toJSONString(), ConnerStyle.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.connerStyle;
    }
}
