package cn.damai.tetris.component.music.mvp;

import cn.damai.musicfestival.bean.FeedInfo;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
public interface DiscoverFeedPluginContract {

    /* compiled from: Taobao */
    public interface Model<D extends BaseNode> extends IModel {
        FeedInfo getBean();
    }

    /* compiled from: Taobao */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
    }

    /* compiled from: Taobao */
    public interface View<P extends Presenter> extends IView<P> {
        void setData(FeedInfo feedInfo);
    }
}
