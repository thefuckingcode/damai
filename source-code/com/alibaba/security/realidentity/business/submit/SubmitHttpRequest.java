package com.alibaba.security.realidentity.business.submit;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.security.realidentity.http.annotation.Api;
import com.alibaba.security.realidentity.http.annotation.Body;
import com.alibaba.security.realidentity.http.model.HttpMethod;
import com.alibaba.security.realidentity.http.model.HttpRequest;
import com.alibaba.security.realidentity.jsbridge.a;

@Api(method = HttpMethod.POST, name = "mtop.verifycenter.rp.submit")
@Body
/* compiled from: Taobao */
public class SubmitHttpRequest extends HttpRequest {
    @JSONField(name = a.d)
    public String verifyToken;
}
