package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.WeatherSearchQuery;

/* compiled from: Taobao */
public final class ar extends at<WeatherSearchQuery, LocalWeatherForecast> {
    private LocalWeatherForecast k = new LocalWeatherForecast();

    public ar(Context context, WeatherSearchQuery weatherSearchQuery) {
        super(context, weatherSearchQuery);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public LocalWeatherForecast a(String str) throws AMapException {
        LocalWeatherForecast f = q.f(str);
        this.k = f;
        return f;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.col.s.a, com.amap.api.col.s.b
    public final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String city = ((a) this).b.getCity();
        if (!q.g(city)) {
            String b = b.b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(b);
        }
        stringBuffer.append("&extensions=all");
        stringBuffer.append("&key=" + bk.f(((a) this).e));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.at, com.amap.api.col.s.df
    public final /* bridge */ /* synthetic */ String h() {
        return super.h();
    }
}
