package cn.damai.user.userprofile.bean;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class UserInfoRerquest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int USER_TYPE_ARTIST = 2;
    public static final int USER_TYPE_BRAND = 4;
    public static final int USER_TYPE_CATEGORY = 9;
    public static final int USER_TYPE_REPERTOIRE = 5;
    public static final int USER_TYPE_USER = 1;
    public static final int USER_TYPE_VANUE = 3;
    private String accountapi = "mtop.damai.wireless.search.account.head";
    public String targetId;
    public long targetType = 1;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1903526833")) {
            return this.accountapi;
        }
        return (String) ipChange.ipc$dispatch("1903526833", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2144021660")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("2144021660", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "35405336")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("35405336", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-223703740")) {
            return "2.1";
        }
        return (String) ipChange.ipc$dispatch("-223703740", new Object[]{this});
    }
}
