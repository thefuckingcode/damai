package cn.damai.tetris.component.discover.mvp;

import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
public interface NoteContract {

    /* compiled from: Taobao */
    public interface Model<D extends BaseNode> extends IModel {
        NoteBean getBean();
    }

    /* compiled from: Taobao */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
        void editClick(View view, NoteBean noteBean, int i);

        void itemClick(View view, NoteBean noteBean, int i);
    }

    /* compiled from: Taobao */
    public interface View<P extends Presenter> extends IView<P> {
        void setData(NoteBean noteBean, int i);
    }
}
