package cn.damai.trade.newtradeorder.ui.projectdetail.common.repository;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.search.request.FollowRequest;
import cn.damai.trade.newtradeorder.ui.projectdetail.bean.ProjectDetailCommentBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.ProjectRecommendResultBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.request.DiscussionRequest;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.request.EvaluatesRequest;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.request.RecommendRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.yz1;

/* compiled from: Taobao */
public class ProjectCommonRepository implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;

    public void retrieveDiscussions(long j, long j2, String str, int i, int i2, int i3, final yz1 yz1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1242240253")) {
            ipChange.ipc$dispatch("1242240253", new Object[]{this, Long.valueOf(j), Long.valueOf(j2), str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), yz1});
            return;
        }
        DiscussionRequest discussionRequest = new DiscussionRequest();
        discussionRequest.itemId = j;
        discussionRequest.categoryId = j2;
        discussionRequest.ipId = str;
        discussionRequest.moduleType = i;
        discussionRequest.pageIndex = i2;
        discussionRequest.pageSize = i3;
        discussionRequest.request(new DMMtopRequestListener<ProjectDetailCommentBean>(ProjectDetailCommentBean.class) {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.common.repository.ProjectCommonRepository.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "955174300")) {
                    ipChange.ipc$dispatch("955174300", new Object[]{this, str, str2});
                    return;
                }
                yz1 yz1 = yz1;
                if (yz1 != null) {
                    yz1.a(str, str2);
                }
            }

            public void onSuccess(ProjectDetailCommentBean projectDetailCommentBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "506312113")) {
                    ipChange.ipc$dispatch("506312113", new Object[]{this, projectDetailCommentBean});
                    return;
                }
                yz1 yz1 = yz1;
                if (yz1 != null) {
                    yz1.b(projectDetailCommentBean);
                }
            }
        });
    }

    public void retrieveEvaluates(long j, long j2, String str, int i, int i2, int i3, int i4, boolean z, String str2, final yz1 yz1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "965106855")) {
            ipChange.ipc$dispatch("965106855", new Object[]{this, Long.valueOf(j), Long.valueOf(j2), str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), str2, yz1});
            return;
        }
        EvaluatesRequest evaluatesRequest = new EvaluatesRequest();
        evaluatesRequest.itemId = j;
        evaluatesRequest.categoryId = j2;
        evaluatesRequest.ipId = str;
        evaluatesRequest.moduleType = i;
        evaluatesRequest.commentType = i2;
        evaluatesRequest.pageIndex = i3;
        evaluatesRequest.pageSize = i4;
        evaluatesRequest.isQueryHotComment = z;
        evaluatesRequest.tourId = str2;
        evaluatesRequest.request(new DMMtopRequestListener<ProjectDetailCommentBean>(ProjectDetailCommentBean.class) {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.common.repository.ProjectCommonRepository.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "962933659")) {
                    ipChange.ipc$dispatch("962933659", new Object[]{this, str, str2});
                    return;
                }
                yz1 yz1 = yz1;
                if (yz1 != null) {
                    yz1.a(str, str2);
                }
            }

            public void onSuccess(ProjectDetailCommentBean projectDetailCommentBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "948066608")) {
                    ipChange.ipc$dispatch("948066608", new Object[]{this, projectDetailCommentBean});
                    return;
                }
                yz1 yz1 = yz1;
                if (yz1 != null) {
                    yz1.b(projectDetailCommentBean);
                }
            }
        });
    }

    public void retrieveRecommendProject(String str, String str2, double d, double d2, int i, int i2, String str3, boolean z, int i3, final yz1 yz1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-428281549")) {
            ipChange.ipc$dispatch("-428281549", new Object[]{this, str, str2, Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), Integer.valueOf(i2), str3, Boolean.valueOf(z), Integer.valueOf(i3), yz1});
            return;
        }
        RecommendRequest recommendRequest = new RecommendRequest();
        recommendRequest.userId = str;
        recommendRequest.cityId = str2;
        recommendRequest.longitude = d;
        recommendRequest.latitude = d2;
        recommendRequest.pageIndex = i;
        recommendRequest.pageSize = i2;
        recommendRequest.projectIdList = str3;
        recommendRequest.returnDefault = z;
        recommendRequest.type = i3;
        recommendRequest.request(new DMMtopRequestListener<ProjectRecommendResultBean.ProjectRecommendDataBean>(ProjectRecommendResultBean.ProjectRecommendDataBean.class) {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.common.repository.ProjectCommonRepository.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "970693018")) {
                    ipChange.ipc$dispatch("970693018", new Object[]{this, str, str2});
                    return;
                }
                yz1 yz1 = yz1;
                if (yz1 != null) {
                    yz1.a(str, str2);
                }
            }

            public void onSuccess(ProjectRecommendResultBean.ProjectRecommendDataBean projectRecommendDataBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1020246243")) {
                    ipChange.ipc$dispatch("-1020246243", new Object[]{this, projectRecommendDataBean});
                    return;
                }
                yz1 yz1 = yz1;
                if (yz1 != null) {
                    yz1.b(projectRecommendDataBean);
                }
            }
        });
    }

    public void updateFollowRelation(int i, long j, int i2, final yz1 yz1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-263817811")) {
            ipChange.ipc$dispatch("-263817811", new Object[]{this, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), yz1});
            return;
        }
        FollowRequest followRequest = new FollowRequest();
        followRequest.operateType = String.valueOf(i);
        followRequest.targetId = String.valueOf(j);
        followRequest.targetType = String.valueOf(i2);
        followRequest.request(new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.common.repository.ProjectCommonRepository.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "978452377")) {
                    ipChange.ipc$dispatch("978452377", new Object[]{this, str, str2});
                    return;
                }
                yz1 yz1 = yz1;
                if (yz1 != null) {
                    yz1.a(str, str2);
                }
            }

            public void onSuccess(FollowDataBean followDataBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1537668441")) {
                    ipChange.ipc$dispatch("-1537668441", new Object[]{this, followDataBean});
                    return;
                }
                yz1 yz1 = yz1;
                if (yz1 != null) {
                    yz1.b(followDataBean);
                }
            }
        });
    }
}
