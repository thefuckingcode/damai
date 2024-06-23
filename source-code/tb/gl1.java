package tb;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.android.ultron.trade.event.model.OpenUrlEventModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMEvent;
import java.util.HashMap;

/* compiled from: Taobao */
public class gl1 extends va {
    public static final String KET_OPEN_URL_H5_OLD_COMPONENT = "__oldComponent";
    public static final String KEY_H5_DATA_PREFIX = "data=";
    public static final String KEY_H5_POST_DATA = "postdata";
    public static final String KEY_H5_QUERY_DATA = "querydata";
    public static final String KEY_OPEN_URL_H5_IS_POST_URL = "isPostUrl";
    public static final String TYPE_OPEN_URL_H5 = "H5";
    public static final String TYPE_OPEN_URL_METHOD_GET = "get";
    public static final String TYPE_OPEN_URL_METHOD_POST = "post";
    public static final String TYPE_OPEN_URL_NATIVE = "Native";
    public static final String TYPE_OPEN_URL_WEEX = "Weex";
    protected int j = 100;
    private int k = 204800;

    public gl1() {
        a();
    }

    private void m(String str) {
        if (str != null && str.length() >= this.k) {
            HashMap hashMap = new HashMap();
            hashMap.put("intent_size", String.valueOf(str.length()));
            ir2.a("FAIL_BINDER_TRANSATION", "intent has to many data in jump to native ", hashMap);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0032 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    @Override // tb.va
    public void h(jn2 jn2) {
        OpenUrlEventModel openUrlEventModel;
        IDMEvent e = e();
        if (e != null && e.getFields() != null) {
            OpenUrlEventModel openUrlEventModel2 = null;
            try {
                String jSONString = e.getFields().toJSONString();
                openUrlEventModel = (OpenUrlEventModel) JSON.parseObject(jSONString, OpenUrlEventModel.class);
                try {
                    m(jSONString);
                } catch (Exception unused) {
                    openUrlEventModel2 = openUrlEventModel;
                }
            } catch (Exception unused2) {
                tr2.b("OpenUrlSubscriber", "onHandleEvent JSON.parseObject failed");
                openUrlEventModel = openUrlEventModel2;
                if (openUrlEventModel == null) {
                }
            }
            if (openUrlEventModel == null) {
                String pageType = openUrlEventModel.getPageType();
                String url = openUrlEventModel.getUrl();
                JSONObject params = openUrlEventModel.getParams();
                if (pageType != null && url != null) {
                    int i = this.j + 1;
                    this.j = i;
                    jn2.m(fl1.KEY_REQUEST_CODE, Integer.valueOf(i));
                    char c = 65535;
                    switch (pageType.hashCode()) {
                        case -1968751561:
                            if (pageType.equals(TYPE_OPEN_URL_NATIVE)) {
                                c = 0;
                                break;
                            }
                            break;
                        case 2285:
                            if (pageType.equals("H5")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 2692129:
                            if (pageType.equals(TYPE_OPEN_URL_WEEX)) {
                                c = 2;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            tr2.b("OpenUrlSubscriber", "跳转到native页面", url);
                            o(url, params);
                            break;
                        case 1:
                            tr2.b("OpenUrlSubscriber", "跳转到h5页面", url);
                            n(url, params, openUrlEventModel.getMethod());
                            break;
                        case 2:
                            tr2.b("OpenUrlSubscriber", "跳转到weex页面", url);
                            p(url, params);
                            break;
                    }
                    this.c.getTradeEventHandler().n(jn2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void n(String str, JSONObject jSONObject, String str2) {
        JSONObject jSONObject2;
        String string = jSONObject != null ? jSONObject.getString(KET_OPEN_URL_H5_OLD_COMPONENT) : null;
        if (TextUtils.isEmpty(str2)) {
            str2 = TYPE_OPEN_URL_METHOD_POST;
        }
        if (string == null || jSONObject == null) {
            str2 = TYPE_OPEN_URL_METHOD_GET;
        }
        if (TYPE_OPEN_URL_METHOD_GET.equals(str2)) {
            o4.c().from(this.b).forResult(this.j).toUri(str);
            return;
        }
        Bundle bundle = new Bundle();
        if (string != null) {
            try {
                String encode = Uri.encode(string);
                bundle.putString(KEY_H5_POST_DATA, KEY_H5_DATA_PREFIX + encode);
            } catch (Exception unused) {
                tr2.b("OpenUrlSubscriber", "oldComponent encode 失败", string);
            }
        }
        bundle.putBoolean(KEY_OPEN_URL_H5_IS_POST_URL, true);
        try {
            jSONObject2 = JSON.parseObject(string);
        } catch (Throwable unused2) {
            jSONObject2 = new JSONObject();
        }
        o4.c().from(this.b).forResult(this.j).withExtras(bundle).toUri(o4.c().from(this.b).createPostUri(str, jSONObject2));
    }

    /* access modifiers changed from: protected */
    public void o(String str, JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        if (jSONObject != null) {
            for (String str2 : jSONObject.keySet()) {
                if (!TextUtils.isEmpty(str2)) {
                    Object obj = jSONObject.get(str2);
                    if (obj instanceof Boolean) {
                        bundle.putBoolean(str2, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Integer) {
                        bundle.putInt(str2, ((Integer) obj).intValue());
                    } else if (obj instanceof Double) {
                        bundle.putDouble(str2, ((Double) obj).doubleValue());
                    } else if (obj instanceof Long) {
                        bundle.putLong(str2, ((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        bundle.putString(str2, (String) obj);
                    }
                }
            }
        }
        o4.c().from(this.b).forResult(this.j).withExtras(bundle).toUri(str);
    }

    /* access modifiers changed from: protected */
    public void p(String str, JSONObject jSONObject) {
    }
}
