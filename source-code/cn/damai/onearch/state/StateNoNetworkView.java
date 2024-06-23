package cn.damai.onearch.state;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import com.alient.onearch.adapter.state.StateViewManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.page.state.IStateView;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.je2;
import tb.k21;

/* compiled from: Taobao */
public final class StateNoNetworkView extends RelativeLayout implements IStateView {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private View contentView = this;
    @Nullable
    private StateViewManager.IStateViewListener listener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StateNoNetworkView(@NotNull Context context) {
        super(context);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_cms_state_view, (ViewGroup) this, true);
        TextView textView = (TextView) inflate.findViewById(R$id.btn_refresh);
        if (textView != null) {
            textView.setOnClickListener(new je2(this));
        }
        TextView textView2 = (TextView) inflate.findViewById(R$id.tv_report);
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        ImageView imageView = (ImageView) inflate.findViewById(R$id.iv_error_tip);
        if (imageView != null) {
            imageView.setImageResource(R$drawable.common_error_net);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-1$lambda-0  reason: not valid java name */
    public static final void m57lambda1$lambda0(StateNoNetworkView stateNoNetworkView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1483585253")) {
            ipChange.ipc$dispatch("-1483585253", new Object[]{stateNoNetworkView, view});
            return;
        }
        k21.i(stateNoNetworkView, "this$0");
        StateViewManager.IStateViewListener iStateViewListener = stateNoNetworkView.listener;
        if (iStateViewListener != null) {
            iStateViewListener.onRefreshClick();
        }
    }

    @Override // com.youku.arch.v3.page.state.IStateView
    @Nullable
    public View getContentView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1263464708")) {
            return this.contentView;
        }
        return (View) ipChange.ipc$dispatch("1263464708", new Object[]{this});
    }

    @Nullable
    public final StateViewManager.IStateViewListener getListener() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1554884870")) {
            return this.listener;
        }
        return (StateViewManager.IStateViewListener) ipChange.ipc$dispatch("1554884870", new Object[]{this});
    }

    @Override // com.youku.arch.v3.page.state.IStateView
    public void setContentView(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "334503108")) {
            ipChange.ipc$dispatch("334503108", new Object[]{this, view});
            return;
        }
        this.contentView = view;
    }

    public final void setListener(@Nullable StateViewManager.IStateViewListener iStateViewListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "778805904")) {
            ipChange.ipc$dispatch("778805904", new Object[]{this, iStateViewListener});
            return;
        }
        this.listener = iStateViewListener;
    }

    @Override // com.youku.arch.v3.page.state.IStateView
    public void update(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1534663669")) {
            ipChange.ipc$dispatch("1534663669", new Object[]{this, str, str2});
        }
    }
}
