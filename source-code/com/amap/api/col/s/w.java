package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.UploadInfo;

/* compiled from: Taobao */
public final class w extends b<UploadInfo, Integer> {
    private Context k;
    private UploadInfo l;

    public w(Context context, UploadInfo uploadInfo) {
        super(context, uploadInfo);
        this.k = context;
        this.l = uploadInfo;
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
        stringBuffer.append(this.l.getUserID());
        LatLonPoint point = this.l.getPoint();
        stringBuffer.append("&location=");
        stringBuffer.append(((float) ((int) (point.getLongitude() * 1000000.0d))) / 1000000.0f);
        stringBuffer.append(",");
        stringBuffer.append(((float) ((int) (point.getLatitude() * 1000000.0d))) / 1000000.0f);
        stringBuffer.append("&coordtype=");
        stringBuffer.append(this.l.getCoordType());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return h.d() + "/nearby/data/create";
    }
}
