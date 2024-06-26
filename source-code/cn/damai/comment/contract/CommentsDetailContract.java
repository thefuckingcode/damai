package cn.damai.comment.contract;

import cn.damai.comment.bean.CommentBaseBean;
import cn.damai.comment.bean.CommentsResultBean;
import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.base.BaseDamaiView;
import java.util.Map;

/* compiled from: Taobao */
public interface CommentsDetailContract {

    /* compiled from: Taobao */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void deleteComment(Map<String, String> map);

        public abstract void getCommentDetailList(Map<String, String> map);

        public abstract void getRelationInfo(String str, String str2);

        public abstract void publishComment(Map<String, String> map);

        public abstract void relationUpdate(Map<String, String> map, String str);
    }

    /* compiled from: Taobao */
    public interface View extends BaseDamaiView {
        void deleteCommentFailed(String str, String str2);

        void deleteCommentSuccess(Map<String, String> map, CommentBaseBean commentBaseBean);

        void publishCommentFailed(String str, String str2);

        void publishCommentSuccess(CommentBaseBean commentBaseBean);

        void relationUserUpdateSuccess(int i);

        void returnCommentDetailList(CommentsResultBean commentsResultBean);

        void returnCommentDetailListError(String str, String str2);
    }
}
