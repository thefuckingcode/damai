package com.ta.utdid2.device;

import com.ta.audid.upload.HttpResponse;
import com.ta.audid.utils.UtdidLogger;

/* compiled from: Taobao */
public class UtdidResponse {
    public static boolean response(HttpResponse httpResponse) {
        String str = "";
        try {
            str = new String(httpResponse.data, "UTF-8");
        } catch (Exception e) {
            UtdidLogger.d(str, e);
        }
        if (HttpResponse.checkSignature(str, httpResponse.signature)) {
            return BizResponse.isSuccess(BizResponse.parseResult(str).code);
        }
        return false;
    }
}
