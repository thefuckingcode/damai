package cn.damai.tetris.component.star.content.freetest;

import android.view.View;
import android.view.ViewGroup;
import cn.damai.tetris.component.star.content.freetest.ContentFreeTestContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ContentFreeTestView extends AbsView implements ContentFreeTestContract.View {
    private static transient /* synthetic */ IpChange $ipChange;

    public ContentFreeTestView(View view) {
        super(view);
    }

    @Override // cn.damai.tetris.component.star.content.freetest.ContentFreeTestContract.View
    public ViewGroup getGridView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2057552166")) {
            return (ViewGroup) getView();
        }
        return (ViewGroup) ipChange.ipc$dispatch("-2057552166", new Object[]{this});
    }
}
