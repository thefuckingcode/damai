package cn.damai.tetris.component.online.mvp;

import cn.damai.tetris.component.online.bean.ArtistBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;

/* compiled from: Taobao */
interface HeaderContract$Model<D extends BaseNode> extends IModel {
    ArtistBean getTopBean();
}
