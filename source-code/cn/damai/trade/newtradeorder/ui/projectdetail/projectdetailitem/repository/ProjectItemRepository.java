package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.repository;

import android.text.TextUtils;
import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.repository.ProjectCommonRepository;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDetailComponentResultBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDetailDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDetailItemResultDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectInformationBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectRecommendListBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.request.ProjectItemDetailRequest;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.request.ProjectItemRecommendRequest;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.request.ProjectNATRequest;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.oz0;
import tb.xl2;
import tb.yz1;

/* compiled from: Taobao */
public class ProjectItemRepository extends ProjectCommonRepository {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onFailCallback(yz1 yz1, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-655515703")) {
            ipChange.ipc$dispatch("-655515703", new Object[]{this, yz1, str, str2});
        } else if (yz1 != null) {
            yz1.a(str, str2);
        }
    }

    public void retrieveProjectItemData(String str, final yz1 yz1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-755659113")) {
            ipChange.ipc$dispatch("-755659113", new Object[]{this, str, yz1});
            return;
        }
        ProjectItemDetailRequest projectItemDetailRequest = new ProjectItemDetailRequest();
        projectItemDetailRequest.itemId = str;
        AnonymousClass1 r5 = new DMMtopRequestListener<ProjectDetailItemResultDataBean>(ProjectDetailItemResultDataBean.class) {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.repository.ProjectItemRepository.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "47748689")) {
                    ipChange.ipc$dispatch("47748689", new Object[]{this, str, str2});
                    return;
                }
                ProjectItemRepository.this.onFailCallback(yz1, str, str2);
            }

            public void onSuccess(ProjectDetailItemResultDataBean projectDetailItemResultDataBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "453969983")) {
                    ipChange.ipc$dispatch("453969983", new Object[]{this, projectDetailItemResultDataBean});
                    return;
                }
                xl2.b();
                if (projectDetailItemResultDataBean != null) {
                    String errorMsg = projectDetailItemResultDataBean.getErrorMsg();
                    String result = projectDetailItemResultDataBean.getResult();
                    if (!TextUtils.isEmpty(errorMsg)) {
                        yz1 yz1 = yz1;
                        if (yz1 != null) {
                            yz1.a("9994", errorMsg);
                        }
                    } else if (!TextUtils.isEmpty(result)) {
                        ProjectDetailDataBean projectDetailDataBean = null;
                        try {
                            ProjectDetailComponentResultBean projectDetailComponentResultBean = (ProjectDetailComponentResultBean) JSON.parseObject(projectDetailItemResultDataBean.getResult(), ProjectDetailComponentResultBean.class);
                            if (!(projectDetailComponentResultBean == null || projectDetailComponentResultBean.getDetailViewComponentMap() == null)) {
                                projectDetailDataBean = projectDetailComponentResultBean.getDetailViewComponentMap().getItem();
                            }
                        } catch (Exception e) {
                            if (AppConfig.v()) {
                                e.printStackTrace();
                            }
                        }
                        if (projectDetailDataBean != null) {
                            yz1 yz12 = yz1;
                            if (yz12 != null) {
                                yz12.b(projectDetailDataBean);
                                return;
                            }
                            return;
                        }
                        ProjectItemRepository.this.onFailCallback(yz1, oz0.FAIL_SYS_TRAFFIC_LIMIT, "麦麦开小差了，请稍后重试哦");
                    } else {
                        ProjectItemRepository.this.onFailCallback(yz1, oz0.FAIL_SYS_TRAFFIC_LIMIT, "麦麦开小差了，请稍后重试哦");
                    }
                } else {
                    ProjectItemRepository.this.onFailCallback(yz1, oz0.FAIL_SYS_TRAFFIC_LIMIT, "麦麦开小差了，请稍后重试哦");
                }
            }
        };
        xl2.c();
        projectItemDetailRequest.request(r5);
    }

    public void retrieveProjectNATData(String str, final yz1 yz1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1224112813")) {
            ipChange.ipc$dispatch("-1224112813", new Object[]{this, str, yz1});
            return;
        }
        ProjectNATRequest projectNATRequest = new ProjectNATRequest();
        projectNATRequest.itemId = str;
        projectNATRequest.request(new DMMtopRequestListener<ProjectInformationBean>(ProjectInformationBean.class) {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.repository.ProjectItemRepository.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "39989330")) {
                    ipChange.ipc$dispatch("39989330", new Object[]{this, str, str2});
                    return;
                }
                yz1 yz1 = yz1;
                if (yz1 != null) {
                    yz1.a(str, str2);
                }
            }

            public void onSuccess(ProjectInformationBean projectInformationBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1958170789")) {
                    ipChange.ipc$dispatch("-1958170789", new Object[]{this, projectInformationBean});
                    return;
                }
                yz1 yz1 = yz1;
                if (yz1 != null) {
                    yz1.b(projectInformationBean);
                }
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.common.repository.ProjectCommonRepository
    public void retrieveRecommendProject(String str, String str2, double d, double d2, int i, int i2, String str3, boolean z, int i3, final yz1 yz1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1549523989")) {
            ipChange.ipc$dispatch("-1549523989", new Object[]{this, str, str2, Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), Integer.valueOf(i2), str3, Boolean.valueOf(z), Integer.valueOf(i3), yz1});
            return;
        }
        ProjectItemRecommendRequest projectItemRecommendRequest = new ProjectItemRecommendRequest();
        projectItemRecommendRequest.cityId = str2;
        projectItemRecommendRequest.longitude = d;
        projectItemRecommendRequest.latitude = d2;
        projectItemRecommendRequest.pageIndex = i;
        projectItemRecommendRequest.pageSize = i2;
        projectItemRecommendRequest.projectIdList = str3;
        projectItemRecommendRequest.returnDefault = z;
        projectItemRecommendRequest.type = i3;
        projectItemRecommendRequest.request(new DMMtopRequestListener<ProjectRecommendListBean>(ProjectRecommendListBean.class) {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.repository.ProjectItemRepository.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "32229971")) {
                    ipChange.ipc$dispatch("32229971", new Object[]{this, str, str2});
                    return;
                }
                yz1 yz1 = yz1;
                if (yz1 != null) {
                    yz1.a(str, str2);
                }
            }

            public void onSuccess(ProjectRecommendListBean projectRecommendListBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1973178418")) {
                    ipChange.ipc$dispatch("-1973178418", new Object[]{this, projectRecommendListBean});
                    return;
                }
                yz1 yz1 = yz1;
                if (yz1 != null) {
                    yz1.b(projectRecommendListBean);
                }
            }
        });
    }
}
