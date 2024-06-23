package cn.damai.commonbusiness.city.util;

import android.content.Context;
import android.text.TextUtils;
import cn.damai.common.app.ShareperfenceConstants;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.city.model.GroupsBean;
import cn.damai.commonbusiness.city.model.HotCityBean;
import cn.damai.commonbusiness.city.model.SitesBean;
import cn.damai.commonbusiness.city.net.CityListResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.piclocation.listener.LocateGpsPicListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.d20;
import tb.hp1;
import tb.lp1;
import tb.m81;
import tb.o81;
import tb.xf2;
import tb.xs0;

/* compiled from: Taobao */
public class CityLocationUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    public LocaltionListener b;
    private long c;
    private Double d;
    private Double e;
    private String f;
    private String g;
    private boolean h = false;
    private boolean i = true;

    /* compiled from: Taobao */
    public interface LocaltionListener {
        void onGetLocalFinsih();

        void onGetLocalSuccess(SitesBean sitesBean);
    }

    /* compiled from: Taobao */
    public class a implements LocateGpsPicListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // com.alibaba.pictures.piclocation.listener.LocateGpsPicListener
        public void onFailed(int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1832440435")) {
                ipChange.ipc$dispatch("1832440435", new Object[]{this, Integer.valueOf(i), str});
                return;
            }
            LocaltionListener localtionListener = CityLocationUtil.this.b;
            if (localtionListener != null) {
                localtionListener.onGetLocalFinsih();
            }
        }

        @Override // com.alibaba.pictures.piclocation.listener.LocateGpsPicListener
        public void onLocationSuccess(m81 m81) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1240161866")) {
                ipChange.ipc$dispatch("-1240161866", new Object[]{this, m81});
                return;
            }
            CityLocationUtil.this.d = Double.valueOf(m81.a);
            CityLocationUtil.this.e = Double.valueOf(m81.b);
            CityLocationUtil.this.f = m81.e;
            CityLocationUtil.this.g = m81.d;
            if (CityLocationUtil.this.d.doubleValue() == 0.0d || CityLocationUtil.this.e.doubleValue() == 0.0d || TextUtils.isEmpty(CityLocationUtil.this.g)) {
                CityLocationUtil.this.d = Double.valueOf(39.907325d);
                CityLocationUtil.this.e = Double.valueOf(116.39145d);
                CityLocationUtil.this.f = "北京市天安门";
                CityLocationUtil.this.g = "北京";
                return;
            }
            if (!TextUtils.isEmpty(CityLocationUtil.this.g) && CityLocationUtil.this.g.endsWith(CityLocationUtil.this.a.getString(R$string.unit_name_city)) && CityLocationUtil.this.g.length() > 1) {
                CityLocationUtil cityLocationUtil = CityLocationUtil.this;
                cityLocationUtil.g = cityLocationUtil.g.substring(0, CityLocationUtil.this.g.length() - 1);
            }
            CityLocationUtil cityLocationUtil2 = CityLocationUtil.this;
            long m = cityLocationUtil2.m(cityLocationUtil2.g);
            if (m != 0) {
                CityLocationUtil.this.c = m;
                if (CityLocationUtil.this.b != null) {
                    SitesBean sitesBean = new SitesBean();
                    sitesBean.setCityId(m + "");
                    sitesBean.setCityName(CityLocationUtil.this.g);
                    CityLocationUtil.this.b.onGetLocalSuccess(sitesBean);
                }
                if (CityLocationUtil.this.i) {
                    CityLocationUtil.this.o();
                }
                if (!CityLocationUtil.this.h) {
                    CityLocationUtil.this.q();
                }
            }
        }
    }

    public CityLocationUtil(Context context, LocaltionListener localtionListener) {
        this.a = context;
        this.b = localtionListener;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private long m(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "274921347")) {
            return ((Long) ipChange.ipc$dispatch("274921347", new Object[]{this, str})).longValue();
        } else if (TextUtils.isEmpty(str)) {
            return 0;
        } else {
            String B = d20.B(ShareperfenceConstants.CITY_DATA_New);
            if (TextUtils.isEmpty(B)) {
                return 0;
            }
            try {
                CityListResponse cityListResponse = (CityListResponse) JSON.parseObject(B, CityListResponse.class);
                if (cityListResponse == null) {
                    return 0;
                }
                List<GroupsBean> groups = cityListResponse.getGroups();
                if (xf2.e(groups) <= 0) {
                    return 0;
                }
                for (int i2 = 0; i2 < groups.size(); i2++) {
                    GroupsBean groupsBean = groups.get(i2);
                    if (groupsBean != null) {
                        List<SitesBean> sites = groupsBean.getSites();
                        if (xf2.e(sites) > 0) {
                            for (int i3 = 0; i3 < sites.size(); i3++) {
                                SitesBean sitesBean = sites.get(i3);
                                if (!(sitesBean == null || TextUtils.isEmpty(sitesBean.getCityName()) || !sitesBean.getCityName().equals(str) || TextUtils.isEmpty(sitesBean.getCityId()) || TextUtils.isEmpty(sitesBean.getCityId().trim()))) {
                                    return xf2.m(sitesBean.getCityId(), 0);
                                }
                            }
                            continue;
                        } else {
                            continue;
                        }
                    }
                }
                List<HotCityBean> hotCity = cityListResponse.getHotCity();
                if (xf2.e(groups) <= 0) {
                    return 0;
                }
                for (int i4 = 0; i4 < hotCity.size(); i4++) {
                    HotCityBean hotCityBean = hotCity.get(i4);
                    if (!(hotCityBean == null || TextUtils.isEmpty(hotCityBean.getCityName()) || !hotCityBean.getCityName().equals(str) || TextUtils.isEmpty(hotCityBean.getCityId()) || TextUtils.isEmpty(hotCityBean.getCityId().trim()))) {
                        return (long) Integer.parseInt(hotCityBean.getCityId());
                    }
                }
                return 0;
            } catch (Exception e2) {
                e2.printStackTrace();
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1301419846")) {
            ipChange.ipc$dispatch("1301419846", new Object[]{this});
        } else if (hp1.i(lp1.LOCATION)) {
            o81.INSTANCE.c().startLocationWithCacheTime(new a(), 0);
        }
    }

    public void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "132526057")) {
            ipChange.ipc$dispatch("132526057", new Object[]{this});
        } else if (this.c != 0) {
            d20.o0(this.d.doubleValue());
            d20.p0(this.e.doubleValue());
            d20.m0(this.f);
            d20.q0(this.g);
            d20.n0(this.c + "," + this.d + "," + this.e);
        }
    }

    public void p(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-271901251")) {
            ipChange.ipc$dispatch("-271901251", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.h = z;
    }

    public void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "746680300")) {
            ipChange.ipc$dispatch("746680300", new Object[]{this});
            return;
        }
        long j = this.c;
        if (j != 0) {
            xs0.b = j;
            xs0.c = this.g;
            d20.c0(this.c + "");
            d20.f0(this.g);
            d20.d0(this.d.doubleValue());
            d20.e0(this.e.doubleValue());
        }
    }
}
