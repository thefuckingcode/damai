package cn.damai.tetris.component.brand;

import cn.damai.tetris.component.brand.BrandHeaderContract;
import cn.damai.tetris.component.brand.bean.ActivityInfo;
import cn.damai.tetris.component.brand.bean.BrandHeaderInfoBean;
import cn.damai.tetris.component.brand.bean.BrandHeaderRootBean;
import cn.damai.tetris.component.brand.bean.CommonCard;
import cn.damai.tetris.component.brand.bean.ProjectVideoBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class BrandHeaderModel extends AbsModel implements BrandHeaderContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    ActivityInfo activityDO;
    List<CommonCard> coupons;
    BrandHeaderInfoBean headerInfo;
    List<ProjectVideoBean> projectVideoBean;

    @Override // cn.damai.tetris.component.brand.BrandHeaderContract.Model
    public ActivityInfo getActivityDO() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1744629307")) {
            return this.activityDO;
        }
        return (ActivityInfo) ipChange.ipc$dispatch("-1744629307", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandHeaderContract.Model
    public List<CommonCard> getCoupons() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "792522911")) {
            return this.coupons;
        }
        return (List) ipChange.ipc$dispatch("792522911", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandHeaderContract.Model
    public BrandHeaderInfoBean getHeaderInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-874054333")) {
            return this.headerInfo;
        }
        return (BrandHeaderInfoBean) ipChange.ipc$dispatch("-874054333", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.brand.BrandHeaderContract.Model
    public List<ProjectVideoBean> getProjectVideoBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1449476804")) {
            return this.projectVideoBean;
        }
        return (List) ipChange.ipc$dispatch("1449476804", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-719038128")) {
            ipChange.ipc$dispatch("-719038128", new Object[]{this, baseNode});
            return;
        }
        try {
            BrandHeaderRootBean brandHeaderRootBean = (BrandHeaderRootBean) JSON.parseObject(baseNode.getItem().toJSONString(), BrandHeaderRootBean.class);
            this.headerInfo = brandHeaderRootBean.getAccountPageResult();
            List<ProjectVideoBean> projectVideoList = brandHeaderRootBean.getProjectVideoList();
            this.projectVideoBean = projectVideoList;
            if (projectVideoList != null && projectVideoList.size() > 3) {
                this.projectVideoBean = this.projectVideoBean.subList(0, 3);
            }
            this.activityDO = brandHeaderRootBean.getActivityDO();
            this.coupons = brandHeaderRootBean.getCoupons();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
