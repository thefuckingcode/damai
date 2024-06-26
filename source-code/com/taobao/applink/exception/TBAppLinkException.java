package com.taobao.applink.exception;

import com.taobao.applink.c.b;
import tb.th2;

/* compiled from: Taobao */
public class TBAppLinkException extends Exception {
    public TBAppLinkException(a aVar) {
        super(getErrorMsg(aVar));
        b.a().c(th2.b(), String.valueOf(aVar.f), null);
    }

    public TBAppLinkException(String str) {
        super(str);
        b.a().c(th2.b(), str, null);
    }

    private static String getErrorMsg(a aVar) {
        if (aVar == null) {
            return "AppLinkSDK error!";
        }
        return "AppLinkSDK error! code: " + aVar.f;
    }
}
