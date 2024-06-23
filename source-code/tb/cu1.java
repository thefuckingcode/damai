package tb;

import android.text.TextUtils;
import cn.damai.commonbusiness.search.Daojishi;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.tetris.component.drama.bean.CategoryItemBean;
import cn.damai.tetris.component.drama.bean.CategoryItemListBean;
import cn.damai.tetris.component.drama.bean.CategoryProjectItem;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.convertor.IConverter;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class cu1 implements IConverter<BaseResponse, BaseSection, GlobalConfig, List<Node>> {
    private static transient /* synthetic */ IpChange $ipChange;

    private List<CategoryProjectItem> b(List<CategoryItemBean> list) {
        CategoryProjectItem categoryProjectItem;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-555642947")) {
            return (List) ipChange.ipc$dispatch("-555642947", new Object[]{this, list});
        } else if (f92.d(list)) {
            return null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (CategoryItemBean categoryItemBean : list) {
                int i = categoryItemBean.type;
                if (i == 4) {
                    categoryProjectItem = new CategoryProjectItem();
                    categoryProjectItem.type = 4;
                    categoryProjectItem.isCurrentCity = true;
                    categoryProjectItem.projectItemBean = categoryItemBean.wirelessProjectDO;
                } else if (i == 5) {
                    categoryProjectItem = new CategoryProjectItem();
                    categoryProjectItem.type = 5;
                    categoryProjectItem.rankBean = categoryItemBean.rankingListVO;
                } else {
                    categoryProjectItem = null;
                }
                if (categoryProjectItem != null) {
                    arrayList.add(categoryProjectItem);
                }
            }
            return arrayList;
        }
    }

    private List<CategoryProjectItem> c(List<ProjectItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1649830311")) {
            return (List) ipChange.ipc$dispatch("-1649830311", new Object[]{this, list});
        } else if (f92.d(list)) {
            return null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (ProjectItemBean projectItemBean : list) {
                CategoryProjectItem categoryProjectItem = new CategoryProjectItem();
                categoryProjectItem.type = 4;
                categoryProjectItem.projectItemBean = projectItemBean;
                categoryProjectItem.isCurrentCity = false;
                arrayList.add(categoryProjectItem);
            }
            return arrayList;
        }
    }

    /* renamed from: a */
    public List<Node> convert(BaseResponse baseResponse, BaseSection baseSection, GlobalConfig globalConfig, qa qaVar) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-894225724")) {
            return (List) ipChange.ipc$dispatch("-894225724", new Object[]{this, baseResponse, baseSection, globalConfig, qaVar});
        }
        NodeData item = baseSection.getItem();
        boolean z2 = baseResponse.isShowJuli;
        ArrayList arrayList = new ArrayList();
        if (item != null) {
            int i = baseResponse.nearByCityListSize;
            CategoryItemListBean categoryItemListBean = (CategoryItemListBean) s41.d(item, CategoryItemListBean.class);
            int i2 = categoryItemListBean.total;
            List<CategoryItemBean> list = categoryItemListBean.currentCity;
            List<ProjectItemBean> list2 = categoryItemListBean.nearByCity;
            int e = xf2.e(list2);
            CategoryProjectItem categoryProjectItem = null;
            if (i <= 0 && e > 0) {
                categoryProjectItem = new CategoryProjectItem();
                categoryProjectItem.type = 1;
                if (i2 > 0) {
                    z = true;
                }
                categoryProjectItem.hasCurrentCity = z;
            }
            List<CategoryProjectItem> b = b(list);
            if (!f92.d(b)) {
                arrayList.addAll(b);
            }
            if (categoryProjectItem != null) {
                arrayList.add(categoryProjectItem);
            }
            List<CategoryProjectItem> c = c(list2);
            if (!f92.d(c)) {
                arrayList.addAll(c);
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", (Object) arrayList);
        Daojishi daojishi = new Daojishi();
        daojishi.setServiceTimeAndDiff(baseResponse.serverTime);
        jSONObject.put(qa.KEY_DAOJISHI, (Object) daojishi);
        jSONObject.put(qa.KEY_SHOW_DIS, Boolean.valueOf(z2));
        jSONObject.put("trackB", (globalConfig == null || TextUtils.isEmpty(globalConfig.pageName)) ? "drama" : globalConfig.pageName);
        jSONObject.put(qa.TRACKKEY_CITY, d20.d());
        baseSection.setItem(jSONObject);
        return new hg().convert(baseResponse, baseSection, globalConfig, qaVar);
    }
}
