package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.presenter;

import android.text.TextUtils;
import cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.SkuBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.SkuSaveInfo;
import cn.damai.commonbusiness.seatbiz.sku.qilin.request.SkuItem;
import cn.damai.commonbusiness.seatbiz.sku.qilin.request.SkuRequest;
import cn.damai.trade.newtradeorder.ui.projectdetail.bean.ProjectDetailCommentBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDetailDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectInformationBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectRecommendListBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.repository.ProjectItemRepository;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ub2;
import tb.xl2;
import tb.yz1;

/* compiled from: Taobao */
public class ProjectItemPresenter extends ProjectItemContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;
    private ProjectItemRepository mRepository = new ProjectItemRepository();

    /* compiled from: Taobao */
    public class a extends yz1<ProjectDetailDataBean> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // tb.yz1
        public void a(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1773556509")) {
                ipChange.ipc$dispatch("-1773556509", new Object[]{this, str, str2});
                return;
            }
            ProjectItemPresenter.this.mView.onNetError(str, str2, "mtop.alibaba.damai.detail.getdetail");
        }

        /* renamed from: c */
        public void b(ProjectDetailDataBean projectDetailDataBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "516733661")) {
                ipChange.ipc$dispatch("516733661", new Object[]{this, projectDetailDataBean});
                return;
            }
            ProjectItemPresenter.this.mView.onReturnProjectDetailDataSuccess(this.a, projectDetailDataBean);
            ProjectItemPresenter.this.mView.onNetSuccess();
        }
    }

    /* compiled from: Taobao */
    public class b extends yz1<ProjectInformationBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // tb.yz1
        public void a(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1781315868")) {
                ipChange.ipc$dispatch("-1781315868", new Object[]{this, str, str2});
                return;
            }
            ProjectItemPresenter.this.mView.onReturnProjectNATDataFail(str, str2);
        }

        /* renamed from: c */
        public void b(ProjectInformationBean projectInformationBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-367374611")) {
                ipChange.ipc$dispatch("-367374611", new Object[]{this, projectInformationBean});
                return;
            }
            ProjectItemPresenter.this.mView.onReturnProjectNATDataSuccess(projectInformationBean);
        }
    }

    /* compiled from: Taobao */
    public class c extends yz1<ProjectRecommendListBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // tb.yz1
        public void a(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1796834586")) {
                ipChange.ipc$dispatch("-1796834586", new Object[]{this, str, str2});
                return;
            }
            ProjectItemPresenter.this.mView.onReturnProjectRecommendError(str, str2);
        }

        /* renamed from: c */
        public void b(ProjectRecommendListBean projectRecommendListBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1244877089")) {
                ipChange.ipc$dispatch("1244877089", new Object[]{this, projectRecommendListBean});
                return;
            }
            ProjectItemPresenter.this.mView.onReturnProjectRecommendSuccess(projectRecommendListBean);
        }
    }

    /* compiled from: Taobao */
    public class d extends yz1<ProjectDetailCommentBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // tb.yz1
        public void a(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1804593945")) {
                ipChange.ipc$dispatch("-1804593945", new Object[]{this, str, str2});
                return;
            }
            ProjectItemPresenter.this.mView.onReturnProjectDetailCommentError(str, str2);
        }

        /* renamed from: c */
        public void b(ProjectDetailCommentBean projectDetailCommentBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-549881732")) {
                ipChange.ipc$dispatch("-549881732", new Object[]{this, projectDetailCommentBean});
                return;
            }
            ProjectItemPresenter.this.mView.onReturnProjectDetailCommentSuccess(projectDetailCommentBean);
        }
    }

    /* compiled from: Taobao */
    public class e extends yz1<ProjectDetailCommentBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // tb.yz1
        public void a(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1812353304")) {
                ipChange.ipc$dispatch("-1812353304", new Object[]{this, str, str2});
                return;
            }
            ProjectItemPresenter.this.mView.onRetrieveDiscussionError(str, str2);
        }

        /* renamed from: c */
        public void b(ProjectDetailCommentBean projectDetailCommentBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-991636227")) {
                ipChange.ipc$dispatch("-991636227", new Object[]{this, projectDetailCommentBean});
                return;
            }
            ProjectItemPresenter.this.mView.onRetrieveDiscussionSuccess(projectDetailCommentBean);
        }
    }

    /* compiled from: Taobao */
    public class f extends yz1<FollowDataBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        @Override // tb.yz1
        public void a(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1820112663")) {
                ipChange.ipc$dispatch("-1820112663", new Object[]{this, str, str2});
                return;
            }
            ProjectItemPresenter.this.mView.onUpdateProjectFollowStatusError(str, str2);
        }

        /* renamed from: c */
        public void b(FollowDataBean followDataBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1010573143")) {
                ipChange.ipc$dispatch("1010573143", new Object[]{this, followDataBean});
                return;
            }
            ProjectItemPresenter.this.mView.onUpdateProjectFollowStatusSuccess(followDataBean);
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.Presenter
    public void getProjectDetailData(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1545230092")) {
            ipChange.ipc$dispatch("1545230092", new Object[]{this, Integer.valueOf(i), str});
            return;
        }
        this.mRepository.retrieveProjectItemData(str, new a(i));
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.Presenter
    public void getProjectDetailDiscussion(long j, long j2, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2030420371")) {
            ipChange.ipc$dispatch("-2030420371", new Object[]{this, Long.valueOf(j), Long.valueOf(j2), str});
            return;
        }
        this.mRepository.retrieveDiscussions(j, j2, str, 1, 1, 3, new e());
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.Presenter
    public void getProjectDetailEvaluates(long j, long j2, String str, int i, int i2, int i3, int i4, boolean z, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-210733553")) {
            ipChange.ipc$dispatch("-210733553", new Object[]{this, Long.valueOf(j), Long.valueOf(j2), str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), str2});
            return;
        }
        this.mRepository.retrieveEvaluates(j, j2, str, i, i2, i3, i4, z, str2, new d());
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.Presenter
    public void getProjectNATData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1164314669")) {
            ipChange.ipc$dispatch("1164314669", new Object[]{this, str});
            return;
        }
        this.mRepository.retrieveProjectNATData(str, new b());
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.Presenter
    public void getRecommendProjectList(String str, String str2, double d2, double d3, int i, int i2, String str3, boolean z, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-273248569")) {
            ipChange.ipc$dispatch("-273248569", new Object[]{this, str, str2, Double.valueOf(d2), Double.valueOf(d3), Integer.valueOf(i), Integer.valueOf(i2), str3, Boolean.valueOf(z), Integer.valueOf(i3)});
            return;
        }
        this.mRepository.retrieveRecommendProject(str, str2, d2, d3, i, i2, str3, z, i3, new c());
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.Presenter
    public void getSubProjectDetailCheckData(String str, String str2) {
        SkuSaveInfo skuSaveInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1833332351")) {
            ipChange.ipc$dispatch("-1833332351", new Object[]{this, str, str2});
            return;
        }
        try {
            skuSaveInfo = ub2.a(Long.parseLong(str));
        } catch (Exception unused) {
            skuSaveInfo = null;
        }
        SkuRequest skuRequest = new SkuRequest();
        skuRequest.itemId = str;
        if (skuSaveInfo != null) {
            SkuItem skuItem = skuRequest.exParams;
            skuItem.dataId = skuSaveInfo.dataId;
            skuItem.dataType = "2";
        } else {
            SkuItem skuItem2 = skuRequest.exParams;
            skuItem2.dataId = null;
            skuItem2.dataType = null;
        }
        if (!TextUtils.isEmpty(str2) && !"0".equals(str2)) {
            skuRequest.exParams.privilegeActId = str2;
        }
        xl2.c();
        skuRequest.request(new DMMtopResultRequestListener<SkuBean>(SkuBean.class) {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.presenter.ProjectItemPresenter.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1789075227")) {
                    ipChange.ipc$dispatch("-1789075227", new Object[]{this, str, str2});
                    return;
                }
                ProjectItemPresenter.this.mView.onReturnSkuBeanDataFail(str, str2);
            }

            public void onSuccess(SkuBean skuBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1597573351")) {
                    ipChange.ipc$dispatch("1597573351", new Object[]{this, skuBean});
                    return;
                }
                xl2.b();
                ProjectItemPresenter.this.mView.onReturnSkuBeanDataSuccess(skuBean);
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.Presenter
    public void updateProjectFollowRelation(int i, long j, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "120516020")) {
            ipChange.ipc$dispatch("120516020", new Object[]{this, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)});
            return;
        }
        this.mRepository.updateFollowRelation(i, j, i2, new f());
    }
}
