package cn.damai.tetris.component.girl.mvp;

import cn.damai.tetris.component.girl.bean.StepBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;

/* compiled from: Taobao */
interface ColumnContract$Model<D extends BaseNode> extends IModel {
    String getCityId();

    StepBean getStepBean();
}
