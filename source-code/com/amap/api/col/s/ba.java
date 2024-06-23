package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.bt;
import com.amap.api.col.s.t;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.interfaces.IGeocodeSearch;
import java.util.List;

/* compiled from: Taobao */
public final class ba implements IGeocodeSearch {
    private Context a;
    private GeocodeSearch.OnGeocodeSearchListener b;
    private Handler c;

    public ba(Context context) throws AMapException {
        bu a2 = bt.a(context, h.a(false));
        if (a2.a == bt.c.SuccessCode) {
            this.a = context.getApplicationContext();
            this.c = t.a();
            return;
        }
        String str = a2.b;
        throw new AMapException(str, 1, str, a2.a.a());
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final RegeocodeAddress getFromLocation(RegeocodeQuery regeocodeQuery) throws AMapException {
        try {
            r.a(this.a);
            if (a(regeocodeQuery)) {
                return (RegeocodeAddress) new ai(this.a, regeocodeQuery).b();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            i.a(e, "GeocodeSearch", "getFromLocationAsyn");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void getFromLocationAsyn(final RegeocodeQuery regeocodeQuery) {
        try {
            ao.a().a(new Runnable() {
                /* class com.amap.api.col.s.ba.AnonymousClass1 */

                public final void run() {
                    Message obtainMessage = t.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 2;
                        obtainMessage.what = 201;
                        t.i iVar = new t.i();
                        iVar.b = ba.this.b;
                        obtainMessage.obj = iVar;
                        iVar.a = new RegeocodeResult(regeocodeQuery, ba.this.getFromLocation(regeocodeQuery));
                        obtainMessage.arg2 = 1000;
                    } catch (AMapException e) {
                        obtainMessage.arg2 = e.getErrorCode();
                    } catch (Throwable th) {
                        ba.this.c.sendMessage(obtainMessage);
                        throw th;
                    }
                    ba.this.c.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            i.a(th, "GeocodeSearch", "getFromLocationAsyn_threadcreate");
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final List<GeocodeAddress> getFromLocationName(GeocodeQuery geocodeQuery) throws AMapException {
        try {
            r.a(this.a);
            if (geocodeQuery != null) {
                return (List) new o(this.a, geocodeQuery).b();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            i.a(e, "GeocodeSearch", "getFromLocationName");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void getFromLocationNameAsyn(final GeocodeQuery geocodeQuery) {
        try {
            ao.a().a(new Runnable() {
                /* class com.amap.api.col.s.ba.AnonymousClass2 */

                public final void run() {
                    Message obtainMessage = t.a().obtainMessage();
                    try {
                        obtainMessage.what = 200;
                        obtainMessage.arg1 = 2;
                        obtainMessage.arg2 = 1000;
                        t.e eVar = new t.e();
                        eVar.b = ba.this.b;
                        obtainMessage.obj = eVar;
                        eVar.a = new GeocodeResult(geocodeQuery, ba.this.getFromLocationName(geocodeQuery));
                    } catch (AMapException e) {
                        obtainMessage.arg2 = e.getErrorCode();
                    } catch (Throwable th) {
                        ba.this.c.sendMessage(obtainMessage);
                        throw th;
                    }
                    ba.this.c.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            i.a(th, "GeocodeSearch", "getFromLocationNameAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void setOnGeocodeSearchListener(GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener) {
        this.b = onGeocodeSearchListener;
    }

    private static boolean a(RegeocodeQuery regeocodeQuery) {
        if (regeocodeQuery == null || regeocodeQuery.getPoint() == null || regeocodeQuery.getLatLonType() == null) {
            return false;
        }
        return true;
    }
}
