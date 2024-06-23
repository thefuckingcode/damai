package cn.damai.tetris.component.girl.mvp;

import cn.damai.tetris.component.girl.bean.BannerBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.IModel;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public interface BannerContract$Model<D extends BaseNode> extends IModel {
    List<BannerBean> getBannerList();

    String getTitle();
}
