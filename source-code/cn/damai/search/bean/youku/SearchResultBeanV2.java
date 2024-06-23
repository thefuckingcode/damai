package cn.damai.search.bean.youku;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.bean.SearchResultBean;
import cn.damai.tetris.component.discover.bean.NoteBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.f92;
import tb.xf2;

/* compiled from: Taobao */
public class SearchResultBeanV2 extends SearchResultBean {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<? extends ArtificialProxy> artificialImageTextList;
    public List<? extends ArtificialProxy> artificialThemeList;
    public List<NoteBean> contentNoteList;
    public boolean isEnd;
    public boolean isImageTextEnd;
    public List<ProjectItemBean> recommendProjectList;

    public boolean isShowCombineHeadItemView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1644261655")) {
            return !f92.d(this.baccountInfo) || this.tour != null || xf2.e(this.brandOptimization) >= 3 || xf2.e(this.artificialThemeList) + xf2.e(this.artificialImageTextList) > 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("1644261655", new Object[]{this})).booleanValue();
    }
}
