package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.bt;
import com.amap.api.col.s.t;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IWeatherSearch;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLive;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;

/* compiled from: Taobao */
public final class bi implements IWeatherSearch {
    private Context a;
    private WeatherSearchQuery b;
    private WeatherSearch.OnWeatherSearchListener c;
    private LocalWeatherLiveResult d;
    private LocalWeatherForecastResult e;
    private Handler f = null;

    public bi(Context context) throws AMapException {
        bu a2 = bt.a(context, h.a(false));
        if (a2.a == bt.c.SuccessCode) {
            this.a = context.getApplicationContext();
            this.f = t.a();
            return;
        }
        String str = a2.b;
        throw new AMapException(str, 1, str, a2.a.a());
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final WeatherSearchQuery getQuery() {
        return this.b;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void searchWeatherAsyn() {
        try {
            ao.a().a(new Runnable() {
                /* class com.amap.api.col.s.bi.AnonymousClass1 */

                public final void run() {
                    t.k kVar;
                    t.l lVar;
                    Message obtainMessage = t.a().obtainMessage();
                    obtainMessage.arg1 = 13;
                    Bundle bundle = new Bundle();
                    if (bi.this.b == null) {
                        try {
                            throw new AMapException("无效的参数 - IllegalArgumentException");
                        } catch (AMapException e) {
                            i.a(e, "WeatherSearch", "searchWeatherAsyn");
                        }
                    } else if (bi.this.b.getType() == 1) {
                        try {
                            bi biVar = bi.this;
                            biVar.d = biVar.a();
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e2) {
                            bundle.putInt("errorCode", e2.getErrorCode());
                            i.a(e2, "WeatherSearch", "searchWeatherAsyn");
                        } catch (Throwable th) {
                            i.a(th, "WeatherSearch", "searchWeatherAnsyThrowable");
                        } finally {
                            lVar = new t.l();
                            obtainMessage.what = 1301;
                            lVar.b = bi.this.c;
                            lVar.a = bi.this.d;
                            obtainMessage.obj = lVar;
                            obtainMessage.setData(bundle);
                            bi.this.f.sendMessage(obtainMessage);
                        }
                    } else if (bi.this.b.getType() == 2) {
                        try {
                            bi biVar2 = bi.this;
                            biVar2.e = biVar2.b();
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e3) {
                            bundle.putInt("errorCode", e3.getErrorCode());
                            i.a(e3, "WeatherSearch", "searchWeatherAsyn");
                        } catch (Throwable th2) {
                            i.a(th2, "WeatherSearch", "searchWeatherAnsyThrowable");
                        } finally {
                            kVar = new t.k();
                            obtainMessage.what = 1302;
                            kVar.b = bi.this.c;
                            kVar.a = bi.this.e;
                            obtainMessage.obj = kVar;
                            obtainMessage.setData(bundle);
                            bi.this.f.sendMessage(obtainMessage);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void setOnWeatherSearchListener(WeatherSearch.OnWeatherSearchListener onWeatherSearchListener) {
        this.c = onWeatherSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void setQuery(WeatherSearchQuery weatherSearchQuery) {
        this.b = weatherSearchQuery;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private LocalWeatherForecastResult b() throws AMapException {
        r.a(this.a);
        WeatherSearchQuery weatherSearchQuery = this.b;
        if (weatherSearchQuery != null) {
            ar arVar = new ar(this.a, weatherSearchQuery);
            return LocalWeatherForecastResult.createPagedResult((WeatherSearchQuery) arVar.c_(), (LocalWeatherForecast) arVar.b());
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private LocalWeatherLiveResult a() throws AMapException {
        r.a(this.a);
        WeatherSearchQuery weatherSearchQuery = this.b;
        if (weatherSearchQuery != null) {
            as asVar = new as(this.a, weatherSearchQuery);
            return LocalWeatherLiveResult.createPagedResult((WeatherSearchQuery) asVar.c_(), (LocalWeatherLive) asVar.b());
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }
}
