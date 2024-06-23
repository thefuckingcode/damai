package cn.damai.tetris.component.common;

import cn.damai.tetris.component.common.bean.ActorBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;
import java.util.List;

/* compiled from: Taobao */
public interface ActorAlbumContract {

    /* compiled from: Taobao */
    public interface Model<D extends BaseNode> extends IModel {
        List<ActorBean> getActors();
    }

    /* compiled from: Taobao */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
    }

    /* compiled from: Taobao */
    public interface View<P extends Presenter> extends IView<P> {
        void initAblum(List<ActorBean> list);
    }
}
