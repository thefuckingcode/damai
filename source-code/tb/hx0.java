package tb;

import cn.damai.common.AppConfig;
import cn.damai.live.LiveActivity;
import com.alibaba.fastjson.JSON;
import com.alient.onearch.adapter.request.DRParam;
import com.amap.api.location.AMapLocation;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.data.Request;
import com.youku.live.livesdk.model.mtop.LiveFullInfo;
import java.util.HashMap;
import java.util.Map;

public final class hx0 {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final hx0 INSTANCE = new hx0();
    public static final String patternName;
    public static final String patternVersion;

    private hx0() {
    }

    public static /* synthetic */ Request b(hx0 hx0, long j, Map map, Map map2, String str, String str2, int i, Object obj) {
        return hx0.a(j, map, map2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2);
    }

    public final Request a(long j, Map<String, Object> map, Map<String, Object> map2, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1309907054")) {
            return (Request) ipChange.ipc$dispatch("-1309907054", new Object[]{this, Long.valueOf(j), map, map2, str, str2});
        }
        k21.i(map, "args");
        k21.i(map2, "requestParams");
        map2.put("patternName", patternName);
        map2.put("patternVersion", patternVersion);
        map.put("comboChannel", "1");
        String p = AppConfig.p();
        k21.h(p, "getTtid()");
        map.put(LiveActivity.OPTION_TTID, p);
        String c = d20.c();
        k21.h(c, "getCityId()");
        map.put("comboDamaiCityId", c);
        map.put(Constants.Name.PAGE_SIZE, 15);
        AMapLocation lastKnownLocation = o81.INSTANCE.c().getLastKnownLocation();
        if (lastKnownLocation != null) {
            map.put("longitude", Double.valueOf(lastKnownLocation.getLongitude()));
            map.put("latitude", Double.valueOf(lastKnownLocation.getLatitude()));
        }
        if (!(str == null || str2 == null)) {
            DRParam dRParam = new DRParam(str, str2);
            map2.put("dr", jl1.ARRAY_START + JSON.toJSONString(dRParam) + jl1.ARRAY_END);
        }
        String jSONString = JSON.toJSONString(map);
        k21.h(jSONString, "toJSONString(args)");
        map2.put("args", jSONString);
        return new Request.Builder().setApiName("mtop.damai.mec.aristotle.get").setVersion(LiveFullInfo.VER).setNeedECode(false).setNeedSession(false).setTimeout(10000).setStrategy(j).setDataParams(new HashMap(map2)).setRequestId(10000).build();
    }
}
