package cn.damai.tetris.component.category;

import cn.damai.commonbusiness.rank.CommonRankHolder;
import cn.damai.commonbusiness.rank.RankItemBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
public interface RankListContract {

    /* compiled from: Taobao */
    public interface Model<D extends BaseNode> extends IModel {
        RankItemBean getBean();

        int getIndex();
    }

    /* compiled from: Taobao */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
    }

    /* compiled from: Taobao */
    public interface View<P extends Presenter> extends IView<P> {
        CommonRankHolder getHolder();
    }
}