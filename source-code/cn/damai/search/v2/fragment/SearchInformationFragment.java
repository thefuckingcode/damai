package cn.damai.search.v2.fragment;

import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import cn.damai.search.bean.SearchResultTabEnum;
import cn.damai.search.v2.bean.InputInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SearchInformationFragment extends SearchBaseFragment {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment, cn.damai.search.v2.listener.SearchInputObserver
    public void dispatchInputWord(InputInfo inputInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1358048234")) {
            ipChange.ipc$dispatch("1358048234", new Object[]{this, inputInfo});
        } else if (inputInfo != null) {
            this.noMoreNodeData.put("content", (Object) ("\"" + inputInfo.inputText + "\"相关资讯只有这么多啦"));
            super.dispatchInputWord(inputInfo);
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    public String getEmptyPageDesSuffix() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1001532212")) {
            return ErrControlViewInfo.TYPE_FEED;
        }
        return (String) ipChange.ipc$dispatch("-1001532212", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    public int getRequestPageSize() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1722902979")) {
            return 15;
        }
        return ((Integer) ipChange.ipc$dispatch("1722902979", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    public String getRequestPatternName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "96352401")) {
            return "searchInformation";
        }
        return (String) ipChange.ipc$dispatch("96352401", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    public String getRequestPatternVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1411552520")) {
            return "2.0";
        }
        return (String) ipChange.ipc$dispatch("1411552520", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.component.ipbrand.ITab
    public String getTabTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1815748392")) {
            return SearchResultTabEnum.INFORMATION.content;
        }
        return (String) ipChange.ipc$dispatch("1815748392", new Object[]{this});
    }
}
