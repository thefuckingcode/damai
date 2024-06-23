package cn.damai.ultron.net;

import android.text.TextUtils;
import cn.damai.common.AppConfig;
import cn.damai.ultron.net.api.UltronAdjustOrder;
import cn.damai.ultron.net.api.UltronBuildOrder;
import cn.damai.ultron.net.api.UltronCreateOrder;
import com.alibaba.android.ultron.trade.data.request.Request;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class DMQueryKey {
    private static transient /* synthetic */ IpChange $ipChange;
    private String addressId;
    private String domain;
    private boolean hasSourceIntKey = false;
    private String latitude;
    private String lifeBizType;
    private String longitude;
    private String mAdjustApiName;
    private String mBuildApiName;
    private String mSubmitApiName;
    private String poiId;
    private int sourceInt;
    private String storeId;

    public DMQueryKey() {
        setDomain();
    }

    public static Map<String, String> getRequestParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2027610947")) {
            return (Map) ipChange.ipc$dispatch("-2027610947", new Object[0]);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("coupon", "true");
        hashMap.put("coVersion", "2.0");
        return hashMap;
    }

    private void setDomain() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "232533885")) {
            ipChange.ipc$dispatch("232533885", new Object[]{this});
        } else if (AppConfig.g() == AppConfig.EnvMode.test) {
            this.domain = "daliy-mtop.damai.cn";
            this.mBuildApiName = "mtop.trade.order.build";
            this.mAdjustApiName = "mtop.trade.order.adjust";
            this.mSubmitApiName = "mtop.trade.order.create";
        } else if (AppConfig.g() == AppConfig.EnvMode.prepare) {
            this.domain = "pre-mtop.damai.cn";
            this.mBuildApiName = UltronBuildOrder.API_NAME_PRE;
            this.mAdjustApiName = UltronAdjustOrder.API_NAME_PRE;
            this.mSubmitApiName = UltronCreateOrder.API_NAME_PRE;
        } else if (AppConfig.g() == AppConfig.EnvMode.online) {
            this.domain = "mtop.damai.cn";
            this.mBuildApiName = "mtop.trade.order.build";
            this.mAdjustApiName = "mtop.trade.order.adjust";
            this.mSubmitApiName = "mtop.trade.order.create";
        }
    }

    public String getAddressId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "884461394")) {
            return this.addressId;
        }
        return (String) ipChange.ipc$dispatch("884461394", new Object[]{this});
    }

    public String getAdjustApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1911537369")) {
            return !TextUtils.isEmpty(this.mAdjustApiName) ? this.mAdjustApiName : "mtop.trade.order.adjust";
        }
        return (String) ipChange.ipc$dispatch("1911537369", new Object[]{this});
    }

    public String getAdjustVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-215693204")) {
            return UltronAdjustOrder.VERSION;
        }
        return (String) ipChange.ipc$dispatch("-215693204", new Object[]{this});
    }

    public String getBuildApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1996647446")) {
            return !TextUtils.isEmpty(this.mBuildApiName) ? this.mBuildApiName : "mtop.trade.order.build";
        }
        return (String) ipChange.ipc$dispatch("-1996647446", new Object[]{this});
    }

    public String getBuildVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "171089277")) {
            return "4.0";
        }
        return (String) ipChange.ipc$dispatch("171089277", new Object[]{this});
    }

    public String getCreateApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2001328460")) {
            return !TextUtils.isEmpty(this.mSubmitApiName) ? this.mSubmitApiName : "mtop.trade.order.create";
        }
        return (String) ipChange.ipc$dispatch("2001328460", new Object[]{this});
    }

    public String getCreateVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-125902113")) {
            return "4.0";
        }
        return (String) ipChange.ipc$dispatch("-125902113", new Object[]{this});
    }

    public String getDomain() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "48126135")) {
            return this.domain;
        }
        return (String) ipChange.ipc$dispatch("48126135", new Object[]{this});
    }

    public String getLatitude() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1857512031")) {
            return this.latitude;
        }
        return (String) ipChange.ipc$dispatch("1857512031", new Object[]{this});
    }

    public String getLifeBizType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "278769780")) {
            return this.lifeBizType;
        }
        return (String) ipChange.ipc$dispatch("278769780", new Object[]{this});
    }

    public String getLongitude() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1523556562")) {
            return this.longitude;
        }
        return (String) ipChange.ipc$dispatch("1523556562", new Object[]{this});
    }

    public String getPoiId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2114843352")) {
            return this.poiId;
        }
        return (String) ipChange.ipc$dispatch("-2114843352", new Object[]{this});
    }

    public int getSourceInt() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1828962500")) {
            return this.sourceInt;
        }
        return ((Integer) ipChange.ipc$dispatch("-1828962500", new Object[]{this})).intValue();
    }

    public String getStoreId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1103618687")) {
            return this.storeId;
        }
        return (String) ipChange.ipc$dispatch("1103618687", new Object[]{this});
    }

    public boolean isHasSourceIntKey() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "757385228")) {
            return this.hasSourceIntKey;
        }
        return ((Boolean) ipChange.ipc$dispatch("757385228", new Object[]{this})).booleanValue();
    }

    public void setAddressId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-316705436")) {
            ipChange.ipc$dispatch("-316705436", new Object[]{this, str});
            return;
        }
        this.addressId = str;
    }

    public DMQueryKey(Map<String, String> map) {
        try {
            setDomain();
            String str = map.get(Request.K_EXPARAMS);
            JSONObject parseObject = str != null ? JSON.parseObject(str) : new JSONObject();
            parseObject.putAll(getRequestParams());
            map.put(Request.K_EXPARAMS, parseObject.toJSONString());
            if (parseObject.containsKey("source_int")) {
                this.hasSourceIntKey = true;
                this.sourceInt = parseObject.getIntValue("source_int");
            }
            if (parseObject.containsKey("wdk_addressId")) {
                this.addressId = parseObject.getString("wdk_addressId");
            }
            if (parseObject.containsKey("wdksgll")) {
                String string = parseObject.getString("wdksgll");
                if (!TextUtils.isEmpty(string)) {
                    String[] split = string.split(",");
                    this.longitude = split[0];
                    this.latitude = split[1];
                }
            }
            if (parseObject.containsKey("poiId")) {
                this.poiId = parseObject.getString("poiId");
            }
            if (parseObject.containsKey("life_order_location")) {
                JSONObject jSONObject = parseObject.getJSONObject("life_order_location");
                this.longitude = jSONObject.getString("longitude");
                this.latitude = jSONObject.getString("latitude");
                this.addressId = jSONObject.getString("addressId");
                this.poiId = jSONObject.getString("poiId");
            }
            this.storeId = map.get("storeId");
            if (parseObject.containsKey("life_biz_type")) {
                this.lifeBizType = parseObject.getString("life_biz_type");
            }
        } catch (Throwable unused) {
        }
    }
}
