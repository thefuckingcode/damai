package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
public class j implements Callable<AAIDResult> {
    public Context a;

    public j(Context context) {
        this.a = context;
    }

    @Override // java.util.concurrent.Callable
    public AAIDResult call() throws Exception {
        Context context = this.a;
        if (context != null) {
            String c = o.c(context);
            AAIDResult aAIDResult = new AAIDResult();
            aAIDResult.setId(c);
            return aAIDResult;
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }
}
