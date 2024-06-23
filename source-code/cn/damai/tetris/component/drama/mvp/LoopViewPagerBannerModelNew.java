package cn.damai.tetris.component.drama.mvp;

import cn.damai.tetris.component.drama.bean.DynSizeBannerBean;
import cn.damai.tetris.component.drama.bean.XBannerBean;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.NodeData;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class LoopViewPagerBannerModelNew extends LoopViewPagerBannerModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<XBannerBean> xBannerBeans;

    @Override // cn.damai.tetris.component.drama.mvp.LoopViewPagerBannerContract.Model, cn.damai.tetris.component.drama.mvp.LoopViewPagerBannerModel
    public List<XBannerBean> getBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1409236672")) {
            return this.xBannerBeans;
        }
        return (List) ipChange.ipc$dispatch("1409236672", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel, cn.damai.tetris.component.drama.mvp.LoopViewPagerBannerModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "37435666")) {
            ipChange.ipc$dispatch("37435666", new Object[]{this, baseNode});
            return;
        }
        NodeData item = baseNode.getItem();
        if (item.get("result") != null) {
            List<DynSizeBannerBean> parseArray = JSON.parseArray(item.getString("result"), DynSizeBannerBean.class);
            this.xBannerBeans = new ArrayList();
            for (DynSizeBannerBean dynSizeBannerBean : parseArray) {
                XBannerBean xBannerBean = new XBannerBean();
                xBannerBean.cover = dynSizeBannerBean.pic;
                xBannerBean.jumpUrl = dynSizeBannerBean.url;
                try {
                    xBannerBean.width = Integer.parseInt(getStyleValue("width"));
                    xBannerBean.height = Integer.parseInt(getStyleValue("height"));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                this.xBannerBeans.add(xBannerBean);
            }
        }
    }
}
