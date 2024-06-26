package cn.damai.tetris.component.common;

import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
public interface CommonErrorContract {
    public static final String CID = "dm_view_commonerror";

    /* compiled from: Taobao */
    public interface Model<D extends BaseNode> extends IModel {
        String getCode();

        String getMsg();
    }

    /* compiled from: Taobao */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
    }

    /* compiled from: Taobao */
    public interface View<P extends Presenter> extends IView<P> {
    }
}
