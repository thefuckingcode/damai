package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.alient.onearch.adapter.pom.OneArchConstants;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.taobao.weex.common.Constants;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jl1;

/* compiled from: Taobao */
public final class g extends e<CloudSearch.Query, CloudResult> {
    private int k = 0;

    public g(Context context, CloudSearch.Query query) {
        super(context, query);
    }

    private static String b(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public CloudResult a(String str) throws AMapException {
        ArrayList<CloudItem> arrayList = null;
        if (str == null || str.equals("")) {
            T t = ((a) this).b;
            return CloudResult.createPagedResult(t, this.k, t.getBound(), ((a) this).b.getPageSize(), null);
        }
        try {
            arrayList = d(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        T t2 = ((a) this).b;
        return CloudResult.createPagedResult(t2, this.k, t2.getBound(), ((a) this).b.getPageSize(), arrayList);
    }

    private ArrayList<CloudItem> d(JSONObject jSONObject) throws JSONException {
        ArrayList<CloudItem> arrayList = new ArrayList<>();
        JSONArray a = e.a(jSONObject);
        if (a == null) {
            return arrayList;
        }
        this.k = e.b(jSONObject);
        for (int i = 0; i < a.length(); i++) {
            JSONObject optJSONObject = a.optJSONObject(i);
            CloudItemDetail c = e.c(optJSONObject);
            e.a(c, optJSONObject);
            arrayList.add(c);
        }
        return arrayList;
    }

    private static String f(String str) {
        return str != null ? str.replace("%26%26", jl1.AND) : str;
    }

    private static String g(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            str = e(str);
            String[] split = str.split("&");
            Arrays.sort(split);
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
                stringBuffer.append("&");
            }
            String f = f(stringBuffer.toString());
            if (f.length() > 1) {
                return (String) f.subSequence(0, f.length() - 1);
            }
            return str;
        } catch (Throwable th) {
            ci.a(th, "ut", "sPa");
        }
    }

    private String j() {
        return ((a) this).b.getSortingrules() != null ? ((a) this).b.getSortingrules().toString() : "";
    }

    private String z() {
        StringBuffer stringBuffer = new StringBuffer();
        String filterString = ((a) this).b.getFilterString();
        String filterNumString = ((a) this).b.getFilterNumString();
        stringBuffer.append(filterString);
        if (!i.a(filterString) && !i.a(filterNumString)) {
            stringBuffer.append(jl1.AND);
        }
        stringBuffer.append(filterNumString);
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a, com.amap.api.col.s.b
    public final String a_() {
        return null;
    }

    @Override // com.amap.api.col.s.a, com.amap.api.col.s.b, com.amap.api.col.s.df
    public final Map<String, String> e() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", bk.f(((a) this).e));
        hashtable.put("output", Preloader.KEY_JSON);
        if (((a) this).b.getBound() != null) {
            if (((a) this).b.getBound().getShape().equals("Bound")) {
                double a = i.a(((a) this).b.getBound().getCenter().getLongitude());
                double a2 = i.a(((a) this).b.getBound().getCenter().getLatitude());
                hashtable.put("center", a + "," + a2);
                StringBuilder sb = new StringBuilder();
                sb.append(((a) this).b.getBound().getRange());
                hashtable.put(BQCCameraParam.FOCUS_AREA_RADIUS, sb.toString());
            } else if (((a) this).b.getBound().getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((a) this).b.getBound().getLowerLeft();
                LatLonPoint upperRight = ((a) this).b.getBound().getUpperRight();
                double a3 = i.a(lowerLeft.getLatitude());
                double a4 = i.a(lowerLeft.getLongitude());
                double a5 = i.a(upperRight.getLatitude());
                double a6 = i.a(upperRight.getLongitude());
                hashtable.put("polygon", a4 + "," + a3 + ";" + a6 + "," + a5);
            } else if (((a) this).b.getBound().getShape().equals("Polygon")) {
                List<LatLonPoint> polyGonList = ((a) this).b.getBound().getPolyGonList();
                if (polyGonList != null && polyGonList.size() > 0) {
                    hashtable.put("polygon", i.a(polyGonList, ";"));
                }
            } else if (((a) this).b.getBound().getShape().equals(CloudSearch.SearchBound.LOCAL_SHAPE)) {
                hashtable.put("city", ((a) this).b.getBound().getCity());
            }
        }
        hashtable.put("layerId", ((a) this).b.getTableID());
        if (!i.a(j())) {
            hashtable.put("sortrule", j());
        }
        String z = z();
        if (!i.a(z)) {
            hashtable.put(Constants.Name.FILTER, z);
        }
        String queryString = ((a) this).b.getQueryString();
        if (queryString == null || "".equals(queryString)) {
            hashtable.put(OneArchConstants.LayoutKey.KEY_WORDS, "");
        } else {
            hashtable.put(OneArchConstants.LayoutKey.KEY_WORDS, queryString);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((a) this).b.getPageSize());
        hashtable.put(Constants.Name.PAGE_SIZE, sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(((a) this).b.getPageNum());
        hashtable.put("pageNum", sb3.toString());
        String a7 = bn.a();
        String a8 = bn.a(((a) this).e, a7, a(hashtable));
        hashtable.put("ts", a7);
        hashtable.put("scode", a8);
        return hashtable;
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        String str = h.e() + "/datasearch";
        String shape = ((a) this).b.getBound().getShape();
        if (shape.equals("Bound")) {
            return str + "/around";
        } else if (shape.equals("Polygon") || shape.equals("Rectangle")) {
            return str + "/polygon";
        } else if (!shape.equals(CloudSearch.SearchBound.LOCAL_SHAPE)) {
            return str;
        } else {
            return str + "/local";
        }
    }

    private static String a(Map<String, String> map) {
        return g(b(map));
    }

    private static String e(String str) {
        return str != null ? str.replace(jl1.AND, "%26%26") : str;
    }
}
