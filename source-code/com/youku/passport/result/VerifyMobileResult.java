package com.youku.passport.result;

import android.text.TextUtils;
import com.youku.usercenter.passport.api.result.Result;
import org.json.JSONObject;

/* compiled from: Taobao */
public class VerifyMobileResult extends Result {
    public String mVerifyResultDataToken;

    public void parseFrom(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull("content")) {
                    String optString = jSONObject.optString("content");
                    if (!TextUtils.isEmpty(optString)) {
                        JSONObject jSONObject2 = new JSONObject(optString);
                        if (!jSONObject2.isNull("verifyResultToken")) {
                            this.mVerifyResultDataToken = jSONObject2.optString("verifyResultToken");
                        }
                    }
                }
                if (!jSONObject.isNull("resultCode")) {
                    setResultCode(jSONObject.optInt("resultCode"));
                }
                if (!jSONObject.isNull("resultMsg")) {
                    setResultMsg(jSONObject.optString("resultMsg"));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.youku.passport.result.AbsResult
    public JSONObject toJson() {
        JSONObject jSONObject;
        Throwable th;
        try {
            jSONObject = super.toJson();
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(this.mVerifyResultDataToken)) {
                    jSONObject2.put("verifyResultToken", this.mVerifyResultDataToken);
                }
                jSONObject.put("content", jSONObject2);
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                return jSONObject;
            }
        } catch (Throwable th3) {
            th = th3;
            jSONObject = null;
            th.printStackTrace();
            return jSONObject;
        }
        return jSONObject;
    }
}
