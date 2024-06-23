package cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.repository;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.repository.ProjectCommonRepository;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.ProjectBookingRegisterData;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.request.ProjectBookingRegisterRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.yz1;

/* compiled from: Taobao */
public class ProjectBookingRegisterRepository extends ProjectCommonRepository {
    private static transient /* synthetic */ IpChange $ipChange;

    public void retrieveProjectBookingRegisterData(String str, final yz1 yz1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-641421125")) {
            ipChange.ipc$dispatch("-641421125", new Object[]{this, str, yz1});
            return;
        }
        ProjectBookingRegisterRequest projectBookingRegisterRequest = new ProjectBookingRegisterRequest();
        projectBookingRegisterRequest.projectId = str;
        projectBookingRegisterRequest.request(new DMMtopRequestListener<ProjectBookingRegisterData>(ProjectBookingRegisterData.class) {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.repository.ProjectBookingRegisterRepository.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-109765420")) {
                    ipChange.ipc$dispatch("-109765420", new Object[]{this, str, str2});
                    return;
                }
                yz1 yz1 = yz1;
                if (yz1 != null) {
                    yz1.a(str, str2);
                }
            }

            public void onSuccess(ProjectBookingRegisterData projectBookingRegisterData) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "640725763")) {
                    ipChange.ipc$dispatch("640725763", new Object[]{this, projectBookingRegisterData});
                    return;
                }
                yz1 yz1 = yz1;
                if (yz1 != null) {
                    yz1.b(projectBookingRegisterData);
                }
            }
        });
    }
}
