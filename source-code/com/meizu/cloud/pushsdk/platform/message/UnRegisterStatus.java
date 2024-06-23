package com.meizu.cloud.pushsdk.platform.message;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class UnRegisterStatus extends BasicPushStatus {
    private boolean isUnRegisterSuccess;

    public UnRegisterStatus() {
    }

    public UnRegisterStatus(String str) {
        super(str);
    }

    public boolean isUnRegisterSuccess() {
        return this.isUnRegisterSuccess;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public void parseValueData(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.isNull("result")) {
            setIsUnRegisterSuccess(jSONObject.getBoolean("result"));
        }
    }

    public void setIsUnRegisterSuccess(boolean z) {
        this.isUnRegisterSuccess = z;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public String toString() {
        return super.toString() + " UnRegisterStatus{isUnRegisterSuccess=" + this.isUnRegisterSuccess + '}';
    }
}
