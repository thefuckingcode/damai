package cn.damai.tetris.component.star;

import android.view.ViewGroup;
import cn.damai.tetris.component.star.bean.ItemModuleBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
public interface OfficalMallContract {

    /* compiled from: Taobao */
    public interface Model<D extends BaseNode> extends IModel {
        ItemModuleBean getData();
    }

    /* compiled from: Taobao */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
    }

    /* compiled from: Taobao */
    public interface View<P extends Presenter> extends IView<P> {
        ViewGroup getMallView();
    }
}
