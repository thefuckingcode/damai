package com.alibaba.pictures.bricks.selector;

import android.view.ViewGroup;
import com.alibaba.pictures.bricks.base.BricksBaseFragment;
import com.alibaba.pictures.bricks.selector.bean.ScriptSelectResponse;
import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.fb0;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class ScriptSelectFragment$requestSearch$2 extends Lambda implements Function1<fb0<ScriptSelectResponse>, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ boolean $isNewSearch;
    final /* synthetic */ ScriptSelectFragment this$0;

    /* compiled from: Taobao */
    public static final class a implements BricksBaseFragment.IClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ScriptSelectFragment a;

        a(ScriptSelectFragment scriptSelectFragment) {
            this.a = scriptSelectFragment;
        }

        @Override // com.alibaba.pictures.bricks.base.BricksBaseFragment.IClickListener
        public void handleClick(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1663331079")) {
                ipChange.ipc$dispatch("1663331079", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.a.requestSearch(true);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScriptSelectFragment$requestSearch$2(boolean z, ScriptSelectFragment scriptSelectFragment) {
        super(1);
        this.$isNewSearch = z;
        this.this$0 = scriptSelectFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(fb0<ScriptSelectResponse> fb0) {
        invoke(fb0);
        return ur2.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.view.ViewGroup] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void invoke(@NotNull fb0<ScriptSelectResponse> fb0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1578491709")) {
            ipChange.ipc$dispatch("1578491709", new Object[]{this, fb0});
            return;
        }
        k21.i(fb0, AdvanceSetting.NETWORK_TYPE);
        String str = "请求出错，请稍候重试";
        SmartRefreshLayout smartRefreshLayout = null;
        if (this.$isNewSearch) {
            ViewGroup viewGroup = this.this$0.errorContainer;
            if (viewGroup == null) {
                k21.A("errorContainer");
                viewGroup = null;
            }
            viewGroup.setVisibility(0);
            ScriptSelectFragment scriptSelectFragment = this.this$0;
            String f = fb0.f();
            if (f != null) {
                str = f;
            }
            String valueOf = String.valueOf(fb0.e());
            ?? r3 = this.this$0.errorContainer;
            if (r3 == 0) {
                k21.A("errorContainer");
            } else {
                smartRefreshLayout = r3;
            }
            scriptSelectFragment.showErrorView(str, valueOf, smartRefreshLayout, new a(this.this$0));
            return;
        }
        SmartRefreshLayout smartRefreshLayout2 = this.this$0.refreshLayout;
        if (smartRefreshLayout2 == null) {
            k21.A("refreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout2;
        }
        smartRefreshLayout.finishLoadMore();
        BricksToastUtil.INSTANCE.b(str);
    }
}
