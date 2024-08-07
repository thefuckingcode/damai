package cn.damai.tetris.component.star.content.feed;

import android.view.ViewGroup;
import cn.damai.tetris.component.star.content.feed.bean.ContentFeedBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;
import java.util.List;

/* compiled from: Taobao */
public interface ContentFeedContract {

    /* compiled from: Taobao */
    public interface Model<D extends BaseNode> extends IModel {
        List<ContentFeedBean> getData();
    }

    /* compiled from: Taobao */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
    }

    /* compiled from: Taobao */
    public interface View<P extends Presenter> extends IView<P> {
        ViewGroup getGridView();
    }
}
