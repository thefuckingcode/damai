package com.taobao.slide.request;

import android.content.Context;
import mtopsdk.common.util.HttpHeaderConstant;
import tb.if1;
import tb.o22;

/* compiled from: Taobao */
public abstract class c<T> extends b<T> {
    public c(Context context, String str, String str2) {
        super(context, str, str2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0066, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0067, code lost:
        r0.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006a, code lost:
        throw r1;
     */
    @Override // com.taobao.slide.request.b
    public String a() throws Throwable {
        IConnection iConnection;
        if (b.d) {
            iConnection = new e(this.a);
        } else {
            iConnection = new d();
        }
        o22.g("BaseRequest", "CdnRequest", "URL", this.b);
        iConnection.openConnection(this.b);
        if (b.d) {
            iConnection.addHeader(HttpHeaderConstant.F_REFER, if1.MODULE_NAME);
        }
        iConnection.setMethod("GET");
        iConnection.connect();
        int responseCode = iConnection.getResponseCode();
        if (responseCode == 200) {
            String response = iConnection.getResponse();
            iConnection.disconnect();
            return response;
        }
        throw new RuntimeException("get response code:" + responseCode);
    }
}
