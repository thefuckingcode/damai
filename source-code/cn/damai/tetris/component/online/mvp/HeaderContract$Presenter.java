package cn.damai.tetris.component.online.mvp;

import cn.damai.tetris.component.online.mvp.HeaderContract$View;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IPresenter;

/* compiled from: Taobao */
interface HeaderContract$Presenter<M extends IModel, V extends HeaderContract$View, N extends BaseNode> extends IPresenter<M, V, N> {
    void btnClick(String str);
}
