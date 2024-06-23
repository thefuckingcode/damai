package cn.damai.commonbusiness.seatbiz.seat.qilin.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.SeatCalcParams;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.f92;

/* compiled from: Taobao */
public class MtopCalcTicketPriceRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String calculateTag;
    public String dmChannel = "*@damai_android_*";
    public String itemId;
    public String performId;
    public String skuParamListJson;

    @Deprecated
    public MtopCalcTicketPriceRequest(String str, String str2, boolean z, boolean z2, boolean z3, List<SeatCalcParams> list) {
        this.itemId = str;
        this.performId = str2;
        if (f92.d(list)) {
            this.skuParamListJson = null;
        } else {
            this.skuParamListJson = JSON.toJSONString(list);
        }
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "144536461")) {
            return "mtop.damai.item.calcTicketPrice";
        }
        return (String) ipChange.ipc$dispatch("144536461", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1356136512")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("1356136512", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1207977796")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1207977796", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1982694112")) {
            return "2.0";
        }
        return (String) ipChange.ipc$dispatch("-1982694112", new Object[]{this});
    }

    public MtopCalcTicketPriceRequest(String str, String str2, String str3, List<SeatCalcParams> list) {
        this.itemId = str;
        this.performId = str2;
        this.calculateTag = str3;
        if (f92.d(list)) {
            this.skuParamListJson = null;
        } else {
            this.skuParamListJson = JSON.toJSONString(list);
        }
    }
}
