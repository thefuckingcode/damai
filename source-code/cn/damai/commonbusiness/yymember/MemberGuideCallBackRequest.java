package cn.damai.commonbusiness.yymember;

import android.text.TextUtils;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.g91;

/* compiled from: Taobao */
public class MemberGuideCallBackRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String siteName = "damai";
    public String tipType;

    public MemberGuideCallBackRequest(String str) {
        this.tipType = str;
    }

    public static void asyncWriteBack(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1974707217")) {
            ipChange.ipc$dispatch("1974707217", new Object[]{str});
        } else if (!TextUtils.isEmpty(str)) {
            new MemberGuideCallBackRequest(str).request(new DMMtopRequestListener<Object>(Object.class) {
                /* class cn.damai.commonbusiness.yymember.MemberGuideCallBackRequest.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-931445387")) {
                        ipChange.ipc$dispatch("-931445387", new Object[]{this, str, str2});
                        return;
                    }
                    g91.b("YYMember", "回写失败" + str + " " + str2);
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(Object obj) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1230329060")) {
                        ipChange.ipc$dispatch("1230329060", new Object[]{this, obj});
                        return;
                    }
                    g91.b("YYMember", "回写成功");
                }
            });
        }
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "451422270")) {
            return "mtop.film.pfusercenter.guide.call.back";
        }
        return (String) ipChange.ipc$dispatch("451422270", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1364697007")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1364697007", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1571276693")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1571276693", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1675808303")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-1675808303", new Object[]{this});
    }
}
