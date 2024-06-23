package com.alibaba.emas.publish.channel.mtop;

import androidx.annotation.Keep;
import com.alibaba.fastjson.JSONObject;

@Keep
/* compiled from: Taobao */
public class PublishMtopUpdateInfo {
    public long applicationId;
    public long batchId;
    public String biz;
    public JSONObject payload;
    public long productId;
}
