package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.TraceLocation;
import com.taobao.weex.common.Constants;
import io.flutter.wpkbridge.U4WPKAdapter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class fx extends fv<List<TraceLocation>, List<LatLng>> implements Runnable {
    private List<TraceLocation> h;
    private Handler i = null;
    private int j = 0;
    private int k = 0;
    private String l;

    public fx(Context context, Handler handler, List<TraceLocation> list, int i2, String str, int i3, int i4) {
        super(context, list);
        this.h = list;
        this.i = handler;
        this.k = i3;
        this.j = i4;
        this.l = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.fv, com.amap.api.mapcore.util.fu
    public String a() {
        JSONArray jSONArray = new JSONArray();
        long j2 = 0;
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            TraceLocation traceLocation = this.h.get(i2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Constants.Name.X, traceLocation.getLongitude());
                jSONObject.put(Constants.Name.Y, traceLocation.getLatitude());
                jSONObject.put("ag", (int) traceLocation.getBearing());
                long time = traceLocation.getTime();
                if (i2 == 0) {
                    if (time == 0) {
                        time = (System.currentTimeMillis() - 10000) / 1000;
                    }
                    jSONObject.put(U4WPKAdapter.KEY_TM, time / 1000);
                } else {
                    if (time != 0) {
                        long j3 = time - j2;
                        if (j3 >= 1000) {
                            jSONObject.put(U4WPKAdapter.KEY_TM, j3 / 1000);
                        }
                    }
                    jSONObject.put(U4WPKAdapter.KEY_TM, 1);
                }
                j2 = time;
                jSONObject.put("sp", (int) traceLocation.getSpeed());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        this.g = getURL() + "&" + jSONArray.toString();
        return jSONArray.toString();
    }

    @Override // com.amap.api.mapcore.util.ii
    public String getIPV6URL() {
        return eq.a(getURL());
    }

    @Override // com.amap.api.mapcore.util.ii
    public String getURL() {
        String str = "key=" + gc.f(this.f);
        String a = gf.a();
        return "http://restapi.amap.com/v4/grasproad/driving?" + str + ("&ts=" + a) + ("&scode=" + gf.a(this.f, a, str));
    }

    @Override // com.amap.api.mapcore.util.ii
    public boolean isSupportIPV6() {
        return true;
    }

    public void run() {
        new ArrayList();
        try {
            fz.a().a(this.l, this.j, (List) e());
            fz.a().a(this.l).a(this.i);
        } catch (ft e) {
            fz.a().a(this.i, this.k, e.a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public List<LatLng> b(String str) throws ft {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("data") && (optJSONArray = jSONObject.optJSONObject("data").optJSONArray("points")) != null) {
                if (optJSONArray.length() != 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        arrayList.add(new LatLng(Double.parseDouble(optJSONObject.optString(Constants.Name.Y)), Double.parseDouble(optJSONObject.optString(Constants.Name.X))));
                    }
                    return arrayList;
                }
            }
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
