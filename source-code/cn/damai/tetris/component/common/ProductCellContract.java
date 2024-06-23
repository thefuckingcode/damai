package cn.damai.tetris.component.common;

import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
public interface ProductCellContract {

    /* compiled from: Taobao */
    public interface Model<D extends BaseNode> extends IModel {
        String getBgImg();

        String getId();

        String getName();

        String getPriceLow();

        String getSchema();
    }

    /* compiled from: Taobao */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
    }

    /* compiled from: Taobao */
    public interface View<P extends Presenter> extends IView<P> {
        ImageView getImg();

        TextView getPrice();

        TextView getTitle();
    }
}
