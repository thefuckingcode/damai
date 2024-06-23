package cn.damai.user.repertoite.contract;

import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.BaseView;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.model.UserAttentionBean;
import cn.damai.user.repertoite.bean.RepertoireDetailDataBean;
import cn.damai.user.repertoite.bean.comment.RepertoireDetailCommentBean;

/* compiled from: Taobao */
public interface RepertoireDetailContract {

    /* compiled from: Taobao */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    public static abstract class Presenter extends a<View, Model> {
    }

    /* compiled from: Taobao */
    public interface View extends BaseView {
        void onPraiseViewOnClick(CommentsItemBean commentsItemBean);

        void onSelfPublishCommentSuccess();

        void relationUpdateFail(String str, String str2);

        void relationUpdateSuccess(UserAttentionBean.DataBean dataBean);

        void repertoireDetailFail(String str, String str2);

        void repertoireDetailSuccess(RepertoireDetailDataBean repertoireDetailDataBean);

        void returnCommentsList(RepertoireDetailCommentBean repertoireDetailCommentBean);

        void returnCommentsListError(String str, String str2);
    }
}
