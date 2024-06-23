package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;

/* compiled from: Taobao */
public final class u extends b<String, Integer> {
    private Context k;
    private String l;

    public u(Context context, String str) {
        super(context, str);
        this.k = context;
        this.l = str;
    }

    private static Integer j() throws AMapException {
        return 0;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a, com.amap.api.col.s.b
    public final /* synthetic */ Integer a(String str) throws AMapException {
        return j();
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a, com.amap.api.col.s.b
    public final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bk.f(this.k));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.l);
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return h.d() + "/nearby/data/delete";
    }
}
