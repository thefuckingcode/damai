package cn.damai.tetris.component.rank;

import cn.damai.tetris.component.rank.bean.RankFilterBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
public interface RankFilterContract {

    /* compiled from: Taobao */
    public interface Model<D extends BaseNode> extends IModel {
        RankFilterBean getData();
    }

    /* compiled from: Taobao */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
    }

    /* compiled from: Taobao */
    public interface View<P extends Presenter> extends IView<P> {
        void bindView(RankFilterBean rankFilterBean);
    }
}
