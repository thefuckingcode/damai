package cn.damai.common.net.mtop;

import android.net.Uri;
import android.text.TextUtils;
import cn.damai.common.OrangeConfigCenter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import java.util.HashMap;
import mtopsdk.mtop.domain.MtopResponse;
import tb.hp1;
import tb.lp1;
import tb.oz0;
import tb.p81;
import tb.s41;

/* compiled from: Taobao */
public class Util {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String MTOP_HEAD_COORDINATES_CONFIG = "mtop_coordinates_list";
    public static final String MTOP_HEAD_COORDINATES_NAME = "dm_mtop_head_coordinates";
    public static final String NO_NET_ERROR = "网络竟然崩溃了";
    public static final String NO_NET_FRIENDLY = "网络不太顺畅哦，请稍后再试吧";
    public static final String SERVICE_ERROR = "服务竟然出错了";
    public static final String SERVICE_ERROR_FRIENDLY = "麦麦开小差了，请稍后重试哦";
    public static final String SYS_LIMIT = "抱歉，当前排队的人数太多啦，请稍后再试哦";
    public static final String SYS_SOLODOUT = "亲，来晚了一步，票被抢光啦";
    private static HashMap<String, String> limitMsgs;
    private static double[] locationTemp = null;
    private static boolean mRequestOrange = false;
    private static JSONArray stringJSONArray = new JSONArray();

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        limitMsgs = hashMap;
        hashMap.put(oz0.FAIL_SYS_TRAFFIC_LIMIT, "抱歉，当前排队的人数太多啦，请稍后再试哦");
        limitMsgs.put("ANDROID_SYS_API_FLOW_LIMIT_LOCKED", "抱歉，当前排队的人数太多啦，请稍后再试哦");
        limitMsgs.put("MAPIE98015", "亲，来晚了一步，票被抢光啦");
        limitMsgs.put("FAIL_BIZ_PARAM_ERROR", "麦麦开小差了，请稍后重试哦");
    }

    public static String getApiParam(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "518930646")) {
            return (String) ipChange.ipc$dispatch("518930646", new Object[]{str, str2});
        }
        if ("mtop.damai.mec.aristotle.get".equals(str) && !TextUtils.isEmpty(str2)) {
            try {
                JSONObject c = s41.c(Uri.parse(str2).getQueryParameter("data"));
                if (c != null) {
                    String obj = c.get("patternName").toString();
                    String obj2 = c.get("patternVersion").toString();
                    return str + JSMethod.NOT_SET + obj + JSMethod.NOT_SET + obj2;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static double[] getDMCoordinates(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "26774022")) {
            return (double[]) ipChange.ipc$dispatch("26774022", new Object[]{str});
        } else if (isNeedCoordinate(str)) {
            return getDMLocation();
        } else {
            return null;
        }
    }

    private static double[] getDMLocation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "329404628")) {
            return (double[]) ipChange.ipc$dispatch("329404628", new Object[0]);
        }
        if (hp1.i(lp1.LOCATION)) {
            return p81.b();
        }
        return null;
    }

    public static String getErrorMsg(MtopResponse mtopResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-166314485")) {
            return (String) ipChange.ipc$dispatch("-166314485", new Object[]{mtopResponse});
        }
        if (mtopResponse != null && !TextUtils.isEmpty(mtopResponse.getRetCode())) {
            if (limitMsgs.containsKey(mtopResponse.getRetCode())) {
                return limitMsgs.get(mtopResponse.getRetCode());
            }
            if (TextUtils.isEmpty(mtopResponse.getRetMsg()) || "服务竟然出错了".equals(mtopResponse.getRetMsg())) {
                return "麦麦开小差了，请稍后重试哦";
            }
            if ("网络竟然崩溃了".endsWith(mtopResponse.getRetMsg())) {
                return "网络不太顺畅哦，请稍后再试吧";
            }
            return mtopResponse.getRetMsg();
        }
        return "麦麦开小差了，请稍后重试哦";
    }

    public static String getTraceId(MtopResponse mtopResponse) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "550145306")) {
            return (mtopResponse == null || mtopResponse.getHeaderFields() == null || !mtopResponse.getHeaderFields().containsKey("x-eagleeye-id") || mtopResponse.getHeaderFields().get("x-eagleeye-id") == null) ? "traceId null" : mtopResponse.getHeaderFields().get("x-eagleeye-id").toString();
        }
        return (String) ipChange.ipc$dispatch("550145306", new Object[]{mtopResponse});
    }

    private static boolean isNeedCoordinate(String str) {
        JSONArray jSONArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-303624415")) {
            return ((Boolean) ipChange.ipc$dispatch("-303624415", new Object[]{str})).booleanValue();
        }
        if (!mRequestOrange || (jSONArray = stringJSONArray) == null || jSONArray.size() == 0) {
            String b = OrangeConfigCenter.c().b("dm_mtop_head_coordinates", "mtop_coordinates_list", "");
            if (!TextUtils.isEmpty(b)) {
                try {
                    stringJSONArray = JSON.parseArray(b);
                } catch (Exception unused) {
                }
            }
            mRequestOrange = true;
        }
        JSONArray jSONArray2 = stringJSONArray;
        return jSONArray2 != null && !jSONArray2.isEmpty() && stringJSONArray.contains(str);
    }

    public static double[] getDMCoordinates() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1360606416") ? (double[]) ipChange.ipc$dispatch("1360606416", new Object[0]) : getDMLocation();
    }

    public static String getErrorMsg(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-852555620")) {
            return (String) ipChange.ipc$dispatch("-852555620", new Object[]{str, str2});
        }
        if (!TextUtils.isEmpty(str)) {
            if (limitMsgs.containsKey(str)) {
                return limitMsgs.get(str);
            }
            if (TextUtils.isEmpty(str2) || "服务竟然出错了".equals(str2)) {
                return "麦麦开小差了，请稍后重试哦";
            }
            return "网络竟然崩溃了".endsWith(str2) ? "网络不太顺畅哦，请稍后再试吧" : str2;
        }
        return "麦麦开小差了，请稍后重试哦";
    }
}
