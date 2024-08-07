package cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.presenter;

import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.ProjectBookingRegisterData;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.contract.ProjectBookingRegisterContract;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.repository.ProjectBookingRegisterRepository;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.yz1;

/* compiled from: Taobao */
public class ProjectBookingRegisterPresenter extends ProjectBookingRegisterContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;
    private ProjectBookingRegisterRepository mBookingRegisterRepository = new ProjectBookingRegisterRepository();

    /* compiled from: Taobao */
    public class a extends yz1<ProjectBookingRegisterData> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // tb.yz1
        public void a(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1281879040")) {
                ipChange.ipc$dispatch("-1281879040", new Object[]{this, str, str2});
                return;
            }
            ProjectBookingRegisterPresenter.this.mView.onReturnBookingRegisterDataError(str, str2, "mtop.damai.item.projectdetail.projectid.get");
        }

        /* renamed from: c */
        public void b(ProjectBookingRegisterData projectBookingRegisterData) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-988235945")) {
                ipChange.ipc$dispatch("-988235945", new Object[]{this, projectBookingRegisterData});
            } else if (projectBookingRegisterData != null) {
                ProjectBookingRegisterPresenter.this.mView.onReturnBookingRegisterDataSuccess(this.a, projectBookingRegisterData);
            } else {
                ProjectBookingRegisterPresenter.this.mView.onReturnBookingRegisterDataError("", "", "mtop.damai.item.projectdetail.projectid.get");
            }
        }
    }

    /* compiled from: Taobao */
    public class b extends yz1<FollowDataBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // tb.yz1
        public void a(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1289638399")) {
                ipChange.ipc$dispatch("-1289638399", new Object[]{this, str, str2});
                return;
            }
            ProjectBookingRegisterPresenter.this.mView.onProjectFollowError(str, str2);
        }

        /* renamed from: c */
        public void b(FollowDataBean followDataBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1667386561")) {
                ipChange.ipc$dispatch("-1667386561", new Object[]{this, followDataBean});
                return;
            }
            ProjectBookingRegisterPresenter.this.mView.onProjectFollowSuccess(followDataBean);
        }
    }

    /* compiled from: Taobao */
    public class c extends yz1<FollowDataBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // tb.yz1
        public void a(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1297397758")) {
                ipChange.ipc$dispatch("-1297397758", new Object[]{this, str, str2});
                return;
            }
            ProjectBookingRegisterPresenter.this.mView.onBookingRegisterError(str, str2);
        }

        /* renamed from: c */
        public void b(FollowDataBean followDataBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "957067166")) {
                ipChange.ipc$dispatch("957067166", new Object[]{this, followDataBean});
                return;
            }
            ProjectBookingRegisterPresenter.this.mView.onBookingRegisterSuccess(followDataBean);
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.contract.ProjectBookingRegisterContract.Presenter
    public void bookingRegisterProject(int i, long j, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1250124861")) {
            ipChange.ipc$dispatch("-1250124861", new Object[]{this, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)});
            return;
        }
        this.mBookingRegisterRepository.updateFollowRelation(i, j, i2, new c());
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.contract.ProjectBookingRegisterContract.Presenter
    public void retrieveProjectBookingRegisterData(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1205834150")) {
            ipChange.ipc$dispatch("-1205834150", new Object[]{this, Integer.valueOf(i), str});
            return;
        }
        this.mBookingRegisterRepository.retrieveProjectBookingRegisterData(str, new a(i));
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.contract.ProjectBookingRegisterContract.Presenter
    public void updateProjectFollowRelation(int i, long j, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "542464913")) {
            ipChange.ipc$dispatch("542464913", new Object[]{this, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)});
            return;
        }
        this.mBookingRegisterRepository.updateFollowRelation(i, j, i2, new b());
    }
}
