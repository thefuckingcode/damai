package cn.damai.tetris.component.live.mvp;

import cn.damai.tetris.component.live.bean.LiveHeaderPicBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;

/* compiled from: Taobao */
interface HeaderContract$Model<D extends BaseNode> extends IModel {
    LiveHeaderPicBean getHeaderBean();
}
