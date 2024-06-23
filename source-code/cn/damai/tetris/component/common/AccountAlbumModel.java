package cn.damai.tetris.component.common;

import cn.damai.tetris.component.common.AccountAlbumContract;
import cn.damai.tetris.component.common.bean.AccountBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class AccountAlbumModel extends AbsModel implements AccountAlbumContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    List<AccountBean> actorList;

    /* compiled from: Taobao */
    static class ResultBean implements Serializable {
        public List<AccountBean> brandBridges;

        ResultBean() {
        }
    }

    @Override // cn.damai.tetris.component.common.AccountAlbumContract.Model
    public List<AccountBean> getAccounts() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-907552706")) {
            return this.actorList;
        }
        return (List) ipChange.ipc$dispatch("-907552706", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1433764278")) {
            ipChange.ipc$dispatch("-1433764278", new Object[]{this, baseNode});
            return;
        }
        try {
            ResultBean resultBean = (ResultBean) JSON.parseObject(baseNode.getItem().toJSONString(), ResultBean.class);
            if (resultBean != null) {
                this.actorList = resultBean.brandBridges;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
