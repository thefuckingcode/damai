package com.youku.live.livesdk.widgets.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.json.IDeserialize;
import com.youku.live.livesdk.model.mtop.base.MtopBaseBean;
import com.youku.live.livesdk.model.mtop.base.MtopLiveBaseDataBean;

/* compiled from: Taobao */
public class MtopDataHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_DATA = "data";

    public static <T extends MtopBaseBean<MtopLiveBaseDataBean<D>>, D> JSONObject getDataDataWithJson(String str, Class<T> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1734151481")) {
            return (JSONObject) ipChange.ipc$dispatch("-1734151481", new Object[]{str, cls});
        }
        try {
            JSONObject parseObject = JSON.parseObject(str);
            if (parseObject == null || !parseObject.containsKey("data")) {
                return null;
            }
            JSONObject jSONObject = parseObject.getJSONObject("data");
            if (jSONObject.containsKey("data")) {
                return jSONObject.getJSONObject("data");
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r4v8, types: [T, D] */
    public static <T extends MtopBaseBean<MtopLiveBaseDataBean<D>>, D> D getDataDataWithModel(String str, Class<T> cls) {
        T t;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "822589932")) {
            return (D) ipChange.ipc$dispatch("822589932", new Object[]{str, cls});
        }
        MtopBaseBean mtopBaseBean = (MtopBaseBean) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(str, cls);
        if (mtopBaseBean == null || (t = mtopBaseBean.data) == null || t.data == null) {
            return null;
        }
        T t2 = t.data;
        try {
            t2.getClass().getField("now").set(t2, mtopBaseBean.data.now);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return mtopBaseBean.data.data;
    }
}
