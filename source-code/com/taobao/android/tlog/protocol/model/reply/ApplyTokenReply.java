package com.taobao.android.tlog.protocol.model.reply;

import com.ali.user.mobile.ui.WebConstant;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.tlog.protocol.model.CommandInfo;
import com.taobao.android.tlog.protocol.model.reply.base.UploadTokenInfo;

/* compiled from: Taobao */
public class ApplyTokenReply {
    private String TAG = "TLOG.Protocol.ApplyTokenReplyParser";
    public UploadTokenInfo[] tokenInfos;
    public String tokenType;
    public String uploadId;

    public void parse(JSON json, CommandInfo commandInfo) throws Exception {
        JSONArray jSONArray;
        JSONObject jSONObject = (JSONObject) json;
        if (jSONObject.containsKey("uploadId")) {
            this.uploadId = jSONObject.getString("uploadId");
        }
        if (jSONObject.containsKey(WebConstant.WEB_LOGIN_TOKEN_TYPE)) {
            this.tokenType = jSONObject.getString(WebConstant.WEB_LOGIN_TOKEN_TYPE);
        }
        if (jSONObject.containsKey("tokenInfos") && (jSONArray = jSONObject.getJSONArray("tokenInfos")) != null && jSONArray.size() > 0) {
            this.tokenInfos = ParseHelper.parseUploadInfos(jSONArray);
        }
    }
}
