package cn.damai.tetris.component.discover.mvp;

import cn.damai.commonbusiness.discover.bean.VoteInfoBean;
import cn.damai.commonbusiness.discover.viewholder.VotePanel;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
public interface VoteContract {

    /* compiled from: Taobao */
    public interface Model<D extends BaseNode> extends IModel {
        VoteInfoBean getBean();
    }

    /* compiled from: Taobao */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N>, VotePanel.VoteUtListener {
        void itemClick(VoteInfoBean voteInfoBean, int i);
    }

    /* compiled from: Taobao */
    public interface View<P extends Presenter> extends IView<P> {
        void setData(VoteInfoBean voteInfoBean, int i);
    }
}
