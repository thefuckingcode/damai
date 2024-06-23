package cn.damai.tetris.component.project;

import cn.damai.commonbusiness.search.Daojishi;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;
import cn.damai.tetris.core.IView;

/* compiled from: Taobao */
public interface ProjectContract {

    /* compiled from: Taobao */
    public interface Model<D extends BaseNode> extends IModel {
        boolean ShowDis();

        ProjectItemBean getBean();

        Daojishi getDaojishi();

        int getIndex();
    }

    /* compiled from: Taobao */
    public interface Presenter<M extends IModel, V extends View, N extends BaseNode> extends IPresenter<M, V, N> {
    }

    /* compiled from: Taobao */
    public interface View<P extends Presenter> extends IView<P> {
        ProjectItemViewHolder getHolder();
    }
}
