package com.taobao.android.tlog.protocol.model.request;

import android.text.TextUtils;
import com.ali.user.mobile.ui.WebConstant;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.tlog.protocol.model.RequestResult;
import com.taobao.android.tlog.protocol.model.reply.base.UploadTokenInfo;
import com.taobao.android.tlog.protocol.model.request.base.FileInfo;
import com.taobao.android.tlog.protocol.model.request.base.LogRequestBase;
import com.taobao.android.tlog.protocol.utils.RandomIdUtils;
import java.util.Map;

/* compiled from: Taobao */
public class ApplyUploadRequest extends LogRequestBase {
    private String TAG = "TLOG.Protocol.ApplyUploadRequestInfo";
    public String bizCode;
    public String bizType;
    public String debugType;
    public Map<String, Object> extraInfo;
    public FileInfo[] fileInfos;
    private String requestType = "REQUEST";

    public RequestResult build(String str) throws Exception {
        String randomId = RandomIdUtils.getRandomId();
        if (TextUtils.isEmpty(str)) {
            str = RandomIdUtils.getRandomId();
        }
        JSONObject buildRequestHeader = BuilderHelper.buildRequestHeader(this, randomId, str);
        JSONObject jSONObject = new JSONObject();
        String str2 = this.debugType;
        if (str2 != null) {
            jSONObject.put("debugType", (Object) str2);
        }
        String str3 = this.bizType;
        if (str3 != null) {
            jSONObject.put("bizType", (Object) str3);
        }
        String str4 = this.bizCode;
        if (str4 != null) {
            jSONObject.put("bizCode", (Object) str4);
        }
        String str5 = this.tokenType;
        if (str5 != null) {
            jSONObject.put(WebConstant.WEB_LOGIN_TOKEN_TYPE, (Object) str5);
        }
        UploadTokenInfo uploadTokenInfo = this.tokenInfo;
        if (uploadTokenInfo != null) {
            jSONObject.put("tokenInfo", (Object) uploadTokenInfo);
        }
        FileInfo[] fileInfoArr = this.fileInfos;
        if (fileInfoArr != null) {
            jSONObject.put("fileInfos", (Object) BuilderHelper.buildFileInfos(fileInfoArr));
        }
        Map<String, Object> map = this.extraInfo;
        if (map != null) {
            jSONObject.put("extraInfo", (Object) map);
        }
        return BuilderHelper.buildRequestResult(jSONObject, buildRequestHeader, this.requestType, randomId, str, str);
    }

    public RequestResult build() throws Exception {
        return build(RandomIdUtils.getRandomId());
    }
}
