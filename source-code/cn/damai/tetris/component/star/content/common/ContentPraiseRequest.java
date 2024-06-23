package cn.damai.tetris.component.star.content.common;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.discover.content.net.ContentDetailApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ContentPraiseRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String operate;
    public String targetId;
    public String targetType;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1736339586")) {
            return ContentDetailApi.CONTENT_COMMENT_PRAISE;
        }
        return (String) ipChange.ipc$dispatch("1736339586", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2083149803")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("2083149803", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1667092903")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1667092903", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-390890987")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-390890987", new Object[]{this});
    }
}
