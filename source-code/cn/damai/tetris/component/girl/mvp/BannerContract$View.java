package cn.damai.tetris.component.girl.mvp;

import cn.damai.tetris.component.girl.bean.BannerBean;
import cn.damai.tetris.component.girl.mvp.BannerContract$Presenter;
import cn.damai.tetris.core.IView;
import java.util.List;

/* compiled from: Taobao */
interface BannerContract$View<P extends BannerContract$Presenter> extends IView<P> {
    void setAdapter();

    void setData(List<BannerBean> list, String str);
}
