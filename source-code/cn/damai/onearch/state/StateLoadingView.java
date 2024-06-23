package cn.damai.onearch.state;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import cn.damai.commonbusiness.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.page.state.IStateView;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class StateLoadingView extends RelativeLayout implements IStateView {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private View contentView = this;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StateLoadingView(@NotNull Context context) {
        super(context);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        LayoutInflater.from(context).inflate(R$layout.layout_cms_state_view_loading, (ViewGroup) this, true);
    }

    @Override // com.youku.arch.v3.page.state.IStateView
    @Nullable
    public View getContentView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "153804307")) {
            return this.contentView;
        }
        return (View) ipChange.ipc$dispatch("153804307", new Object[]{this});
    }

    @Override // com.youku.arch.v3.page.state.IStateView
    public void setContentView(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "294769045")) {
            ipChange.ipc$dispatch("294769045", new Object[]{this, view});
            return;
        }
        this.contentView = view;
    }

    @Override // com.youku.arch.v3.page.state.IStateView
    public void update(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "913785412")) {
            ipChange.ipc$dispatch("913785412", new Object[]{this, str, str2});
        }
    }
}
