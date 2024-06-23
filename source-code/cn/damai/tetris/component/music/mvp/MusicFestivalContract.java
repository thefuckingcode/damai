package cn.damai.tetris.component.music.mvp;

import cn.damai.musicfestival.bean.MusicFestivalRes;
import cn.damai.tetris.component.music.viewholder.MusicFestivalViewHolder;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
public interface MusicFestivalContract {

    /* compiled from: Taobao */
    public interface Model<D extends BaseNode> extends IModel {
        MusicFestivalRes getBean();
    }

    /* compiled from: Taobao */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N>, MusicFestivalViewHolder.OnUtEventListener {
    }

    /* compiled from: Taobao */
    public interface View<P extends Presenter> extends IView<P> {
        void setData(MusicFestivalRes musicFestivalRes);
    }
}
