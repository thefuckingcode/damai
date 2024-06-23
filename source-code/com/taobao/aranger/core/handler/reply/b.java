package com.taobao.aranger.core.handler.reply;

import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.exception.IPCException;
import tb.hi1;
import tb.ks0;
import tb.nd1;

/* compiled from: Taobao */
public class b {
    public static IReplyHandler a(Call call) throws IPCException {
        int type = call.getServiceWrapper().getType();
        if (type == 0) {
            return new hi1(call);
        }
        if (type == 1) {
            return new ks0(call);
        }
        if (type == 3) {
            return new nd1(call);
        }
        throw new IPCException(13, "Type " + call.getServiceWrapper().getType() + " is not supported.");
    }
}
