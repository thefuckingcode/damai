package com.alibaba.pictures.bricks.selector;

import android.view.ViewGroup;
import com.alibaba.pictures.bricks.selector.bean.ScriptSelectMo;
import com.alibaba.pictures.bricks.selector.bean.ScriptSelectResponse;
import com.alibaba.pictures.bricks.selector.request.ScriptSelectRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class ScriptSelectFragment$requestSearch$1 extends Lambda implements Function1<ScriptSelectResponse, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ boolean $isNewSearch;
    final /* synthetic */ ScriptSelectRequest $request;
    final /* synthetic */ ScriptSelectFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScriptSelectFragment$requestSearch$1(boolean z, ScriptSelectFragment scriptSelectFragment, ScriptSelectRequest scriptSelectRequest) {
        super(1);
        this.$isNewSearch = z;
        this.this$0 = scriptSelectFragment;
        this.$request = scriptSelectRequest;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(ScriptSelectResponse scriptSelectResponse) {
        invoke(scriptSelectResponse);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull ScriptSelectResponse scriptSelectResponse) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-483564228")) {
            ipChange.ipc$dispatch("-483564228", new Object[]{this, scriptSelectResponse});
            return;
        }
        k21.i(scriptSelectResponse, "response");
        SmartRefreshLayout smartRefreshLayout = null;
        if (this.$isNewSearch) {
            ViewGroup viewGroup = this.this$0.errorContainer;
            if (viewGroup == null) {
                k21.A("errorContainer");
                viewGroup = null;
            }
            viewGroup.setVisibility(8);
            ScriptSelectFragment scriptSelectFragment = this.this$0;
            ViewGroup viewGroup2 = scriptSelectFragment.errorContainer;
            if (viewGroup2 == null) {
                k21.A("errorContainer");
                viewGroup2 = null;
            }
            scriptSelectFragment.removeErrorView(viewGroup2);
            SmartRefreshLayout smartRefreshLayout2 = this.this$0.refreshLayout;
            if (smartRefreshLayout2 == null) {
                k21.A("refreshLayout");
                smartRefreshLayout2 = null;
            }
            smartRefreshLayout2.finishRefresh();
            ArrayList<ScriptSelectMo> arrayList = new ArrayList<>();
            this.this$0.getAdapter().f(this.$request.getKeyword());
            ScriptSelectMo selected = scriptSelectResponse.getSelected();
            if (selected != null) {
                this.this$0.getAdapter().g(selected.getTargetId());
                arrayList.add(selected);
            }
            ArrayList<ScriptSelectMo> searchResultList = scriptSelectResponse.getSearchResultList();
            if (searchResultList != null) {
                arrayList.addAll(searchResultList);
            }
            this.this$0.getAdapter().e(arrayList);
            if (arrayList.isEmpty()) {
                ScriptSelectFragment scriptSelectFragment2 = this.this$0;
                String keyword = this.$request.getKeyword();
                scriptSelectFragment2.showEmpty(true ^ (keyword == null || (o.y(keyword))));
            }
        } else {
            this.this$0.getAdapter().b(scriptSelectResponse.getSearchResultList());
            SmartRefreshLayout smartRefreshLayout3 = this.this$0.refreshLayout;
            if (smartRefreshLayout3 == null) {
                k21.A("refreshLayout");
                smartRefreshLayout3 = null;
            }
            smartRefreshLayout3.finishLoadMore();
        }
        SmartRefreshLayout smartRefreshLayout4 = this.this$0.refreshLayout;
        if (smartRefreshLayout4 == null) {
            k21.A("refreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout4;
        }
        Boolean hasNext = scriptSelectResponse.getHasNext();
        if (hasNext != null) {
            z = hasNext.booleanValue();
        }
        smartRefreshLayout.setEnableLoadMore(z);
    }
}
