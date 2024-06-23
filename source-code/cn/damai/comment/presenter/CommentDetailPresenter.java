package cn.damai.comment.presenter;

import android.text.TextUtils;
import cn.damai.comment.bean.CommentBaseBean;
import cn.damai.comment.bean.CommentGetRelationTargetBean;
import cn.damai.comment.bean.CommentsResultBean;
import cn.damai.comment.contract.CommentsDetailContract;
import cn.damai.comment.request.CommentDeleteRequest;
import cn.damai.comment.request.CommentGetRelationRequest;
import cn.damai.comment.request.CommentPublishRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.search.request.FollowRequest;
import cn.damai.evaluate.request.CommentListRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tb.p21;

/* compiled from: Taobao */
public class CommentDetailPresenter extends CommentsDetailContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.comment.contract.CommentsDetailContract.Presenter
    public void deleteComment(final Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1708153430")) {
            ipChange.ipc$dispatch("1708153430", new Object[]{this, map});
            return;
        }
        CommentDeleteRequest commentDeleteRequest = new CommentDeleteRequest();
        if (map.containsKey(p21.ISSUE_PARAM_COMMENT_ID)) {
            commentDeleteRequest.commentId = map.get(p21.ISSUE_PARAM_COMMENT_ID);
        }
        commentDeleteRequest.request(new DMMtopRequestListener<CommentBaseBean>(CommentBaseBean.class) {
            /* class cn.damai.comment.presenter.CommentDetailPresenter.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1486172428")) {
                    ipChange.ipc$dispatch("1486172428", new Object[]{this, str, str2});
                    return;
                }
                CommentDetailPresenter.this.mView.deleteCommentFailed(str, str2);
            }

            public void onSuccess(CommentBaseBean commentBaseBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "626304484")) {
                    ipChange.ipc$dispatch("626304484", new Object[]{this, commentBaseBean});
                    return;
                }
                CommentDetailPresenter.this.mView.deleteCommentSuccess(map, commentBaseBean);
            }
        });
    }

    @Override // cn.damai.comment.contract.CommentsDetailContract.Presenter
    public void getCommentDetailList(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "703175446")) {
            ipChange.ipc$dispatch("703175446", new Object[]{this, map});
            return;
        }
        CommentListRequest commentListRequest = new CommentListRequest();
        if (map.containsKey("targetType")) {
            commentListRequest.targetType = map.get("targetType");
        }
        if (map.containsKey(p21.ISSUE_PARAM_COMMENT_TYPE)) {
            commentListRequest.commentType = map.get(p21.ISSUE_PARAM_COMMENT_TYPE);
        }
        if (map.containsKey("mainCommentId")) {
            commentListRequest.mainCommentId = map.get("mainCommentId");
        }
        if (map.containsKey("isQueryAppend")) {
            commentListRequest.isQueryAppend = map.get("isQueryAppend");
        }
        if (map.containsKey("pageIndex")) {
            int parseInt = Integer.parseInt(map.get("pageIndex"));
            commentListRequest.pageIndex = String.valueOf(parseInt);
            if (parseInt == 1) {
                commentListRequest.isQueryMainComment = "true";
            } else {
                commentListRequest.isQueryMainComment = "false";
            }
        }
        if (map.containsKey("isQueryProjectInfo")) {
            commentListRequest.isQueryProjectInfo = map.get("isQueryProjectInfo");
        }
        if (map.containsKey("queryUploadFlag")) {
            commentListRequest.queryUploadFlag = map.get("queryUploadFlag");
        }
        commentListRequest.request(new DMMtopRequestListener<CommentsResultBean>(CommentsResultBean.class) {
            /* class cn.damai.comment.presenter.CommentDetailPresenter.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1493931787")) {
                    ipChange.ipc$dispatch("1493931787", new Object[]{this, str, str2});
                    return;
                }
                CommentDetailPresenter.this.mView.returnCommentDetailListError(str, str2);
            }

            public void onSuccess(CommentsResultBean commentsResultBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1151986508")) {
                    ipChange.ipc$dispatch("1151986508", new Object[]{this, commentsResultBean});
                    return;
                }
                CommentDetailPresenter.this.mView.returnCommentDetailList(commentsResultBean);
            }
        });
    }

    @Override // cn.damai.comment.contract.CommentsDetailContract.Presenter
    public void getRelationInfo(final String str, final String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1010981673")) {
            ipChange.ipc$dispatch("-1010981673", new Object[]{this, str, str2});
            return;
        }
        CommentGetRelationRequest commentGetRelationRequest = new CommentGetRelationRequest();
        commentGetRelationRequest.targetId = "[\"" + str + "\"]";
        commentGetRelationRequest.targetType = str2;
        commentGetRelationRequest.showLoginUI(false);
        commentGetRelationRequest.request(new DMMtopRequestListener<CommentGetRelationTargetBean>(CommentGetRelationTargetBean.class) {
            /* class cn.damai.comment.presenter.CommentDetailPresenter.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1470653710")) {
                    ipChange.ipc$dispatch("1470653710", new Object[]{this, str, str2});
                }
            }

            public void onSuccess(CommentGetRelationTargetBean commentGetRelationTargetBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1161382646")) {
                    ipChange.ipc$dispatch("1161382646", new Object[]{this, commentGetRelationTargetBean});
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(commentGetRelationTargetBean.getResult());
                    if (jSONObject.get(str) != null && !TextUtils.isEmpty(jSONObject.get(str).toString())) {
                        int intValue = Integer.valueOf(jSONObject.get(str).toString()).intValue();
                        if ("1".equals(str2)) {
                            CommentDetailPresenter.this.mView.relationUserUpdateSuccess(intValue);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // cn.damai.comment.contract.CommentsDetailContract.Presenter
    public void publishComment(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "195008078")) {
            ipChange.ipc$dispatch("195008078", new Object[]{this, map});
            return;
        }
        CommentPublishRequest commentPublishRequest = new CommentPublishRequest();
        if (map.containsKey("targetId")) {
            commentPublishRequest.targetId = map.get("targetId");
        }
        if (map.containsKey("targetType")) {
            commentPublishRequest.targetType = map.get("targetType");
        }
        if (map.containsKey(p21.ISSUE_PARAM_COMMENT_TYPE)) {
            commentPublishRequest.commentType = map.get(p21.ISSUE_PARAM_COMMENT_TYPE);
        }
        if (map.containsKey("text")) {
            commentPublishRequest.text = map.get("text");
        }
        if (map.containsKey("mainCommentId")) {
            commentPublishRequest.mainCommentId = map.get("mainCommentId");
        }
        commentPublishRequest.request(new DMMtopRequestListener<CommentBaseBean>(CommentBaseBean.class) {
            /* class cn.damai.comment.presenter.CommentDetailPresenter.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1478413069")) {
                    ipChange.ipc$dispatch("1478413069", new Object[]{this, str, str2});
                    return;
                }
                CommentDetailPresenter.this.mView.publishCommentFailed(str, str2);
            }

            public void onSuccess(CommentBaseBean commentBaseBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1319697189")) {
                    ipChange.ipc$dispatch("1319697189", new Object[]{this, commentBaseBean});
                    return;
                }
                CommentDetailPresenter.this.mView.publishCommentSuccess(commentBaseBean);
            }
        });
    }

    @Override // cn.damai.comment.contract.CommentsDetailContract.Presenter
    public void relationUpdate(Map<String, String> map, final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1154782803")) {
            ipChange.ipc$dispatch("-1154782803", new Object[]{this, map, str});
            return;
        }
        FollowRequest followRequest = new FollowRequest();
        if (map.containsKey("operateType")) {
            followRequest.operateType = map.get("operateType");
        }
        if (map.containsKey("targetId")) {
            followRequest.targetId = map.get("targetId");
        }
        if (map.containsKey("targetType")) {
            followRequest.targetType = map.get("targetType");
        }
        followRequest.request(new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) {
            /* class cn.damai.comment.presenter.CommentDetailPresenter.AnonymousClass5 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1462894351")) {
                    ipChange.ipc$dispatch("1462894351", new Object[]{this, str, str2});
                }
            }

            public void onSuccess(FollowDataBean followDataBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1103398031")) {
                    ipChange.ipc$dispatch("-1103398031", new Object[]{this, followDataBean});
                } else if ("1".equals(str)) {
                    CommentDetailPresenter.this.mView.relationUserUpdateSuccess(followDataBean.getStatus());
                }
            }
        });
    }
}
