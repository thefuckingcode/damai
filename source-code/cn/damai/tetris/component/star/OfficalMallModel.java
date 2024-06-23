package cn.damai.tetris.component.star;

import cn.damai.tetris.component.star.OfficalMallContract;
import cn.damai.tetris.component.star.bean.ItemModuleBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class OfficalMallModel extends AbsModel implements OfficalMallContract.Model<BaseNode> {
    private static transient /* synthetic */ IpChange $ipChange;
    ItemModuleBean itemModuleBean;

    @Override // cn.damai.tetris.component.star.OfficalMallContract.Model
    public ItemModuleBean getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1034645099")) {
            return this.itemModuleBean;
        }
        return (ItemModuleBean) ipChange.ipc$dispatch("1034645099", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        List<ItemModuleBean.GoodBean> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1648541985")) {
            ipChange.ipc$dispatch("1648541985", new Object[]{this, baseNode});
            return;
        }
        try {
            ItemModuleBean itemModuleBean2 = (ItemModuleBean) JSON.parseObject(baseNode.getItem().toJSONString(), ItemModuleBean.class);
            this.itemModuleBean = itemModuleBean2;
            if (itemModuleBean2 != null && (list = itemModuleBean2.goods) != null && list.size() > 6) {
                ItemModuleBean itemModuleBean3 = this.itemModuleBean;
                itemModuleBean3.goods = itemModuleBean3.goods.subList(0, 6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
