package tb;

import android.text.TextUtils;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.StyleInfo;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.convertor.IConverter;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class r80 implements IConverter<BaseResponse, BaseSection, GlobalConfig, List<Node>> {
    private static transient /* synthetic */ IpChange $ipChange;

    private void a(BaseSection baseSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1691039452")) {
            ipChange.ipc$dispatch("-1691039452", new Object[]{this, baseSection});
            return;
        }
        try {
            TrackInfo trackInfo = baseSection.getTrackInfo();
            StyleInfo style = baseSection.getStyle();
            if (trackInfo == null) {
                trackInfo = new TrackInfo();
                baseSection.setTrackInfo(trackInfo);
            }
            if (style != null) {
                String string = style.getString("title");
                if (!TextUtils.isEmpty(string)) {
                    trackInfo.put("titlelabel", (Object) string);
                }
            }
            Object d = d20.d();
            trackInfo.put("usercode", d20.E());
            trackInfo.put("city", d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void c(JSONObject jSONObject, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2095128561")) {
            ipChange.ipc$dispatch("-2095128561", new Object[]{jSONObject, Float.valueOf(f)});
        } else if (jSONObject != null) {
            jSONObject.put("hwRatio", (Object) Float.valueOf(f));
        }
    }

    /* renamed from: b */
    public List<Node> convert(BaseResponse baseResponse, BaseSection baseSection, GlobalConfig globalConfig, qa qaVar) {
        JSONArray jSONArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1241612939")) {
            return (List) ipChange.ipc$dispatch("1241612939", new Object[]{this, baseResponse, baseSection, globalConfig, qaVar});
        }
        ArrayList arrayList = new ArrayList();
        NodeData item = baseSection.getItem();
        a(baseSection);
        if (!(item == null || (jSONArray = item.getJSONArray("data")) == null || jSONArray.size() <= 0)) {
            for (int i = 0; i < jSONArray.size(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    float f = i % 5 == 0 ? 1.3333334f : 1.0f;
                    String string = jSONObject.getString("cardType");
                    if (TextUtils.equals("1", string)) {
                        baseSection.setComponentId(wj2.NOTE_C_ID);
                        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                        c(jSONObject2, f);
                        baseSection.setItem(jSONObject2);
                        List<Node> l = qaVar.l(baseSection, globalConfig);
                        if (l != null) {
                            arrayList.addAll(l);
                        }
                    } else if (TextUtils.equals("2", string)) {
                        baseSection.setComponentId(wj2.THEME_C_ID);
                        JSONObject jSONObject3 = jSONObject.getJSONObject("data");
                        c(jSONObject3, f);
                        baseSection.setItem(jSONObject3);
                        List<Node> l2 = qaVar.l(baseSection, globalConfig);
                        if (l2 != null) {
                            arrayList.addAll(l2);
                        }
                    } else if (TextUtils.equals("4", string)) {
                        baseSection.setComponentId(wj2.PROJECT_C_ID);
                        baseSection.setItem(jSONObject.getJSONObject("data"));
                        List<Node> l3 = qaVar.l(baseSection, globalConfig);
                        if (l3 != null) {
                            arrayList.addAll(l3);
                        }
                    } else if (TextUtils.equals("5", string)) {
                        baseSection.setComponentId(wj2.VOTE_C_ID);
                        baseSection.setItem(jSONObject.getJSONObject("data"));
                        List<Node> l4 = qaVar.l(baseSection, globalConfig);
                        if (l4 != null) {
                            arrayList.addAll(l4);
                        }
                    }
                }
            }
        }
        return arrayList;
    }
}
