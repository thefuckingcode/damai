package cn.damai.onearch.component.evaluate;

import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.evaluate.ui.item.EvaluateItemViewHolder;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface OneEvaluate {

    /* compiled from: Taobao */
    public interface Model {
        @NotNull
        CommentsItemBean getEvaluate();
    }

    /* compiled from: Taobao */
    public interface Present {
    }

    /* compiled from: Taobao */
    public interface View {
        @NotNull
        EvaluateItemViewHolder getEvaluateHolder();
    }
}
