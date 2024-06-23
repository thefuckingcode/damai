package tb;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.android.ultron.trade.event.model.OpenUrlEventModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMEvent;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
public class fl1 extends va {
    public static final String KEY_H5_RESULT = "data";
    public static final String KEY_OPEN_URL_EVENT = "openUrlEvent";
    public static final String KEY_OPEN_URL_PARAMS = "params";
    public static final String KEY_REQUEST_CODE = "activityRequestCode";
    public static final String KEY_RESULT_CODE = "activityResultCode";
    public static final String KEY_RESULT_DATA = "activityResultData";
    protected Intent j;
    protected IDMEvent k;

    private boolean o() {
        int intValue = ((Integer) c(KEY_REQUEST_CODE)).intValue();
        this.j = (Intent) c(KEY_RESULT_DATA);
        jn2 jn2 = (jn2) c(KEY_OPEN_URL_EVENT);
        if (this.e == null || jn2 == null) {
            return false;
        }
        int intValue2 = ((Integer) jn2.e(KEY_REQUEST_CODE)).intValue();
        IDMEvent iDMEvent = (IDMEvent) jn2.c();
        this.k = iDMEvent;
        if (iDMEvent == null) {
            return false;
        }
        JSONObject fields = iDMEvent.getFields();
        if (intValue != intValue2 || fields == null) {
            return false;
        }
        return true;
    }

    private JSONObject p(Intent intent) {
        Object obj;
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return null;
        }
        Set<String> keySet = extras.keySet();
        JSONObject jSONObject = new JSONObject();
        if (keySet != null) {
            for (String str : keySet) {
                if (!TextUtils.isEmpty(str) && (obj = extras.get(str)) != null) {
                    jSONObject.put(str, (Object) String.valueOf(obj));
                }
            }
        }
        return jSONObject;
    }

    @Override // tb.va
    public void h(jn2 jn2) {
        if (o()) {
            int intValue = ((Integer) c(KEY_RESULT_CODE)).intValue();
            String pageType = ((OpenUrlEventModel) JSON.parseObject(this.k.getFields().toJSONString(), OpenUrlEventModel.class)).getPageType();
            if (!TextUtils.isEmpty(pageType)) {
                pageType.hashCode();
                char c = 65535;
                switch (pageType.hashCode()) {
                    case -1968751561:
                        if (pageType.equals(gl1.TYPE_OPEN_URL_NATIVE)) {
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
                        if (pageType.equals(gl1.TYPE_OPEN_URL_WEEX)) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        tr2.b("OpenUrlResultSubscriber", "从native页面跳回");
                        n(this.j, intValue);
                        return;
                    case 1:
                        tr2.b("OpenUrlResultSubscriber", "从H5页面跳回");
                        m(this.j, intValue);
                        return;
                    case 2:
                        tr2.b("OpenUrlResultSubscriber", "从weex页面跳回");
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void m(Intent intent, int i) {
        OpenUrlEventModel openUrlEventModel;
        if (i == -1 && intent != null && (openUrlEventModel = (OpenUrlEventModel) JSON.parseObject(this.k.getFields().toJSONString(), OpenUrlEventModel.class)) != null) {
            JSONObject params = openUrlEventModel.getParams();
            if (params == null) {
                params = new JSONObject();
            }
            String stringExtra = intent.getStringExtra("data");
            if (stringExtra == null) {
                this.c.respondToLinkage(this.e);
                return;
            }
            try {
                Map<String, ? extends Object> parseObject = JSON.parseObject(stringExtra);
                if (parseObject != null) {
                    j(parseObject);
                    params.putAll(parseObject);
                }
            } catch (Exception unused) {
                tr2.b("OpenUrlResultSubscriber", "handleH5Result", "h5转化json失败", stringExtra);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("params", (Object) params);
            k(this.k, jSONObject);
            this.c.respondToLinkage(this.e);
        }
    }

    /* access modifiers changed from: protected */
    public void n(Intent intent, int i) {
        if (i == -1 && intent != null) {
            JSONObject p = p(intent);
            OpenUrlEventModel openUrlEventModel = null;
            try {
                openUrlEventModel = (OpenUrlEventModel) JSON.parseObject(this.k.getFields().toJSONString(), OpenUrlEventModel.class);
            } catch (Exception unused) {
            }
            if (openUrlEventModel != null) {
                JSONObject params = openUrlEventModel.getParams();
                params.putAll(p);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("params", (Object) params);
                k(this.k, jSONObject);
                this.c.respondToLinkage(this.e);
            }
        }
    }
}
