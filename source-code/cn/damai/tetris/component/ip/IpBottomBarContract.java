package cn.damai.tetris.component.ip;

import android.widget.TextView;
import cn.damai.tetris.component.ip.bean.IpBottomBarBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
public interface IpBottomBarContract {

    /* compiled from: Taobao */
    public interface Model<D extends BaseNode> extends IModel {
        IpBottomBarBean getBottomBarBean();
    }

    /* compiled from: Taobao */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
    }

    /* compiled from: Taobao */
    public interface View<P extends Presenter> extends IView<P> {
        TextView getBuyView();

        TextView getDescView();
    }
}
