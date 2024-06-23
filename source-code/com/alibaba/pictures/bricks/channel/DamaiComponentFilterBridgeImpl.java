package com.alibaba.pictures.bricks.channel;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.AppConfig;
import cn.damai.common.app.ShareperfenceConstants;
import cn.damai.common.net.mtop.Util;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.city.net.CityListRequest;
import cn.damai.commonbusiness.citycopy.net.CityListResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.bricks.channel.bean.LocationInfo;
import com.alibaba.pictures.bricks.channel.bean.NewLocationInfo;
import com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge;
import com.alibaba.pictures.bricks.channel.bridge.OnBizListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.model.mtop.LiveFullInfo;
import java.util.List;
import java.util.Map;
import tb.d20;
import tb.fp1;
import tb.gi;
import tb.sb;
import tb.xs0;

/* compiled from: Taobao */
public class DamaiComponentFilterBridgeImpl implements ComponentFilterBridge {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @NonNull
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "148132804")) {
            return "mtop.damai.mec.aristotle.get";
        }
        return (String) ipChange.ipc$dispatch("148132804", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @NonNull
    public String getApiVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2108279029")) {
            return LiveFullInfo.VER;
        }
        return (String) ipChange.ipc$dispatch("2108279029", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @NonNull
    public String getCityId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1989141885")) {
            return d20.c();
        }
        return (String) ipChange.ipc$dispatch("1989141885", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @NonNull
    public String getCityName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "375787821")) {
            return d20.d();
        }
        return (String) ipChange.ipc$dispatch("375787821", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @NonNull
    public String getComboChannel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1937351340")) {
            return "1";
        }
        return (String) ipChange.ipc$dispatch("1937351340", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @Nullable
    public Double[] getDMCoordinates() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1806993534")) {
            return (Double[]) ipChange.ipc$dispatch("1806993534", new Object[]{this});
        }
        double[] dMCoordinates = Util.getDMCoordinates();
        if (dMCoordinates == null || dMCoordinates.length != 2) {
            return null;
        }
        return new Double[]{Double.valueOf(dMCoordinates[0]), Double.valueOf(dMCoordinates[1])};
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @Nullable
    public CityListResponse getLocalCityList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1770973532")) {
            return (CityListResponse) ipChange.ipc$dispatch("1770973532", new Object[]{this});
        }
        String B = d20.B(ShareperfenceConstants.CITY_DATA_New);
        if (TextUtils.isEmpty(B)) {
            B = gi.a(xs0.a());
        }
        try {
            return (CityListResponse) JSON.parseObject(B, CityListResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @Nullable
    public String getSpValue(@NonNull String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1601864631")) {
            return d20.B(str);
        }
        return (String) ipChange.ipc$dispatch("-1601864631", new Object[]{this, str});
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @NonNull
    public String getTtid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1879981134")) {
            return AppConfig.p();
        }
        return (String) ipChange.ipc$dispatch("-1879981134", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @Nullable
    public String getUserCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "153547247")) {
            return d20.E();
        }
        return (String) ipChange.ipc$dispatch("153547247", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    public void reportClick(@NonNull sb.b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "237169644")) {
            ipChange.ipc$dispatch("237169644", new Object[]{this, bVar});
            return;
        }
        sb sbVar = bVar.a;
        if (sbVar != null) {
            a.b bVar2 = new a.b();
            bVar2.d(sbVar.i());
            bVar2.a(sbVar.f());
            bVar2.e(sbVar.j());
            bVar2.h(sbVar.l());
            bVar2.k(sbVar.o());
            bVar2.b(sbVar.g());
            bVar2.i(sbVar.m());
            bVar2.l(sbVar.p());
            bVar2.c(sbVar.h());
            bVar2.f(sbVar.k());
            bVar2.j(sbVar.n());
            bVar2.g(sbVar.q());
            c.e().x(bVar2);
        }
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    public void reportExposureSingleCustomEvent(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, long j, @Nullable Map<String, String> map, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2101425249")) {
            ipChange.ipc$dispatch("2101425249", new Object[]{this, str, str2, str3, str4, Long.valueOf(j), map, Integer.valueOf(i)});
            return;
        }
        c.e().C(str, str2, str3, str4, j, map, i);
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    public void requestCityList(@NonNull final OnBizListener<CityListResponse> onBizListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "398232484")) {
            ipChange.ipc$dispatch("398232484", new Object[]{this, onBizListener});
            return;
        }
        CityListRequest cityListRequest = new CityListRequest();
        cityListRequest.showLoginUI(false);
        cityListRequest.request(new DMMtopRequestListener<CityListResponse>(CityListResponse.class) {
            /* class com.alibaba.pictures.bricks.channel.DamaiComponentFilterBridgeImpl.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1432802991")) {
                    ipChange.ipc$dispatch("1432802991", new Object[]{this, str, str2});
                    return;
                }
                onBizListener.onBizFail(str, str2);
            }

            public void onSuccess(CityListResponse cityListResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "8156945")) {
                    ipChange.ipc$dispatch("8156945", new Object[]{this, cityListResponse});
                    return;
                }
                onBizListener.onBizSuccess(cityListResponse);
                if (cityListResponse != null) {
                    try {
                        d20.T(ShareperfenceConstants.CITY_DATA_New, JSON.toJSONString(cityListResponse));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    public void saveLocationInfo(@NonNull LocationInfo locationInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1668201596")) {
            ipChange.ipc$dispatch("-1668201596", new Object[]{this, locationInfo});
            return;
        }
        long j = locationInfo.cityDamaiId;
        if (j != 0) {
            double d = locationInfo.locationLat;
            double d2 = locationInfo.locationLng;
            String str = locationInfo.locationadd;
            String str2 = locationInfo.locationgname;
            d20.o0(d);
            d20.p0(d2);
            d20.m0(str);
            d20.q0(str2);
            d20.n0(j + "," + d + "," + d2);
        }
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    public void saveSpValue(@NonNull String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1610440644")) {
            ipChange.ipc$dispatch("-1610440644", new Object[]{this, str, str2});
            return;
        }
        d20.T(str, str2);
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    public void setExposureTag(@Nullable View view, @Nullable String str, @NonNull String str2, @NonNull String str3, @Nullable Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "265026735")) {
            ipChange.ipc$dispatch("265026735", new Object[]{this, view, str, str2, str3, map});
            return;
        }
        c.e().G(view, str, str2, str3, map);
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    public void setNewLocationData(@NonNull NewLocationInfo newLocationInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-287526935")) {
            ipChange.ipc$dispatch("-287526935", new Object[]{this, newLocationInfo});
            return;
        }
        long j = newLocationInfo.cityDamaiId;
        if (j != 0) {
            String str = newLocationInfo.locationgname;
            double d = newLocationInfo.locationLat;
            double d2 = newLocationInfo.locationLng;
            xs0.b = j;
            xs0.c = str;
            d20.c0(j + "");
            d20.f0(str);
            d20.d0(d);
            d20.e0(d2);
        }
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    public void showPermissionDialog(@NonNull Context context, @NonNull String str, @Nullable List<String> list, boolean z, @Nullable DialogInterface.OnClickListener onClickListener, @Nullable DialogInterface.OnClickListener onClickListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1709858552")) {
            ipChange.ipc$dispatch("-1709858552", new Object[]{this, context, str, list, Boolean.valueOf(z), onClickListener, onClickListener2});
            return;
        }
        fp1.a(context, str, list, z, onClickListener, onClickListener2);
    }
}
