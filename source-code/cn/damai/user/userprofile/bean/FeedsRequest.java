package cn.damai.user.userprofile.bean;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class FeedsRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String BIZ_TYPE_ALL = "[5,6,7]";
    public static String BIZ_TYPE_OFFICAL = "[6]";
    public static String BIZ_TYPE_USER = "[1,2,3,4,5,8,9]";
    public static int FEED_TYPE_DONGTAI = 1;
    public static int FEED_TYPE_QUANZI = 3;
    public String bid;
    public String bizTypeList = BIZ_TYPE_ALL;
    public int feedType = FEED_TYPE_DONGTAI;
    private String feedapi = "mtop.damai.wireless.follow.feed.query";
    public int pageSize = 30;
    public boolean refreshHeader = false;
    public int sortType = 2;
    public String sourceId;
    public String startRow;
    public int targetType;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2039355027")) {
            return this.feedapi;
        }
        return (String) ipChange.ipc$dispatch("2039355027", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "462385658")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("462385658", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1109089290")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1109089290", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-87875546")) {
            return "1.2";
        }
        return (String) ipChange.ipc$dispatch("-87875546", new Object[]{this});
    }

    public Map<String, String> toParam() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-894868015")) {
            return (Map) ipChange.ipc$dispatch("-894868015", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("feedType", this.feedType + "");
        if (this.feedType == FEED_TYPE_DONGTAI) {
            hashMap.put("sourceId", this.sourceId + "");
        } else {
            hashMap.put("sourceId", this.bid + "");
        }
        hashMap.put("targetType", this.targetType + "");
        String str = this.startRow;
        if (str != null) {
            hashMap.put("startRow", str);
        }
        hashMap.put(Constants.Name.PAGE_SIZE, this.pageSize + "");
        hashMap.put("bizTypeList", this.bizTypeList);
        hashMap.put("sortType", "2");
        return hashMap;
    }
}
