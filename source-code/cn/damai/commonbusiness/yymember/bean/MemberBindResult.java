package cn.damai.commonbusiness.yymember.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class MemberBindResult implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String returnCode;
    public String returnMessage;
    public ReturnValue returnValue;

    /* compiled from: Taobao */
    public static class ReturnValue implements Serializable {
        public String dmHavanaId;
        public String tbUserId;
    }

    public boolean isSuccess() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1902892615")) {
            return TextUtils.equals("0", this.returnCode);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1902892615", new Object[]{this})).booleanValue();
    }
}
