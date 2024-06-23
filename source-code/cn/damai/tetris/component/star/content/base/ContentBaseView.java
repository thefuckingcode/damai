package cn.damai.tetris.component.star.content.base;

import android.view.View;
import android.view.ViewGroup;
import cn.damai.tetris.component.star.content.base.ContentBaseContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ContentBaseView extends AbsView implements ContentBaseContract.View {
    private static transient /* synthetic */ IpChange $ipChange;

    public ContentBaseView(View view) {
        super(view);
    }

    @Override // cn.damai.tetris.component.star.content.base.ContentBaseContract.View
    public ViewGroup getProjectsView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-989041004")) {
            return (ViewGroup) getView();
        }
        return (ViewGroup) ipChange.ipc$dispatch("-989041004", new Object[]{this});
    }
}
