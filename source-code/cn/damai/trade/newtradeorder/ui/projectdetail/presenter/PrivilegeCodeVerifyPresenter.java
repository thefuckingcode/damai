package cn.damai.trade.newtradeorder.ui.projectdetail.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.bean.PrivilegeVerifyBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.request.PrivilegeCodeVerifyRequest;
import cn.damai.trade.newtradeorder.ui.projectdetail.contract.PrivilegeCodeVerifyContract;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PrivilegeCodeVerifyPresenter extends PrivilegeCodeVerifyContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.contract.PrivilegeCodeVerifyContract.Presenter
    public void verifyAndSignPrivilegeCode(String str, String str2, int i, long j, long j2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1830430342")) {
            ipChange.ipc$dispatch("-1830430342", new Object[]{this, str, str2, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), str3});
            return;
        }
        PrivilegeCodeVerifyRequest privilegeCodeVerifyRequest = new PrivilegeCodeVerifyRequest();
        privilegeCodeVerifyRequest.buyerId = str;
        privilegeCodeVerifyRequest.channelId = str2;
        privilegeCodeVerifyRequest.bizObjType = i;
        privilegeCodeVerifyRequest.bizObjId = j;
        privilegeCodeVerifyRequest.activityId = j2;
        privilegeCodeVerifyRequest.code = str3;
        privilegeCodeVerifyRequest.request(new DMMtopRequestListener<PrivilegeVerifyBean>(PrivilegeVerifyBean.class) {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.presenter.PrivilegeCodeVerifyPresenter.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "97533606")) {
                    ipChange.ipc$dispatch("97533606", new Object[]{this, str, str2});
                    return;
                }
                PrivilegeCodeVerifyPresenter.this.mView.onReturnVerifyPrivilegeCodeResultError(str, str2);
            }

            public void onSuccess(PrivilegeVerifyBean privilegeVerifyBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-475327082")) {
                    ipChange.ipc$dispatch("-475327082", new Object[]{this, privilegeVerifyBean});
                    return;
                }
                PrivilegeCodeVerifyPresenter.this.mView.onReturnVerifyPrivilegeCodeResultSuccess(privilegeVerifyBean);
            }
        });
    }
}
