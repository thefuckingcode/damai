package cn.damai.tetris.component.drama.mvp;

import cn.damai.tetris.component.drama.bean.DramaList;
import cn.damai.tetris.component.drama.bean.DramaV2Bean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
public interface DramaWorthSeeContract {

    /* compiled from: Taobao */
    public interface Model<D extends BaseNode> extends IModel {
        DramaList getBean();
    }

    /* compiled from: Taobao */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
        void expose(android.view.View view, DramaV2Bean dramaV2Bean, int i);

        void itemAllClick(View view, String str, int i);

        void itemClick(View view, DramaV2Bean dramaV2Bean, int i);
    }

    /* compiled from: Taobao */
    public interface View<P extends Presenter> extends IView<P> {
        void setData(DramaList dramaList, int i);
    }
}
