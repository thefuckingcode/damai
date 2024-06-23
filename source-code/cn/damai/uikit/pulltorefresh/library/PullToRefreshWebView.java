package cn.damai.uikit.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import cn.damai.uikit.R$id;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshBase;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PullToRefreshWebView extends PullToRefreshBase<WebView> {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final PullToRefreshBase.OnRefreshListener<WebView> defaultOnRefreshListener = new a();
    private final WebChromeClient defaultWebChromeClient;

    @TargetApi(9)
    /* compiled from: Taobao */
    public final class InternalWebViewSDK9 extends WebView {
        private static transient /* synthetic */ IpChange $ipChange = null;
        static final int OVERSCROLL_FUZZY_THRESHOLD = 2;
        static final float OVERSCROLL_SCALE_FACTOR = 1.5f;

        public InternalWebViewSDK9(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private int getScrollRange() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "22040795")) {
                return (int) Math.max(0.0d, Math.floor((double) (((float) ((WebView) PullToRefreshWebView.this.mRefreshableView).getContentHeight()) * ((WebView) PullToRefreshWebView.this.mRefreshableView).getScale())) - ((double) ((getHeight() - getPaddingBottom()) - getPaddingTop())));
            }
            return ((Integer) ipChange.ipc$dispatch("22040795", new Object[]{this})).intValue();
        }

        /* access modifiers changed from: protected */
        public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1078893330")) {
                return ((Boolean) ipChange.ipc$dispatch("-1078893330", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z)})).booleanValue();
            }
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            b.b(PullToRefreshWebView.this, i, i3, i2, i4, getScrollRange(), 2, 1.5f, z);
            return overScrollBy;
        }
    }

    /* compiled from: Taobao */
    public static final class a implements PullToRefreshBase.OnRefreshListener<WebView> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase.OnRefreshListener
        public void onRefresh(PullToRefreshBase<WebView> pullToRefreshBase) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-371408599")) {
                ipChange.ipc$dispatch("-371408599", new Object[]{this, pullToRefreshBase});
                return;
            }
            pullToRefreshBase.getRefreshableView().reload();
        }
    }

    public PullToRefreshWebView(Context context) {
        super(context);
        AnonymousClass2 r2 = new WebChromeClient() {
            /* class cn.damai.uikit.pulltorefresh.library.PullToRefreshWebView.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onProgressChanged(WebView webView, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-117123561")) {
                    ipChange.ipc$dispatch("-117123561", new Object[]{this, webView, Integer.valueOf(i)});
                } else if (i == 100) {
                    PullToRefreshWebView.this.onRefreshComplete();
                }
            }
        };
        this.defaultWebChromeClient = r2;
        setOnRefreshListener(defaultOnRefreshListener);
        ((WebView) this.mRefreshableView).setWebChromeClient(r2);
    }

    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-305330165")) {
            return PullToRefreshBase.Orientation.VERTICAL;
        }
        return (PullToRefreshBase.Orientation) ipChange.ipc$dispatch("-305330165", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public boolean isReadyForPullEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-554422019")) {
            return ((Boolean) ipChange.ipc$dispatch("-554422019", new Object[]{this})).booleanValue();
        } else if (((float) ((WebView) this.mRefreshableView).getScrollY()) >= ((float) Math.floor((double) (((float) ((WebView) this.mRefreshableView).getContentHeight()) * ((WebView) this.mRefreshableView).getScale()))) - ((float) ((WebView) this.mRefreshableView).getHeight())) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public boolean isReadyForPullStart() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-579379114")) {
            return ((WebView) this.mRefreshableView).getScrollY() == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-579379114", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public void onPtrRestoreInstanceState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1783606130")) {
            ipChange.ipc$dispatch("1783606130", new Object[]{this, bundle});
            return;
        }
        super.onPtrRestoreInstanceState(bundle);
        ((WebView) this.mRefreshableView).restoreState(bundle);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public void onPtrSaveInstanceState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1076998919")) {
            ipChange.ipc$dispatch("-1076998919", new Object[]{this, bundle});
            return;
        }
        super.onPtrSaveInstanceState(bundle);
        ((WebView) this.mRefreshableView).saveState(bundle);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase
    public WebView createRefreshableView(Context context, AttributeSet attributeSet) {
        WebView webView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1242649230")) {
            return (WebView) ipChange.ipc$dispatch("-1242649230", new Object[]{this, context, attributeSet});
        }
        if (Build.VERSION.SDK_INT >= 9) {
            webView = new InternalWebViewSDK9(context, attributeSet);
        } else {
            webView = new WebView(context, attributeSet);
        }
        webView.setId(R$id.webview);
        return webView;
    }

    public PullToRefreshWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AnonymousClass2 r1 = new WebChromeClient() {
            /* class cn.damai.uikit.pulltorefresh.library.PullToRefreshWebView.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onProgressChanged(WebView webView, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-117123561")) {
                    ipChange.ipc$dispatch("-117123561", new Object[]{this, webView, Integer.valueOf(i)});
                } else if (i == 100) {
                    PullToRefreshWebView.this.onRefreshComplete();
                }
            }
        };
        this.defaultWebChromeClient = r1;
        setOnRefreshListener(defaultOnRefreshListener);
        ((WebView) this.mRefreshableView).setWebChromeClient(r1);
    }

    public PullToRefreshWebView(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
        AnonymousClass2 r1 = new WebChromeClient() {
            /* class cn.damai.uikit.pulltorefresh.library.PullToRefreshWebView.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onProgressChanged(WebView webView, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-117123561")) {
                    ipChange.ipc$dispatch("-117123561", new Object[]{this, webView, Integer.valueOf(i)});
                } else if (i == 100) {
                    PullToRefreshWebView.this.onRefreshComplete();
                }
            }
        };
        this.defaultWebChromeClient = r1;
        setOnRefreshListener(defaultOnRefreshListener);
        ((WebView) this.mRefreshableView).setWebChromeClient(r1);
    }

    public PullToRefreshWebView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
        AnonymousClass2 r1 = new WebChromeClient() {
            /* class cn.damai.uikit.pulltorefresh.library.PullToRefreshWebView.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onProgressChanged(WebView webView, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-117123561")) {
                    ipChange.ipc$dispatch("-117123561", new Object[]{this, webView, Integer.valueOf(i)});
                } else if (i == 100) {
                    PullToRefreshWebView.this.onRefreshComplete();
                }
            }
        };
        this.defaultWebChromeClient = r1;
        setOnRefreshListener(defaultOnRefreshListener);
        ((WebView) this.mRefreshableView).setWebChromeClient(r1);
    }
}
