package cn.damai.search.v2.fragment;

import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import cn.damai.search.bean.SearchResultTabEnum;
import cn.damai.search.v2.bean.InputInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SearchBrandIdFragment extends SearchBaseFragment {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment, cn.damai.search.v2.listener.SearchInputObserver
    public void dispatchInputWord(InputInfo inputInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-927337920")) {
            ipChange.ipc$dispatch("-927337920", new Object[]{this, inputInfo});
        } else if (inputInfo != null) {
            this.noMoreNodeData.put("content", (Object) ("\"" + inputInfo.inputText + "\"相关厂牌只有这么多啦"));
            super.dispatchInputWord(inputInfo);
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    public String getEmptyPageDesSuffix() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1582970462")) {
            return ErrControlViewInfo.TYPE_BRAND_IP;
        }
        return (String) ipChange.ipc$dispatch("-1582970462", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    public int getRequestPageSize() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1788323225")) {
            return 15;
        }
        return ((Integer) ipChange.ipc$dispatch("1788323225", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    public String getRequestPatternName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-485085849")) {
            return "searchBrandIP";
        }
        return (String) ipChange.ipc$dispatch("-485085849", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    public String getRequestPatternVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1387751538")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("1387751538", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.component.ipbrand.ITab
    public String getTabTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1962936190")) {
            return SearchResultTabEnum.BRAND.content;
        }
        return (String) ipChange.ipc$dispatch("1962936190", new Object[]{this});
    }
}
