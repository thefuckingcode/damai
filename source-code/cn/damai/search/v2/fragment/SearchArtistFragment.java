package cn.damai.search.v2.fragment;

import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import cn.damai.search.bean.SearchResultTabEnum;
import cn.damai.search.v2.bean.InputInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SearchArtistFragment extends SearchBaseFragment {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.search.v2.fragment.SearchBaseFragment, cn.damai.search.v2.listener.SearchInputObserver
    public void dispatchInputWord(InputInfo inputInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2045230429")) {
            ipChange.ipc$dispatch("2045230429", new Object[]{this, inputInfo});
        } else if (inputInfo != null) {
            this.noMoreNodeData.put("content", (Object) ("\"" + inputInfo.inputText + "\"相关艺人只有这么多啦"));
            super.dispatchInputWord(inputInfo);
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    public String getEmptyPageDesSuffix() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-173368449")) {
            return ErrControlViewInfo.TYPE_ARTIST;
        }
        return (String) ipChange.ipc$dispatch("-173368449", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    public int getRequestPageSize() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-609204234")) {
            return 15;
        }
        return ((Integer) ipChange.ipc$dispatch("-609204234", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    public String getRequestPatternName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "924516164")) {
            return "searchArtist";
        }
        return (String) ipChange.ipc$dispatch("924516164", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.search.v2.fragment.SearchBaseFragment
    public String getRequestPatternVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1348899467")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-1348899467", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.component.ipbrand.ITab
    public String getTabTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "944445851")) {
            return SearchResultTabEnum.ARTIST.content;
        }
        return (String) ipChange.ipc$dispatch("944445851", new Object[]{this});
    }
}
