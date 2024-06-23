package cn.damai.homepage.util;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import cn.damai.common.util.ToastUtil;
import cn.damai.homepage.R$raw;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import tb.cw0;
import tb.vf2;
import tb.xs0;

/* compiled from: Taobao */
public class LottieMockHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_IN_MOCK = "release_me_use_lottie_url";

    public static JSONObject a(JSONArray jSONArray) {
        JSONObject a;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-177076096")) {
            return (JSONObject) ipChange.ipc$dispatch("-177076096", new Object[]{jSONArray});
        }
        if (jSONArray == null || jSONArray.size() <= 0) {
            return null;
        }
        Iterator<Object> it = jSONArray.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) next;
                boolean equals = "3".equals(jSONObject.get("level"));
                boolean equals2 = "7542".equals(jSONObject.get("type"));
                if (equals && equals2) {
                    return jSONObject;
                }
                Object obj = jSONObject.get("nodes");
                if ((obj instanceof JSONArray) && (a = a((JSONArray) obj)) != null) {
                    return a;
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0064 A[SYNTHETIC, Splitter:B:34:0x0064] */
    public static JSONObject b(String str) {
        Throwable th;
        Exception e;
        InputStream inputStream;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1368965831")) {
            return (JSONObject) ipChange.ipc$dispatch("-1368965831", new Object[]{str});
        }
        InputStream inputStream2 = null;
        try {
            inputStream = xs0.a().getResources().openRawResource(R$raw.home_amtosphere_mock);
            try {
                String a = vf2.a(inputStream);
                if (a != null) {
                    JSONObject parseObject = JSON.parseObject(a.replace(KEY_IN_MOCK, str));
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    return parseObject;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                return null;
            } catch (Exception e4) {
                e = e4;
                try {
                    e.printStackTrace();
                    d("Mock氛围解析本地数据失败");
                    if (inputStream != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            inputStream = null;
            e.printStackTrace();
            d("Mock氛围解析本地数据失败");
            if (inputStream != null) {
                inputStream.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (inputStream2 != null) {
            }
            throw th;
        }
    }

    public static void c(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1873109842")) {
            ipChange.ipc$dispatch("1873109842", new Object[]{jSONObject});
            return;
        }
        String b = cw0.b();
        if (!TextUtils.isEmpty(b) && jSONObject != null && jSONObject.containsKey("data")) {
            Object obj = jSONObject.get("data");
            if (obj instanceof JSONObject) {
                JSONObject jSONObject2 = (JSONObject) obj;
                if (jSONObject2.containsKey("nodes")) {
                    Object obj2 = jSONObject2.get("nodes");
                    if (obj2 instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj2;
                        if (jSONArray.size() > 0) {
                            JSONObject a = a(jSONArray);
                            if (a != null) {
                                Object obj3 = a.get("data");
                                if (obj3 instanceof JSONObject) {
                                    ((JSONObject) obj3).put("lottie", (Object) b);
                                    d("氛围使用Lottie 1:" + b);
                                    return;
                                }
                                return;
                            }
                            JSONObject b2 = b(b);
                            if (b2 != null) {
                                jSONArray.add(0, b2);
                                d("氛围使用Lottie 2:" + b);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void d(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1295472367")) {
            ipChange.ipc$dispatch("1295472367", new Object[]{str});
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class cn.damai.homepage.util.LottieMockHelper.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-366256777")) {
                    ipChange.ipc$dispatch("-366256777", new Object[]{this});
                    return;
                }
                ToastUtil.a().j(xs0.a(), str);
            }
        });
    }
}
