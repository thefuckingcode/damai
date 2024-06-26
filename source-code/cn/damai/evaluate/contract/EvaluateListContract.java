package cn.damai.evaluate.contract;

import cn.damai.comment.bean.CommentPerformInfoBean;
import cn.damai.comment.bean.CommentsResultBean;
import cn.damai.comment.bean.EvaluateParams;
import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.base.BaseDamaiView;
import java.util.List;
import tb.fk;

/* compiled from: Taobao */
public interface EvaluateListContract {

    /* compiled from: Taobao */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void create();

        public abstract void initExtras(EvaluateParams evaluateParams);

        public abstract void loadMoreData();

        public abstract void refresh(int i);

        public abstract void resume();

        public abstract void setContentLabelList(String str);
    }

    /* compiled from: Taobao */
    public interface View extends BaseDamaiView {
        void addDataAndRefresh(List<fk> list);

        void hideEmptyView();

        void refreshCommentStateScoreHeader(CommentsResultBean commentsResultBean, int i);

        void setCommentHeaderLabel(CommentsResultBean commentsResultBean);

        void showEntryView(CommentPerformInfoBean commentPerformInfoBean);

        void showTip(String str, String str2);

        void startRefreshing();

        void stopRefreshing();

        void updateData(List<fk> list);
    }
}
