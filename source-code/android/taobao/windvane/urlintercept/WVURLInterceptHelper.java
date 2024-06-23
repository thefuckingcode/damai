package android.taobao.windvane.urlintercept;

import android.taobao.windvane.config.WVServerConfig;
import android.taobao.windvane.connect.api.ApiResponse;
import android.taobao.windvane.urlintercept.WVURLInterceptData;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVUrlUtil;
import android.text.TextUtils;
import com.taobao.orange.OConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
public class WVURLInterceptHelper {
    private static String TAG = "WVURLInterceptHelper";
    private static final String URL_FILTER_TAG = "_wv_url_hyid";

    public static synchronized WVURLInterceptData.URLInfo parseByRule(String str, Set<WVURLInterceptData.RuleData> set, Map<String, Pattern> map) {
        synchronized (WVURLInterceptHelper.class) {
            WVURLInterceptData.URLInfo uRLInfo = new WVURLInterceptData.URLInfo();
            uRLInfo.url = str;
            Hashtable hashtable = new Hashtable();
            Iterator<WVURLInterceptData.RuleData> it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WVURLInterceptData.RuleData next = it.next();
                String str2 = next.pattern;
                Pattern pattern = map.get(str2);
                if (pattern == null) {
                    try {
                        pattern = Pattern.compile(str2);
                        map.put(str2, pattern);
                    } catch (PatternSyntaxException unused) {
                        String str3 = TAG;
                        TaoLog.e(str3, "pattern:" + str2);
                    }
                }
                if (pattern == null) {
                    return uRLInfo;
                }
                Matcher matcher = pattern.matcher(str);
                if (matcher.matches()) {
                    if (TaoLog.getLogStatus()) {
                        String str4 = TAG;
                        TaoLog.d(str4, "url matched for pattern " + str2);
                    }
                    uRLInfo.code = next.target;
                    uRLInfo.rule = str2;
                    int i = next.rutype;
                    if (i == 0) {
                        int groupCount = matcher.groupCount();
                        for (Map.Entry<String, Integer> entry : next.indexp.entrySet()) {
                            int intValue = entry.getValue().intValue();
                            String group = matcher.group(intValue);
                            if (groupCount >= intValue && !TextUtils.isEmpty(group)) {
                                hashtable.put(entry.getKey(), group);
                            }
                        }
                    } else if (i == 1) {
                        for (Map.Entry<String, String> entry2 : next.namep.entrySet()) {
                            String paramVal = WVUrlUtil.getParamVal(str, entry2.getKey());
                            if (!TextUtils.isEmpty(paramVal)) {
                                hashtable.put(entry2.getValue(), paramVal);
                            }
                        }
                    }
                }
            }
            uRLInfo.params = hashtable;
            return uRLInfo;
        }
    }

    public static WVURLInterceptData.URLInfo parseByTag(String str) {
        String paramVal = WVUrlUtil.getParamVal(str, URL_FILTER_TAG);
        if (TextUtils.isEmpty(paramVal)) {
            return null;
        }
        WVURLInterceptData.URLInfo uRLInfo = new WVURLInterceptData.URLInfo();
        uRLInfo.url = str;
        if (!paramVal.contains(";")) {
            return null;
        }
        int indexOf = paramVal.indexOf(";");
        uRLInfo.code = Integer.parseInt(TextUtils.substring(paramVal, 0, indexOf));
        HashMap hashMap = new HashMap();
        for (String str2 : TextUtils.substring(paramVal, indexOf + 1, paramVal.length()).split(",")) {
            String[] split = str2.split(":");
            if (split.length == 2) {
                String paramVal2 = WVUrlUtil.getParamVal(str, split[1].trim());
                if (!TextUtils.isEmpty(paramVal2)) {
                    hashMap.put(split[0].trim(), paramVal2);
                }
            }
        }
        uRLInfo.params = hashMap;
        return uRLInfo;
    }

    public static List<WVURLInterceptData.RuleData> parseRuleData(String str) {
        List<WVURLInterceptData.RuleData> synchronizedList = Collections.synchronizedList(new ArrayList());
        ApiResponse apiResponse = new ApiResponse();
        JSONObject jSONObject = apiResponse.parseJsonResult(str).success ? apiResponse.data : null;
        if (jSONObject == null) {
            return synchronizedList;
        }
        try {
            ArrayList arrayList = new ArrayList();
            try {
                WVServerConfig.URL_FILTER = jSONObject.optInt(OConstant.DIMEN_FILE_LOCK, 0) == 0;
                if (jSONObject.has("rules")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("rules");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                        WVURLInterceptData.RuleData ruleData = new WVURLInterceptData.RuleData();
                        ruleData.target = jSONObject2.getInt("target");
                        ruleData.pattern = jSONObject2.getString("pattern");
                        ruleData.rutype = jSONObject2.optInt("rutype");
                        for (String str2 : jSONObject2.optString("indexp").split(",")) {
                            String[] split = str2.split(":");
                            if (split.length == 2 && TextUtils.isDigitsOnly(split[1].trim())) {
                                ruleData.indexp.put(split[0].trim(), Integer.valueOf(Integer.parseInt(split[1].trim())));
                            }
                        }
                        for (String str3 : jSONObject2.optString("namep").split(",")) {
                            String[] split2 = str3.split(":");
                            if (split2.length == 2) {
                                ruleData.namep.put(split2[1].trim(), split2[0].trim());
                            }
                        }
                        arrayList.add(ruleData);
                    }
                }
            } catch (Exception unused) {
            }
            return arrayList;
        } catch (Exception unused2) {
            return synchronizedList;
        }
    }
}
